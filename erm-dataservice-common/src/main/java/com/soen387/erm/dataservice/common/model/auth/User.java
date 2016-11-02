package com.soen387.erm.dataservice.common.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class User extends ResourceSupport {

    @Id
    @JsonProperty("username")
    private String username;

    private String firstName;

    private String lastName;

    @JsonIgnore
    private String passwordEncrypted;

    private String email;

    private String phone;

    @ManyToOne
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
