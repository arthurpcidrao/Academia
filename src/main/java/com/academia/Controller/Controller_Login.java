package com.academia.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Controller_Login {

    @GetMapping("/data")
    public String getData() {
        // Code to return all tasks
        return "Hello from spring boot do tuca!";
    }

    @PostMapping("/criar")
    public String postData(@RequestBody String requestData) {
        // Code to create a new task
        return "Received: " + requestData;
    }

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
