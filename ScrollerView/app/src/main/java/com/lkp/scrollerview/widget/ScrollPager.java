package com.lkp.scrollerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Administrator on 2016/11/7.
 */
public class ScrollPager extends ViewGroup {
    private Scroller mScroller;

    //手指每次移动时需要更新x，记录上次手指所在的坐标。
    private float mLastX;

    public ScrollPager(Context context){
        this(context,null,0);
    }

    public ScrollPager(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }

    public ScrollPager(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getRawX();

        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:{
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                mLastX = x;
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                int dxMove = (int) (mLastX - x);
                scrollBy(dxMove,0);
                mLastX = x;
                return true;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:{
                // 当手指抬起时，第几屏占的比例大就去第几屏。(这里在除的时候加上view一半宽是因为滑动到0.6的时候，不到1，结果就是0
                // 其实按照惯性应该是1，所以我们给它补上一半的屏，这样相当于4舍5入。)
                int sonIndex = (getScrollX()+getWidth()/2)/getWidth();

                //如果滑动页面超过当前页面数，那么把屏index定为最大页面数的index。
                int childCount = getChildCount();
                if (sonIndex >= childCount){
                    sonIndex = childCount -1;
                }
                int dx = sonIndex * getWidth() - getScrollX();
                //y方向不变，x方向到目的地
                mScroller.startScroll(getScrollX(),0,dx,0,500);
                invalidate();
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i<childCount;i++){
            View childView = getChildAt(i);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }

    protected void onLayout(boolean changed, int l,int t,int r,int b){
        if (changed){
            int childCount = getChildCount();
            for (int i = 0;i<childCount;i++){
                View childView = getChildAt(i);
                int childW = childView.getMeasuredWidth();
                childView.layout(i * childW, 0, childW * i + childW, childView.getMeasuredHeight());
                }
            }
        }
    }

