package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.entity.TodoEntity;
import ru.niatomi.service.TodoService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity,
                                     @RequestParam Long userId) {
        try {

            return ResponseEntity.ok(service.createTodo(todoEntity, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.updateTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }
}
