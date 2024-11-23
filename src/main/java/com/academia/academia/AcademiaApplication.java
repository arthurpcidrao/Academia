package com.academia.academia;

import com.academia.Model.Aluno;
import com.academia.Service.Servicos_Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(AcademiaApplication.class, args);

        Aluno aluno;
        Servicos_Aluno servico =  new Servicos_Aluno();
        aluno = servico.procurar("aluno00002");
        System.out.println(aluno);
        servico.alterar("aluno00002", "Fernando", "85992823609",
                "fernando@exemplo.com", true, "masculino", "3");
        //servico.cadastrar(aluno);


    }

}
