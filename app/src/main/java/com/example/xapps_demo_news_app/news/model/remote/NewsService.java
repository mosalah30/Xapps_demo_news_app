package com.example.xapps_demo_news_app.news.model.remote;

import com.example.xapps_demo_news_app.helper.livedata.ApiResponse;
import com.example.xapps_demo_news_app.news.model.NewsResponse;
import androidx.lifecycle.LiveData;
import retrofit2.http.GET;

public interface NewsService {

    @GET("top-headlines?country=eg&apiKey=6ba7df004b6846989b72984297bd7e70")
    LiveData<ApiResponse<NewsResponse>> getNews();

}
