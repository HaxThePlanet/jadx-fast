package f.c.a.e.r;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import d.h.f.a;
import f.c.a.e.a0.b;

/* compiled from: MaterialColors.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(int i, int i2) {
        return a.i(i, (Color.alpha(i) * i2) / 255);
    }

    public static int b(Context context, int i, int i2) {
        TypedValue typedValue = b.a(context, i);
        if (typedValue != null) {
            return typedValue.data;
        }
        return i2;
    }

    public static int c(Context context, int i, String str) {
        return b.d(context, i, str);
    }

    public static int d(View view, int i) {
        return b.e(view, i);
    }

    public static int e(View view, int i, int i2) {
        return a.b(view.getContext(), i, i2);
    }

    public static boolean f(int i) {
        double d;
        double d2 = 4602678819172646912L;
        boolean z = false;
        if (i != 0) {
            d = a.c(i);
            d2 = 0.5d;
            i = d > 0.5d ? 1 : 0;
        }
        return (d > 0.5d ? 1 : 0);
    }

    public static int g(int i, int i2) {
        return a.f(i2, i);
    }

    public static int h(int i, int i2, float f) {
        return a.g(i, a.i(i2, Math.round((float)Color.alpha(i2) * f)));
    }

    public static int i(View view, int i, int i2, float f) {
        return a.h(a.d(view, i), a.d(view, i2), f);
    }
}
