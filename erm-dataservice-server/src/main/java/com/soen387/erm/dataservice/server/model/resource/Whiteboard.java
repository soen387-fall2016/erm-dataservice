package com.soen387.erm.dataservice.server.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "whiteboard")
@JsonTypeName("whiteboard")
@Entity
public class Whiteboard extends LocatableAbstractResource {

    @Embedded
    private Dimensions dimensions;

    public Dimensions getDimensions() {
        return dimensions;
    }

    @Override
    public String getType() {
        return "whiteboard";
    }
}