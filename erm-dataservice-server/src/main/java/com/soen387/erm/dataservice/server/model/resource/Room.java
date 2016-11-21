package com.soen387.erm.dataservice.server.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "room")
@JsonTypeName("room")
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
