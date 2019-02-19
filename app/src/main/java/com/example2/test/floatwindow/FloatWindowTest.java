package com.example2.test.floatwindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example2.test.base.BaseActivity;


public class FloatWindowTest extends BaseActivity{


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, FloatWindowTest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent service = new Intent();
        service.setClass(FloatWindowTest.this, FloatService.class);
        startService(service);
    }



}
