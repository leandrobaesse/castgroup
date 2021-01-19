package br.com.cast.avaliacao.service;

import br.com.cast.avaliacao.exception.CursoNaoEncontradoException;
import br.com.cast.avaliacao.exception.EntidadeEmUsoException;
import br.com.cast.avaliacao.model.Categoria;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CursoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Long categoriaId = curso.getCategoria().getId();

        Categoria categoria = categoriaService.buscarPorId(categoriaId);

        curso.setCategoria(categoria);

        return cursoRepository.save(curso);
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


}
