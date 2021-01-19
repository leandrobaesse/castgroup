package br.com.cast.avaliacao.view.controller;

import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CursoRepository;
import br.com.cast.avaliacao.service.CursoService;
import br.com.cast.avaliacao.util.MapperUtil;
import br.com.cast.avaliacao.view.input.CursoInput;
import br.com.cast.avaliacao.view.output.CursoOutput;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/castgroup/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CursoController {


    private final CursoRepository cursoRepository;

    private final CursoService cursoService;

    private final MapperUtil mapperUtil;

    private final ModelMapper modelMapper;

    public CursoController(CursoRepository cursoRepository, CursoService cursoService, MapperUtil mapperUtil, ModelMapper modelMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoService = cursoService;
        this.mapperUtil = mapperUtil;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public List<CursoOutput> listarTodosCursos() {

        List<Curso> cursos = cursoRepository.findAll();
        return mapperUtil.mapList(cursos, CursoOutput.class);
    }


    @GetMapping("/{cursoId}")
    public CursoOutput buscarPorId(@PathVariable Long cursoId) {

        Curso curso = cursoService.buscar(cursoId);

        return mapperUtil.mapTo(curso, CursoOutput.class);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoOutput salvar(@RequestBody @Valid CursoInput cursoInput) {

        Curso curso = mapperUtil.mapTo(cursoInput, Curso.class);

        curso = cursoService.salvar(curso);
        return mapperUtil.mapTo(curso, CursoOutput.class);

    }

    @PutMapping("/{cursoId}")
    public CursoOutput atualizar(@PathVariable Long cursoId,
                                 @RequestBody @Valid CursoInput cursoInput) {

        Curso cursoAtual = cursoService.buscar(cursoId);

        modelMapper.map(cursoInput, cursoAtual);

        return mapperUtil.mapTo(cursoService.salvar(cursoAtual), CursoOutput.class);

    }


    @DeleteMapping("/{cursoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cursoId) {
        cursoService.excluir(cursoId);
    }


}
