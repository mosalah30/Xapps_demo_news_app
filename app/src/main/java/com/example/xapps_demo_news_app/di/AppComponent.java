package com.example.xapps_demo_news_app.di;
import com.example.xapps_demo_news_app.di.module.ApiModule;
import com.example.xapps_demo_news_app.di.module.AppModule;
import com.example.xapps_demo_news_app.di.module.DaoModule;
import com.example.xapps_demo_news_app.di.module.NetModule;
import com.example.xapps_demo_news_app.news.viewmodel.NewsViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mohamed Khaled on Thu, 09/Aug/2018 at 1:01 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                NetModule.class,
                DaoModule.class,
                ApiModule.class
        }
)

public interface AppComponent {

    void inject(NewsViewModel newsViewModel);

}
