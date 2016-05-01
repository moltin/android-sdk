package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Gateway extends Facade {

    public Gateway(Preferences preferences)
    {
        super("gateways","gateways",preferences);
    }

    @Override
    public void get(final String slug, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "gateways/" + slug;

                        Gateway.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Gateway.super.getHeaders(), null, callback);
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

        if(Gateway.super.getPreferences().isExpired() && !Gateway.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Gateway.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void listing(final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "gateways";

                        Gateway.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Gateway.super.getHeaders(), null, callback);
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

        if(Gateway.super.getPreferences().isExpired() && !Gateway.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Gateway.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }
}
