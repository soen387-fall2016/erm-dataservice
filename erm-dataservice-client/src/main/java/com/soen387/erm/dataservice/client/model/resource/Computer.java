package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.resource.ComputerOS;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-22.
 */
@XmlRootElement(name = "computer")
@JsonTypeName("computer")
public class Computer extends LocatableAbstractResource {
	 private String hostname;

	    private String machineType;

	    private ComputerOS operatingSystem;

	    private String manufacturer;

	    private String model;

	    private Boolean dviOutput;

	    private Boolean vgaOutput;

	    private Boolean hdmiOutput;

	    private Boolean speakers;

	    private Boolean keyboard;

	    private Boolean mouse;

	    private Boolean wirelessNetworking;

	    private Boolean wiredNetworking;

	    public String getHostname() {
	        return hostname;
	    }

	    public String getMachineType() {
	        return machineType;
	    }

	    public ComputerOS getOperatingSystem() {
	        return operatingSystem;
	    }

	    public String getManufacturer() {
	        return manufacturer;
	    }

	    public String getModel() {
	        return model;
	    }

	    public Boolean getDviOutput() {
	        return dviOutput;
	    }

	    public Boolean getVgaOutput() {
	        return vgaOutput;
	    }

	    public Boolean getHdmiOutput() {
	        return hdmiOutput;
	    }

	    public Boolean getSpeakers() {
	        return speakers;
	    }

	    public Boolean getKeyboard() {
	        return keyboard;
	    }

	    public Boolean getMouse() {
	        return mouse;
	    }

	    public Boolean getWirelessNetworking() {
	        return wirelessNetworking;
	    }

	    public Boolean getWiredNetworking() {
	        return wiredNetworking;
	    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Computer)) {
            return false;
        }
        Computer otherComputer = (Computer) other;
        //WIP
        if ((otherComputer.getHostname() == null || this.hostname== null)) {
            return false;
        }
        else if (!(otherComputer.getHostname().equals(this.getHostname()))) {
            return false;
        }
        return true;
    }

}
