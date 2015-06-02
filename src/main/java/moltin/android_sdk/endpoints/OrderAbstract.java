package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import moltin.android_sdk.models.*;
import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling API calls for the endpoint
public class OrderAbstract extends HttpMethodAbstract {

    public Preferences preferences;

    public OrderAbstract(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public void get(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "orders/" + id;

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void find(moltin.android_sdk.models.Order terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "orders";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, (terms==null ? null : terms.getData()), callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void list(Pagination terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "orders";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, (terms==null ? null : terms.getData()), callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void create(moltin.android_sdk.models.Order data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "orders";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, (data==null ? null : data.getData()), callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
