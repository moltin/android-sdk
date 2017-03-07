package com.gospelware.moltin.modules.collections;

import com.gospelware.moltin.Links;
import com.gospelware.moltin.modules.products.IncludedProducts;

/**
 * Created by lewis on 07/03/2017.
 */

public class CollectionResponse {

    private Collection data;
    private Links links;
    private IncludedProducts products;

    public Collection getData() {
        return data;
    }

    public void setData(Collection data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public IncludedProducts getProducts() {
        return products;
    }

    public void setProducts(IncludedProducts products) {
        this.products = products;
    }
}
