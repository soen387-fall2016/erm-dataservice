package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nicola on 2016-11-22.
 */
public class LocatableAbstractResource extends AbstractResource {

    @JsonProperty("room")
	private String roomLink;

    public String getRoomLink() {
        return roomLink;
    }

    public void setRoomLink(String roomLink) {
        this.roomLink = roomLink;
    }
}
