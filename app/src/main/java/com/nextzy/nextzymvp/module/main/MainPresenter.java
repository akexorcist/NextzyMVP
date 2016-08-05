package com.nextzy.nextzymvp.module.main;

import com.nextzy.nextzymvp.common.mvp.NextzyPresenter;

/**
 * Created by Akexorcist on 8/1/16 AD.
 */
@SuppressWarnings("Convert2Lambda")
public class MainPresenter extends NextzyPresenter<MainContractor.View> implements MainContractor.Presenter {
    String message;

    public static MainPresenter createPresenter(MainContractor.View view) {
        return new MainPresenter(view);
    }

    private MainPresenter(MainContractor.View view) {
        super(view);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onButtonOkClicked() {
        getView().showSavedMessage(message);
    }

    @Override
    public void onButtonSaveClicked(String message) {
        setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
