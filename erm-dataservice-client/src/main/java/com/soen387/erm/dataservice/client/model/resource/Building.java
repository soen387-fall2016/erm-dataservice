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
    
    private Long buildingId;
    
    private String buildingName;
    

    public String getAddress() {
        return address;
    }
    
    public Long getBuildingId(){
    	return buildingId;
    }
    
    public String getBuildingName(){
    	return buildingName;
    }
    


    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Building)) {
            return false;
        }
        Building otherBuilding = (Building) other;
        //WIP
        if ((otherBuilding.getAddress() == null || this.getAddress() == null)) {
            return false;
        }
        else if (!(otherBuilding.getAddress().equals(this.getAddress()))) {
            return false;
        }
        return true;
    }

}
