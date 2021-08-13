package com.aitymkiv.belgorod_travelfuide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.myViewHolder>{

    private final List<NewsItem> news;

    public NewsAdapter( List<NewsItem> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.myViewHolder holder, int position) {
        NewsItem newsItem = news.get(position);
        holder.newsImageView.setImageResource(newsItem.getImageRes());
        holder.headingNewsTextView.setText(newsItem.getHeading());
        holder.textNewsTextView.setText(newsItem.getNewsText());
        holder.dateNewsTextView.setText(newsItem.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = newsItem.getURINews();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        final ImageView newsImageView;
        final TextView headingNewsTextView, textNewsTextView, dateNewsTextView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = (ImageView)itemView.findViewById(R.id.newsImageView);
            headingNewsTextView = (TextView) itemView.findViewById(R.id.headingTextView);
            textNewsTextView = (TextView) itemView.findViewById(R.id.newsTextView);
            dateNewsTextView = (TextView) itemView.findViewById(R.id.dateTextView);
        }
    }
}
