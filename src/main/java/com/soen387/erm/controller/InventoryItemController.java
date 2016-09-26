package com.soen387.erm.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.soen387.erm.model.InventoryItem;
import com.soen387.erm.model.InventoryItemType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@RestController
@RequestMapping("/inventory")
public class InventoryItemController {

//    private final AtomicLong counter = new AtomicLong();

    private Map<Integer, InventoryItem> placeholderItems;

    public InventoryItemController() {
        // placeholder items
        placeholderItems = new HashMap<>();
        placeholderItems.put(1, new InventoryItem(1, "item1", InventoryItemType.LaptopComputer, "Laptop #2535"));
        placeholderItems.put(2, new InventoryItem(2, "item2", InventoryItemType.DesktopComputer, "Desktop #2538"));
        placeholderItems.put(3, new InventoryItem(3, "item3", InventoryItemType.Projector, "Projector 3"));
        placeholderItems.put(4, new InventoryItem(4, "item4", InventoryItemType.ConferenceRoom, "Room 12345"));
        placeholderItems.put(5, new InventoryItem(5, "item5", InventoryItemType.Unknown, "Misc item 25"));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public Map<Integer, InventoryItem> getInventory() {
        return placeholderItems;
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
    public InventoryItem getItem(@PathVariable int itemId) {
        return placeholderItems.get(itemId);
    }
}
