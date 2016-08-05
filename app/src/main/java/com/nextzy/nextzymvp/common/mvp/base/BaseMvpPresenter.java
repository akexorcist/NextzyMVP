package com.nextzy.nextzymvp.common.mvp.base;

/**
 * Created by Akexorcist on 8/1/16 AD.
 */
public abstract class BaseMvpPresenter<CV extends BaseMvpContractorView> implements BaseMvpContractorPresenter {
    private CV view;

    protected BaseMvpPresenter(CV view) {
        this.view = view;
        view.setPresenter(this);
    }

    public CV getView() {
        return view;
    }

    @Override
    public abstract void start();

    @Override
    public abstract void stop();
}
