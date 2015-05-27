package in.molt.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import java.util.UUID;

import in.molt.android_sdk.utilities.Constants;
import in.molt.android_sdk.utilities.Preferences;

//handling API calls for the endpoint
public class CartAbstract extends HttpMethodAbstract {

    public Preferences preferences;

    public CartAbstract(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public String getIdentifier(){
        try
        {
            String cartId=preferences.getCartId();

            if(cartId.equals(""))
            {
                cartId = UUID.randomUUID().toString().replace("-","");
                preferences.setCartId(cartId);
            }

            return cartId;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void contents(Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId();

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

    public void insert(String id, Integer qty, String mods, Handler.Callback callback) throws Exception {
        try
        {
            if(qty==null || qty<0)
                qty=1;

            JSONObject jsonData = new JSONObject();
            jsonData.put("id",id);
            jsonData.put("quantity",qty);
            jsonData.put("modifier",mods);

            String endpoint = "cart/" + preferences.getCartId();

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, jsonData, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void update(String id, JSONObject data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId() + "/item/" + id;

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpPutAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, data, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId();

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpDeleteAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void remove(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId() + "/item/" + id;

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpDeleteAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void item(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId() + "/item/" + id;

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

    public void inCart(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId() + "/has/" + id;

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

    public void checkout(Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId() + "/checkout";

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

    public void complete(JSONObject data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "cart/" + preferences.getCartId() + "/checkout";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, data, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
