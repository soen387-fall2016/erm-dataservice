package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Building extends Resource {

    private String address;

    public String getAddress() {
        return address;
    }
}