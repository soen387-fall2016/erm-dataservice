package com.soen387.erm.dataservice.server.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.server.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "userRole")
@JsonTypeName("userRole")
@Entity
public class UserRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @JsonProperty(value="roleName")
    private String userRoleHumanReadable;

    public String getUserRoleHumanReadable() {
        return userRoleHumanReadable;
    }

    public void setUserRoleHumanReadable(String userRoleHumanReadable) {
        this.userRoleHumanReadable = userRoleHumanReadable;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof UserRole)) {
            return false;
        }
        UserRole otherUserRole = (UserRole) other;
        // TODO find better way to do this
        return otherUserRole.getUserRoleHumanReadable().equals(this.getUserRoleHumanReadable());
    }
}
