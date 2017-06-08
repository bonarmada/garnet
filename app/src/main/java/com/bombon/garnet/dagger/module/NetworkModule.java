package com.bombon.garnet.dagger.module;

import android.app.Application;
import android.content.Context;

import com.bombon.garnet.dagger.scope.AppScope;
import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Vaughn on 6/7/17.
 */

@Module
public class NetworkModule {
    String mBaseUrl;

    public NetworkModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @AppScope
    HttpLoggingInterceptor provideLogginInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i("OkHttp", message);
            }
        });
    }

    @Provides
    @AppScope
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @AppScope
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @AppScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @AppScope
    Picasso providePicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context).downloader(okHttp3Downloader).build();
    }

    @Provides
    @AppScope
    OkHttp3Downloader provideOkHttpDownloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}