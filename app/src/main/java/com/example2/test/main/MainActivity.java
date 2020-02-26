package com.example2.test.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example2.test.R;
import com.example2.test.permission.RequestPermission;
import com.example2.test.webview.WebTest;

public class MainActivity extends Activity {



    private static final String TAG = "main";
    private Object o = new Object();


    public static void startAppFromName(Context context, String packageName, String activityName){
        Intent mIntent = new Intent();
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName comp = new ComponentName(packageName,activityName);
        mIntent.setComponent(comp);
        context.startService(mIntent);
    }


    public void startAppFromName2(String packageName, String activityName){
        Intent mIntent = new Intent();
        //mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName comp = new ComponentName(packageName,activityName);
        mIntent.setComponent(comp);
        startActivityForResult(mIntent,3);
    }

    private void startAppFromPackageName(Context context,String packagename){
        Intent intent = getPackageManager().getLaunchIntentForPackage(packagename);
        if (intent != null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("test","requestCode="+requestCode+",resultCode="+resultCode);
    }

    private int getRandomTime(){
        return  (int)(1+Math.random()*(3600));
    }

    int pos = 0;
    private LinearLayout layout;
    private int w;
    private int h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.click);
        w = layout.getLayoutParams().width;
        h = layout.getLayoutParams().height;
        Log.v("test","w="+w+",h="+h);


        Button test = (Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();
                layout.setRotation(90);
                /*layoutParams.height = 1280;
                layoutParams.width = 720;
                layout.setLayoutParams(layoutParams);*/

            }
        });

        //WebTest.launch(this);

        //RequestPermission.launch(this);

        //Log.v("test","time="+getRandomTime());
        /*RelativeLayout click = (RelativeLayout)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("aa","wff232f32f");
            }
        });

        List<String> list = new ArrayList<>();
        list.add("http://192.168.31.107:80/a.jpg");
        list.add("http://192.168.31.107:80/b.jpg");
        list.add("http://192.168.31.107:80/c.jpg");



        ImageView image = (ImageView)findViewById(R.id.image);
        Glide.with(this).load(list.get(pos)).into(image);
        pos++;

        Disposable interval_disposable = io.reactivex.Observable.interval(8, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        if(pos>=list.size()){
                            pos=0;
                        }
                        Log.v("aa","p="+pos);
                        ImageView image = (ImageView)findViewById(R.id.image);
                        Glide.with(MainActivity.this).load(list.get(pos)).crossFade(2000).into(image);
                        pos++;
                    }
                });*/


        //registerReceiver();

        //RotationAnimalTest.launch(this);
        //startAppFromName2("com.nextclass.ai.settings","com.nextclass.ai.settings.main.NetworkManagerActivity");

        //startAppFromName(this,"com.android.settings","Settings");

        //startAppFromPackageName("com.hiveview.clear.manager");

        //FGActivity.launch(this);

        //FloatWindowTest.launch(this);

//        DITest.launch(this);
        //Rx2Test.launch(this);

//        UtilTest.launch(this);


        //JsoupActivity.launch(this);

        /*String filepath  = "/mnt/sdcard/PermRoot.apk";
        File file = new File(filepath);
        PUtils.print("file exist=="+file.exists());
        PUtils.print("file can read=="+file.canRead());*/


        //MessengerTestActivity.launch(this);
        //AnimationTest.launch(this);
//        ReflectTest.launch(this);

        //AndFixDemo.launch(this);
        //QueueTest.launch(this);
        //finish();



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
        ComponentName comp = new ComponentName("com.hiveview.dianshang.inputmanager","com.hiveview.dianshang.inputmanager.FGActivity");
        intent.setComponent(comp);
        startActivity(intent);*/




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver();
    }

    private VolumeBroadcastReceiver mVolumeBroadcastReceiver;

    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";

    /**
     *     * 注册音量广播接收器
     *     * @return
     *    
     */
    public void registerReceiver() {
        mVolumeBroadcastReceiver = new VolumeBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(VOLUME_CHANGED_ACTION);
        registerReceiver(mVolumeBroadcastReceiver, filter);
    }


    /**
     * * 解注册音量广播监听器，需要与 registerReceiver 成对使用
     *    
     */
    public void unregisterReceiver() {
        try {
            unregisterReceiver(mVolumeBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class VolumeBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //媒体音量改变才通知
            Log.v(TAG,"action=="+intent.getAction());
            if (VOLUME_CHANGED_ACTION.equals(intent.getAction())) {
                AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                Log.v(TAG, "broadVolume:" + currentVolume);
            }
        }
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


    final static int COUNTS = 5;//点击次数
    final static long DURATION = 5 * 1000;//规定有效时间
    long[] mHits = new long[COUNTS];

    /**
     * 连续点击多次退出
     */
    private void exitAfterMany() {

        //复位处理，超过规定的时间，把数组清空
        long lasttime=0;
        for (int i = 0; i < mHits.length ; i++) {
            if(mHits[i]!=0){
                lasttime = mHits[i];
                break;
            }
        }
        Log.v("test","#######lasttime="+lasttime);
        long nowtime = SystemClock.uptimeMillis();
        Log.v("test","nowtime="+nowtime);
        if(lasttime>0 && (nowtime- lasttime > DURATION)){
            mHits = new long[COUNTS];
            Log.v("test","reset");
        }

        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
        //实现左移，然后最后一个位置更新距离开机的时间，如果最后一个时间和最开始时间小于DURATION，即连续5次点击
        mHits[mHits.length - 1] = nowtime;

        for (int i = 0; i < mHits.length; i++) {
            Log.v("test","array "+mHits[i]);
        }

        if ((mHits[mHits.length - 1] - mHits[0] <= DURATION)) {
            String tips = "您已在[" + DURATION + "]ms内连续点击【" + mHits.length + "】次了！！！";
            Toast.makeText(MainActivity.this, tips, Toast.LENGTH_SHORT).show();
            finish();
        }
    }



}
