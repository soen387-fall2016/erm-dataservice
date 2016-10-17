package com.soen387.erm.dataservice.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userRoleHumanReadable;

    public Long getId() {
        return id;
    }

    public String getUserRoleHumanReadable() {
        return userRoleHumanReadable;
    }
}
