package com.nextzy.myais.common.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.akexorcist.localizationactivity.LocalizationActivity;

/**
 * Created by Akexorcist on 8/1/16 AD.
 */
public abstract class BaseMvpActivity<CP extends BaseMvpContractorPresenter> extends LocalizationActivity implements BaseMvpContractorView<CP> {
    private CP presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        bindView();
        setupView();
        createPresenter();

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent != null) {
                restoreArgument(intent.getExtras());
            }
            initialize();
        }
    }

    public abstract int getLayoutView();

    protected abstract void createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public abstract void bindView();

    public abstract void setupView();

    public abstract void restoreArgument(Bundle bundle);

    public abstract void initialize();

    public abstract void restoreInstanceState(Bundle savedInstanceState);

    public abstract void restoreView();

    public abstract void saveInstanceState(Bundle outState);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreInstanceState(savedInstanceState);
        restoreView();
    }

    public CP getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }
}
