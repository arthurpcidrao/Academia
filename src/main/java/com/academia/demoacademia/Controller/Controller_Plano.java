package com.academia.demoacademia.Controller;

import com.academia.demoacademia.Model.Plano;
import com.academia.demoacademia.Repository.Plano_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/plano")
public class Controller_Plano {

    @Autowired
    private Plano_DAO dao;

    @GetMapping("/todos")
    public List<Plano> listaPlanos(){
        return (List<Plano>) dao.findAll();
    }

    @PostMapping("/salvar")
    public Plano salvarPlano(@RequestBody Plano plano) {
        return dao.save(plano);
    }

    @GetMapping("/{id}")
    public Optional<Plano> buscaPlano(@PathVariable int id){
        return dao.findById(id);
    }


}
