package com.kbq.component;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.kbq.component.base.BaseApplication;

public class AppApplication extends BaseApplication {
    public static AppApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ARouter.openLog();     // 打印日志；
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(instance); // 尽可能早，推荐在Application中初始化

        Utils.init(instance);
    }
}
