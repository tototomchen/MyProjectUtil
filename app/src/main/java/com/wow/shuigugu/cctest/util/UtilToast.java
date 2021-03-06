package com.wow.shuigugu.cctest.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by cl on 2018/11/7.
 */
public class UtilToast {
    static {
        UtilLog.e("tag","UtilToast    static");
    }
    public UtilToast(){
        super();
        UtilLog.e("tag","UtilToast构造出生了！！！！");
    }
    static Toast toast = null;

    /**
     * 短时间显示
     * @param context
     * @param msg
     */
    public static void shortgmsg(Context context, String msg){
        UtilLog.e("tag","shortgmsg");
        if(toast==null){
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
