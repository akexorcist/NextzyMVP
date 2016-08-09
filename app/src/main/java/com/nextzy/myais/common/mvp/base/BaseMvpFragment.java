package com.nextzy.myais.common.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class BaseMvpFragment<CP extends BaseMvpContractorPresenter> extends Fragment implements BaseMvpContractorView<CP> {
    private CP presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            restoreArgument(getArguments());
        } else {
            restoreInstanceState(savedInstanceState);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(getLayoutView(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView();
        setupView();
        createPresenter();
        if (savedInstanceState == null) {
            initialize();
        } else {
            restoreView();
        }
    }

    public abstract int getLayoutView();

    protected abstract void createPresenter();

    public abstract void bindView();

    public abstract void setupView();

    public abstract void restoreArgument(Bundle bundle);

    public abstract void initialize();

    public abstract void restoreInstanceState(Bundle savedInstanceState);

    public abstract void restoreView();

    public abstract void saveInstanceState(Bundle outState);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    public CP getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }
}
