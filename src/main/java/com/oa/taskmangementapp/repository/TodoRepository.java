package com.oa.taskmangementapp.repository;

import com.oa.taskmangementapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByUserId(String user_id);
}
