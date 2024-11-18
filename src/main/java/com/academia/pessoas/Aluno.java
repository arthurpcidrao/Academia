package com.academia.pessoas;

import com.academia.banco_dados.MySQL_DB;
import com.academia.exercicios.Treino;

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
    private String endereco;
    private String genero;
    private String plano;
    private List<Treino> treinos;

    private MySQL_DB database;

    public Aluno(String nome, String cpf, String telefone, String email, boolean status, Date data_nascimento,
                 Date data_matricula, String senha, String endereco, String genero, String plano){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.data_nascimento = data_nascimento;
        this.data_matricula = data_matricula;
        this.senha = senha;
        this.endereco = endereco;
        this.genero = genero;
        this.plano = plano;
        treinos = new ArrayList<Treino>();

        this.login = define_login();
    }

    public String define_login(){

        int num = 1;
        return "alu" + String.format("%07d",num);
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_matricula() {
        return data_matricula;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
