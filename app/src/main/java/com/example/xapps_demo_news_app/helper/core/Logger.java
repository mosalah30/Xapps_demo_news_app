package com.example.xapps_demo_news_app.helper.core;

import android.util.Log;

import com.example.xapps_demo_news_app.BuildConfig;


/**
 * Created by Mohamed Khaled on Thu, 09/Aug/2018 at 1:01 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class Logger {

    private static final String TAG = "Gatjet";

    /**
     * @param str
     */
    public static void v(String str) {
        if (BuildConfig.DEBUG)
            Log.v(TAG, str);
    }

    /**
     * @param str
     */
    public static void i(String str) {
        if (BuildConfig.DEBUG)
            Log.i(TAG, str);
    }

    /**
     * @param str
     * @param e
     */
    public static void e(String str, Throwable e) {
        if (BuildConfig.DEBUG)
            Log.e(TAG, str, e);
    }

    /**
     * @param str
     */
    public static void d(String str) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, str);
    }

}

