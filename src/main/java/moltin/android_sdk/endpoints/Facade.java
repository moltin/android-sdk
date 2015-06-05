package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the generic methods of all endpoints
abstract class Facade extends HttpMethodAbstract {

    private String plural="";
    private String single="";
    private Preferences preferences;
    protected Authenticate authenticate;
    private JSONObject jsonHeaders;
    private String endpoint="";

    protected Facade(String plural, String single, Preferences preferences)
    {
        this.plural=plural;
        this.single=single;
        this.preferences=preferences;
        this.authenticate=new Authenticate(this.preferences);
    }

    protected String getPlural()
    {
        return plural;
    }

    protected String getSingle()
    {
        return single;
    }

    protected JSONObject getJsonFromArray(String[][] array) throws Exception {
        if(array==null || array.length==0)
        {
            return null;
        }
        else if(array!=null && array[0].length==2)
        {
            JSONObject json=new JSONObject();
            for(int i=0;i<array.length;i++)
            {
                json.put(array[i][0],array[i][1]);
            }

            return json;
        }
        else
        {
            throw new Exception("Incorrect data. Only two columns (second dimension) allowed for array (key,value)");
        }
    }

    protected JSONObject getHeaders()
    {
        try{
            jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");
            jsonHeaders.put("Authorization", "Bearer " + preferences.getToken());
            if(preferences.getCurrencyId().length()>0)
                jsonHeaders.put("X-Currency", preferences.getCurrencyId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return jsonHeaders;
    }

    protected Preferences getPreferences()
    {
        return preferences;
    }

    protected void get(final String id,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = plural + "/" + id;

                        Facade.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    protected void create(final JSONObject data,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = single;

                        Facade.super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, data, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    protected void update(final String id,final JSONObject data,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = single + "/" + id;

                        Facade.super.httpPutAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, data, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    protected void delete(final String id,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = single + "/" + id;

                        Facade.super.httpDeleteAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }endpoint = single + "/" + id;

            super.httpDeleteAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, callback);
    }

    protected void find(final JSONObject terms,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = single;

                        Facade.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), terms, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    protected void listing(final JSONObject terms,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = single;

                        Facade.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), terms, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    protected void fields(final String id,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        endpoint = plural + "/" + (id!=null && id.length()>0 ? id + "/fields" : "fields");

                        Facade.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else
                {
                    callback.handleMessage(msg);
                    return false;
                }
            }
        };

        if(preferences.isExpired() && !preferences.getToken().equals(""))
        {
            new Authenticate(preferences).authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }
}
