package com.soen387.erm.dataservice.client.model.resource;

import com.soen387.erm.dataservice.client.model.resource.AbstractResource;
import com.soen387.erm.dataservice.client.model.resource.Room;

/**
 * Created by Nicola on 2016-11-22.
 */
public class LocatableAbstractResource extends AbstractResource {
	private Room room;

    public Room getRoom() {
        return room;
    }
}


