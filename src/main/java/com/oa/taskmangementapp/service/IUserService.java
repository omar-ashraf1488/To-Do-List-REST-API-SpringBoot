package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void addUser(AppUser appUser);
    void updateUser(AppUser appUser);
    boolean existsById(String id);
    Optional<AppUser> findById(String id);
    List<AppUser> findAll();
    void deleteUser(String id);
}
