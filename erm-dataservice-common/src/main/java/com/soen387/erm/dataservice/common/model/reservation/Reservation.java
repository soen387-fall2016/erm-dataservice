package com.soen387.erm.dataservice.common.model.reservation;

import com.soen387.erm.dataservice.common.model.auth.User;
import com.soen387.erm.dataservice.common.model.resource.AbstractResource;

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
    private Long reservationId;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<AbstractResource> resources;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public Long getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public List<AbstractResource> getResources() {
        return resources;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setResources(List<AbstractResource> resources) {
        this.resources = resources;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
