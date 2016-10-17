package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Computer extends Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

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
}
