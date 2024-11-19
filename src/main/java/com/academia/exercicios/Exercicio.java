package com.academia.exercicios;
import com.academia.banco_dados.MySQL_DB;

import java.sql.SQLException;

public class Exercicio {
    private String id;
    private String nome;
    private String categoria;
    private String maquina;
    private String descricao;

    private MySQL_DB database = new MySQL_DB();

    public Exercicio(String nome, String categoria,
                     String maquina) throws SQLException {
        this.nome = nome;
        //this.descricao = descricao;
        this.categoria = categoria;
        this.maquina = maquina;


    }

    /*
    public void adicionar_exercicio(){
        String id_exercicio = "exe009";

        database.cadastrar_exercicio(id_exercicio,this.nome, this.categoria, this.maquina,
                this.serie, this.repeticoes, this.tempo);
    }
    */

    /*
    public void excluir_exercicio(String id){
        database.excluir_exercicio(id);
    }
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
