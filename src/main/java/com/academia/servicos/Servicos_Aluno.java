package com.academia.servicos;

import com.academia.banco_dados.MySQL_DB;
import com.academia.pessoas.Aluno;

public class Servicos_Aluno {

    private MySQL_DB database;

    public Aluno procura(String email){
        return database.get_aluno(email);
    }


    // BCryptPasswordEncoder() -> faz parte de biblioteca spring security no java (autenticação de senha)
}
