package com.oa.taskmangementapp.repository;

import com.oa.taskmangementapp.model.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository // We use @Repository to define this object as a component with the responsibility of the repository.
@Component // Marking the class with @Component instructs Spring to instantiate the class and add an instance as a bean in its context.
public class DBTodoRepository implements TodoRepository {
    @Override
    public void saveTodo(Todo todo) {

        System.out.println("Storing comment: " + todo.getDescription());
    }

}
