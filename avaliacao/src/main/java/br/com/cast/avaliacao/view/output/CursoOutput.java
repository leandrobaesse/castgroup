package br.com.cast.avaliacao.view.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CursoOutput {

    private Long id;

    private String descricao;

    private int qtdeAlunos;

    @JsonFormat(pattern = "yyyy-MM-dd" )
    private LocalDate dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

    private CategoriaOutput categoria;

}
