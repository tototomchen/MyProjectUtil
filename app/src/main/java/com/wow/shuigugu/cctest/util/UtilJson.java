package com.wow.shuigugu.cctest.util;

import com.google.gson.Gson;


/**
 * json解析工具类
 *
 * @author chenli
 *         <p>
 *         2015年10月28日上午8:41:41
 */
public class UtilJson {

    /**
     * Gson解析-泛型
     *
     * @param json     json字符串
     * @param classOfT 泛型
     * @return
     */
    public static <T> T toJson(String json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

    public static String toJsonStr(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
