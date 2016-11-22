package com.soen387.erm.dataservice.client.model.auth;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.server.model.User;
import com.soen387.erm.dataservice.server.model.resource.AbstractResource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola  on 2016-11-21.
 */
@XmlRootElement(name = "reservation")
@JsonTypeName("reservation")
public class Reservation extends BaseEntity {

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
    
    private Long reservationId;
    
    private User user;

    private List<AbstractResource> resources;

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


    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Reservation)) {
            return false;
        }
        Reservation otherReservation = (Reservation) other;
        // TODO find better way to do this
        if ((otherReservation.getName() == null || this.getName() == null)) {
            return false;
        }
        else if (!(otherReservation.getName().equals(this.getName()))) {
            return false;
        }
        return true;
    }


}
