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

    public Cart(Object object) throws Exception {
        this((JSONObject)object);
    }

    public Cart(JSONObject json) throws Exception {
        try
        {
            if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("item") && !json.isNull("item") && json.get("item") instanceof JSONObject)
            {
                json = json.getJSONObject("item");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("contents") && !json.isNull("contents"))
            {
                throw new Exception("multiple items, expected single item to parse");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && !json.isNull("result"))
            {
                throw new Exception("multiple items, expected single item to parse");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && !json.getBoolean("status") && json.has("errors") && !json.isNull("errors"))
            {
                String errors="status is false";
                for(int i=0;i<json.getJSONArray("errors").length();i++)
                {
                    errors += "\n" + json.getJSONArray("errors").getString(i);
                }
                throw new Exception(errors);
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && !json.getBoolean("status") && json.has("error") && !json.isNull("error"))
            {
                throw new Exception(json.getString("error"));
            }

            if(json.has("id") && !json.isNull("id"))
                id = (String)json.get("id");

            if(json.has("quantity") && !json.isNull("quantity"))
                quantity = (Integer)json.get("quantity");

            /*if(json.has("sku") && !json.isNull("sku"))
                sku = (String)json.get("sku");

            if(json.has("title") && !json.isNull("title"))
                title = (String)json.get("title");

            if(json.has("slug") && !json.isNull("slug"))
                slug = (String)json.get("slug");

            if(json.has("price") && !json.isNull("price"))
                price = (Float)json.get("price");

            if(json.has("sale_price") && !json.isNull("sale_price"))
                sale_price = (Float)json.get("sale_price");*/

            /*if(json.has("status") && !json.isNull("status"))
                status = new Status(json.getJSONObject("status"));*/

            /*if(json.has("category") && !json.isNull("category"))
                category = new Category(json.getJSONObject("category"));*/

            /*if(json.has("stock_level") && !json.isNull("stock_level"))
                stock_level = (Integer)json.get("stock_level");*/

            /*if(json.has("stock_status") && !json.isNull("stock_status"))
                stock_status = new StockStatus(json.getJSONObject("stock_status"));*/

            if(json.has("weight") && !json.isNull("weight"))
                weight = (Float)json.get("weight");

            if(json.has("height") && !json.isNull("height"))
                height = (Float)json.get("height");

            if(json.has("width") && !json.isNull("width"))
                width = (Float)json.get("width");

            if(json.has("depth") && !json.isNull("depth"))
                depth = (Float)json.get("depth");

            /*if(json.has("description") && !json.isNull("description"))
                description = (String)json.get("description");*/

            if(json.has("name") && !json.isNull("name"))
                name = (String)json.get("name");

            /*if(json.has("tax") && !json.isNull("tax"))
                tax = (Float)json.get("tax");

            if(json.has("total") && !json.isNull("total"))
                total = (Float)json.get("total");

            if(json.has("total_before_tax") && !json.isNull("total_before_tax"))
                total_before_tax = (Float)json.get("total_before_tax");*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
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
