package moltin.android_sdk.models;

import org.json.JSONObject;

public class Tax {

    private String id=null;
    private String title=null;
    private String description=null;
    private Float rate=null;

    public Tax()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(title!=null) json.put("title",title);
            if(description!=null) json.put("description",description);
            if(rate!=null) json.put("rate",rate);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
