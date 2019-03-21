package com.wow.shuigugu.cctest.ui;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.base.BaseActivity;
import com.wow.shuigugu.cctest.util.UtilLog;
import com.wow.shuigugu.cctest.util.UtilToast;
import com.wow.shuigugu.cctest.view.StarBar;
import com.wow.shuigugu.cctest.view.SuperRecyclerView;
import com.wow.shuigugu.cctest.view.superrecycleview.DividerItemDecoration;
import com.wow.shuigugu.cctest.view.superrecycleview.OnMoreListener;
import com.wow.shuigugu.cctest.view.superrecycleview.RecyclerItemClickListener;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.jzvd.JZTextureView;
import cn.jzvd.JzvdStd;

/**
 * 旋转屏幕测试
 * Created by cl on 2019/1/4.
 */
public class RotatingScreenActivity extends BaseActivity {

    private TextView tv_zhengshu,tv_toast;
    private StarBar sb;
    private LinearLayout ll_content;
    private SuperRecyclerView srv_test;
    private EditText  et;
    private TextView tv_show;
    private EditText tv_data;
    private TextView tv_jiaobiao;

    private List<String> names = new ArrayList<>();
    private InformAdapter informAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewTitleAndLoad(R.layout.activity_star);
        bindViews();
        bindListener();
        initData();
        informAdapter = new InformAdapter();
        srv_test.setAdapter(informAdapter);
        srv_test.setLayoutManager(new LinearLayoutManager(context));
        srv_test.getSwipeToRefresh().setColorSchemeResources(R.color.fontBlue, R.color.fontBlue,R.color.fontBlue, R.color.fontBlue);
        srv_test.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "chat";
            String channelName = "聊天消息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);

            channelId = "subscribe";
            channelName = "订阅消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);

        }

    }

    private void initData() {
        names.add("美国队长");
        names.add("小渣渣");
        names.add("蜘蛛侠");
        names.add("钢铁侠");
        names.add("超人");
        names.add("蝙蝠侠");
        names.add("绿灯侠");
        names.add("灭霸");
        names.add("绿箭侠");
        names.add("毒液");
        names.add("绿巨人");
        names.add("小丑");
        names.add("孙悟空");
        names.add("贝吉塔");
        names.add("比克大魔王");
        names.add("科林");
        names.add("饮茶");


        setAddTextChangeWithEditText(et);

    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setShowBadge(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }

    private void bindListener() {
        tv_jiaobiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new NotificationCompat.Builder(RotatingScreenActivity.this, "chat")
//                        .setContentTitle("收到一条聊天消息")
//                        .setContentText("今天中午吃什么？")
//                        .setWhen(System.currentTimeMillis())
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                        .setAutoCancel(true)
//                        .setNumber(20)
//                        .build();
//                manager.notify(1, notification);

//                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new NotificationCompat.Builder(RotatingScreenActivity.this, "subscribe")
//                        .setContentTitle("收到一条订阅消息")
//                        .setContentText("地铁沿线30万商铺抢购中！")
//                        .setWhen(System.currentTimeMillis())
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                        .setAutoCancel(true)
//                        .setNumber(3)
//                        .build();
//                manager.notify(2, notification);
//                LinearLayout.LayoutParams upArrowParams = (LinearLayout.LayoutParams) tv_jiaobiao.getLayoutParams();
//                upArrowParams.leftMargin = upArrowParams.leftMargin+100;
//                tv_jiaobiao.setLayoutParams(upArrowParams);

            }
        });
        tv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_data.setText(toDouble(et.getText().toString()==null?"没数据":et.getText().toString()));
                UtilLog.e("tag",et.getText().toString()==null?"没数据":et.getText().toString());
            }
        });
        srv_test.addOnItemTouchListener(new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                UtilToast.shortgmsg(context,names.get(position));
            }

            @Override
            public void onLongClick(View view, final int position) {
                names.remove(position);
                informAdapter.notifyDataSetChanged();
            }
        }));
        srv_test.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                UtilLog.e("tag","onRefresh");
                names.clear();
                initData();
                informAdapter.notifyDataSetChanged();
            }
        });
        srv_test.setOnMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
                UtilLog.e("tag","onMoreAsked");
                if(names.size()<50){
                    initData();
                    informAdapter.notifyDataSetChanged();
                }
                srv_test.setRefreshing(false);
                srv_test.setLoadingMore(false);
                srv_test.getMoreProgressView().setVisibility(View.GONE);
            }
        });





        sb.setOnStarChangeListener(new StarBar.OnStarChangeListener() {
            @Override
            public void onStarChange(float mark) {
                UtilToast.shortgmsg(RotatingScreenActivity.this,"评分是："+mark+"分");
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
//                showPW();
                UtilLog.e("tag", "------"+System.currentTimeMillis()/1000+"");
            }
        });
    }

    //保留两位小数
    public static String keepTwoDecimal(double text){
        DecimalFormat df = new DecimalFormat("#.00");
        String result=df.format(text);
        if(result.startsWith(".")){
            result=0+result;
        }
        return result;
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
        tv_show = findViewById(R.id.tv_show);
        tv_data = findViewById(R.id.tv_data);
        et = findViewById(R.id.et);
        sb = findViewById(R.id.sb);
        tv_zhengshu = findViewById(R.id.tv_zhengshu);
        tv_toast = findViewById(R.id.tv_toast);
        ll_content = findViewById(R.id.ll_content);
        srv_test = findViewById(R.id.srv_test);
        tv_jiaobiao = findViewById(R.id.tv_jiaobiao);
        JzvdStd jzVideoPlayerStandard = (JzvdStd) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子闭眼睛",JzvdStd.SCREEN_WINDOW_NORMAL);
        jzVideoPlayerStandard.thumbImageView.setImageDrawable(getDrawable(R.drawable.ic_launcher_background));
    }


    class InformAdapter extends RecyclerView.Adapter<LocalViewHolder>{


        @Override
        public LocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
            LocalViewHolder viewHolder=new LocalViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(LocalViewHolder holder, int position) {
            holder.tv_name.setText(names.get(position));
        }
        @Override
        public int getItemCount() {
            return names.size();
        }
    }

    static class LocalViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;

        public LocalViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


    private boolean isRight(CharSequence charSequence){

        String reg = "^\\d{1,12}||\\d{1,12}+\\.||\\d{1,12}+\\.+\\d{1,2}$";//非零开头的最多带两位小数的数字
//                String reg = "^[0-9]+(.[0-9]{2})?$";
//        String reg = "^([1-9][0-9]*)+(.[0-9]{1,2})?$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(charSequence);
        boolean b = matcher.matches();
        return b;
    }

    private void setAddTextChangeWithEditText(final EditText editText){
        final EditText old_EditText = new EditText(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length()==0){
                    return;
                }else {
                    old_EditText.setText(s);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()<=0){
                    return;
                }
                boolean b = isRight(charSequence) ;
                if (b==true){
                    //合格
                }else {
                    if (old_EditText.getText().toString().length() > 0 ){
                        editText.setText(old_EditText.getText());
                        editText.setSelection(i+i1);

                    }else {
                        editText.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private String toDouble(String number){
        BigDecimal   b   =   new BigDecimal(number);
        String  f1  =   b.setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        return f1+"";
    }
}