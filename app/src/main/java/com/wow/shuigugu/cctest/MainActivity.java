package com.wow.shuigugu.cctest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.wow.shuigugu.cctest.ui.BaseFunctionActivity;
import com.wow.shuigugu.cctest.ui.StarActivity;
import com.wow.shuigugu.cctest.ui.VpTestActivity;
import com.wow.shuigugu.cctest.view.FadingScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View layout;
    private FadingScrollView fadingScrollView;
    private TextView tv_star;
    private TextView tv_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);
        setAllScr();
        bindViews();
        bindListener();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.nac_layout:
                Intent intent = new Intent(MainActivity.this,VpTestActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_star:
                Intent star = new Intent(MainActivity.this,StarActivity.class);
                startActivity(star);
                break;
            case R.id.tv_base:
                Intent base = new Intent(MainActivity.this,BaseFunctionActivity.class);
                startActivity(base);
                break;
        }
    }

    private void bindListener() {
        layout.setOnClickListener(this);
        tv_star.setOnClickListener(this);
        tv_base.setOnClickListener(this);
    }

    private void bindViews() {


        layout = findViewById(R.id.nac_layout);
        tv_star = findViewById(R.id.tv_star);
        tv_base = findViewById(R.id.tv_base);
        layout.setAlpha(0);
        fadingScrollView = (FadingScrollView)findViewById(R.id.nac_root);
        fadingScrollView.setFadingView(layout);
        fadingScrollView.setFadingHeightView(findViewById(R.id.nac_image));
    }

    private void setAllScr() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }


}
