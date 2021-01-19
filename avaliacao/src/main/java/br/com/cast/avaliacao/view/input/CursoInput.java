package br.com.cast.avaliacao.view.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class CursoInput {

    @NotNull
    private String descricao;

    @NotNull
    private Date dataInicio;

    @NotNull
    private Date dataFim;

    private int qtdeAlunos;

    @NotNull
    @Valid
    private CategoriaIdInput categoria;

}
