package com.kbq.component.goods.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kbq.component.base.utils.ToastUtil;
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
    private static final String TAG = "GoodsFragment";

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
            ARouter.getInstance().build(RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY).navigation(getActivity(), new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    Log.i(TAG, "onFound: ");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Log.i(TAG, "onLost: ");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    Log.i(TAG, "onArrival: ");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    Log.i(TAG, "onInterrupt: ");
                    ToastUtil.showShort((String) postcard.getTag());
                }
            });
        }
    }
}
