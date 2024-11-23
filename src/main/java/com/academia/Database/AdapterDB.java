package com.academia.Database;

import com.academia.Model.Exercicio;
import com.academia.Model.Treino;
import com.academia.Model.Aluno;

import java.sql.Connection;
import java.sql.SQLException;

public interface AdapterDB {

    default Connection conectar() throws SQLException {
        return null;
    }

    public String get_treino(String id);
    public String get_exercicio(String id);
    public Aluno get_aluno(String login) throws SQLException;
    public Aluno get_aluno_cpf(String cpf) throws SQLException;

    public boolean teste_aluno() throws SQLException;
    public String cria_login() throws SQLException;

    public void cadastrar_aluno(Aluno aluno);
    public void cadastrar_exercicio(Exercicio exercicio);
    public void cadastrar_treino(Treino treino);

    public void editar_aluno(Aluno aluno);

    public void excluir_aluno(String login);
    public void excluir_exercicio(String id);
    public void excluir_treino(String id);


}
