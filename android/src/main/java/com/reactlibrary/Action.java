package com.reactlibrary;

import android.app.IntentService;
import android.content.Intent;
import android.widget.RemoteViews;
import java.io.Serializable;
import com.facebook.react.bridge.Callback;
import android.content.pm.PackageManager;
import android.content.Intent;



public class Action extends IntentService {

    public Action(String name) {
        super("Back");
    }
    public Action() {
        super("Back");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        Redux.reactFunc.invoke();
        if (Redux.actionDissmis){
            Redux.manager.cancel(Redux.id);
        }
        if (Redux.actionOpen){
            Intent app = Redux.ctx.getPackageManager().getLaunchIntentForPackage(Redux.packageName);
            // TaskStackBuilder stackBuilder = TaskStackBuilder.create(reactContext);
            // stackBuilder.addNextIntentWithParentStack(app);
            app.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            Redux.ctx.startActivity(app);
        }
        Redux.ctx.stopService(Redux.actionIntent);
    }
}
