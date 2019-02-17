
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNHsnzNotificatonModule extends ViewGroupManager<Test> {

  private final ReactApplicationContext reactContext;

  public RNHsnzNotificatonModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNHsnzNotificaton";
  }

  @Override
	public Test createViewInstance(ThemedReactContext context) {
		return new Test(context);
	}
}