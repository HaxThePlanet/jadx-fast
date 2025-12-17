package com.skydoves.balloon.a0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import androidx.core.content.a;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class a {
    public static final int a(Context context, int i2) {
        n.f(context, "$this$contextColor");
        return a.d(context, i2);
    }

    public static final float b(Context context, int i2) {
        n.f(context, "$this$dimen");
        return context.getResources().getDimension(i2);
    }

    public static final Point c(Context context) {
        n.f(context, "$this$displaySize");
        Resources resources = context.getResources();
        final String str2 = "resources";
        n.e(resources, str2);
        Resources obj3 = context.getResources();
        n.e(obj3, str2);
        Point point = new Point(displayMetrics.widthPixels, obj3.heightPixels);
        return point;
    }

    public static final boolean d(Context context) {
        Object obj1;
        n.f(context, "$this$isFinishing");
        if (context instanceof Activity != null && (Activity)context.isFinishing()) {
            obj1 = (Activity)context.isFinishing() ? 1 : 0;
        } else {
        }
        return obj1;
    }
}
