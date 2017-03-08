package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.currencies.CurrenciesResponse;
import com.gospelware.moltin.modules.currencies.CurrencyResponse;
import com.gospelware.moltin.modules.files.FileResponse;
import com.gospelware.moltin.modules.files.FilesResponse;

import rx.Observable;

/**
 * Created by lewis on 07/03/2017.
 */

public class Currencies {

    private static Api api;

    public Currencies(Api api){
        this.api = api;
    }

    public static Observable<CurrenciesResponse> getAll(MoltinQuery query){
        return api.getCurrencies(query);
    }

    public static Observable<CurrencyResponse> getById(MoltinQuery query, String uuid){
        return api.getCurrencyById(query, uuid);
    }
}
