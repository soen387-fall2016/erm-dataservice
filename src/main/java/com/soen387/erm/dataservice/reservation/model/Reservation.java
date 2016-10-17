package com.soen387.erm.dataservice.reservation.model;

import com.soen387.erm.dataservice.auth.model.User;
import com.soen387.erm.dataservice.resource.model.Resource;

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

    private User user;

    @ManyToMany
    private List<Resource> resources;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
