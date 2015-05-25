package in.molt.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import in.molt.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint
public class Product extends ProductAbstract {

    public Product(Preferences preferences)
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
                    if (msg.what == 1)
                    {
                        try {
                            Product.super.get(id, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {

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
}
