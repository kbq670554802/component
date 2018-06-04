package com.kbq.component.base.view.activity;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.kbq.component.base.R;

/**
 * Author: 柯葆青
 * Date: 2018/05/30
 * Description: BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar mToolBar;
    private TextView mTbTitle;
    private TextView mTbRightText;
    private ImageView mTbRightImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        setToolBar();
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

    private void setToolBar() {
        mToolBar = findViewById(R.id.toolbar);
        mTbTitle = findViewById(R.id.tb_title);
        mTbRightText = findViewById(R.id.tb_right_text);
        mTbRightImage = findViewById(R.id.tb_right_image);
        if(mToolBar!=null) {
            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityUtils.finishActivity(BaseActivity.this);
                }
            });
        }
    }

    public void setTbTitle(String text) {
        if (mTbTitle != null) {
            mTbTitle.setVisibility(View.VISIBLE);
            mTbTitle.setText(text);
        }
    }

    public void setTbRightText(String text, View.OnClickListener listener) {
        if (mTbRightText != null) {
            mTbRightText.setVisibility(View.VISIBLE);
            mTbRightText.setText(text);
            mTbRightText.setOnClickListener(listener);
        }
    }

    public void setTbRightImage(@DrawableRes int resId, View.OnClickListener listener) {
        if (mTbRightImage != null) {
            mTbRightImage.setVisibility(View.VISIBLE);
            mTbRightImage.setImageDrawable(ContextCompat.getDrawable(this, resId));
            mTbRightImage.setOnClickListener(listener);
        }
    }
}
