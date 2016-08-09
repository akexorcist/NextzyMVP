package com.nextzy.myais.common.mvp;

import com.nextzy.myais.common.mvp.base.BaseMvpContractorPresenter;
import com.nextzy.myais.common.mvp.base.BaseMvpContractorView;
import com.nextzy.myais.common.mvp.base.BaseMvpPresenter;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class NextzyPresenter<CV extends BaseMvpContractorView> extends BaseMvpPresenter<CV> implements BaseMvpContractorPresenter {
    protected NextzyPresenter(CV view) {
        super(view);
    }
}
