package com.academia.servicos;

import com.academia.banco_dados.MySQL_DB;
import com.academia.pessoas.Aluno;

public class Servicos_Cadastro {

    private MySQL_DB database;

    public String salvar(Aluno aluno) {
        database.cadastrar_aluno(aluno);
        return "Aluno Cadastrado com sucesso!";
    }
}
