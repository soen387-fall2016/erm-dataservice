package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.common.model.auth.User;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.hateoas.Resource;

import java.util.Collection;

/**
 * Created by jeremybrown on 2016-11-01.
 */
public class UserApiTest {

    private static DataserviceClient client;

    @BeforeClass
    public static void setUp() throws Exception {
        client = new DataserviceClient();
    }

    @Ignore
    @Test
    public void testGetAllUsers() {
        Collection<Resource<User>> users = client.getUserApi().getAllUsers();

        users.forEach(res -> System.out.println(res.getId().getHref()));
        users.forEach(res -> System.out.println(res.getContent().getFirstName() + " " + res.getContent().getLastName()));
    }

    @Ignore
    @Test
    public void testGetUserByUsername() {
        String username = "uzah";
        Resource<User> user = client.getUserApi().getUserByUsername(username);

        String userHref = user.getId().getHref();
        assert userHref.equals("http://localhost:8080/api/users/uzah");
    }

    @Ignore
    @Test
    public void testGetUserByLink() {
        String link = "http://localhost:8080/api/users/uzah";
        Resource<User> user = client.getUserApi().getResourceByLink(link);

        String userHref = user.getId().getHref();
        assert userHref.equals("http://localhost:8080/api/users/uzah");
    }
}
