package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.entity.Todo;

import com.oa.taskmangementapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoService implements ITodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public void addTodo(Todo todo){
        todoRepository.save(todo);
    }

    /*@Override
    public void updateTodo(int id, String description) {
        todoRepository.findById(Todo.getId());
        todoRepository.save(Todo);
    }*/

    @Override
    public boolean existsById(int id) {
        return todoRepository.existsById(id);
    }

    @Override
    public Optional<Todo> findTodoById(int id) {
        return todoRepository.findById(id);
    }


    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> getTodosForUser(String id) {
        return todoRepository.findAllByUserId(id);
    }

}
