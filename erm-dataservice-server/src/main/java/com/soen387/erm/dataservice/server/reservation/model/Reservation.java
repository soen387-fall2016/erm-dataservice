package com.soen387.erm.dataservice.server.reservation.model;

import com.soen387.erm.dataservice.server.auth.model.User;
import com.soen387.erm.dataservice.server.resource.model.AbstractResource;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<AbstractResource> resources;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
