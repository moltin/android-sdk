package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import moltin.android_sdk.models.Pagination;
import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint
public class Order extends OrderAbstract {

    public Order(Preferences preferences)
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
                            Order.super.get(id, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {
                        try {
                            Order.super.get(id, callback);
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
    public void find(final moltin.android_sdk.models.Order terms, final Handler.Callback callback) throws Exception {
        if(preferences.isExpired())
        {
            Authenticate authenticate = new Authenticate(preferences);

            Handler.Callback callbackForAuth = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == Constants.RESULT_OK)
                    {
                        try {
                            Order.super.find(terms, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {
                        try {
                            Order.super.find(terms, callback);
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
            super.find(terms, callback);
        }
    }

    @Override
    public void list(final Pagination terms, final Handler.Callback callback) throws Exception {
        if(preferences.isExpired())
        {
            Authenticate authenticate = new Authenticate(preferences);

            Handler.Callback callbackForAuth = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == Constants.RESULT_OK)
                    {
                        try {
                            Order.super.list(terms, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {
                        try {
                            Order.super.list(terms, callback);
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

    @Override
    public void create(final moltin.android_sdk.models.Order data, final Handler.Callback callback) throws Exception {
        if(preferences.isExpired())
        {
            Authenticate authenticate = new Authenticate(preferences);

            Handler.Callback callbackForAuth = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == Constants.RESULT_OK)
                    {
                        try {
                            Order.super.create(data, callback);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else
                    {
                        try {
                            Order.super.create(data, callback);
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
            super.create(data, callback);
        }
    }
}
