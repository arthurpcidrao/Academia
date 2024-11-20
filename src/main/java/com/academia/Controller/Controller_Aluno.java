package com.academia.Controller;

import com.academia.servicos.Servicos_Aluno;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/aluno")
public class Controller_Aluno {

    private final Servicos_Aluno servicos_aluno = new Servicos_Aluno();

    public Controller_Aluno() throws SQLException {
    }

    @GetMapping("/data")
    public String getData() {
        // Code to return all tasks
        return "Hello from spring boot do tuca!";
    }

    @PostMapping("/data")
    public String postData(@RequestBody String requestData) {
        // Code to create a new task
        return "Received: " + requestData;
    }

    /*
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Validar os dados da requisição
        // ...

        boolean isAuthenticated = alunoService.authenticate(loginRequest.getEmail(), loginRequest.getSenha());
        if (isAuthenticated) {
            // Gerar um token JWT
            String jwt = JwtUtils.generateJwtToken(loginRequest.getEmail());
            return ResponseEntity.ok(new JwtResponse(jwt));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    */

    /*
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        // Code to update the task
        return task;
    }
    /*

    /*
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        // Code to delete the task
    }
    */
}

