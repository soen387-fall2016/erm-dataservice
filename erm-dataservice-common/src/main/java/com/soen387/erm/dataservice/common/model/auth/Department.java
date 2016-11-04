package com.soen387.erm.dataservice.common.model.auth;

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
@XmlRootElement(name = "department")
@JsonTypeName("department")
@Entity
public class Department extends BaseEntity {

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
