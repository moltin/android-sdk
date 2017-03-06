package com.gospelware.moltin;

import com.gospelware.moltin.products.DeleteProductResponse;
import com.gospelware.moltin.products.ProductAttributesResponse;
import com.gospelware.moltin.products.ProductResponse;
import com.gospelware.moltin.products.ProductsResponse;

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

//    public static Observable<ProductAttributesResponse> getAttributes(MoltinQuery query){
//        return api.getProductAttributes(query);
//    }
//
//    public static Observable<DeleteProductResponse> delete(MoltinQuery query, String uuid){
//        return api.deleteProduct(query, uuid);
//    }
}
