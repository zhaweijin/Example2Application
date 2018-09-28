package com.example2.test.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example2.test.R;
import com.example2.test.utiltest.UtilTest;
import com.hiveview.cloudtv.settings.wifi.HvWiFiBase;
import com.hiveview.cloudtv.settings.wifi42.RTKWiFi;
import com.hiveview.cloudtv.settings.wifi50.TongweiWiFi;

public class MainActivity extends AppCompatActivity {



    private Object o = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        HvWiFiBase wiFiBase = new TongweiWiFi();
        Log.v("test",wiFiBase.aaa());
        Log.v("test",wiFiBase.bbb());


        wiFiBase = new RTKWiFi();
        Log.v("test",wiFiBase.aaa());
        Log.v("test",wiFiBase.bbb());





//        DITest.launch(this);
        //Rx2Test.launch(this);

        UtilTest.launch(this);


        //JsoupActivity.launch(this);

        /*String filepath  = "/mnt/sdcard/PermRoot.apk";
        File file = new File(filepath);
        PUtils.print("file exist=="+file.exists());
        PUtils.print("file can read=="+file.canRead());*/


        //MessengerTestActivity.launch(this);
        //AnimationTest.launch(this);
//        ReflectTest.launch(this);



        //getScreenPhysicalSize(this);

        /*RTKEthernetManager rtkEthernetManager = new RTKEthernetManager(this);
        Log.v("test","ip="+rtkEthernetManager.getEthernetIpAddress()+",status="+rtkEthernetManager.isEthernetAvailable()+",mask=="+rtkEthernetManager.getEthernetNetmask());

        if(!rtkEthernetManager.isEthernetDhcp()){
            Log.v("test","ip="+rtkEthernetManager.setEthernetIpConfiguration(true,"","","",""));
        }*/

        /*TWEthernetManager twEthernetManager = new TWEthernetManager(this);

        if(!twEthernetManager.isEthernetDhcp()){
            Log.v("test","ip="+twEthernetManager.setEthernetIpConfiguration(true,"","","",""));
        }*/


        /*Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.hiveview.dianshang.inputmanager","com.hiveview.dianshang.inputmanager.MainActivity");
        intent.setComponent(comp);
        startActivity(intent);*/




    }

    /**
     * 精确获取屏幕尺寸（例如：3.5、4.0、5.0寸屏幕）
     *
     * @param ctx
     * @return
     */
    public void getScreenPhysicalSize(Activity ctx) {
        DisplayMetrics dm = new DisplayMetrics();
        ctx.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Log.v("test","width="+dm.widthPixels);
        Log.v("test","height="+dm.heightPixels);
    }

    private void switchInputMethod(){
        String ACTION_INPUT_METHOD_CLASS_NAME ="input_method_class_name";
        String switchClassName="com.baidu.input_baidutv/.ImeService";  //待切换的输入法名称

        Intent intent = new Intent();
        intent.setAction("com.hiveview.inputmethod.switch");
        intent.putExtra(ACTION_INPUT_METHOD_CLASS_NAME,switchClassName);
        startActivity(intent);
    }


    private void resetDefaultInputMethod(){
        String ACTION_INPUT_METHOD_CLASS_NAME ="input_method_class_name";
        String defaultClassName="com.hiveview.customkeyboard/.SoftKeyboard";  //系统默认的输入法名称

        Intent intent = new Intent();
        intent.setAction("com.hiveview.inputmethod.switch");
        intent.putExtra(ACTION_INPUT_METHOD_CLASS_NAME,defaultClassName);
        startActivity(intent);
    }


}
