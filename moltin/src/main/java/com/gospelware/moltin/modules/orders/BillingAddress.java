package com.gospelware.moltin.modules.orders;

/**
 * Created by lewis on 13/03/2017.
 */

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String line1;
    private String line2;
    private String postcode;
    private String county;
    private String country;

    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String line1, String line2, String postcode, String county, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.line1 = line1;
        this.line2 = line2;
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
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
