package com.soen387.erm.dataservice.common.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.common.model.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "user")
@JsonTypeName("user")
@Entity
public class User extends BaseEntity {

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
