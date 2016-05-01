package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Customer extends Facade {

    public Customer(Preferences preferences)
    {
        super("customers","customers",preferences);
    }

    @Override
    public void get(final String id, final Handler.Callback callback) throws Exception {
        super.get(id, callback);
    }

    public void find(String[][] terms, Handler.Callback callback) throws Exception {
        find(super.getJsonFromArray(terms), callback);
    }

    @Override
    public void find(final JSONObject terms, final Handler.Callback callback) throws Exception {
        super.find(terms, callback);
    }

    public void listing(String[][] terms, Handler.Callback callback) throws Exception {
        listing(super.getJsonFromArray(terms), callback);
    }

    @Override
    public void listing(final JSONObject terms, final Handler.Callback callback) throws Exception {
        super.listing(terms, callback);
    }

    @Override
    public void fields(final String id, final Handler.Callback callback) throws Exception {
        super.fields(id, callback);
    }

    public void create(String[][] data, Handler.Callback callback) throws Exception {
        create(super.getJsonFromArray(data), callback);
    }

    @Override
    public void create(final JSONObject data, final Handler.Callback callback) throws Exception {
        super.create(data, callback);
    }

    public void update(final String id, String[][] data, Handler.Callback callback) throws Exception {
        update(id, super.getJsonFromArray(data), callback);
    }

    @Override
    public void update(final String id, final JSONObject data, final Handler.Callback callback) throws Exception {
        super.update(id, data, callback);
    }

    /**
     * login a user with its email address and password.
     * @param email user email address
     * @param password user password
     * @param callback asynchronous callback. will return Contants.RESULT_OK if the user is properly loggued in, Constans.RESULT_NOT_OK if the credentials are invalid
     * @throws Exception exception
     */
    public void login(final String email, final String password, final Handler.Callback callback) throws Exception {

        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "/v1/customers/token";
                        JSONObject data = new JSONObject();
                        data.put("email", email);
                        data.put("password", password);

                        Customer.super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, getHeaders(), null, data, callback);
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

        Preferences prefs = Customer.super.getPreferences();

        if(prefs.isExpired() && !prefs.getToken().equals(""))
        {
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
