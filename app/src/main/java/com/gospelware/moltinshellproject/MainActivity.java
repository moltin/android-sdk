package com.gospelware.moltinshellproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.gospelware.moltin.AccessTokenResponse;
import com.gospelware.moltin.Moltin;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.Preferences;
import com.gospelware.moltin.brands.BrandsResponse;
import com.gospelware.moltin.products.ProductResponse;
import com.gospelware.moltin.products.ProductsResponse;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String CLIENT_ID = "B7H9MthG8jYduHlGrmKnqO613XCEvsrZ6bwSYo1TWM";
    public static final String API_ENDPOINT = "https://api.moltin.com";

    Moltin moltinApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Preferences preferences = new Preferences("GBP", "", API_ENDPOINT, CLIENT_ID,"");

        moltinApi = new Moltin(preferences);

        Observable<AccessTokenResponse> response = moltinApi.requestAuthentication();
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<AccessTokenResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                handleAccessTokenError(e);
            }

            @Override
            public void onNext(AccessTokenResponse accessTokenResponse) {
                handleAccessToken(accessTokenResponse);
            }
        });

        ((Button) findViewById(R.id.button_get_products)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getProducts();
            }
        });

//        ((Button) findViewById(R.id.button_get_product_attributes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getProductAttributes();
//            }
//        });

        ((Button) findViewById(R.id.button_get_brands)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getBrandById();
            }
        });


        //Moltin.Product.getAll()
    }

    private void handleAccessToken(AccessTokenResponse response){
        moltinApi.setAccessToken(response);
    }

    private void getProductAttributes(){
//        Observable<ProductAttributesResponse> response = moltinApi.Products.getAttributes(new MoltinQuery());
//        response.subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<ProductAttributesResponse>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(ProductAttributesResponse response){
//
//                        if(response.data.size() > 0){
//                            getProductById(response.data.get(0).getLabel());
//                        }
//                        //Log.e("hello","Baseresponse:" + response.data.size());
//                    }
//                });
    }

    private void getProducts(){
        Observable<ProductsResponse> response = moltinApi.Products.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ProductsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ProductsResponse response){

                        if(response.data.size() > 0){
                            getProductById(response.data.get(0).getId());
                        }
                        //Log.e("hello","Baseresponse:" + response.data.size());
                    }
                });
    }

    private void getProductById(String id){
        Observable<ProductResponse> response = moltinApi.Products.get(new MoltinQuery(), id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ProductResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ProductResponse response){
                        Log.e("hello","Baseresponse:" + response.data.getName());
                    }
                });
    }

    private void getBrands(){
        Observable<BrandsResponse> response = moltinApi.Brands.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<BrandsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BrandsResponse response){
                        Log.e("hello","Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getBrandById(){
        String brand_now_tv = "ddb86543-b151-48ce-b6ce-e6ee046d146d";

        Observable<BrandsResponse> response = moltinApi.Brands.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<BrandsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BrandsResponse response){
                        Log.e("hello","Baseresponse:" + response.getData().size());
                    }
                });
    }

//    private void deleteProductById(String id){
//        Observable<ProductResponse> response = moltinApi.Products.delete(id);
//        response.subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<ProductResponse>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(ProductResponse response){
//                        Log.e("hello","Baseresponse:" + response.data.getName());
//                    }
//                });
//    }

    private void handleAccessTokenError(Throwable e){
        e.printStackTrace();
        Toast.makeText(this,"Error authenticating", Toast.LENGTH_SHORT);
    }

    private void handleProductsResponse(JsonObject products){
       // for(Product p : products.data){
            Log.i("LEWIS","Product: " + products.toString());
        //}
    }
}
