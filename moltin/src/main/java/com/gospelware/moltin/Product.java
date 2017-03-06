package com.gospelware.moltin;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by lewis on 07/02/2017.
 */

public class Product {

    public JsonElement rawJson;

    public String type;
    public String id;
    public String name;
    public String slug;
    public String sku;
    public Boolean manageStock;
    public String description;
    public ArrayList<Price> price;
    public String status;
    public String commodityType;
    public Dimensions dimensions;
    public Weight weight;
    public BaseResponse.BaseResponseLinks links;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonElement getRawJson() {
        return rawJson;
    }

    public void setRawJson(JsonElement rawJson) {
        this.rawJson = rawJson;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getManageStock() {
        return manageStock;
    }

    public void setManageStock(Boolean manageStock) {
        this.manageStock = manageStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Price> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Price> price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public BaseResponse.BaseResponseLinks getLinks() {
        return links;
    }

    public void setLinks(BaseResponse.BaseResponseLinks links) {
        this.links = links;
    }
}
