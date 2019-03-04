package com.example.xapps_demo_news_app.di.module;

import android.app.Application;
import com.example.xapps_demo_news_app.AppDatabase;
import com.example.xapps_demo_news_app.news.model.local.NewsDao;

import javax.inject.Singleton;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohamed Khaled on Thu, 09/Aug/2018 at 1:01 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
@Module
public class DaoModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Application app) {
        return Room.databaseBuilder(app,
                AppDatabase.class, "xapps_demo_localDB.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public NewsDao provideNewsDao(AppDatabase appDatabase) {
        return appDatabase.NewsDao();
  }

}
