package com.academia.demoacademia.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aluno")
public class Usuario {

    @Column(name = "nome_aluno", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf_aluno", length = 20, nullable = false)
    private String cpf;

    @Column(name = "telefone_aluno", length = 20, nullable = false)
    private String telefone;

    @Column(name = "Email_aluno", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "data_nascimento_aluno", nullable = false)
    private String dataNascimento;

    @Column(name = "senha_aluno", length = 100, nullable = false)
    private String senha;

    @Column(name = "genero_aluno", length = 10, nullable = false)
    private String genero;

    @Column(name = "plano", length = 1, nullable = false)
    private Integer plano;

    @Id
    @Column(name = "id_aluno", length = 10, nullable = false)
    private String login;

    @Column(name = "status_aluno", nullable = false)
    private boolean status;

    @Column(name = "data_inscricao", nullable = false)
    private LocalDate dataMatricula;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public java.sql.Date getDataNascimento() {
        return java.sql.Date.valueOf(dataNascimento);
    }

    public void setDataNascimento(String data_nascimento) {
        this.dataNascimento = data_nascimento;
    }

    public java.sql.Date getDataMatricula() {
        return java.sql.Date.valueOf(dataMatricula);
    }

    public void setDataMatricula(LocalDate data_matricula) {
        this.dataMatricula = data_matricula;
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

    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }

}

