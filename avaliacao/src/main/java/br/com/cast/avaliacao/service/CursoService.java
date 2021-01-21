package br.com.cast.avaliacao.service;

import br.com.cast.avaliacao.exception.CursoNaoEncontradoException;
import br.com.cast.avaliacao.exception.EntidadeEmUsoException;
import br.com.cast.avaliacao.exception.NegocioException;
import br.com.cast.avaliacao.model.Categoria;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CursoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CursoService {

    final
    CursoRepository cursoRepository;

    private final CategoriaService categoriaService;

    private static final String MSG_CURSO_EM_USO
            = "Curso de código %d não pode ser removido, pois está em uso";

    public CursoService(CursoRepository cursoRepository, CategoriaService categoriaService) {
        this.cursoRepository = cursoRepository;
        this.categoriaService = categoriaService;
    }

    @Transactional
    public Curso salvar(Curso curso) {

        try{

            this.podeCadastrarCurso(curso);

            Long categoriaId = curso.getCategoria().getId();

            Categoria categoria = categoriaService.buscarPorId(categoriaId);

            curso.setCategoria(categoria);

            return cursoRepository.save(curso);

        }catch (NegocioException ne){
            throw new NegocioException(ne.getMessage());
        }

    }

    @Transactional
    public void excluir(Long cursoId) {
        try {
            cursoRepository.deleteById(cursoId);
            cursoRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new CursoNaoEncontradoException(cursoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_CURSO_EM_USO, cursoId));
        }
    }

    public Curso buscar(Long cursoId) {
        return cursoRepository.findById(cursoId)
                .orElseThrow(() -> new CursoNaoEncontradoException(cursoId));
    }

    private void podeCadastrarCurso(Curso curso) {


        if (curso.getDataInicio().isBefore(LocalDate.now())) {
            throw new NegocioException("Não é permitido o cadastro de curso com início anterior à data atual.");
        }

        if (curso.getDataFim().isBefore(curso.getDataInicio())) {
            throw new NegocioException("A Data Fim é anterior à Data Início.");
        }

        List<Curso> cursos = cursoRepository.getCursosCadastradosEntreData(curso.getDataInicio());

        if (curso.getId() != null && !cursos.isEmpty()) {
            if (cursos.stream().anyMatch(p -> !p.getId().equals(curso.getId())
                    && !isDataPermitida(curso.getDataInicio(), curso.getDataFim(), p.getDataInicio(), p.getDataFim()))) {
                throw new NegocioException("Existe(m) curso(s) planejados(s) dentro do período informado. !");
            }
        } else if (cursos.stream().anyMatch(p -> !isDataPermitida(curso.getDataInicio(), curso.getDataFim(), p.getDataInicio(), p.getDataFim()))) {
            throw new NegocioException("Existe(m) curso(s) planejados(s) dentro do período informado.");
        }

    }

    private boolean isDataPermitida(LocalDate inicioSalvar, LocalDate fimSalvar,
                                 LocalDate inicioCursoSalvo , LocalDate fimCursoSalvo) {


        if (inicioSalvar.isEqual(inicioCursoSalvo) || fimSalvar.isEqual(fimCursoSalvo)
                || inicioSalvar.isEqual(fimCursoSalvo) || fimSalvar.isEqual(inicioCursoSalvo)) {
            return false;
        }

        if (inicioSalvar.isBefore(inicioCursoSalvo) && fimSalvar.isAfter(inicioCursoSalvo)) {
            return false;
        }

        if (inicioSalvar.isAfter(inicioCursoSalvo) && fimSalvar.isBefore(fimCursoSalvo)) {
            return false;
        }

        if (inicioSalvar.isBefore(fimCursoSalvo) && fimSalvar.isAfter(fimCursoSalvo)) {
            return false;
        }

        return true;
    }
}
