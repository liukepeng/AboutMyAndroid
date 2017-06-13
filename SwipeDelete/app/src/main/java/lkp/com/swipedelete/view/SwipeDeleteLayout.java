package lkp.com.swipedelete.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.util.ArrayList;

import lkp.com.swipedelete.R;

/**
 * Created by Administrator on 2017/6/13.
 */

public class SwipeDeleteLayout extends ViewGroup {

    private final ArrayList<View> mMatchParentChildren = new ArrayList<>(1);
    private int mLeftViewResID;
    private int mRightViewResID;
    private int mContentViewResID;
    private View mLeftView;
    private View mRightView;
    private View mContentView;
    private MarginLayoutParams mContentViewLp;
    private boolean isSwipeing;
    private boolean isTouched;
    private PointF mLastP;
    private PointF mFirstP;
    private float mFraction = 0.5f;
    private boolean mCanLeftSwipe = true;
    private boolean mCanRightSwipe = true;
    private int mScaledTouchSlop;
    private Scroller mScroller;
    private static SwipeDeleteLayout mViewCache;
    private static State mStateCache;

    public enum State {
        LEFTOPEN,
        RIGHTOPEN,
        CLOSE,
    }


    public SwipeDeleteLayout(Context context) {
        this(context, null);
    }

    public SwipeDeleteLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeDeleteLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr){
        //创建辅助对象
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        mScaledTouchSlop = viewConfiguration.getScaledTouchSlop();//在我们认为用户滚动之前，触摸可以漫游的像素的距离
        mScroller = new Scroller(context);
        //1、获取配置属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SwipeDeleteLayout, defStyleAttr, 0);

        try {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++){
                int attr = typedArray.getIndex(i);
                if (attr == R.styleable.SwipeDeleteLayout_leftMenuView){
                    mLeftViewResID = typedArray.getResourceId(R.styleable.SwipeDeleteLayout_leftMenuView, -1);
                } else if (attr == R.styleable.SwipeDeleteLayout_rightMenuView){
                    mRightViewResID = typedArray.getResourceId(R.styleable.SwipeDeleteLayout_rightMenuView, -1);
                } else if (attr == R.styleable.SwipeDeleteLayout_contentView){
                    mContentViewResID = typedArray.getResourceId(R.styleable.SwipeDeleteLayout_contentView,-1);
                } else if (attr == R.styleable.SwipeDeleteLayout_canLeftSwipe){
                    mCanLeftSwipe = typedArray.getBoolean(R.styleable.SwipeDeleteLayout_canLeftSwipe, true);
                } else if (attr == R.styleable.SwipeDeleteLayout_canRightSwipe){
                    mCanRightSwipe = typedArray.getBoolean(R.styleable.SwipeDeleteLayout_canRightSwipe, true);
                } else if (attr == R.styleable.SwipeDeleteLayout_fraction){
                    mFraction = typedArray.getFloat(R.styleable.SwipeDeleteLayout_fraction, 0.5f);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取childView的个数
        int count = getChildCount();
        final boolean meassureMatchParentChildren =
                MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY ||
                MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY;

        mMatchParentChildren.clear();
        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;

        for (int i = 0; i < count; i++){
            View child = getChildAt(i);

            if (child.getVisibility() != GONE){
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) child.getLayoutParams();
                maxWidth = Math.max(maxWidth, child.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                maxHeight = Math.max(maxHeight, child.getMeasuredHeight() + marginLayoutParams.topMargin +marginLayoutParams.bottomMargin);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                if (meassureMatchParentChildren){
                    if (marginLayoutParams.width == LayoutParams.MATCH_PARENT ||
                            marginLayoutParams.height == LayoutParams.MATCH_PARENT){
                        mMatchParentChildren.add(child);
                    }
                }
            }
        }
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(maxHeight, heightMeasureSpec, childState << MEASURED_HEIGHT_STATE_SHIFT));

        count = mMatchParentChildren.size();
        if (count > 1){
            for (int i = 0; i < count; i++){
                final View child = mMatchParentChildren.get(i);
                final MarginLayoutParams marginLayoutParams = (MarginLayoutParams) child.getLayoutParams();

                final int childWidthMeasureSpec;
                if (marginLayoutParams.width == LayoutParams.MATCH_PARENT){
                    final int width = Math.max(0,getMeasuredWidth() - marginLayoutParams.leftMargin - marginLayoutParams.rightMargin);
                    childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
                } else {
                    childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
                }

                final int childHeightMeasureSpec;
                if (marginLayoutParams.height == LayoutParams.MATCH_PARENT){
                    final int height = Math.max(0, getMeasuredHeight() - marginLayoutParams.topMargin - marginLayoutParams.bottomMargin);
                    childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
                } else {
                    childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
                }

                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int left = 0 + getPaddingLeft();
        int right = 0 + getPaddingRight();
        int top = 0 + getPaddingTop();
        int bottom = 0 + getPaddingBottom();

        for (int i = 0; i < count; i++){
            View child = getChildAt(i);
            if (mLeftView == null && child.getId() == mLeftViewResID){
                mLeftView = child;
                mLeftView.setClickable(true);
            } else if (mRightView == null && child.getId() == mRightViewResID){
                mRightView = child;
                mRightView.setClickable(true);
            } else if (mContentView == null && child.getId() == mContentViewResID){
                mContentView = child;
                mContentView.setClickable(true);
            }

            if (mContentView != null){
                mContentViewLp = (MarginLayoutParams) mContentView.getLayoutParams();
                int cTop = top + mContentViewLp.topMargin;
                int cLeft = left + mContentViewLp.leftMargin;
                int cRight = left + mContentViewLp.leftMargin + mContentView.getMeasuredWidth();
                int cBottom = cTop + mContentView.getMeasuredHeight();
                mContentView.layout(cLeft, cTop, cRight, cBottom);
            }
            if (mLeftView != null) {
                MarginLayoutParams leftViewLp = (MarginLayoutParams) mLeftView.getLayoutParams();
                int lTop = top + leftViewLp.topMargin;
                int lLeft = 0 - mLeftView.getMeasuredWidth() + leftViewLp.leftMargin + leftViewLp.rightMargin;
                int lRight = 0 - leftViewLp.rightMargin;
                int lBottom = lTop + mLeftView.getMeasuredHeight();
                mLeftView.layout(lLeft, lTop, lRight, lBottom);
            }
            if (mRightView != null) {
                MarginLayoutParams rightViewLp = (MarginLayoutParams) mRightView.getLayoutParams();
                int lTop = top + rightViewLp.topMargin;
                int lLeft = mContentView.getRight() + mContentViewLp.rightMargin + rightViewLp.leftMargin;
                int lRight = lLeft + mRightView.getMeasuredWidth();
                int lBottom = lTop + mRightView.getMeasuredHeight();
                mRightView.layout(lLeft, lTop, lRight, lBottom);
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                isSwipeing = false;
                if (mLastP == null) {
                    mLastP = new PointF();
                }
                mLastP.set(ev.getRawX(), ev.getRawY());
                if (mFirstP == null) {
                    mFirstP = new PointF();
                }
                mFirstP.set(ev.getRawX(), ev.getRawY());
                if (mViewCache != null) {
                    if (mViewCache != this) {
                        mViewCache.handlerSwipeMenu(State.CLOSE);

                    }
//                    getParent().requestDisallowInterceptTouchEvent(true);
                }

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                isSwipeing = true;
                float distanceX = mLastP.x - ev.getRawX();
                float distanceY = mLastP.y - ev.getRawY();
                if (Math.abs(distanceY) > mScaledTouchSlop * 2) {
                    break;
                }
                //当处于水平滑动时，禁止父类拦截
                if (Math.abs(distanceX) > mScaledTouchSlop * 2 || Math.abs(getScrollX()) > mScaledTouchSlop * 2) {
                    requestDisallowInterceptTouchEvent(true);
                }
                scrollBy((int) (distanceX), 0);//滑动使用scrollBy

                //越界修正
                if (getScrollX() < 0) {
                    if (!mCanRightSwipe || mLeftView == null) {
                        scrollTo(0, 0);
                    } else {//左滑
                        if (getScrollX() < mLeftView.getLeft()) {
                            scrollTo(mLeftView.getLeft(), 0);
                        }

                    }
                } else if (getScrollX() > 0) {
                    if (!mCanLeftSwipe || mRightView == null) {
                        scrollTo(0, 0);
                    } else {
                        if (getScrollX() > mRightView.getRight() - mContentView.getRight() - mContentViewLp.rightMargin) {
                            scrollTo(mRightView.getRight() - mContentView.getRight() - mContentViewLp.rightMargin, 0);
                        }
                    }
                }

                mLastP.set(ev.getRawX(), ev.getRawY());

                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                State result = isShouldOpen(getScrollX());
                handlerSwipeMenu(result);
                break;
            }
            default: {
                break;
            }
        }

        return super.dispatchTouchEvent(ev);
    }

    /**
     * 自动设置状态
     *
     * @param result
     */
    private void handlerSwipeMenu(State result) {
        if (result == State.LEFTOPEN) {
            mScroller.startScroll(getScrollX(), 0, mLeftView.getLeft() - getScrollX(), 0);
            mViewCache = this;
            mStateCache = result;
        } else if (result == State.RIGHTOPEN) {
            mViewCache = this;
            mScroller.startScroll(getScrollX(), 0, mRightView.getRight() - mContentView.getRight() - mContentViewLp.rightMargin - getScrollX(), 0);
            mStateCache = result;
        } else {
            mScroller.startScroll(getScrollX(), 0, -getScrollX(), 0);
            mViewCache = null;
            mStateCache = null;

        }
        invalidate();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                //对左边界进行处理
                float distance = mLastP.x - event.getRawX();
                if (Math.abs(distance) > mScaledTouchSlop) {
                    // 当手指拖动值大于mScaledTouchSlop值时，认为应该进行滚动，拦截子控件的事件
                    return true;
                }
                break;

            }

        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        //判断Scroller是否执行完毕：
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            //通知View重绘-invalidate()->onDraw()->computeScroll()
            invalidate();
        }
    }
    /**
     * 根据当前的scrollX的值判断松开手后应处于何种状态
     *
     * @param scrollX
     * @return
     */
    private State isShouldOpen(int scrollX) {
        if (getScrollX() < 0 && mLeftView != null) {
            //➡滑动
            //获得leftView的测量长度
            if (Math.abs(mLeftView.getWidth() * mFraction) < Math.abs(getScrollX())) {
                return State.LEFTOPEN;
            }

        } else if (getScrollX() > 0 && mRightView != null) {
            //⬅️滑动
            if (Math.abs(mRightView.getWidth() * mFraction) < Math.abs(getScrollX())) {
                return State.RIGHTOPEN;
            }

        }
        return State.CLOSE;
    }

    @Override
    protected void onDetachedFromWindow() {
        if (this == mViewCache) {
            mViewCache.handlerSwipeMenu(State.CLOSE);
        }
        super.onDetachedFromWindow();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this == mViewCache) {
            mViewCache.handlerSwipeMenu(mStateCache);
        }
    }

    public void resetStatus() {
        if (mViewCache != null) {
            if (mStateCache != null && mStateCache != State.CLOSE && mScroller != null) {
                mScroller.startScroll(mViewCache.getScrollX(), 0, -mViewCache.getScrollX(), 0);
                mViewCache.invalidate();
                mViewCache = null;
                mStateCache = null;
            }
        }
    }

    public float getFraction() {
        return mFraction;
    }

    public void setFraction(float mFraction) {
        this.mFraction = mFraction;
    }

    public boolean isCanLeftSwipe() {
        return mCanLeftSwipe;
    }

    public void setCanLeftSwipe(boolean mCanLeftSwipe) {
        this.mCanLeftSwipe = mCanLeftSwipe;
    }

    public boolean isCanRightSwipe() {
        return mCanRightSwipe;
    }

    public void setCanRightSwipe(boolean mCanRightSwipe) {
        this.mCanRightSwipe = mCanRightSwipe;
    }

    public static SwipeDeleteLayout getViewCache() {
        return mViewCache;
    }


    public static State getStateCache() {
        return mStateCache;
    }

}
