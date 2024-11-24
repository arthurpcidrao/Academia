package com.academia.demoacademia.Controller;

import com.academia.demoacademia.Model.Usuario;
import com.academia.demoacademia.Repository.Usuario_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class Controller_Usuario {

    @Autowired
    private Usuario_DAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/todos")
    public List<Usuario> listaUsuarios(){
        return (List<Usuario>) dao.findAll();
    }

    @GetMapping("/{login}")
    public Optional<Usuario> buscaUsuario(@PathVariable String login){  //Optional -> se não encontrar, retorna NULL
        return dao.findById(login);
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        int login = dao.maiorId();
        String novoLogin = String.format("aluno%05d", login + 1);

        usuario.setLogin(novoLogin);
        usuario.setDataMatricula(LocalDate.now());

        usuario.setSenha(proteger_senha(usuario.getSenha()));

        return dao.save(usuario);
    }

    public String proteger_senha(String senha_bruta){
        return this.passwordEncoder.encode(senha_bruta);
    }

    /*
    public boolean autenticar_usuario(String login, String senha_bruta) {
        Usuario usuario = procurar(login);
        return this.passwordEncoder.matches(senha_bruta, usuario.getSenha());
    }
    */

    @PutMapping("/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return dao.save(usuario);
    }

    @DeleteMapping("/deletar/{login}")
    public Optional<Usuario> deletarUsuario(@PathVariable String login){
        Optional<Usuario> usuario = dao.findById(login);
        dao.deleteById(login);
        return usuario;
    }


}
