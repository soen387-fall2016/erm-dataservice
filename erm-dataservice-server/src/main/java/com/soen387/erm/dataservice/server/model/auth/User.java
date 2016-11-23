package com.soen387.erm.dataservice.server.model.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.server.model.BaseEntity;

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
    @JsonInclude
    private String username;

    private String firstName;

    private String lastName;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + username + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User otherUser = (User) other;
        return otherUser.getUsername().equals(this.getUsername());
    }
}
