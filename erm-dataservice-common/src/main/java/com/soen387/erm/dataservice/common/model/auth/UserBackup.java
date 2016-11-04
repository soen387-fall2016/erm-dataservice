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
public class UserBackup extends ResourceSupport {

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
    private DepartmentBackup department;

    @ManyToMany
    private List<UserRoleBackup> roles;

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

    public DepartmentBackup getDepartment() {
        return department;
    }

    public List<UserRoleBackup> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + username + ")";
    }
}
