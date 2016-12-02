package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.auth.Department;
import org.junit.*;

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

    private Department dummyDepartment1;
    private Department dummyDepartment2;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        Department dummyD1 = new Department();
        dummyD1.setName("IT");

        Department dummyD2 = new Department();
        dummyD2.setName("Accounting");

        dummyDepartment1 = client.getDepartmentApi().create(dummyD1);
        dummyDepartment2 = client.getDepartmentApi().create(dummyD2);
    }

    @After
    public void tearDown() throws Exception {
        client.getUserApi().deleteResourceByLink(dummyDepartment1.getId().getHref());
        client.getUserApi().deleteResourceByLink(dummyDepartment2.getId().getHref());
    }

    @Test
    public void testGetAllDepartments() {
        Collection<Department> departments = client.getDepartmentApi().getAll();

        departments.forEach(r -> assertNotNull(r.getId()));
        departments.forEach(Assert::assertNotNull);

        assertTrue(departments.contains(dummyDepartment1));
        assertTrue(departments.contains(dummyDepartment2));
    }

    @Test
    public void testGetDepartmentById() {
        long departmentId = dummyDepartment1.getDepartmentId();
        Department departmentResource = client.getDepartmentApi().getDepartmentById(departmentId);

        String departmentHref = departmentResource.getId().getHref();
        assertEquals(client.getApiRootUrl() + "departments/" + departmentId, departmentHref);
        assertNotNull(departmentResource);
    }

    @Test
    public void testGetDepartmentByLink() {
        String link = dummyDepartment2.getId().getHref();
        Department department = client.getDepartmentApi().getByLink(link);

        assertEquals(link, department.getId().getHref());
        assertEquals(dummyDepartment2, department);
    }

    @Test
    public void testCreateDepartment() {
        Department d1 = new Department();
        d1.setName("Department HEYYO!");

        Department createdDepartment = client.getDepartmentApi().create(d1);
        assertNotNull(createdDepartment);

        client.getUserApi().deleteResourceByLink(createdDepartment.getId().getHref());
    }
}
