package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import android.view.View.MeasureSpec;
import com.google.firebase.inappmessaging.display.internal.Logging;

/* loaded from: classes2.dex */
public class MeasureUtils {
    private static void measure(View view, int i2, int i3, int i4, int i5) {
        int obj4;
        int obj5;
        Logging.logdPair("\tdesired (w,h)", (float)measuredWidth, (float)measuredHeight);
        if (view.getVisibility() == 8) {
            obj5 = obj4;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(obj4, i4), View.MeasureSpec.makeMeasureSpec(obj5, i5));
        Logging.logdPair("\tactual (w,h)", (float)obj4, (float)obj3);
    }

    public static void measureAtMost(View view, int i2, int i3) {
        final int i = Integer.MIN_VALUE;
        MeasureUtils.measure(view, i2, i3, i, i);
    }

    public static void measureExactly(View view, int i2, int i3) {
        final int i = 1073741824;
        MeasureUtils.measure(view, i2, i3, i, i);
    }

    public static void measureFullHeight(View view, int i2, int i3) {
        MeasureUtils.measure(view, i2, i3, Integer.MIN_VALUE, 1073741824);
    }

    public static void measureFullWidth(View view, int i2, int i3) {
        MeasureUtils.measure(view, i2, i3, 1073741824, Integer.MIN_VALUE);
    }
}
