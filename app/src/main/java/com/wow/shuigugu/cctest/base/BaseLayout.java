package com.wow.shuigugu.cctest.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 基础view
 * Created by cl on 2018/11/7.
 */
public class BaseLayout extends RelativeLayout {

    public Context context;
    public int type;
    public int res_id;
    private LayoutInflater layoutInflater;

    public BaseLayout(Context context,int type,int res_id){
        super(context);
        this.context = context;
        this.type = type;
        this.res_id = res_id;
        initView();
    }

    private void initView() {
        layoutInflater = LayoutInflater.from(context);

    }


}
