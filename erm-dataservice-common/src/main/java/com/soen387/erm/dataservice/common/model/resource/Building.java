package com.soen387.erm.dataservice.common.model.resource;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Building extends AbstractResource {

    private String address;

    public String getAddress() {
        return address;
    }
}