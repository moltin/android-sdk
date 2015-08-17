# Moltin Android-SDK

The Moltin android-sdk is a simple to use interface for the API to help you get off the ground quickly and efficiently within an Android app.

## Installation

These lines should be added to your application's gradle file:
```
repositories {
   flatDir {
       dirs 'libs'
   }
}

dependencies {
   compile(name:'android-sdk-[debug|release]', ext:'aar')
}
```
Once complete, add the `.aar` file into your `libs` folder from:

```
[moltin lib root folder]/build/outputs/aar/
```

## Usage

### Configuration

```java
Moltin moltin = new Moltin(this);
```

### Authentication

Just set the `publicId` from the api console on Moltin website and you are ready to go.

```java
moltin.authenticate("YOUR_PUBLIC_ID", callback);
```
**Be aware that the `authenticate` call is asynchronous, only after the callback the TOKEN is ready**

### Get A CRUD Resource

The majority of our API calls can be mapped to Model-esque instance and don't need any low-level API calls.

```java
moltin.product.get("6", callback);
```

### Some examples

Here are some examples of handling the callback:

*Getting the the product object for a product with the slug "6"*

```java
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

*Creating a user's address:*

```java
moltin.address.create("0", new String[][]{
		{"save_as","3"},
		{"first_name","Joe"},
		{"last_name","Black"},
		{"address_1","Example Village"},
		{"address_2","Lower street"},
		{"country","GB"},
        {"postcode","1000"}
	}, new Handler.Callback() {
	@Override
	public boolean handleMessage(Message msg) {
		showPopup(msg.obj.toString());
		if (msg.what == Constants.RESULT_OK) {
			return true;
		} else {
			return false;
		}
	}
});
```
