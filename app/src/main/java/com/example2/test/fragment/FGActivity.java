package com.example2.test.fragment;



import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example2.test.R;
import com.example2.test.base.BaseActivity;

public class FGActivity extends BaseActivity implements BackHandledInterface {


    private BackHandledFragment mBackHandedFragment;
    private Button btnSecond;

    private static final String TAG = "FG";

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, FGActivity.class);
        activity.startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_stack_test);
        btnSecond = (Button) findViewById(R.id.button);
        btnSecond.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                loadFragment();
                btnSecond.setVisibility(View.GONE);
            }
        });

    }


    public void loadFragment() {
        FirstFragment fragment = new FirstFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.firstFragment, fragment);
        //ft.addToBackStack("tag");
        ft.commitAllowingStateLoss();
    }

    @Override
    public void setSelectedFragment(BackHandledFragment selectedFragment) {
        this.mBackHandedFragment = selectedFragment;

    }

    @Override
    public void onBackPressed() {
        Log.v(TAG,"onBack...");
        if (mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()) {


            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            } else {
                /*if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                    btnSecond.setVisibility(View.VISIBLE);
                }*/
                getSupportFragmentManager().popBackStack();
            }
        }
    }



}