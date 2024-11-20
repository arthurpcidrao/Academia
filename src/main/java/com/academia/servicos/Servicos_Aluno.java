package com.academia.servicos;

import com.academia.banco_dados.MySQL_DB;
import com.academia.pessoas.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Component
public class Servicos_Aluno {

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private final MySQL_DB database = new MySQL_DB();

    public Servicos_Aluno() throws SQLException {
    }

    public void cadastrar(Aluno aluno) throws SQLException {
        aluno.setSenha(proteger_senha(aluno.getSenha())); // criptografando a senha
        database.cadastrar_aluno(aluno);
    }

    public String proteger_senha(String senha_bruta){
        return this.passwordEncoder.encode(senha_bruta);
    }

    public boolean autenticar_usuario(String login, String senha_bruta) throws SQLException {
        Aluno aluno = procurar(login);
        return this.passwordEncoder.matches(senha_bruta, aluno.getSenha());
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

}
