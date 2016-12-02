package com.soen387.erm.dataservice.server.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "building")
@JsonTypeName("building")
@Entity
public class Building extends AbstractResource {

    private String address;

    public String getAddress() {
        return address;
    }

    @Override
    public String getType() {
        return "building";
    }
}
