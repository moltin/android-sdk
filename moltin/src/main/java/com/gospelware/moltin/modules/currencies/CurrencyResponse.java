package com.gospelware.moltin.modules.currencies;

import com.gospelware.moltin.BaseResponse;

import java.util.ArrayList;

/**
 * Created by lewis on 08/03/2017.
 */

public class CurrencyResponse extends BaseResponse {

    private Currency data;

    public Currency getData() {
        return data;
    }

    public void setData(Currency data) {
        this.data = data;
    }
}
