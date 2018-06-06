package com.kbq.component.base.utils;

import com.blankj.utilcode.util.SPUtils;
import com.kbq.component.base.model.bean.UserBean;

/**
 * Author: 柯葆青
 * Date: 2018/06/06
 * Description: 偏好设置工具类
 */
public class SpUtil {

    /**
     * 保存用户信息
     * @param user 用户信息
     */
    public static void setUserInfo(UserBean user) {
        SPUtils.getInstance().put("user", JsonConvertUtil.toJson(user));
    }

    /**
     * 获取用户信息
     * @return 用户信息
     */
    public static UserBean getUserInfo() {
        return JsonConvertUtil.toObj(SPUtils.getInstance().getString("user"), UserBean.class);
    }
    /**
     * 清除用户信息
     */
    public static void clearUserInfo() {
        SPUtils.getInstance().put("user", "");
    }
}
