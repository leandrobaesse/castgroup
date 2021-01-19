package br.com.cast.avaliacao.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "curso")
public class Curso {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Date dataInicio;

    @Column(nullable = false)
    private Date dataFim;

    @Column(nullable = true)
    private int qtdeAlunos;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;


}
