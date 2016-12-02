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

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public void setOperatingSystem(ComputerOS operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setDviOutput(Boolean dviOutput) {
		this.dviOutput = dviOutput;
	}

	public void setVgaOutput(Boolean vgaOutput) {
		this.vgaOutput = vgaOutput;
	}

	public void setHdmiOutput(Boolean hdmiOutput) {
		this.hdmiOutput = hdmiOutput;
	}

	public void setSpeakers(Boolean speakers) {
		this.speakers = speakers;
	}

	public void setKeyboard(Boolean keyboard) {
		this.keyboard = keyboard;
	}

	public void setMouse(Boolean mouse) {
		this.mouse = mouse;
	}

	public void setWirelessNetworking(Boolean wirelessNetworking) {
		this.wirelessNetworking = wirelessNetworking;
	}

	public void setWiredNetworking(Boolean wiredNetworking) {
		this.wiredNetworking = wiredNetworking;
	}
}
