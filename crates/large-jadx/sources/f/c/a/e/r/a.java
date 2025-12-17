package f.c.a.e.r;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import d.h.f.a;
import f.c.a.e.a0.b;

/* loaded from: classes2.dex */
public class a {
    public static int a(int i, int i2) {
        return a.i(i, i3 /= 255);
    }

    public static int b(Context context, int i2, int i3) {
        android.util.TypedValue obj0 = b.a(context, i2);
        if (obj0 != null) {
            return obj0.data;
        }
        return i3;
    }

    public static int c(Context context, int i2, String string3) {
        return b.d(context, i2, string3);
    }

    public static int d(View view, int i2) {
        return b.e(view, i2);
    }

    public static int e(View view, int i2, int i3) {
        return a.b(view.getContext(), i2, i3);
    }

    public static boolean f(int i) {
        double d;
        long l;
        int obj4;
        if (i != 0 && Double.compare(d, l) > 0) {
            obj4 = Double.compare(d, l) > 0 ? 1 : 0;
        } else {
        }
        return obj4;
    }

    public static int g(int i, int i2) {
        return a.f(i2, i);
    }

    public static int h(int i, int i2, float f3) {
        return a.g(i, a.i(i2, Math.round(f *= f3)));
    }

    public static int i(View view, int i2, int i3, float f4) {
        return a.h(a.d(view, i2), a.d(view, i3), f4);
    }
}
