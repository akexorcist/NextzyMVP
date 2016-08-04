package com.nextzy.nextzymvp.module.main;

import com.nextzy.nextzymvp.common.base.BaseContractorPresenter;
import com.nextzy.nextzymvp.common.base.BaseContractorView;

/**
 * Created by Akexorcist on 8/1/16 AD.
 */
public class MainContractor {

    public interface Presenter extends BaseContractorPresenter {
        void onButtonOkClicked();

        void onButtonSaveClicked(String message);

        String getMessage();

        void setMessage(String message);
    }

    public interface View extends BaseContractorView<Presenter> {
        void showToastMessage();

        void showSavedMessage(String message);
    }

}
