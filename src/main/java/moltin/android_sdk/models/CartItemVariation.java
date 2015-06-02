package moltin.android_sdk.models;

import org.json.JSONObject;

public class CartItemVariation {

    private String modifierId=null;
    private String variationId=null;

    public CartItemVariation()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(modifierId!=null && variationId!=null) json.put("modifier["+modifierId+"]",variationId);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public String getVariationId() {
        return variationId;
    }

    public void setVariationId(String variationId) {
        this.variationId = variationId;
    }
}
