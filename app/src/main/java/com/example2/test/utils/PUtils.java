package com.example2.test.utils;

import android.util.Log;

/**
 * Created by zwj on 6/8/18.
 */

public class PUtils {
    private final static String tag =  "test";
    private final static boolean DEBUG = true;

    public static void print(String msg){
        if(DEBUG) Log.v(tag,msg);
    }


}
