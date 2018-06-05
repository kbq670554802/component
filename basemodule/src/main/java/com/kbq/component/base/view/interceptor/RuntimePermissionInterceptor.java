package com.kbq.component.base.view.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Author: 柯葆青
 * Date: 2018/06/5
 * Description: 页面访问权限拦截器
 */
@Interceptor(priority = 10, name = "页面访问权限拦截器")
public class RuntimePermissionInterceptor implements IInterceptor {
    private static final String TAG = "PermissionInterceptor";

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i(TAG, "process: ");
        callback.onContinue(postcard);  // 处理完成，交还控制权
//         callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程
    }

    @Override
    public void init(Context context) {
        Log.i(TAG, "init: ");
    }
}
