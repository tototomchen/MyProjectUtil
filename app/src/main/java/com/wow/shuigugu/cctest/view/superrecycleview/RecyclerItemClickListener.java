package com.wow.shuigugu.cctest.view.superrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by cl on 2019/2/15.
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener{
    private View childView;
    private RecyclerView touchView;
    public RecyclerItemClickListener(Context context, final OnItemClickListener mListener) {
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent ev) {
                if (childView != null && mListener != null) {
                    mListener.onItemClick(childView, touchView.getChildPosition(childView));
                }
                return true;
            }
            @Override
            public void onLongPress(MotionEvent ev) {
                if (childView != null && mListener != null) {
                    mListener.onLongClick(childView, touchView.getChildPosition(childView));
                }
            }
        });
    }

    GestureDetector mGestureDetector;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
        public void onLongClick(View view, int position);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        childView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        touchView = recyclerView;
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
