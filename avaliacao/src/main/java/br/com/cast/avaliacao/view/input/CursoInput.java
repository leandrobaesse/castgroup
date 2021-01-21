package br.com.cast.avaliacao.view.input;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@Setter
@Getter
@NoArgsConstructor
public class CursoInput {

    @NotEmpty(message = "O campo descrição é obrigatório.")
    private String descricao;

    @NotNull(message = "O campo Data Início é obrigatório.")
    private LocalDate dataInicio;

    @NotNull(message = "O campo Data Fim é obrigatório.")
    private LocalDate dataFim;

    private int qtdeAlunos;

    @NotNull(message = "O campo Categoria é obrigatório.")
    @Valid
    private CategoriaIdInput categoria;

}
