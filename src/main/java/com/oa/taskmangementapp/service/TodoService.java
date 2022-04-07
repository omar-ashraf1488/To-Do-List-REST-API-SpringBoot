package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.model.Todo;

import com.oa.taskmangementapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TodoService implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todosList= new ArrayList<>(Arrays.asList());

    @Override
    public boolean saveTodo(Todo todo) {
        //todoRepository.saveTodo(todo);
        return todosList.add(todo);
    }

    @Override
    public List<Todo> showAllTodos(){
        return todosList;
    }

    @Override
    public Todo updateTodo(int id, String description) {
        for (Todo todo:todosList) {
            if(todo.getId() == id){
                todo.setDescription(description);
            }
        }
        return null;
    }

    @Override
    public void deleteTodo(int id){
        todosList.removeIf(todo -> todo.getId() == id);
    }
}
