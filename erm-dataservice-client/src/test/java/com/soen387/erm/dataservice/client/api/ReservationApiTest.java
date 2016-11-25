package com.soen387.erm.dataservice.client.api;

import com.soen387.erm.dataservice.client.DataserviceClient;
import com.soen387.erm.dataservice.client.model.auth.User;
import com.soen387.erm.dataservice.client.model.reservation.Reservation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by jeremybrown on 2016-11-25.
 */
@Ignore
public class ReservationApiTest {

    private static DataserviceClient client;

    private User dummyUser1;

    @Before
    public void setUp() throws Exception {
        client = new DataserviceClient();

        User dummyU1 = new User();
        dummyU1.setUsername("uzah");
        dummyU1.setFirstName("USER");
        dummyU1.setLastName("SLANG");
        dummyU1.setEmail("uazh@gmail.com");
        dummyU1.setPhone("555-555-5555");
        dummyU1.setPasswordEncrypted("hashhashhashhash");

        dummyUser1 = client.getUserApi().create(dummyU1);
    }

    @After
    public void tearDown() throws Exception {
        client.getUserApi().deleteResourceByLink(dummyUser1.getId().getHref());
    }

    @Test
    public void testCreateReservation() throws Exception {
        Reservation r1 = new Reservation();
        r1.setUser(dummyUser1.getId().getHref());
        LocalDateTime now = LocalDateTime.now();
        r1.setStartDateTime(now);
        r1.setEndDateTime(now.plusWeeks(2));

        Reservation createdReservation = client.getReservationApi().create(r1);
        assertNotNull(createdReservation);

        String userLink = createdReservation.getLink("user").getHref();
        User userFromReservation = client.getUserApi().getByLink(userLink);
        assertNotNull(userFromReservation);

        System.out.println("Reservation");
        System.out.println("Link: " + createdReservation.getId().getHref());
        System.out.println("Start date time: " + createdReservation.getStartDateTime());
        System.out.println("End date time: " + createdReservation.getEndDateTime());
        System.out.println("User link: " + createdReservation.getLink("user").getHref());

        System.out.println("User");
        System.out.println("Link: " + userFromReservation.getId().getHref());
        System.out.println("Username: " + userFromReservation.getUsername());
        System.out.println("Name: " + userFromReservation.getFirstName() + " " + userFromReservation.getLastName());
        System.out.println("Department: " + userFromReservation.getDepartment());
        System.out.println("Department: " + userFromReservation.getEmail());
        System.out.println("Department: " + userFromReservation.getPhone());
        System.out.println("Department: " + userFromReservation.getPasswordEncrypted());

//        client.getUserApi().deleteResourceByLink(createdReservation.getId().getHref());
    }
}
