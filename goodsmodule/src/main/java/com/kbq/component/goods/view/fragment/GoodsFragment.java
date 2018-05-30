package com.kbq.component.goods.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kbq.component.base.view.fragment.BaseFragment;
import com.kbq.component.goods.R;
import com.kbq.component.goods.RouterConfig;

/**
 * Author: 柯葆青
 * Date: 2018/05/30
 * Description: 商品主页
 */
@Route(path = RouterConfig.GOODS_GOODS_FRAGMENT)
public class GoodsFragment extends BaseFragment {

    private TextView mTvGoodsDetail;


    @Override
    public int attachLayoutRes() {
        return R.layout.goods_fragment;
    }

    @Override
    public void initUI() {
        mTvGoodsDetail = getView(R.id.tv_goods_detail);
        mTvGoodsDetail.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.tv_goods_detail) {
            ARouter.getInstance().build(RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY).navigation();
        }
    }
}
