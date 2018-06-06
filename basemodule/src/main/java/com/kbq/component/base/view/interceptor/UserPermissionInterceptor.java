package com.kbq.component.base.view.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.kbq.component.base.model.bean.UserBean;
import com.kbq.component.base.utils.SpUtil;

/**
 * Author: 柯葆青
 * Date: 2018/06/5
 * Description: 页面访问权限拦截器
 */
@Interceptor(priority = 2, name = "页面访问权限拦截器")
public class UserPermissionInterceptor implements IInterceptor {
    private static final String TAG = "PermissionInterceptor";

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i(TAG, "process: ");
        UserBean user = SpUtil.getUserInfo();
        if (user != null && user.getId() > 0) {
            callback.onContinue(postcard);  // 处理完成，交还控制权
        } else {
            callback.onInterrupt(new RuntimeException("请先登录"));// 觉得有问题，中断路由流程
        }
    }

    @Override
    public void init(Context context) {
        Log.i(TAG, "init: ");
    }
}
