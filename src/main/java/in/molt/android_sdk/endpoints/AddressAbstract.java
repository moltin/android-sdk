package in.molt.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import in.molt.android_sdk.utilities.Constants;
import in.molt.android_sdk.utilities.Preferences;

//handling API calls for the endpoint
public abstract class AddressAbstract extends HttpMethodAbstract {

    public Preferences preferences;

    public AddressAbstract(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public void get(String customer, String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "customer/" + customer + "/address/" + id;

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void find(String customer, JSONObject terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "customer/" + customer + "/address";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, terms, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void list(String customer, JSONObject terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "customer/" + customer + "/addresses";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, terms, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void create(String customer, JSONObject data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "customer/" + customer + "/address";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());

            super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, data, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void fields(String customer, String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "";

            if (customer == null || customer.length()==0) {
                customer = "";
            }
            if (id == null || id.length()==0) {
                id = "";
            }
            if (customer.length()>0 && id.length()==0) {
                endpoint = "customer/" + customer + "/address/fields";
            } else if (customer.length()>0 && id.length()>0) {
                endpoint = "customer/" + customer + "/address/" + id + "/fields";
            } else {
                endpoint = "address/fields";
            }

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
