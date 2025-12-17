package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import d.a.j;
import d.h.l.e;
import d.h.l.u;

/* loaded from: classes.dex */
public class e0 extends ViewGroup {

    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public static class a extends ViewGroup.MarginLayoutParams {

        public float a;
        public int b = -1;
        public a(int i, int i2) {
            super(i, i2);
            int obj1 = -1;
            this.a = 0;
        }

        public a(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            final TypedArray obj3 = context.obtainStyledAttributes(attributeSet2, j.a1);
            this.a = obj3.getFloat(j.c1, 0);
            this.b = obj3.getInt(j.b1, -1);
            obj3.recycle();
        }

        public a(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            final int obj1 = -1;
        }
    }
    public e0(Context context) {
        super(context, 0);
    }

    public e0(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public e0(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        final int i = 1;
        this.mBaselineAligned = i;
        final int i2 = -1;
        this.mBaselineAlignedChildIndex = i2;
        final int i4 = 0;
        this.mBaselineChildTop = i4;
        this.mGravity = 8388659;
        final int[] q0 = j.Q0;
        androidx.appcompat.widget.t0 t0Var = t0.v(context, attributeSet2, q0, i3, i4);
        u.j0(this, context, q0, attributeSet2, t0Var.r(), i3, 0);
        int obj12 = t0Var.k(j.S0, i2);
        if (obj12 >= 0) {
            setOrientation(obj12);
        }
        obj12 = t0Var.k(j.R0, i2);
        if (obj12 >= 0) {
            setGravity(obj12);
        }
        obj12 = t0Var.a(j.T0, i);
        if (obj12 == null) {
            setBaselineAligned(obj12);
        }
        this.mWeightSum = t0Var.i(j.V0, -1082130432);
        this.mBaselineAlignedChildIndex = t0Var.k(j.U0, i2);
        this.mUseLargestChild = t0Var.a(j.Y0, i4);
        setDividerDrawable(t0Var.g(j.W0));
        this.mShowDividers = t0Var.k(j.Z0, i4);
        this.mDividerPadding = t0Var.f(j.X0, i4);
        t0Var.w();
    }

    private void forceUniformHeight(int i, int i2) {
        int i7;
        int visibility;
        View virtualChildAt;
        int i5;
        int i3;
        int i4;
        int i6;
        ViewGroup.LayoutParams view;
        int width;
        i7 = 0;
        while (i7 < i) {
            virtualChildAt = getVirtualChildAt(i7);
            view = layoutParams;
            if (virtualChildAt.getVisibility() != 8 && view.height == -1) {
            }
            i7++;
            view = layoutParams;
            if (view.height == -1) {
            }
            view.width = virtualChildAt.getMeasuredWidth();
            this.measureChildWithMargins(virtualChildAt, i2, 0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824), 0);
            view.width = view.width;
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int i4;
        int visibility;
        View virtualChildAt;
        int i3;
        int i5;
        int i7;
        int i6;
        ViewGroup.LayoutParams view;
        int height;
        i4 = 0;
        while (i4 < i) {
            virtualChildAt = getVirtualChildAt(i4);
            view = layoutParams;
            if (virtualChildAt.getVisibility() != 8 && view.width == -1) {
            }
            i4++;
            view = layoutParams;
            if (view.width == -1) {
            }
            view.height = virtualChildAt.getMeasuredHeight();
            this.measureChildWithMargins(virtualChildAt, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), 0, i2, 0);
            view.height = view.height;
        }
    }

    private void setChildFrame(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 += i2, i5 += i3);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return layoutParams instanceof e0.a;
    }

    @Override // android.view.ViewGroup
    void drawDividersHorizontal(Canvas canvas) {
        int i;
        int virtualChildCount;
        int mDividerWidth;
        int i2;
        boolean dividerBeforeChildAt2;
        View virtualChildAt;
        int dividerBeforeChildAt;
        int i3;
        virtualChildCount = getVirtualChildCount();
        mDividerWidth = z0.b(this);
        i2 = 0;
        while (i2 < virtualChildCount) {
            virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
            }
            i2++;
            if (virtualChildAt.getVisibility() != 8) {
            }
            if (hasDividerBeforeChildAt(i2)) {
            }
            ViewGroup.LayoutParams layoutParams = virtualChildAt.getLayoutParams();
            if (mDividerWidth) {
            } else {
            }
            i5 -= dividerBeforeChildAt;
            drawVerticalDivider(canvas, virtualChildAt);
            right2 += dividerBeforeChildAt;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount--);
            if (virtualChildAt2 == null) {
                if (mDividerWidth) {
                    virtualChildCount = getPaddingLeft();
                } else {
                    width -= paddingRight;
                    mDividerWidth = this.mDividerWidth;
                    i -= mDividerWidth;
                }
            } else {
                dividerBeforeChildAt2 = virtualChildAt2.getLayoutParams();
                if (mDividerWidth) {
                    left -= leftMargin;
                    mDividerWidth = this.mDividerWidth;
                } else {
                    right += mDividerWidth;
                }
            }
            drawVerticalDivider(canvas, virtualChildCount);
        }
    }

    @Override // android.view.ViewGroup
    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount;
        int i;
        boolean dividerBeforeChildAt2;
        View virtualChildAt;
        int dividerBeforeChildAt;
        int i2;
        virtualChildCount = getVirtualChildCount();
        i = 0;
        while (i < virtualChildCount) {
            virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
            }
            i++;
            if (virtualChildAt.getVisibility() != 8) {
            }
            if (hasDividerBeforeChildAt(i)) {
            }
            drawHorizontalDivider(canvas, i5 -= dividerBeforeChildAt);
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount--);
            if (virtualChildAt2 == null) {
                i4 -= dividerBeforeChildAt2;
            } else {
                bottom += dividerBeforeChildAt2;
            }
            drawHorizontalDivider(canvas, virtualChildCount);
        }
    }

    @Override // android.view.ViewGroup
    void drawHorizontalDivider(Canvas canvas, int i2) {
        this.mDivider.setBounds(paddingLeft += mDividerPadding, i2, i3 -= mDividerPadding2, mDividerHeight += i2);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.ViewGroup
    void drawVerticalDivider(Canvas canvas, int i2) {
        this.mDivider.setBounds(i2, paddingTop += mDividerPadding, mDividerWidth += i2, i4 -= mDividerPadding2);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected androidx.appcompat.widget.e0.a generateDefaultLayoutParams() {
        int mOrientation = this.mOrientation;
        final int i2 = -2;
        if (mOrientation == 0) {
            e0.a aVar = new e0.a(i2, i2);
            return aVar;
        }
        if (mOrientation == 1) {
            e0.a aVar2 = new e0.a(-1, i2);
            return aVar2;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.e0.a generateLayoutParams(AttributeSet attributeSet) {
        e0.a aVar = new e0.a(getContext(), attributeSet);
        return aVar;
    }

    @Override // android.view.ViewGroup
    protected androidx.appcompat.widget.e0.a generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        e0.a aVar = new e0.a(layoutParams);
        return aVar;
    }

    @Override // android.view.ViewGroup
    public int getBaseline() {
        int mBaselineChildTop;
        int mOrientation;
        int mTotalLength;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int mBaselineAlignedChildIndex3 = this.mBaselineAlignedChildIndex;
        if (getChildCount() <= mBaselineAlignedChildIndex3) {
        } else {
            View childAt = getChildAt(mBaselineAlignedChildIndex3);
            int baseline2 = childAt.getBaseline();
            int i = -1;
            if (baseline2 == i) {
                if (this.mBaselineAlignedChildIndex != 0) {
                } else {
                    return i;
                }
                RuntimeException runtimeException = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
                throw runtimeException;
            }
            mGravity &= 112;
            if (this.mOrientation == 1 && mOrientation != 48) {
                mGravity &= 112;
                if (mOrientation != 48) {
                    if (mOrientation != 16) {
                        if (mOrientation != 80) {
                        } else {
                            i5 -= mOrientation;
                        }
                    } else {
                        mBaselineChildTop += mOrientation;
                    }
                }
            }
            return i2 += baseline2;
        }
        RuntimeException runtimeException2 = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        throw runtimeException2;
    }

    @Override // android.view.ViewGroup
    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    @Override // android.view.ViewGroup
    int getChildrenSkipCount(View view, int i2) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    @Override // android.view.ViewGroup
    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @Override // android.view.ViewGroup
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.ViewGroup
    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.view.ViewGroup
    int getLocationOffset(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup
    int getNextLocationOffset(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // android.view.ViewGroup
    public int getShowDividers() {
        return this.mShowDividers;
    }

    @Override // android.view.ViewGroup
    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    @Override // android.view.ViewGroup
    int getVirtualChildCount() {
        return getChildCount();
    }

    @Override // android.view.ViewGroup
    public float getWeightSum() {
        return this.mWeightSum;
    }

    @Override // android.view.ViewGroup
    protected boolean hasDividerBeforeChildAt(int i) {
        int i3;
        int visibility;
        int i2;
        int obj5;
        i3 = 0;
        final int i4 = 1;
        if (i == 0 && obj5 &= i4 != 0) {
            if (obj5 &= i4 != 0) {
                i3 = i4;
            }
            return i3;
        }
        if (i == getChildCount() && obj5 &= 4 != 0) {
            if (obj5 &= 4 != 0) {
                i3 = i4;
            }
            return i3;
        }
        if (mShowDividers &= 2 != 0) {
            i -= i4;
            while (obj5 >= 0) {
                if (getChildAt(obj5).getVisibility() != 8) {
                    break;
                } else {
                }
                obj5--;
            }
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    @Override // android.view.ViewGroup
    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    @Override // android.view.ViewGroup
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int childrenSkipCount;
        int paddingLeft;
        int mTotalLength;
        int i5;
        int mTotalLength2;
        int height;
        int i18;
        int i8;
        int i14;
        int measuredHeight;
        int paddingTop;
        int virtualChildCount;
        int bottomMargin;
        boolean dividerBeforeChildAt;
        int i15;
        int i17;
        int i6;
        int i11;
        int i7;
        int i16;
        int i9;
        int i10;
        int i19;
        int i13;
        int i12;
        int obj25;
        final Object obj = this;
        int i21 = i4 - i2;
        int mGravity = obj.mGravity;
        i15 = mGravity & 112;
        int i24 = e.b(i27 &= mGravity, u.B(this));
        measuredHeight = 1;
        if (i24 != measuredHeight) {
            if (i24 != 5) {
                paddingLeft = getPaddingLeft();
            } else {
                i26 -= mTotalLength;
            }
        } else {
            paddingLeft3 += mTotalLength;
        }
        i5 = 0;
        if (z0.b(this)) {
            i11 = childrenSkipCount;
            i7 = -1;
        } else {
            i11 = i5;
            i7 = measuredHeight;
        }
        height = i5;
        while (height < virtualChildCount) {
            i5 = i11 + i20;
            childrenSkipCount = obj.getVirtualChildAt(i5);
            if (childrenSkipCount == null) {
            } else {
            }
            if (childrenSkipCount.getVisibility() != 8) {
            } else {
            }
            i16 = height;
            i13 = paddingTop;
            i9 = virtualChildCount;
            i10 = i15;
            i19 = 1;
            i12 = -1;
            height++;
            virtualChildCount = i9;
            i15 = i10;
            measuredHeight = i19;
            paddingTop = i13;
            i6 = 2;
            int measuredWidth = childrenSkipCount.getMeasuredWidth();
            measuredHeight = childrenSkipCount.getMeasuredHeight();
            ViewGroup.LayoutParams view4 = layoutParams;
            if (obj.mBaselineAligned) {
            } else {
            }
            i9 = virtualChildCount;
            bottomMargin = -1;
            if (view4.b < 0) {
            }
            i18 &= 112;
            i10 = i15;
            if (i31 != 16) {
            } else {
            }
            i17 = -1;
            i19 = 1;
            i36 -= bottomMargin;
            if (obj.hasDividerBeforeChildAt(i5)) {
            }
            leftMargin += paddingLeft;
            View view3 = childrenSkipCount;
            i13 = paddingTop;
            i12 = -1;
            this.setChildFrame(view3, i39 + locationOffset, i8, measuredWidth, measuredHeight);
            View view2 = obj25;
            height = i16 + childrenSkipCount;
            paddingLeft = virtualChildCount;
            paddingLeft += dividerBeforeChildAt;
            if (i31 != 48) {
            } else {
            }
            if (bottomMargin != -1) {
            } else {
            }
            i19 = 1;
            i8 += i13;
            if (i31 != 80) {
            } else {
            }
            if (bottomMargin != -1) {
            }
            i8 -= i13;
            i8 = paddingTop;
            i17 = -1;
            i18 = i15;
            i9 = virtualChildCount;
            if (view4.height != -1) {
            } else {
            }
            bottomMargin = childrenSkipCount.getBaseline();
            paddingLeft += childrenSkipCount;
            i19 = measuredHeight;
            i13 = paddingTop;
            i9 = virtualChildCount;
            i10 = i15;
        }
    }

    @Override // android.view.ViewGroup
    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int mTotalLength2;
        int i6;
        int i7;
        int i5;
        int i11;
        boolean dividerBeforeChildAt;
        int measureNullChild;
        int mTotalLength;
        int rightMargin;
        int i8;
        int measuredWidth;
        int i9;
        int i13;
        View virtualChildAt;
        ViewGroup.LayoutParams view;
        int i12;
        int i10;
        final Object obj = this;
        final int paddingLeft = getPaddingLeft();
        int i14 = i3 - i;
        int mGravity = obj.mGravity;
        mTotalLength2 = mGravity & 112;
        if (mTotalLength2 != 16) {
            if (mTotalLength2 != 80) {
                paddingTop = getPaddingTop();
            } else {
                i19 -= mTotalLength2;
            }
        } else {
            paddingTop3 += mTotalLength2;
        }
        i13 = i6;
        while (i13 < getVirtualChildCount()) {
            virtualChildAt = obj.getVirtualChildAt(i13);
            view = 1;
            if (virtualChildAt == null) {
            } else {
            }
            if (virtualChildAt.getVisibility() != 8) {
            } else {
            }
            i6 = view;
            i13 += i6;
            measuredWidth = virtualChildAt.getMeasuredWidth();
            int measuredHeight = virtualChildAt.getMeasuredHeight();
            ViewGroup.LayoutParams view4 = layoutParams;
            if (view4.b < 0) {
            }
            i22 &= 7;
            if (i23 != view) {
            } else {
            }
            i26 += leftMargin2;
            rightMargin = view4.rightMargin;
            i5 -= rightMargin;
            if (obj.hasDividerBeforeChildAt(i13)) {
            }
            int i32 = paddingTop + topMargin;
            this.setChildFrame(virtualChildAt, i11, i32 + locationOffset, measuredWidth, measuredHeight);
            i13 += childrenSkipCount;
            paddingTop = i10;
            i6 = 1;
            paddingTop += dividerBeforeChildAt;
            if (i23 != 5) {
            } else {
            }
            i5 = i28 - measuredWidth;
            rightMargin = view4.rightMargin;
            leftMargin += paddingLeft;
            i7 = i30;
            paddingTop += measureNullChild;
        }
    }

    @Override // android.view.ViewGroup
    void measureChildBeforeLayout(View view, int i2, int i3, int i4, int i5, int i6) {
        this.measureChildWithMargins(view, i3, i4, i5, i6);
    }

    @Override // android.view.ViewGroup
    void measureHorizontal(int i, int i2) {
        int[] mMaxDescent;
        int width2;
        int width;
        int mTotalLength4;
        int measuredWidth2;
        int i22;
        int i35;
        int resolveSizeAndState;
        int i21;
        int i13;
        int i34;
        int height;
        int i12;
        int i19;
        int mDividerWidth2;
        int i26;
        int i38;
        int i6;
        int i9;
        int i16;
        int i10;
        int measureSpec;
        int i29;
        int i41;
        int virtualChildAt2;
        int i42;
        int i24;
        boolean mUseLargestChild;
        int dividerBeforeChildAt2;
        int nextLocationOffset2;
        int i39;
        int mTotalLength2;
        int i5;
        int i3;
        boolean nextLocationOffset3;
        int visibility;
        int i8;
        int childrenSkipCount;
        boolean dividerBeforeChildAt;
        int i43;
        int rightMargin;
        int measuredState;
        int height2;
        int measureNullChild;
        int layoutParams;
        int mGravity;
        int[] mMaxDescent2;
        int measureNullChild2;
        int mGravity2;
        int mTotalLength;
        int i40;
        int measureSpec2;
        int mTotalLength3;
        int i15;
        int i28;
        int i32;
        int i30;
        int combineMeasuredStates2;
        int mDividerWidth;
        int i47;
        int i20;
        int virtualChildCount;
        int i14;
        int nextLocationOffset;
        int virtualChildAt;
        int i31;
        int i36;
        int i23;
        int i11;
        int i46;
        int cmp;
        int i37;
        int combineMeasuredStates;
        int i33;
        int i48;
        int i44;
        int[] iArr;
        View measuredWidth;
        int i25;
        int i45;
        int i7;
        boolean z;
        int i27;
        int i4;
        int i17;
        boolean z2;
        int i18;
        final Object obj2 = this;
        i30 = i2;
        mDividerWidth = 0;
        obj2.mTotalLength = mDividerWidth;
        virtualChildCount = getVirtualChildCount();
        final int mode = View.MeasureSpec.getMode(i);
        final int mode2 = View.MeasureSpec.getMode(i2);
        int i135 = 4;
        if (obj2.mMaxAscent != null) {
            if (obj2.mMaxDescent == null) {
                obj2.mMaxAscent = new int[i135];
                obj2.mMaxDescent = new int[i135];
            }
        } else {
        }
        final int[] mMaxAscent = obj2.mMaxAscent;
        mMaxDescent2 = obj2.mMaxDescent;
        final int i136 = 3;
        i8 = -1;
        mMaxAscent[i136] = i8;
        final int i137 = 2;
        mMaxAscent[i137] = i8;
        final int i138 = 1;
        mMaxAscent[i138] = i8;
        mMaxAscent[mDividerWidth] = i8;
        mMaxDescent2[i136] = i8;
        mMaxDescent2[i137] = i8;
        mMaxDescent2[i138] = i8;
        mMaxDescent2[mDividerWidth] = i8;
        nextLocationOffset3 = obj2.mBaselineAligned;
        mUseLargestChild = obj2.mUseLargestChild;
        i31 = mode == 1073741824 ? i138 : mDividerWidth;
        final int i139 = 0;
        i44 = combineMeasuredStates;
        i48 = i138;
        width2 = i139;
        iArr = mMaxDescent2;
        while (i12 < virtualChildCount) {
            measureNullChild2 = obj2.getVirtualChildAt(i12);
            if (measureNullChild2 == null) {
            } else {
            }
            if (measureNullChild2.getVisibility() == 8) {
            } else {
            }
            if (obj2.hasDividerBeforeChildAt(i12)) {
            }
            ViewGroup.LayoutParams view2 = layoutParams3;
            float f3 = view2.a;
            i7 = width2 + f3;
            if (mode == i9 && view2.width == 0 && Float.compare(f3, i139) > 0) {
            } else {
            }
            if (view2.width == 0 && Float.compare(f3, i139) > 0) {
            } else {
            }
            i43 = -2;
            i10 = Integer.MIN_VALUE;
            if (Float.compare(i7, i139) == 0) {
            } else {
            }
            i25 = 0;
            z2 = nextLocationOffset3;
            int i121 = -1;
            i45 = i144;
            measuredWidth = measureNullChild2;
            this.measureChildBeforeLayout(measureNullChild2, i12, i, i25, i2, 0);
            int i49 = i17;
            if (i49 != Integer.MIN_VALUE) {
            }
            measuredWidth2 = measuredWidth.getMeasuredWidth();
            if (i31 != 0) {
            } else {
            }
            int mTotalLength8 = obj2.mTotalLength;
            obj2.mTotalLength = Math.max(mTotalLength8, i69 += nextLocationOffset3);
            if (mUseLargestChild) {
            }
            i19 = 1073741824;
            if (mode2 != i19 && view2.height == -1) {
            } else {
            }
            i22 = 0;
            measuredHeight += i29;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, mUseLargestChild.getMeasuredState());
            measuredState = mUseLargestChild.getBaseline();
            if (z2 && measuredState != -1 && view2.b < 0) {
            }
            i36 = Math.max(i36, nextLocationOffset3);
            if (i48 != 0 && view2.height == -1) {
            } else {
            }
            i48 = 0;
            if (Float.compare(f4, i139) > 0) {
            } else {
            }
            if (i22 != 0) {
            } else {
            }
            i29 = nextLocationOffset3;
            i23 = Math.max(i23, i29);
            i11 = i47;
            mDividerWidth = i4;
            i16 = i50;
            width2 = i7;
            i30 = i2;
            mMaxDescent2 = iArr;
            mUseLargestChild = z;
            nextLocationOffset3 = z2;
            i8 = -1;
            mDividerWidth = 0;
            i9 = i19;
            i12 = i18;
            iArr = mMaxDescent2;
            if (i22 != 0) {
            } else {
            }
            i29 = nextLocationOffset3;
            i11 = Math.max(i11, i29);
            if (view2.height == -1) {
            } else {
            }
            i48 = i138;
            measuredState = mUseLargestChild.getBaseline();
            if (measuredState != -1) {
            }
            if (view2.b < 0) {
            }
            i110 >>= 1;
            mMaxAscent[measureNullChild2] = Math.max(mMaxAscent[measureNullChild2], measuredState);
            iArr[measureNullChild2] = Math.max(iArr[measureNullChild2], nextLocationOffset3 - measuredState);
            mGravity2 = obj2.mGravity;
            if (view2.height == -1) {
            } else {
            }
            i44 = i22;
            virtualChildAt = Math.max(measuredWidth2, virtualChildAt);
            obj2.mTotalLength = mTotalLength9 += measureSpec;
            view2.width = i49;
            i25 = mTotalLength4;
            if (Float.compare(f3, i139) > 0) {
            } else {
            }
            view2.width = -2;
            i10 = 0;
            if (view2.width == 0) {
            } else {
            }
            if (Float.compare(f3, i139) > 0) {
            } else {
            }
            if (i31 != 0) {
            } else {
            }
            int mTotalLength5 = obj2.mTotalLength;
            obj2.mTotalLength = Math.max(mTotalLength5, i72 += rightMargin);
            if (nextLocationOffset3) {
            } else {
            }
            i4 = i12;
            z = mUseLargestChild;
            z2 = nextLocationOffset3;
            mUseLargestChild = measureNullChild2;
            i37 = i138;
            i19 = 1073741824;
            i45 = -2;
            measuredWidth2 = 0;
            measureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth2, measuredWidth2);
            measureNullChild2.measure(measureSpec, measureSpec);
            i4 = i12;
            z = mUseLargestChild;
            z2 = nextLocationOffset3;
            mUseLargestChild = measureNullChild2;
            i45 = -2;
            obj2.mTotalLength = mTotalLength6 += rightMargin;
            obj2.mTotalLength = mTotalLength13 += mDividerWidth;
            i12 += childrenSkipCount;
            z = mUseLargestChild;
            z2 = nextLocationOffset3;
            i16 = i12;
            i19 = i18;
            obj2.mTotalLength = mTotalLength14 += measureNullChild2;
        }
        mDividerWidth2 = i9;
        boolean z3 = mUseLargestChild;
        i41 = i36;
        visibility = i23;
        mTotalLength = combineMeasuredStates;
        combineMeasuredStates2 = Integer.MIN_VALUE;
        int i145 = -2;
        if (obj2.mTotalLength > 0 && obj2.hasDividerBeforeChildAt(virtualChildCount)) {
            if (obj2.hasDividerBeforeChildAt(virtualChildCount)) {
                obj2.mTotalLength = mTotalLength12 += mDividerWidth2;
            }
        }
        nextLocationOffset2 = -1;
        if (mMaxAscent[i138] == nextLocationOffset2 && mMaxAscent[0] == nextLocationOffset2 && mMaxAscent[i137] == nextLocationOffset2) {
            if (mMaxAscent[0] == nextLocationOffset2) {
                if (mMaxAscent[i137] == nextLocationOffset2) {
                    if (mMaxAscent[i136] != nextLocationOffset2) {
                        i46 = mTotalLength;
                        i26 = Math.max(i41, i63 += nextLocationOffset2);
                    } else {
                        i26 = i41;
                        i46 = mTotalLength;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (z3) {
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    obj2.mTotalLength = 0;
                    i41 = 0;
                    while (i41 < virtualChildCount) {
                        nextLocationOffset2 = obj2.getVirtualChildAt(i41);
                        if (nextLocationOffset2 == null) {
                        } else {
                        }
                        if (nextLocationOffset2.getVisibility() == 8) {
                        } else {
                        }
                        measureNullChild = nextLocationOffset2.getLayoutParams();
                        if (i31 != 0) {
                        } else {
                        }
                        mTotalLength = obj2.mTotalLength;
                        i23 = i26;
                        obj2.mTotalLength = Math.max(mTotalLength, i127 += nextLocationOffset5);
                        i41++;
                        i26 = i23;
                        obj2.mTotalLength = mTotalLength15 += combineMeasuredStates2;
                        i23 = i26;
                        i41 += nextLocationOffset2;
                        obj2.mTotalLength = mTotalLength11 += measureNullChild;
                    }
                }
            } else {
            }
        }
        mTotalLength10 += i73;
        obj2.mTotalLength = i60;
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(i60, getSuggestedMinimumWidth()), i, 0);
        if (i37 == 0) {
            if (i76 -= mTotalLength2 != 0 && Float.compare(width2, i139) > 0) {
                if (Float.compare(width2, i139) > 0) {
                    float mWeightSum = obj2.mWeightSum;
                    if (Float.compare(mWeightSum, i139) > 0) {
                        width2 = mWeightSum;
                    }
                    layoutParams = -1;
                    mMaxAscent[i136] = layoutParams;
                    mMaxAscent[i137] = layoutParams;
                    mMaxAscent[i138] = layoutParams;
                    int i111 = 0;
                    mMaxAscent[i111] = layoutParams;
                    iArr[i136] = layoutParams;
                    iArr[i137] = layoutParams;
                    iArr[i138] = layoutParams;
                    iArr[i111] = layoutParams;
                    obj2.mTotalLength = i111;
                    mTotalLength = visibility;
                    visibility = layoutParams;
                    combineMeasuredStates2 = i46;
                    i20 = 0;
                    while (i20 < virtualChildCount) {
                        virtualChildAt = obj2.getVirtualChildAt(i20);
                        if (virtualChildAt != null) {
                        } else {
                        }
                        mTotalLength2 = virtualChildAt2;
                        combineMeasuredStates = virtualChildCount;
                        i24 = i2;
                        i20++;
                        measureSpec2 = i;
                        virtualChildAt2 = mTotalLength2;
                        virtualChildCount = combineMeasuredStates;
                        layoutParams = -1;
                        if (virtualChildAt.getVisibility() == 8) {
                        } else {
                        }
                        layoutParams = virtualChildAt.getLayoutParams();
                        float f = layoutParams.a;
                        if (Float.compare(f, i139) > 0) {
                        } else {
                        }
                        mTotalLength2 = virtualChildAt2;
                        combineMeasuredStates = virtualChildCount;
                        i14 = -1;
                        i24 = i2;
                        if (i31 != 0) {
                        } else {
                        }
                        mTotalLength3 = obj2.mTotalLength;
                        i46 = width2;
                        obj2.mTotalLength = Math.max(mTotalLength3, i134 += nextLocationOffset4);
                        if (mode2 != 1073741824 && layoutParams.height == -1) {
                        } else {
                        }
                        i34 = 0;
                        measuredHeight3 += i15;
                        visibility = Math.max(visibility, virtualChildCount);
                        if (i34 != 0) {
                        } else {
                        }
                        i15 = virtualChildCount;
                        if (i48 != 0) {
                        } else {
                        }
                        measureSpec2 = -1;
                        i40 = 0;
                        virtualChildAt = virtualChildAt.getBaseline();
                        if (nextLocationOffset3 && virtualChildAt != measureSpec2 && layoutParams.b < 0) {
                        }
                        i48 = i40;
                        mTotalLength = i57;
                        width2 = i46;
                        virtualChildAt = virtualChildAt.getBaseline();
                        if (virtualChildAt != measureSpec2) {
                        }
                        if (layoutParams.b < 0) {
                        }
                        i103 >>= 1;
                        mMaxAscent[layoutParams] = Math.max(mMaxAscent[layoutParams], virtualChildAt);
                        iArr[layoutParams] = Math.max(iArr[layoutParams], virtualChildCount -= virtualChildAt);
                        mGravity = obj2.mGravity;
                        if (layoutParams.height == -1) {
                        } else {
                        }
                        i40 = i138;
                        if (layoutParams.height == -1) {
                        } else {
                        }
                        i34 = i138;
                        obj2.mTotalLength = mTotalLength16 += i143;
                        i46 = width2;
                        i28 = (int)i120;
                        combineMeasuredStates = virtualChildCount;
                        i14 = -1;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i89 += bottomMargin, layoutParams.height);
                        if (layoutParams.width == 0) {
                        } else {
                        }
                        i3 = 1073741824;
                        if (i28 += measuredWidth < 0) {
                        }
                        virtualChildAt.measure(View.MeasureSpec.makeMeasureSpec(i32, i3), childMeasureSpec);
                        combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates2, measuredState2 &= i91);
                        width2 = cmp;
                        mTotalLength2 = i37;
                        i32 = 0;
                        i3 = 1073741824;
                        if (mode != i3) {
                        } else {
                        }
                        if (i28 > 0) {
                        } else {
                        }
                        i28 = 0;
                        virtualChildAt.measure(View.MeasureSpec.makeMeasureSpec(i28, i3), childMeasureSpec);
                    }
                    i42 = i2;
                    i33 = virtualChildCount;
                    obj2.mTotalLength = mTotalLength7 += i84;
                    i5 = -1;
                    if (mMaxAscent[i138] == i5 && mMaxAscent[0] == i5 && mMaxAscent[i137] == i5) {
                        if (mMaxAscent[0] == i5) {
                            if (mMaxAscent[i137] == i5) {
                                if (mMaxAscent[i136] != i5) {
                                    int i85 = 0;
                                    i21 = Math.max(visibility, i55 += i5);
                                } else {
                                    i21 = visibility;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    i39 = i21;
                    i35 = mTotalLength;
                    i46 = combineMeasuredStates2;
                } else {
                    i35 = Math.max(visibility, i11);
                    if (z3 && mode != 1073741824) {
                        if (mode != 1073741824) {
                            i20 = 0;
                            while (i20 < virtualChildCount) {
                                virtualChildAt2 = obj2.getVirtualChildAt(i20);
                                if (virtualChildAt2 != 0) {
                                }
                                i20++;
                                if (virtualChildAt2.getVisibility() == 8) {
                                } else {
                                }
                                if (Float.compare(f2, i139) > 0) {
                                }
                                visibility = 1073741824;
                                virtualChildAt2.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt, visibility), View.MeasureSpec.makeMeasureSpec(virtualChildAt2.getMeasuredHeight(), visibility));
                            }
                        }
                    }
                    i42 = i2;
                    i33 = virtualChildCount;
                    i39 = i140;
                }
            } else {
            }
        } else {
        }
        if (i48 == 0 && mode2 != 1073741824) {
            if (mode2 != 1073741824) {
            } else {
                i35 = i39;
            }
        } else {
        }
        obj2.setMeasuredDimension(resolveSizeAndState2 |= i82, View.resolveSizeAndState(Math.max(i35 += i80, getSuggestedMinimumHeight()), i42, i46 << 16));
        if (i44 != 0) {
            obj2.forceUniformHeight(i33, i);
        }
    }

    @Override // android.view.ViewGroup
    int measureNullChild(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    void measureVertical(int i, int i2) {
        int i36;
        int i13;
        int width2;
        int i37;
        int height;
        int height2;
        int mTotalLength;
        int i10;
        int i3;
        int combineMeasuredStates;
        int i18;
        int i22;
        boolean dividerBeforeChildAt2;
        int mTotalLength4;
        int i28;
        int i19;
        int width;
        int i39;
        int i34;
        int i35;
        int bottomMargin;
        int i30;
        int dividerBeforeChildAt;
        int virtualChildAt2;
        View view2;
        int mDividerHeight;
        int nextLocationOffset;
        int i9;
        int i21;
        int childrenSkipCount;
        int cmp;
        int i38;
        int paddingBottom;
        int width3;
        int i31;
        int measureSpec;
        int i4;
        int measureNullChild;
        int mTotalLength3;
        int i6;
        int i7;
        int virtualChildCount;
        int mTotalLength2;
        int i8;
        int i40;
        int i20;
        int mode;
        int virtualChildAt;
        int mBaselineAlignedChildIndex;
        boolean mUseLargestChild;
        int i26;
        int i5;
        int i33;
        int cmp2;
        int i23;
        int i15;
        int i14;
        View view;
        int measuredHeight;
        int i29;
        int i27;
        int i16;
        int i17;
        int i25;
        int i11;
        int i32;
        int i24;
        int i12;
        final Object obj2 = this;
        cmp = i;
        i31 = i2;
        measureNullChild = 0;
        obj2.mTotalLength = measureNullChild;
        virtualChildCount = getVirtualChildCount();
        final int mode2 = View.MeasureSpec.getMode(i);
        mode = View.MeasureSpec.getMode(i2);
        mBaselineAlignedChildIndex = obj2.mBaselineAlignedChildIndex;
        mUseLargestChild = obj2.mUseLargestChild;
        final int i86 = 0;
        final int i87 = 1;
        i15 = i33;
        i36 = i86;
        i23 = i87;
        view = mDividerHeight;
        while (childrenSkipCount < virtualChildCount) {
            nextLocationOffset = obj2.getVirtualChildAt(childrenSkipCount);
            int i91 = i3;
            if (obj2.hasDividerBeforeChildAt(childrenSkipCount)) {
            }
            measureNullChild = layoutParams;
            float f = measureNullChild.a;
            i27 = i36 + f;
            if (mode == 1073741824 && measureNullChild.height == 0 && Float.compare(f, i86) > 0) {
            } else {
            }
            if (measureNullChild.height == 0 && Float.compare(f, i86) > 0) {
            } else {
            }
            i35 = Integer.MIN_VALUE;
            if (Float.compare(i27, i86) == 0) {
            } else {
            }
            measuredHeight = 0;
            width3 = i91;
            i11 = i93;
            i31 = dividerBeforeChildAt;
            i16 = virtualChildCount;
            i29 = mode;
            mode = view;
            int i79 = i25;
            view = nextLocationOffset;
            i24 = i9;
            virtualChildCount = childrenSkipCount;
            this.measureChildBeforeLayout(nextLocationOffset, childrenSkipCount, i, 0, i2, measuredHeight);
            int i47 = i32;
            if (i47 != Integer.MIN_VALUE) {
            }
            int measuredHeight2 = view.getMeasuredHeight();
            int mTotalLength7 = obj2.mTotalLength;
            obj2.mTotalLength = Math.max(mTotalLength7, i56 += nextLocationOffset);
            if (mUseLargestChild) {
            } else {
            }
            i10 = i31;
            if (mBaselineAlignedChildIndex >= 0 && mBaselineAlignedChildIndex == virtualChildCount + 1) {
            }
            if (mode2 != 1073741824 && measureNullChild.width == -1) {
            } else {
            }
            i28 = 0;
            measuredWidth += i30;
            if (i23 != 0 && measureNullChild.width == -1) {
            } else {
            }
            i23 = 0;
            if (Float.compare(f3, i86) > 0) {
            } else {
            }
            if (i28 != 0) {
            } else {
            }
            i30 = i64;
            i19 = Math.max(i24, i30);
            mDividerHeight = mode;
            dividerBeforeChildAt = i10;
            i36 = i27;
            i9 = i19;
            i3 = combineMeasuredStates2;
            childrenSkipCount = i57;
            i39 = i12;
            childrenSkipCount++;
            cmp = i;
            i31 = i2;
            mode = i29;
            virtualChildCount = i16;
            view = mDividerHeight;
            if (i28 != 0) {
            } else {
            }
            i30 = i64;
            mDividerHeight = Math.max(mode, i30);
            i19 = i24;
            if (measureNullChild.width == -1) {
            } else {
            }
            i23 = i87;
            if (measureNullChild.width == -1) {
            } else {
            }
            i15 = i28;
            if (mBaselineAlignedChildIndex == virtualChildCount + 1) {
            }
            obj2.mBaselineChildTop = obj2.mTotalLength;
            i10 = Math.max(measuredHeight2, i31);
            measureNullChild.height = i47;
            measuredHeight = mTotalLength;
            if (Float.compare(f, i86) > 0) {
            } else {
            }
            measureNullChild.height = -2;
            i35 = 0;
            if (measureNullChild.height == 0) {
            } else {
            }
            if (Float.compare(f, i86) > 0) {
            } else {
            }
            int mTotalLength6 = obj2.mTotalLength;
            obj2.mTotalLength = Math.max(mTotalLength6, i52 += bottomMargin);
            i10 = dividerBeforeChildAt;
            view2 = nextLocationOffset;
            i24 = i9;
            i33 = i87;
            width3 = i91;
            i11 = i94;
            i16 = virtualChildCount;
            i29 = mode;
            mode = view;
            virtualChildCount = childrenSkipCount;
            obj2.mTotalLength = mTotalLength8 += measureNullChild;
            childrenSkipCount += childrenSkipCount2;
            i16 = virtualChildCount;
            mDividerHeight = view;
            i3 = i91;
            i29 = mode;
            obj2.mTotalLength = mTotalLength12 += measureNullChild;
            i16 = virtualChildCount;
            i29 = mode;
            mDividerHeight = view;
        }
        paddingBottom = i3;
        int i71 = dividerBeforeChildAt;
        i22 = i9;
        int i92 = virtualChildCount;
        i21 = i39;
        if (obj2.mTotalLength > 0) {
            if (obj2.hasDividerBeforeChildAt(i92)) {
                obj2.mTotalLength = mTotalLength10 += mDividerHeight;
            }
        } else {
            i34 = i92;
        }
        virtualChildAt2 = i90;
        if (mUseLargestChild) {
            if (virtualChildAt2 != Integer.MIN_VALUE) {
                if (virtualChildAt2 == 0) {
                    obj2.mTotalLength = 0;
                    mDividerHeight = 0;
                    while (mDividerHeight < i34) {
                        View virtualChildAt3 = obj2.getVirtualChildAt(mDividerHeight);
                        if (virtualChildAt3 == null) {
                        } else {
                        }
                        if (virtualChildAt3.getVisibility() == measureNullChild) {
                        } else {
                        }
                        virtualChildCount = virtualChildAt3.getLayoutParams();
                        mBaselineAlignedChildIndex = obj2.mTotalLength;
                        obj2.mTotalLength = Math.max(mBaselineAlignedChildIndex, nextLocationOffset3 += i14);
                        mDividerHeight++;
                        measureNullChild = 8;
                        mDividerHeight += childrenSkipCount;
                        obj2.mTotalLength = mTotalLength13 += virtualChildCount;
                    }
                }
            } else {
            }
        }
        mTotalLength11 += i69;
        obj2.mTotalLength = i61;
        int i70 = i2;
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(i61, getSuggestedMinimumHeight()), i70, 0);
        i74 -= mTotalLength2;
        if (i33 == 0) {
            if (measureSpec != 0 && Float.compare(i36, i86) > 0) {
                if (Float.compare(i36, i86) > 0) {
                    float mWeightSum = obj2.mWeightSum;
                    if (Float.compare(mWeightSum, i86) > 0) {
                        i36 = mWeightSum;
                    }
                    mTotalLength3 = 0;
                    obj2.mTotalLength = mTotalLength3;
                    i8 = measureSpec;
                    measureSpec = i22;
                    combineMeasuredStates = paddingBottom;
                    i38 = mTotalLength3;
                    while (i38 < i34) {
                        virtualChildAt = obj2.getVirtualChildAt(i38);
                        if (virtualChildAt.getVisibility() == 8) {
                        } else {
                        }
                        mBaselineAlignedChildIndex = virtualChildAt.getLayoutParams();
                        float f5 = mBaselineAlignedChildIndex.a;
                        if (Float.compare(f5, i86) > 0) {
                        } else {
                        }
                        i40 = i;
                        i14 = i6;
                        measuredWidth3 += i7;
                        i21 = Math.max(i21, i80);
                        if (mode2 != 1073741824) {
                        } else {
                        }
                        measuredHeight = combineMeasuredStates;
                        i18 = -1;
                        i13 = 0;
                        if (i13 != 0) {
                        } else {
                        }
                        i7 = i80;
                        if (i23 != 0 && mBaselineAlignedChildIndex.width == i18) {
                        } else {
                        }
                        i4 = 0;
                        mTotalLength3 = obj2.mTotalLength;
                        obj2.mTotalLength = Math.max(mTotalLength3, i83 += nextLocationOffset2);
                        i23 = i4;
                        combineMeasuredStates = measuredHeight;
                        measureSpec = i41;
                        i36 = i33;
                        i38++;
                        i8 = i14;
                        mTotalLength3 = 0;
                        if (mBaselineAlignedChildIndex.width == i18) {
                        } else {
                        }
                        i4 = i87;
                        measuredHeight = combineMeasuredStates;
                        if (mBaselineAlignedChildIndex.width == -1) {
                        } else {
                        }
                        i13 = i87;
                        i26 = (int)i85;
                        i14 = i78;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i76 += rightMargin, mBaselineAlignedChildIndex.width);
                        if (mBaselineAlignedChildIndex.height == 0) {
                        } else {
                        }
                        i6 = 1073741824;
                        if (i26 += measuredHeight < 0) {
                        }
                        virtualChildAt.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i5, i6));
                        combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, measuredState &= -256);
                        i36 = cmp2;
                        i5 = 0;
                        i6 = 1073741824;
                        if (virtualChildAt2 != i6) {
                        } else {
                        }
                        if (i26 > 0) {
                        } else {
                        }
                        i26 = 0;
                        virtualChildAt.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i26, i6));
                        i14 = i8;
                        i40 = i;
                    }
                    i20 = i;
                    obj2.mTotalLength = mTotalLength5 += virtualChildAt2;
                    i37 = measureSpec;
                } else {
                    i37 = Math.max(i22, view);
                    if (mUseLargestChild && virtualChildAt2 != 1073741824) {
                        if (virtualChildAt2 != 1073741824) {
                            i22 = 0;
                            while (i22 < i34) {
                                virtualChildAt2 = obj2.getVirtualChildAt(i22);
                                if (virtualChildAt2 != 0) {
                                }
                                i22++;
                                if (virtualChildAt2.getVisibility() == 8) {
                                } else {
                                }
                                if (Float.compare(f4, i86) > 0) {
                                }
                                mTotalLength2 = 1073741824;
                                virtualChildAt2.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt2.getMeasuredWidth(), mTotalLength2), View.MeasureSpec.makeMeasureSpec(i71, mTotalLength2));
                            }
                        }
                    }
                    i20 = i;
                    combineMeasuredStates = paddingBottom;
                }
            } else {
            }
        } else {
        }
        if (i23 == 0 && mode2 != 1073741824) {
            if (mode2 != 1073741824) {
            } else {
                i37 = i21;
            }
        } else {
        }
        obj2.setMeasuredDimension(View.resolveSizeAndState(Math.max(i37 += i58, getSuggestedMinimumWidth()), i20, combineMeasuredStates), resolveSizeAndState2);
        if (i15 != 0) {
            obj2.forceUniformWidth(i34, i70);
        }
    }

    @Override // android.view.ViewGroup
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mOrientation == 1) {
            layoutVertical(i2, i3, i4, i5);
        } else {
            layoutHorizontal(i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    @Override // android.view.ViewGroup
    public void setBaselineAlignedChildIndex(int i) {
        int childCount;
        if (i < 0) {
        } else {
            if (i >= getChildCount()) {
            } else {
                this.mBaselineAlignedChildIndex = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("base aligned child index out of range (0, ");
        stringBuilder.append(getChildCount());
        stringBuilder.append(")");
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    @Override // android.view.ViewGroup
    public void setDividerDrawable(Drawable drawable) {
        int i;
        int intrinsicHeight;
        if (drawable == this.mDivider) {
        }
        this.mDivider = drawable;
        i = 0;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = i;
            this.mDividerHeight = i;
        }
        if (drawable == null) {
            i = 1;
        }
        setWillNotDraw(i);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    @Override // android.view.ViewGroup
    public void setGravity(int i) {
        int i2;
        int mGravity;
        int obj2;
        if (this.mGravity != i && i3 &= i == 0) {
            if (i3 &= i == 0) {
                i |= i2;
            }
            if (obj2 & 112 == 0) {
                obj2 |= 48;
            }
            this.mGravity = obj2;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setHorizontalGravity(int i) {
        int i2;
        int obj3;
        int i3 = 8388615;
        i &= i3;
        final int mGravity = this.mGravity;
        if (i3 &= mGravity != obj3) {
            this.mGravity = obj3 |= i2;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.ViewGroup
    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    @Override // android.view.ViewGroup
    public void setVerticalGravity(int i) {
        int mGravity;
        int obj3;
        i &= 112;
        mGravity = this.mGravity;
        if (mGravity & 112 != obj3) {
            this.mGravity = obj3 |= mGravity;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}
