package com.kbq.component.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.kbq.component.R;
import com.kbq.component.base.view.activity.BaseActivity;
import com.kbq.component.goods.RouterConfig;
import com.kbq.component.model.bean.TabBean;
import com.kbq.component.view.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private CommonTabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabBeanList = new ArrayList<>();


    @Override
    public int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        mTabLayout = getView(R.id.tab_layout);
        mViewPager = getView(R.id.view_pager);
        initViewPager();
    }

    @Override
    public void initData() {

    }

    private void initViewPager() {
        String[] titleList = {"首页", "商品", "购物车", "我的"};
        mTabBeanList.add(new TabBean(titleList[0], R.drawable.tab_home_select, R.drawable.tab_home_unselect));
        mTabBeanList.add(new TabBean(titleList[1], R.drawable.tab_speech_select, R.drawable.tab_speech_unselect));
        mTabBeanList.add(new TabBean(titleList[2], R.drawable.tab_contact_select, R.drawable.tab_contact_unselect));
        mTabBeanList.add(new TabBean(titleList[3], R.drawable.tab_more_select, R.drawable.tab_more_unselect));

        mFragmentList.add((Fragment) ARouter.getInstance().build("/home/homefragment").navigation());
        mFragmentList.add((Fragment) ARouter.getInstance().build(RouterConfig.GOODS_GOODS_FRAGMENT).navigation());
        mFragmentList.add((Fragment) ARouter.getInstance().build("/cart/cartfragment").navigation());
        mFragmentList.add((Fragment) ARouter.getInstance().build("/mine/minefragment").navigation());


        mTabLayout.setTabData(mTabBeanList);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList, titleList));
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
//                if (position == 0) {
//                    mTabLayout_2.showMsg(0, mRandom.nextInt(100) + 1);
////                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
//                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(0);
    }
}
