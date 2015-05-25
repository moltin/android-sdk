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
   compile(name:'android-sdk', ext:'aar')
}
```
And then add the .aar file into your libs folder:

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

### Get A CRUD Resource

The majority of our API calls can be mapped to Model-esque instance and don't need any low-level API calls.

```
moltin.product.get("6", callback);
```

### Handling the Callback on an example

```
moltin.product.get("6", new Handler.Callback() {
	@Override
	public boolean handleMessage(Message msg) {                                    
		if (msg.what == 1) {
			return true;
		} else {
			return false;
		}
	}
});                            
```