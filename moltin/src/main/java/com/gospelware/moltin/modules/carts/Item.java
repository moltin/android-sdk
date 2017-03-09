package com.gospelware.moltin.modules.carts;

import com.gospelware.moltin.Links;
import com.gospelware.moltin.Price;

/**
 * Created by lewis on 09/03/2017.
 */

public class Item {

    private String type;
    private String id;
    private String productId;
    private String name;
    private String sku;
    private String quantity;
    private Price unitPrice;
    private Price value;
    private Links links;
    private ItemMeta meta;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Price getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Price unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Price getValue() {
        return value;
    }

    public void setValue(Price value) {
        this.value = value;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public ItemMeta getMeta() {
        return meta;
    }

    public void setMeta(ItemMeta meta) {
        this.meta = meta;
    }

    public class ItemMeta{

        private DisplayPriceWrapper displayPrice;

        public DisplayPriceWrapper getDisplayPrice() {
            return displayPrice;
        }

        public void setDisplayPrice(DisplayPriceWrapper displayPrice) {
            this.displayPrice = displayPrice;
        }
    }
}
