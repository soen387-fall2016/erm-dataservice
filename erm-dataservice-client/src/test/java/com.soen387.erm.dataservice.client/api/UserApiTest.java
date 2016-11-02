package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.common.model.auth.User;
import com.soen387.erm.dataservice.common.model.auth.UserRole;
import org.junit.Test;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by jeremybrown on 2016-11-01.
 */
public class UserApiTest {

    @Test
    public void testGetUsers() throws Exception {
        DataserviceClient client = new DataserviceClient();
        Collection<User> users = client.getUserApi().getUsers();

        // TODO
        users.forEach(r -> System.out.println(r.getId().getHref() + ": " + r.getUsername() + ": "));
    }
}
