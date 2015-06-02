package moltin.android_sdk.models;

import org.json.JSONObject;

public class Cart {

    private String id=null;
    private Integer quantity=null;
    private Float price=null;
    private Float weight=null;
    private Float height=null;
    private Float width=null;
    private Float depth=null;
    private String name=null;

    public Cart()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(name!=null) json.put("name",name);
            if(quantity!=null) json.put("quantity",quantity);
            if(price!=null) json.put("price",price);
            if(weight!=null) json.put("weight",weight);
            if(height!=null) json.put("height",height);
            if(width!=null) json.put("width",width);
            if(depth!=null) json.put("depth",depth);
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
