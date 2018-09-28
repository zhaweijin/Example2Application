package com.example2.test.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.example2.test.di.component.AppComponent;
import com.example2.test.di.component.DaggerAppComponent;
import com.example2.test.di.module.AppModule;
import com.example2.test.di.module.GithubApiModule;


/**
 * Created by carter on 2/28/17.
 */
public class Example2Application extends Application {

    private AppComponent appComponent;

    private static Example2Application sInstance;

    private void setupCompoent(){
        appComponent = DaggerAppComponent.builder()
                .githubApiModule(new GithubApiModule())
                .appModule(new AppModule(this))
                .build();
    }


    public static Example2Application getsInstance() {
        return sInstance;
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Utils.init(sInstance);
        setupCompoent();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    @Override
    public void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }



}
