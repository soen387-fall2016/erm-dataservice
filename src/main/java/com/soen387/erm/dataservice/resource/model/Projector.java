package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Projector extends Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ProjectorResolution resolution;

    private Boolean dviInput;

    private Boolean vgaInput;

    private Boolean hdmiInput;

    public ProjectorResolution getResolution() {
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

    public Long getId() {
        return id;
    }

    class ProjectorResolution {

        private Long width;

        private Long height;
    }
}
