package com.academia.pessoas;

import com.academia.exercicios.Treino;
import com.academia.servicos.Servicos_Aluno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {

    private String nome;
    private String login;
    private String cpf;
    private String telefone;
    private String email;
    private boolean status;
    private Date data_nascimento;
    private Date data_matricula;
    private String senha;
    private String genero;
    private String plano;
    private List<Treino> treinos;

    private Servicos_Aluno servicos;

    public Aluno(String login, String nome, String cpf, String telefone, String email, boolean status, Date data_nascimento,
                 Date data_matricula, String senha, String genero, String plano){

        this.login = login;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.data_nascimento = data_nascimento;
        this.data_matricula = data_matricula;
        this.senha = senha;
        this.genero = genero;
        this.plano = plano;
        treinos = new ArrayList<Treino>();
    }

    public Aluno(String nome, String cpf, String telefone, String email, boolean status, Date data_nascimento,
                 Date data_matricula, String senha, String genero, String plano) throws SQLException {

        this.login = criar_login();
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.data_nascimento = data_nascimento;
        this.data_matricula = data_matricula;
        this.senha = senha;
        this.genero = genero;
        this.plano = plano;
        treinos = new ArrayList<Treino>();
    }

    public String criar_login() throws SQLException {
        return this.servicos.define_login();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public java.sql.Date getData_nascimento() {
        return (java.sql.Date) data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public java.sql.Date getData_matricula() {
        return (java.sql.Date) data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
}
