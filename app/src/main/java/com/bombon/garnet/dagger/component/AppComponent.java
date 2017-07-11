package com.bombon.garnet.dagger.component;

import com.bombon.garnet.activity.MainActivity;
import com.bombon.garnet.dagger.module.RemoteModule;
import com.bombon.garnet.dagger.scope.AppScope;

import dagger.Component;

/**
 * Created by Vaughn on 6/8/17.
 */

@AppScope
@Component(modules = RemoteModule.class)

public interface AppComponent {
    void inject(MainActivity activity);
}
