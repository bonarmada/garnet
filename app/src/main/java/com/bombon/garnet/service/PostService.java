package com.bombon.garnet.service;


import com.bombon.garnet.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vaughn on 6/5/17.
 */

public interface PostService {
    @GET("/posts")
    Observable<List<Post>> getPosts();

    @GET("/posts/{id}")
    Observable<Post> getPost(@Path("id") int id);
}
