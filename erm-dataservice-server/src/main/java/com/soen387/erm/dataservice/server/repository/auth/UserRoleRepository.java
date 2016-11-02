package com.soen387.erm.dataservice.server.repository.auth;

import com.soen387.erm.dataservice.common.model.auth.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeremybrown on 2016-10-17.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
