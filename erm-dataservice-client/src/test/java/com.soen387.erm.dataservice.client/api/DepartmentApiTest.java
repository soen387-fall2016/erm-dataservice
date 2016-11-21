package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.auth.Department;
import org.junit.*;
import org.springframework.hateoas.Resource;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeremybrown on 2016-11-03.
 */
@Ignore
public class DepartmentApiTest {

    private static DataserviceClient client;

    private Resource<Department> dummyDepartment1;
    private Resource<Department> dummyDepartment2;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        Department dummyD1 = new Department();
        dummyD1.setName("IT");

        Department dummyD2 = new Department();
        dummyD2.setName("Accounting");

        dummyDepartment1 = client.getDepartmentApi().createResource(dummyD1);
        dummyDepartment2 = client.getDepartmentApi().createResource(dummyD2);
    }

    @After
    public void tearDown() throws Exception {
        client.getUserApi().deleteResourceByLink(dummyDepartment1.getId().getHref());
        client.getUserApi().deleteResourceByLink(dummyDepartment2.getId().getHref());
    }

    @Test
    public void testGetAllDepartments() {
        Collection<Resource<Department>> departments = client.getDepartmentApi().getAllDepartments();

        departments.forEach(r -> assertNotNull(r.getId()));
        departments.forEach(r -> assertNotNull(r.getContent()));

        assertTrue(departments.contains(dummyDepartment1));
        assertTrue(departments.contains(dummyDepartment2));
    }

    @Ignore
    @Test
    public void testGetDepartmentById() {
        // TODO fix this test
        Long departmentId = 1L;
        Resource<Department> departmentResource = client.getDepartmentApi().getDepartmentById(departmentId);

        String departmentHref = departmentResource.getId().getHref();
        assertEquals("http://localhost:8080/api/departments/1", departmentHref);
        assertNotNull(departmentResource.getContent());
    }

    @Test
    public void testGetDepartmentByLink() {
        String link = dummyDepartment2.getId().getHref();
        Resource<Department> department = client.getDepartmentApi().getResourceByLink(link);

        assertEquals(link, department.getId().getHref());
        assertEquals(dummyDepartment2, department);
    }

    @Test
    public void testCreateDepartment() {
        Department d1 = new Department();
        d1.setName("Department HEYYO!");

        Resource<Department> createdDepartment = client.getDepartmentApi().createResource(d1);
        assertNotNull(createdDepartment.getContent());

        client.getUserApi().deleteResourceByLink(createdDepartment.getId().getHref());
    }
}
