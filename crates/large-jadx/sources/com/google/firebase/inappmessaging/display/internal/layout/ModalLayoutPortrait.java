package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R.id;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure;
import com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ModalLayoutPortrait extends com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout {

    private static final int ITEM_SPACING_DP = 24;
    private int vertItemSpacing;
    private VerticalViewGroupMeasure vgm;
    public ModalLayoutPortrait(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        VerticalViewGroupMeasure obj1 = new VerticalViewGroupMeasure();
        this.vgm = obj1;
    }

    private boolean isFlex(View view) {
        int image_view;
        int obj3;
        if (view.getId() != R.id.body_scroll) {
            if (view.getId() == R.id.image_view) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i;
        int vertItemSpacing;
        int i7;
        int i8;
        float f;
        int measuredWidth;
        int i6;
        float f2;
        String str;
        int obj9;
        super.onLayout(z, i2, i3, i4, i5);
        obj9 = getPaddingTop();
        final int obj11 = getPaddingLeft();
        int obj13 = getVisibleChildren().size();
        i = 0;
        while (i < obj13) {
            Object obj = getVisibleChildren().get(i);
            measuredWidth = obj.getMeasuredWidth();
            measuredHeight2 += obj9;
            int i12 = 1;
            if (gravity &= i12 == i12) {
            } else {
            }
            i7 = obj11 + measuredWidth;
            i6 = obj11;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Layout child ");
            stringBuilder.append(i);
            Logging.logd(stringBuilder.toString());
            Logging.logdPair("\t(top, bottom)", (float)obj9, (float)i8);
            Logging.logdPair("\t(left, right)", (float)i6, (float)i7);
            obj.layout(i6, obj9, i7, i8);
            if (i < obj13 + -1) {
            }
            i++;
            obj9 += vertItemSpacing;
            i10 /= 2;
            measuredWidth /= 2;
            i6 = i11 - measuredWidth;
            i11 += measuredWidth;
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onMeasure(int i, int i2) {
        int i3;
        Object desiredHeight;
        int view;
        int i4;
        View childAt;
        String maxHeight;
        VerticalViewGroupMeasure vgm;
        String next;
        boolean flex;
        int obj10;
        super.onMeasure(i, i2);
        this.vertItemSpacing = dpToPixels(24);
        final int obj9 = calculateBaseWidth(i);
        obj10 = calculateBaseHeight(i2);
        i7 += i9;
        this.vgm.reset(obj9, obj10);
        int i10 = 0;
        i4 = i10;
        while (i4 < getChildCount()) {
            childAt = getChildAt(i4);
            this.vgm.add(childAt, isFlex(childAt));
            i4++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Screen dimens: ");
        stringBuilder2.append(getDisplayMetrics());
        Logging.logd(stringBuilder2.toString());
        Logging.logdPair("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f = (float)obj9;
        Logging.logdPair("Base dimens", f, (float)obj10);
        Iterator iterator2 = this.vgm.getViews().iterator();
        for (ViewMeasure next : iterator2) {
            Logging.logd("Pre-measure child");
            next.preMeasure(obj9, obj10);
        }
        totalHeight += i3;
        Logging.logdNumber("Total reserved height", (float)i3);
        Logging.logdNumber("Total desired height", (float)i11);
        if (i11 > obj10) {
        } else {
            view = i10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Total height constrained: ");
        stringBuilder.append(view);
        Logging.logd(stringBuilder.toString());
        if (view != null) {
            this.vgm.allocateSpace(obj10 -= totalFixedHeight);
        }
        Iterator iterator = this.vgm.getViews().iterator();
        for (ViewMeasure next3 : iterator) {
            Logging.logd("Measuring child");
            MeasureUtils.measureAtMost(next3.getView(), obj9 - i6, next3.getMaxHeight());
            i3 += desiredHeight;
        }
        Logging.logdPair("Measured dims", f, (float)i3);
        setMeasuredDimension(obj9, i3);
    }
}
