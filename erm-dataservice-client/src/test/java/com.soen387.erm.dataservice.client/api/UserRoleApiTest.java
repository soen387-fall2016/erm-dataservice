package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.common.model.auth.UserRole;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-03.
 */
public class UserRoleApiTest {

    private static DataserviceClient client;

    @BeforeClass
    public static void setUp() throws Exception {
        client = new DataserviceClient();
    }

    @Ignore
    @Test
    public void testGetAllUsersRoles() {
        Collection<Resource<UserRole>> roles = client.getUserRoleApi().getAllUserRoles();

        roles.forEach(res -> System.out.println(res.getId().getHref()));
        roles.forEach(res -> System.out.println(res.getContent().getUserRoleHumanReadable()));
    }

    @Ignore
    @Test
    public void testGetUserRoleById() {
        Long userRoleId = 1L;
        Resource<UserRole> role = client.getUserRoleApi().getUserRoleById(userRoleId);

        String roleHref = role.getId().getHref();
        assert roleHref.equals("http://localhost:8080/api/userRoles/1");
    }

    @Ignore
    @Test
    public void testGetUserRoleByLink() {
        String link = "http://localhost:8080/api/userRoles/1";
        Resource<UserRole> role = client.getUserRoleApi().getResourceByLink(link);


        String roleHref = role.getId().getHref();
        assert roleHref.equals("http://localhost:8080/api/userRoles/1");
    }
}
