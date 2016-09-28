package com.soen387.erm.controller;

import com.soen387.erm.model.InventoryItemType;
import com.soen387.erm.repository.InventoryItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * COPYRIGHT Ericsson 2016
 * <p>
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 * <p>
 * InventoryItemTypeController.java
 * <p>
 * Created by ebrjere on 9/28/16.
 */
@RestController
@RequestMapping("/inventory/type")
public class InventoryItemTypeController {

    @Autowired
    private InventoryItemTypeRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<InventoryItemType> getInventory() {
        return repository.findAll();
    }

    @RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
    public InventoryItemType getItem(@PathVariable long itemId) {
        return repository.findOne(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public InventoryItemType postItem(@RequestBody InventoryItemType newItem) {
        return repository.save(newItem);
    }
}
