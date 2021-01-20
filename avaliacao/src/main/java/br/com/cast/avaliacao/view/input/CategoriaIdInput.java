package br.com.cast.avaliacao.view.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class CategoriaIdInput {

    @NotNull
    private Integer id;
}
