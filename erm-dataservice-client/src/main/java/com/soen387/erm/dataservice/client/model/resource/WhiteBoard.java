package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.resource.Dimensions;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-24.
 */
@XmlRootElement(name = "whiteboard")
@JsonTypeName("whiteboard")
public class WhiteBoard extends LocatableAbstractResource {

	 private Dimensions dimensions;

	    public Dimensions getDimensions() {
	        return dimensions;
	    }
	


    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof WhiteBoard)) {
            return false;
        }
        WhiteBoard otherWhiteBoard = (WhiteBoard) other;
        //WIP
        if ((otherWhiteBoard.getId() == null || this.getId() == null)) {
            return false;
        }
        else if (!(otherWhiteBoard.getId().equals(this.getId()))) {
            return false;
        }
        return true;
    }

}

