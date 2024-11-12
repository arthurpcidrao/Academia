package com.academia.pessoas;

import java.util.Date;

public class Funcionario {
    private String nome;
    private String cargo;
    private String email;
    private String senha;
    private String login;
    private String telefone;
    private String cpf;
    private String endereco;
    private Date data_contratacao;
    private boolean status;
    private double salario;


    public Funcionario(String nome, String cargo, String email,
                       String cpf, String data_contratacao, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.cpf = cpf;
        this.endereco = data_contratacao;
        this.salario = salario;
    }

}
