package com.kbq.component.goods.view.activity;


import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.kbq.component.base.view.activity.BaseActivity;
import com.kbq.component.goods.R;
import com.kbq.component.goods.RouterConfig;

import java.util.List;

/**
 * Author: 柯葆青
 * Date: 2018/05/30
 * Description: 商品详情页
 */
@Route(path = RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY)
public class GoodsDetailActivity extends BaseActivity {

    private TextView tv_activitys;

    @Override
    public int attachLayoutRes() {
        return R.layout.goods_detail_activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initUI() {
//        initTooleBar("商品详情");
        mTitleBar.setMyCenterTitle("商品详情")
//                .setMySettingText("搜索")
                .setMySettingIcon(R.drawable.setting)
                .setSettingTextOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showShort("搜索");
                    }
                }).setMyNavigationText("取消")
                .setNavigationTextOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GoodsDetailActivity.this.finish();
                    }
                });


        tv_activitys = getView(R.id.tv_activitys);
        tv_activitys.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.tv_activitys) {
            List<Activity> list = ActivityUtils.getActivityList();
        }
    }
}
