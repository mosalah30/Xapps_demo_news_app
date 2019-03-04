package com.example.xapps_demo_news_app.news.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public  class NewsResponse {
    @SerializedName("articles")
    private List<Articles> articles;

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }
}
