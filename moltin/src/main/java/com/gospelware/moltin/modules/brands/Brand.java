package com.gospelware.moltin.modules.brands;

import com.google.gson.JsonElement;
import com.gospelware.moltin.Links;
import com.gospelware.moltin.modules.meta.TimestampMeta;

/**
 * Created by lewis on 02/03/2017.
 */

public class Brand {

    private String type;
    private String id;
    private String name;
    private String slug;
    private String status;
    private String description;
    private Links links;
    private TimestampMeta meta;

    public JsonElement rawJson;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public TimestampMeta getMeta() {
        return meta;
    }

    public void setMeta(TimestampMeta meta) {
        this.meta = meta;
    }

    public JsonElement getRawJson() {
        return rawJson;
    }

    public void setRawJson(JsonElement rawJson) {
        this.rawJson = rawJson;
    }

}
