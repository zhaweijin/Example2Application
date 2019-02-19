package com.example2.test.floatwindow;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example2.test.R;
import com.example2.test.base.Example2Application;

public class FloatService extends Service {

    WindowManager wm = null;
    WindowManager.LayoutParams wmParams = null;
    View view;

    @Override
    public void onCreate() {
        Log.v("FloatService", "onCreate");
        super.onCreate();
        view = LayoutInflater.from(this).inflate(R.layout.activity_floating, null);
        createView();

    }

    private void createView() {
        wm = (WindowManager) getApplicationContext().getSystemService("window");
        //
        wmParams = ((Example2Application) getApplication()).getMywmParams();
        wmParams.type = 2002;
        wmParams.flags |= 8;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        //
        wmParams.x = 300;
        wmParams.y = 400;
        //
        wmParams.width = 200;
        wmParams.height = 300;
        wmParams.format = 1;

        wm.addView(view, wmParams);
    }


    @Override
    public void onStart(Intent intent, int startId) {
        Log.v("FloatService", "onStart");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.v("FloatService", "onDestroy");
        //wm.removeView(view);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
