package com.soen387.erm.dataservice.client;

import com.soen387.erm.dataservice.common.model.auth.UserRole;
import org.junit.Test;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by jeremybrown on 2016-10-31.
 */
public class Test1 {

    @Test
    public void clientTest1() throws Exception {
        DataserviceClient client = new DataserviceClient();
//        List<UserRole> roles = client.getUserRoles();

//        roles.forEach(r -> System.out.println("[" + r.getRoleId() + "] " + r.getUserRoleHumanReadable()));
    }

    @Test
    public void testGetUserRoles() throws Exception {
        DataserviceClient client = new DataserviceClient();
        Collection<UserRole> roles = client.getUserRoleApi().getUserRoles();

        // TODO
        roles.forEach(r -> System.out.println(r.getId().getHref() + ": " + r.getUserRoleHumanReadable()));
    }

    @Test
    public void testGetUserRoleById() throws Exception {
//        DataserviceClient client = new DataserviceClient();
//        Optional<UserRole> role1 = client.getUserRoleApi().getUserRoleById(1L);
//
//         TODO
//        if (role1.isPresent()) {
//            System.out.println("role1 name: " + role1.get().getUserRoleHumanReadable());
//        }
//        else {
//            System.out.println("role1 not present");
//        }
    }

    @Test
    public void test4() throws Exception {
//        DataserviceClient client = new DataserviceClient();
//        UserRole role1 = client.getUserRoleById(1L);
//        System.out.println("role1 name: " + role1.getUserRoleHumanReadable());
    }
}
