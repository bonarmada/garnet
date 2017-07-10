package com.bombon.garnet.service;

import android.util.Log;

import com.bombon.garnet.dagger.remote.PostRemote;
import com.bombon.garnet.model.Post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vaughn on 7/10/17.
 */

public class PostService {
    private static PostRemote remote;

    @Inject
    PostService(PostRemote remote) {
        this.remote = remote;
    }


    public static void getPosts() {
        remote.getPosts().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("hehe", "OnSubscribe()");
                    }

                    @Override
                    public void onNext(@NonNull List<Post> posts) {
                        for (Post post: posts){
                            Log.i("loop", post.getTitle());
                        }
                        Log.i("hehe", "onNext()");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Log.i("hehe", "onError()");
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
