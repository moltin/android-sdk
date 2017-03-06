package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.categories.CategoriesResponse;
import com.gospelware.moltin.modules.categories.CategoryResponse;
import com.gospelware.moltin.modules.categories.CategoryTreeResponse;

import rx.Observable;

/**
 * Created by lewis on 06/03/2017.
 */

public class CategoryTree {

    private static Api api;

    public CategoryTree(Api api){
        this.api = api;
    }

    public static Observable<CategoryTreeResponse> getAll(MoltinQuery query){
        return api.getCategoryTree(query);
    }
}
