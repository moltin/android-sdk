package com.gospelware.moltin;

/**
 * Created by lewis on 28/02/2017.
 */

public class MoltinPreferences {

    private String currency;
    private String language;
    private String clientId;
    private String locale;

    public MoltinPreferences(String currency, String language, String clientId, String locale) {
        this.currency = currency;
        this.language = language;
        this.clientId = clientId;
        this.locale = locale;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
