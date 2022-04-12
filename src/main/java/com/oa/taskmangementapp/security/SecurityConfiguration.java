package com.oa.taskmangementapp.security;

import com.oa.taskmangementapp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean // Create a password encoder bean.
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // Configure the authentication manager builder with a user details service and password encoder.
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    // The function takes a HttpSecurity object as a parameter, which is used to specify the security rules for the application.
    // The function is protected because it is meant to be used by the security framework only.
    // Application developers should not need to call this function directly.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  Disable CSRF protection and frame options.
        //  CSRF protection is a security measure that helps to prevent cross-site request forgery attacks.
        http.csrf().disable();
        //  Frame options help to prevent clickjacking attacks.
        http.headers().frameOptions().disable();
        // Anyone can access the API endpoints located at /api/v1/.
        http.authorizeRequests().antMatchers("/api/v1/**").permitAll();
        // Defines a rule that all requests to the server must be authorized with a role of ROLE_ADMIN.
        http.authorizeRequests().antMatchers("/**").access("Role('ROLE_ADMIN')");
    }






}
