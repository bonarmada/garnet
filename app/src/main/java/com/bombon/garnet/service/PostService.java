package com.bombon.garnet.service;

import com.bombon.garnet.dagger.remote.PostRemote;
import com.bombon.garnet.model.Post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by Vaughn on 7/10/17.
 */

public class PostService {
    private static PostRemote remote;

    @Inject
    PostService(PostRemote remote) {
        this.remote = remote;
    }

    public static void getPosts(final ServiceCallback callback) {
        remote.getPosts().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<Post>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Response<List<Post>> response) {
                        callback.getResult(response.code(), response.body());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.getResult(((HttpException) e).code(), null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void getPost(int id){
        remote.getPost(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<Post>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Response<Post> postResponse) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
