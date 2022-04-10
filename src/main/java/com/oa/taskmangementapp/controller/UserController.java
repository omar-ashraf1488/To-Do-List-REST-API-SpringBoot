package com.oa.taskmangementapp.controller;

import com.oa.taskmangementapp.model.User;
import com.oa.taskmangementapp.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/add-user")
    public ResponseEntity<ApiResponse> addUser(@RequestBody User user) {
        try {
            userService.save(user);
            return new ResponseEntity(new ApiResponse(true, "User registered successfully"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, "Something went wrong"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(value = "/update-user/")
    public ResponseEntity<ApiResponse> updateTodo(@RequestParam String id,
                                                  @RequestBody User user){
        if (!userService.existsById(id)) {
            return new ResponseEntity<>(new ApiResponse(false, "User not found"),
                    HttpStatus.NOT_FOUND);
        }

        Optional<User> optionalUser = userService.findById(id);
        User currentUser = optionalUser.get();

        if (user.getEmail() != null && !user.getEmail().equals(currentUser.getEmail())) {
            currentUser.setEmail(user.getEmail());
        }

        if (user.getFirstName() != null && !user.getFirstName().equals(currentUser.getFirstName())) {
            currentUser.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null && !user.getLastName().equals(currentUser.getLastName())) {
            currentUser.setLastName(user.getLastName());
        }
        userService.save(currentUser);

        return new ResponseEntity <> (new ApiResponse(true, "User updated"),
                HttpStatus.OK);
    }

    @GetMapping(value = "/all-users")
    public ResponseEntity<List<User>> listOfUser() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

   @DeleteMapping(value = "/delete-user")
    public ResponseEntity<ApiResponse> deleteTodo(@RequestParam String id) {
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
