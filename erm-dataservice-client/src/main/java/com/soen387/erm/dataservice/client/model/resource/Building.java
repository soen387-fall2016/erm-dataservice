package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-22.
 */
@XmlRootElement(name = "building")
@JsonTypeName("building")
public class Building extends AbstractResource {

    private String address;
    
    private String buildingName;

    public String getAddress() {
        return address;
    }

    public String getBuildingName(){
    	return buildingName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
