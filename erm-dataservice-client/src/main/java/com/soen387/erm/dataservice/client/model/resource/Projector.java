package com.soen387.erm.dataservice.client.model.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.soen387.erm.dataservice.client.model.BaseEntity;
import com.soen387.erm.dataservice.client.model.resource.Dimensions;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nicola on 2016-11-24.
 */
@XmlRootElement(name = "projector")
@JsonTypeName("projector")
public class Projector extends LocatableAbstractResource {

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

    public void setResolution(Dimensions resolution) {
        this.resolution = resolution;
    }

    public void setDviInput(Boolean dviInput) {
        this.dviInput = dviInput;
    }

    public void setVgaInput(Boolean vgaInput) {
        this.vgaInput = vgaInput;
    }

    public void setHdmiInput(Boolean hdmiInput) {
        this.hdmiInput = hdmiInput;
    }
}
