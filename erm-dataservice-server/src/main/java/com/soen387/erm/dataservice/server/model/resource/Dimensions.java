package com.soen387.erm.dataservice.server.model.resource;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jeremybrown on 2016-10-22.
 */
@Embeddable
public class Dimensions {

    @Column(nullable = true)
    private int width;

    @Column(nullable = true)
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
