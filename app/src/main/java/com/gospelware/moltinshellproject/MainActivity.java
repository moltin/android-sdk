package com.gospelware.moltinshellproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.gospelware.moltin.AccessTokenResponse;
import com.gospelware.moltin.Moltin;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.Preferences;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;
import com.gospelware.moltin.modules.carts.CartItem;
import com.gospelware.moltin.modules.carts.CartItemsResponse;
import com.gospelware.moltin.modules.carts.CartResponse;
import com.gospelware.moltin.modules.categories.CategoriesResponse;
import com.gospelware.moltin.modules.categories.CategoryResponse;
import com.gospelware.moltin.modules.categories.CategoryTreeResponse;
import com.gospelware.moltin.modules.collections.CollectionsResponse;
import com.gospelware.moltin.modules.currencies.CurrenciesResponse;
import com.gospelware.moltin.modules.currencies.CurrencyResponse;
import com.gospelware.moltin.modules.files.FileResponse;
import com.gospelware.moltin.modules.files.FilesResponse;
import com.gospelware.moltin.modules.orders.BillingAddress;
import com.gospelware.moltin.modules.orders.CheckoutRequest;
import com.gospelware.moltin.modules.orders.CheckoutResponse;
import com.gospelware.moltin.modules.orders.Customer;
import com.gospelware.moltin.modules.orders.ShippingAddress;
import com.gospelware.moltin.modules.products.ProductResponse;
import com.gospelware.moltin.modules.products.ProductsResponse;

import java.util.UUID;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String DEBUG_TAG = "MoltinTest";
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


        ((Button) findViewById(R.id.button_get_categories)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCategories();
            }
        });

        ((Button) findViewById(R.id.button_get_category)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCategoryById();
            }
        });

        ((Button) findViewById(R.id.button_get_category_tree)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCategoryTree();
            }
        });


        ((Button) findViewById(R.id.button_get_collections)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCollections();
            }
        });

        ((Button) findViewById(R.id.button_get_files)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFiles();
            }
        });

        ((Button) findViewById(R.id.button_get_single_file)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFile();
            }
        });

        ((Button) findViewById(R.id.button_get_currencies)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrencies();
            }
        });

        ((Button) findViewById(R.id.button_get_currency)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrencyById();
            }
        });

        ((Button) findViewById(R.id.button_create_cart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCart();
            }
        });

        ((Button) findViewById(R.id.button_get_cart_items)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCartItems();
            }
        });

        ((Button) findViewById(R.id.button_add_item)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemToCart();
            }
        });

        ((Button) findViewById(R.id.button_delete_item)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItem();
            }
        });

        ((Button) findViewById(R.id.button_modify_item)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateItems();
            }
        });

        ((Button) findViewById(R.id.button_checkout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkoutCart();
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
//                        //Log.e(DEBUG_TAG,"Baseresponse:" + response.data.size());
//                    }
//                });
    }

    private void getCollections(){
        Observable<CollectionsResponse> response = moltinApi.Collections.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CollectionsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CollectionsResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
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
                        //Log.e(DEBUG_TAG,"Baseresponse:" + response.data.size());
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
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.data.getName());
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
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getBrandById(){
        String brand_now_tv = "ddb86543-b151-48ce-b6ce-e6ee046d146d";

        Observable<BrandResponse> response = moltinApi.Brands.getById(new MoltinQuery(), brand_now_tv);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<BrandResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BrandResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().getName());
                    }
                });
    }

    private void getCategories(){

        Observable<CategoriesResponse> response = moltinApi.Categories.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CategoriesResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CategoriesResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getCategoryById(){
        String id = "5bc59e6a-5ea4-4828-833c-b94f7456b67a";

        Observable<CategoryResponse> response = moltinApi.Categories.getById(new MoltinQuery(), id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CategoryResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CategoryResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().getName());
                    }
                });
    }

    private void getCategoryTree(){
       Observable<CategoryTreeResponse> response = moltinApi.CategoryTree.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CategoryTreeResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CategoryTreeResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getFiles(){
        Observable<FilesResponse> response = moltinApi.Files.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<FilesResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(FilesResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getFile(){
        String file = "000cf298-762b-459b-9178-a17507acaf9e";
        Observable<FileResponse> response = moltinApi.Files.getById(new MoltinQuery(), file);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<FileResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(FileResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().getFileSize());
                    }
                });
    }

    private void getCurrencies(){
        Observable<CurrenciesResponse> response = moltinApi.Currencies.getAll(new MoltinQuery());
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CurrenciesResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CurrenciesResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getCurrencyById(){
        String id = "8617f801-0ced-452a-a19d-206444e70897";
        Observable<CurrencyResponse> response = moltinApi.Currencies.getById(new MoltinQuery(),id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CurrencyResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CurrencyResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().getCode());
                    }
                });
    }

    private void createCart(){
        String id = UUID.randomUUID().toString();
        Observable<CartResponse> response = moltinApi.Carts.create(new MoltinQuery(),id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CartResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CartResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().getId());
                    }
                });
    }

    private void addItemToCart(){
        String id = "c612d0c6-31d8-460b-a3d3-f080cf782999";
        String cartId = "73c27dec-50d8-48cf-ada6-b76206a72dea";
        CartItem item = new CartItem();
        item.setId(id);
        item.setQuantity(2);

        Observable<CartItemsResponse> response = moltinApi.Carts.addItemByReference(cartId, item);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CartItemsResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CartItemsResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void getCartItems(){
        String id = "73c27dec-50d8-48cf-ada6-b76206a72dea";
        Observable<CartItemsResponse> response = moltinApi.Carts.getItems(id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CartItemsResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CartItemsResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void deleteItem(){
        String cartId = "73c27dec-50d8-48cf-ada6-b76206a72dea";
        String id = "4c1642c4-631b-4e1d-b7b2-0fbcb77b56a1";
        Observable<CartItemsResponse> response = moltinApi.Carts.deleteItem(cartId, id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CartItemsResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CartItemsResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void updateItems(){

        String cartId = "73c27dec-50d8-48cf-ada6-b76206a72dea";
        String id = "61b6d1fe-3db9-420c-b4ee-a71980fa04e9";
        String productId = "c612d0c6-31d8-460b-a3d3-f080cf782999";
        CartItem item = new CartItem();
        item.setId(productId);
        item.setQuantity(5);

        Observable<CartItemsResponse> response = moltinApi.Carts.updateItemQuantity(cartId, item, id);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CartItemsResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CartItemsResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData().size());
                    }
                });
    }

    private void checkoutCart(){

        String cartId = "73c27dec-50d8-48cf-ada6-b76206a72dea";

        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        Customer customer = new Customer();
        billingAddress.setFirstName("Jimmy");
        billingAddress.setLastName("R");
        billingAddress.setLine_1("26 Grey Street");
        billingAddress.setCountry("United Kingdom");
        billingAddress.setPostcode("NE8 6QW");
        billingAddress.setCounty("Tyne and Wear");
        shippingAddress.setLine_1("26 Grey Street");
        shippingAddress.setCounty("Tyne and wear");
        shippingAddress.setCountry("United Kingdom");
        shippingAddress.setPostcode("NE8 6QW");
        shippingAddress.setFirstName("Jimmy");
        shippingAddress.setLastName("R");

        customer.setEmail("test@test.com");
        customer.setName("Jimmy R");

        CheckoutRequest data = new CheckoutRequest(customer, billingAddress, shippingAddress);


        Observable<CheckoutResponse> response = moltinApi.Checkout.performCheckout(cartId, data);
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CheckoutResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CheckoutResponse response){
                        Log.e(DEBUG_TAG,"Baseresponse:" + response.getData());
                    }
                });
    }

    private void handleAccessTokenError(Throwable e){
        e.printStackTrace();
        Toast.makeText(this,"Error authenticating", Toast.LENGTH_SHORT);
    }
}
