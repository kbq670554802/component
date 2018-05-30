package com.kbq.component.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Author: 柯葆青
 * Date: 2018/05/30
 * Description: BaseFragment
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(attachLayoutRes(), null);
        initUI();
        initData();
        return mRootView;
    }

    public abstract int attachLayoutRes();

    public abstract void initUI();

    public abstract void initData();

    public <E extends View> E getView(int resId) {
        try {
            return (E) mRootView.findViewById(resId);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

    @Override
    public void onClick(View v) {
    }
}