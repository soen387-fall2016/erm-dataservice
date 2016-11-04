package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.common.model.auth.Department;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public class DepartmentApiTest {

    private static DataserviceClient client;

    @BeforeClass
    public static void setUp() throws Exception {
        client = new DataserviceClient();
    }

    @Ignore
    @Test
    public void testGetAllDepartments() {
        Collection<Resource<Department>> departmentsCollection = client.getDepartmentApi().getAllDepartments();

        departmentsCollection.forEach(res -> System.out.println(res.getId().getHref()));
        departmentsCollection.forEach(res -> System.out.println(res.getContent().getName()));
    }

    @Ignore
    @Test
    public void testGetDepartmentById() {
        Long departmentId = 1L;
        Resource<Department> departmentResource = client.getDepartmentApi().getDepartmentById(departmentId);

        String departmentHref = departmentResource.getId().getHref();
        assert departmentHref.equals("http://localhost:8080/api/departments/1");
    }

    @Ignore
    @Test
    public void testGetDepartmentByLink() {
        String link = "http://localhost:8080/api/departments/1";
        Resource<Department> departmentResource = client.getDepartmentApi().getResourceByLink(link);


        String departmentHref = departmentResource.getId().getHref();
        assert departmentHref.equals("http://localhost:8080/api/departments/1");
    }
}
