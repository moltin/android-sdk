package com.gospelware.moltin.modules.carts;

import com.gospelware.moltin.modules.meta.TimestampMeta;

/**
 * Created by lewis on 08/03/2017.
 */

public class CartMeta {

    private Cart.CartDisplayPrice displayPrice;
    private TimestampMeta timestamps;

    public Cart.CartDisplayPrice getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(Cart.CartDisplayPrice displayPrice) {
        this.displayPrice = displayPrice;
    }

    public TimestampMeta getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(TimestampMeta timestamps) {
        this.timestamps = timestamps;
    }
}
