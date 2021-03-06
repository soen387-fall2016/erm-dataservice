package com.soen387.erm.dataservice.server.repository.auth;

import com.soen387.erm.dataservice.server.model.auth.User;
import com.soen387.erm.dataservice.server.model.auth.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ebrjere on 9/28/16.
 */
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByEmail(@Param("email") String email);

    List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<User> findByDepartmentName(@Param("departmentName") String departmentName);

    List<User> findByRoles(@Param("roleId") UserRole userRole);

    // TODO
}
