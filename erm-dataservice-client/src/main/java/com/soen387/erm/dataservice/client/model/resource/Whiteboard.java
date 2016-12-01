package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-24.
 */
@XmlRootElement(name = "whiteboard")
@JsonTypeName("whiteboard")
public class Whiteboard extends LocatableAbstractResource {

    private Dimensions dimensions;

    public Dimensions getDimensions() {
	        return dimensions;
	    }

}

