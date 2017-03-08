package com.gospelware.moltin.modules.currencies;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.Links;

import java.util.ArrayList;

/**
 * Created by lewis on 08/03/2017.
 */

public class CurrenciesResponse extends BaseResponse {

    private ArrayList<Currency> data;

    public ArrayList<Currency> getData() {
        return data;
    }

    public void setData(ArrayList<Currency> data) {
        this.data = data;
    }
}
