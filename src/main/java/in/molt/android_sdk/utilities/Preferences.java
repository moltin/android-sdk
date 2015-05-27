package in.molt.android_sdk.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Date;

//shared preferenced where all the needed data for communication is stored
public class Preferences {

    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    public Preferences(Context this_context)
    {
        context = this_context;

        if(context!=null) {
            sharedPreferences = context.getSharedPreferences(Constants.PREFERENCES_NAME, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public String getCurrencyId()
    {
        return preferencesGetString("mcurrency");
    }

    public void setCurrencyId(String currencyId)
    {
        preferencesSetString("mcurrency", currencyId);
    }

    public String getCartId()
    {
        return preferencesGetString("mcart");
    }

    public void setCartId(String cartId)
    {
        preferencesSetString("mcart", cartId);
    }

    public String getPublicId()
    {
        return preferencesGetString("mpublic");
    }

    public void setPublicId(String publicId)
    {
        preferencesSetString("mpublic", publicId);
    }

    public String getToken()
    {
        Log.i("READING TOKEN", "mtoken " + preferencesGetString("mtoken"));
        return preferencesGetString("mtoken");
    }

    public void setToken(String token)
    {
        Log.i("WRITING TOKEN", "mtoken " + token);
        preferencesSetString("mtoken", token);
    }

    public void setExpiration(long expires_in)
    {
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + (expires_in * 1000));

        preferencesSetLong("mexpires", expireDate.getTime());
    }

    public boolean isExpired()
    {
        long dateLong = preferencesGetLong("mexpires");
        Date expireDate = new Date(dateLong);

        Date currentDate = new Date();

        if(currentDate.after(expireDate) && !getToken().equals(""))
            return true;
        else
            return false;

    }

    public long getExpiration()
    {
        return preferencesGetLong("mexpires");
    }

    private String preferencesGetString(String sName)
    {
        return sharedPreferences.getString(sName, "");
    }

    private int preferencesGetInt(String sName)
    {
        return sharedPreferences.getInt(sName, 0);
    }

    private long preferencesGetLong(String sName)
    {
        return sharedPreferences.getLong(sName, 0);
    }

    private boolean preferencesGetBoolean(String sName)
    {
        return sharedPreferences.getBoolean(sName, false);
    }

    private void preferencesSetString(String sName, String sValue)
    {
        editor.putString(sName, sValue);
        editor.commit();
    }

    private void preferencesSetInt(String sName, int iValue)
    {
        editor.putInt(sName, iValue);
        editor.commit();
    }

    private void preferencesSetLong(String sName, long lValue)
    {
        editor.putLong(sName, lValue);
        editor.commit();
    }

    private void preferencesSetBoolean(String sName, boolean bValue)
    {
        editor.putBoolean(sName, bValue);
        editor.commit();
    }
}
