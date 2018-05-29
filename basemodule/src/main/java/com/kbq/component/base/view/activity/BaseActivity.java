package com.kbq.component.base.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kbq.component.base.R;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
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
}
