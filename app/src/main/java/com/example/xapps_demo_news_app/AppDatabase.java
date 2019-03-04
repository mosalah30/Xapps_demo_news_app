package com.example.xapps_demo_news_app;

import com.example.xapps_demo_news_app.news.model.Articles;
import com.example.xapps_demo_news_app.news.model.local.NewsDao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
        Articles.class},
        version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NewsDao NewsDao();


}
