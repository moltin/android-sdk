# Moltin

The Moltin android-sdk is a simple to use interface for the API to help you get off the ground quickly and efficiently within the Android app.

## Installation

Add these lines to your application's gradle file:
```
repositories {
   flatDir {
       dirs 'libs'
   }
}

dependencies {
   compile(name:'android-sdk-[debug|release]', ext:'aar')
}
``
And then add the .aar file into your `libs` folder from `[moltin lib root folder]/build/outputs/aar/`

## Usage

### Configuration

```
Moltin moltin = new Moltin(this);
```

### Authentication

Just set the `publicId` from the api console on Moltin website and you are ready to go.

```
moltin.authenticate("XXXXXXXXXXXXX", callback);
```
be aware that the `authenticate` call is asynchronous, only after the callback the TOKEN is ready

### Get A CRUD Resource

The majority of our API calls can be mapped to Model-esque instance and don't need any low-level API calls.

```
moltin.product.get("6", callback);
```

### Handling the Callback on an example

Getting the product "6" specification
```

moltin.product.get("6", new Handler.Callback() {
	@Override
	public boolean handleMessage(Message msg) {
		if (msg.what == Constants.RESULT_OK) {
			JSONObject jsonResponse = (JSONObject)msg.obj;
			return true;
		} else {
			return false;
		}
	}
});
```

Creating a user's address
```
JSONObject jsonCustomer = new JSONObject();
jsonCustomer.put("save_as","2");
jsonCustomer.put("first_name","Joe");
jsonCustomer.put("last_name","Black");
jsonCustomer.put("address_1","High Street");
jsonCustomer.put("address_2","Example Village");
jsonCustomer.put("postcode","1000");
jsonCustomer.put("country","GB");

moltin.address.create("0", jsonCustomer, new Handler.Callback() {
	@Override
	public boolean handleMessage(Message msg) {
		if (msg.what == Constants.RESULT_OK) {
			JSONObject jsonResponse = (JSONObject) msg.obj;
			return true;
		} else {
			return false;
		}
	}
});
```