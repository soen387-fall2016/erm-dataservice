package com.soen387.erm.dataservice.server.model.resource;

import javax.persistence.ManyToMany;

/**
 * Created by jeremybrown on 2016-10-22.
 */
public abstract class LocatableAbstractResource extends AbstractResource {

    @ManyToMany
    private Room room;

    public Room getRoom() {
        return room;
    }
}
