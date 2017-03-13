package com.gospelware.moltin.modules.orders;

/**
 * Created by lewis on 13/03/2017.
 */

public class CheckoutRequest {

    private CheckoutRequestData data;

    public CheckoutRequest() {
    }

    public CheckoutRequest(CheckoutRequestData data) {
        this.data = data;
    }

    public CheckoutRequestData getData() {
        return data;
    }

    public void setData(CheckoutRequestData data) {
        this.data = data;
    }

    private class CheckoutRequestData{
        private Customer customer;
        private BillingAddress billingAddress;
        private ShippingAddress shippingAddress;

        public CheckoutRequestData() {
        }

        public CheckoutRequestData(Customer customer, BillingAddress billingAddress, ShippingAddress shippingAddress) {
            this.customer = customer;
            this.billingAddress = billingAddress;
            this.shippingAddress = shippingAddress;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public BillingAddress getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(BillingAddress billingAddress) {
            this.billingAddress = billingAddress;
        }

        public ShippingAddress getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
        }
    }

}
