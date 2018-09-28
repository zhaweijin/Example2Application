package com.example2.test.reflect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example2.test.base.BaseActivity;
import com.example2.test.utils.ReflectUtils;

import java.lang.reflect.Method;

/**
 * Created by zwj on 8/21/18.
 */

public class ReflectTest extends BaseActivity{

    /**
     *
     * /** @hide */
      /*public static int checkUidPermission(String permission, int uid) {
        try {
            return AppGlobals.getPackageManager()
                    .checkUidPermission(permission, uid);
        } catch (RemoteException e) {
            // Should never happen, but if it does... deny!
            Slog.e(TAG, "PackageManager is dead?!?", e);
        }
        return PackageManager.PERMISSION_DENIED;
    }
     *
     *
     */
    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, ReflectTest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getFeild();
    }


    private void invoke(){
         try {
             Class c;
             c = Class.forName("android.app.ActivityManager");
             Method m = c.getMethod("checkUidPermission", new Class[] {String.class, int.class});
             Object o = m.invoke(null, new Object[]{"android.permission.READ_CONTACTS", 10010});
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    private void getFeild(){
        Object rkDisplayOutputManager = null;
        try {
            rkDisplayOutputManager = Class.forName("android.os.RkDisplayOutputManager").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rkDisplayOutputManager == null)
            return;

        Log.v("test",">>>"+ReflectUtils.getFieldValue(rkDisplayOutputManager,"HDR_AUTO"));


    }

    private void setOverScanProperty(int direction) {
        Object rkDisplayOutputManager = null;
        try {
            rkDisplayOutputManager = Class.forName("android.os.RkDisplayOutputManager").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rkDisplayOutputManager == null)
            return;

        ReflectUtils.invokeMethod(rkDisplayOutputManager, "setOverScan", new Class[]{int.class, int.class, int.class}, new Object[]{22, 0, 3});

        // save config
        ReflectUtils.invokeMethod(rkDisplayOutputManager, "saveConfig", new Class[]{}, new Object[]{});
    }

}
