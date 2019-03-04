package com.example.xapps_demo_news_app.news;

import android.view.View;

public interface CustomItemClickListener<T> {
   void onItemClick(View v,T object);
}
