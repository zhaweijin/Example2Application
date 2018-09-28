package com.example2.test.di;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example2.test.di.api.GithubApiService;
import com.example2.test.di.component.AppComponent;
import com.example2.test.di.model.BaseData;
import com.example2.test.di.model.TestData;
import com.example2.test.utils.RxUtils;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;


/**
 * Created by zwj on 5/31/18.
 */

public class DITest extends DIBaseActivity {

    /**
     * 注入方法，编译耗时太久.暂不考虑
     */

    @Inject
    GithubApiService githubApiService;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, DITest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        githubApiService.getRepoData(1)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new Consumer<BaseData<TestData>>() {
                    @Override
                    public void accept(BaseData<TestData> testDataBaseData) throws Exception {
                        Log.v("test", ">>>>" + testDataBaseData.getData().getTotal());
                    }
                }, throwable -> {
                    Log.v("test","error");
                });

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }
}
