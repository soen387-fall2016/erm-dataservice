package com.soen387.erm.dataservice.resource.model;

import javax.persistence.*;

/**
 * Created by jeremybrown on 2016-10-17.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Whiteboard extends Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private WhiteboardDimensions dimensions;

    public WhiteboardDimensions getDimensions() {
        return dimensions;
    }

    public Long getId() {
        return id;
    }

    class WhiteboardDimensions {

        private long width;

        private long height;
    }
}
