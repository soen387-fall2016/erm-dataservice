package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-22.
 */
@XmlRootElement(name = "room")
@JsonTypeName("room")
public class Room extends AbstractResource {
	 private String roomNumber;

	    private Building building;

	    public String getRoomNumber() {
	        return roomNumber;
	    }

	    public Building getBuilding() {
	        return building;
	    }
	
    


    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Room)) {
            return false;
        }
        Room otherRoom = (Room) other;
        //WIP temp
        if ((otherRoom.getRoomNumber()== null || this.getRoomNumber() == null)) {
            return false;
        }
        else if (!(otherRoom.getRoomNumber().equals(this.getRoomNumber()))) {
            return false;
        }
        return true;
    }

}
