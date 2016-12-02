package com.soen387.erm.dataservice.client.model.resource;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;

/**
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Computer.class, name = "computer"),
        @JsonSubTypes.Type(value = Whiteboard.class, name = "whiteboard"),
        @JsonSubTypes.Type(value = Projector.class, name = "projector"),
        @JsonSubTypes.Type(value = Building.class, name = "building"),
        @JsonSubTypes.Type(value = Room.class, name = "room")
})
@XmlRootElement(name = "resource")
@JsonTypeName("resource")
public class AbstractResource extends BaseEntity {

    private long resourceId;

    private String name;

    private String description;

    private Boolean available;

    private Boolean moveable;

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Boolean getMoveable() {
        return moveable;
    }

    public String getDescription() {
        return description;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setMoveable(Boolean moveable) {
        this.moveable = moveable;
    }

    @Override
    public String toString() {
        return "AbstractResource " + getName();
    }
}