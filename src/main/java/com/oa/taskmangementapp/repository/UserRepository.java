package com.oa.taskmangementapp.repository;

import com.oa.taskmangementapp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<AppUser, String> {

    AppUser findByEmail(String email);
}
