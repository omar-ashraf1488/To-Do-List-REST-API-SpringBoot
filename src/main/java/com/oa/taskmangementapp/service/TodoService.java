package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.model.Todo;

import com.oa.taskmangementapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class TodoService implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void addTodo(String description) {
        Todo todo = new Todo();
        todo.setDescription(description);
        entityManager.persist(todo);
    }

   @Override
    public void updateTodo(int id, String description) {
        todoRepository.updateTodo(id, description);
    }

    @Override
    public void deleteTodo(int id){
        todoRepository.deleteTodo(id);
    }

    @Override
    public List<Todo> getAllTodos(){
       List todos = todoRepository.getAllTodos();
       return todos;
    }
}
