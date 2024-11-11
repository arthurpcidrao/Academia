package com.academia.academia;

import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class Controller {

    @GetMapping
    public List<Task> getTasks() {
        // Code to return all tasks
        return List.of();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // Code to create a new task
        return task;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        // Code to update the task
        return task;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        // Code to delete the task
    }
}

