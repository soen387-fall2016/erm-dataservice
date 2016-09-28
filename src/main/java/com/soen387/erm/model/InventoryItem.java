package com.soen387.erm.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private InventoryItemType type;

    private String content;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public InventoryItemType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "InventoryItem toString TODO";
    }
}
