package com.wow.shuigugu.cctest.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.base.BaseActivity;
import com.wow.shuigugu.cctest.util.UtilLog;
import com.wow.shuigugu.cctest.util.UtilToast;
import com.wow.shuigugu.cctest.view.StarBar;

/**
 * 星星评分
 * Created by cl on 2018/11/7.
 */
public class StarActivity extends BaseActivity {

    private TextView tv_zhengshu,tv_toast;
    private StarBar sb;
    private LinearLayout ll_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewTitleAndLoad(R.layout.activity_star);
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
                if(tv_zhengshu.isSelected()){
                    tv_zhengshu.setSelected(false);
                }else{
                    tv_zhengshu.setSelected(true);
                }
            }
        });
//        UtilToast utilToast = new UtilToast();
        tv_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UtilToast.shortgmsg(context,"hahahah");
                showPW();
            }
        });
    }

    private void showPW() {
        TextView view = new TextView(this);
        PopupWindow pw =  new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        view.setText("哈哈哈哈");
//        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
//        int screenWidth = wm.getDefaultDisplay().getWidth();
//        int h = wm.getDefaultDisplay().getHeight();
//        pw.setHeight(h/4);
//        pw.setWidth((int) (screenWidth*0.8));
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.7f;
        this.getWindow().setAttributes(lp);
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
        pw.setContentView(view);
        pw.setBackgroundDrawable(getResources().getDrawable(R.color.fontBlue));
        pw.setFocusable(true);// 一定不能少
        pw.setOutsideTouchable(true);
        pw.setAnimationStyle(R.style.anim_photo_select);
        pw.showAtLocation(ll_content, Gravity.BOTTOM, 0, 0);
    }

    private void bindViews() {
        sb = findViewById(R.id.sb);
        tv_zhengshu = findViewById(R.id.tv_zhengshu);
        tv_toast = findViewById(R.id.tv_toast);
        ll_content = findViewById(R.id.ll_content);
    }

}
