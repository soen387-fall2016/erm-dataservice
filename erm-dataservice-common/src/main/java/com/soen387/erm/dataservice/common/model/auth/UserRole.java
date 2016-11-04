package com.soen387.erm.dataservice.common.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.common.model.BaseEntity;

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
    private Long id;

    @JsonProperty(value="roleName")
    private String userRoleHumanReadable;

    public String getUserRoleHumanReadable() {
        return userRoleHumanReadable;
    }
}
