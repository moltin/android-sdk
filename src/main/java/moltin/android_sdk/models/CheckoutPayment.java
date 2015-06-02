package moltin.android_sdk.models;

import org.json.JSONObject;

public class CheckoutPayment {

    private Integer number=null;
    private Integer expiry_month=null;
    private Integer expiry_year=null;
    private Integer start_month=null;
    private Integer start_year=null;
    private Integer cvv=null;
    private Integer issue_number=null;
    private String type=null;

    public CheckoutPayment()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(number!=null) json.put("number",number);
            if(expiry_month!=null) json.put("expiry_month",expiry_month);
            if(expiry_year!=null) json.put("expiry_year",expiry_year);
            if(start_month!=null) json.put("start_month",start_month);
            if(start_year!=null) json.put("start_year",start_year);
            if(cvv!=null) json.put("cvv",cvv);
            if(issue_number!=null) json.put("issue_number",issue_number);
            if(type!=null) json.put("type",type);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(Integer expiry_month) {
        this.expiry_month = expiry_month;
    }

    public Integer getExpiry_year() {
        return expiry_year;
    }

    public void setExpiry_year(Integer expiry_year) {
        this.expiry_year = expiry_year;
    }

    public Integer getStart_month() {
        return start_month;
    }

    public void setStart_month(Integer start_month) {
        this.start_month = start_month;
    }

    public Integer getStart_year() {
        return start_year;
    }

    public void setStart_year(Integer start_year) {
        this.start_year = start_year;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getIssue_number() {
        return issue_number;
    }

    public void setIssue_number(Integer issue_number) {
        this.issue_number = issue_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
