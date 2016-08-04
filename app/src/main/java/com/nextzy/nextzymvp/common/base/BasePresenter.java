package com.nextzy.nextzymvp.common.base;

/**
 * Created by Akexorcist on 8/1/16 AD.
 */
public abstract class BasePresenter<CV extends BaseContractorView> implements BaseContractorPresenter {
    private CV view;

    protected BasePresenter(CV view) {
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
