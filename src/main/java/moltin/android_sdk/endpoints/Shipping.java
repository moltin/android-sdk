package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint
public class Shipping extends ShippingAbstract {

    public Shipping(Preferences preferences)
    {
        super(preferences);
    }

    @Override
    public void get(final String id, final Handler.Callback callback) throws Exception {
        if(preferences.isExpired())
        {
            Authenticate authenticate = new Authenticate(preferences);

            Handler.Callback callbackForAuth = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == Constants.RESULT_OK)
                    {
                        try {
                            Shipping.super.get(id, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {
                        try {
                            Shipping.super.get(id, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                }
            };

            authenticate.authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            super.get(id, callback);
        }
    }

    @Override
    public void list(final moltin.android_sdk.models.Shipping terms, final Handler.Callback callback) throws Exception {
        if(preferences.isExpired())
        {
            Authenticate authenticate = new Authenticate(preferences);

            Handler.Callback callbackForAuth = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == Constants.RESULT_OK)
                    {
                        try {
                            Shipping.super.list(terms, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {
                        try {
                            Shipping.super.list(terms, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                }
            };

            authenticate.authenticateAsync(preferences.getPublicId(),callbackForAuth);
        }
        else
        {
            super.list(terms, callback);
        }
    }
}
