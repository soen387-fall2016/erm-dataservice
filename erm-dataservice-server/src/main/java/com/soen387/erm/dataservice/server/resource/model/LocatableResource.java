package com.soen387.erm.dataservice.server.resource.model;

import javax.persistence.ManyToMany;

/**
 * Created by jeremybrown on 2016-10-22.
 */
public abstract class LocatableResource extends Resource {

    @ManyToMany
    private Room room;

    public Room getRoom() {
        return room;
    }
}
