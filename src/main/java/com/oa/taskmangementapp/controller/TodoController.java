package com.oa.taskmangementapp.controller;

import com.oa.taskmangementapp.model.Todo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oa.taskmangementapp.service.ITodoService;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/todos")
@AllArgsConstructor
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @GetMapping(value = "/all-todos")
    public List <Todo> listTodos() { return todoService.getAllTodos(); }

    @PostMapping(value = "/add-todo")
    public void addTodo(@RequestParam String description) {
        todoService.addTodo(description);
    }

    @DeleteMapping(value = "/delete-todo")
    public void deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);
    }

    @PutMapping(value = "/update-todo")
    public Todo updateTodo(@RequestParam(value = "id") int id,
                          @RequestBody String description){
        todoService.updateTodo(id, description);
        return null;
        }
}
