package com.academia.servicos;

import com.academia.banco_dados.MySQL_DB;
import com.academia.pessoas.Aluno;

public class Servicos_Aluno {

    private MySQL_DB database;

    public String salvar(Aluno aluno) {
        database.cadastrar_aluno(aluno);
        return "Aluno Cadastrado com sucesso!";
    }

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

    // BCryptPasswordEncoder() -> faz parte de biblioteca spring security no java (autenticação de senha)
}
