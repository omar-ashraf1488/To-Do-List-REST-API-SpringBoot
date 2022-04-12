package com.oa.taskmangementapp.controller;

import com.oa.taskmangementapp.entity.Todo;
import com.oa.taskmangementapp.entity.AppUser;
import com.oa.taskmangementapp.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oa.taskmangementapp.service.ITodoService;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1/todos")
@AllArgsConstructor
public class TodoController {

    @Autowired
    private ITodoService todoService;
    @Autowired
    private IUserService userService;


    @PostMapping(value = "/add-todo")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
        String userId = todo.getUserId();
        Optional<AppUser> user = userService.findById(userId);

        if(user != null) {
            todo.setUserId(userId);
            todoService.addTodo(todo);
            return new ResponseEntity<>("Todo created", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all-todos/{userId}")
    public ResponseEntity <?> listTodos(@PathVariable("userId") String userId) {

     try {
            List<Todo> todos = todoService.getTodosForUser(userId);
            return new ResponseEntity<>(todos, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("No todos found for user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete-todo")
    public void deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);
    }

 /*   @PutMapping(value = "/update-todo")
    public Todo updateTodo(@RequestParam(value = "id") int id,
                          @RequestBody String description){
        todoService.updateTodo(id, description);
        return null;
        }*/
}
