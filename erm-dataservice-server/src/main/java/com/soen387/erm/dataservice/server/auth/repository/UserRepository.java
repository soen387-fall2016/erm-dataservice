package com.soen387.erm.dataservice.server.auth.repository;

import com.soen387.erm.dataservice.server.auth.model.Department;
import com.soen387.erm.dataservice.server.auth.model.User;
import com.soen387.erm.dataservice.server.auth.model.UserRole;
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
