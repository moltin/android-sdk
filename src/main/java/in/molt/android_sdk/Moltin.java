package in.molt.android_sdk;

import android.content.Context;
import android.os.Handler;

import in.molt.android_sdk.endpoints.Address;
import in.molt.android_sdk.endpoints.Authenticate;
import in.molt.android_sdk.endpoints.Brand;
import in.molt.android_sdk.endpoints.Cart;
import in.molt.android_sdk.endpoints.Category;
import in.molt.android_sdk.endpoints.Checkout;
import in.molt.android_sdk.endpoints.Collection;
import in.molt.android_sdk.endpoints.Currency;
import in.molt.android_sdk.endpoints.Entry;
import in.molt.android_sdk.endpoints.Gateway;
import in.molt.android_sdk.endpoints.Order;
import in.molt.android_sdk.endpoints.Product;
import in.molt.android_sdk.endpoints.Shipping;
import in.molt.android_sdk.endpoints.Tax;
import in.molt.android_sdk.utilities.Preferences;

//core class for Moltin API
public class Moltin
{
    private Context context;

    private Authenticate authenticate;

    public Address address;
    public Brand brand;
    public Cart cart;
    public Category category;
    public Checkout checkout;
    public Collection collection;
    public Currency currency;
    public Entry entry;
    public Gateway gateway;
    public Order order;
    public Product product;
    public Shipping shipping;
    public Tax tax;

    private Preferences preferences;

    public Moltin(Context context)
    {
        this.context=context;
        this.preferences = new Preferences(context);

        authenticate = new Authenticate(preferences);
        
        address = new Address(preferences);
        brand = new Brand(preferences);
        cart = new Cart(preferences);
        category = new Category(preferences);
        checkout = new Checkout(preferences);
        collection = new Collection(preferences);
        currency = new Currency(preferences);
        entry = new Entry(preferences);
        gateway = new Gateway(preferences);
        order = new Order(preferences);
        product = new Product(preferences);
        shipping = new Shipping(preferences);
        tax = new Tax(preferences);
    }

    public void authenticate(String publicId, Handler.Callback callback) throws Exception {
        authenticate.authenticateAsync(publicId, callback);
    }
}
