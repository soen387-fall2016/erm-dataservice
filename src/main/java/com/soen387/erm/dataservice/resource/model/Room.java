package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Room extends Resource {

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
