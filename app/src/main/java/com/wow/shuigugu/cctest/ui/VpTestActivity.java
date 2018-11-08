package com.wow.shuigugu.cctest.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wow.shuigugu.cctest.MainActivity;
import com.wow.shuigugu.cctest.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by cl on 2018/10/31.
 */
public class VpTestActivity extends FragmentActivity {

    private ViewPager viewpager;
    private Button btn_startLogin;
    private LinearLayout ll_guide_sign;
    private ArrayList<ImageView> imageViews;
    private int currentPage = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_test);
        bindViews();
        initData();
        viewpager.setAdapter(new WelcomeAdapter(VpTestActivity.this,imageViews));
        bindListener();
    }

    private void bindListener() {

        btn_startLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent intent = new Intent(VpTestActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                if(arg0==imageViews.size()-1){
                    btn_startLogin.setVisibility(View.VISIBLE);
                }else {
                    btn_startLogin.setVisibility(View.INVISIBLE);
                }
                initPoint(arg0);
                Log.e("tag", "当前的index"+arg0);
                currentPage = arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        viewpager.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float endX;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();

                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        //获取屏幕的宽度
                        WindowManager wm = (WindowManager)VpTestActivity.this.getSystemService(Context.WINDOW_SERVICE);
                        int width = wm.getDefaultDisplay().getWidth();
                        //根据滑动的距离来切换界面
                        if (currentPage == 5 && startX - endX >= (width / 5)) {
                            Intent intent = new Intent(VpTestActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void bindViews() {
        viewpager = findViewById(R.id.viewpager);
        btn_startLogin = findViewById(R.id.btn_startLogin);
        ll_guide_sign = findViewById(R.id.ll_guide_sign);
    }

    private void initData() {
        // TODO Auto-generated method stub
        int ids[] = { R.mipmap.guide01, R.mipmap.guide02,
                R.mipmap.guide03,R.mipmap.guide04 ,R.mipmap.guide05,R.mipmap.guide06};
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < ids.length; i++) {
            ImageView imageView = new ImageView(this);
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Bitmap.Config.RGB_565;
            opt.inPurgeable = true;
            opt.inInputShareable = true;
            InputStream is = getResources().openRawResource(ids[i] );
            Bitmap bm = BitmapFactory.decodeStream(is, null, opt);
            BitmapDrawable bd = new BitmapDrawable(getResources(), bm);
            imageView.setBackgroundDrawable(bd);
            imageViews.add(imageView);
        }
        for(int i = 0; i < ids.length; i++){
            ImageView pointImageview = new ImageView(this);
            pointImageview.setBackgroundResource(R.mipmap.guide_selcted);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin=50;
            ll_guide_sign.addView(pointImageview,params);
        }
        initPoint(0);
    }

    private void initPoint(int index){
        int size=ll_guide_sign.getChildCount();
        for(int i=0;i<size;i++){
            ImageView iv=(ImageView)ll_guide_sign.getChildAt(i);
            if(index==i){
                iv.setBackgroundResource(R.mipmap.guide_selcted);
            }else{
                iv.setBackgroundResource(R.mipmap.pic_selector_normal);
            }

        }
    }

    public class WelcomeAdapter extends PagerAdapter {

        private ArrayList<ImageView> imageViews;

        public WelcomeAdapter(Activity activity, ArrayList<ImageView> imageViews) {
            // TODO Auto-generated constructor stub
            this.imageViews = imageViews;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return imageViews.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            return imageView;

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

    }
}
