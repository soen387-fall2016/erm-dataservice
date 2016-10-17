package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Building extends Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }
}
