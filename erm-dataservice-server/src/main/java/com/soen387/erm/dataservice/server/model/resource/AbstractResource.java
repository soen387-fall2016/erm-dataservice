package com.soen387.erm.dataservice.server.model.resource;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-09-26.
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
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractResource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resourceId;

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

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof AbstractResource)) {
            return false;
        }
        AbstractResource otherResource = (AbstractResource) other;
        return this.getResourceId().equals((otherResource).getResourceId());
    }

    @Override
    public String toString() {
        return "AbstractResource " + getName();
    }
}
