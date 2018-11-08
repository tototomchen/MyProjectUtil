package com.wow.shuigugu.cctest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.base.BaseActivity;
import com.wow.shuigugu.cctest.util.UtilLog;
import com.wow.shuigugu.cctest.util.UtilToast;
import com.wow.shuigugu.cctest.view.StarBar;

/**
 * 基础页使用
 * Created by cl on 2018/11/8.
 */
public class BaseFunctionActivity extends BaseActivity {

    private TextView tv_loading;
    private TextView tv_no_net;
    private TextView tv_no_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewTitleAndLoad(R.layout.activity_base_function);
        bindViews();
        initData();
        bindListener();
    }

    private void bindListener() {
        tv_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadStart();
            }
        });
        tv_no_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNoData();
            }
        });
        tv_no_net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNonet();
            }
        });
    }

    private void bindViews() {
        tv_loading = (TextView) findViewById(R.id.tv_loading);
        tv_no_net = (TextView) findViewById(R.id.tv_no_net);
        tv_no_data = (TextView) findViewById(R.id.tv_no_data);
    }

    @Override
    public void onRight1Click() {
        super.onRight1Click();
        loadSuccess();
    }

    private void initData() {
        setRight1Text("重置");
    }

    @Override
    public void onReloadClick() {
        super.onReloadClick();
        loadSuccess();
    }
}
