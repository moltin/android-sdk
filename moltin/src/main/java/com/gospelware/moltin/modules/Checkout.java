package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;
import com.gospelware.moltin.modules.orders.CheckoutRequest;
import com.gospelware.moltin.modules.orders.CheckoutResponse;

import rx.Observable;

/**
 * Created by lewis on 14/03/2017.
 */

public class Checkout {

    private static Api api;

    public Checkout(Api api){
        this.api = api;
    }

    public static Observable<CheckoutResponse> performCheckout(String reference, CheckoutRequest body){
        return api.checkoutOrder(reference, body);
    }

}