package com.example.xapps_demo_news_app.di.module;

import com.example.xapps_demo_news_app.news.model.remote.NewsService;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Mohamed Khaled on Thu, 09/Aug/2018 at 1:01 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public NewsService providesNewsService(Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }


}
