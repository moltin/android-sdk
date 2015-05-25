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
}
