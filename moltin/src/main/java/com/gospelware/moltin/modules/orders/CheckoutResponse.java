package com.gospelware.moltin.modules.orders;

import com.gospelware.moltin.BaseResponse;
import com.gospelware.moltin.modules.carts.DisplayPriceWrapper;
import com.gospelware.moltin.modules.gateways.Gateway;
import com.gospelware.moltin.modules.meta.TimestampMeta;

import java.util.ArrayList;

/**
 * Created by lewis on 13/03/2017.
 */

public class CheckoutResponse extends BaseResponse {

    private Order data;

    public Order getData() {
        return data;
    }

    public void setData(Order data) {
        this.data = data;
    }

    private class Order {

        private String type;
        private String id;
        private String status;
        private String shipping;
        private Customer customer;
        private ShippingAddress shippingAddress;
        private BillingAddress billingAddress;
        private OrderMeta meta;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShipping() {
            return shipping;
        }

        public void setShipping(String shipping) {
            this.shipping = shipping;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public ShippingAddress getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public BillingAddress getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(BillingAddress billingAddress) {
            this.billingAddress = billingAddress;
        }

        public OrderMeta getMeta() {
            return meta;
        }

        public void setMeta(OrderMeta meta) {
            this.meta = meta;
        }
    }

    private class OrderMeta{
        private DisplayPriceWrapper value;
        private CartOrderCountMeta counts;
        private TimestampMeta timestamps;
        private ArrayList<Gateway> gateways;
    }

    private class CartOrderCountMeta{
        private CartOrderCountMetaData products;

        public CartOrderCountMetaData getProducts() {
            return products;
        }

        public void setProducts(CartOrderCountMetaData products) {
            this.products = products;
        }
    }

    private class CartOrderCountMetaData{
        private Integer total;
        private Integer unique;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getUnique() {
            return unique;
        }

        public void setUnique(Integer unique) {
            this.unique = unique;
        }
    }
}
