package com.example2.test.di.api;


import com.example2.test.di.model.BaseData;
import com.example2.test.di.model.TestData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by zwj on 5/31/18.
 */

public interface GithubApiService {

    String HOST = "http://www.wanandroid.com/";

    @GET("article/list/{num}/json")
    Observable<BaseData<TestData>> getRepoData(@Path("num") int num);
}


