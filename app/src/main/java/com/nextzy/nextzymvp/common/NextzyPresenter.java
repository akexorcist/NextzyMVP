package com.nextzy.nextzymvp.common;

import com.nextzy.nextzymvp.common.base.BaseMvpContractorPresenter;
import com.nextzy.nextzymvp.common.base.BaseMvpContractorView;
import com.nextzy.nextzymvp.common.base.BaseMvpPresenter;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class NextzyPresenter<CV extends BaseMvpContractorView> extends BaseMvpPresenter<CV> implements BaseMvpContractorPresenter {
    protected NextzyPresenter(CV view) {
        super(view);
    }
}
