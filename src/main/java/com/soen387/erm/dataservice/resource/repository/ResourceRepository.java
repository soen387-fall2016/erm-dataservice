package com.soen387.erm.dataservice.resource.repository;

import com.soen387.erm.dataservice.resource.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
public interface ResourceRepository extends CrudRepository<Resource, Long> {

    List<Resource> findByName(@Param("name") String name);

    // TODO
}
