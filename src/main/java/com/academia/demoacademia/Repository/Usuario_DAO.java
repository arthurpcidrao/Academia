package com.academia.demoacademia.Repository;

import com.academia.demoacademia.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Usuario_DAO extends CrudRepository<Usuario, String> {

    @Query("SELECT COALESCE(MAX(SUBSTRING(u.login, 6)), 0) FROM Usuario u")
    int maiorId();
}
