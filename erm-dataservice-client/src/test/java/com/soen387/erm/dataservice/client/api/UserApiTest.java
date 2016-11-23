package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.auth.Department;
import com.soen387.erm.dataservice.client.model.auth.User;
import com.soen387.erm.dataservice.client.model.auth.UserRole;
import org.junit.*;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeremybrown on 2016-11-01.
 */
@Ignore
public class UserApiTest {

    private static DataserviceClient client;

    private User dummyUser1;
    private User dummyUser2;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        User dummyU1 = new User();
        dummyU1.setUsername("uzah");
        dummyU1.setFirstName("USER");
        dummyU1.setLastName("SLANG");

        User dummyU2 = new User();
        dummyU2.setUsername("admin");
        dummyU2.setFirstName("SUPER");
        dummyU2.setLastName("USER");

        dummyUser1 = client.getUserApi().createResource(dummyU1);
        dummyUser2 = client.getUserApi().createResource(dummyU2);
    }

    @After
    public void tearDown() throws Exception {
        client.getUserApi().deleteResourceByLink(dummyUser1.getId().getHref());
        client.getUserApi().deleteResourceByLink(dummyUser2.getId().getHref());
    }

    @Test
    public void testGetAllUsers() {
        Collection<User> users = client.getUserApi().getAllUsers();

        users.forEach(r -> assertNotNull(r.getId()));
        users.forEach(Assert::assertNotNull);

        assertTrue(users.contains(dummyUser1));
        assertTrue(users.contains(dummyUser2));
    }

    @Test
    public void testGetUserByUsername() {
        String username = "uzah";
        User user = client.getUserApi().getUserByUsername(username);

        assertEquals("http://localhost:8080/api/users/uzah", user.getId().getHref());
        assertEquals(dummyUser1, user);
    }

    @Test
    public void testGetUserByLink() {
        String link = dummyUser2.getId().getHref();
        User user = client.getUserApi().getResourceByLink(link);

        assertEquals(link, user.getId().getHref());
        assertEquals(dummyUser2, user);
    }

    @Test
    public void testCreateUser() {
        User u1 = new User();
        u1.setUsername("jonny");
        u1.setFirstName("John");
        u1.setLastName("Smith");

        User createdUser = client.getUserApi().createResource(u1);
        assertNotNull(createdUser);

        client.getUserApi().deleteResourceByLink(createdUser.getId().getHref());
    }

    @Test
    public void testCreateDepartmentAndUserAndRole() {
        Department d1 = new Department();
        d1.setName("Department HEYYO!");

        Department createdDepartment = client.getDepartmentApi().createResource(d1);
        assertNotNull(createdDepartment);

        UserRole role = new UserRole();
        role.setUserRoleHumanReadable("ROLE #2!");

        UserRole createdRole = client.getUserRoleApi().createResource(role);
        assertNotNull(createdRole);

        User u1 = new User();
        u1.setUsername("jonny");
        u1.setFirstName("John");
        u1.setLastName("Smith");
        u1.setDepartment(createdDepartment.getId().getHref());
        u1.addRole(createdRole.getId().getHref());

        User createdUser = client.getUserApi().createResource(u1);
        assertNotNull(createdUser);

        String departmentLink = createdUser.getLink("department").getHref();
        String rolesLink = createdUser.getLink("roles").getHref();
        Department departmentFromUser = client.getDepartmentApi().getResourceByLink(departmentLink);
        assertNotNull(departmentFromUser);
        Collection<UserRole> rolesFromUser = client.getUserRoleApi().getCollectionByLink(rolesLink);
        assertNotNull(rolesFromUser);

        client.getUserApi().deleteResourceByLink(createdUser.getId().getHref());
        client.getDepartmentApi().deleteResourceByLink(createdDepartment.getId().getHref());
        client.getUserRoleApi().deleteResourceByLink(createdRole.getId().getHref());
    }

}
