package br.com.cast.avaliacao.view.controller;

import br.com.cast.avaliacao.model.Categoria;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CategoriaRepository;
import br.com.cast.avaliacao.service.CategoriaService;
import br.com.cast.avaliacao.util.MapperUtil;
import br.com.cast.avaliacao.view.output.CategoriaOutput;
import br.com.cast.avaliacao.view.output.CursoOutput;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/castgroup/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {


    private final CategoriaRepository categoriaRepository;

    private final MapperUtil mapperUtil;


    public CategoriaController(CategoriaRepository categoriaRepository, MapperUtil mapperUtil) {
        this.categoriaRepository = categoriaRepository;
        this.mapperUtil = mapperUtil;

    }


    @GetMapping
    public List<CategoriaOutput> listarTodasCategorias() {

        List<Categoria> categorias = categoriaRepository.findAll();
        return mapperUtil.mapList(categorias, CategoriaOutput.class);
    }



}
