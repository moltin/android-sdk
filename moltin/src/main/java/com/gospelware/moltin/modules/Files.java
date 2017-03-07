package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.collections.CollectionsResponse;
import com.gospelware.moltin.modules.files.FilesResponse;

import rx.Observable;

/**
 * Created by lewis on 07/03/2017.
 */

public class Files {

    private static Api api;

    public Files(Api api){
        this.api = api;
    }

    public static Observable<FilesResponse> getAll(MoltinQuery query){
        return api.getFiles(query);
    }
}
