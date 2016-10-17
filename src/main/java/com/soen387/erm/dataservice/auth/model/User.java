package com.soen387.erm.dataservice.auth.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class User {

    @Id
    private String username;

    private String firstName;

    private String lastName;

    private String passwordEncrypted;

    private String email;

    private String phone;

    private Department department;

    @ManyToMany
    private List<UserRole> roles;

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Department getDepartment() {
        return department;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + username + ")";
    }
}
