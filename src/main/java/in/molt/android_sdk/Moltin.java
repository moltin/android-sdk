package in.molt.android_sdk;

import android.content.Context;
import android.os.Handler;

import in.molt.android_sdk.endpoints.Address;
import in.molt.android_sdk.endpoints.Authenticate;
import in.molt.android_sdk.endpoints.Product;
import in.molt.android_sdk.utilities.Preferences;

//core class for Moltin API
public class Moltin
{
    private Context context;
    private Authenticate authenticate;
    public Address address;
    public Product product;
    private Preferences preferences;

    public Moltin(Context context)
    {
        this.context=context;
        this.preferences = new Preferences(context);
        authenticate = new Authenticate(preferences);
        address = new Address(preferences);
        product = new Product(preferences);
    }

    public void authenticate(String publicId, Handler.Callback callback) throws Exception {
        authenticate.authenticateAsync(publicId, callback);
    }
}
