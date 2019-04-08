package com.reactlibrary;

import com.facebook.react.bridge.Callback;
import android.content.Intent;
import com.facebook.react.bridge.ReactApplicationContext;
import android.app.Notification;
import android.app.NotificationManager;




public class Redux {
    public static Callback reactFunc;
    public static Intent actionIntent;
    public static ReactApplicationContext ctx;
    public static int id;
    public static String tag;
    public static NotificationManager manager;
    public static Notification notif;
    public static boolean actionDissmis = false;
    public static boolean actionOpen;
    public static String packageName;
}