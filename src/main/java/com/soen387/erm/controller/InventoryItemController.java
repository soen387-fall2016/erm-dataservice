package com.soen387.erm.controller;

import java.util.Map;

import com.soen387.erm.model.InventoryItem;
import com.soen387.erm.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeremybrown on 2016-09-26.
 */
@RestController
@RequestMapping("/inventory/item")
public class InventoryItemController {

    @Autowired
    private InventoryItemRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<InventoryItem> getInventory() {
        return repository.findAll();
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
    public InventoryItem getItem(@PathVariable long itemId) {
        return repository.findOne(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public InventoryItem postItem(@RequestBody InventoryItem newItem) {
        return repository.save(newItem);
    }
}
