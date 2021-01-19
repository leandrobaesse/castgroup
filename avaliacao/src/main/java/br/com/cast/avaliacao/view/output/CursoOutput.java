package br.com.cast.avaliacao.view.output;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CursoOutput {

    private Long id;

    private String descricao;

    private Date dataInicio;

    private Date dataFim;

    private CategoriaOutput categoria;

}
