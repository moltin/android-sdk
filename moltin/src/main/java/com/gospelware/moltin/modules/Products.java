package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.products.ProductResponse;
import com.gospelware.moltin.modules.products.ProductsResponse;

import rx.Observable;

/**
 * Created by lewis on 28/02/2017.
 */

public class Products {

    private static Api api;

    public Products(Api api){
        this.api = api;
    }

    public static Observable<ProductsResponse> getAll(MoltinQuery query){
        return api.getProducts(query);
    }

    public static Observable<ProductResponse> get(MoltinQuery query, String id){
        return api.getProduct(query, id);
    }

}
