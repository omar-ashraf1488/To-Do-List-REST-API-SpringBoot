package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {

    void addTodo(String description);
    void updateTodo(int id, String description);
    void deleteTodo(int id);
    public List<Todo> getAllTodos();
}
