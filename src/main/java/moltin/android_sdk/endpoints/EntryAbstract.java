package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import moltin.android_sdk.models.Pagination;
import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling API calls for the endpoint
public class EntryAbstract extends HttpMethodAbstract {

    public Preferences preferences;

    public EntryAbstract(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public void get(String flow, String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "flows/" + flow + "/entries/" + id;

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

    public void find(String flow, Pagination terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "flows/" + flow + "/entries";

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

    public void list(String flow, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "flows/" + flow + "/entries";

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
}
