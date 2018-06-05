package com.kbq.component.goods.view.activity;


import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ActivityUtils;
import com.kbq.component.base.view.activity.SwipeBackActivity;
import com.kbq.component.base.view.widget.TitleBar;
import com.kbq.component.goods.R;
import com.kbq.component.goods.RouterConfig;

import java.util.List;

/**
 * Author: 柯葆青
 * Date: 2018/05/30
 * Description: 商品详情页
 */
@Route(path = RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY)
public class GoodsDetailActivity extends SwipeBackActivity {
    private static final String TAG = "GoodsDetailActivity";

    private TextView tv_activitys;

    @Override
    public int attachLayoutRes() {
        return R.layout.goods_detail_activity;
    }

    @Override
    public void initUI() {
        setTitle(R.string.app_name);
//        TitleBar titleBar = findViewById(R.id.title_bar);
//        titleBar.setCenterText("发布采购")
//
//                .setLeftIcon(R.drawable.nav_back)
//                .setLeftIconOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.i(TAG, "onClick: 左边图标");
//                    }
//                })
//                .setLeftText("取消")
//                .setLeftTextPaddingLeft(4)
//                .setLeftTextOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Log.i(TAG, "onClick: 左边文字");
//                    }
//                })
//                .setRightIcon(R.drawable.nav_back)
//                .setRightIconOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.i(TAG, "onClick: 右侧图标");
//                    }
//                })
//                .setRightText("保存")
//                .setRightTextPaddingRight(4)
//                .setRightTextOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.i(TAG, "onClick: 右边文字");
//                    }
//                })
//        ;

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
