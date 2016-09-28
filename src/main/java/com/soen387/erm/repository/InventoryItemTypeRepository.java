package com.soen387.erm.repository;

import com.soen387.erm.model.InventoryItemType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
public interface InventoryItemTypeRepository extends CrudRepository<InventoryItemType, Long> {

    List<InventoryItemType> findByName(String name);
}
