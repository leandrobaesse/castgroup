package br.com.cast.avaliacao.view.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CategoriaIdInput {

    @NotNull
    private Integer id;
}
