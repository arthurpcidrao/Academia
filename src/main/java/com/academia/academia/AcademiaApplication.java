package com.academia.academia;

import com.academia.pessoas.Aluno;
import com.academia.servicos.Servicos_Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(AcademiaApplication.class, args);

        //Aluno aluno = new Aluno("Teste", "05676868334", "85999024837","teste@exemplo.br","03/12/2004","teste456","feminino","2");
        //Servicos_Aluno servico =  new Servicos_Aluno();
        //servico.cadastrar(aluno);

        System.out.println("INICIOU!!!!");

    }

}
