package moltin.android_sdk.endpoints;

import android.os.Handler;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Customer extends Facade {

    public Customer(Preferences preferences)
    {
        super("brands","brands",preferences);
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
}
