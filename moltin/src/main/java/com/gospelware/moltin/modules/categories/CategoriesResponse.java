package com.gospelware.moltin.modules.categories;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.modules.products.IncludedProducts;

import java.util.ArrayList;

/**
 * Created by lewis on 06/03/2017.
 */

public class CategoriesResponse extends BaseResponse {

    private IncludedProducts included;
    private ArrayList<Category> data;

    public IncludedProducts getIncluded() {
        return included;
    }

    public void setIncluded(IncludedProducts included) {
        this.included = included;
    }

    public ArrayList<Category> getData() {
        return data;
    }

    public void setData(ArrayList<Category> data) {
        this.data = data;
    }
}
