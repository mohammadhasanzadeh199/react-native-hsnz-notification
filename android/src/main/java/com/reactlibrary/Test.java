package com.reactlibrary;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;


public class Test extends Button {

    public BulbView(Context context) {
        super(context);
        this.setTextColor(Color.BLUE);
        this.setText("This button is created from JAVA code");
    }
}