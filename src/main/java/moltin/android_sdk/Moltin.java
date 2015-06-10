package moltin.android_sdk;

import android.content.Context;
import android.os.Handler;

import moltin.android_sdk.endpoints.Address;
import moltin.android_sdk.endpoints.Authenticate;
import moltin.android_sdk.endpoints.Brand;
import moltin.android_sdk.endpoints.Cart;
import moltin.android_sdk.endpoints.Category;
import moltin.android_sdk.endpoints.Checkout;
import moltin.android_sdk.endpoints.Collection;
import moltin.android_sdk.endpoints.Currency;
import moltin.android_sdk.endpoints.Customer;
import moltin.android_sdk.endpoints.Entry;
import moltin.android_sdk.endpoints.Gateway;
import moltin.android_sdk.endpoints.Order;
import moltin.android_sdk.endpoints.Product;
import moltin.android_sdk.endpoints.Shipping;
import moltin.android_sdk.endpoints.Tax;
import moltin.android_sdk.utilities.Preferences;

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
    public Customer customer;
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
        customer = new Customer(preferences);
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

    public void resetAuthenticationData()
    {
        preferences.resetAuthentication();
    }
}
