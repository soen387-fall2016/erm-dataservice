package com.soen387.erm.dataservice.server.auth.repository;

import com.soen387.erm.dataservice.server.auth.model.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeremybrown on 2016-10-17.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}