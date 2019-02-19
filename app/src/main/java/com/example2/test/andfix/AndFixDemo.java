package com.example2.test.andfix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alipay.euler.andfix.patch.PatchManager;
import com.example2.test.R;
import com.example2.test.base.BaseActivity;

import butterknife.BindView;

public class AndFixDemo extends BaseActivity{

    @BindView(R.id.bug)
    Button bug;

    @BindView(R.id.fix)
    Button fix;


    private String path = "/mnt/sdcard/carter.apatch";


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, AndFixDemo.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andfix_demo_main);


        bug.setOnClickListener(onClickListener);
        fix.setOnClickListener(onClickListener);
    }



    public void bugTest(){
        String output = null;
        Log.v("test",output);
    }

    public void fixTest(){
        AndFixManager.getInstance().addPatch(path);
    }


    View.OnClickListener onClickListener = v -> {
        switch (v.getId()) {
            case R.id.bug:
                bugTest();
                break;
            case R.id.fix:
                fixTest();
                break;
            default:
                break;
        }
    };
}

