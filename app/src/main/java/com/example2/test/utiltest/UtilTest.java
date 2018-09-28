package com.example2.test.utiltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.example2.test.base.BaseActivity;
import com.example2.test.utils.PUtils;


/**
 * Created by zwj on 8/16/18.
 */

public class UtilTest extends BaseActivity {


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, UtilTest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Log.v("test", "ping ---" + NetworkUtils.isAvailableByPing());

        /**
         * 请求的权限，对应AndroidManifest.xml定义的申请，两边都需要有
         */
        PermissionUtils.permission(PermissionConstants.CAMERA,PermissionConstants.STORAGE).request();

        PUtils.print("");

        LogUtils.v("");


    }


}