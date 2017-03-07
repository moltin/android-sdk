package com.gospelware.moltin;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.gospelware.moltin.modules.CategoryTree;
import com.gospelware.moltin.modules.brands.Brand;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;
import com.gospelware.moltin.modules.categories.CategoriesResponse;
import com.gospelware.moltin.modules.categories.CategoryResponse;
import com.gospelware.moltin.modules.categories.CategoryTreeResponse;
import com.gospelware.moltin.modules.collections.CollectionResponse;
import com.gospelware.moltin.modules.collections.CollectionsResponse;
import com.gospelware.moltin.modules.files.FileResponse;
import com.gospelware.moltin.modules.files.FilesResponse;
import com.gospelware.moltin.modules.products.ProductResponse;
import com.gospelware.moltin.modules.products.ProductsResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by lewis on 06/02/2017.
 */

public class Api {

    private Preferences preferences;
    private ApiInterface service;
    private AccessTokenResponse accessToken;
    private Gson gson;

    public Api(Preferences preferences) {

        service = createRetrofitService(ApiInterface.class, preferences.getEndpoint(), null);

        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        this.preferences = preferences;
    }


    <T> T createRetrofitService(final Class<T> clazz, final String endPoint, final String token) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);
        Retrofit retrofit = null;

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request;

                Request.Builder builder = original.newBuilder();
                builder.header("Content-Type", "application/x-www-form-urlencoded")
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());

                if(token != null){
                    builder.header("Authorization", "Bearer " + token);
                }
                request = builder.build();

                return chain.proceed(request);
            }
        });

        httpClient.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response;
            }
        });

        Gson gson = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Product.class, new ProductDeserializer())
                .registerTypeAdapter(BrandDeserializer.class, new BrandDeserializer())
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.build())
                .build();


        retrofit.create(clazz);
        return retrofit.create(clazz);

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
        this.service = createRetrofitService(ApiInterface.class, preferences.getEndpoint(), accessToken.getAccessToken());
    }

    public Observable<AccessTokenResponse> login(String clientId, String grantType){
        return service.login(clientId, grantType);
    }

    public Observable<ProductsResponse> getProducts(MoltinQuery query_string){
        return service.getProducts(preferences.getCurrency(), preferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<ProductResponse> getProduct(MoltinQuery query_string, String id){
        return service.getProduct(preferences.getCurrency(), preferences.getLanguage(), query_string.getQueryMap(), id);
    }

    public Observable<BrandsResponse> getBrands(MoltinQuery query_string){
        return service.getBrands(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<BrandResponse> getBrandById(MoltinQuery query_string, String uuid){
        return service.getBrandById(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CategoriesResponse> getCategories(MoltinQuery query_string){
        return service.getCategories(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CategoryResponse> getCategoryById(MoltinQuery query_string, String uuid){
        return service.getCategoryById(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<CategoryTreeResponse> getCategoryTree(MoltinQuery query_string){
        return service.getCategoryTree(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CollectionsResponse> getCollections(MoltinQuery query_string){
        return service.getCollections(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<CollectionResponse> getCollectionById(MoltinQuery query_string, String uuid){
        return service.getCollectionById(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public Observable<FilesResponse> getFiles(MoltinQuery query_string){
        return service.getFiles(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap());
    }

    public Observable<FileResponse> getFileById(MoltinQuery query_string, String uuid){
        return service.getFileById(preferences.getLocale(), preferences.getLanguage(), query_string.getQueryMap(), uuid);
    }

    public interface ApiInterface {

        @FormUrlEncoded
        @POST("/oauth/access_token")
        Observable<AccessTokenResponse> login(@Field("client_id") String clientId, @Field("grant_type") String grantType);


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

    }



}
