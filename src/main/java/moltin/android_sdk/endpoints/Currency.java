package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Currency extends Facade {

    public Currency(Preferences preferences)
    {
        super("currencies","currencies",preferences);
    }

    public void set(String code) throws Exception {
        try
        {
            super.getPreferences().setCurrencyId(code);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
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
}
