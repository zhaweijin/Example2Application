package com.example2.test.di.component;


import com.example2.test.di.DITest;
import com.example2.test.di.module.AppModule;
import com.example2.test.di.module.GithubApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zwj on 5/31/18.
 */

@Singleton
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {
    // inject what
    void inject(DITest activity);
}
