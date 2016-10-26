package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
public class Projector extends LocatableResource {

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
