package com.google.firebase.inappmessaging.display.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes2.dex */
public class ResizableImageView extends AppCompatImageView {

    private int mDensityDpi;

    private static class Dimensions {

        final int h;
        final int w;
        private Dimensions(int i, int i2) {
            super();
            this.w = i;
            this.h = i2;
        }

        Dimensions(int i, int i2, com.google.firebase.inappmessaging.display.internal.ResizableImageView.1 resizableImageView$13) {
            super(i, i2);
        }
    }
    public ResizableImageView(Context context) {
        super(context);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init(context);
    }

    public ResizableImageView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        init(context);
    }

    private com.google.firebase.inappmessaging.display.internal.ResizableImageView.Dimensions bound(int i, int i2) {
        float maxWidth;
        int maxHeight;
        float str;
        String str2;
        int obj5;
        int obj6;
        maxWidth = getMaxWidth();
        maxHeight = getMaxHeight();
        if (i > maxWidth) {
            Logging.logdNumber("Image: capping width", (float)maxWidth);
            obj6 /= i;
            obj5 = maxWidth;
        }
        if (obj6 > maxHeight) {
            Logging.logdNumber("Image: capping height", (float)maxHeight);
            obj5 /= obj6;
        } else {
            maxHeight = obj6;
        }
        obj6 = new ResizableImageView.Dimensions(obj5, maxHeight, 0);
        return obj6;
    }

    private void checkMinDim() {
        int cmp;
        int i;
        int measuredWidth;
        int measuredHeight;
        int stringBuilder;
        float str;
        float f;
        float f2;
        int i2;
        int i3 = Math.max(getMinimumWidth(), getSuggestedMinimumWidth());
        i = Math.max(getMinimumHeight(), getSuggestedMinimumHeight());
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
        float f3 = (float)i3;
        str = (float)i;
        Logging.logdPair("Image: min width, height", f3, str);
        f = (float)measuredWidth;
        f2 = (float)measuredHeight;
        Logging.logdPair("Image: actual width, height", f, f2);
        stringBuilder = measuredWidth < i3 ? f3 / f : i2;
        if (measuredHeight < i) {
            i2 = str / f2;
        }
        if (Float.compare(stringBuilder, i2) > 0) {
        } else {
            stringBuilder = i2;
        }
        if (Double.compare(d, l) > 0) {
            int i4 = (int)ceil;
            int i5 = (int)ceil2;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Measured dimension (");
            stringBuilder.append(measuredWidth);
            String str2 = "x";
            stringBuilder.append(str2);
            stringBuilder.append(measuredHeight);
            stringBuilder.append(") too small.  Resizing to ");
            stringBuilder.append(i4);
            stringBuilder.append(str2);
            stringBuilder.append(i5);
            Logging.logd(stringBuilder.toString());
            com.google.firebase.inappmessaging.display.internal.ResizableImageView.Dimensions bound = bound(i4, i5);
            setMeasuredDimension(bound.w, bound.h);
        }
    }

    private void init(Context context) {
        this.mDensityDpi = (int)obj2;
    }

    private void scalePxToDp(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int obj5 = drawable.getIntrinsicHeight();
        float f4 = (float)obj5;
        Logging.logdPair("Image: intrinsic width, height", (float)intrinsicWidth, f4);
        int mDensityDpi = this.mDensityDpi;
        obj5 = bound((int)ceil, (int)ceil2);
        Logging.logdPair("Image: new target dimensions", (float)i4, (float)i6);
        setMeasuredDimension(obj5.w, obj5.h);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onMeasure(int i, int i2) {
        int obj1;
        int obj2;
        super.onMeasure(i, i2);
        obj1 = getDrawable();
        if (Build.VERSION.SDK_INT > 16 && obj1 != null && getAdjustViewBounds()) {
            obj1 = getDrawable();
            if (obj1 != null) {
                if (getAdjustViewBounds()) {
                    scalePxToDp(obj1);
                    checkMinDim();
                }
            }
        }
    }
}
