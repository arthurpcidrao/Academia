package com.academia.demoacademia.Controller;

import com.academia.demoacademia.Model.Usuario;
import com.academia.demoacademia.Repository.Usuario_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class Controller_Usuario {

    @Autowired
    private Usuario_DAO dao;

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
        return dao.save(usuario);
    }

    @PutMapping("/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return dao.save(usuario);
    }


}
