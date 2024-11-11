package com.academia.banco_dados;

import java.sql.Connection;
import java.sql.SQLException;

public interface AdapterDB {

    private Connection conectar() throws SQLException {
        return null;
    }

    public int numero_funcionarios();

    public String get_treino();
    public String get_exercicio();
    public String get_funcionario();
    public String get_aluno();
    public String get_cadastro();

    public void cadastrar_funcionario();
    public void cadastrar_aluno(String nome, String cpf, String email);
    public void cadastrar_exercicio(String id, String nome, String categoria, String maquina, int serie,
                                    int repeticoes, int tempo);
    public void cadastrar_treino();

    public void editar_status_funcionario();
    public void editar_status_aluno();
    public void editar_status_atendente();

    public void excluir_aluno();
    public void excluir_exercicio(String id);
    public void excluir_funcionario();
    public void excluir_treino();


}
