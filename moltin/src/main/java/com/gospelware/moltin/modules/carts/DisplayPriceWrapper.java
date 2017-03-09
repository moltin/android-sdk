package com.gospelware.moltin.modules.carts;

import com.gospelware.moltin.modules.meta.DisplayPrice;

/**
 * Created by lewis on 08/03/2017.
 */

public class DisplayPriceWrapper {

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
