package com.soen387.erm.dataservice.client.model.resource;

import com.soen387.erm.dataservice.client.model.resource.ComputerOS.OsType;

public class ComputerOS {
	
	private Long id;

    enum OsType {
        WIN, MAC, LINUX
    }

    private OsType osType;

    private String version;

    private String license;

    public String getVersion() {
        return version;
    }

    public String getLicense() {
        return license;
    }
}


