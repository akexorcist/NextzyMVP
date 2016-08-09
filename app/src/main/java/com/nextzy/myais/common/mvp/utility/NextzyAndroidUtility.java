package com.nextzy.myais.common.mvp.utility;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Akexorcist on 8/9/16 AD.
 */
public class NextzyAndroidUtility {
    private static NextzyAndroidUtility utility;

    public static NextzyAndroidUtility getInstance() {
        if (utility == null) {
            utility = new NextzyAndroidUtility();
        }
        return utility;
    }

    public float getPixelFromDp(Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }

    public float getDpFromPixel(Context context, float px) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / (metrics.densityDpi / 160f);
    }

    public int getDrawableResourceByFilename(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
    }

    public int getMipmapResourceByFilename(Context context, String filename) {
        return context.getResources().getIdentifier(filename, "mipmap", context.getPackageName());
    }

    public String getAppVersion(Context context) {
        String version = "0.0";
        try {
            PackageInfo infos = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = infos.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public void hideKeyboard(Activity activity) {
        if (activity != null) {
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}
