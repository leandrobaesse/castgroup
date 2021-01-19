package br.com.cast.avaliacao.api.controller;

import br.com.cast.avaliacao.repository.CursoRepository;
import br.com.cast.avaliacao.service.CursoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CursoController {


    private final CursoRepository cursoRepository;

    private final CursoService cursoService;

    public CursoController(CursoRepository cursoRepository, CursoService cursoService) {
        this.cursoRepository = cursoRepository;
        this.cursoService = cursoService;
    }


}
