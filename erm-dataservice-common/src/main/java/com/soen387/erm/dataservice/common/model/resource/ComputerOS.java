package com.soen387.erm.dataservice.common.model.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
class ComputerOS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
