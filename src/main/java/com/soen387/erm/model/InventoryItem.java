package com.soen387.erm.model;

/**
 * Created by jeremybrown on 2016-09-26.
 */
public class InventoryItem {
    private final long id;
    private final String name;
    private final InventoryItemType type;
    private final String content;

    public InventoryItem(long id, String  name, InventoryItemType type, String content) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public long getId() {
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
}
