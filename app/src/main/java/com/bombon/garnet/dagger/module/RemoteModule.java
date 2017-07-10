package com.bombon.garnet.dagger.module;

import com.bombon.garnet.dagger.scope.AppScope;
import com.bombon.garnet.dagger.remote.PostRemote;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Vaughn on 6/8/17.
 */

@Module(includes = NetworkModule.class)
public class RemoteModule {
    @Provides
    @AppScope
    PostRemote providePostRemote(Retrofit retrofit){
        return retrofit.create(PostRemote.class);
    }
}
