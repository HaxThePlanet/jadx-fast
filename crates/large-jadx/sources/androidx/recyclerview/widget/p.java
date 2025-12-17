package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class p extends androidx.recyclerview.widget.RecyclerView.a0 {

    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final DecelerateInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel = false;
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;
    protected final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;
    protected PointF mTargetVector;
    public p(Context context) {
        super();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.mLinearInterpolator = linearInterpolator;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        this.mDecelerateInterpolator = decelerateInterpolator;
        int i = 0;
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private int clampApplyScroll(int i, int i2) {
        final int obj2 = i - i2;
        if (i *= obj2 <= 0) {
            return 0;
        }
        return obj2;
    }

    private float getSpeedPerPixel() {
        boolean mHasCalculatedMillisPerPixel;
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return this.mMillisPerPixel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        if (i5 != -1 && i5 != 0) {
            if (i5 != 0) {
                if (i5 != 1) {
                } else {
                    return i4 -= i2;
                }
                IllegalArgumentException obj2 = new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
                throw obj2;
            }
            i3 -= i;
            if (obj4 > 0) {
                return obj4;
            }
            i4 -= i2;
            if (obj5 < 0) {
                return obj5;
            }
            return 0;
        }
        return i3 -= i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    public int calculateDxToMakeVisible(View view, int i2) {
        boolean z;
        androidx.recyclerview.widget.RecyclerView.p layoutManager = getLayoutManager();
        if (layoutManager != null && !layoutManager.H()) {
            if (!layoutManager.H()) {
            }
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return this.calculateDtToFit(i3 - leftMargin, obj11 + rightMargin, layoutManager.v(), obj11 - i, i2);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    public int calculateDyToMakeVisible(View view, int i2) {
        boolean z;
        androidx.recyclerview.widget.RecyclerView.p layoutManager = getLayoutManager();
        if (layoutManager != null && !layoutManager.I()) {
            if (!layoutManager.I()) {
            }
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return this.calculateDtToFit(i3 - topMargin, obj11 + bottomMargin, layoutManager.u(), obj11 - i, i2);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return i /= obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected int calculateTimeForDeceleration(int i) {
        return (int)ceil;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected int calculateTimeForScrolling(int i) {
        return (int)ceil;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected int getHorizontalSnapPreference() {
        int i;
        PointF mTargetVector;
        int i2;
        int cmp;
        mTargetVector = this.mTargetVector;
        if (mTargetVector != null) {
            mTargetVector = mTargetVector.x;
            i2 = 0;
            if (Float.compare(mTargetVector, i2) == 0) {
                i = 0;
            } else {
                i = Float.compare(mTargetVector, i2) > 0 ? 1 : -1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected int getVerticalSnapPreference() {
        int i2;
        PointF mTargetVector;
        int i;
        int cmp;
        mTargetVector = this.mTargetVector;
        if (mTargetVector != null) {
            mTargetVector = mTargetVector.y;
            i = 0;
            if (Float.compare(mTargetVector, i) == 0) {
                i2 = 0;
            } else {
                i2 = Float.compare(mTargetVector, i) > 0 ? 1 : -1;
            }
        } else {
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onSeekTargetStep(int i, int i2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a4) {
        if (getChildCount() == 0) {
            stop();
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i);
        int obj1 = clampApplyScroll(this.mInterimTargetDy, i2);
        this.mInterimTargetDy = obj1;
        if (this.mInterimTargetDx == 0 && obj1 == null) {
            if (obj1 == null) {
                updateActionForInterimTarget(a4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onStart() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onStop() {
        int i = 0;
        this.mInterimTargetDy = i;
        this.mInterimTargetDx = i;
        this.mTargetVector = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void onTargetFound(View view, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a3) {
        int mDecelerateInterpolator;
        int obj3;
        int obj4;
        obj4 = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        obj3 = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        mDecelerateInterpolator = obj3 * obj3;
        int timeForDeceleration = calculateTimeForDeceleration((int)sqrt);
        if (timeForDeceleration > 0) {
            a3.d(-obj4, -obj3, timeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$a0
    protected void updateActionForInterimTarget(androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a) {
        int cmp;
        int i;
        PointF scrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        i = 0;
        if (scrollVectorForPosition != null && Float.compare(f3, i) == 0 && Float.compare(f6, i) == 0) {
            i = 0;
            if (Float.compare(f3, i) == 0) {
                if (Float.compare(f6, i) == 0) {
                }
            }
            normalize(scrollVectorForPosition);
            this.mTargetVector = scrollVectorForPosition;
            int i11 = 1176256512;
            this.mInterimTargetDx = (int)i7;
            this.mInterimTargetDy = (int)i2;
            int i12 = 1067030938;
            a.d((int)i9, (int)i13, (int)i5, this.mLinearInterpolator);
        }
        a.b(getTargetPosition());
        stop();
    }
}
