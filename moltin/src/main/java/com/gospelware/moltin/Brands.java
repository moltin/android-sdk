package com.gospelware.moltin;

import com.gospelware.moltin.brands.BrandResponse;
import com.gospelware.moltin.brands.BrandsResponse;

import rx.Observable;

/**
 * Created by lewis on 02/03/2017.
 */

public class Brands {

    private static Api api;

    public Brands(Api api){
        this.api = api;
    }

    public static Observable<BrandsResponse> getAll(MoltinQuery query){
        return api.getBrands(query);
    }

    public static Observable<BrandResponse> getById(MoltinQuery query, String uuid){
        return api.getBrandById(query, uuid);
    }
}
