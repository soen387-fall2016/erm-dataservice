package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.auth.UserRole;
import org.junit.*;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeremybrown on 2016-11-03.
 */
@Ignore
public class UserRoleApiTest {

    private static DataserviceClient client;

    private UserRole dummyUserRole1;
    private UserRole dummyUserRole2;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        UserRole dummyUR1 = new UserRole();
        dummyUR1.setUserRoleHumanReadable("Role 1");

        UserRole dummyUR2 = new UserRole();
        dummyUR2.setUserRoleHumanReadable("Role 2");

        dummyUserRole1 = client.getUserRoleApi().create(dummyUR1);
        dummyUserRole2 = client.getUserRoleApi().create(dummyUR2);
    }

    @After
    public void tearDown() throws Exception {
        client.getUserApi().deleteResourceByLink(dummyUserRole1.getId().getHref());
        client.getUserApi().deleteResourceByLink(dummyUserRole2.getId().getHref());
    }

    @Test
    public void testGetAllUsersRoles() {
        Collection<UserRole> roles = client.getUserRoleApi().getAll();

        roles.forEach(r -> assertNotNull(r.getId()));
        roles.forEach(Assert::assertNotNull);

        assertTrue(roles.contains(dummyUserRole1));
        assertTrue(roles.contains(dummyUserRole2));
    }

    @Test
    public void testGetUserRoleById() {
        long roleId = dummyUserRole1.getRoleId();
        UserRole role = client.getUserRoleApi().getUserRoleById(roleId);

        assertEquals(client.getApiRootUrl() + "userRoles/" + roleId, role.getId().getHref());
        assertEquals(dummyUserRole1, role);
    }

    @Test
    public void testGetUserRoleByLink() {
        String link = dummyUserRole2.getId().getHref();
        UserRole role = client.getUserRoleApi().getByLink(link);

        assertEquals(link, role.getId().getHref());
        assertEquals(dummyUserRole2, role);
    }

    @Test
    public void testCreateUserRole() {
        UserRole role = new UserRole();
        role.setUserRoleHumanReadable("ROLE #2!");

        UserRole createdRole = client.getUserRoleApi().create(role);
        assertNotNull(createdRole);

        client.getUserRoleApi().deleteResourceByLink(createdRole.getId().getHref());
    }
}
