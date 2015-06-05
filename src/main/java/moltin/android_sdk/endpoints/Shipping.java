package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Shipping extends Facade {

    public Shipping(Preferences preferences)
    {
        super("shipping","shipping",preferences);
    }

    @Override
    public void get(final String id, final Handler.Callback callback) throws Exception {
        super.get(id, callback);
    }

    public void listing(String[][] terms, Handler.Callback callback) throws Exception {
        listing(super.getJsonFromArray(terms), callback);
    }

    @Override
    public void listing(final JSONObject terms, final Handler.Callback callback) throws Exception {
        super.listing(terms, callback);
    }
}
