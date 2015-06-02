package moltin.android_sdk.models;

import org.json.JSONObject;

public class Product {

    private String id=null;
    private String sku=null;
    private String title=null;
    private String slug=null;
    private Float price=null;
    private Float sale_price=null;
    private String status=null;
    private String category=null;
    private Integer stock_level=null;
    private Integer stock_status=null;

    public Product()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(sku!=null) json.put("sku",sku);
            if(title!=null) json.put("title",title);
            if(slug!=null) json.put("slug",slug);
            if(price!=null) json.put("price",price);
            if(sale_price!=null) json.put("sale_price",sale_price);
            if(status!=null) json.put("status",status);
            if(category!=null) json.put("category",category);
            if(stock_level!=null) json.put("stock_level",stock_level);
            if(stock_status!=null) json.put("stock_status",stock_status);
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSale_price() {
        return sale_price;
    }

    public void setSale_price(Float sale_price) {
        this.sale_price = sale_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock_level() {
        return stock_level;
    }

    public void setStock_level(Integer stock_level) {
        this.stock_level = stock_level;
    }

    public Integer getStock_status() {
        return stock_status;
    }

    public void setStock_status(Integer stock_status) {
        this.stock_status = stock_status;
    }
}
