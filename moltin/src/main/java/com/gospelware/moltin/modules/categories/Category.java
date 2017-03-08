package com.gospelware.moltin.modules.categories;

import com.gospelware.moltin.Relationships;
import com.gospelware.moltin.modules.meta.TimestampMeta;

import java.util.ArrayList;

/**
 * Created by lewis on 06/03/2017.
 */

public class Category {

    private String type;
    private String id;
    private String name;
    private String slug;
    private String description;
    private String status;

    private TimestampMeta meta;
    private Relationships relationships;
    private ArrayList<Category> children;

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

    public TimestampMeta getMeta() {
        return meta;
    }

    public void setMeta(TimestampMeta meta) {
        this.meta = meta;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public ArrayList<Category> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Category> children) {
        this.children = children;
    }
}
