package moltin.android_sdk.models;

import org.json.JSONObject;

public class Checkout {

    private CheckoutPayment paymentData=null;
    private String ip=null;
    private String return_url=null;
    private String cancel_url=null;

    public Checkout()
    {

    }

    public JSONObject getData()
    {
        try
        {
            JSONObject json = new JSONObject();
            if(paymentData!=null) json.put("data",paymentData.getData());
            if(ip!=null) json.put("ip",ip);
            if(return_url!=null) json.put("return_url",return_url);
            if(cancel_url!=null) json.put("cancel_url",cancel_url);
            return json;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public CheckoutPayment getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(CheckoutPayment paymentData) {
        this.paymentData = paymentData;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getCancel_url() {
        return cancel_url;
    }

    public void setCancel_url(String cancel_url) {
        this.cancel_url = cancel_url;
    }
}
