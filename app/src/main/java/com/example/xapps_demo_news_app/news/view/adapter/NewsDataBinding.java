package com.example.xapps_demo_news_app.news.view.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xapps_demo_news_app.R;
import com.example.xapps_demo_news_app.news.CustomItemClickListener;
import com.example.xapps_demo_news_app.news.model.Articles;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class NewsDataBinding {

    @BindingAdapter({"articlesList", "onItemClicked"})
    public static void setupListNewsRecycler(RecyclerView view,
                                             List<Articles> articlesList,
                                             CustomItemClickListener<Articles> itemClickListener) {
        ListNewsAdapter adapter = new ListNewsAdapter(articlesList, itemClickListener);
        view.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.placeholderOf(R.drawable.enointernet))
                .into(view);
    }
}