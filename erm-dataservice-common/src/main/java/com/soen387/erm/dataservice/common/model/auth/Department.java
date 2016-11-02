package com.soen387.erm.dataservice.common.model.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    private String name;

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }
}
