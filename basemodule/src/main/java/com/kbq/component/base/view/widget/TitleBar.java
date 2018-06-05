package com.kbq.component.base.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.kbq.component.base.R;

/**
 * Author: 柯葆青
 * Date: 2018/06/1
 * Description: 自定义ToolBar
 */
public class TitleBar extends Toolbar {
    //中心标题
    private TextView mCenterText;
    //左侧文字
    private TextView mLeftText;
    //左侧按钮
    private ImageButton mLeftIcon;
    //右侧文字
    private TextView mRightText;
    //右侧按钮
    private ImageButton mRightIcon;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public ImageButton getRightBtn() {
        return mRightIcon;
    }

    public TextView getRightTextView() {
        return mRightText;
    }

    public TextView getCenterTextView() {
        return mCenterText;
    }

    /**
     * 左侧文字
     *
     * @param resId
     */
    public TitleBar setLeftText(@StringRes int resId) {
        setLeftText(this.getContext().getText(resId));
        return this;
    }

    /**
     * ToolBar左侧有contentInsetStart 16Dp的空白，若需要可自己定义style修改
     * 详情请见 http://my.oschina.net/yaly/blog/502471
     *
     * @param text
     */
    public TitleBar setLeftText(CharSequence text) {
        Context context = this.getContext();
        if (this.mLeftText == null) {
            this.mLeftText = new TextView(context);
            mLeftText.setTextSize(16);
            this.mLeftText.setGravity(Gravity.CENTER);
            this.mLeftText.setSingleLine();
            this.mLeftText.setEllipsize(TextUtils.TruncateAt.END);
            this.mLeftText.setTextColor(getResources().getColor(R.color.white));
            //左侧图标和左侧文字同时存在时,左侧图标的paddingRight为0
            if (mLeftIcon != null && mLeftIcon.getVisibility() != View.GONE) {
                this.mLeftText.setPadding(0, 0, SizeUtils.dp2px(15), 0);
            } else {
                this.mLeftText.setPadding(SizeUtils.dp2px(15), 0, SizeUtils.dp2px(15), 0);
            }
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.START;
            this.addView(this.mLeftText, params);
        }
        mLeftText.setText(text);
        return this;
    }

    public TitleBar setLeftTextPaddingLeft(int paddingLeft) {
        if (this.mLeftText != null) {
            this.mLeftText.setPadding(SizeUtils.dp2px(paddingLeft), 0, SizeUtils.dp2px(15), 0);
        }
        return this;
    }

    public TitleBar setLeftTextColor(@ColorInt int color) {
        if (this.mLeftText != null) {
            this.mLeftText.setTextColor(color);
        }
        return this;
    }

    public TitleBar setLeftTextSize(float size) {
        if (this.mLeftText != null) {
            this.mLeftText.setTextSize(size);
        }
        return this;
    }

    public TitleBar setLeftTextOnClickListener(View.OnClickListener listener) {
        if (mLeftText != null) {
            mLeftText.setOnClickListener(listener);
        }
        return this;
    }

    public TitleBar setLeftIcon(@DrawableRes int resId) {
        setLeftIcon(ContextCompat.getDrawable(this.getContext(), resId));
        return this;
    }

    public TitleBar setLeftIcon(Drawable drawable) {
        Context context = this.getContext();
        if (this.mLeftIcon == null) {
            this.mLeftIcon = new ImageButton(context);
            this.mLeftIcon.setBackgroundColor(0x00000000);
            int paddingLeft = SizeUtils.dp2px(15);
            int paddingTop = SizeUtils.dp2px(8);
            this.mLeftIcon.setPadding(paddingLeft, paddingTop, 0, paddingTop);
            this.mLeftIcon.setScaleType(ImageView.ScaleType.CENTER);
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.START;
            this.addView(this.mLeftIcon, params);
        } else {
            if (mLeftIcon.getVisibility() != VISIBLE) {
                mLeftIcon.setVisibility(VISIBLE);
            }
        }
        mLeftIcon.setImageDrawable(drawable);
        return this;
    }

    public TitleBar setLeftIconOnClickListener(View.OnClickListener listener) {
        if (mLeftIcon != null) {
            mLeftIcon.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * 居中标题
     *
     * @param rsId
     */
    public TitleBar setCenterText(@StringRes int rsId) {
        setCenterText(this.getContext().getText(rsId));
        return this;
    }

    public TitleBar setCenterText(CharSequence text) {
        Context context = this.getContext();
        if (this.mCenterText == null) {
            this.mCenterText = new TextView(context);
            this.mCenterText.setGravity(Gravity.CENTER);
            this.mCenterText.setSingleLine();
            this.mCenterText.setEllipsize(TextUtils.TruncateAt.END);
            this.mCenterText.setTextSize(17);
            this.mCenterText.setTextColor(ContextCompat.getColor(this.getContext(), R.color.white));
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.CENTER;
            this.addView(this.mCenterText, params);
        } else {
            if (this.mCenterText.getVisibility() != VISIBLE) {
                mCenterText.setVisibility(VISIBLE);
            }
        }
        //隐藏toolbar自带的标题
        setTitle("");
        mCenterText.setText(text);
        return this;
    }

    public TitleBar setCenterTextAppearance(Context context, @StyleRes int resId) {
        if (this.mCenterText != null) {
            this.mCenterText.setTextAppearance(context, resId);
        }
        return this;
    }

    public TitleBar setCenterTextColor(@ColorInt int color) {
        if (this.mCenterText != null) {
            this.mCenterText.setTextColor(color);
        }
        return this;
    }

    public TitleBar setCenterTextSize(float size) {
        if (this.mCenterText != null) {
            this.mCenterText.setTextSize(size);
        }
        return this;
    }


    /**
     * 右侧文字
     *
     * @param Rid
     */
    public TitleBar setRightText(@StringRes int Rid) {
        setRightText(this.getContext().getText(Rid));
        return this;
    }


    public TitleBar setRightText(CharSequence text) {
        Context context = this.getContext();
        if (this.mRightText == null) {
            this.mRightText = new TextView(context);
            this.mRightText.setTextSize(16);
            this.mRightText.setGravity(Gravity.CENTER);
            this.mRightText.setSingleLine();
            this.mRightText.setEllipsize(TextUtils.TruncateAt.END);
            this.mRightText.setTextColor(getResources().getColor(R.color.white));
            //右侧图标和右侧文字同时存在时,右侧图标的paddingLeft为0
            if (mRightIcon != null && mRightIcon.getVisibility() != View.GONE) {
                this.mRightText.setPadding(SizeUtils.dp2px(15), 0,0 , 0);
            } else {
                this.mRightText.setPadding(SizeUtils.dp2px(15), 0, SizeUtils.dp2px(15), 0);
            }
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.END;
            this.addView(this.mRightText, params);
        } else {
            if (mRightText.getVisibility() != VISIBLE) {
                mRightText.setVisibility(VISIBLE);
            }
        }

        mRightText.setText(text);

        return this;
    }
    public TitleBar setRightTextPaddingRight(int paddingRight) {
        if (this.mRightText != null) {
            this.mRightText.setPadding(SizeUtils.dp2px(15), 0, SizeUtils.dp2px(paddingRight), 0);
        }
        return this;
    }
    private TitleBar setRightTextAppearance(Context context, @StyleRes int resId) {
        if (this.mRightText != null) {
            this.mRightText.setTextAppearance(context, resId);
        }
        return this;
    }


    public TitleBar setRightTextColor(@ColorInt int color) {
        if (mRightText != null) {
            mRightText.setTextColor(color);
        }
        return this;
    }

    public TitleBar setRightTextSize(float size) {
        if (mRightText != null) {
            mRightText.setTextSize(size);
        }
        return this;
    }

    public TitleBar setRightTextOnClickListener(View.OnClickListener listener) {
        if (mRightText != null) {
            mRightText.setOnClickListener(listener);
        }
        return this;
    }


    /**
     * 右侧图标
     *
     * @param resId
     */
    public TitleBar setRightIcon(@DrawableRes int resId) {
        setRightIcon(ContextCompat.getDrawable(this.getContext(), resId));
        return this;
    }


    public TitleBar setRightIcon(Drawable drawable) {
        Context context = this.getContext();
        if (this.mRightIcon == null) {
            this.mRightIcon = new ImageButton(context);
            this.mRightIcon.setBackgroundColor(0x00000000);
            int paddingLeft = SizeUtils.dp2px(15);
            int paddingTop = SizeUtils.dp2px(8);
            this.mRightIcon.setPadding(0, paddingTop, paddingLeft, paddingTop);
            this.mRightIcon.setScaleType(ImageView.ScaleType.CENTER);
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.END;
            this.addView(this.mRightIcon, params);
        } else {
            if (mRightIcon.getVisibility() != VISIBLE) {
                mRightIcon.setVisibility(VISIBLE);
            }
        }
        mRightIcon.setImageDrawable(drawable);
        return this;
    }

    public TitleBar setRightIconOnClickListener(View.OnClickListener listener) {
        if (mRightIcon != null) {
            mRightIcon.setOnClickListener(listener);
        }
        return this;
    }

}