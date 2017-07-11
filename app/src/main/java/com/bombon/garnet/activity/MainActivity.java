package com.bombon.garnet.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bombon.garnet.App;
import com.bombon.garnet.R;
import com.bombon.garnet.adapter.PostRecyclerViewAdapter;
import com.bombon.garnet.model.Post;
import com.bombon.garnet.service.PostService;
import com.bombon.garnet.service.ServiceCallback;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    PostService postService;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private PostRecyclerViewAdapter adapter;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App)getApplication()).getComponent().inject(this);

        setupUi();
        fetchDataFromSource();
    }

    private void setupUi() {
        adapter = new PostRecyclerViewAdapter(posts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void fetchDataFromSource() {
        postService.getPosts(new ServiceCallback<List<Post>>() {
            @Override
            public void getResult(int statusCode, List<Post> object) {
                Log.i(TAG, statusCode + "");
                if (statusCode == 200){
                    adapter.refresh(object);
                }
            }
        });
    }
}
