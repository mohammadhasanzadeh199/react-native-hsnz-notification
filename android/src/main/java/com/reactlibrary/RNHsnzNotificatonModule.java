
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import com.facebook.react.bridge.Callback;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import android.widget.RemoteViews;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.graphics.drawable.Icon;
import android.content.res.Resources;
import android.content.Intent;
import android.app.PendingIntent;
import android.content.Context;
import java.lang.*;



public class RNHsnzNotificatonModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private Resources res;
  private String packageName ;
  private Notification customNotification;
  private NotificationCompat.Builder setUpNotif;
  private NotificationManager mNotificationManager;
  private String tag;
  private int id;

  public RNHsnzNotificatonModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    Redux.ctx = reactContext;
    res = reactContext.getResources();
    packageName = reactContext.getPackageName();
    setUpNotif = new NotificationCompat.Builder(reactContext)
      .setStyle(new NotificationCompat.DecoratedCustomViewStyle());
    mNotificationManager = (NotificationManager) reactContext.getSystemService(reactContext.NOTIFICATION_SERVICE);
    Redux.manager = mNotificationManager;
    Redux.packageName = packageName;
  }

  @Override
  public String getName() {
    return "RNHsnzNotificaton";
  }

  @ReactMethod
  public void init(String tag, int id,String directory, String fileName) {
    this.tag = tag;
    this.id = id;
    Redux.id = id;
    Redux.tag = tag;
    setUpNotif.setSmallIcon(res.getIdentifier(fileName, directory, packageName));
  }


  @ReactMethod
  public void badge(int state) {
    if (state==1){
      setUpNotif.setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL);
    } else if(state==2) {
      setUpNotif.setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE);
    }
  }



  @ReactMethod
  public void outoCancel(boolean state) {
    if (state){
      setUpNotif.setAutoCancel(state);
    }
  }


  @ReactMethod
  public void show() {
    customNotification = setUpNotif.build();
    mNotificationManager.notify(tag,id,customNotification);
  }


  @ReactMethod
  public void dismiss() {
    mNotificationManager.cancel(id);
  }

  @ReactMethod
  public void addAction(String directory, String fileName,String title,Boolean open,Boolean dismiss,Callback reactFunc) {
    Redux.reactFunc = reactFunc;
    Intent temp = new Intent(reactContext,Action.class);
    PendingIntent intent = PendingIntent.getService(reactContext,0,temp,PendingIntent.FLAG_UPDATE_CURRENT);
    Redux.actionDissmis = dismiss;
    Redux.actionIntent = temp;
    Redux.actionOpen = open;
    setUpNotif.addAction(res.getIdentifier(fileName, directory, packageName), title, intent);
  }


  @ReactMethod
  public void cancelByTouch(Boolean state) {
    setUpNotif.setAutoCancel(state);
  }

  @ReactMethod
  public void setBadgeIcon(String directory, String fileName) {
    setUpNotif.setBadgeIconType(res.getIdentifier(fileName, directory, packageName));
  }

  @ReactMethod
  public void setColor(int color) {
    setUpNotif.setColor(color);
  }


  @ReactMethod
  public void setContentInfo(String info) {
    setUpNotif.setContentInfo(info);
  }

  @ReactMethod
  public void setContentText(String text){
    setUpNotif.setContentText(text);
  }
  
  @ReactMethod
  public void setContentTitle(String title){
    setUpNotif.setContentTitle(title);
  }

  @ReactMethod
  public void setGroup(String key){
    setUpNotif.setGroup(key);
  }

  @ReactMethod
  public void setLights(int color, int onMS, int offMS) {
    setUpNotif.setLights(color,onMS,offMS);
  }

  @ReactMethod
  public void setNumber(int number){
    setUpNotif.setNumber(number);
  }


  @ReactMethod
  public void setVibrate(ReadableArray patern){
    long[] newPatern = new long[patern.size()];
    for (int i =0;i<patern.size();i++){
      newPatern[i] = (long) patern.getDouble(i);
    }
    setUpNotif.setVibrate(newPatern);
  }

  

	// public Test createViewInstance(ThemedReactContext context) {
	// 	Test test = new Test(context,reactContext);
  //   Notification customNotification = new NotificationCompat.Builder(reactContext)
  //       .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
  //       .setSmallIcon(res.getIdentifier("ic_launcher", "mipmap", packageName))
  //       .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
  //       .build();
  //   mNotificationManager.notify(0, customNotification);
  //   return test;
	// }

  // public boolean needsCustomLayoutForChildren() {
  //     return true;
  // }
}
