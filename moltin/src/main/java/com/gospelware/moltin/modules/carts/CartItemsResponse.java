package com.gospelware.moltin.modules.carts;

import java.util.ArrayList;

/**
 * Created by lewis on 08/03/2017.
 */

public class CartItemsResponse {

    private ArrayList<Item> data;
    private CartMeta meta;

    public ArrayList<Item> getData() {
        return data;
    }

    public void setData(ArrayList<Item> data) {
        this.data = data;
    }

    public CartMeta getMeta() {
        return meta;
    }

    public void setMeta(CartMeta meta) {
        this.meta = meta;
    }
}
