package com.gospelware.moltin;

import java.util.ArrayList;

/**
 * Created by lewis on 02/03/2017.
 */

public class Validation {

    public String regex;
    public Integer min;
    public Integer max;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
