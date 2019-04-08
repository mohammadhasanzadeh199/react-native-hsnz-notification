package com.reactlibrary;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.facebook.react.bridge.ReactApplicationContext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;


public class Test extends LinearLayout {

    public Test(Context context) {
        super(context);
    }
    public Test(Context context,ReactApplicationContext content){
        super(context);
    }
    public Test(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Test(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}