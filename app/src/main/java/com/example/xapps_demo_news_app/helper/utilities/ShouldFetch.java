package com.example.xapps_demo_news_app.helper.utilities;


import com.example.xapps_demo_news_app.App;

/**
 * Created by Mohamed Khaled on Mon, 15/Oct/2018 at 11:52 AM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class ShouldFetch {
    public static boolean networkRecommended() {
        return NetworkUtils.isNetworkAvailable(App.get());
    }
}
