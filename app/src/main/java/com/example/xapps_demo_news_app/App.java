package com.example.xapps_demo_news_app;

import android.content.Context;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.xapps_demo_news_app.di.AppComponent;

import com.example.xapps_demo_news_app.di.DaggerAppComponent;
import com.example.xapps_demo_news_app.di.module.ApiModule;
import com.example.xapps_demo_news_app.di.module.AppModule;
import com.example.xapps_demo_news_app.di.module.DaoModule;
import com.example.xapps_demo_news_app.di.module.NetModule;

import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {

    private static AppComponent appComponent;
    private static App instance;


    public static Context get() {
        return instance;
    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ImageViewTarget.setTagId(R.id.glide_custom_view_target_tag);
        appComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this))
                .apiModule(new ApiModule())
              .netModule(new NetModule("https://newsapi.org/v2/"))
                .daoModule(new DaoModule())
                .build();
    }



}
