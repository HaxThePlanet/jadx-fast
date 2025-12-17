package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class BaselineLayout extends ViewGroup {

    private int a = -1;
    public BaselineLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
        final int obj2 = -1;
    }

    @Override // android.view.ViewGroup
    public int getBaseline() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt;
        int visibility;
        int i;
        int i6;
        int i7;
        int baseline2;
        int baseline;
        int obj11;
        final int obj9 = getPaddingLeft();
        int obj8 = getPaddingTop();
        obj11 = 0;
        while (obj11 < getChildCount()) {
            childAt = getChildAt(obj11);
            if (childAt.getVisibility() == 8) {
            } else {
            }
            int measuredWidth = childAt.getMeasuredWidth();
            i9 += obj9;
            baseline = -1;
            if (this.a != baseline && childAt.getBaseline() != baseline) {
            } else {
            }
            i7 = obj8;
            childAt.layout(i6, i7, measuredWidth += i6, measuredHeight += i7);
            obj11++;
            if (childAt.getBaseline() != baseline) {
            } else {
            }
            i11 -= baseline;
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int childCount;
        int i3;
        int i7;
        int i4;
        int combineMeasuredStates;
        int i6;
        int i8;
        View measuredState;
        int measuredHeight;
        int i5;
        int i11 = -1;
        i8 = i6;
        combineMeasuredStates = i4;
        while (i3 < getChildCount()) {
            measuredState = getChildAt(i3);
            if (measuredState.getVisibility() == 8) {
            } else {
            }
            measureChild(measuredState, i, i2);
            int baseline = measuredState.getBaseline();
            if (baseline != i11) {
            }
            i4 = Math.max(i4, measuredState.getMeasuredWidth());
            i7 = Math.max(i7, measuredState.getMeasuredHeight());
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, measuredState.getMeasuredState());
            i3++;
            i6 = Math.max(i6, baseline);
            i8 = Math.max(i8, measuredHeight2 -= baseline);
        }
        if (i6 != i11) {
            i7 = Math.max(i7, i10 += i6);
            this.a = i6;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i4, getSuggestedMinimumWidth()), i, combineMeasuredStates), View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, combineMeasuredStates << 16));
    }
}
