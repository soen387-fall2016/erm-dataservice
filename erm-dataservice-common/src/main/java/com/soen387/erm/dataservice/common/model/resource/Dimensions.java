package com.soen387.erm.dataservice.common.model.resource;

import javax.persistence.Embeddable;

/**
 * Created by jeremybrown on 2016-10-22.
 */
@Embeddable
public class Dimensions {

    private int width;

    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
