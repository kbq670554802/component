package com.kbq.component.base.view.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
    public TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        mTitleBar = findViewById(R.id.title_bar);
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


    public void initTooleBar(boolean showBack, String title) {
        if (mTitleBar == null) {
            return;
        }
        if (showBack) {
            mTitleBar.setNavigationIcon(R.drawable.nav_back);
            mTitleBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityUtils.finishActivity(BaseActivity.this);
                }
            });
        } else {
            mTitleBar.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(title)) {
            mTitleBar.setVisibility(View.GONE);
        } else {
            mTitleBar.setVisibility(View.VISIBLE);
            mTitleBar.setMyCenterTitle(title);
        }
    }

    public void initTooleBar(boolean showBack, int titleRes) {
        String title = getResources().getString(titleRes);
        initTooleBar(showBack, title);
    }

    public void initTooleBar(String title) {
        initTooleBar(true, title);
    }

    public Drawable getDrawable_(int resId) {
        return ContextCompat.getDrawable(this, resId);
    }
}
