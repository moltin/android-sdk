package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Collection extends Facade {

    public Collection(Preferences preferences)
    {
        super("collections","collections",preferences);
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
