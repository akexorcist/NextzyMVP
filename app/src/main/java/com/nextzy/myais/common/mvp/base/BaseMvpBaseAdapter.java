package com.nextzy.myais.common.mvp.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class BaseMvpBaseAdapter<CP extends BaseMvpContractorPresenter> extends FragmentStatePagerAdapter implements BaseMvpContractorView<CP> {
    private CP presenter;

    public BaseMvpBaseAdapter(FragmentManager fm) {
        super(fm);
        createPresenter();
    }

    public abstract void createPresenter();

    public CP getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }
}
