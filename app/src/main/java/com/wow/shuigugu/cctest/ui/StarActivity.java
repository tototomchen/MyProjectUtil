package com.wow.shuigugu.cctest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.util.UtilLog;
import com.wow.shuigugu.cctest.util.UtilToast;
import com.wow.shuigugu.cctest.view.StarBar;

/**
 * 星星评分
 * Created by cl on 2018/11/7.
 */
public class StarActivity extends FragmentActivity {

    private TextView tv_zhengshu;
    private StarBar sb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        bindViews();


        sb.setOnStarChangeListener(new StarBar.OnStarChangeListener() {
            @Override
            public void onStarChange(float mark) {
                UtilToast.shortgmsg(StarActivity.this,"评分是："+mark+"分");
                UtilLog.e("tag","评分是："+mark+"分");
            }
        });
        tv_zhengshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.setIntegerMark(!sb.getIntegerMark());
                tv_zhengshu.setText(sb.getIntegerMark()?"转化为小数":"转化为整数");
            }
        });
    }

    private void bindViews() {
        sb = findViewById(R.id.sb);
        tv_zhengshu = findViewById(R.id.tv_zhengshu);
    }
}
