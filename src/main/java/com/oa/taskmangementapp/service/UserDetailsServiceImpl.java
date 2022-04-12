package com.oa.taskmangementapp.service;

import com.oa.taskmangementapp.entity.AppUser;
import com.oa.taskmangementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    // Load a user by their email address and returns an object containing their details. If the user is not found, an exception is thrown.
    // UserDetails is an interface in the Spring Security framework that represents a user's details.
    // UserDetails can be used to store information about a user, such as their username, password, and roles.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = this.userRepository.findByEmail(email);

        if (user == null) {
            System.out.println(email + " not found!");
            throw new UsernameNotFoundException("User " + email + " not found!");
        }
        System.out.println("Found user");

        // GrantedAuthority represents a role or permission that can be assigned to a user.
        // Create a list of granted authorities for a user with the roles specified in the "roles" array.
        // If the user is an admin, they are given the "ROLE_ADMIN" authority. If the user is not an admin, they are given the "ROLE_USER" authority.
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        if (user.isAdmin()) {
            grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else
            grantList.add(new SimpleGrantedAuthority("ROLE_USER"));

        // Creates a new User object with the email and password from the user object, and a list of granted permissions.
        // The new User object is being treated as a UserDetails object.
        // UserDetails is an interface that defines methods for getting information about a user, such as their email address and password.
        UserDetails userDetails = (UserDetails) new User(user.getEmail(), user.getPassword(), grantList);

        return userDetails;
    }

}
