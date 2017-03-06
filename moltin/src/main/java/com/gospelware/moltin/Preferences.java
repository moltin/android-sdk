package com.gospelware.moltin;

/**
 * Created by lewis on 28/02/2017.
 */

public class Preferences {

    private String currency;
    private String language;
    private String endpoint;
    private String clientId;
    private String locale;

    public Preferences(String currency, String language, String endpoint, String clientId, String locale) {
        this.currency = currency;
        this.language = language;
        this.endpoint = endpoint;
        this.clientId = clientId;
        this.locale = locale;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
