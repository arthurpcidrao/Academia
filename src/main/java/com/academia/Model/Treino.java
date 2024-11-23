package com.academia.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "treino")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTreino;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_exercicio", nullable = false)
    private Exercicio exercicio;

    @Column(name = "serie_exercicio", nullable = false)
    private int serie;

    @Column(name = "repeticoes_exercicio", nullable = false)
    private int repeticoes;

    @Column(name = "tipo_treino", length = 1, nullable = false)
    private String tipo;

    // Construtores, getters e setters
    public Treino() {}

    // Outros getters e setters omitidos para brevidade
}
