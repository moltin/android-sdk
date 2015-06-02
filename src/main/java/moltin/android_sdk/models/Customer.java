package moltin.android_sdk.models;

import org.json.JSONObject;

public class Customer {

    private String id=null;
    private String first_name=null;
    private String last_name=null;
    private String email=null;
    private History history=null;

    public Customer()
    {

    }

    public Customer(Object object)
    {
        this((JSONObject)object);
    }

    public Customer(JSONObject json)
    {
        try
        {
            if(json.has("id") && !json.isNull("id"))
                id = (String)json.get("id");

            if(json.has("first_name") && !json.isNull("first_name"))
                first_name = (String)json.get("first_name");

            if(json.has("last_name") && !json.isNull("last_name"))
                last_name = (String)json.get("last_name");

            if(json.has("email") && !json.isNull("email"))
                email = (String)json.get("email");

            if(json.has("history") && !json.isNull("history"))
                history = new History(json.getJSONObject("history"));
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
            if(id!=null) json.put("id",id);
            if(first_name!=null) json.put("first_name",first_name);
            if(last_name!=null) json.put("last_name",last_name);
            if(email!=null) json.put("email",email);
            if(history!=null) json.put("history",history.getData());
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
