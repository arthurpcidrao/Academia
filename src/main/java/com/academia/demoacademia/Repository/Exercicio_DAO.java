package com.academia.demoacademia.Repository;

import com.academia.demoacademia.Model.Exercicio;
import com.academia.demoacademia.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface Exercicio_DAO extends CrudRepository<Exercicio, String> {
}
