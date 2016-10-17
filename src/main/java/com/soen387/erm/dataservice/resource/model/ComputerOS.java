package com.soen387.erm.dataservice.resource.model;

/**
 * Created by jeremybrown on 2016-10-17.
 */
class ComputerOS {

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
