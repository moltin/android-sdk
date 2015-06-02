package moltin.android_sdk.models;

import org.json.JSONObject;

public class Pagination {

    private Integer total=null;
    private Integer current=null;
    private Integer limit=null;
    private Integer offset=null;
    private Integer from=null;
    private Integer to=null;

    public Pagination()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(total!=null) json.put("total",total);
            if(current!=null) json.put("current",current);
            if(limit!=null) json.put("limit",limit);
            if(offset!=null) json.put("offset",offset);
            if(from!=null) json.put("from",from);
            if(to!=null) json.put("to",to);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
