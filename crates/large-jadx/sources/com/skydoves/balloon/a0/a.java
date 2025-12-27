package com.skydoves.balloon.a0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import androidx.core.content.a;
import kotlin.d0.d.n;

/* compiled from: ContextExtension.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final /* synthetic */ int a(Context context, int i) {
        n.f(context, "$this$contextColor");
        return a.d(context, i);
    }

    public static final /* synthetic */ float b(Context context, int i) throws android.content.res.Resources.NotFoundException {
        n.f(context, "$this$dimen");
        return context.getResources().getDimension(i);
    }

    public static final /* synthetic */ Point c(Context context) {
        n.f(context, "$this$displaySize");
        Resources resources = context.getResources();
        final String str2 = "resources";
        n.e(resources, str2);
        Resources resources2 = context.getResources();
        n.e(resources2, str2);
        return new Point(resources.getDisplayMetrics().widthPixels, resources2.getDisplayMetrics().heightPixels);
    }

    public static final /* synthetic */ boolean d(Context context) {
        boolean z2 = false;
        n.f(context, "$this$isFinishing");
        if (context instanceof Activity) {
            context = context.isFinishing() ? 1 : 0;
        }
        return (context.isFinishing() ? 1 : 0);
    }
}
