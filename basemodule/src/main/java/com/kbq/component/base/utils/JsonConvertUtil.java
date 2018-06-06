package com.kbq.component.base.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Author: 柯葆青
 * Date: 2018/06/06
 * Description: Json转换工具类
 */
public class JsonConvertUtil {

    /**
     * 对象转Json字符串
     *
     * @param o Object对象
     * @return Json字符串
     */
    public static String toJson(Object o) {
        try {
            Gson gson = new Gson();
            return gson.toJson(o);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Json字符串转对象
     *
     * @param json  json字符串
     * @param clazz 对象类型
     * @param <T>   对象类
     * @return 对象
     */
    public static <T> T toObj(String json, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, clazz);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Json字符串转数组
     *
     * @param json  json字符串
     * @param clazz 对象类型
     * @param <T>   对象类
     * @return 数组
     */
    public static <T> T toArr(String json, List<Class<T>> clazz) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception ex) {
            return null;
        }
    }
}
