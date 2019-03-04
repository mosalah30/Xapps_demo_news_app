package com.example.xapps_demo_news_app.news.model.repo;

import com.example.xapps_demo_news_app.helper.core.AppExecutors;
import com.example.xapps_demo_news_app.helper.livedata.ApiResponse;
import com.example.xapps_demo_news_app.helper.livedata.NetworkBoundResource;
import com.example.xapps_demo_news_app.helper.livedata.Resource;
import com.example.xapps_demo_news_app.helper.utilities.ShouldFetch;
import com.example.xapps_demo_news_app.news.model.Articles;
import com.example.xapps_demo_news_app.news.model.NewsResponse;
import com.example.xapps_demo_news_app.news.model.local.NewsDao;
import com.example.xapps_demo_news_app.news.model.remote.NewsService;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
@Singleton
public class NewsRepository {
    private NewsDao newsDao;
    private NewsService newsService;
    private AppExecutors appExecutors;

@Inject
    public NewsRepository(NewsDao newsDao, NewsService newsService) {
        this.newsDao = newsDao;
        this.newsService = newsService;
        this.appExecutors = new AppExecutors();
    }


    public LiveData<Resource<List<Articles>>> getAllNews() {
        return new NetworkBoundResource<List<Articles>, NewsResponse>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull NewsResponse item) {
                for (Articles articles : item.getArticles()) {
                    newsDao.insertNews(articles);
                }
            }

            @Override
            protected void onFetchFailed() {
                loadFromDb();
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Articles> data) {
                return ShouldFetch.networkRecommended();
            }

            @NonNull
            @Override
            protected LiveData<List<Articles>> loadFromDb() {
                return newsDao.getAllNews();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<NewsResponse>> createCall() {
                return newsService.getNews();
            }
        }.asLiveData();
    }
}
