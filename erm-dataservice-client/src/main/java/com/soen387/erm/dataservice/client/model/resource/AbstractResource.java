package com.soen387.erm.dataservice.client.model.resource;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;

/**
 */

@XmlRootElement(name = "resource")
@JsonTypeName("resource")

public class AbstractResource extends BaseEntity {

    private  long resourceID;

    private String name;

    private String description;

    private Boolean available;


    private Boolean moveable;

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Boolean getMoveable() {
        return moveable;
    }

    public String getDescription() {
        return description;
    }

    public Long getResourceId() {
        return resourceID;
    }

    @Override
    public String toString() {
        return "AbstractResource " + getName();
    }
}