package com.wow.shuigugu.cctest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 解析时间
 * Created by cl on 2018/11/8.
 */
public class UtilTime {

    public static String ZI_YMD = "yyyy年MM月dd日";
    public static String ZI_YMD_HM = "yyyy年MM月dd日 HH:mm";
    public static String ZI_YMD_HMS = "yyyy年MM月dd日 HH:mm:ss";

    public static String S_YMD = "yyyy/MM/dd";
    public static String S_YMD_HM = "yyyy/MM/dd HH:mm";
    public static String S_YMD_HMS = "yyyy/MM/dd HH:mm:ss";

    public static String B_YMD = "yyyy-MM-dd";
    public static String B_YMD_HM = "yyyy-MM-dd HH:mm";
    public static String B_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    static SimpleDateFormat formatter = new SimpleDateFormat(B_YMD);

    public static String parseStamp(String time, String type) {
        if(type!=null){
            formatter = new SimpleDateFormat(type);
        }else{
            formatter = new SimpleDateFormat(B_YMD);
        }
        String newTime = null;
        long time1 = Long.valueOf(time);
        newTime = formatter.format(new Date(time1 * 1000L));
        return newTime;
    }

    public static String createStamp(String time, String type) {
        if(type!=null){
            formatter = new SimpleDateFormat(type);
        }else{
            formatter = new SimpleDateFormat(B_YMD);
        }
        String newTime = null;
        Date d;
        try {
            d = formatter.parse(time);
            newTime = d.getTime() / 1000 + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newTime;
    }
}
