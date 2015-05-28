package moltin.android_sdk.endpoints;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import moltin.android_sdk.utilities.Constants;

//abstract class for http methods with params and headers handling
abstract class HttpMethodAbstract {

    private static String errorString="ERROR";
    private static String errorStringParameters="error parsing parameters";
    private static String errorStringHeaders="error parsing header";
    private static String errorStringResponseNull="error response is null";

    private static String getParametersString(JSONObject parameters)
    {
        try
        {
            if(parameters!=null)
            {
                String stringParameters="?";
                int i=0;
                Iterator<?> keys=parameters.keys();
                while( keys.hasNext() )
                {
                    if(i!=0)
                        stringParameters+="&";

                    String key = (String)keys.next();

                    Log.i("Key - Value", key + " - " + parameters.getString(key));
                    if( parameters.get(key) instanceof String){
                        stringParameters+=key + "=" + parameters.getString(key);
                        i++;
                    }
                }

                Log.i("REQUEST PARAMETERS", stringParameters);

                return stringParameters;
            }
            else
            {
                return "";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return errorString;
        }
    }

    private static HttpGet setHeaders(HttpGet httpGet, JSONObject headers)
    {
        try
        {
            if(headers!=null)
            {
                Iterator<?> keys=headers.keys();
                while( keys.hasNext() )
                {
                    String key = (String)keys.next();
                    Log.i("Key - Value", key + " - " + headers.getString(key));
                    if( headers.get(key) instanceof String){
                        httpGet.addHeader(key, headers.getString(key));
                    }
                }

                return httpGet;
            }
            else
            {
                return httpGet;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static HttpPost setHeaders(HttpPost httpPost, JSONObject headers)
    {
        try
        {
            if(headers!=null)
            {
                Iterator<?> keys=headers.keys();
                while( keys.hasNext() )
                {
                    String key = (String)keys.next();
                    Log.i("Key - Value", key + " - " + headers.getString(key));
                    if( headers.get(key) instanceof String){
                        httpPost.addHeader(key, headers.getString(key));
                    }
                }

                return httpPost;
            }
            else
            {
                return httpPost;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static HttpPut setHeaders(HttpPut httpPut, JSONObject headers)
    {
        try
        {
            if(headers!=null)
            {
                Iterator<?> keys=headers.keys();
                while( keys.hasNext() )
                {
                    String key = (String)keys.next();
                    Log.i("Key - Value", key + " - " + headers.getString(key));
                    if( headers.get(key) instanceof String){
                        httpPut.addHeader(key, headers.getString(key));
                    }
                }

                return httpPut;
            }
            else
            {
                return httpPut;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static HttpDelete setHeaders(HttpDelete httpDelete, JSONObject headers)
    {
        try
        {
            if(headers!=null)
            {
                Iterator<?> keys=headers.keys();
                while( keys.hasNext() )
                {
                    String key = (String)keys.next();
                    Log.i("Key - Value", key + " - " + headers.getString(key));
                    if( headers.get(key) instanceof String){
                        httpDelete.addHeader(key, headers.getString(key));
                    }
                }

                return httpDelete;
            }
            else
            {
                return httpDelete;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static ArrayList<BasicNameValuePair> setData(JSONObject data)
    {
        try
        {
            if(data!=null)
            {
                ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();

                Iterator<?> keys=data.keys();

                int i=0;

                while( keys.hasNext() )
                {
                    String key = (String)keys.next();
                    if(data.get(key) instanceof String || data.get(key) instanceof Integer || data.get(key) instanceof Long || data.get(key) instanceof Float || data.get(key) instanceof Double){
                        nameValuePairs.add(new BasicNameValuePair(key, data.getString(key)));
                        Log.i("Key - Value", key + " - " + data.getString(key));
                    }
                    else if(data.get(key) instanceof JSONObject)
                    {
                        getNestedName(key, data.getJSONObject(key), nameValuePairs);
                    }

                    i++;
                }

                return nameValuePairs;
            }
            else
            {
                return new ArrayList<BasicNameValuePair>();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    static private void getNestedName(String oldKey, JSONObject json, ArrayList<BasicNameValuePair> nameValuePairs)
    {
        try
        {
            Iterator<?> keys=json.keys();

            while( keys.hasNext() )
            {
                String key = (String)keys.next();
                if(json.get(key) instanceof String || json.get(key) instanceof Integer || json.get(key) instanceof Long || json.get(key) instanceof Float || json.get(key) instanceof Double){
                    nameValuePairs.add(new BasicNameValuePair(oldKey + "[" + key + "]", json.getString(key)));
                    Log.i("Key - Value", oldKey + "[" + key + "]" + " - " + json.getString(key));
                }
                else if(json.get(key) instanceof JSONObject)
                {
                    getNestedName(oldKey + "[" + key + "]", json.getJSONObject(key), nameValuePairs);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void httpGetAsync(final String url, final String version, final String endpoint, final JSONObject headers, final JSONObject parameters, final Handler.Callback callback) {
        final Message callbackMessage = new Message();

        new AsyncTask<Handler.Callback, Object, Object>() {
            @Override
            protected Object doInBackground(Handler.Callback... callbacks) {
                try {
                    HttpClient client = new DefaultHttpClient();

                    ConnManagerParams.setTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setSoTimeout(client.getParams(), 5000); //Timeout Limit
                    HttpResponse response;

                    String stringParameters = getParametersString(parameters);

                    if(stringParameters.equals(errorString))
                        return errorStringParameters;

                    HttpGet get = new HttpGet(url + (version.length()>0 ? version + "/" : "") + endpoint + stringParameters);

                    Log.i("REQUEST URL",get.getURI().toString());

                    get = setHeaders(get, headers);

                    if(get == null)
                        return errorStringHeaders;

                    response = client.execute(get);

                    if (response != null) {
                        int responseCode = response.getStatusLine().getStatusCode();

                        Log.i("RESPONSE CODE","" + responseCode);

                        InputStream in = response.getEntity().getContent(); //Get the data in the entity

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String sLine = "";
                        String sResponse = "";

                        try {
                            while ((sLine = reader.readLine()) != null) {
                                sResponse = sResponse + sLine;
                            }

                            JSONObject jsonResponse = new JSONObject(sResponse);

                            Log.i("RESPONSE",sResponse);

                            if (responseCode < 200 || responseCode >= 300) {
                                callbackMessage.obj = jsonResponse;
                                return null;
                            }

                            return jsonResponse;

                        } catch (IOException e) {
                            e.printStackTrace();

                            return e;
                        } finally {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        return errorStringResponseNull;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return e;
                }
            }
            @Override
            protected void onPostExecute(Object result) {
                //if result is JSONObject all is OK
                if (result != null && (result instanceof JSONObject)) {
                    callbackMessage.what = Constants.RESULT_OK;
                    callbackMessage.obj = result;
                    callback.handleMessage(callbackMessage);
                } else {
                    callbackMessage.what = Constants.RESULT_NOT_OK;
                    if (callbackMessage.obj == null && result != null) {
                        callbackMessage.obj = result;
                    }
                    callback.handleMessage(callbackMessage);
                }
            }

        }.execute(null, null, null);
    }

    public static void httpPostAsync(final String url, final String version, final String endpoint, final JSONObject headers, final JSONObject parameters, final JSONObject json, final Handler.Callback callback) {
        final Message callbackMessage = new Message();

        new AsyncTask<Handler.Callback, Object, Object>() {
            @Override
            protected Object doInBackground(Handler.Callback... callbacks) {
                try {
                    HttpClient client = new DefaultHttpClient();

                    ConnManagerParams.setTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setSoTimeout(client.getParams(), 5000); //Timeout Limit
                    HttpResponse response;

                    String stringParameters = getParametersString(parameters);

                    if(stringParameters.equals(errorString))
                        return errorStringParameters;

                    HttpPost post = new HttpPost(url + (version.length()>0 ? version + "/" : "") + endpoint + stringParameters);

                    Log.i("REQUEST URL",post.getURI().toString());

                    post = setHeaders(post, headers);

                    if(post == null)
                        return errorStringHeaders;

                    if(json!=null)
                    {
                        Log.i("REQUEST JSON", json.toString());

                        /*StringEntity se = new StringEntity(json.toString(),"UTF-8");
                        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_ENCODING,"charset=utf-8"));
                        se.setContentType("application/json; charset=utf-8");

                        post.setEntity(se);*/

                        ArrayList<BasicNameValuePair> params = setData(json);

                        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity( params, "utf-8");
                        post.setEntity(urlEncodedFormEntity);
                    }

                    response = client.execute(post);

                    if (response != null) {
                        int responseCode = response.getStatusLine().getStatusCode();

                        Log.i("RESPONSE CODE","" + responseCode);

                        InputStream in = response.getEntity().getContent(); //Get the data in the entity

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String sLine = "";
                        String sResponse = "";

                        try {
                            while ((sLine = reader.readLine()) != null) {
                                sResponse = sResponse + sLine;
                            }

                            Log.i("RESPONSE",sResponse);

                            JSONObject jsonResponse = new JSONObject(sResponse);

                            if (responseCode < 200 || responseCode >= 300) {
                                callbackMessage.obj = jsonResponse;
                                return null;
                            }

                            return jsonResponse;

                        } catch (IOException e) {
                            e.printStackTrace();

                            return e;
                        } finally {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        return errorStringResponseNull;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return e;
                }
            }
            @Override
            protected void onPostExecute(Object result) {
                //if result is JSONObject all is OK
                if (result != null && (result instanceof JSONObject)) {
                    callbackMessage.what = Constants.RESULT_OK;
                    callbackMessage.obj = result;
                    callback.handleMessage(callbackMessage);
                } else {
                    callbackMessage.what = Constants.RESULT_NOT_OK;
                    if (callbackMessage.obj == null && result != null) {
                        callbackMessage.obj = result;
                    }
                    callback.handleMessage(callbackMessage);
                }
            }

        }.execute(null, null, null);
    }

    public static void httpPutAsync(final String url, final String version, final String endpoint, final JSONObject headers, final JSONObject parameters, final JSONObject json, final Handler.Callback callback) {
        final Message callbackMessage = new Message();

        new AsyncTask<Handler.Callback, Object, Object>() {
            @Override
            protected Object doInBackground(Handler.Callback... callbacks) {
                try {
                    HttpClient client = new DefaultHttpClient();

                    ConnManagerParams.setTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setSoTimeout(client.getParams(), 5000); //Timeout Limit
                    HttpResponse response;

                    String stringParameters = getParametersString(parameters);

                    if(stringParameters.equals(errorString))
                        return errorStringParameters;

                    HttpPut put = new HttpPut(url + (version.length()>0 ? version + "/" : "") + endpoint + stringParameters);

                    Log.i("REQUEST URL",put.getURI().toString());

                    put = setHeaders(put, headers);

                    if(put == null)
                        return errorStringHeaders;

                    if(json!=null)
                    {
                        Log.i("REQUEST JSON", json.toString());

                        /*StringEntity se = new StringEntity(json.toString(),"UTF-8");
                        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_ENCODING,"charset=utf-8"));
                        se.setContentType("application/json; charset=utf-8");

                        post.setEntity(se);*/

                        ArrayList<BasicNameValuePair> params = setData(json);

                        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity( params, "utf-8");
                        put.setEntity(urlEncodedFormEntity);
                    }

                    response = client.execute(put);

                    if (response != null) {
                        int responseCode = response.getStatusLine().getStatusCode();

                        Log.i("RESPONSE CODE","" + responseCode);

                        InputStream in = response.getEntity().getContent(); //Get the data in the entity

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String sLine = "";
                        String sResponse = "";

                        try {
                            while ((sLine = reader.readLine()) != null) {
                                sResponse = sResponse + sLine;
                            }

                            Log.i("RESPONSE",sResponse);

                            JSONObject jsonResponse = new JSONObject(sResponse);

                            if (responseCode < 200 || responseCode >= 300) {
                                callbackMessage.obj = jsonResponse;
                                return null;
                            }

                            return jsonResponse;

                        } catch (IOException e) {
                            e.printStackTrace();

                            return e;
                        } finally {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        return errorStringResponseNull;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return e;
                }
            }
            @Override
            protected void onPostExecute(Object result) {
                //if result is JSONObject all is OK
                if (result != null && (result instanceof JSONObject)) {
                    callbackMessage.what = Constants.RESULT_OK;
                    callbackMessage.obj = result;
                    callback.handleMessage(callbackMessage);
                } else {
                    callbackMessage.what = Constants.RESULT_NOT_OK;
                    if (callbackMessage.obj == null && result != null) {
                        callbackMessage.obj = result;
                    }
                    callback.handleMessage(callbackMessage);
                }
            }

        }.execute(null, null, null);
    }

    public static void httpDeleteAsync(final String url, final String version, final String endpoint, final JSONObject headers, final JSONObject parameters, final Handler.Callback callback) {
        final Message callbackMessage = new Message();

        new AsyncTask<Handler.Callback, Object, Object>() {
            @Override
            protected Object doInBackground(Handler.Callback... callbacks) {
                try {
                    HttpClient client = new DefaultHttpClient();

                    ConnManagerParams.setTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
                    HttpConnectionParams.setSoTimeout(client.getParams(), 5000); //Timeout Limit
                    HttpResponse response;

                    String stringParameters = getParametersString(parameters);

                    if(stringParameters.equals(errorString))
                        return errorStringParameters;

                    HttpDelete delete = new HttpDelete(url + (version.length()>0 ? version + "/" : "") + endpoint + stringParameters);

                    Log.i("REQUEST URL",delete.getURI().toString());

                    delete = setHeaders(delete, headers);

                    if(delete == null)
                        return errorStringHeaders;

                    response = client.execute(delete);

                    if (response != null) {
                        int responseCode = response.getStatusLine().getStatusCode();

                        Log.i("RESPONSE CODE","" + responseCode);

                        InputStream in = response.getEntity().getContent(); //Get the data in the entity

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String sLine = "";
                        String sResponse = "";

                        try {
                            while ((sLine = reader.readLine()) != null) {
                                sResponse = sResponse + sLine;
                            }

                            JSONObject jsonResponse = new JSONObject(sResponse);

                            Log.i("RESPONSE",sResponse);

                            if (responseCode < 200 || responseCode >= 300) {
                                callbackMessage.obj = jsonResponse;
                                return null;
                            }

                            return jsonResponse;

                        } catch (IOException e) {
                            e.printStackTrace();

                            return e;
                        } finally {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        return errorStringResponseNull;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return e;
                }
            }
            @Override
            protected void onPostExecute(Object result) {
                //if result is JSONObject all is OK
                if (result != null && (result instanceof JSONObject)) {
                    callbackMessage.what = Constants.RESULT_OK;
                    callbackMessage.obj = result;
                    callback.handleMessage(callbackMessage);
                } else {
                    callbackMessage.what = Constants.RESULT_NOT_OK;
                    if (callbackMessage.obj == null && result != null) {
                        callbackMessage.obj = result;
                    }
                    callback.handleMessage(callbackMessage);
                }
            }

        }.execute(null, null, null);
    }
}
