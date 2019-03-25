package com.wow.shuigugu.cctest.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;

import com.wow.shuigugu.cctest.util.UtilToast;
import com.wow.shuigugu.cctest.view.StarBar;

import cn.jzvd.JzvdStd;

/**
 * Created by cl on 2019/3/22.
 */
public class MyView extends JzvdStd {
    Context context;
    private OnStateChangeListener OnStateChangeListener;
    public MyView(Context context) {
        super(context);
        this.context = context;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        UtilToast.shortgmsg(context,"播放完毕");
        OnStateChangeListener.onStateChange(JzvdStd.CURRENT_STATE_AUTO_COMPLETE);
    }


    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener){
        this.OnStateChangeListener = OnStateChangeListener;
    }

    public interface OnStateChangeListener {
        void onStateChange(int state);
    }
}
