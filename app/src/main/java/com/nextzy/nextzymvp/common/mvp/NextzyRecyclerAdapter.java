package com.nextzy.nextzymvp.common.mvp;

import android.support.v7.widget.RecyclerView;

import com.nextzy.nextzymvp.common.mvp.base.BaseMvpContractorPresenter;
import com.nextzy.nextzymvp.common.mvp.base.BaseMvpRecyclerAdapter;

/**
 * Created by Akexorcist on 8/5/16 AD.
 */
public abstract class NextzyRecyclerAdapter<VH extends RecyclerView.ViewHolder, CP extends BaseMvpContractorPresenter> extends BaseMvpRecyclerAdapter<VH, CP> {
}
