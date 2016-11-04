package com.soen387.erm.dataservice.server.repository.auth;

import com.soen387.erm.dataservice.common.model.auth.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by jeremybrown on 2016-11-03.
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByName(@Param("name") String name);

}
