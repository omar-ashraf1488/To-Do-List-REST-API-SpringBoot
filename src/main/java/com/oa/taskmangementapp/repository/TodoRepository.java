package com.oa.taskmangementapp.repository;

import com.oa.taskmangementapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Modifying
    @Query(value = "INSERT INTO todos (description) VALUES (:description):", nativeQuery=true)
    void addTodo(@Param("description") String description);

    @Query(value = "SELECT * FROM todos;", nativeQuery=true)
    List<Todo> getAllTodos();

    @Modifying
    @Query(value = "DELETE FROM todos todo WHERE todo.id = :id", nativeQuery=true)
    @Transactional
    void deleteTodo(@Param("id") int id);

    @Modifying
    @Query(value = "UPDATE todos todo SET todo.description = :description WHERE todo.id = :id", nativeQuery=true)
    @Transactional
    void updateTodo(@Param("id") int id, @Param("description") String description);
}
