package com.example2.test.di;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example2.test.di.component.AppComponent;
import com.example2.test.base.Example2Application;

import butterknife.ButterKnife;


/**
 * Created by zwj on 5/31/18.
 */

public abstract class DIBaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setupActivityComponent(Example2Application.getsInstance().getAppComponent());
    }



    protected abstract void setupActivityComponent(AppComponent appComponent);
}

