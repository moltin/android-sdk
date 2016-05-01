package moltin.android_sdk.endpoints;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import moltin.android_sdk.utilities.Constants;
import moltin.android_sdk.utilities.Preferences;

//authenticating the user with publicId from api console
public class Authenticate extends HttpMethodAbstract {

    private Preferences preferences;

    public Authenticate(Preferences preferences) {
        this.preferences = preferences;
    }

    public void authenticateAsync(final String publicId, String secretId, String grant_type, final Handler.Callback callback) throws Exception {
        try {
            if (preferences.getPublicId().equals("") && (publicId == null || publicId.length() == 0)) {
                throw new Exception("Public ID must be set");
            }

            preferences.setPublicId(publicId);
            preferences.setGrantType(grant_type);
            if (secretId != null)
                preferences.setSecretId(secretId);

            if (!Constants.DISABLE_LOGGING)
                Log.i("REQUEST TOKEN", "mtoken " + preferences.getToken());

            if (!preferences.getToken().equals("") && !preferences.isExpired()) {
                JSONObject json = new JSONObject();
                try {

                    if (!Constants.DISABLE_LOGGING) Log.i("RESPONSE AUTH", "already authenticated");

                    json.put("result", "already authenticated");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final Message callbackMessage = new Message();
                callbackMessage.what = Constants.RESULT_OK;
                callbackMessage.obj = json;
                callback.handleMessage(callbackMessage);

                return;
            }

            String endpoint = "oauth/access_token";

            JSONObject jsonData = new JSONObject();
            jsonData.put("client_id", publicId);
            jsonData.put("grant_type", grant_type);
            if (grant_type.equals("client_credentials")) {

                if (secretId == null) {
                    throw new Exception("client secret ID must be set for grant_type 'client_credentials'");
                }
                jsonData.put("client_secret", secretId);
            }

            JSONObject jsonHeaders = new JSONObject();
            jsonHeaders.put("Content-Type", "application/x-www-form-urlencoded");

            Handler.Callback callbackForAuth = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    if (msg.what == Constants.RESULT_OK) {
                        JSONObject json = new JSONObject();
                        try {
                            json.put("result", "already authenticated with valid token");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSONObject response = (JSONObject) msg.obj;

                        if (!Constants.DISABLE_LOGGING) Log.i("RESPONSE AUTH", response.toString());

                        try {
                            preferences.setToken(response.getString("access_token"));
                            preferences.setExpiration(response.getLong("expires_in"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return false;
                        }

                        final Message callbackMessage = new Message();
                        callbackMessage.what = msg.what;
                        callbackMessage.obj = msg.obj;
                        callback.handleMessage(callbackMessage);
                        return true;
                    } else {
                        final Message callbackMessage = new Message();
                        callbackMessage.what = msg.what;
                        callbackMessage.obj = msg.obj;
                        callback.handleMessage(callbackMessage);
                        return false;
                    }
                }
            };

            super.httpPostAsync(Constants.URL, "", endpoint, jsonHeaders, null, jsonData, callbackForAuth);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void authenticateAsync(final String publicId, final Handler.Callback callback) throws Exception {

        this.authenticateAsync(publicId, null, "implicit", callback);
    }
}