package com.gospelware.moltin.modules.carts;

import com.gospelware.moltin.Links;
import com.gospelware.moltin.modules.meta.DisplayPrice;
import com.gospelware.moltin.modules.meta.TimestampMeta;

/**
 * Created by lewis on 08/03/2017.
 */

public class Cart {

    private String type;
    private String id;
    private Links links;
    private CartMeta meta;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public CartMeta getMeta() {
        return meta;
    }

    public void setMeta(CartMeta meta) {
        this.meta = meta;
    }


}
