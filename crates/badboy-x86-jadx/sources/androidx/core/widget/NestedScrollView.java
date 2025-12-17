package androidx.core.widget;

import android.app.Notification.Action;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.R.attr;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.List;

/* loaded from: classes5.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {

    private static final androidx.core.widget.NestedScrollView.AccessibilityDelegate ACCESSIBILITY_DELEGATE = null;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final float DECELERATION_RATE = 0f;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = null;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    final androidx.core.widget.NestedScrollView.DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private androidx.core.widget.NestedScrollView.OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private androidx.core.widget.NestedScrollView.SavedState mSavedState;
    private final int[] mScrollConsumed;
    ScrollFeedbackProviderCompat mScrollFeedbackProvider;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            int i;
            super.onInitializeAccessibilityEvent(host, event);
            final View view = host;
            event.setClassName(ScrollView.class.getName());
            i = (NestedScrollView)view.getScrollRange() > 0 ? 1 : 0;
            event.setScrollable(i);
            event.setScrollX(view.getScrollX());
            event.setScrollY(view.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(event, view.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(event, view.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            boolean scrollRange;
            int aCTION_SCROLL_UP;
            int aCTION_SCROLL_DOWN;
            super.onInitializeAccessibilityNodeInfo(host, info);
            final View view = host;
            info.setClassName(ScrollView.class.getName());
            scrollRange = view.getScrollRange();
            info.setScrollable(true);
            if ((NestedScrollView)view.isEnabled() && scrollRange > 0 && view.getScrollY() > 0) {
                scrollRange = view.getScrollRange();
                if (scrollRange > 0) {
                    info.setScrollable(true);
                    if (view.getScrollY() > 0) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                    }
                    if (view.getScrollY() < scrollRange) {
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                        info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                    }
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View host, int action, Bundle arguments) {
            int height;
            boolean globalVisibleRect;
            final int i = 1;
            if (super.performAccessibilityAction(host, action, arguments)) {
                return i;
            }
            View view = host;
            final int i2 = 0;
            if (!(NestedScrollView)view.isEnabled()) {
                return i2;
            }
            height = view.getHeight();
            Rect rect = new Rect();
            if (view.getMatrix().isIdentity() && view.getGlobalVisibleRect(rect)) {
                if (view.getGlobalVisibleRect(rect)) {
                    height = rect.height();
                }
            }
            switch (action) {
                case 4096:
                    int i10 = Math.min(scrollY2 += i6, view.getScrollRange());
                    view.smoothScrollTo(i2, i10, i);
                    return i;
                    return i2;
                case 8192:
                    int i8 = Math.max(scrollY -= i4, i2);
                    view.smoothScrollTo(i2, i8, i);
                    return i;
                    return i2;
                default:
                    return i2;
            }
        }
    }

    static class Api21Impl {
        static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    private static final class Api35Impl {
        public static void setFrameContentVelocity(View view, float velocity) {
            Throwable th;
            try {
                view.setFrameContentVelocity(velocity);
            }
        }
    }

    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {

        final androidx.core.widget.NestedScrollView this$0;
        DifferentialMotionFlingTargetImpl(androidx.core.widget.NestedScrollView this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -verticalScrollFactorCompat;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float velocity) {
            if (Float.compare(velocity, i) == 0) {
                return 0;
            }
            stopDifferentialMotionFling();
            this.this$0.fling((int)velocity);
            return 1;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.access$000(this.this$0).abortAnimation();
        }
    }

    public interface OnScrollChangeListener {
        public abstract void onScrollChange(androidx.core.widget.NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class SavedState extends View.BaseSavedState {

        public static final Parcelable.Creator<androidx.core.widget.NestedScrollView.SavedState> CREATOR;
        public int scrollPosition;
        static {
            NestedScrollView.SavedState.1 anon = new NestedScrollView.SavedState.1();
            NestedScrollView.SavedState.CREATOR = anon;
        }

        SavedState(Parcel source) {
            super(source);
            this.scrollPosition = source.readInt();
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View$BaseSavedState
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("HorizontalScrollView.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" scrollPosition=").append(this.scrollPosition).append("}").toString();
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.scrollPosition);
        }
    }
    static {
        NestedScrollView.DECELERATION_RATE = (float)i;
        NestedScrollView.AccessibilityDelegate accessibilityDelegate = new NestedScrollView.AccessibilityDelegate();
        NestedScrollView.ACCESSIBILITY_DELEGATE = accessibilityDelegate;
        NestedScrollView.SCROLLVIEW_STYLEABLE = /* result */;
    }

    public NestedScrollView(Context context) {
        super(context, 0);
    }

    public NestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Rect rect = new Rect();
        this.mTempRect = rect;
        int i = 1;
        this.mIsLayoutDirty = i;
        int i2 = 0;
        this.mIsLaidOut = i2;
        this.mChildToScrollTo = 0;
        this.mIsBeingDragged = i2;
        this.mSmoothScrollingEnabled = i;
        this.mActivePointerId = -1;
        int i5 = 2;
        this.mScrollOffset = new int[i5];
        this.mScrollConsumed = new int[i5];
        NestedScrollView.DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new NestedScrollView.DifferentialMotionFlingTargetImpl(this);
        this.mDifferentialMotionFlingTarget = differentialMotionFlingTargetImpl;
        DifferentialMotionFlingController differentialMotionFlingController = new DifferentialMotionFlingController(getContext(), this.mDifferentialMotionFlingTarget);
        this.mDifferentialMotionFlingController = differentialMotionFlingController;
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attrs);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attrs);
        this.mPhysicalCoeff = i9 *= i11;
        initScrollView();
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, NestedScrollView.SCROLLVIEW_STYLEABLE, defStyleAttr, i2);
        setFillViewport(styledAttributes.getBoolean(i2, i2));
        styledAttributes.recycle();
        NestedScrollingParentHelper nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mParentHelper = nestedScrollingParentHelper;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.mChildHelper = nestedScrollingChildHelper;
        setNestedScrollingEnabled(i);
        ViewCompat.setAccessibilityDelegate(this, NestedScrollView.ACCESSIBILITY_DELEGATE);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    static OverScroller access$000(androidx.core.widget.NestedScrollView x0) {
        return x0.mScroller;
    }

    private boolean canOverScroll() {
        int i;
        int scrollRange;
        final int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            if (overScrollMode == 1 && getScrollRange() > 0) {
                if (getScrollRange() > 0) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private boolean canScroll() {
        int i;
        i = 0;
        View childAt = getChildAt(i);
        final ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (getChildCount() > 0 && i2 += bottomMargin > i4 -= paddingBottom) {
            childAt = getChildAt(i);
            layoutParams = childAt.getLayoutParams();
            if (i2 += bottomMargin > i4 -= paddingBottom) {
                i = 1;
            }
            return i;
        }
        return i;
    }

    private static int clamp(int n, int my, int child) {
        if (my < child) {
            if (n < 0) {
            } else {
                if (my + n > child) {
                    return child - my;
                }
            }
            return n;
        }
        return 0;
    }

    private void doScrollY(int delta) {
        boolean mSmoothScrollingEnabled;
        int i;
        if (delta != 0) {
            i = 0;
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(i, delta);
            } else {
                scrollBy(i, delta);
            }
        }
    }

    private boolean edgeEffectFling(int velocityY) {
        int consumed;
        int mEdgeGlowBottom;
        int i;
        consumed = 1;
        i = 0;
        if (Float.compare(distance, i) != 0) {
            if (shouldAbsorb(this.mEdgeGlowTop, velocityY)) {
                this.mEdgeGlowTop.onAbsorb(velocityY);
            } else {
                fling(-velocityY);
            }
        } else {
            if (Float.compare(distance2, i) != 0) {
                if (shouldAbsorb(this.mEdgeGlowBottom, -velocityY)) {
                    this.mEdgeGlowBottom.onAbsorb(-velocityY);
                } else {
                    fling(-velocityY);
                }
            } else {
                consumed = 0;
            }
        }
        return consumed;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        int i2 = 0;
        this.mIsBeingDragged = i2;
        recycleVelocityTracker();
        stopNestedScroll(i2);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean topFocus, int top, int bottom) {
        int focusCandidate;
        int foundFullyContainedFocusable;
        int i2;
        Object obj;
        int top2;
        int bottom2;
        int i3;
        int i4;
        int i;
        int bottom3;
        java.util.ArrayList focusables = getFocusables(2);
        focusCandidate = 0;
        foundFullyContainedFocusable = 0;
        i2 = 0;
        while (i2 < focusables.size()) {
            obj = focusables.get(i2);
            top2 = (View)obj.getTop();
            bottom2 = obj.getBottom();
            if (top < bottom2 && top2 < bottom) {
            }
            i2++;
            if (top2 < bottom) {
            }
            i4 = 1;
            if (top < top2 && bottom2 < bottom) {
            } else {
            }
            i = i3;
            if (focusCandidate == 0) {
            } else {
            }
            if (topFocus) {
            } else {
            }
            if (!topFocus && bottom2 > focusCandidate.getBottom()) {
            } else {
            }
            if (foundFullyContainedFocusable != 0) {
            } else {
            }
            if (i != 0) {
            } else {
            }
            if (i3 != 0) {
            }
            focusCandidate = obj;
            focusCandidate = obj;
            foundFullyContainedFocusable = 1;
            if (i != 0 && i3 != 0) {
            }
            if (i3 != 0) {
            }
            focusCandidate = obj;
            if (bottom2 > focusCandidate.getBottom()) {
            } else {
            }
            i3 = i4;
            if (top2 >= focusCandidate.getTop()) {
            } else {
            }
            focusCandidate = obj;
            foundFullyContainedFocusable = i;
            if (bottom2 < bottom) {
            } else {
            }
            i = i4;
        }
        return focusCandidate;
    }

    private ScrollFeedbackProviderCompat getScrollFeedbackProvider() {
        ScrollFeedbackProviderCompat mScrollFeedbackProvider;
        if (this.mScrollFeedbackProvider == null) {
            this.mScrollFeedbackProvider = ScrollFeedbackProviderCompat.createProvider(this);
        }
        return this.mScrollFeedbackProvider;
    }

    private float getSplineFlingDistance(int velocity) {
        int i6 = 1014350479;
        mPhysicalCoeff *= i6;
        return (float)i9;
    }

    private boolean inChild(int x, int y) {
        int i;
        int right;
        i = 0;
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            final View childAt = getChildAt(i);
            if (y >= top -= scrollY && y < bottom -= scrollY && x >= childAt.getLeft() && x < childAt.getRight()) {
                if (y < bottom -= scrollY) {
                    if (x >= childAt.getLeft()) {
                        if (x < childAt.getRight()) {
                            i = 1;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker mVelocityTracker;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void initScrollView() {
        OverScroller overScroller = new OverScroller(getContext());
        this.mScroller = overScroller;
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration view = ViewConfiguration.get(getContext());
        this.mTouchSlop = view.getScaledTouchSlop();
        this.mMinimumVelocity = view.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = view.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        VelocityTracker mVelocityTracker;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int lastMotionY, int activePointerId) {
        this.mLastMotionY = lastMotionY;
        this.mActivePointerId = activePointerId;
        startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View descendant) {
        return withinDeltaOfScreen ^= 1;
    }

    private static boolean isViewDescendantOf(View child, View parent) {
        int i;
        boolean viewDescendantOf;
        if (child == parent) {
            return 1;
        }
        final ViewParent parent2 = child.getParent();
        if (parent2 instanceof ViewGroup && NestedScrollView.isViewDescendantOf((View)parent2, parent)) {
            if (NestedScrollView.isViewDescendantOf((View)parent2, parent)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean isWithinDeltaOfScreen(View descendant, int delta, int height) {
        int i;
        int i2;
        int scrollY;
        descendant.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(descendant, this.mTempRect);
        if (bottom += delta >= getScrollY() && top -= delta <= scrollY2 += height) {
            i2 = top -= delta <= scrollY2 += height ? 1 : 0;
        } else {
        }
        return i2;
    }

    private void onNestedScrollInternal(int dyUnconsumed, int type, int[] consumed) {
        int scrollY;
        int i;
        scrollBy(0, dyUnconsumed);
        final int i5 = scrollY - scrollY2;
        if (consumed != null) {
            scrollY = 1;
            consumed[scrollY] = i3 += i5;
        }
        this.mChildHelper.dispatchNestedScroll(0, i5, 0, dyUnconsumed - i5, 0, type, consumed);
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int mActivePointerId;
        VelocityTracker mVelocityTracker;
        final int actionIndex = ev.getActionIndex();
        if (ev.getPointerId(actionIndex) == this.mActivePointerId) {
            mActivePointerId = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int)f;
            this.mActivePointerId = ev.getPointerId(mActivePointerId);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker mVelocityTracker;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = 0;
        }
    }

    private int releaseVerticalGlow(int deltaY, float x) {
        int consumed;
        int mEdgeGlowBottom;
        int i;
        consumed = 0;
        int i2 = x / f;
        f2 /= f3;
        final int i5 = 0;
        if (Float.compare(distance, i5) != 0) {
            consumed = -onPullDistance;
            if (Float.compare(distance4, i5) == 0) {
                this.mEdgeGlowTop.onRelease();
            }
        } else {
            consumed = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i3, i6 -= i2);
            if (Float.compare(distance2, i5) != 0 && Float.compare(distance3, i5) == 0) {
                consumed = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i3, i6 -= i2);
                if (Float.compare(distance3, i5) == 0) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        }
        int round = Math.round(f4 *= consumed);
        if (round != 0) {
            invalidate();
        }
        return round;
    }

    private void runAnimatedScroll(boolean participateInNestedScrolling) {
        int i;
        int i2 = 1;
        if (participateInNestedScrolling) {
            startNestedScroll(2, i2);
        } else {
            stopNestedScroll(i2);
        }
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean scrollAndFocus(int direction, int top, int bottom) {
        int handled;
        int i2;
        View newFocused;
        int i;
        handled = 1;
        final int scrollY = getScrollY();
        final int i3 = scrollY + height;
        int i5 = 0;
        final int i6 = 1;
        i2 = direction == 33 ? i6 : i5;
        if (findFocusableViewInBounds(i2, top, bottom) == null) {
            newFocused = this;
        }
        if (top >= scrollY && bottom <= i3) {
            if (bottom <= i3) {
                handled = 0;
            } else {
                i = i2 != 0 ? top - scrollY : bottom - i3;
                scrollBy(i, i5, i6, i6);
            }
        } else {
        }
        if (newFocused != findFocus()) {
            newFocused.requestFocus(direction);
        }
        return handled;
    }

    private int scrollBy(int verticalScrollDistance, int x, int touchType, boolean isSourceMouseOrKeyboard) {
        return this.scrollBy(verticalScrollDistance, -1, 0, x, touchType, isSourceMouseOrKeyboard);
    }

    private void scrollToChild(View child) {
        int i;
        child.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(child, this.mTempRect);
        int scrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (scrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, scrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean immediate) {
        int i;
        final int scrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        final int i2 = 0;
        i = scrollDeltaToGetChildRectOnScreen != 0 ? 1 : i2;
        if (i != 0) {
            if (immediate) {
                scrollBy(i2, scrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(i2, scrollDeltaToGetChildRectOnScreen);
            }
        }
        return i;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int velocity) {
        int i;
        if (velocity > 0) {
            return 1;
        }
        if (Float.compare(splineFlingDistance, i2) < 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private void smoothScrollBy(int dx, int dy, int scrollDurationMs, boolean withNestedScrolling) {
        boolean z;
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        int i5;
        int i;
        OverScroller mScroller;
        int scrollX;
        int scrollY;
        int i3;
        int i6;
        int i2;
        int i4;
        if (getChildCount() == 0) {
        }
        if (Long.compare(i7, i8) > 0) {
            int i9 = 0;
            childAt = getChildAt(i9);
            layoutParams = childAt.getLayoutParams();
            scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, i10 - scrollY, scrollDurationMs);
            runAnimatedScroll(withNestedScrolling);
        } else {
            z = withNestedScrolling;
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(dx, dy);
            i6 = dy;
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean stopGlowAnimations(MotionEvent e) {
        int stopped;
        int mEdgeGlowTop;
        int mEdgeGlowBottom;
        int i;
        float f;
        stopped = 0;
        final int i2 = 0;
        if (Float.compare(distance, i2) != 0) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, i2, f2 /= f);
            stopped = 1;
        }
        if (Float.compare(distance2, i2) != 0) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i2, i3 -= i);
            stopped = 1;
        }
        return stopped;
    }

    @Override // android.widget.FrameLayout
    public void addView(View child) {
        if (getChildCount() > 0) {
        } else {
            super.addView(child);
        }
        IllegalStateException illegalStateException = new IllegalStateException("ScrollView can host only one direct child");
        throw illegalStateException;
    }

    @Override // android.widget.FrameLayout
    public void addView(View child, int index) {
        if (getChildCount() > 0) {
        } else {
            super.addView(child, index);
        }
        IllegalStateException illegalStateException = new IllegalStateException("ScrollView can host only one direct child");
        throw illegalStateException;
    }

    @Override // android.widget.FrameLayout
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
        } else {
            super.addView(child, index, params);
        }
        IllegalStateException illegalStateException = new IllegalStateException("ScrollView can host only one direct child");
        throw illegalStateException;
    }

    @Override // android.widget.FrameLayout
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
        } else {
            super.addView(child, params);
        }
        IllegalStateException illegalStateException = new IllegalStateException("ScrollView can host only one direct child");
        throw illegalStateException;
    }

    @Override // android.widget.FrameLayout
    public boolean arrowScroll(int direction) {
        View currentFocused;
        int descendantFocusability;
        int scrollDelta;
        boolean withinDeltaOfScreen;
        int i5;
        int childCount;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        int i;
        int i2;
        int i4;
        if (findFocus() == this) {
            currentFocused = 0;
        }
        View nextFocus = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        final int maxScrollAmount = getMaxScrollAmount();
        descendantFocusability = 0;
        final int i6 = 1;
        if (nextFocus != null && isWithinDeltaOfScreen(nextFocus, maxScrollAmount, getHeight())) {
            if (isWithinDeltaOfScreen(nextFocus, maxScrollAmount, getHeight())) {
                nextFocus.getDrawingRect(this.mTempRect);
                offsetDescendantRectToMyCoords(nextFocus, this.mTempRect);
                scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), descendantFocusability, i6, i6);
                nextFocus.requestFocus(direction);
            } else {
                i3 = 130;
                if (direction == 33 && getScrollY() < maxScrollAmount) {
                    if (getScrollY() < maxScrollAmount) {
                        scrollDelta = getScrollY();
                    } else {
                        if (direction == i3 && getChildCount() > 0) {
                            if (getChildCount() > 0) {
                                childCount = getChildAt(descendantFocusability);
                                scrollDelta = Math.min(i - i2, maxScrollAmount);
                            }
                        }
                    }
                } else {
                }
                if (scrollDelta == 0) {
                    return descendantFocusability;
                }
                i5 = direction == i3 ? scrollDelta : -scrollDelta;
                scrollBy(i5, descendantFocusability, i6, i6);
            }
        } else {
        }
        if (currentFocused != null && currentFocused.isFocused() && isOffScreen(currentFocused)) {
            if (currentFocused.isFocused()) {
                if (isOffScreen(currentFocused)) {
                    setDescendantFocusability(131072);
                    requestFocus();
                    setDescendantFocusability(getDescendantFocusability());
                }
            }
        }
        return i6;
    }

    @Override // android.widget.FrameLayout
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.widget.FrameLayout
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.widget.FrameLayout
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.widget.FrameLayout
    public void computeScroll() {
        Object obj;
        int overScrollMode;
        int unconsumed;
        int mEdgeGlowBottom;
        int i;
        int mScrollOffset;
        int scrollRange;
        int[] mScrollConsumed;
        int range;
        int i3;
        int i2;
        if (this.mScroller.isFinished()) {
        }
        this.mScroller.computeScrollOffset();
        final int currY = this.mScroller.getCurrY();
        int consumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - mLastScrollerY);
        this.mLastScrollerY = currY;
        final int i15 = 1;
        i2 = 0;
        this.mScrollConsumed[i15] = i2;
        this.dispatchNestedPreScroll(0, consumeFlingInVerticalStretch, this.mScrollConsumed, 0, 1);
        consumeFlingInVerticalStretch -= i6;
        scrollRange = getScrollRange();
        if (Build.VERSION.SDK_INT >= 35) {
            NestedScrollView.Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
        }
        if (unconsumed != 0) {
            int scrollY2 = getScrollY();
            obj = this;
            obj.overScrollByCompat(0, unconsumed, getScrollX(), scrollY2, 0, scrollRange, 0, 0, false);
            range = scrollRange;
            scrollY -= i3;
            i = unconsumed - i8;
            this.mScrollConsumed[i15] = i2;
            obj.dispatchNestedScroll(0, i8, 0, i, this.mScrollOffset, 1, this.mScrollConsumed);
            unconsumed = overScrollMode;
        } else {
            range = scrollRange;
        }
        if (unconsumed != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (overScrollMode == i15 && range > 0) {
                    if (range > 0) {
                        i2 = i15;
                    }
                }
            } else {
            }
            if (i2 != 0) {
                if (unconsumed < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int)currVelocity2);
                    }
                } else {
                    if (this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onAbsorb((int)currVelocity3);
                    }
                }
            }
            abortAnimatedScroll();
        }
        if (!this.mScroller.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            stopNestedScroll(i15);
        }
    }

    @Override // android.widget.FrameLayout
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int screenTop;
        int screenBottom;
        int scrollYDelta3;
        int scrollYDelta2;
        int scrollYDelta;
        int bottom;
        int i2;
        int bottom2;
        int i;
        int bottomMargin;
        int i3 = 0;
        if (getChildCount() == 0) {
            return i3;
        }
        int height = getHeight();
        screenTop = getScrollY();
        screenBottom = screenTop + height;
        final int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            screenTop += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(i3);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (rect.bottom < i5 += bottomMargin) {
            screenBottom -= verticalFadingEdgeLength;
        }
        scrollYDelta3 = 0;
        if (rect.bottom > screenBottom && rect.top > screenTop) {
            if (rect.top > screenTop) {
                if (rect.height() > height) {
                    scrollYDelta3 += i2;
                } else {
                    scrollYDelta3 += i2;
                }
                scrollYDelta3 = Math.min(scrollYDelta2, bottom - i4);
            } else {
            }
        } else {
        }
        return scrollYDelta3;
    }

    @Override // android.widget.FrameLayout
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.widget.FrameLayout
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.widget.FrameLayout
    public int computeVerticalScrollRange() {
        int scrollRange;
        int i;
        i2 -= paddingTop;
        if (getChildCount() == 0) {
            return i3;
        }
        int i4 = 0;
        final View childAt = getChildAt(i4);
        bottom += bottomMargin;
        int scrollY = getScrollY();
        int i5 = Math.max(i4, scrollRange - i3);
        if (scrollY < 0) {
            scrollRange -= scrollY;
        } else {
            if (scrollY > i5) {
                scrollRange += i;
            }
        }
        return scrollRange;
    }

    @Override // android.widget.FrameLayout
    int consumeFlingInVerticalStretch(int unconsumedY) {
        int cmp;
        EdgeEffect mEdgeGlowBottom;
        EdgeEffect mEdgeGlowTop;
        int distance;
        final int height = getHeight();
        int i = 1056964608;
        cmp = 0;
        int i7 = 1082130432;
        int round2 = Math.round(i13 *= onPullDistance2);
        if (unconsumedY > 0 && Float.compare(distance2, cmp) != 0 && round2 != unconsumedY) {
            if (Float.compare(distance2, cmp) != 0) {
                round2 = Math.round(i13 *= onPullDistance2);
                if (round2 != unconsumedY) {
                    this.mEdgeGlowTop.finish();
                }
                return unconsumedY - round2;
            }
        }
        int round = Math.round(i10 *= onPullDistance);
        if (unconsumedY < 0 && Float.compare(distance, cmp) != 0 && round != unconsumedY) {
            if (Float.compare(distance, cmp) != 0) {
                round = Math.round(i10 *= onPullDistance);
                if (round != unconsumedY) {
                    this.mEdgeGlowBottom.finish();
                }
                return unconsumedY - round;
            }
        }
        return unconsumedY;
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchKeyEvent(KeyEvent event) {
        int i;
        boolean dispatchKeyEvent;
        if (!super.dispatchKeyEvent(event)) {
            if (executeKeyEvent(event)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, 0);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    @Override // android.widget.FrameLayout
    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    @Override // android.widget.FrameLayout
    public void draw(Canvas canvas) {
        boolean finished2;
        boolean finished;
        int width;
        int height;
        int xTranslation;
        int yTranslation;
        boolean clipToPadding;
        boolean clipToPadding3;
        boolean draw;
        boolean clipToPadding2;
        boolean clipToPadding4;
        int paddingBottom;
        int i;
        super.draw(canvas);
        final int scrollY = getScrollY();
        if (!this.mEdgeGlowTop.isFinished() && NestedScrollView.Api21Impl.getClipToPadding(this)) {
            if (NestedScrollView.Api21Impl.getClipToPadding(this)) {
                width -= i5;
                xTranslation += clipToPadding;
            }
            if (NestedScrollView.Api21Impl.getClipToPadding(this)) {
                height -= i4;
                yTranslation += clipToPadding3;
            }
            canvas.translate((float)xTranslation, (float)yTranslation);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(canvas.save());
        }
        height = getHeight();
        if (!this.mEdgeGlowBottom.isFinished() && NestedScrollView.Api21Impl.getClipToPadding(this)) {
            height = getHeight();
            if (NestedScrollView.Api21Impl.getClipToPadding(this)) {
                width -= i8;
                xTranslation += clipToPadding2;
            }
            if (NestedScrollView.Api21Impl.getClipToPadding(this)) {
                height -= i6;
                yTranslation -= clipToPadding4;
            }
            canvas.translate((float)i7, (float)yTranslation);
            canvas.rotate(1127481344, (float)width, 0);
            this.mEdgeGlowBottom.setSize(width, height);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(canvas.save());
        }
    }

    @Override // android.widget.FrameLayout
    public boolean executeKeyEvent(KeyEvent event) {
        int handled;
        View currentFocused;
        boolean keyCode;
        int requestFocus;
        int shiftPressed;
        int i;
        int i2;
        this.mTempRect.setEmpty();
        requestFocus = 130;
        if (!canScroll() && isFocused() && event.getKeyCode() != 4 && findFocus() == this) {
            if (isFocused()) {
                if (event.getKeyCode() != 4) {
                    if (findFocus() == this) {
                        currentFocused = 0;
                    }
                    View nextFocus = FocusFinder.getInstance().findNextFocus(this, currentFocused, requestFocus);
                    if (nextFocus != null && nextFocus != this && nextFocus.requestFocus(requestFocus)) {
                        if (nextFocus != this) {
                            if (nextFocus.requestFocus(requestFocus)) {
                                i = 1;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    return i;
                }
            }
            return 0;
        }
        handled = 0;
        if (event.getAction() == 0) {
            i2 = 33;
            switch (shiftPressed) {
                case 19:
                    handled = fullScroll(i2);
                    handled = arrowScroll(i2);
                    break;
                case 20:
                    handled = fullScroll(requestFocus);
                    handled = arrowScroll(requestFocus);
                    break;
                case 62:
                    requestFocus = i2;
                    pageScroll(requestFocus);
                    break;
                case 92:
                    handled = fullScroll(i2);
                    break;
                case 93:
                    handled = fullScroll(requestFocus);
                    break;
                case 122:
                    pageScroll(i2);
                    break;
                case 123:
                    pageScroll(requestFocus);
                    break;
                default:
            }
        }
        return handled;
    }

    @Override // android.widget.FrameLayout
    public void fling(int velocityY) {
        int childCount;
        OverScroller mScroller;
        int scrollX;
        int scrollY;
        int i5;
        int velocityY2;
        int i;
        int i3;
        int i4;
        int i2;
        int i6;
        int i7;
        int obj13;
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, velocityY, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            runAnimatedScroll(true);
            if (Build.VERSION.SDK_INT >= 35) {
                NestedScrollView.Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
            }
        } else {
            velocityY2 = velocityY;
        }
    }

    @Override // android.widget.FrameLayout
    public boolean fullScroll(int direction) {
        int i;
        Rect childCount;
        Object mTempRect;
        ViewGroup.LayoutParams layoutParams;
        Rect mTempRect2;
        int i2;
        int paddingBottom;
        int i4 = 0;
        i = direction == 130 ? 1 : i4;
        final int height = getHeight();
        mTempRect.top = i4;
        childCount.bottom = height;
        childCount = getChildCount();
        if (i != 0 && childCount > 0) {
            childCount = getChildCount();
            if (childCount > 0) {
                mTempRect = getChildAt(childCount + -1);
                mTempRect4.bottom = i6 += paddingBottom;
                mTempRect2.top = bottom3 -= height;
            }
        }
        return scrollAndFocus(direction, count.top, mTempRect3.bottom);
    }

    @Override // android.widget.FrameLayout
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        final int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        i5 -= i3;
        if (i6 < verticalFadingEdgeLength) {
            return f /= f2;
        }
        return 1065353216;
    }

    @Override // android.widget.FrameLayout
    public int getMaxScrollAmount() {
        return (int)i;
    }

    @Override // android.widget.FrameLayout
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @Override // android.widget.FrameLayout
    int getScrollRange() {
        int scrollRange;
        int childCount;
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        int i;
        int i2;
        int i3;
        scrollRange = 0;
        if (getChildCount() > 0) {
            childCount = 0;
            childAt = getChildAt(childCount);
            layoutParams = childAt.getLayoutParams();
            scrollRange = Math.max(childCount, i - i2);
        }
        return scrollRange;
    }

    @Override // android.widget.FrameLayout
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        final int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return f /= f2;
        }
        return 1065353216;
    }

    @Override // android.widget.FrameLayout
    float getVerticalScrollFactorCompat() {
        int typedValue;
        int context;
        float dimension;
        int i;
        int i2;
        if (Float.compare(mVerticalScrollFactor, context) == 0) {
            typedValue = new TypedValue();
            context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            } else {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            throw illegalStateException;
        }
        return this.mVerticalScrollFactor;
    }

    @Override // android.widget.FrameLayout
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.widget.FrameLayout
    public boolean hasNestedScrollingParent(int type) {
        return this.mChildHelper.hasNestedScrollingParent(type);
    }

    @Override // android.widget.FrameLayout
    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.widget.FrameLayout
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.widget.FrameLayout
    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.widget.FrameLayout
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        int i2 = 0;
        child.measure(NestedScrollView.getChildMeasureSpec(parentWidthMeasureSpec, paddingLeft += paddingRight, layoutParams.width), View.MeasureSpec.makeMeasureSpec(i2, i2));
    }

    @Override // android.widget.FrameLayout
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        final ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        child.measure(NestedScrollView.getChildMeasureSpec(parentWidthMeasureSpec, i3 += widthUsed, layoutParams.width), View.MeasureSpec.makeMeasureSpec(topMargin += bottomMargin, 0));
    }

    @Override // android.widget.FrameLayout
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.widget.FrameLayout
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int x;
        Object obj;
        int axisValue;
        int i;
        int i2;
        MotionEvent motionEvent2;
        int i3;
        Object obj10;
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            if (!this.mIsBeingDragged) {
                if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                    x = motionEvent.getAxisValue(9);
                    i3 = axisValue;
                    i2 = i;
                } else {
                    if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                        i3 = i6;
                        x = axisValue;
                        i2 = i;
                    } else {
                        x = 0;
                        i3 = axisValue;
                        i2 = i;
                    }
                }
                Object obj2 = this;
                MotionEvent motionEvent3 = motionEvent;
                obj2.scrollBy(-i14, i2, motionEvent3, i3, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                if (Float.compare(x, x2) != 0 && i2 != 0) {
                    obj2 = this;
                    motionEvent3 = motionEvent;
                    obj2.scrollBy(-i14, i2, motionEvent3, i3, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                    if (i2 != 0) {
                        obj2.mDifferentialMotionFlingController.onMotionEvent(motionEvent3, i2);
                    }
                    return 1;
                }
                obj = this;
                motionEvent2 = motionEvent;
            } else {
                obj = this;
                motionEvent2 = motionEvent;
            }
        } else {
        }
        return 0;
    }

    @Override // android.widget.FrameLayout
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int springBack;
        boolean glowAnimations2;
        boolean mIsBeingDragged;
        int mActivePointerId;
        boolean glowAnimations;
        int pointerIndex;
        int i2;
        int nestedScrollAxes;
        int scrollX;
        int scrollY;
        int i;
        int i4;
        int i3;
        int scrollRange;
        final Object obj = this;
        final MotionEvent motionEvent = ev;
        final int action = motionEvent.getAction();
        springBack = 1;
        glowAnimations2 = 2;
        if (action == glowAnimations2 && obj.mIsBeingDragged) {
            if (obj.mIsBeingDragged) {
                return springBack;
            }
        }
        glowAnimations = -1;
        final int i6 = 0;
        switch (mActivePointerId) {
            case 0:
                mActivePointerId = (int)f2;
                springBack = i6;
                obj.mIsBeingDragged = springBack;
                obj.recycleVelocityTracker();
                obj.mLastMotionY = mActivePointerId;
                obj.mActivePointerId = motionEvent.getPointerId(i6);
                obj.initOrResetVelocityTracker();
                obj.mVelocityTracker.addMovement(motionEvent);
                obj.mScroller.computeScrollOffset();
                springBack = i6;
                obj.mIsBeingDragged = springBack;
                obj.startNestedScroll(glowAnimations2, i6);
                break;
            case 1:
                obj.mIsBeingDragged = i6;
                obj.mActivePointerId = glowAnimations;
                obj.recycleVelocityTracker();
                obj.postInvalidateOnAnimation();
                obj.stopNestedScroll(i6);
                break;
            case 2:
                mActivePointerId = obj.mActivePointerId;
                pointerIndex = motionEvent.findPointerIndex(mActivePointerId);
                StringBuilder stringBuilder = new StringBuilder();
                Log.e("NestedScrollView", stringBuilder.append("Invalid pointerId=").append(mActivePointerId).append(" in onInterceptTouchEvent").toString());
                glowAnimations = (int)f3;
                obj.mIsBeingDragged = springBack;
                obj.mLastMotionY = glowAnimations;
                obj.initVelocityTrackerIfNotExists();
                obj.mVelocityTracker.addMovement(motionEvent);
                obj.mNestedYOffset = i6;
                glowAnimations2 = obj.getParent();
                glowAnimations2.requestDisallowInterceptTouchEvent(springBack);
                break;
            case 3:
                break;
            default:
                onSecondaryPointerUp(ev);
        }
        return obj.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childAt;
        View mChildToScrollTo;
        int childSize;
        boolean mIsLaidOut;
        androidx.core.widget.NestedScrollView.SavedState mSavedState;
        int layoutParams;
        int scrollPosition;
        int bottomMargin;
        super.onLayout(changed, l, t, r, b);
        final int obj11 = r;
        final int obj9 = l;
        final boolean obj8 = changed;
        final Object obj7 = this;
        childAt = 0;
        obj7.mIsLayoutDirty = childAt;
        if (obj7.mChildToScrollTo != null && NestedScrollView.isViewDescendantOf(obj7.mChildToScrollTo, this)) {
            if (NestedScrollView.isViewDescendantOf(obj7.mChildToScrollTo, this)) {
                scrollToChild(obj7.mChildToScrollTo);
            }
        }
        childSize = 0;
        obj7.mChildToScrollTo = childSize;
        if (!obj7.mIsLaidOut && obj7.mSavedState != null) {
            if (obj7.mSavedState != null) {
                scrollTo(getScrollX(), mSavedState2.scrollPosition);
                obj7.mSavedState = childSize;
            }
            childSize = 0;
            if (getChildCount() > 0) {
                childAt = getChildAt(childAt);
                layoutParams = childAt.getLayoutParams();
                childSize = scrollPosition + bottomMargin;
            }
            mIsLaidOut = getScrollY();
            scrollPosition = NestedScrollView.clamp(mIsLaidOut, i3 -= paddingBottom, childSize);
            if (scrollPosition != mIsLaidOut) {
                scrollTo(getScrollX(), scrollPosition);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        obj7.mIsLaidOut = true;
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount;
        ViewGroup.LayoutParams layoutParams;
        int measuredHeight;
        int i;
        int childMeasureSpec;
        int measureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.mFillViewport) {
        }
        if (View.MeasureSpec.getMode(heightMeasureSpec) == 0) {
        }
        childCount = getChildAt(0);
        layoutParams = childCount.getLayoutParams();
        i5 -= childMeasureSpec;
        if (getChildCount() > 0 && childCount.getMeasuredHeight() < i) {
            childCount = getChildAt(0);
            layoutParams = childCount.getLayoutParams();
            i5 -= childMeasureSpec;
            if (childCount.getMeasuredHeight() < i) {
                childCount.measure(NestedScrollView.getChildMeasureSpec(widthMeasureSpec, i7 += rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!consumed) {
            final int i4 = 1;
            dispatchNestedFling(0, velocityY, i4);
            fling((int)velocityY);
            return i4;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override // android.widget.FrameLayout
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        this.onNestedPreScroll(target, dx, dy, consumed, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        this.dispatchNestedPreScroll(dx, dy, consumed, 0, type);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        onNestedScrollInternal(dyUnconsumed, 0, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        onNestedScrollInternal(dyUnconsumed, type, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        onNestedScrollInternal(dyUnconsumed, type, consumed);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScrollAccepted(View child, View target, int axes) {
        onNestedScrollAccepted(child, target, axes, 0);
    }

    @Override // android.widget.FrameLayout
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.mParentHelper.onNestedScrollAccepted(child, target, axes, type);
        startNestedScroll(2, type);
    }

    @Override // android.widget.FrameLayout
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.scrollTo(scrollX, scrollY);
    }

    @Override // android.widget.FrameLayout
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        int i2;
        View nextFocusFromRect;
        int i;
        int obj4;
        if (direction == 2) {
            obj4 = 130;
        } else {
            if (direction == 1) {
                obj4 = 33;
            }
        }
        if (previouslyFocusedRect == null) {
            nextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, 0, obj4);
        } else {
            nextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, previouslyFocusedRect, obj4);
        }
        int i3 = 0;
        if (nextFocusFromRect == null) {
            return i3;
        }
        if (isOffScreen(nextFocusFromRect)) {
            return i3;
        }
        return nextFocusFromRect.requestFocus(obj4, previouslyFocusedRect);
    }

    @Override // android.widget.FrameLayout
    protected void onRestoreInstanceState(Parcelable state) {
        if (!state instanceof NestedScrollView.SavedState) {
            super.onRestoreInstanceState(state);
        }
        Object obj = state;
        super.onRestoreInstanceState((NestedScrollView.SavedState)obj.getSuperState());
        this.mSavedState = obj;
        requestLayout();
    }

    @Override // android.widget.FrameLayout
    protected Parcelable onSaveInstanceState() {
        NestedScrollView.SavedState savedState = new NestedScrollView.SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.widget.FrameLayout
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        androidx.core.widget.NestedScrollView.OnScrollChangeListener mOnScrollChangeListener;
        Object obj;
        int l2;
        int i;
        int i2;
        int i3;
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.mOnScrollChangeListener != null) {
            this.mOnScrollChangeListener.onScrollChange(this, l, t, oldl, oldt);
        } else {
            l2 = l;
            i = t;
            i2 = oldl;
            i3 = oldt;
        }
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        boolean scrollDeltaToGetChildRectOnScreen;
        super.onSizeChanged(w, h, oldw, oldh);
        final View focus = findFocus();
        if (focus != null) {
            if (this == focus) {
            } else {
                if (isWithinDeltaOfScreen(focus, 0, oldh)) {
                    focus.getDrawingRect(this.mTempRect);
                    offsetDescendantRectToMyCoords(focus, this.mTempRect);
                    doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
                }
            }
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onStartNestedScroll(View child, View target, int axes) {
        return onStartNestedScroll(child, target, axes, 0);
    }

    @Override // android.widget.FrameLayout
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        int i;
        i = axes & 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // android.widget.FrameLayout
    public void onStopNestedScroll(View target) {
        onStopNestedScroll(target, 0);
    }

    @Override // android.widget.FrameLayout
    public void onStopNestedScroll(View target, int type) {
        this.mParentHelper.onStopNestedScroll(target, type);
        stopNestedScroll(type);
    }

    @Override // android.widget.FrameLayout
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean deltaY;
        VelocityTracker mVelocityTracker;
        int parent;
        boolean mIsBeingDragged2;
        boolean mIsBeingDragged;
        int springBack;
        boolean dispatchNestedPreFling;
        int mMinimumVelocity;
        OverScroller pointerIndex;
        int scrollX;
        int scrollY;
        int i3;
        int i;
        int i2;
        int scrollRange;
        final Object obj = this;
        final MotionEvent motionEvent2 = motionEvent;
        obj.initVelocityTrackerIfNotExists();
        final int actionMasked = motionEvent2.getActionMasked();
        deltaY = 0;
        if (actionMasked == 0) {
            obj.mNestedYOffset = deltaY;
        }
        final MotionEvent obtain = MotionEvent.obtain(motionEvent2);
        springBack = 0;
        obtain.offsetLocation(springBack, (float)mNestedYOffset);
        final int i14 = 1;
        switch (actionMasked) {
            case 0:
                return deltaY;
                mIsBeingDragged = obj.getParent();
                mIsBeingDragged.requestDisallowInterceptTouchEvent(i14);
                obj.abortAnimatedScroll();
                obj.initializeTouchDrag((int)f7, motionEvent2.getPointerId(deltaY));
                break;
            case 1:
                deltaY = obj.mVelocityTracker;
                deltaY.computeCurrentVelocity(1000, (float)mMaximumVelocity);
                parent = (int)yVelocity;
                obj.dispatchNestedFling(springBack, (float)i11, i14);
                obj.fling(-parent);
                obj.postInvalidateOnAnimation();
                obj.endTouchDrag();
                break;
            case 2:
                pointerIndex = motionEvent2.findPointerIndex(obj.mActivePointerId);
                StringBuilder stringBuilder = new StringBuilder();
                Log.e("NestedScrollView", stringBuilder.append("Invalid pointerId=").append(obj.mActivePointerId).append(" in onTouchEvent").toString());
                scrollX = (int)f;
                mLastMotionY -= scrollX;
                i6 -= releaseVerticalGlow;
                mIsBeingDragged2 = obj.getParent();
                mIsBeingDragged2.requestDisallowInterceptTouchEvent(i14);
                obj.mIsBeingDragged = i14;
                deltaY -= springBack;
                deltaY += springBack;
                parent = obj.scrollBy(deltaY, 1, motionEvent2, (int)f6, 0, false);
                obj.mLastMotionY = scrollX - parent;
                obj.mNestedYOffset = mNestedYOffset2 += parent;
                break;
            case 3:
                obj.postInvalidateOnAnimation();
                obj.endTouchDrag();
                break;
            case 4:
                break;
            case 5:
                deltaY = motionEvent2.getActionIndex();
                obj.mLastMotionY = (int)f4;
                obj.mActivePointerId = motionEvent2.getPointerId(deltaY);
                break;
            default:
                onSecondaryPointerUp(motionEvent);
                obj.mLastMotionY = (int)f2;
        }
        if (obj.mVelocityTracker != null) {
            obj.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return i14;
    }

    @Override // android.widget.FrameLayout
    boolean overScrollByCompat(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        int i10;
        int i7;
        int newScrollX;
        int i;
        int i2;
        int i8;
        int newScrollX2;
        int maxOverScrollX2;
        int newScrollY;
        int maxOverScrollY2;
        int clampedX2;
        int clampedX;
        int i11;
        OverScroller overScroller;
        int i3;
        int i4;
        int i5;
        int i9;
        int i6;
        int scrollRange;
        final Object obj = this;
        final int overScrollMode = obj.getOverScrollMode();
        int i12 = 1;
        i10 = obj.computeHorizontalScrollRange() > obj.computeHorizontalScrollExtent() ? i12 : 0;
        i7 = obj.computeVerticalScrollRange() > obj.computeVerticalScrollExtent() ? i12 : 0;
        if (overScrollMode != 0) {
            if (overScrollMode == i12 && i10 != 0) {
                if (i10 != 0) {
                    i2 = i12;
                } else {
                    i2 = 0;
                }
            } else {
            }
        } else {
        }
        if (overScrollMode != 0) {
            if (overScrollMode == i12 && i7 != 0) {
                if (i7 != 0) {
                    i8 = i12;
                } else {
                    i8 = 0;
                }
            } else {
            }
        } else {
        }
        int i13 = scrollX + deltaX;
        maxOverScrollX2 = i2 == 0 ? 0 : maxOverScrollX;
        int i14 = scrollY + deltaY;
        maxOverScrollY2 = i8 == 0 ? 0 : maxOverScrollY;
        final int i15 = -maxOverScrollX2;
        final int i16 = maxOverScrollX2 + scrollRangeX;
        final int i17 = -maxOverScrollY2;
        final int i18 = maxOverScrollY2 + scrollRangeY;
        if (i13 > i16) {
            i3 = newScrollX3;
            newScrollX2 = clampedX2;
        } else {
            if (i13 < i15) {
                i3 = newScrollX4;
                newScrollX2 = clampedX2;
            } else {
                i3 = i13;
                newScrollX2 = clampedX2;
            }
        }
        if (i14 > i18) {
            i4 = newScrollY3;
            newScrollY = clampedX;
        } else {
            if (i14 < i17) {
                i4 = newScrollY2;
                newScrollY = clampedX;
            } else {
                i4 = i14;
                newScrollY = clampedX;
            }
        }
        if (newScrollY != 0 && !obj.hasNestedScrollingParent(i12)) {
            if (!obj.hasNestedScrollingParent(i12)) {
                obj.mScroller.springBack(i3, i4, 0, 0, 0, obj.getScrollRange());
                newScrollX = i3;
                i = i4;
            } else {
                newScrollX = i3;
                i = i4;
            }
        } else {
        }
        obj.onOverScrolled(newScrollX, i, newScrollX2, newScrollY);
        if (newScrollX2 == 0) {
            if (newScrollY != 0) {
                i11 = 1;
            } else {
                i11 = 0;
            }
        } else {
        }
        return i11;
    }

    @Override // android.widget.FrameLayout
    public boolean pageScroll(int direction) {
        int i3;
        int childCount;
        int mTempRect2;
        int layoutParams;
        int i;
        int mTempRect;
        int i2;
        childCount = 0;
        i3 = direction == 130 ? 1 : childCount;
        final int height = getHeight();
        if (i3 != 0) {
            mTempRect5.top = scrollY += height;
            childCount = getChildCount();
            mTempRect2 = getChildAt(childCount + -1);
            i7 += paddingBottom;
            if (childCount > 0 && top3 += height > i) {
                mTempRect2 = getChildAt(childCount + -1);
                i7 += paddingBottom;
                if (top3 += height > i) {
                    mTempRect.top = i - height;
                }
            }
        } else {
            mTempRect8.top = scrollY2 -= height;
            if (mTempRect9.top < 0) {
                mTempRect2.top = childCount;
            }
        }
        mTempRect3.bottom = top2 += height;
        return scrollAndFocus(direction, mTempRect4.top, mTempRect7.bottom);
    }

    @Override // android.widget.FrameLayout
    public void requestChildFocus(View child, View focused) {
        if (!this.mIsLayoutDirty) {
            scrollToChild(focused);
        } else {
            this.mChildToScrollTo = focused;
        }
        super.requestChildFocus(child, focused);
    }

    @Override // android.widget.FrameLayout
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        rectangle.offset(left -= scrollX, top -= scrollY);
        return scrollToChildRect(rectangle, immediate);
    }

    @Override // android.widget.FrameLayout
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.widget.FrameLayout
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout
    int scrollBy(int verticalScrollDistance, int verticalScrollAxis, MotionEvent ev, int x, int touchType, boolean isSourceMouseOrKeyboard) {
        int i3;
        int dispatchNestedPreScroll;
        int i5;
        boolean nestedScrollingParent;
        int i;
        int scrollFeedbackProvider2;
        int i2;
        int deviceId;
        int scrollY;
        int totalScrollOffset;
        Object scrollFeedbackProvider3;
        int mEdgeGlowBottom;
        boolean mVelocityTracker;
        int mEdgeGlowBottom2;
        Object scrollFeedbackProvider;
        int mScrollConsumed;
        int source;
        int source2;
        int i4;
        int i6;
        int hitScrollBarrier;
        final Object obj = this;
        final int i29 = verticalScrollAxis;
        final Object obj2 = x;
        int i20 = touchType;
        totalScrollOffset = 0;
        source = 1;
        if (i20 == source) {
            obj.startNestedScroll(2, i20);
        }
        source2 = i20;
        if (obj.dispatchNestedPreScroll(0, verticalScrollDistance, obj.mScrollConsumed, obj.mScrollOffset, i20)) {
            i2 = dispatchNestedPreScroll;
            i4 = totalScrollOffset;
        } else {
            i2 = verticalScrollDistance;
            i4 = totalScrollOffset;
        }
        scrollY = obj.getScrollY();
        int scrollRange = obj.getScrollRange();
        i6 = 0;
        if (obj.canOverScroll() && !isSourceMouseOrKeyboard) {
            i5 = !isSourceMouseOrKeyboard ? source : i6;
        } else {
        }
        final int i31 = i5;
        final int i32 = i2;
        int i26 = scrollY;
        if (obj.overScrollByCompat(0, i2, 0, scrollY, 0, scrollRange, 0, 0, true) && !obj.hasNestedScrollingParent(source2)) {
            i = !obj.hasNestedScrollingParent(source2) ? source : i6;
        } else {
        }
        hitScrollBarrier = i;
        int i16 = scrollFeedbackProvider2 - i26;
        if (ev != null && i16 != 0) {
            if (i16 != 0) {
                obj.getScrollFeedbackProvider().onScrollProgress(ev.getDeviceId(), ev.getSource(), i29, i16);
            }
        }
        obj.mScrollConsumed[source] = i6;
        mEdgeGlowBottom = source2;
        obj.dispatchNestedScroll(0, i16, 0, i32 - i16, obj.mScrollOffset, mEdgeGlowBottom, obj.mScrollConsumed);
        int i22 = mEdgeGlowBottom;
        int i13 = i32 - i12;
        int i18 = i26 + i13;
        if (i18 < 0) {
            EdgeEffectCompat.onPullDistance(obj.mEdgeGlowTop, f2 /= f6, f7 /= i6);
            if (i31 != 0 && ev != null) {
                EdgeEffectCompat.onPullDistance(obj.mEdgeGlowTop, f2 /= f6, f7 /= i6);
                if (ev != null) {
                    obj.getScrollFeedbackProvider().onScrollLimit(ev.getDeviceId(), ev.getSource(), i29, source);
                }
                if (!obj.mEdgeGlowBottom.isFinished()) {
                    obj.mEdgeGlowBottom.onRelease();
                }
            }
        } else {
            EdgeEffectCompat.onPullDistance(obj.mEdgeGlowBottom, f /= f4, i30 -= source2);
            if (i18 > scrollRange && i31 != 0 && ev != null) {
                if (i31 != 0) {
                    EdgeEffectCompat.onPullDistance(obj.mEdgeGlowBottom, f /= f4, i30 -= source2);
                    if (ev != null) {
                        obj.getScrollFeedbackProvider().onScrollLimit(ev.getDeviceId(), ev.getSource(), i29, i6);
                    }
                    if (!obj.mEdgeGlowTop.isFinished()) {
                        obj.mEdgeGlowTop.onRelease();
                    }
                }
            }
        }
        if (obj.mEdgeGlowTop.isFinished()) {
            if (!obj.mEdgeGlowBottom.isFinished()) {
                obj.postInvalidateOnAnimation();
                hitScrollBarrier = 0;
            }
        } else {
        }
        if (hitScrollBarrier != 0 && i22 == 0 && obj.mVelocityTracker != null) {
            if (i22 == 0) {
                if (obj.mVelocityTracker != null) {
                    obj.mVelocityTracker.clear();
                }
            }
        }
        if (i22 == 1) {
            obj.stopNestedScroll(i22);
            obj.mEdgeGlowTop.onRelease();
            obj.mEdgeGlowBottom.onRelease();
        }
        return i4 += i11;
    }

    @Override // android.widget.FrameLayout
    public void scrollTo(int x, int y) {
        int childCount;
        ViewGroup.LayoutParams layoutParams;
        int i3;
        int i;
        int i4;
        int i2;
        int scrollX;
        int obj8;
        int obj9;
        if (getChildCount() > 0) {
            childCount = getChildAt(0);
            layoutParams = childCount.getLayoutParams();
            obj8 = NestedScrollView.clamp(x, i6 -= paddingRight, i7 += rightMargin);
            obj9 = NestedScrollView.clamp(y, i8 -= paddingBottom, i9 += bottomMargin);
            if (obj8 == getScrollX()) {
                if (obj9 != getScrollY()) {
                    super.scrollTo(obj8, obj9);
                }
            } else {
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void setFillViewport(boolean fillViewport) {
        if (fillViewport != this.mFillViewport) {
            this.mFillViewport = fillViewport;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public void setNestedScrollingEnabled(boolean enabled) {
        this.mChildHelper.setNestedScrollingEnabled(enabled);
    }

    @Override // android.widget.FrameLayout
    public void setOnScrollChangeListener(androidx.core.widget.NestedScrollView.OnScrollChangeListener l) {
        this.mOnScrollChangeListener = l;
    }

    @Override // android.widget.FrameLayout
    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        this.mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    @Override // android.widget.FrameLayout
    public boolean shouldDelayChildPressedState() {
        return 1;
    }

    @Override // android.widget.FrameLayout
    public final void smoothScrollBy(int dx, int dy) {
        smoothScrollBy(dx, dy, 250, false);
    }

    @Override // android.widget.FrameLayout
    public final void smoothScrollBy(int dx, int dy, int scrollDurationMs) {
        smoothScrollBy(dx, dy, scrollDurationMs, false);
    }

    @Override // android.widget.FrameLayout
    public final void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 250, false);
    }

    @Override // android.widget.FrameLayout
    public final void smoothScrollTo(int x, int y, int scrollDurationMs) {
        smoothScrollTo(x, y, scrollDurationMs, false);
    }

    @Override // android.widget.FrameLayout
    void smoothScrollTo(int x, int y, int scrollDurationMs, boolean withNestedScrolling) {
        smoothScrollBy(x - scrollX, y - scrollY, scrollDurationMs, withNestedScrolling);
    }

    @Override // android.widget.FrameLayout
    void smoothScrollTo(int x, int y, boolean withNestedScrolling) {
        smoothScrollTo(x, y, 250, withNestedScrolling);
    }

    @Override // android.widget.FrameLayout
    public boolean startNestedScroll(int axes) {
        return startNestedScroll(axes, 0);
    }

    @Override // android.widget.FrameLayout
    public boolean startNestedScroll(int axes, int type) {
        return this.mChildHelper.startNestedScroll(axes, type);
    }

    @Override // android.widget.FrameLayout
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.widget.FrameLayout
    public void stopNestedScroll(int type) {
        this.mChildHelper.stopNestedScroll(type);
    }
}
