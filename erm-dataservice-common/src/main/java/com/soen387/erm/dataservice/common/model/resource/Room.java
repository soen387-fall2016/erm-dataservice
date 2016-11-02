package com.soen387.erm.dataservice.common.model.resource;

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
