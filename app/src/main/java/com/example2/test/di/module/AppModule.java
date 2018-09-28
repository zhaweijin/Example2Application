package com.example2.test.di.module;

import com.example2.test.base.Example2Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zwj on 5/31/18.
 */

@Module
public class AppModule {

    private final Example2Application application;

    public AppModule(Example2Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Example2Application provideApplicationContext() {
        return application;
    }
}
