package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R.id;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class CardLayoutPortrait extends com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout {

    private static double IMAGE_MAX_HEIGHT_PCT = 0.8d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;
    static {
    }

    public CardLayoutPortrait(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        String string;
        float f3;
        float f;
        float f2;
        String str;
        int obj8;
        int obj9;
        int obj10;
        super.onLayout(z, i2, i3, i4, i5);
        final int obj7 = 0;
        obj9 = obj8;
        while (obj8 < getVisibleChildren().size()) {
            obj10 = getVisibleChildren().get(obj8);
            measuredHeight += obj9;
            measuredWidth += obj7;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Layout child ");
            stringBuilder2.append(obj8);
            Logging.logd(stringBuilder2.toString());
            Logging.logdPair("\t(top, bottom)", (float)obj9, (float)i);
            Logging.logdPair("\t(left, right)", (float)obj7, (float)i6);
            obj10.layout(obj7, obj9, i6, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Child ");
            stringBuilder.append(obj8);
            stringBuilder.append(" wants to be ");
            Logging.logdPair(stringBuilder.toString(), (float)measuredWidth2, (float)measuredHeight2);
            obj9 += obj10;
            obj8++;
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout
    protected void onMeasure(int i, int i2) {
        int i3;
        int desiredHeight;
        int i4;
        double desiredHeight2;
        super.onMeasure(i, i2);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.actionBarChild = findChildById(R.id.action_bar);
        int obj5 = calculateBaseWidth(i);
        int obj6 = calculateBaseHeight(i2);
        int roundToNearest = roundToNearest((int)i5, 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullWidth(this.imageChild, obj5, obj6);
        if (getDesiredHeight(this.imageChild) > roundToNearest) {
            Logging.logd("Image exceeded maximum height, remeasuring image");
            MeasureUtils.measureFullHeight(this.imageChild, obj5, roundToNearest);
        }
        obj5 = getDesiredWidth(this.imageChild);
        Logging.logd("Measuring title");
        MeasureUtils.measureFullWidth(this.titleChild, obj5, obj6);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureFullWidth(this.actionBarChild, obj5, obj6);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullWidth(this.scrollChild, obj5, obj6 -= desiredHeight5);
        i4 = i3;
        while (i3 < getVisibleChildren().size()) {
            i4 += desiredHeight2;
            i3++;
        }
        setMeasuredDimension(obj5, i4);
    }
}
