package moltin.android_sdk.models;

import org.json.JSONObject;

public class Shipping {

    private String id=null;
    private String title=null;
    private String slug=null;
    private String company=null;
    private Integer status=null;
    private Float price=null;
    private Float price_min=null;
    private Float price_max=null;
    private Float weight_min=null;
    private Float weight_max=null;
    private String description=null;
    private Integer tax_band=null;

    public Shipping()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(title!=null) json.put("title",title);
            if(slug!=null) json.put("slug",slug);
            if(company!=null) json.put("company",company);
            if(status!=null) json.put("status",status);
            if(price!=null) json.put("price",price);
            if(price_min!=null) json.put("price_min",price_min);
            if(price_max!=null) json.put("price_max",price_max);
            if(weight_min!=null) json.put("weight_min",weight_min);
            if(weight_max!=null) json.put("weight_max",weight_max);
            if(description!=null) json.put("description",description);
            if(tax_band!=null) json.put("tax_band",tax_band);
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice_min() {
        return price_min;
    }

    public void setPrice_min(Float price_min) {
        this.price_min = price_min;
    }

    public Float getPrice_max() {
        return price_max;
    }

    public void setPrice_max(Float price_max) {
        this.price_max = price_max;
    }

    public Float getWeight_min() {
        return weight_min;
    }

    public void setWeight_min(Float weight_min) {
        this.weight_min = weight_min;
    }

    public Float getWeight_max() {
        return weight_max;
    }

    public void setWeight_max(Float weight_max) {
        this.weight_max = weight_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTax_band() {
        return tax_band;
    }

    public void setTax_band(Integer tax_band) {
        this.tax_band = tax_band;
    }
}
