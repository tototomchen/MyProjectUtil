package com.wow.shuigugu.cctest.util;

/**
 * 字符串常用工具
 */
public class UtilString {
    public static boolean isNullOrEmpty(String str) {
        if (null == str || str.length() <= 0 || "null".endsWith(str) || "Null".endsWith(str)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAllInteger(String str) {
        try {
            int num = Integer.valueOf(str);//把字符串强制转换为数字
            return true;//如果是数字，返回True
        } catch (Exception e) {
            //如果抛出异常，返回False
            return false;
        }
    }

    public static String getHtmlName(String url) {
        String[] arr = url.split("/");
        return arr[arr.length - 1];
    }

    public static Double toDouble(String str) {
        double result = 0;
        try {
            result = Double.parseDouble(str);
        } catch (Exception e) {
            // TODO: handle exception
            return (double) 0;
        }
        return result;
    }

    public static int toInt(String str) {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
        return result;
    }
}
