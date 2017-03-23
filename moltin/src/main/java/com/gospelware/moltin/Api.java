package com.gospelware.moltin;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.gospelware.moltin.modules.brands.Brand;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;
import com.gospelware.moltin.modules.carts.CartItemRequest;
import com.gospelware.moltin.modules.carts.CartItemsResponse;
import com.gospelware.moltin.modules.carts.CartResponse;
import com.gospelware.moltin.modules.categories.CategoriesResponse;
import com.gospelware.moltin.modules.categories.CategoryResponse;
import com.gospelware.moltin.modules.categories.CategoryTreeResponse;
import com.gospelware.moltin.modules.collections.CollectionResponse;
import com.gospelware.moltin.modules.collections.CollectionsResponse;
import com.gospelware.moltin.modules.currencies.CurrenciesResponse;
import com.gospelware.moltin.modules.currencies.CurrencyResponse;
import com.gospelware.moltin.modules.files.FileResponse;
import com.gospelware.moltin.modules.files.FilesResponse;
import com.gospelware.moltin.modules.orders.CheckoutRequest;
import com.gospelware.moltin.modules.orders.CheckoutResponse;
import com.gospelware.moltin.modules.products.ProductResponse;
import com.gospelware.moltin.modules.products.ProductsResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by lewis on 06/02/2017.
 */

public class Api {

    private MoltinPreferences moltinPreferences;
    private ApiInterface service;
    private AccessTokenResponse accessToken;
    private Gson gson;
    public static final String GRANT_TYPE  = "implicit";
    public static final String API_ENDPOINT = "https://api.moltin.com";
    private String clientId;

    public Api(MoltinPreferences moltinPreferences, Gson gson) {

        service = createRetrofitService(ApiInterface.class, API_ENDPOINT, null);
        this.gson = gson;
        this.moltinPreferences = moltinPreferences;
        this.clientId = moltinPreferences.getClientId();
    }

    public MoltinPreferences getMoltinPreferences() {
        return moltinPreferences;
    }

    <T> T createRetrofitService(final Class<T> clazz, final String endPoint, final String token) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(logging);
        Retrofit retrofit = null;

        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request;

                Request.Builder builder = original.newBuilder();
                builder.header("Content-Type", "application/x-www-form-urlencoded")
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());

                if(token != null){

                    try{
                        if (tokenIsValid() == false){
                            refreshToken(httpClientBuilder.build());
                        } else {
                            builder.header("Authorization", "Bearer " + token);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                request = builder.build();
                Response response = chain.proceed(request);
                return response;
            }
        });

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Product.class, new ProductDeserializer())
                .registerTypeAdapter(BrandDeserializer.class, new BrandDeserializer())
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClientBuilder.build())
                .build();


        retrofit.create(clazz);
        return retrofit.create(clazz);
    }

    private void refreshToken(OkHttpClient httpClient) throws Exception{
        RequestBody formBody = new FormBody.Builder()
                .add("client_id", moltinPreferences.getClientId())
                .add("grant_type", GRANT_TYPE)
                .build();

        Request newRequest = new Request.Builder().url(API_ENDPOINT + "/oauth/access_token")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .post(formBody)
                .build();

        try{

            Response resp = httpClient.newCall(newRequest).execute();
            String s = resp.body().string();
            AccessTokenResponse response = gson.fromJson(s, AccessTokenResponse.class);
            this.accessToken = response;

        } catch (Exception e){
            throw new Exception("Error refreshing access token");
        }

    }

    public Boolean tokenIsValid(){
        Long currentTime = System.currentTimeMillis()/1000;

        if(accessToken == null){
            return null;
        }

        if(currentTime > accessToken.getExpires()){
            return false;
        } else {
            return true;
        }
    }

    public Gson getGson() {
        return gson;
    }

    public class ProductDeserializer implements JsonDeserializer<Product> {

        @Override
        public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            Product response = gson.fromJson(json, Product.class);
            response.setRawJson(json);

            return response;
        }
    }

    public class BrandDeserializer implements JsonDeserializer<Brand> {

        @Override
        public Brand deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            Brand response = gson.fromJson(json, Brand.class);
            response.setRawJson(json);

            return response;
        }
    }

    public boolean isAuthenticated(){
        if(this.accessToken == null){
            return false;
        } else if (this.accessToken.isValid()){
            return false;
        } else {
            return true;
        }
    }

    public AccessTokenResponse getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessTokenResponse accessToken) {
        this.accessToken = accessToken;
        this.service = createRetrofitService(ApiInterface.class, API_ENDPOINT, accessToken.getAccessToken());
    }

    public Observable<AccessTokenResponse> login(){
        return service.login(this.moltinPreferences.getClientId(), GRANT_TYPE);
    }

    public Observable<ProductsResponse> getProducts(MoltinQuery query_string){
        return service.getProducts(moltinPreferences.getCurrency(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<ProductResponse> getProduct(MoltinQuery query_string, String id){
        return service.getProduct(moltinPreferences.getCurrency(), moltinPreferences.getLanguage(), query_string.getQueryMap(), id);
    }

    public Observable<BrandsResponse> getBrands(MoltinQuery query_string){
        return service.getBrands(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<BrandResponse> getBrandById(MoltinQuery query_string, String uuid){
        return service.getBrandById(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CategoriesResponse> getCategories(MoltinQuery query_string){
        return service.getCategories(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CategoryResponse> getCategoryById(MoltinQuery query_string, String uuid){
        return service.getCategoryById(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CategoryTreeResponse> getCategoryTree(MoltinQuery query_string){
        return service.getCategoryTree(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CollectionsResponse> getCollections(MoltinQuery query_string){
        return service.getCollections(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CollectionResponse> getCollectionById(MoltinQuery query_string, String uuid){
        return service.getCollectionById(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<FilesResponse> getFiles(MoltinQuery query_string){
        return service.getFiles(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<FileResponse> getFileById(MoltinQuery query_string, String uuid){
        return service.getFileById(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CurrenciesResponse> getCurrencies(MoltinQuery query_string){
        return service.getCurrencies(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CurrencyResponse> getCurrencyById(MoltinQuery query_string, String uuid){
        return service.getCurrencyById(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CartResponse> createCartWithId(MoltinQuery query_string, String uuid){
        return service.createCartWithId(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CartItemsResponse> getItemsInCart(String uuid){
        return service.getItemsInCart(moltinPreferences.getLocale(), moltinPreferences.getLanguage(), uuid);
    }

    public Observable<CartItemsResponse> addItemToCart(String reference, CartItemRequest item){
        return service.addItemToCart(reference, item);
    }

    public Observable<CartItemsResponse> deleteItemFromCart(String reference, String item_id){
        return service.deleteItem(reference, item_id);
    }

    public Observable<CartItemsResponse> updateItemQuantity(String reference, CartItemRequest item, String item_id){
        return service.updateItemQuantity(reference, item_id, item);
    }

    public Observable<CheckoutResponse> checkoutOrder(String reference, CheckoutRequest body){
        return service.checkoutOrder(reference, body);
    }

    public interface ApiInterface {

        @FormUrlEncoded
        @POST("/oauth/access_token")
        Observable<AccessTokenResponse> login(@Field("client_id") String clientId, @Field("grant_type") String grantType);

        @FormUrlEncoded
        @POST("/oauth/access_token")
        AccessTokenResponse synchronousLogin(@Field("client_id") String clientId, @Field("grant_type") String grantType);


        @GET("/v2/products")
        Observable<ProductsResponse> getProducts(
                @Header("X-MOLTIN-CURRENCY") String currency,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/products/{uuid}")
        Observable<ProductResponse> getProduct(
                @Header("X-MOLTIN-CURRENCY") String currency,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("uuid") String uuid
        );


        @GET("/v2/brands")
        Observable<BrandsResponse> getBrands(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/brands/{uuid}")
        Observable<BrandResponse> getBrandById(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("uuid") String uuid
        );

        @GET("/v2/categories")
        Observable<CategoriesResponse> getCategories(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/categories/{uuid}")
        Observable<CategoryResponse> getCategoryById(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("uuid") String uuid
        );

        @GET("/v2/categories/tree")
        Observable<CategoryTreeResponse> getCategoryTree(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/collections")
        Observable<CollectionsResponse> getCollections(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/collections/{uuid}")
        Observable<CollectionResponse> getCollectionById(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("uuid") String uuid
        );

        @GET("/v2/files")
        Observable<FilesResponse> getFiles(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/files/{uuid}")
        Observable<FileResponse> getFileById(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("uuid") String uuid
        );

        @GET("/v2/currencies")
        Observable<CurrenciesResponse> getCurrencies(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString
        );

        @GET("/v2/currencies/{uuid}")
        Observable<CurrencyResponse> getCurrencyById(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("uuid") String uuid
        );

        @GET("/v2/carts/{reference}")
        Observable<CartResponse> createCartWithId(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @QueryMap Map<String, String> queryString,
                @Path("reference") String uuid
        );

        @GET("/v2/carts/{reference}/items")
        Observable<CartItemsResponse> getItemsInCart(
                @Header("X-MOLTIN-LOCALE") String locale,
                @Header("X-MOLTIN-LANGUAGE") String language,
                @Path("reference") String uuid
        );

        @POST("/v2/carts/{reference}/items")
        @Headers("Content-Type: application/json")
        Observable<CartItemsResponse> addItemToCart(
                @Path("reference") String uuid,
                @Body CartItemRequest item
        );

        @DELETE("/v2/carts/{reference}/items/{item_id}")
        Observable<CartItemsResponse> deleteItem(
                @Path("reference") String reference,
                @Path("item_id") String item_id
        );

        @PUT("/v2/carts/{reference}/items/{item_id}")
        @Headers("Content-Type: application/json")
        Observable<CartItemsResponse> updateItemQuantity(
                @Path("reference") String reference,
                @Path("item_id") String item_id,
                @Body CartItemRequest item
        );

        @POST("/v2/carts/{reference}/checkout")
        @Headers("Content-Type: application/json")
        Observable<CheckoutResponse> checkoutOrder (
                @Path("reference") String reference,
                @Body CheckoutRequest body
        );

    }



}
