package moltin.android_sdk.models;

import org.json.JSONObject;

public class Order {

    private String id=null;
    private String customer=null;
    private String gateway=null;
    private String status=null;
    private Float subtotal=null;
    private Float shipping_price=null;
    private Float total=null;
    private Integer currency=null;
    private String currency_code=null;
    private Float exchange_rate=null;
    private String bill_to=null;
    private String ship_to=null;
    private String shipping=null;

    public Order()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(customer!=null) json.put("customer",customer);
            if(gateway!=null) json.put("gateway",gateway);
            if(status!=null) json.put("status",status);
            if(subtotal!=null) json.put("subtotal",subtotal);
            if(shipping_price!=null) json.put("shipping_price",shipping_price);
            if(total!=null) json.put("total",total);
            if(currency!=null) json.put("currency",currency);
            if(currency_code!=null) json.put("currency_code",currency_code);
            if(exchange_rate!=null) json.put("exchange_rate",exchange_rate);
            if(bill_to!=null) json.put("bill_to",bill_to);
            if(ship_to!=null) json.put("ship_to",ship_to);
            if(shipping!=null) json.put("shipping",shipping);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getShipping_price() {
        return shipping_price;
    }

    public void setShipping_price(Float shipping_price) {
        this.shipping_price = shipping_price;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public Float getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(Float exchange_rate) {
        this.exchange_rate = exchange_rate;
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

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
}
