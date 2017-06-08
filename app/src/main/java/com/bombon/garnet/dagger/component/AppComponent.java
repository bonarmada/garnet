package com.bombon.garnet.dagger.component;

import com.bombon.garnet.MainActivity;
import com.bombon.garnet.dagger.module.ContextModule;
import com.bombon.garnet.dagger.module.PostServiceModule;
import com.bombon.garnet.dagger.scope.AppScope;

import dagger.Component;

/**
 * Created by Vaughn on 6/8/17.
 */

@AppScope
@Component(modules = {ContextModule.class, PostServiceModule.class})

public interface AppComponent {
    void inject(MainActivity activity);
}
