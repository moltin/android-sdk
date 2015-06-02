package moltin.android_sdk.models;

import org.json.JSONObject;

/**
 * Created by user on 02/06/15.
 */
public class CartCustomerCheckout {

    private String customer=null;
    private Integer shipping=null;
    private String gateway=null;
    private String bill_to=null;
    private String ship_to=null;

    public CartCustomerCheckout()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(customer!=null) json.put("customer",customer);
            if(shipping!=null) json.put("shipping",shipping);
            if(gateway!=null) json.put("gateway",gateway);
            if(bill_to!=null) json.put("bill_to",bill_to);
            if(ship_to!=null) json.put("ship_to",ship_to);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getBill_to() {
        return bill_to;
    }

    public void setBill_to(String bill_to) {
        this.bill_to = bill_to;
    }

    public String getShip_to() {
        return ship_to;
    }

    public void setShip_to(String ship_to) {
        this.ship_to = ship_to;
    }
}
