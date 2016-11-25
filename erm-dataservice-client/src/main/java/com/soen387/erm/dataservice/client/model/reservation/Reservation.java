package com.soen387.erm.dataservice.client.model.reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.soen387.erm.dataservice.client.model.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola  on 2016-11-21.
 */
@XmlRootElement(name = "reservation")
@JsonTypeName("reservation")
public class Reservation extends BaseEntity {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDateTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDateTime;
    
    private Long reservationId;

    @JsonProperty("user")
    private String userLink;

    @JsonProperty("resources")
    private List<String> resourcesLinks;

    public Long getReservationId() {
        return reservationId;
    }

    public String getUser() {
        return userLink;
    }

    public List<String> getResources() {
        return resourcesLinks;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setUser(String userLink) {
        this.userLink = userLink;
    }

    public void setResources(List<String> resources) {
        this.resourcesLinks = resources;
    }

    public void addResource(String resourceLink) {
        if (this.resourcesLinks == null) {
            this.resourcesLinks = new ArrayList<>();
        }
        this.resourcesLinks.add(resourceLink);
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
        return !(otherReservation.getReservationId() == null || this.getReservationId() == null)
                && otherReservation.getReservationId().equals(this.getReservationId());
    }

}
