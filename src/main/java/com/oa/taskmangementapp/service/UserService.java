package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.entity.AppUser;
import com.oa.taskmangementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(AppUser appUser){
        userRepository.save(appUser);
    }

    @Override
    public void updateUser(AppUser appUser) {
       userRepository.findById(appUser.getId());
       userRepository.save(appUser);
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public Optional<AppUser> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


}
