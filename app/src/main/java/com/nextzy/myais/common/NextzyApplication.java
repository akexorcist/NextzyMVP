package com.nextzy.myais.common;

import android.app.Application;

import com.nextzy.myais.common.permission.NextzyPermission;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public class NextzyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NextzyPermission.initialize(getApplicationContext());
    }
}
