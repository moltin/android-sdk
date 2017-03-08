package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;

import rx.Observable;

/**
 * Created by lewis on 02/03/2017.
 */

public class Carts {

    private static Api api;

    public Carts(Api api){
        this.api = api;
    }

    public static Observable<BrandResponse> create(MoltinQuery query, String uuid){
        return api.getBrandById(query, uuid);
    }
}
