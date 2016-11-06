package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.common.model.auth.Department;
import com.soen387.erm.dataservice.common.model.auth.User;
import org.junit.*;
import org.springframework.hateoas.Resource;

import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeremybrown on 2016-11-01.
 */
@Ignore
public class UserApiTest {

    private static DataserviceClient client;

    private Resource<User> dummyUser1;
    private Resource<User> dummyUser2;

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

    @Ignore
    @Test
    public void testGetAllUsers() {
        Collection<Resource<User>> users = client.getUserApi().getAllUsers();

        users.forEach(r -> assertNotNull(r.getId()));
        users.forEach(r -> assertNotNull(r.getContent()));

        assertTrue(users.contains(dummyUser1));
        assertTrue(users.contains(dummyUser2));
    }

    @Ignore
    @Test
    public void testGetUserByUsername() {
        String username = "uzah";
        Resource<User> user = client.getUserApi().getUserByUsername(username);

        assertEquals("http://localhost:8080/api/users/uzah", user.getId().getHref());
        assertEquals(dummyUser1, user);
    }

    @Ignore
    @Test
    public void testGetUserByLink() {
        String link = dummyUser2.getId().getHref();
        Resource<User> user = client.getUserApi().getResourceByLink(link);

        assertEquals(link, user.getId().getHref());
        assertEquals(dummyUser2, user);
    }

        @Ignore
    @Test
    public void testCreateUser() {
        User u1 = new User();
        u1.setUsername("jonny");
        u1.setFirstName("John");
        u1.setLastName("Smith");

        Resource<User> createdUser = client.getUserApi().createResource(u1);
        assertNotNull(createdUser.getContent());

        client.getUserApi().deleteResourceByLink(createdUser.getId().getHref());
    }
}
