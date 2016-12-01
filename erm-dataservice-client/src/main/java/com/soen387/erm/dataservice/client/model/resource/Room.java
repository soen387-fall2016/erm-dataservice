package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-22.
 */
@XmlRootElement(name = "room")
@JsonTypeName("room")
public class Room extends AbstractResource {

    private String roomNumber;

    @JsonProperty("building")
    private String buildingLink;

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBuildingLink() {
        return buildingLink;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBuildingLink(String buildingLink) {
        this.buildingLink = buildingLink;
    }

}
