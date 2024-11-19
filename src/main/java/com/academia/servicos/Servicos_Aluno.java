package com.academia.servicos;

import com.academia.banco_dados.MySQL_DB;
import com.academia.pessoas.Aluno;

import java.sql.SQLException;

public class Servicos_Aluno {

    private MySQL_DB database;

    public void cadastrar(Aluno aluno) throws SQLException {
        database.cadastrar_aluno(aluno);
    }

    public String define_login() throws SQLException {
        int num;
        if (database.cria_login() == null){
            num = 1;
        }
        else{
            String[] partes = database.cria_login().split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
            num = Integer.parseInt(partes[1]) + 1;
        }
        return "aluno" + String.format("%05d",num);
    }

    public Aluno procurar(String login) throws SQLException {
        return database.get_aluno(login);
    }

    public boolean authenticate(String login, String senha) throws SQLException {
        Aluno aluno = procurar(login);
        if (aluno == null) {
            return false;
        }
        return true; //new BCryptPasswordEncoder().matches(senha, aluno.getSenha());
    }

    // BCryptPasswordEncoder() -> faz parte de biblioteca spring security no java (autenticação de senha)
}
