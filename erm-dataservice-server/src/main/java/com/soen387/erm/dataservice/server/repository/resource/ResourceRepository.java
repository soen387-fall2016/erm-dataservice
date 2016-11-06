package com.soen387.erm.dataservice.server.repository.resource;

import com.soen387.erm.dataservice.common.model.resource.AbstractResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
@RepositoryRestResource(collectionResourceRel = "resources", path = "resources")
public interface ResourceRepository extends CrudRepository<AbstractResource, Long> {

    @RestResource(exported = true)
    List<AbstractResource> findByName(@Param("name") String name);

    // TODO
}
