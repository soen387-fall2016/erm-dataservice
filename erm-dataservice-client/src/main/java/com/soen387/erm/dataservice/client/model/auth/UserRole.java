package com.soen387.erm.dataservice.client.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "userRole")
@JsonTypeName("userRole")
public class UserRole extends BaseEntity {

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
