package com.academia.pessoas;

import com.academia.banco_dados.MySQL_DB;
import com.academia.exercicios.Treino;

import java.util.Date;
import java.util.List;

public class Aluno {

    private String nome;
    private Date data_nascimento;
    private String cpf;
    private String sexo;
    private String telefone;
    private String endereco;
    private Date data_matricula;
    private boolean status;
    private String email;
    private String senha;
    private String plano;
    private List<Treino> treinos;

    private MySQL_DB database;

    public Aluno(String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public void adicionar_aluno(){
        database.cadastrar_aluno(this.nome, this.cpf, this.email);
    }



}
