package com.nextzy.myais.common.mvp.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

/**
 * Created by Akexorcist on 8/9/16 AD.
 */
public class NextzyImageLoader {
    private static NextzyImageLoader imageLoader;

    public static NextzyImageLoader getInstance() {
        if (imageLoader == null) {
            imageLoader = new NextzyImageLoader();
        }
        return imageLoader;
    }

    public Target<GlideDrawable> load(Context context, String url, ImageView imageView) {
        return Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    public Target<GlideDrawable> load(android.support.v4.app.Fragment fragment, String url, ImageView imageView) {
        return load(fragment.getActivity(), url, imageView);
    }

    public Target<GlideDrawable> load(android.app.Fragment fragment, String url, ImageView imageView) {
        return load(fragment.getActivity(), url, imageView);
    }

    private Target loadBitmap(Context context, String url, SimpleTarget<Bitmap> target) {
        return Glide.with(context).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(target);
    }

    public Target loadBitmap(Context context, final String url, final BitmapLoaderCallback callback) {
        return loadBitmap(context, url, new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                callback.onBitmapReady(url, bitmap);
            }
        });
    }

    public Target loadBitmap(android.support.v4.app.Fragment fragment, final String url, final BitmapLoaderCallback callback) {
        return loadBitmap(fragment.getActivity(), url, new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                callback.onBitmapReady(url, bitmap);
            }
        });
    }

    public Target loadBitmap(android.app.Fragment fragment, final String url, final BitmapLoaderCallback callback) {
        return loadBitmap(fragment.getActivity(), url, new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                callback.onBitmapReady(url, bitmap);
            }
        });
    }

    public interface BitmapLoaderCallback {
        void onBitmapReady(String url, Bitmap bitmap);
    }

    public Target<GifDrawable> loadGif(Context context, String url, ImageView imageView) {
        return Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    public Target<GifDrawable> loadGif(android.support.v4.app.Fragment fragment, String url, ImageView imageView) {
        return loadGif(fragment.getActivity(), url, imageView);
    }

    public Target<GifDrawable> loadGif(android.app.Fragment fragment, String url, ImageView imageView) {
        return loadGif(fragment.getActivity(), url, imageView);
    }
}
