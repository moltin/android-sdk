package com.gospelware.moltin.products;

import com.gospelware.moltin.Validation;

import java.util.ArrayList;

/**
 * Created by lewis on 02/03/2017.
 */

public class ProductAttribute {

    public String label;
    public String value;
    public String type;
    public Validation validation;
    public Boolean required;
    public ArrayList<String> options;
    public String description;
    public ArrayList<ProductAttribute> items;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ProductAttribute> getItems() {
        return items;
    }

    public void setItems(ArrayList<ProductAttribute> items) {
        this.items = items;
    }
}
