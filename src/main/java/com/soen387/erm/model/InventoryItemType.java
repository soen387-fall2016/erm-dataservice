package com.soen387.erm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@Entity
public class InventoryItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return "InventoryItemType " + getName() + "[ID " + getId() + "]";
    }
}
