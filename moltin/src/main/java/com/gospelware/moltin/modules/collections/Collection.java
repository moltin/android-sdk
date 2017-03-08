package com.gospelware.moltin.modules.collections;

import com.gospelware.moltin.Links;
import com.gospelware.moltin.modules.meta.TimestampMeta;

/**
 * Created by lewis on 07/03/2017.
 */

public class Collection {

    private String type;
    private String id;
    private String name;
    private String slug;
    private String description;
    private String status;
    private Links links;
    private TimestampMeta meta;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
