package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.resource.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeremybrown on 2016-11-30.
 */
@Ignore
public class ResourceApiTest {

    private static DataserviceClient client;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();
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

        // TODO fix link returned by API
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
//        c.setRoomLink();

        Computer createdComputer = (Computer) client.getResourceApi().create(c);
        assertNotNull(createdComputer);

        System.out.println("Name: " + createdComputer.getName());
        System.out.println("Description: " + createdComputer.getDescription());
        System.out.println("Hostname: " + createdComputer.getHostname());
        System.out.println("Manufacturer: " + createdComputer.getManufacturer());
        System.out.println("Model: " + createdComputer.getModel());
        System.out.println("etc.");

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
//        r.setBuildingLink();

        Room createdRoom = (Room) client.getResourceApi().create(r);
        assertNotNull(createdRoom);

        System.out.println("Name: " + createdRoom.getName());
        System.out.println("Available: " + createdRoom.getAvailable());
        System.out.println("Moveable: " + createdRoom.getMoveable());
        System.out.println("Room number: " + createdRoom.getRoomNumber());

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
//        p.setRoomLink();

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

        client.getResourceApi().deleteResourceByLink(createdProjector.getId().getHref());
    }

    @Test
    public void testCreateWhiteboard() throws Exception {
        Whiteboard w = new Whiteboard();
        w.setDimensions(new Dimensions(1000, 1000));
        w.setName("Whiteboard AXA");
        w.setAvailable(true);
        w.setMoveable(false);
//        w.setRoomLink();

        Whiteboard createdWhiteboard = (Whiteboard) client.getResourceApi().create(w);
        assertNotNull(w);

        System.out.println("Name: " + createdWhiteboard.getName());
        System.out.println("Available: " + createdWhiteboard.getAvailable());
        System.out.println("Moveable: " + createdWhiteboard.getMoveable());
        System.out.println("Dimensions: " + createdWhiteboard.getDimensions().getWidth() + "x" +
                createdWhiteboard.getDimensions().getHeight());

        client.getResourceApi().deleteResourceByLink(createdWhiteboard.getId().getHref());
    }

}
