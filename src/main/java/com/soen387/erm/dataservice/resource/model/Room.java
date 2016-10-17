package com.soen387.erm.dataservice.resource.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Room extends Resource {

    @Id
    private String roomNumber;

    @Id
    private Building building;

    public String getRoomNumber() {
        return roomNumber;
    }

    public Building getBuilding() {
        return building;
    }
}
