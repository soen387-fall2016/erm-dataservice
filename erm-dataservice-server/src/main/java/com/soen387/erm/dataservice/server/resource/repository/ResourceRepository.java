package com.soen387.erm.dataservice.server.resource.repository;

import com.soen387.erm.dataservice.server.resource.model.AbstractResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@RepositoryRestResource()
public interface ResourceRepository extends CrudRepository<AbstractResource, Long> {

    @RestResource(exported = true, path="byName")
    List<AbstractResource> findByName(@Param("name") String name);

    // TODO
}
