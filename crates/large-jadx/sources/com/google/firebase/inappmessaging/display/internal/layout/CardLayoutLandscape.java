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
public class CardLayoutLandscape extends com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout {

    private static double IMAGE_MAX_WIDTH_PCT = 0.6d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;
    static {
    }

    public CardLayoutLandscape(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        final int obj8 = getMeasuredHeight();
        Logging.logd("Layout image");
        int obj9 = getDesiredWidth(this.imageChild);
        int i7 = 0;
        final Object obj = this;
        obj.layoutChild(this.imageChild, 0, i7, obj9, getDesiredHeight(this.imageChild));
        Logging.logd("Layout title");
        int obj10 = getDesiredHeight(this.titleChild);
        int i6 = obj9;
        int i11 = obj7;
        obj.layoutChild(this.titleChild, i6, i7, i11, obj10);
        Logging.logd("Layout scroll");
        obj.layoutChild(this.scrollChild, i6, obj10, i11, obj10 + obj11);
        Logging.logd("Layout action bar");
        obj.layoutChild(this.actionBarChild, i6, obj8 - obj10, i11, obj8);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onMeasure(int i, int i2) {
        List desiredWidth;
        int desiredWidth2;
        int i3;
        super.onMeasure(i, i2);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        View childById4 = findChildById(R.id.action_bar);
        this.actionBarChild = childById4;
        View[] arr = new View[3];
        int obj7 = calculateBaseWidth(i);
        int obj8 = calculateBaseHeight(i2);
        int roundToNearest = roundToNearest((int)i5, 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullHeight(this.imageChild, obj7, obj8);
        if (getDesiredWidth(this.imageChild) > roundToNearest) {
            Logging.logd("Image exceeded maximum width, remeasuring image");
            MeasureUtils.measureFullWidth(this.imageChild, roundToNearest, obj8);
        }
        obj8 = getDesiredHeight(this.imageChild);
        int desiredWidth3 = getDesiredWidth(this.imageChild);
        obj7 -= desiredWidth3;
        float f2 = (float)desiredWidth3;
        Logging.logdPair("Max col widths (l, r)", f2, (float)obj7);
        Logging.logd("Measuring title");
        MeasureUtils.measureAtMost(this.titleChild, obj7, obj8);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureAtMost(this.actionBarChild, obj7, obj8);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullHeight(this.scrollChild, obj7, i11 -= desiredHeight2);
        obj7 = Arrays.asList(this.titleChild, this.scrollChild, childById4).iterator();
        for (View next2 : obj7) {
            i3 = Math.max(getDesiredWidth(next2), i3);
        }
        Logging.logdPair("Measured columns (l, r)", f2, (float)i3);
        desiredWidth3 += i3;
        Logging.logdPair("Measured dims", (float)i7, (float)obj8);
        setMeasuredDimension(i7, obj8);
    }
}
