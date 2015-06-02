package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import java.util.UUID;

import moltin.android_sdk.models.CartCustomerCheckout;
import moltin.android_sdk.models.CartItemVariation;
import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

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

    public void setIdentifier(String cartId){
        try
        {
            preferences.setCartId(cartId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contents(Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "carts/" + getIdentifier();

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

    public void insertItem(moltin.android_sdk.models.Cart data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "carts/" + getIdentifier();

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

    public void insertVariation(String id, Integer qty, CartItemVariation[] mods, Handler.Callback callback) throws Exception {
        try
        {
            if(qty==null || qty<0)
                qty=1;

            JSONObject jsonData = new JSONObject();
            if(id!=null)
                jsonData.put("id",id);

            jsonData.put("quantity",qty);

            JSONObject jsonMods = new JSONObject();
            for(int i=0;i<mods.length;i++)
            {
                //jsonMods.put("modifier["+mods[i].getModifierId()+"]",mods[i].getVariationId());
                jsonMods.put(mods[i].getModifierId(),mods[i].getVariationId());
            }
            if(jsonMods!=null)
                jsonData.put("modifier",jsonMods);

            String endpoint = "carts/" + getIdentifier();

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

    public void update(String id, moltin.android_sdk.models.Cart data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "carts/" + getIdentifier() + "/items/" + id;

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpPutAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, null, (data==null ? null : data.getData()), callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "carts/" + preferences.getCartId();

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
            String endpoint = "carts/" + getIdentifier() + "/items/" + id;

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
            String endpoint = "carts/" + getIdentifier() + "/items/" + id;

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
            String endpoint = "carts/" + getIdentifier() + "/has/" + id;

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

    public void checkout(CartCustomerCheckout data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "carts/" + getIdentifier() + "/checkout";

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, (data==null ? null : data.getData()), callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void complete(CartCustomerCheckout data, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "carts/" + getIdentifier() + "/checkout";

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
