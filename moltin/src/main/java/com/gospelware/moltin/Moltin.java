package com.gospelware.moltin;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gospelware.moltin.modules.Brands;
import com.gospelware.moltin.modules.Categories;
import com.gospelware.moltin.modules.Collections;
import com.gospelware.moltin.modules.Currencies;
import com.gospelware.moltin.modules.Files;
import com.gospelware.moltin.modules.Products;
import com.gospelware.moltin.modules.CategoryTree;
import com.gospelware.moltin.modules.Carts;
import com.gospelware.moltin.modules.Checkout;

import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;

public class Moltin {

    private Api api;
    private Gson gson;
    private Preferences preferences;

    public static Products Products;
    public static Brands Brands;
    public static Categories Categories;
    public static CategoryTree CategoryTree;
    public static Collections Collections;
    public static Files Files;
    public static Currencies Currencies;
    public static Carts Carts;
    public static Checkout Checkout;

    public static final String GRANT_TYPE  = "implicit";

    public Moltin(Preferences preferences) {
        if(preferences == null){
            throw new NullPointerException("You must provide a Preferences object to use Moltin.");
        } else {
            this.preferences = preferences;
        }

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        this.api = new Api(preferences, gson);
        this.Products = new Products(this.api);
        this.Brands = new Brands(this.api);
        this.Categories = new Categories(this.api);
        this.CategoryTree = new CategoryTree(this.api);
        this.Collections = new Collections(this.api);
        this.Files = new Files(this.api);
        this.Currencies = new Currencies(this.api);
        this.Carts = new Carts(this.api);
        this.Checkout = new Checkout(this.api);
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

    public static ArrayList<BaseResponse.JsonApiErrorResponse>  getErrorsFromResponse(Throwable e){

        if(e instanceof HttpException){
            Response response = ((HttpException)e).response();
            try{
                String errorResponse = response.errorBody().string().toString();

                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create();

                BaseResponse res = gson.fromJson(errorResponse, BaseResponse.class);
                if(res != null){
                    return res.getErrors();
                }
            } catch (Exception exception){
                e.printStackTrace();
            }
        }

        return null;
    }


}
