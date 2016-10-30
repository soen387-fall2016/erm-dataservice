package com.soen387.erm.dataservice.server.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Room extends AbstractResource {

    private String roomNumber;

    @ManyToOne
    private Building building;

    public String getRoomNumber() {
        return roomNumber;
    }

    public Building getBuilding() {
        return building;
    }
}
