package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.categories.CategoryTreeResponse;
import com.gospelware.moltin.modules.collections.CollectionsResponse;

import rx.Observable;

/**
 * Created by lewis on 07/03/2017.
 */

public class Collections {

    private static Api api;

    public Collections(Api api){
        this.api = api;
    }

    public static Observable<CollectionsResponse> getAll(MoltinQuery query){
        return api.getCollections(query);
    }
}
