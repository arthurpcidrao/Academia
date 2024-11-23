package com.academia.Repository;

import com.academia.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_Aluno extends JpaRepository<Aluno, String> {
    Aluno findByCpf(String cpf);
}
