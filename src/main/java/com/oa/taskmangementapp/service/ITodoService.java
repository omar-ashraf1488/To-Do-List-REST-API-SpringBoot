package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {
    void addTodo(Todo todo);
    List<Todo> getTodosForUser(String id);
    /*  void updateTodo(int id, String description);*/
    void deleteTodo(int id);
    boolean existsById(int id);
    Optional<Todo> findTodoById(int id);
    List<Todo> findAll();
}
