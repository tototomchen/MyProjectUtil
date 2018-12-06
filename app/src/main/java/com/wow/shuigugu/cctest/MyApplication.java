package com.wow.shuigugu.cctest;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

import com.wow.shuigugu.cctest.util.Density;

/**
 * Created by cl on 2018/11/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WindowManager wm = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth();



//        Density.setDensity(this,375);
    }
}
