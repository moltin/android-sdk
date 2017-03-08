package com.gospelware.moltin.modules.meta;

/**
 * Created by lewis on 08/03/2017.
 */

public class DisplayPrice {

    private Integer amount;
    private String currency;
    private String formatted;

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

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
