package com.gospelware.moltin;
import android.content.Context;

import com.google.gson.JsonObject;

import rx.Observable;

public class Moltin {

    private Api api;
    private Preferences preferences;

    public static Products Products;
    public static Brands Brands;

    public static final String GRANT_TYPE  = "implicit";

    public Moltin(Preferences preferences) {
        if(preferences == null){
            throw new NullPointerException("You must provide a Preferences object to use Moltin.");
        } else {
            this.preferences = preferences;
        }

        this.api = new Api(preferences);
        this.Products = new Products(this.api);
        this.Brands = new Brands(this.api);
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public Observable<AccessTokenResponse> requestAuthentication(){
        return this.api.login(preferences.getClientId(), GRANT_TYPE);
    }

    public void setAccessToken(AccessTokenResponse accessToken){
        this.api.setAccessToken(accessToken);
    }

    public boolean isAuthenticated(){
        return this.api.isAuthenticated();
    }





    
//    public String getCurrency(){
//        return currency;
//    }

//    public Api with(Context context){
//
//        if (context == null) {
//            throw new IllegalArgumentException("Context cannot be null");
//        }
//
//        if(this.api == null){
//            this.api = new Api(API_ENDPOINT);
//        }
//
//        return api;
//    }
}
