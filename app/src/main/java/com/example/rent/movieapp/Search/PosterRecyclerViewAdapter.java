package com.example.rent.movieapp.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rent.movieapp.R;

import java.util.Collections;
import java.util.List;

import static butterknife.ButterKnife.findById;

public class PosterRecyclerViewAdapter extends RecyclerView.Adapter<PosterRecyclerViewAdapter.ViewHolder> {

    private List<String> urls = Collections.emptyList();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_layout, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.posterImageView.getContext()).load(urls.get(position)).into(holder.posterImageView);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView posterImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            posterImageView = findById(itemView, R.id.search_poster);
        }
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
        notifyDataSetChanged();
    }
}
