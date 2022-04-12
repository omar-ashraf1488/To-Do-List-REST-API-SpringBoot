package com.oa.taskmangementapp.entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "User")
@Table(name = "users")
// The Serializable interface is used to indicate that an object can be serialized, or converted to a byte stream. This is useful for storing or transmitting data.
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="created_at", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public AppUser() {
    }

    public AppUser(String id) {
        this.id = id;
    }

    public AppUser(String id, String email, boolean isAdmin, String firstName, Date createdAt) {
        this.id = id;
        this.email = email;
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
// TODO: 12/04/2022  it may be more convenient to convert the Users object into a UsersDto object
//    so that you can more easily access the data that you need.
// TODO: 12/04/2022  UsersDto object contains only the data that you need, so you don't have to worry about accidentally accessing data that you don't want.
//  Second, the UsersDto object is easier to work with in general, since it is designed specifically for use in your program.
