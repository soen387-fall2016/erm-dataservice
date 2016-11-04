package com.soen387.erm.dataservice.common.model.auth;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class DepartmentBackup extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }
}
