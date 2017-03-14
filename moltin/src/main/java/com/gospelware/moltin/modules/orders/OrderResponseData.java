package com.gospelware.moltin.modules.orders;

/**
 * Created by lewis on 14/03/2017.
 */

public class OrderResponseData {

    private String gateway;
    private String method;
    private String payment;

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
