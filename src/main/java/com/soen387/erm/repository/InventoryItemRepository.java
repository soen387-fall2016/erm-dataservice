package com.soen387.erm.repository;

import com.soen387.erm.model.InventoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {

    List<InventoryItem> findByName(@Param("name") String name);
}
