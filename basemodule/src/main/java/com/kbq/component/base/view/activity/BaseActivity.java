package com.kbq.component.base.view.activity;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.kbq.component.base.R;
import com.kbq.component.base.view.widget.TitleBar;

/**
 * Author: 柯葆青
 * Date: 2018/05/30
 * Description: BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        initToolBar();
        initUI();
        initData();
    }


    public abstract int attachLayoutRes();

    public abstract void initUI();

    public abstract void initData();

    public <E extends View> E getView(int resId) {
        try {
            return (E) findViewById(resId);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

    @Override
    public void onClick(View v) {
    }

    private void initToolBar() {
        mTitleBar = findViewById(R.id.title_bar);
        if (mTitleBar != null) {
            mTitleBar.setLeftIcon(R.drawable.nav_back)
                    .setLeftIconOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ActivityUtils.finishActivity(BaseActivity.this);
                        }
                    });
        }
    }

    public void setTitle(String title) {
        if (mTitleBar != null) {
            mTitleBar.setCenterText(title);
        }
    }

    public void setTitle(@StringRes int rsId) {
        setTitle(getString(rsId));
    }


}
