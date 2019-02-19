package com.example2.test.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.TextView;

import com.example2.test.R;
import com.example2.test.base.BaseActivity;

import butterknife.BindView;

public class LocationTest extends BaseActivity{

    private static final String TAG = "location";

    @BindView(R.id.location)
    TextView txt;

    private static final int REQUEST_CODE_PERMISSION = 2;
    // Storage Permissions
    private static String[] PERMISSIONS_REQ = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, LocationTest.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_test);


        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.M) {

            verifyPermissions(this);
        }


        Log.v(TAG,">>>onCreate");


        new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        }).start();
    }


    private void test(){
        try {
            String serviceString = Context.LOCATION_SERVICE;// 获取的是位置服务
            LocationManager locationManager = (LocationManager) getSystemService(serviceString);// 调用getSystemService()方法来获取LocationManager对象

            String provider = LocationManager.GPS_PROVIDER;// 指定LocationManager的定位方法
            Location location = locationManager.getLastKnownLocation(provider);

            while(location  == null)
            {
                locationManager.requestLocationUpdates("gps", 60000, 1, locationListener);
            }

            if(location==null) return;
            double lat = location.getLatitude();//获取纬度
            double lng = location.getLongitude();//获取经度

            Log.v(TAG,"LAT=="+lat);
            Log.v(TAG,"LNG=="+lng);

            //txt.setText("LAT=="+lat+",LNG=="+lng);


            locationManager.requestLocationUpdates(provider, 2000, 10,locationListener);// 产生位置改变事件的条件设定为距离改变10米，时间间隔为2秒，设定监听位置变化

        } catch (SecurityException e) {
            e.printStackTrace();
            Log.v(TAG,e.getMessage());
        }catch (Exception e){

            Log.v(TAG,e.getMessage());
        }

    }

    private static boolean verifyPermissions(Activity activity) {
        // Check if we have write permission
        int write_permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        int read_persmission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION);


        if (write_permission != PackageManager.PERMISSION_GRANTED ||
                read_persmission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_REQ,
                    REQUEST_CODE_PERMISSION
            );
            return false;
        } else {
            return true;
        }
    }


    private final LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            if(location==null)return;
            double lat = location.getLatitude();//获取纬度
            double lng = location.getLongitude();//获取经度

            Log.v(TAG,"listener LAT=="+lat);
            Log.v(TAG,"listener LNG=="+lng);
            txt.setText("listener LAT=="+lat+",LNG=="+lng);
        }

        @Override
        public void onProviderDisabled(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
            // TODO Auto-generated method stub

        }

    };
}
