package com.soen387.erm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@Entity
public class InventoryItemType {

    @Id
    String name;

    public String getName() {
        return name;
    }

    public String toString() {
        return "InventoryItemType " + getName();
    }
}
