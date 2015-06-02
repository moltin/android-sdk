package moltin.android_sdk.models;

import org.json.JSONArray;
import org.json.JSONObject;

public class Address {

    private String id=null;
    private String save_as=null;
    private String company=null;
    private String first_name=null;
    private String last_name=null;
    private String email=null;
    private String phone=null;
    private String address_1=null;
    private String address_2=null;
    private String city=null;
    private String county=null;
    private String postcode=null;
    private String country=null;

    public Address()
    {

    }

    public Address(Object object) throws Exception {
        this((JSONObject)object);
    }

    public Address(JSONObject json) throws Exception {
        try
        {
            if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && !json.isNull("result") && json.get("result") instanceof JSONObject)
            {
                json = json.getJSONObject("result");
            }
            if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && !json.isNull("result") && json.getJSONArray("result").length()==1)
            {
                json = json.getJSONArray("result").getJSONObject(0);
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && !json.isNull("result") && json.getJSONArray("result").length()>1)
            {
                throw new Exception("multiple items, expected single item to parse");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && !json.isNull("result") && json.getJSONArray("result").length()<1)
            {
                throw new Exception("zero items, expected single item to parse");
            }
            else if(json.has("status") && !json.isNull("status") && json.get("status") instanceof Boolean && json.getBoolean("status") && json.has("result") && json.get("result") instanceof JSONArray && json.isNull("result"))
            {
                throw new Exception("no items to parse");
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

            if(json.has("save_as") && !json.isNull("save_as"))
                save_as = (String)json.get("save_as");

            if(json.has("company") && !json.isNull("company"))
                company = (String)json.get("company");

            if(json.has("first_name") && !json.isNull("first_name"))
                first_name = (String)json.get("first_name");

            if(json.has("last_name") && !json.isNull("last_name"))
                last_name = (String)json.get("last_name");

            if(json.has("email") && !json.isNull("email"))
                email = (String)json.get("email");

            if(json.has("phone") && !json.isNull("phone"))
                phone = (String)json.get("phone");

            if(json.has("address_1") && !json.isNull("address_1"))
                address_1 = (String)json.get("address_1");

            if(json.has("address_2") && !json.isNull("address_2"))
                address_2 = (String)json.get("address_2");

            if(json.has("city") && !json.isNull("city"))
                city = (String)json.get("city");

            if(json.has("county") && !json.isNull("county"))
                county = (String)json.get("county");

            if(json.has("postcode") && !json.isNull("postcode"))
                postcode = (String)json.get("postcode");

            /*if(json.has("country") && !json.isNull("country"))
                country = new Country(json.getJSONObject("country"));*/

            /*if(json.has("customer") && !json.isNull("customer"))
                customer = new Customer(json.getJSONObject("customer"));*/
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
            if(save_as!=null) json.put("save_as",save_as);
            if(company!=null) json.put("company",company);
            if(first_name!=null) json.put("first_name",first_name);
            if(last_name!=null) json.put("last_name",last_name);
            if(email!=null) json.put("email",email);
            if(phone!=null) json.put("phone",phone);
            if(address_1!=null) json.put("address_1",address_1);
            if(address_2!=null) json.put("address_2",address_2);
            if(city!=null) json.put("city",city);
            if(county!=null) json.put("county",county);
            if(postcode!=null) json.put("postcode",postcode);
            if(country!=null) json.put("country",country);
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

    public String getSave_as() {
        return save_as;
    }

    public void setSave_as(String save_as) {
        this.save_as = save_as;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
