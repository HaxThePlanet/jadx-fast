package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.firebase.inappmessaging.display.R.styleable;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseModalLayout extends FrameLayout {

    private static final float DEFAULT_MAX_HEIGHT_PCT = -1f;
    private static final float DEFAULT_MAX_WIDTH_PCT = -1f;
    private DisplayMetrics mDisplay;
    private float mMaxHeightPct;
    private float mMaxWidthPct;
    private List<View> mVisibleChildren;
    public BaseModalLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        ArrayList arrayList = new ArrayList();
        this.mVisibleChildren = arrayList;
        final int i2 = 0;
        final TypedArray obj5 = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.ModalLayout, i2, i2);
        int i = -1082130432;
        this.mMaxWidthPct = obj5.getFloat(R.styleable.ModalLayout_maxWidthPct, i);
        this.mMaxHeightPct = obj5.getFloat(R.styleable.ModalLayout_maxHeightPct, i);
        obj5.recycle();
        this.mDisplay = context.getResources().getDisplayMetrics();
    }

    @Override // android.widget.FrameLayout
    protected int calculateBaseHeight(int i) {
        int str;
        int obj3;
        if (Float.compare(maxHeightPct, i2) > 0) {
            Logging.logd("Height: restrict by pct");
            obj3 = roundToNearest((int)obj3, 4);
        } else {
            Logging.logd("Height: restrict by spec");
            obj3 = View.MeasureSpec.getSize(i);
        }
        return obj3;
    }

    @Override // android.widget.FrameLayout
    protected int calculateBaseWidth(int i) {
        int str;
        int obj3;
        if (Float.compare(maxWidthPct, i2) > 0) {
            Logging.logd("Width: restrict by pct");
            obj3 = roundToNearest((int)obj3, 4);
        } else {
            Logging.logd("Width: restrict by spec");
            obj3 = View.MeasureSpec.getSize(i);
        }
        return obj3;
    }

    @Override // android.widget.FrameLayout
    protected int dpToPixels(int i) {
        final int i2 = 1;
        return (int)floor;
    }

    @Override // android.widget.FrameLayout
    protected View findChildById(int i) {
        View viewById = findViewById(i);
        if (viewById == null) {
        } else {
            return viewById;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No such child: ");
        stringBuilder.append(i);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.widget.FrameLayout
    protected int getDesiredHeight(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    @Override // android.widget.FrameLayout
    protected int getDesiredWidth(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    @Override // android.widget.FrameLayout
    protected DisplayMetrics getDisplayMetrics() {
        return this.mDisplay;
    }

    @Override // android.widget.FrameLayout
    protected int getHeightWithMargins(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
        return obj3 += bottomMargin;
    }

    @Override // android.widget.FrameLayout
    protected FrameLayout.LayoutParams getLayoutParams(View view) {
        return (FrameLayout.LayoutParams)view.getLayoutParams();
    }

    @Override // android.widget.FrameLayout
    protected int getMarginBottom(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return obj3.bottomMargin;
    }

    @Override // android.widget.FrameLayout
    protected int getMarginTop(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return obj3.topMargin;
    }

    @Override // android.widget.FrameLayout
    protected float getMaxHeightPct() {
        return this.mMaxHeightPct;
    }

    @Override // android.widget.FrameLayout
    protected float getMaxWidthPct() {
        return this.mMaxWidthPct;
    }

    protected List<View> getVisibleChildren() {
        return this.mVisibleChildren;
    }

    @Override // android.widget.FrameLayout
    protected int getWidthWithMargins(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
        return obj3 += rightMargin;
    }

    @Override // android.widget.FrameLayout
    protected void layoutChild(View view, int i2, int i3) {
        this.layoutChild(view, i2, i3, i2 + desiredWidth, i3 + desiredHeight);
    }

    @Override // android.widget.FrameLayout
    protected void layoutChild(View view, int i2, int i3, int i4, int i5) {
        Logging.logdPair("\tleft, right", (float)i2, (float)i4);
        Logging.logdPair("\ttop, bottom", (float)i3, (float)i5);
        view.layout(i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout
    protected void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        Logging.logdPair("\tdesired (w,h)", (float)measuredWidth, (float)measuredHeight);
        super.measureChildWithMargins(view, i2, i3, i4, i5);
        Logging.logdPair("\tactual  (w,h)", (float)obj5, (float)obj4);
    }

    @Override // android.widget.FrameLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Logging.logdHeader("BEGIN LAYOUT");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("onLayout: l: ");
        obj2.append(i2);
        obj2.append(", t: ");
        obj2.append(i3);
        obj2.append(", r: ");
        obj2.append(i4);
        obj2.append(", b: ");
        obj2.append(i5);
        Logging.logd(obj2.toString());
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        String mVisibleChildren;
        int i3;
        int obj3;
        float obj4;
        Logging.logdHeader("BEGIN MEASURE");
        Logging.logdPair("Display", (float)obj3, (float)obj4);
        this.mVisibleChildren.clear();
        obj3 = 0;
        while (obj3 < getChildCount()) {
            obj4 = getChildAt(obj3);
            if (obj4.getVisibility() != 8) {
            } else {
            }
            Logging.logdNumber("Skipping GONE child", (float)obj3);
            obj3++;
            this.mVisibleChildren.add(obj4);
        }
    }

    @Override // android.widget.FrameLayout
    protected int roundToNearest(int i, int i2) {
        return i2 *= obj2;
    }
}
