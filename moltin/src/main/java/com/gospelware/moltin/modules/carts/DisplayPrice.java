package com.gospelware.moltin.modules.carts;

/**
 * Created by lewis on 08/03/2017.
 */

public class DisplayPrice {

    private DisplayPrice withTax;
    private DisplayPrice withoutTax;

    public DisplayPrice getWithTax() {
        return withTax;
    }

    public void setWithTax(DisplayPrice withTax) {
        this.withTax = withTax;
    }

    public DisplayPrice getWithoutTax() {
        return withoutTax;
    }

    public void setWithoutTax(DisplayPrice withoutTax) {
        this.withoutTax = withoutTax;
    }
}
