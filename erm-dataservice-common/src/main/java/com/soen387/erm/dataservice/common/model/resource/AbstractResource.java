package com.soen387.erm.dataservice.common.model.resource;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractResource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resourceId;

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
        return resourceId;
    }

    @Override
    public String toString() {
        return "AbstractResource " + getName();
    }
}
