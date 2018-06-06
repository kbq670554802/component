package com.kbq.component.mine.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kbq.component.base.model.bean.UserBean;
import com.kbq.component.base.utils.SpUtil;
import com.kbq.component.base.view.fragment.BaseFragment;
import com.kbq.component.mine.R;


@Route(path = "/mine/minefragment")
public class MineFragment extends BaseFragment {
    private TextView mTvLogin;

    @Override
    public int attachLayoutRes() {
        return R.layout.mine_fragment;
    }

    @Override
    public void initUI() {
        mTvLogin = getView(R.id.tv_login);
        mTvLogin.setOnClickListener(this);
        setLoginBtn();
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.tv_login) {
            login();
        }
    }

    private void login() {
        UserBean user = SpUtil.getUserInfo();
        if (user != null && user.getId() > 0) {
            SpUtil.clearUserInfo();
            setLoginBtn();
        } else {
            UserBean u = new UserBean(8, "柯葆青");
            SpUtil.setUserInfo(u);
            setLoginBtn();
        }
    }

    private void setLoginBtn() {
        UserBean user = SpUtil.getUserInfo();
        if (user != null && user.getId() > 0) {
            mTvLogin.setText("退出登录:用户ID:" + user.getId());
        } else {
            mTvLogin.setText("登录");
        }
    }

}
