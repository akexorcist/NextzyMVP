package com.nextzy.myais.common.mvp;

import android.support.v4.app.FragmentManager;

import com.nextzy.myais.common.mvp.base.BaseMvpBaseAdapter;
import com.nextzy.myais.common.mvp.base.BaseMvpContractorPresenter;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class NextzyBaseAdapter<CP extends BaseMvpContractorPresenter> extends BaseMvpBaseAdapter<CP> {
    public NextzyBaseAdapter(FragmentManager fm) {
        super(fm);
    }
}
