package com.soen387.erm.dataservice.common.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class UserRole extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(value="roleName")
    private String userRoleHumanReadable;

    public String getUserRoleHumanReadable() {
        return userRoleHumanReadable;
    }
}
