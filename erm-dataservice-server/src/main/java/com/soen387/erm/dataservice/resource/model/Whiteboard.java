package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Whiteboard extends LocatableResource {

    @Embedded
    private Dimensions dimensions;

    public Dimensions getDimensions() {
        return dimensions;
    }
}