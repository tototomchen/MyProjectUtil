package com.wow.shuigugu.cctest.util;

import android.util.Log;

public class UtilLog {

	public static boolean  isDebug=true;//是不是调试
	public static void e(String tag,String msg){
		if(isDebug){
			try{
				Log.e(tag, msg);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void i(String tag,String msg){
		if(isDebug){
			try{
				Log.i(tag, msg);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}
	public static void v(String tag,String msg){
		if(isDebug){
			try{
				Log.v(tag, msg);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}
	public static void w(String tag,String msg){
		if(isDebug){
			try{
				Log.w(tag, msg);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}
	public static void d(String tag,String msg){
		if(isDebug){
			try{
				Log.d(tag, msg);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}
	public static void print(String msg){
		if(isDebug){
			try{
				Log.e("tag", msg);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}




}
