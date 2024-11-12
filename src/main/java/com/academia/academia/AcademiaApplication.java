package com.academia.academia;

import com.academia.exercicios.Exercicio;
import com.academia.pessoas.Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(AcademiaApplication.class, args);

        //Aluno aluno = new Aluno("Carlos-teste", "123.456.789-12", "carlos@teste.com");
        //aluno.adicionar_aluno();

        Exercicio exercicio = new Exercicio("Agachamento","Força",
                "Barra Livre",4,10,30);

        System.out.println("OLÁ, TUDO BEM?");

        exercicio.adicionar_exercicio();
        //exercicio.excluir_exercicio("exe002");
    }

}
