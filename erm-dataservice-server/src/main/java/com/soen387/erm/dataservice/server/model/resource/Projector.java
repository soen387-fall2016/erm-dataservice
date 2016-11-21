package com.soen387.erm.dataservice.server.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@XmlRootElement(name = "projector")
@JsonTypeName("projector")
@Entity
public class Projector extends LocatableAbstractResource {

    @Embedded
    private Dimensions resolution;

    private Boolean dviInput;

    private Boolean vgaInput;

    private Boolean hdmiInput;

    public Dimensions getResolution() {
        return resolution;
    }

    public Boolean getDviInput() {
        return dviInput;
    }

    public Boolean getVgaInput() {
        return vgaInput;
    }

    public Boolean getHdmiInput() {
        return hdmiInput;
    }

}
