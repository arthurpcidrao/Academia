package com.academia.banco_dados;

import com.academia.pessoas.Aluno;

import java.sql.Connection;
import java.sql.SQLException;

public interface AdapterDB {

    private Connection conectar() throws SQLException {
        return null;
    }

    public String get_treino();
    public String get_exercicio();
    public Aluno get_aluno(String email);

    public void cadastrar_aluno(Aluno aluno);
    public void cadastrar_exercicio(String id, String nome, String categoria, String maquina, String descricao);
    public void cadastrar_treino();

    public void editar_aluno();

    public void excluir_aluno();
    public void excluir_exercicio(String id);
    public void excluir_treino();


}
