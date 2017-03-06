package com.gospelware.moltin;

/**
 * Created by lewis on 24/02/2017.
 */

public class Price {

    public Integer amount;
    public String currency;
    public Boolean includesTax;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getIncludesTax() {
        return includesTax;
    }

    public void setIncludesTax(Boolean includesTax) {
        this.includesTax = includesTax;
    }
}
