package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Checkout extends Facade {

    public Checkout(Preferences preferences)
    {
        super("checkout","checkout",preferences);
    }

    public void payment(String method, String order, String[][] data, Handler.Callback callback) throws Exception {
        payment(method, order, super.getJsonFromArray(data), callback);
    }

    public void payment(final String method, final String order, final JSONObject data, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "checkout/payment/" + method + "/" + order;

                        Checkout.super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, Checkout.super.getHeaders(), null, data, callback);
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

        if(Checkout.super.getPreferences().isExpired() && !Checkout.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Checkout.super.getPreferences();
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
