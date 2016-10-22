package com.soen387.erm.dataservice.resource.repository;

import com.soen387.erm.dataservice.resource.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jeremybrown on 2016-10-22.
 */
public interface ReservationRepository extends CrudRepository<Resource, Long> {

    List<Resource> findByUserUsername(@Param("username") String username);

    List<Resource> findByResourceId(@Param("resourceid") String resourceid);
}
