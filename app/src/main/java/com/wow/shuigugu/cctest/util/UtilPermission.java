package com.wow.shuigugu.cctest.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by cl on 2019/3/20.
 */
public class UtilPermission {

    public static String  READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final int read_external_storage = 1;


    public static boolean getPermission(Context context, String permission){
        if (Build.VERSION.SDK_INT < 23) {
            Log.w("EasyPermissions", "hasPermissions: API version < M, returning true by default");
            return true;
        } else {
            if(ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, read_external_storage);
                return false;
            }
        }
    }


}
