package com.gospelware.moltin.brands;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.Product;

import java.util.ArrayList;

/**
 * Created by lewis on 02/03/2017.
 */

public class BrandsResponse extends BaseResponse{

    private BrandResponseIncludes includes;
    private ArrayList<Brand> data;

    public BrandResponseIncludes getIncludes() {
        return includes;
    }

    public void setIncludes(BrandResponseIncludes includes) {
        this.includes = includes;
    }

    public ArrayList<Brand> getData() {
        return data;
    }

    public void setData(ArrayList<Brand> data) {
        this.data = data;
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
