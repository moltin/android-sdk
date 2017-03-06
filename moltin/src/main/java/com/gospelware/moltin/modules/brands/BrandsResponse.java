package com.gospelware.moltin.modules.brands;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.modules.products.IncludedProducts;

import java.util.ArrayList;

/**
 * Created by lewis on 02/03/2017.
 */

public class BrandsResponse extends BaseResponse{

    private IncludedProducts included;
    private ArrayList<Brand> data;

    public ArrayList<Brand> getData() {
        return data;
    }

    public void setData(ArrayList<Brand> data) {
        this.data = data;
    }

    public IncludedProducts getIncluded() {
        return included;
    }

    public void setIncluded(IncludedProducts included) {
        this.included = included;
    }
}
