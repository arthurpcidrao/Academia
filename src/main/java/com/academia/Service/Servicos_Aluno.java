package com.academia.Service;

import com.academia.Model.Aluno;
import com.academia.Repository.Repositorio_Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicos_Aluno {

    @Autowired
    private Repositorio_Aluno alunoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public void cadastrar(Aluno aluno) {
        aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
        alunoRepository.save(aluno);
    }

    public Aluno procurar(String login) {
        return alunoRepository.findById(login).orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
    }

    public void alterar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void deletar(String login) {
        alunoRepository.deleteById(login);
    }
}
