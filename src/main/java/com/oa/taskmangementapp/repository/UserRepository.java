package com.oa.taskmangementapp.repository;

import com.oa.taskmangementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User , String> {
}
