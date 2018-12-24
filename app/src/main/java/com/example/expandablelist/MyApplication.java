package com.example.expandablelist;

import android.app.Application;
import android.content.Context;

/**
 * Created by 增冠 on 2018/8/17.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
