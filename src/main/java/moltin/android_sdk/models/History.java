package moltin.android_sdk.models;

import org.json.JSONObject;

public class History {

    private Integer orders=null;
    private Double value=null;

    public History()
    {

    }

    public History(Object object)
    {
        this((JSONObject)object);
    }

    public History(JSONObject json)
    {
        try
        {
            if(json.has("orders") && !json.isNull("orders"))
                orders = (Integer)json.get("orders");

            if(json.has("value") && !json.isNull("value"))
                value = (Double)json.get("value");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(orders!=null) json.put("orders",orders);
            if(value!=null) json.put("value",value);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
