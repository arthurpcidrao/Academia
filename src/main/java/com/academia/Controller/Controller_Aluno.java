package com.academia.Controller;

import com.academia.Model.Aluno;
import com.academia.Service.Servicos_Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class Controller_Aluno {

    @Autowired
    private Servicos_Aluno servico;

    @GetMapping
    public List<Aluno> listar() {
        return servico.listarTodos();
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Aluno aluno) {
        servico.cadastrar(aluno);
        return ResponseEntity.ok("Aluno cadastrado com sucesso!");
    }

    @GetMapping("/{login}")
    public ResponseEntity<Aluno> buscar(@PathVariable String login) {
        Aluno aluno = servico.procurar(login);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{login}")
    public ResponseEntity<Aluno> alterar(@PathVariable String login, @RequestBody Aluno alunoAtualizado) {
        alunoAtualizado.setLogin(login);
        servico.alterar(alunoAtualizado);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<Void> deletar(@PathVariable String login) {
        servico.deletar(login);
        return ResponseEntity.noContent().build();
    }
}
