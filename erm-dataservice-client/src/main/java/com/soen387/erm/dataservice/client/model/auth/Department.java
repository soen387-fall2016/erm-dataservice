package com.soen387.erm.dataservice.client.model.auth;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "department")
@JsonTypeName("department")
public class Department extends BaseEntity {

    private Long departmentId;

    private String name;

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Department)) {
            return false;
        }
        Department otherDepartment = (Department) other;
        // TODO find better way to do this
        if ((otherDepartment.getName() == null || this.getName() == null)) {
            return false;
        }
        else if (!(otherDepartment.getName().equals(this.getName()))) {
            return false;
        }
        return true;
    }

}
