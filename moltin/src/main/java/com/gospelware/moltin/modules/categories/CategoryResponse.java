package com.gospelware.moltin.modules.categories;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.modules.products.IncludedProducts;

/**
 * Created by lewis on 06/03/2017.
 */

public class CategoryResponse extends BaseResponse {

    private IncludedProducts included;
    private Category data;

    public IncludedProducts getIncluded() {
        return included;
    }

    public void setIncluded(IncludedProducts included) {
        this.included = included;
    }

    public Category getData() {
        return data;
    }

    public void setData(Category data) {
        this.data = data;
    }
}
