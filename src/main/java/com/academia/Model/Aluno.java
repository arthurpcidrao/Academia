package com.academia.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @Column(name = "id_aluno", length = 10, nullable = false)
    private String login;

    @Column(name = "nome_aluno", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf_aluno", length = 20, nullable = false)
    private String cpf;

    @Column(name = "telefone_aluno", length = 20, nullable = false)
    private String telefone;

    @Column(name = "email_aluno", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "status_aluno", nullable = false)
    private boolean status;

    @Column(name = "data_nascimento_aluno", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_inscricao", nullable = false)
    private LocalDate dataMatricula;

    @Column(name = "senha_aluno", length = 100, nullable = false)
    private String senha;

    @Column(name = "genero_aluno", length = 10, nullable = false)
    private String genero;

    @Column(name = "id_plano", nullable = false)
    private int plano;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treino> treinos = new ArrayList<>();

    // Construtores, getters e setters
    public Aluno() {}

    public Aluno(String login, String nome, String cpf, String telefone, String email, boolean status,
                 LocalDate dataNascimento, LocalDate dataMatricula, String senha, String genero, int plano) {
        this.login = login;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.dataNascimento = dataNascimento;
        this.dataMatricula = dataMatricula;
        this.senha = senha;
        this.genero = genero;
        this.plano = plano;
    }

    // Getters e Setters
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
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

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
}
