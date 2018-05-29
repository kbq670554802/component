package com.kbq.component.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentList;
    private String[] mTitleList;

    public ViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragmentList,String[] titleList) {
        super(fm);
        mFragmentList = fragmentList;
        mTitleList = titleList;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
}