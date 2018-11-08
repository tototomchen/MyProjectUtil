package com.wow.shuigugu.cctest.base;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.util.UtilVar;

/**
 * 基础view
 * Created by cl on 2018/11/7.
 */
public class BaseLayout extends RelativeLayout {


    //通用title和相关子view 具体项目可以自己加
    public View base_title;//通用的title
    public RelativeLayout rl_base_left;
    public TextView tv_base_title;
    public RelativeLayout rl_base_right;
    public TextView tv_base_right1;
    public ImageView iv_base_right1;
    public View v_base_infobar;
    public LinearLayout ll_base_title;

    public View personl_title;//个人自己的title(这个布局只有 type=BASE_LOAD的时候才有)
    public ViewGroup personl_content;//用户自己的内容 (包括标题)
    public View personal_part_content;//用户自己的内容不包括标题

    /***
     * base 加载数据部分
     */
    private View base_load;//通用加载的效果的内容
    private ProgressBar pb_load;
    public TextView tv_load_no_data;
    private LinearLayout ll_load_err;
    public Button bt_load_restart;

    public Context context;
    public int type;
    public int res_id;
    private int titleId;

    public BaseLayout(Context context, int type, int resouceId) {
        super(context);
        this.context = context;
        this.type = type;
        this.res_id = resouceId;
        personl_content = (ViewGroup) View.inflate(context, resouceId, null);
        bindViews();
        initView();
        initDisplay();
    }

    public BaseLayout(Context context, int type, int resouceId, int titleId, int contentId) {
        super(context);
        this.context = context;
        this.type = type;
        this.titleId = titleId;
        this.res_id = resouceId;
        personl_content = (ViewGroup) View.inflate(context, resouceId, null);
        if (titleId != 0) {
            personl_title = personl_content.findViewById(titleId);
        }
        personal_part_content = personl_content.findViewById(contentId);
        bindViews();
        initView();
        initDisplay();
    }

    private void bindViews() {
        base_title = View.inflate(context, R.layout.base_title, null);
        rl_base_left = base_title.findViewById(R.id.rl_base_left);
        tv_base_title = base_title.findViewById(R.id.tv_base_title);
        rl_base_right = base_title.findViewById(R.id.rl_base_right);
        tv_base_right1 = base_title.findViewById(R.id.tv_base_right1);
        iv_base_right1 = base_title.findViewById(R.id.iv_base_right1);
        v_base_infobar = base_title.findViewById(R.id.v_base_infobar);
        ll_base_title = base_title.findViewById(R.id.ll_base_title);

        tv_base_right1.setVisibility(View.GONE);
        base_load = View.inflate(context, R.layout.base_load, null);
        pb_load = (ProgressBar) base_load.findViewById(R.id.pb_load);
        tv_load_no_data = (TextView) base_load.findViewById(R.id.tv_load_no_data);
        ll_load_err = (LinearLayout) base_load.findViewById(R.id.ll_load_err);
        base_load.setVisibility(View.GONE);
        bt_load_restart = (Button) base_load.findViewById(R.id.bt_load_restart);
    }

    private void initView() {
        tv_base_right1.setVisibility(View.GONE);
        iv_base_right1.setVisibility(View.GONE);
    }

    /**
     * 初始化显示的布局
     */
    private void initDisplay() {

        if (type == UtilVar.BASE_TITLE) {
            LayoutParams baseTitleParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
            this.addView(base_title, baseTitleParams);
            LayoutParams personalContentParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
            personalContentParams.addRule(RelativeLayout.BELOW, R.id.ll_base_title);
            this.addView(personl_content, personalContentParams);
        } else if (type == UtilVar.BASE_LOAD) {
            if (personl_content instanceof RelativeLayout) {
                LayoutParams fillParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
                LayoutParams baseLoadParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
                baseLoadParams.addRule(RelativeLayout.BELOW, titleId);
                LayoutParams personalPartcontentParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
                personalPartcontentParams.addRule(RelativeLayout.BELOW, R.id.rl_base_load);
                personal_part_content.setLayoutParams(personalPartcontentParams);
                personl_content.addView(base_load, baseLoadParams);
                this.addView(personl_content, fillParams);
            } else if (personl_content instanceof LinearLayout) {
                LayoutParams fillParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
                LinearLayout.LayoutParams llFillParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
                //用户没有title比如fragment
                if (titleId == 0) {
                    personl_content.addView(base_load, 0, llFillParams);
                } else {
                    personl_content.addView(base_load, 1, llFillParams);
                }
                this.addView(personl_content, fillParams);
            }

        } else {
            LayoutParams baseTitleParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
            this.addView(base_title, baseTitleParams);
            LayoutParams baseLoadParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
            baseLoadParams.addRule(RelativeLayout.BELOW, R.id.ll_base_title);
            addView(base_load, baseLoadParams);
            LayoutParams personalContentParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
            personalContentParams.addRule(RelativeLayout.BELOW, R.id.rl_base_load);
            this.addView(personl_content, personalContentParams);
        }
    }

    public void loadStart() {
        base_load.setVisibility(View.VISIBLE);
        pb_load.setVisibility(View.VISIBLE);
        tv_load_no_data.setVisibility(View.GONE);
        ll_load_err.setVisibility(View.GONE);

    }

    /**
     * 加载无网络
     */
    public void loadNonet() {
        base_load.setVisibility(View.VISIBLE);
        pb_load.setVisibility(View.GONE);
        tv_load_no_data.setVisibility(View.GONE);
        ll_load_err.setVisibility(View.VISIBLE);
    }

    public void loadNoData() {
        base_load.setVisibility(View.VISIBLE);
        pb_load.setVisibility(View.GONE);
        tv_load_no_data.setVisibility(View.VISIBLE);
        ll_load_err.setVisibility(View.GONE);
    }

    public void loadSuccess() {
        base_load.setVisibility(View.GONE);
        pb_load.setVisibility(View.GONE);
    }

    public void setBaseTitle(String title) {
        tv_base_title.setText(title);
    }

    /**
     * 设置标题的颜色
     *
     * @param titlteBackColor #4388e5(这样为了直接可以设置，不用再color里面定义属性)
     */
    public void setTitleBackColor(String titlteBackColor) {
        ll_base_title.setBackgroundColor(Color.parseColor(titlteBackColor));
    }

    /**
     * 设置标题颜色
     *
     * @param titlteColor
     */
    public void setTilteTextColor(String titlteColor) {
        tv_base_title.setTextColor(Color.parseColor(titlteColor));
    }

    //设置右边第一个文字的颜色
    public void setRight1TextColor(String textColor) {
        tv_base_right1.setTextColor(Color.parseColor(textColor));
    }
}
