package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    void updateUser(User user);
    boolean existsById(String id);
    Optional<User> findById(String id);
    void save(User currentUser);
    List<User> findAll();
    void deleteUser(String id);
    /*
    void deleteUser(UUID id);

*/
}
