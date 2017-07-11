package com.bombon.garnet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bombon.garnet.R;
import com.bombon.garnet.model.Post;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vaughn on 7/11/17.
 */

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostRecyclerViewAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }
    public PostRecyclerViewAdapter(List<Post> posts){
        this.posts = posts;
    }

    public void refresh(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_post, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Bind ui objects here
        @BindView(R.id.id) TextView id;
        @BindView(R.id.title) TextView title;
        @BindView(R.id.body) TextView body;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post post = posts.get(position);

        holder.id.setText(post.getId() + "");
        holder.title.setText(post.getTitle() + "");
        holder.body.setText(post.getBody() + "");
    }
}
