package com.wow.shuigugu.cctest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.util.image.ShowImageUtils;

/**
 * Created by cl on 2019/3/20.
 */
public class ImageUtilActivity extends AppCompatActivity {

    private LinearLayout linearlayout;
    private RelativeLayout relativelayout;
    private FrameLayout framelayout;
    private ImageView imageview;
    private TextView textview;

    public String url1 = "http://img5.imgtn.bdimg.com/it/u=3691544771,740678494&fm=23&gp=0.jpg";
    public String url2 = "http://a.hiphotos.baidu.com/image/h%3D200/sign=7f12fce71630e924d0a49b317c096e66/d52a2834349b033b23af1d351cce36d3d539bd3e.jpg";
    public String url3 = "http://www.5068.com/uploads/allimg/160401/1-160401145114-50.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_util);
        bindViews();
        initViews();
    }

    private void initViews() {
        ShowImageUtils.showImageView(this,R.drawable.ic_launcher_background,url1,linearlayout);
        ShowImageUtils.showImageView(this,R.drawable.ic_launcher_background,url1,relativelayout);
        ShowImageUtils.showImageView(this,R.drawable.ic_launcher_background,url1,framelayout);
        ShowImageUtils.showImageView(this,R.drawable.ic_launcher_background,url1,imageview);
        ShowImageUtils.showImageView(this,R.drawable.ic_launcher_background,url1,textview);
    }

    private void bindViews() {
        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        relativelayout = (RelativeLayout) findViewById(R.id.relativelayout);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        imageview = (ImageView) findViewById(R.id.imageview);
        textview = (TextView) findViewById(R.id.textview);
    }
}
