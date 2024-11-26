package com.academia.demoacademia.Controller;

import com.academia.demoacademia.Model.Usuario;
import com.academia.demoacademia.Repository.Usuario_DAO;
import com.academia.demoacademia.Services.Servicos_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/autenticar")
public class Controller_Login {

    @Autowired
    private Usuario_DAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private Servicos_Usuario servicos;

    @PostMapping("/login")
    public ResponseEntity<String> autenticarUsuario(@RequestBody Usuario credenciais){
        String resultado = servicos.autenticar_usuario(credenciais.getLogin(), credenciais.getSenha());
        switch (resultado) {
            case "Senha correta":
                return ResponseEntity.ok("Login realizado com sucesso!");
            case "Senha incorreta":
                return ResponseEntity.status(401).body("Usuário não encontrado ou Senha incorreta");
            default:
                return ResponseEntity.status(404).body("Usuário não encontrado ou Senha incorreta");
        }
    }
}
