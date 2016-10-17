package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@Entity
public abstract class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Boolean available;

    private Room room;

    private Boolean moveable;

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Room getRoom() {
        return room;
    }

    public Boolean getMoveable() {
        return moveable;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Resource " + getName();
    }
}
