package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;

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
