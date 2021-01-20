package br.com.cast.avaliacao.view.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class CursoOutput {

    private Long id;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    private CategoriaOutput categoria;

}
