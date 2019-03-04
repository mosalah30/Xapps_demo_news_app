package com.example.xapps_demo_news_app.news.viewmodel;


import com.example.xapps_demo_news_app.App;
import com.example.xapps_demo_news_app.helper.livedata.Resource;
import com.example.xapps_demo_news_app.helper.livedata.SingleLiveEvent;
import com.example.xapps_demo_news_app.news.CustomItemClickListener;
import com.example.xapps_demo_news_app.news.model.Articles;
import com.example.xapps_demo_news_app.news.model.repo.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {


    private final SingleLiveEvent<Articles> articleSingleLiveEvent = new SingleLiveEvent<>();
    private final CustomItemClickListener<Articles> articleCustomItemClickListener = (v, article) -> articleSingleLiveEvent.setValue(article);
    private final MutableLiveData<List<Articles>> mutableArticlesListLiveData;
    private LiveData<Resource<List<Articles>>> listArticlesLiveData;
    private androidx.lifecycle.Observer<Resource<List<Articles>>> articlesListObserver;
    private final MutableLiveData<Boolean> dataLoading;
    private final MutableLiveData<Boolean> showNoNetworkScreenEvent;
    private final SingleLiveEvent<String> errorMessageEvent;
    @Inject
    NewsRepository newsRepository;

    public NewsViewModel() {
        App.getAppComponent().inject(this);
        mutableArticlesListLiveData = new MutableLiveData<>();
        showNoNetworkScreenEvent = new MutableLiveData<>();
        dataLoading = new MutableLiveData<>();
        articlesListObserver = getArticlesListObserver();
        errorMessageEvent = new SingleLiveEvent<>();

    }

    public void getNewsList() {
        listArticlesLiveData = newsRepository.getAllNews();
        listArticlesLiveData.observeForever(articlesListObserver);
    }

    private Observer<Resource<List<Articles>>> getArticlesListObserver() {

        return listResource -> {
            if (listResource != null) {
                switch (listResource.getStatus()) {
                    case LOADING:
                        dataLoading.setValue(true);
                        showNoNetworkScreenEvent.setValue(false);

                        break;
                    case SUCCESS:
                        dataLoading.setValue(false);
                        if (listResource.getData() != null&&listResource.getData().size()>0) {
                            mutableArticlesListLiveData.setValue(listResource.getData());
                            showNoNetworkScreenEvent.setValue(false);

                        } else
                            showNoNetworkScreenEvent.setValue(true);

                        break;
                    case ERROR:
                        dataLoading.setValue(false);
                        errorMessageEvent.setValue(listResource.message);
                        break;

                }
            }
        };
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (listArticlesLiveData != null)
            listArticlesLiveData.removeObserver(articlesListObserver);
    }

    public MutableLiveData<List<Articles>> getMutableArticlesListLiveData() {
        return mutableArticlesListLiveData;
    }

    public MutableLiveData<Boolean> getDataLoading() {
        return dataLoading;
    }

    public MutableLiveData<Boolean> getShowNoNetworkScreenEvent() {
        return showNoNetworkScreenEvent;
    }

    public CustomItemClickListener<Articles> getArticleCustomItemClickListener() {
        return articleCustomItemClickListener;
    }

    public SingleLiveEvent<String> getErrorMessageEvent() {
        return errorMessageEvent;
    }

    public SingleLiveEvent<Articles> getArticleSingleLiveEvent() {
        return articleSingleLiveEvent;
    }
}
