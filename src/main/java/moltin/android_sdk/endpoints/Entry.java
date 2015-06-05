package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Entry extends Facade {

    public Entry(Preferences preferences)
    {
        super("flows","flows",preferences);
    }

    public void get(final String flow, final String id, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "flows/" + flow + "/entries/" + id;

                        Entry.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Entry.super.getHeaders(), null, callback);
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

        if(Entry.super.getPreferences().isExpired() && !Entry.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Entry.super.getPreferences()).authenticateAsync(Entry.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void find(String flow, String[][] terms, Handler.Callback callback) throws Exception {
        find(flow, super.getJsonFromArray(terms), callback);
    }

    public void find(final String flow, final JSONObject terms, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "flows/" + flow + "/entries/search";

                        Entry.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Entry.super.getHeaders(), terms, callback);
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

        if(Entry.super.getPreferences().isExpired() && !Entry.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Entry.super.getPreferences()).authenticateAsync(Entry.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void listing(String flow, String[][] terms, Handler.Callback callback) throws Exception {
        listing(flow, super.getJsonFromArray(terms), callback);
    }

    public void listing(final String flow, final JSONObject terms, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "flows/" + flow + "/entries";

                        Entry.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Entry.super.getHeaders(), terms, callback);
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

        if(Entry.super.getPreferences().isExpired() && !Entry.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Entry.super.getPreferences()).authenticateAsync(Entry.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }
}
