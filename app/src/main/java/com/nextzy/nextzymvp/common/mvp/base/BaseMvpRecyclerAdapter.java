package com.nextzy.nextzymvp.common.mvp.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class BaseMvpRecyclerAdapter<VH extends RecyclerView.ViewHolder, CP extends BaseMvpContractorPresenter> extends RecyclerView.Adapter<VH> implements BaseMvpContractorView<CP> {
    private CP presenter;

    public BaseMvpRecyclerAdapter() {
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
