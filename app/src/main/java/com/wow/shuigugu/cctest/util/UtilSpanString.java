package com.wow.shuigugu.cctest.util;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.wow.shuigugu.cctest.R;

/**
 * 仿百度贴吧的评论回复util
 */

public class UtilSpanString {
    public static SpannableStringBuilder setClick(final Context context , String a, String b, String c, View.OnClickListener nameClick,View.OnClickListener itemClick){
        if(b==null||(b!=null&&(b.contains("null")))){
            b=": ";
        }
        SpannableStringBuilder spanableInfo = new SpannableStringBuilder(a+b+c);
        spanableInfo.setSpan(new Clickable(context,nameClick), 0, a.length(), Spanned.SPAN_MARK_MARK);
        spanableInfo.setSpan(new Clickable(context,itemClick), a.length(), (a+b+c).length(), Spanned.SPAN_MARK_MARK);
        spanableInfo.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.fontBlue)), 0, a.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanableInfo.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.fontBlack)), a.length(), (a+b+c).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanableInfo;
    }
    public static class Clickable extends ClickableSpan implements View.OnClickListener {
        private Context context;
        private View.OnClickListener click;
        public Clickable(Context context,View.OnClickListener nameClick) {
            this.context = context;
            this.click = nameClick;
        }

        @Override
        public void onClick(View v) {
            click.onClick(v);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }

    }
}
