package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.resource.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jeremybrown on 2016-11-30.
 */
@Ignore
public class ResourceApiTest {

    private static DataserviceClient client;

    private Building dummyBuilding;

    private Room dummyRoom;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        Building building1 = new Building();
        building1.setName("Hall");
        building1.setDescription("Henry F. Hall Building");
        building1.setAddress("2100 Bishop St., Montreal, Quebec, Canada");

        dummyBuilding = (Building) client.getResourceApi().create(building1);

        Room room1 = new Room();
        room1.setName("Conference Room #1");
        room1.setAvailable(false);
        room1.setMoveable(false);
        room1.setRoomNumber("CR1");
//        room1.setBuildingLink(dummyBuilding.getId().getHref());

        dummyRoom = (Room) client.getResourceApi().create(room1);
    }

    @After
    public void tearDown() throws Exception {
        client.getResourceApi().deleteResourceByLink(dummyBuilding.getId().getHref());
        client.getResourceApi().deleteResourceByLink(dummyRoom.getId().getHref());
    }

    @Test
    public void testCreateBuilding() throws Exception {
        Building b1 = new Building();
        b1.setName("Hall");
        b1.setDescription("Henry F. Hall Building");
        b1.setAddress("2100 Bishop St., Montreal, Quebec, Canada");

        Building createdBuilding = (Building) client.getResourceApi().create(b1);
        assertNotNull(createdBuilding);

        System.out.println("Name: " + createdBuilding.getName());
        System.out.println("Description: " + createdBuilding.getDescription());
        System.out.println("Address: " + createdBuilding.getAddress());
        System.out.println("Link: " + createdBuilding.getId().getHref());

        client.getResourceApi().deleteResourceByLink(createdBuilding.getId().getHref());
    }

    @Test
    public void testCreateComputer() throws Exception {
        Computer c = new Computer();
        c.setName("main computer");
        c.setHostname("mshome-1");
        c.setDescription("this is the main computer");
        c.setDviOutput(true);
        c.setHdmiOutput(false);
        c.setMachineType("Desktop");
        c.setKeyboard(true);
        c.setManufacturer("Dell");
        c.setModel("Inspiron");
        c.setMouse(false);
//        c.setOperatingSystem(ComputerOS);
        c.setSpeakers(true);
        c.setWirelessNetworking(false);
        c.setWiredNetworking(true);
        c.setAvailable(true);
        c.setMoveable(true);
//        c.setRoomLink(dummyRoom.getId().getHref());

        Computer createdComputer = (Computer) client.getResourceApi().create(c);
        assertNotNull(createdComputer);

        System.out.println("Name: " + createdComputer.getName());
        System.out.println("Description: " + createdComputer.getDescription());
        System.out.println("Hostname: " + createdComputer.getHostname());
        System.out.println("Manufacturer: " + createdComputer.getManufacturer());
        System.out.println("Model: " + createdComputer.getModel());
//        System.out.println("Room link: " + createdComputer.getRoomLink());

        client.getResourceApi().deleteResourceByLink(createdComputer.getId().getHref());
    }

    @Test
    public void testCreateRoom() throws Exception {
        Room r = new Room();
        r.setName("Conference Room #1");
        r.setAvailable(false);
        r.setMoveable(false);
        r.setRoomNumber("CR1");
        r.setDescription("Conference room seating between 8 to 10 people, located on the 2nd floor.");
//        r.setBuildingLink(dummyBuilding.getId().getHref());

        Room createdRoom = (Room) client.getResourceApi().create(r);
        assertNotNull(createdRoom);

        System.out.println("Name: " + createdRoom.getName());
        System.out.println("Available: " + createdRoom.getAvailable());
        System.out.println("Moveable: " + createdRoom.getMoveable());
        System.out.println("Room number: " + createdRoom.getRoomNumber());
//        System.out.println("Building link: " + createdRoom.getBuildingLink());

        client.getResourceApi().deleteResourceByLink(createdRoom.getId().getHref());
    }

    @Test
    public void testCreateProjector() throws Exception {
        Projector p = new Projector();
        p.setName("Projector 15");
        p.setMoveable(true);
        p.setDescription("DLP projector");
        p.setAvailable(true);
        p.setVgaInput(true);
        p.setDviInput(true);
        p.setHdmiInput(false);
        p.setResolution(new Dimensions(1920, 1080));
//        p.setRoomLink(dummyRoom.getId().getHref());

        Projector createdProjector = (Projector) client.getResourceApi().create(p);
        assertNotNull(createdProjector);

        System.out.println("Name: " + createdProjector.getName());
        System.out.println("Available: " + createdProjector.getAvailable());
        System.out.println("Moveable: " + createdProjector.getMoveable());
        System.out.println("Resolution: " + createdProjector.getResolution().getWidth() + "x" +
                createdProjector.getResolution().getHeight());
        System.out.println("Vga input: " + createdProjector.getVgaInput());
        System.out.println("Dvi input: " + createdProjector.getDviInput());
        System.out.println("Hdmi input: " + createdProjector.getHdmiInput());
//        System.out.println("Room link: " + createdProjector.getRoomLink());

        client.getResourceApi().deleteResourceByLink(createdProjector.getId().getHref());
    }

    @Test
    public void testCreateWhiteboard() throws Exception {
        Whiteboard w = new Whiteboard();
        w.setDimensions(new Dimensions(1000, 1000));
        w.setName("Whiteboard AXA");
        w.setAvailable(true);
        w.setMoveable(false);
//        w.setRoomLink(dummyRoom.getId().getHref());

        Whiteboard createdWhiteboard = (Whiteboard) client.getResourceApi().create(w);
        assertNotNull(w);

        System.out.println("Name: " + createdWhiteboard.getName());
        System.out.println("Available: " + createdWhiteboard.getAvailable());
        System.out.println("Moveable: " + createdWhiteboard.getMoveable());
        System.out.println("Dimensions: " + createdWhiteboard.getDimensions().getWidth() + "x" +
                createdWhiteboard.getDimensions().getHeight());
//        System.out.println("Room link: " + createdWhiteboard.getRoomLink());

        client.getResourceApi().deleteResourceByLink(createdWhiteboard.getId().getHref());
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<AbstractResource> allResources = client.getResourceApi().getAll();
        assertFalse(allResources.isEmpty());

        for (AbstractResource r: allResources) {
            System.out.println(r.getName());
            System.out.println(r.getId().getHref());
            System.out.println(r.getAvailable());
            System.out.println(r.getDescription());
        }
    }

    @Test
    public void testGetByLink() throws Exception {
        Building b = (Building) client.getResourceApi().getByLink(dummyBuilding.getId().getHref());
        assertNotNull(b);

        System.out.println(b.getId().getHref());
        System.out.println(b.getName());
        System.out.println(b.getDescription());
    }

    @Test
    public void testGetResourceById() throws Exception {
        System.out.println(dummyRoom.getResourceId());
        Room r = (Room) client.getResourceApi().getResourceById(dummyRoom.getResourceId());
        assertNotNull(r);

        System.out.println(r.getId().getHref());
        System.out.println(r.getName());
        System.out.println(r.getDescription());
    }
}
