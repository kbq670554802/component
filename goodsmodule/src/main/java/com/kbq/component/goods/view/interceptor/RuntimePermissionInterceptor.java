package com.kbq.component.goods.view.interceptor;

import android.Manifest;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.kbq.component.goods.GoodsApplication;
import com.kbq.component.goods.RouterConfig;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

/**
 * Author: 柯葆青
 * Date: 2018/06/5
 * Description: 页面访问权限拦截器
 */
@Interceptor(priority = 11, name = "页面访问权限拦截器")
public class RuntimePermissionInterceptor implements IInterceptor {
    private static final String TAG = "PermissionInterceptor";
    private Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i(TAG, "process: ");
        callback.onContinue(postcard);  // 处理完成，交还控制权
//         callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程

        if(TextUtils.equals(postcard.getPath(), RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY)) {
            RxPermissions rxPermissions = new RxPermissions(GoodsApplication.getTopActivity());
//            rxPermissions
//                    .requestEach(Manifest.permission.CAMERA,
//                            Manifest.permission.READ_PHONE_STATE)
//                    .subscribe(new Consumer<Permission>() {
//                        @Override
//                        public void accept(Permission permission) throws Exception {
//                            if (permission.granted) {
//                                // 用户已经同意该权限
//                                Log.d(TAG, permission.name + " is granted.");
//                            } else if (permission.shouldShowRequestPermissionRationale) {
//                                // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
//                                Log.d(TAG, permission.name + " is denied. More info should be provided.");
//                            } else {
//                                // 用户拒绝了该权限，并且选中『不再询问』
//                                Log.d(TAG, permission.name + " is denied.");
//                            }
//                        }
//                    });
            rxPermissions.requestEach(Manifest.permission.READ_PHONE_STATE)
                    .subscribe(new Consumer<Permission>() {
                        @Override
                        public void accept(Permission permission) throws Exception {
                            if (permission.granted) {
                                // 用户已经同意该权限
                                Log.d(TAG,"用户已经同意该权限");
                            } else if (permission.shouldShowRequestPermissionRationale) {
                                // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                                Log.d(TAG,"用户拒绝了该权限");
                            } else {
                                // 用户拒绝了该权限，并且选中『不再询问』，提醒用户手动打开权限
                                Log.d(TAG,"权限被拒绝，请在设置里面开启相应权限，若无相应权限会影响使用");
                            }
                        }
                    });
        }
    }

    @Override
    public void init(Context context) {
        this.mContext = context;//context是Application对象
    }
}
