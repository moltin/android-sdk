package com.gospelware.moltin.modules.orders;

/**
 * Created by lewis on 13/03/2017.
 */

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String line_1;
    private String line_2;
    private String postcode;
    private String county;
    private String country;

    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String line_1, String line_2, String postcode, String county, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.line_1 = line_1;
        this.line_2 = line_2;
        this.postcode = postcode;
        this.county = county;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLine_1() {
        return line_1;
    }

    public void setLine_1(String line_1) {
        this.line_1 = line_1;
    }

    public String getLine_2() {
        return line_2;
    }

    public void setLine_2(String line_2) {
        this.line_2 = line_2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
