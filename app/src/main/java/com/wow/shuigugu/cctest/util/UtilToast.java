package com.wow.shuigugu.cctest.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by cl on 2018/11/7.
 */
public class UtilToast {

    static Toast toast = null;

    /**
     * 短时间显示
     * @param context
     * @param msg
     */
    public static void shortgmsg(Context context, String msg){
        if(toast==null){
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
