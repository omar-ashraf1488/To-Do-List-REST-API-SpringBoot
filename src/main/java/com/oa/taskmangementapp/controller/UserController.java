package com.oa.taskmangementapp.controller;

import com.oa.taskmangementapp.entity.AppUser;
import com.oa.taskmangementapp.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    BCryptPasswordEncoder passwordencoder;

    @PostMapping(value = "/add-user")
    public ResponseEntity<ApiResponse> addUser(@RequestBody AppUser appUser) {

        try {
            appUser.setPassword(passwordencoder.encode(appUser.getPassword()));
            userService.addUser(appUser);
            return new ResponseEntity(new ApiResponse(true, "User registered successfully"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, "Something went wrong"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity<ApiResponse> updateTodo(@PathVariable(value = "id") String id,
                                                  @RequestBody AppUser appUser){
        if (!userService.existsById(id)) {
            return new ResponseEntity<>(new ApiResponse(false, "User not found"),
                    HttpStatus.NOT_FOUND);
        }

        Optional<AppUser> optionalUser = userService.findById(id);
        AppUser currentAppUser = optionalUser.get();

        if (appUser.getEmail() != null && !appUser.getEmail().equals(currentAppUser.getEmail())) {
            currentAppUser.setEmail(appUser.getEmail());
        }
        if (appUser.getPassword() != null && !appUser.getPassword().equals(currentAppUser.getPassword())) {
            currentAppUser.setPassword(appUser.getPassword());
        }

        if (appUser.getFirstName() != null && !appUser.getFirstName().equals(currentAppUser.getFirstName())) {
            currentAppUser.setFirstName(appUser.getFirstName());
        }

        if (appUser.getLastName() != null && !appUser.getLastName().equals(currentAppUser.getLastName())) {
            currentAppUser.setLastName(appUser.getLastName());
        }
        userService.updateUser(currentAppUser);

        return new ResponseEntity <> (new ApiResponse(true, "User updated"),
                HttpStatus.OK);
    }

    @GetMapping(value = "/all-users")
    public ResponseEntity<List<AppUser>> listOfUser() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

   @DeleteMapping(value = "/delete-user/{id}")
    public ResponseEntity<ApiResponse> deleteTodo(@PathVariable(value = "id")String id) {
       try {
           userService.deleteUser(id);
           return new ResponseEntity<ApiResponse>(new ApiResponse(true, "User deleted successfully"),
                   HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<ApiResponse>(new ApiResponse(false, "User not found"),
                   HttpStatus.NOT_FOUND);
       }
   }
}
