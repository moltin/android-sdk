package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import java.util.Iterator;

import moltin.android_sdk.models.Pagination;
import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling API calls for the endpoint
public class ProductAbstract extends HttpMethodAbstract {

    public Preferences preferences;

    public ProductAbstract(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public void get(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "products/" + id;

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

    public void find(moltin.android_sdk.models.Product terms, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "products";

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

    public void list(Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "products";

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

    public void search(Pagination termsPagination, moltin.android_sdk.models.Product termsProduct, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "products/search";

            JSONObject merged = null;

            if(termsPagination!=null && termsProduct!=null)
            {
                merged = new JSONObject();
                JSONObject[] objs = new JSONObject[] { termsPagination.getData(), termsProduct.getData() };

                int i=0;

                for (JSONObject obj : objs) {
                    Iterator it = obj.keys();
                    while (it.hasNext()) {
                        String key = (String)it.next();
                        merged.put(key, obj.get(key));
                        i++;
                    }
                }

                if(i==0)
                    merged=null;
            }
            else if(termsPagination!=null)
            {
                merged = termsPagination.getData();
            }
            else if(termsProduct!=null)
            {
                merged = termsProduct.getData();
            }


            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());

            super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, jsonHeaders, merged, callback);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void fields(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "";

            if (id == null || id.length()==0) {
                id = "";
            }

            endpoint = "products/" + (id.length()>0 ? id + "/fields" : "fields");

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

    public void modifiers(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "products/" + id + "/modifiers";

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

    public void variations(String id, Handler.Callback callback) throws Exception {
        try
        {
            String endpoint = "products/" + id + "/variations";

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