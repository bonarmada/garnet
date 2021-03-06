package com.bombon.garnet;

import android.app.Application;

import com.bombon.garnet.dagger.component.AppComponent;
import com.bombon.garnet.dagger.component.DaggerAppComponent;
import com.bombon.garnet.dagger.module.ContextModule;
import com.bombon.garnet.dagger.module.NetworkModule;

/**
 * Created by Vaughn on 6/7/17.
 */

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule(Constants.BASE_URL))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}