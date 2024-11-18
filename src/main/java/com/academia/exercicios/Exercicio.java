package com.academia.exercicios;
import com.academia.banco_dados.MySQL_DB;

import java.sql.SQLException;

public class Exercicio {
    private String nome;
    private String descricao;
    private String categoria;
    private String maquina;
    private int repeticoes;
    
    private MySQL_DB database = new MySQL_DB();

    public Exercicio(String nome, String categoria,
                     String maquina, int repeticoes,
                     int tempo, int serie) throws SQLException {
        this.nome = nome;
        //this.descricao = descricao;
        this.categoria = categoria;
        this.maquina = maquina;
        this.repeticoes = repeticoes;


    }

    public void adicionar_exercicio(){
        String id_exercicio = "exe009";

        database.cadastrar_exercicio(id_exercicio,this.nome, this.categoria, this.maquina,
                this.serie, this.repeticoes, this.tempo);
    }

    public void excluir_exercicio(String id){
        database.excluir_exercicio(id);
    }


}
