package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.model.Todo;

import java.util.List;

public interface ITodoService {
    boolean saveTodo(Todo todo);
    void deleteTodo(int id);
    public List<Todo> showAllTodos ();
    public  Todo updateTodo(int id, String description);
}
