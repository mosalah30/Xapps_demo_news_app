package com.example.xapps_demo_news_app.news.model.local;

import com.example.xapps_demo_news_app.news.model.Articles;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


@Dao
public interface NewsDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNews(Articles articles);

@Query("SELECT * FROM news")
    LiveData<List<Articles>>getAllNews();
}
