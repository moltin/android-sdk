package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Category extends Facade {

    public Category(Preferences preferences)
    {
        super("categories","categories",preferences);
    }

    @Override
    public void get(final String id, final Handler.Callback callback) throws Exception {
        Category.super.get(id, callback);
    }

    public void find(String[][] terms, Handler.Callback callback) throws Exception {
        find(super.getJsonFromArray(terms), callback);
    }

    @Override
    public void find(final JSONObject terms, final Handler.Callback callback) throws Exception {
        Category.super.find(terms, callback);
    }

    public void listing(String[][] terms, Handler.Callback callback) throws Exception {
        listing(super.getJsonFromArray(terms), callback);
    }

    @Override
    public void listing(final JSONObject terms, final Handler.Callback callback) throws Exception {
        super.listing(terms, callback);
    }

    public void tree(String[][] terms, Handler.Callback callback) throws Exception {
        tree(super.getJsonFromArray(terms), callback);
    }

    public void tree(final JSONObject terms, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = Category.super.getPlural() + "/tree";

                        Category.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Category.super.getHeaders(), terms, callback);
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

        if(Category.super.getPreferences().isExpired() && !Category.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Category.super.getPreferences()).authenticateAsync(Category.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    @Override
    public void fields(final String id, final Handler.Callback callback) throws Exception {
        super.fields(id, callback);
    }
}
