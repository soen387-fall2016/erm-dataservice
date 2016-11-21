package com.soen387.erm.dataservice.client.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "user")
@JsonTypeName("user")
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    @JsonIgnore
    private String passwordEncrypted;

    private String email;

    private String phone;

    private String department;

    private List<String> roles;

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

    public String getDepartment() {
        return department;
    }

    public List<String> getRoles() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartmentId(String departmentId) {
        this.department = departmentId;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String roleId) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(roleId);
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
        if (!(otherUser.getUsername().equals(this.getUsername()))) {
            return false;
        }
        return true;
    }
}
