package com.academia.demoacademia.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idExercicio;
    private String nomeExercicio;
    private String tipoExercicio;
    private String maquinaExercicio;
    private String descricaoExercicio;


}
