package com.example2.test.seekbar;

import android.app.Dialog;
import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example2.test.R;

import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL;


public class NextBrightnessDialog extends Dialog{


    private Context mContext;
    private LayoutInflater mFactory = null;
    private View mView = null;


    private RelativeLayout grobal;

    public NextBrightnessDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        initView(context);

        //R.layout.seekbar
    }


    private void setWH(){
        /*Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        lp.width = Utils.getScreenWidth(mContext);
        lp.height = Utils.getScreenHeight(mContext);
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);

        dialogWindow.setType(WindowManager.LayoutParams.TYPE_VOLUME_OVERLAY);*/
    }

    private void initView(Context context){
        mContext = context;
        mFactory = LayoutInflater.from(mContext);
        mView = mFactory.inflate(R.layout.nextclass_light_test, null);

        setWH();
        setContentView(mView);


    }

}
