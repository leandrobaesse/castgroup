package br.com.cast.avaliacao.view.input;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class CursoInput {

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataInicio;

    @NotNull
    private LocalDate dataFim;

    private int qtdeAlunos;

    @NotNull
    @Valid
    private CategoriaIdInput categoria;

}
