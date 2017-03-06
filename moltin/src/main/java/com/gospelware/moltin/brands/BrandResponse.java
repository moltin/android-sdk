package com.gospelware.moltin.brands;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.Product;

import java.util.ArrayList;

/**
 * Created by lewis on 02/03/2017.
 */

public class BrandResponse extends BaseResponse{

    private BrandResponseIncludes includes;
    private Brand data;

    public BrandResponseIncludes getIncludes() {
        return includes;
    }

    public void setIncludes(BrandResponseIncludes includes) {
        this.includes = includes;
    }

    public class BrandResponseIncludes{

        private ArrayList<Product> products;

        public ArrayList<Product> getProducts() {
            return products;
        }

        public void setProducts(ArrayList<Product> products) {
            this.products = products;
        }
    }

}
