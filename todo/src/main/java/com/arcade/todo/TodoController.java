package com.arcade.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<TodoModel> getTodos() {
        return repository.findAll();
    }

    @PostMapping
    TodoModel createTodo(@RequestBody TodoModel newTodo) {
        return repository.save(newTodo);
    }

    @GetMapping("/{id}")
    Optional<TodoModel> getOneTodo(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Optional<Object> updateTodo(@RequestBody TodoModel newTodo, @PathVariable Long id) {
        return repository.findById(id).map((todo) -> {
            todo.setContent(newTodo.getContent());
            return repository.save(todo);
        });
    }

    @DeleteMapping("/{id}")
    void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
