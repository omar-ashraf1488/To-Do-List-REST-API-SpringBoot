package com.oa.taskmangementapp.controller;

import com.oa.taskmangementapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oa.taskmangementapp.service.ITodoService;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @GetMapping(value = "/all-todos")
    public List <Todo> listTodos() {

        return todoService.showAllTodos();
    }

    @PostMapping(value = "/add-todo")
    public Todo addTodo(@RequestBody Todo todo) {
        //todoService.saveTodo(todo);
        //return String.format(todo.getDescription());

       if (todoService.saveTodo(todo)) {
            return todo;
        }
       return null;
    }

    @DeleteMapping(value = "/delete-todo")
    public void deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);
    }

    @PutMapping(value = "/update-todo/{id}")
    public Todo updateTodo(@PathVariable(value = "id") int id,
                           @RequestBody String description){
        todoService.updateTodo(id, description);
        return null;
        }
}
