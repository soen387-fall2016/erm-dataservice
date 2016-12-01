package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.ClientConfig;
import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.resource.Building;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeremybrown on 2016-11-30.
 */
public class ResourceApiTest {

    private static DataserviceClient client;

    @Before
    public void setUp() throws Exception {
        ClientConfig c = new ClientConfig("http://54.218.174.224:8080/api/");
        client = new DataserviceClient(c);
    }

    @Test
    public void testCreateResource() throws Exception {
        Building b1 = new Building();
        b1.setBuildingName("Hall");
        b1.setDescription("Henry F. Hall Building");
        b1.setAddress("2100 Bishop St., Montreal, Quebec, Canada");

        Building createdBuilding = (Building) client.getResourceApi().create(b1);
        assertNotNull(createdBuilding);

        System.out.println("Name: " + createdBuilding.getName());
        System.out.println("Description: " + createdBuilding.getDescription());
        System.out.println("Address: " + createdBuilding.getAddress());

        client.getResourceApi().deleteResourceByLink(createdBuilding.getId().getHref());
    }

}
