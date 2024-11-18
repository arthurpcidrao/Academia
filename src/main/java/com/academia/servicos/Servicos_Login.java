package com.academia.servicos;

import com.academia.pessoas.Aluno;
import com.academia.banco_dados.MySQL_DB;

public class Servicos_Login {

    private MySQL_DB database;

    public Aluno procura(String email){
        return database.get_aluno(email);
    }

    public boolean authenticate(String email, String senha) {
        Aluno aluno = procura(email);
        if (aluno == null) {
            return false;
        }
        return true; //new BCryptPasswordEncoder().matches(senha, aluno.getSenha());
    }

}

