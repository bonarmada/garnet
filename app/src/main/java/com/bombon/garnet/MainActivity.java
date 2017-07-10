package com.bombon.garnet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bombon.garnet.service.PostService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    PostService postService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(MainActivity.this);

        postService.getPosts();
    }
}
