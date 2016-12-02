package com.soen387.erm.dataservice.client.model.resource;

/**
 * Created by Nicola on 2016-11-22.
 */

public class Dimensions {

    public Dimensions() {}

    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int width;

    private int height;

    public int getWidth() {
	        return width;
	    }

    public int getHeight() {
	        return height;
	    }

}


