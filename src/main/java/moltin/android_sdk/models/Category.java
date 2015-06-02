package moltin.android_sdk.models;

import org.json.JSONObject;

public class Category {

    private Integer id=null;
    private String parent=null;
    private String title=null;
    private String slug=null;
    private String status=null;
    private String description=null;

    public Category()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(parent!=null) json.put("parent",parent);
            if(title!=null) json.put("title",title);
            if(slug!=null) json.put("slug",slug);
            if(status!=null) json.put("status",status);
            if(description!=null) json.put("description",description);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
