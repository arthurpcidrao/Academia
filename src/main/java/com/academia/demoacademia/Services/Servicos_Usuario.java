package com.academia.demoacademia.Services;

import com.academia.demoacademia.Model.Usuario;
import com.academia.demoacademia.Repository.Usuario_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Servicos_Usuario {

    @Autowired
    private Usuario_DAO repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String autenticar_usuario(String login, String senha_bruta) {
        Optional<Usuario> usuario = repositorio.findById(login);
        boolean status;
        if(usuario.isPresent()) {
            status = this.passwordEncoder.matches(senha_bruta, usuario.get().getSenha());
            if (status) return "Senha correta";

            return "Senha incorreta";
        }
        return "Usuário não existe";
    }
}
