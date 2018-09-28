package com.example2.test.jsoup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.blankj.utilcode.util.Utils;
import com.example2.test.base.BaseActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by zwj on 8/23/18.
 */

public class JsoupActivity extends BaseActivity{

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, JsoupActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("test","density=="+Utils.getApp().getResources().getDisplayMetrics().density);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                     try {

                         Document doc = Jsoup.connect("http://qiushibaike.com/8hr/page/"+i+"/").get();
                         Elements els = doc.select("a.contentHerf");
                         //Log.v("test","内容1=="+els.toString());
                         for (int j = 0; j < els.size(); j++) {
                             Element el = els.get(j);
                             String herf = el.attr("herf");
                             //Log.v("test","title=="+el.text());

                             Document doc_detail = Jsoup.connect("http://www.qiushibaike.com").get();
                             Elements els_detail = doc_detail.select(".content");
                             Log.v("test","content="+els_detail.toString());
                             Elements els_pic = els_detail.select(".thumb img[src$=jpg]");
                             if(!els_pic.isEmpty()){
                                 String pic = els_pic.attr("src");
                                 Log.v("test","pic="+pic);
                             }
                         }
                     } catch (Exception e) {
                         e.printStackTrace();
                     }

                }
            }
        }).start();
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);

    }




    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
