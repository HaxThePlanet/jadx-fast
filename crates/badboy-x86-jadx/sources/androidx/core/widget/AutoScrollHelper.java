package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* loaded from: classes5.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = 340282350000000000000000000000000000000f;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = 340282350000000000000000000000000000000f;
    public static final float NO_MIN = 0f;
    public static final float RELATIVE_UNSPECIFIED = 0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    final androidx.core.widget.AutoScrollHelper.ClampedScroller mScroller;
    final View mTarget;

    private static class ClampedScroller {

        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;
        ClampedScroller() {
            super();
            long l = Long.MIN_VALUE;
            int i = -1;
            int i2 = 0;
            int i3 = 0;
        }

        private float getValueAt(long currentTime) {
            int cmp;
            long mStopTime;
            int i5 = 0;
            if (Long.compare(currentTime, mStartTime) < 0) {
                return i5;
            }
            int i7 = 1065353216;
            if (Long.compare(mStopTime2, i10) >= 0 && Long.compare(currentTime, mStopTime) < 0) {
                if (Long.compare(currentTime, mStopTime) < 0) {
                }
                return i += i11;
            }
            return constrain *= i6;
        }

        private float interpolateValue(float value) {
            return i3 += i6;
        }

        public void computeScrollDelta() {
            if (Long.compare(mDeltaTime, i) == 0) {
            } else {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                final float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
                int i2 = currentAnimationTimeMillis - mDeltaTime2;
                this.mDeltaTime = currentAnimationTimeMillis;
                this.mDeltaX = (int)i4;
                this.mDeltaY = (int)i7;
            }
            RuntimeException currentTime = new RuntimeException("Cannot compute scroll delta before calling start()");
            throw currentTime;
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            return (int)i;
        }

        public int getVerticalDirection() {
            return (int)i;
        }

        public boolean isFinished() {
            int cmp;
            int i2;
            int i;
            long l;
            if (Long.compare(mStopTime, i) > 0 && Long.compare(currentAnimationTimeMillis, i) > 0) {
                i2 = Long.compare(currentAnimationTimeMillis, i) > 0 ? 1 : 0;
            } else {
            }
            return i2;
        }

        public void requestStop() {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int)i, 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int durationMillis) {
            this.mRampDownDuration = durationMillis;
        }

        public void setRampUpDuration(int durationMillis) {
            this.mRampUpDuration = durationMillis;
        }

        public void setTargetVelocity(float x, float y) {
            this.mTargetVelocityX = x;
            this.mTargetVelocityY = y;
        }

        public void start() {
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStopTime = -1;
            this.mDeltaTime = this.mStartTime;
            this.mStopValue = 1056964608;
            int i3 = 0;
            this.mDeltaX = i3;
            this.mDeltaY = i3;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {

        final androidx.core.widget.AutoScrollHelper this$0;
        ScrollAnimationRunnable(androidx.core.widget.AutoScrollHelper autoScrollHelper) {
            this.this$0 = autoScrollHelper;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean mNeedsReset;
            int this$0;
            boolean finished;
            boolean mNeedsCancel;
            if (!this$02.mAnimating) {
            }
            this$0 = 0;
            if (this$03.mNeedsReset != null) {
                this$04.mNeedsReset = this$0;
                this$05.mScroller.start();
            }
            androidx.core.widget.AutoScrollHelper.ClampedScroller mScroller = this$06.mScroller;
            if (!mScroller.isFinished()) {
                if (!this.this$0.shouldAnimate()) {
                } else {
                    if (this$08.mNeedsCancel) {
                        mNeedsCancel.mNeedsCancel = this$0;
                        this.this$0.cancelTargetTouch();
                    }
                }
                mScroller.computeScrollDelta();
                this.this$0.scrollTargetBy(mScroller.getDeltaX(), mScroller.getDeltaY());
                ViewCompat.postOnAnimation(this$010.mTarget, this);
            }
            deltaY.mAnimating = this$0;
        }
    }
    static {
        AutoScrollHelper.DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    public AutoScrollHelper(View target) {
        super();
        AutoScrollHelper.ClampedScroller clampedScroller = new AutoScrollHelper.ClampedScroller();
        this.mScroller = clampedScroller;
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.mEdgeInterpolator = accelerateInterpolator;
        int i = 2;
        float[] fArr2 = new float[i];
        fArr2 = new int[]{0, 0};
        this.mRelativeEdges = fArr2;
        float[] fArr3 = new float[i];
        fArr3 = new int[]{2139095039, 2139095039};
        this.mMaximumEdges = fArr3;
        float[] fArr4 = new float[i];
        fArr4 = new int[]{0, 0};
        this.mRelativeVelocity = fArr4;
        float[] fArr5 = new float[i];
        fArr5 = new int[]{0, 0};
        this.mMinimumVelocity = fArr5;
        float[] fArr = new float[i];
        fArr = new int[]{2139095039, 2139095039};
        this.mMaximumVelocity = fArr;
        this.mTarget = target;
        android.util.DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i3 = 1056964608;
        int i7 = (int)i6;
        int i4 = (int)i15;
        setMaximumVelocity((float)i7, (float)i7);
        setMinimumVelocity((float)i4, (float)i4);
        setEdgeType(1);
        int i10 = 2139095039;
        setMaximumEdges(i10, i10);
        int i11 = 1045220557;
        setRelativeEdges(i11, i11);
        int i12 = 1065353216;
        setRelativeVelocity(i12, i12);
        setActivationDelay(AutoScrollHelper.DEFAULT_ACTIVATION_DELAY);
        int i13 = 500;
        setRampUpDuration(i13);
        setRampDownDuration(i13);
    }

    private float computeTargetVelocity(int direction, float coordinate, float srcSize, float dstSize) {
        final float edgeValue = getEdgeValue(this.mRelativeEdges[direction], srcSize, this.mMaximumEdges[direction], coordinate);
        int i = 0;
        if (Float.compare(edgeValue, i) == 0) {
            return i;
        }
        float f4 = this.mMinimumVelocity[direction];
        float f5 = this.mMaximumVelocity[direction];
        final int i6 = f3 * dstSize;
        if (Float.compare(edgeValue, i) > 0) {
            return AutoScrollHelper.constrain(edgeValue * i6, f4, f5);
        }
        return -constrain2;
    }

    static float constrain(float value, float min, float max) {
        if (Float.compare(value, max) > 0) {
            return max;
        }
        if (Float.compare(value, min) < 0) {
            return min;
        }
        return value;
    }

    static int constrain(int value, int min, int max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    private float constrainEdgeValue(float current, float leading) {
        int mAnimating;
        int i2;
        int i;
        int i3 = 0;
        if (Float.compare(leading, i3) == 0) {
            return i3;
        }
        switch (mAnimating) {
            case 0:
                i2 = 1065353216;
                return i2 -= i4;
                return i2;
            case 1:
                return current / i5;
            default:
        }
        return i3;
    }

    private float getEdgeValue(float relativeValue, float size, float maxValue, float current) {
        int interpolation;
        int cmp;
        int i2 = 0;
        float constrain = AutoScrollHelper.constrain(relativeValue * size, i2, maxValue);
        final int i4 = constrainEdgeValue2 - constrainEdgeValue;
        if (Float.compare(i4, i2) < 0) {
            interpolation = -interpolation2;
            return AutoScrollHelper.constrain(interpolation, -1082130432, 1065353216);
        } else {
            if (Float.compare(i4, i2) > 0) {
                interpolation = this.mEdgeInterpolator.getInterpolation(i4);
            }
        }
        return i2;
    }

    private void requestStop() {
        int mScroller;
        if (this.mNeedsReset != null) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        Runnable scrollAnimationRunnable;
        boolean mActivationDelay;
        Object mRunnable;
        Runnable mRunnable2;
        long l;
        if (this.mRunnable == null) {
            scrollAnimationRunnable = new AutoScrollHelper.ScrollAnimationRunnable(this);
            this.mRunnable = scrollAnimationRunnable;
        }
        int i = 1;
        this.mAnimating = i;
        this.mNeedsReset = i;
        if (!this.mAlreadyDelayed && this.mActivationDelay > 0) {
            if (this.mActivationDelay > 0) {
                ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, (long)mActivationDelay2);
            } else {
                this.mRunnable.run();
            }
        } else {
        }
        this.mAlreadyDelayed = i;
    }

    @Override // android.view.View$OnTouchListener
    public abstract boolean canTargetScrollHorizontally(int i);

    @Override // android.view.View$OnTouchListener
    public abstract boolean canTargetScrollVertically(int i);

    @Override // android.view.View$OnTouchListener
    void cancelTargetTouch() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, obj1, uptimeMillis, obj3, 3, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    @Override // android.view.View$OnTouchListener
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // android.view.View$OnTouchListener
    public boolean isExclusive() {
        return this.mExclusive;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int i;
        float targetVelocity;
        boolean xTargetVelocity;
        float targetVelocity2;
        boolean mAnimating;
        float f;
        i = 0;
        if (!this.mEnabled) {
            return i;
        }
        final int i2 = 1;
        switch (actionMasked) {
            case 0:
                this.mNeedsCancel = i2;
                this.mAlreadyDelayed = i;
                this.mScroller.setTargetVelocity(computeTargetVelocity(i, event.getX(), (float)width, (float)width2), computeTargetVelocity(i2, event.getY(), (float)height, (float)height2));
                startAnimating();
                break;
            case 1:
                requestStop();
                break;
            default:
        }
        if (this.mExclusive && this.mAnimating) {
            if (this.mAnimating) {
                i = i2;
            }
        }
        return i;
    }

    @Override // android.view.View$OnTouchListener
    public abstract void scrollTargetBy(int i, int i2);

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setActivationDelay(int delayMillis) {
        this.mActivationDelay = delayMillis;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setEdgeType(int type) {
        this.mEdgeType = type;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setEnabled(boolean enabled) {
        if (this.mEnabled && !enabled) {
            if (!enabled) {
                requestStop();
            }
        }
        this.mEnabled = enabled;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setExclusive(boolean exclusive) {
        this.mExclusive = exclusive;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setMaximumEdges(float horizontalMax, float verticalMax) {
        this.mMaximumEdges[0] = horizontalMax;
        this.mMaximumEdges[1] = verticalMax;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setMaximumVelocity(float horizontalMax, float verticalMax) {
        int i = 1148846080;
        this.mMaximumVelocity[0] = horizontalMax / i;
        this.mMaximumVelocity[1] = verticalMax / i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setMinimumVelocity(float horizontalMin, float verticalMin) {
        int i = 1148846080;
        this.mMinimumVelocity[0] = horizontalMin / i;
        this.mMinimumVelocity[1] = verticalMin / i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setRampDownDuration(int durationMillis) {
        this.mScroller.setRampDownDuration(durationMillis);
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setRampUpDuration(int durationMillis) {
        this.mScroller.setRampUpDuration(durationMillis);
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setRelativeEdges(float horizontal, float vertical) {
        this.mRelativeEdges[0] = horizontal;
        this.mRelativeEdges[1] = vertical;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    public androidx.core.widget.AutoScrollHelper setRelativeVelocity(float horizontal, float vertical) {
        int i = 1148846080;
        this.mRelativeVelocity[0] = horizontal / i;
        this.mRelativeVelocity[1] = vertical / i;
        return this;
    }

    @Override // android.view.View$OnTouchListener
    boolean shouldAnimate() {
        int i;
        boolean targetScrollVertically;
        final androidx.core.widget.AutoScrollHelper.ClampedScroller mScroller = this.mScroller;
        final int verticalDirection = mScroller.getVerticalDirection();
        final int horizontalDirection = mScroller.getHorizontalDirection();
        if (verticalDirection != 0) {
            if (!canTargetScrollVertically(verticalDirection)) {
                if (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection)) {
                    i = canTargetScrollHorizontally(horizontalDirection) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
