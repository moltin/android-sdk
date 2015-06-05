package moltin.android_sdk.endpoints;


import android.os.Handler;
import android.os.Message;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.UUID;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//handling the token expiration when calling endpoint or calling Facede abstract methods
public class Cart extends Facade {

    public Cart(Preferences preferences)
    {
        super("carts","carts", preferences);
    }

    public String getIdentifier(){
        try
        {
            String cartId=super.getPreferences().getCartId();

            if(cartId.equals(""))
            {
                cartId = UUID.randomUUID().toString().replace("-","");
                super.getPreferences().setCartId(cartId);
            }

            return cartId;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setIdentifier(String cartId){
        try
        {
            super.getPreferences().setCartId(cartId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contents(final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier();

                        Cart.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void insert(String id, Integer qty, String[][] mods, Handler.Callback callback) throws Exception {
        insert(id, qty, super.getJsonFromArray(mods), callback);
    }

    public void insert(final String id, final Integer qty, final JSONObject mods, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        JSONObject jsonData = new JSONObject();
                        if(id!=null)
                            jsonData.put("id",id);

                        if(qty==null || qty<0)
                            jsonData.put("quantity",1);
                        else
                            jsonData.put("quantity",qty);

                        JSONObject jsonMods = null;

                        Iterator<?> keys=mods.keys();
                        while( keys.hasNext() )
                        {
                            if(jsonMods==null)
                                jsonMods = new JSONObject();

                            String key = (String)keys.next();
                            if( mods.get(key) instanceof String){
                                jsonMods.put(key, mods.getString(key));
                            }
                        }

                        if(jsonMods!=null)
                            jsonData.put("modifier",jsonMods);

                        String endpoint = "carts/" + getIdentifier();

                        Cart.super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, jsonData, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void update(String id, String[][] data, Handler.Callback callback) throws Exception {
        update(id, super.getJsonFromArray(data), callback);
    }

    public void update(final String id, final JSONObject data, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier() + "/item/" + id;

                        Cart.super.httpPutAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, data, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void delete(final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier();

                        Cart.super.httpDeleteAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void remove(final String id,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier() + "/item/" + id;

                        Cart.super.httpDeleteAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void item(final String id,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier() + "/item/" + id;

                        Cart.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void inCart(final String id,final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier() + "/has/" + id;

                        Cart.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void checkout(final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier() + "/checkout";

                        Cart.super.httpGetAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }

    public void order(String[][] data, Handler.Callback callback) throws Exception {
        order(super.getJsonFromArray(data), callback);
    }

    public void order(final JSONObject data, final Handler.Callback callback) throws Exception {
        Handler.Callback callbackForAuth = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == Constants.RESULT_OK)
                {
                    try {
                        String endpoint = "carts/" + getIdentifier() + "/checkout";

                        Cart.super.httpPostAsync(Constants.URL, Constants.VERSION, endpoint, Cart.super.getHeaders(), null, data, callback);
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

        if(Cart.super.getPreferences().isExpired() && !Cart.super.getPreferences().getToken().equals(""))
        {
            new Authenticate(Cart.super.getPreferences()).authenticateAsync(Cart.super.getPreferences().getPublicId(), callbackForAuth);
        }
        else
        {
            final Message callbackMessage = new Message();
            callbackMessage.what = Constants.RESULT_OK;
            callbackForAuth.handleMessage(callbackMessage);
        }
    }
}
