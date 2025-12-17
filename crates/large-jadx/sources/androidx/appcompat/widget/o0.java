package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import d.a.j;
import d.h.f.a;

/* loaded from: classes.dex */
public class o0 {

    private static final java.lang.ThreadLocal<TypedValue> a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    private static final int[] g;
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        o0.a = threadLocal;
        int i = 1;
        int[] iArr2 = new int[i];
        final int i6 = 0;
        iArr2[i6] = -16842910;
        o0.b = iArr2;
        int[] iArr3 = new int[i];
        iArr3[i6] = 16842908;
        o0.c = iArr3;
        int[] iArr4 = new int[i];
        iArr4[i6] = 16842919;
        o0.d = iArr4;
        int[] iArr5 = new int[i];
        iArr5[i6] = 16842912;
        o0.e = iArr5;
        o0.f = new int[i6];
        o0.g = new int[i];
    }

    public static void a(View view, Context context2) {
        boolean value;
        StringBuilder stringBuilder;
        String str;
        Object obj3;
        final TypedArray obj4 = context2.obtainStyledAttributes(j.u0);
        if (!obj4.hasValue(j.z0)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view.getClass());
            stringBuilder.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            Log.e("ThemeUtils", stringBuilder.toString());
        }
        obj4.recycle();
    }

    public static int b(Context context, int i2) {
        boolean stateful;
        ColorStateList list = o0.e(context, i2);
        if (list != null && list.isStateful()) {
            if (list.isStateful()) {
                return list.getColorForState(o0.b, list.getDefaultColor());
            }
        }
        TypedValue typedValue = o0.f();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return o0.d(context, i2, typedValue.getFloat());
    }

    public static int c(Context context, int i2) {
        final int[] iArr = o0.g;
        final int i = 0;
        iArr[i] = i2;
        final androidx.appcompat.widget.t0 obj2 = t0.u(context, 0, iArr);
        obj2.w();
        return obj2.b(i, i);
    }

    static int d(Context context, int i2, float f3) {
        int obj0 = o0.c(context, i2);
        return a.i(obj0, Math.round(obj1 *= f3));
    }

    public static ColorStateList e(Context context, int i2) {
        final int[] iArr = o0.g;
        final int i = 0;
        iArr[i] = i2;
        final androidx.appcompat.widget.t0 obj2 = t0.u(context, 0, iArr);
        obj2.w();
        return obj2.c(i);
    }

    private static TypedValue f() {
        Object typedValue;
        final java.lang.ThreadLocal threadLocal = o0.a;
        if ((TypedValue)threadLocal.get() == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }
}
