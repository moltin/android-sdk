package moltin.android_sdk.models;

import org.json.JSONObject;

public class Currency {

    private String id=null;
    private String code=null;
    private String title=null;
    private Boolean enabled=null;
    private String modifier=null;
    private Float exchange_rate=null;
    private String format=null;
    private String decimal_point=null;
    private String thousand_point=null;
    private String rounding=null;
    private Boolean default_usage=null;

    public Currency()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(id!=null) json.put("id",id);
            if(code!=null) json.put("code",code);
            if(title!=null) json.put("title",title);
            if(enabled!=null) json.put("enabled",enabled);
            if(modifier!=null) json.put("modifier",modifier);
            if(exchange_rate!=null) json.put("exchange_rate",exchange_rate);
            if(format!=null) json.put("format",format);
            if(decimal_point!=null) json.put("decimal_point",decimal_point);
            if(thousand_point!=null) json.put("thousand_point",thousand_point);
            if(rounding!=null) json.put("rounding",rounding);
            if(default_usage!=null) json.put("default",default_usage);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Float getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(Float exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDecimal_point() {
        return decimal_point;
    }

    public void setDecimal_point(String decimal_point) {
        this.decimal_point = decimal_point;
    }

    public String getThousand_point() {
        return thousand_point;
    }

    public void setThousand_point(String thousand_point) {
        this.thousand_point = thousand_point;
    }

    public String getRounding() {
        return rounding;
    }

    public void setRounding(String rounding) {
        this.rounding = rounding;
    }

    public Boolean getDefault_usage() {
        return default_usage;
    }

    public void setDefault_usage(Boolean default_usage) {
        this.default_usage = default_usage;
    }
}
