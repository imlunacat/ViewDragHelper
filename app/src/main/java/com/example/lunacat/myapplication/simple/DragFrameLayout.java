package com.example.lunacat.myapplication.simple;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;


public class DragFrameLayout extends FrameLayout {
    private ViewDragHelper mViewDragHelper;
    public DragFrameLayout(@NonNull Context context) {
        super(context);
        init();
    }

    public DragFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DragFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - child.getWidth();
                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
                return newLeft;
            }

            public int clampViewPositionVertical(View child, int top, int dy) {
                final int topBound = getPaddingTop();
                final int bottomBound = getHeight() - child.getHeight();
                final int newTop = Math.min(Math.max(top, topBound), bottomBound);
                return newTop;
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
