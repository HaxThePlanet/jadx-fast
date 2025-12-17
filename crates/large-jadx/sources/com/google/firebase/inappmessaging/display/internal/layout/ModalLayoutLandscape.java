package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R.id;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ModalLayoutLandscape extends com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout {

    private static final int ITEM_SPACING_DP = 24;
    private static final float MAX_IMG_WIDTH_PCT = 0.4f;
    private int barrierWidth;
    private View buttonChild;
    private View imageChild;
    private int leftContentHeight;
    private int rightContentHeight;
    private View scrollChild;
    private View titleChild;
    private int vertItemSpacing;
    public ModalLayoutLandscape(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void layoutCenterHorizontal(View view, int i2, int i3, int i4, int i5) {
        measuredWidth /= 2;
        i2 += obj11;
        this.layoutChild(view, obj9 - i, i3, obj9 + i, i5);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int obj12;
        int obj13;
        int obj14;
        super.onLayout(z, i2, i3, i4, i5);
        final int paddingLeft = getPaddingLeft();
        int obj10 = getPaddingTop();
        obj11 -= obj12;
        obj12 = this.leftContentHeight;
        obj13 = this.rightContentHeight;
        obj14 = 0;
        if (obj12 < obj13) {
            obj13 /= 2;
            obj12 = obj14;
        } else {
            obj12 /= 2;
            obj13 = obj14;
        }
        Logging.logd("Layout image");
        int i6 = obj10 + obj13;
        obj13 += paddingLeft;
        this.layoutChild(this.imageChild, paddingLeft, i6, obj13, i6 + desiredHeight);
        obj13 += barrierWidth;
        Logging.logd("Layout getTitle");
        int i11 = obj10 + obj12;
        obj10 += i11;
        this.layoutChild(this.titleChild, obj13, i11, obj11, obj10);
        Logging.logd("Layout getBody");
        int i = 8;
        obj12 = this.titleChild.getVisibility() == i ? obj14 : this.vertItemSpacing;
        int i12 = obj10 + obj12;
        obj10 += i12;
        this.layoutChild(this.scrollChild, obj13, i12, obj11, obj10);
        Logging.logd("Layout button");
        if (this.scrollChild.getVisibility() == i) {
        } else {
            obj14 = this.vertItemSpacing;
        }
        layoutChild(this.buttonChild, obj13, obj10 += obj14);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onMeasure(int i, int i2) {
        int dpToPixels;
        List desiredWidth;
        int i3;
        int i4;
        int i5;
        int visibility;
        int obj13;
        super.onMeasure(i, i2);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.buttonChild = findChildById(R.id.button);
        int i7 = 24;
        int i10 = 8;
        i4 = 0;
        if (this.imageChild.getVisibility() == i10) {
            dpToPixels = i4;
        } else {
            dpToPixels = dpToPixels(i7);
        }
        this.barrierWidth = dpToPixels;
        this.vertItemSpacing = dpToPixels(i7);
        View[] arr = new View[3];
        arr[i4] = this.titleChild;
        int i11 = 1;
        arr[i11] = this.scrollChild;
        arr[2] = this.buttonChild;
        desiredWidth = Arrays.asList(arr);
        paddingLeft += paddingRight;
        paddingBottom += paddingTop;
        obj13 -= i12;
        obj12 -= i9;
        Logging.logd("Measuring image");
        MeasureUtils.measureAtMost(this.imageChild, (int)i16, obj13);
        int desiredWidth2 = getDesiredWidth(this.imageChild);
        obj12 -= i18;
        float f3 = (float)desiredWidth2;
        Logging.logdPair("Max col widths (l, r)", f3, (float)obj12);
        Iterator iterator = desiredWidth.iterator();
        i5 = i4;
        while (iterator.hasNext()) {
            if ((View)iterator.next().getVisibility() != i10) {
            }
            i5++;
        }
        i3 = Math.max(i4, i20 *= vertItemSpacing);
        obj13 -= i3;
        Logging.logd("Measuring getTitle");
        MeasureUtils.measureAtMost(this.titleChild, obj12, obj13);
        Logging.logd("Measuring button");
        MeasureUtils.measureAtMost(this.buttonChild, obj12, obj13);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureAtMost(this.scrollChild, obj12, obj13 -= desiredHeight2);
        this.leftContentHeight = getDesiredHeight(this.imageChild);
        this.rightContentHeight = i3;
        Iterator obj12 = desiredWidth.iterator();
        for (View obj13 : obj12) {
            this.rightContentHeight = rightContentHeight += obj13;
        }
        obj12 = Math.max(obj12 += i12, obj13 += i12);
        obj13 = desiredWidth.iterator();
        for (View next2 : obj13) {
            i4 = Math.max(getDesiredWidth(next2), i4);
        }
        Logging.logdPair("Measured columns (l, r)", f3, (float)i4);
        i14 += i9;
        Logging.logdPair("Measured dims", (float)i15, (float)obj12);
        setMeasuredDimension(i15, obj12);
    }
}
