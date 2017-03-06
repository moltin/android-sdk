package com.gospelware.moltin;

/**
 * Created by lewis on 24/02/2017.
 */

public class Dimensions {

    public DimensionWidth width;
    public DimensionWidth height;
    public DimensionWidth length;

    public DimensionWidth getWidth() {
        return width;
    }

    public void setWidth(DimensionWidth width) {
        this.width = width;
    }

    public DimensionWidth getHeight() {
        return height;
    }

    public void setHeight(DimensionWidth height) {
        this.height = height;
    }

    public DimensionWidth getLength() {
        return length;
    }

    public void setLength(DimensionWidth length) {
        this.length = length;
    }

    public class DimensionWidth {
        public ValueUnit cm;
        public ValueUnit m;
        public ValueUnit ft;
        public ValueUnit in;
        public ValueUnit yd;
        public ValueUnit mi;
    }


}
