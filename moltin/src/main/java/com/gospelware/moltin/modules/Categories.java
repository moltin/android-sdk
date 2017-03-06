package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.categories.CategoriesResponse;
import com.gospelware.moltin.modules.categories.CategoryResponse;

import rx.Observable;

/**
 * Created by lewis on 06/03/2017.
 */

public class Categories {

    private static Api api;

    public Categories(Api api){
        this.api = api;
    }

    public static Observable<CategoriesResponse> getAll(MoltinQuery query){
        return api.getCategories(query);
    }

    public static Observable<CategoryResponse> getById(MoltinQuery query, String uuid){
        return api.getCategoryById(query, uuid);
    }
}
