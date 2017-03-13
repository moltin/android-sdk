package com.gospelware.moltin.modules;

import com.gospelware.moltin.Api;
import com.gospelware.moltin.MoltinQuery;
import com.gospelware.moltin.modules.brands.BrandResponse;
import com.gospelware.moltin.modules.brands.BrandsResponse;
import com.gospelware.moltin.modules.carts.CartItem;
import com.gospelware.moltin.modules.carts.CartItemRequest;
import com.gospelware.moltin.modules.carts.CartItemsResponse;
import com.gospelware.moltin.modules.carts.CartResponse;

import rx.Observable;

/**
 * Created by lewis on 02/03/2017.
 */

public class Carts {

    private static Api api;

    public Carts(Api api){
        this.api = api;
    }

    public static Observable<CartResponse> create(MoltinQuery query, String uuid){
        return api.createCartWithId(query, uuid);
    }

    public static Observable<CartItemsResponse> addItemByReference(String uuid, CartItem item){
        CartItemRequest request = new CartItemRequest();
        request.setData(item);
        return api.addItemToCart(uuid, request);
    }

    public static Observable<CartItemsResponse> getItems(String cart_reference){
        return api.getItemsInCart(cart_reference);
    }

    public static Observable<CartItemsResponse> deleteItem(String cart_reference, String cart_item_id){
        return api.deleteItemFromCart(cart_reference, cart_item_id);
    }

    public static Observable<CartItemsResponse> updateItemQuantity(String cart_reference, CartItem item, String item_id){
        CartItemRequest request = new CartItemRequest();
        request.setData(item);
        return api.updateItemQuantity(cart_reference, request, item_id);
    }
}
