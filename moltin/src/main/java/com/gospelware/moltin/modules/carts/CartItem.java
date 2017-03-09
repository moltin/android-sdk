package com.gospelware.moltin.modules.carts;

/**
 * Created by lewis on 09/03/2017.
 */

public class CartItem {

    private String type = "cart_item";
    private String id;
    private Integer quantity;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
