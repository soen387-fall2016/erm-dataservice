package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.common.model.auth.Department;
import com.soen387.erm.dataservice.common.model.auth.UserRole;
import org.junit.*;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeremybrown on 2016-11-03.
 */
@Ignore
public class UserRoleApiTest {

    private static DataserviceClient client;

    private Resource<UserRole> dummyUserRole1;
    private Resource<UserRole> dummyUserRole2;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        UserRole dummyUR1 = new UserRole();
        dummyUR1.setUserRoleHumanReadable("Role 1");

        UserRole dummyUR2 = new UserRole();
        dummyUR2.setUserRoleHumanReadable("Role 2");

        dummyUserRole1 = client.getUserRoleApi().createResource(dummyUR1);
        dummyUserRole2 = client.getUserRoleApi().createResource(dummyUR2);
    }

    @After
    public void tearDown() throws Exception {
        client.getUserApi().deleteResourceByLink(dummyUserRole1.getId().getHref());
        client.getUserApi().deleteResourceByLink(dummyUserRole2.getId().getHref());
    }

    @Test
    public void testGetAllUsersRoles() {
        Collection<Resource<UserRole>> roles = client.getUserRoleApi().getAllUserRoles();

        roles.forEach(r -> assertNotNull(r.getId()));
        roles.forEach(r -> assertNotNull(r.getContent()));

        assertTrue(roles.contains(dummyUserRole1));
        assertTrue(roles.contains(dummyUserRole2));
    }

    @Ignore
    @Test
    public void testGetUserRoleById() {
        // TODO fix this test
        Long userRoleId = 1L;
        Resource<UserRole> role = client.getUserRoleApi().getUserRoleById(userRoleId);

        assertEquals("http://localhost:8080/api/userRoles/1", role.getId().getHref());
        assertEquals(dummyUserRole1, role);
    }

    @Test
    public void testGetUserRoleByLink() {
        String link = dummyUserRole2.getId().getHref();
        Resource<UserRole> role = client.getUserRoleApi().getResourceByLink(link);

        assertEquals(link, role.getId().getHref());
        assertEquals(dummyUserRole2, role);
    }

    @Test
    public void testCreateUserRole() {
        UserRole role = new UserRole();
        role.setUserRoleHumanReadable("ROLE #2!");

        Resource<UserRole> createdRole = client.getUserRoleApi().createResource(role);
        assertNotNull(createdRole.getContent());

        client.getUserRoleApi().deleteResourceByLink(createdRole.getId().getHref());
    }
}
