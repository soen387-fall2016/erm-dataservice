package com.soen387.erm.dataservice.auth.repository;

import com.soen387.erm.dataservice.auth.model.User;
import com.soen387.erm.dataservice.resource.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

//    List<Resource> findByUsername(@Param("username") String username);

    // TODO
}
