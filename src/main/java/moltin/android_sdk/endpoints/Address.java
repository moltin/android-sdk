package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Address extends Facade {

    public Address(Preferences preferences)
    {
        super("addresses","addresses",preferences);
    }

    public void get(final String customer, final  String id, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "customers/" + customer + "/addresses/" + id;

                        Address.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Address.super.getHeaders(), null, callback);
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

        if(Address.super.getPreferences().isExpired() && !Address.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Address.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void find(String customer, String[][] terms, Handler.Callback callback) throws Exception {
        find(customer,super.getJsonFromArray(terms),callback);
    }

    public void find(final String customer, final JSONObject terms, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "customers/" + customer + "/addresses";

                        Address.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Address.super.getHeaders(), terms, callback);
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

        if(Address.super.getPreferences().isExpired() && !Address.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Address.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void listing(String customer, String[][] terms, Handler.Callback callback) throws Exception {
        listing(customer, super.getJsonFromArray(terms), callback);
    }

    public void listing(final String customer, final JSONObject terms, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "customers/" + customer + "/addresses";

                        Address.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Address.super.getHeaders(), terms, callback);
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

        if(Address.super.getPreferences().isExpired() && !Address.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Address.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    /**
     * update an Address object from a array of arrays of Strings
     * @param customer customer Moltin identifier
     * @param address address Moltin identifier
     * @param data parameters and values to update
     * @param callback asynchronous callback. will return the updated address object.
     * @throws Exception
     */
    public void update(String customer, String address, String[][] data, Handler.Callback callback) throws Exception {
        update(customer,super.getJsonFromArray(data),callback);
    }

    /**
     * update an Address object from JSONObject object
     * @param customer customer Moltin identifier
     * @param address address Moltin identifier
     * @param data parameters and values to update
     * @param callback asynchronous callback. will return the updated address object.
     * @throws Exception
     */
    public void update(final String customer, final String address, final JSONObject data, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "customers/" + customer + "/addresses/" + address;

                        Address.super.httpPutAsync(Constants.URL, Constants.VERSION, endpoint, Address.super.getHeaders(), null, data, callback);
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

        if(Address.super.getPreferences().isExpired() && !Address.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Address.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }



    public void create(String customer, String[][] data, Handler.Callback callback) throws Exception {
        create(customer,super.getJsonFromArray(data),callback);
    }

    public void create(final String customer, final JSONObject data, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "customers/" + customer + "/addresses";

                        Address.super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, Address.super.getHeaders(), null, data, callback);
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

        if(Address.super.getPreferences().isExpired() && !Address.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Address.super.getPreferences();
            new Authenticate(prefs).authenticateAsync(prefs.getPublicId(), prefs.getSecretId(), prefs.getGrantType(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }


    public void fields(final String customer, final  String id, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "";

                        if (customer!=null && customer.length()>0 && (id==null || id.length()==0)) {
                            endpoint = "customers/" + customer + "/addresses/fields";
                        } else if (customer!=null && customer.length()>0 && id!= null && id.length()>0) {
                            endpoint = "customers/" + customer + "/addresses/" + id + "/fields";
                        } else if ((customer==null || customer.length()==0) && id!= null && id.length()>0) {
                            endpoint = "addresses/" + id + "/fields";
                        }  else {
                            endpoint = "addresses/fields";
                        }

                        Address.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Address.super.getHeaders(), null, callback);
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

        if(Address.super.getPreferences().isExpired() && !Address.super.getPreferences().getToken().equals(""))
        {
            Preferences prefs = Address.super.getPreferences();
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
