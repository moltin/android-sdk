package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.categories.CategoryResponse;
import com.gospelware.moltin.modules.files.FileResponse;
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

    public static Observable<FileResponse> getById(MoltinQuery query, String uuid){
        return api.getFileById(query, uuid);
    }
}
