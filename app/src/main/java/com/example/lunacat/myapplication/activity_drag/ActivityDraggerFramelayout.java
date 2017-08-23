package com.example.lunacat.myapplication.activity_drag;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class ActivityDraggerFramelayout extends FrameLayout {
    private ViewDragHelper mViewDragHelper;
    public ActivityDraggerFramelayout(@NonNull Context context) {
        super(context);
    }

    public ActivityDraggerFramelayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ActivityDraggerFramelayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ActivityDraggerFramelayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onAttach(@NonNull Activity activity) {
//        View root = activity.findViewById(android.R.id.content);

        View root = ((ViewGroup)activity.getWindow().getDecorView()).getChildAt(0);
        android.util.Log.d("123", "123");
        mViewDragHelper = ViewDragHelper.create((ViewGroup) root, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return 0;
            }

            public int clampViewPositionVertical(View child, int top, int dy) {
                final int topBound = getPaddingTop();
                final int bottomBound = getHeight() - child.getHeight();
                final int newTop = Math.min(Math.max(top, topBound), bottomBound);
                return top;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            mViewDragHelper.processTouchEvent(ev);
        } catch (Exception ex){
            // nothing we can do
        }
        return true;
    }
}
