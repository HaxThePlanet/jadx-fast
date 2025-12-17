package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.t0;
import f.c.a.e.b;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public final class l {

    private static final int[] a;
    private static final int[] b;
    static {
        int i = 1;
        int[] iArr2 = new int[i];
        final int i4 = 0;
        iArr2[i4] = b.o;
        l.a = iArr2;
        int[] iArr = new int[i];
        iArr[i4] = b.p;
        l.b = iArr;
    }

    public static void a(Context context) {
        l.e(context, l.a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet2, int i3, int i4) {
        int[] iArr;
        TypedValue obj2;
        boolean obj3;
        int obj4;
        obj2 = context.obtainStyledAttributes(attributeSet2, l.x6, i3, i4);
        obj2.recycle();
        if (obj2.getBoolean(l.z6, false)) {
            obj2 = new TypedValue();
            if (context.getTheme().resolveAttribute(b.x, obj2, true)) {
                if (obj2.type == 18 && obj2.data == null) {
                    if (obj2.data == null) {
                        l.c(context);
                    }
                }
            } else {
            }
        }
        l.a(context);
    }

    public static void c(Context context) {
        l.e(context, l.b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet2, int[] i3Arr3, int i4, int i5, int... i6Arr6) {
        boolean boolean;
        int i;
        boolean obj3;
        AttributeSet obj4;
        TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, l.x6, i4, i5);
        if (!styledAttributes.getBoolean(l.A6, false)) {
            styledAttributes.recycle();
        }
        if (i6Arr6 != null) {
            if (i6Arr6.length == 0) {
                obj4 = -1;
                if (styledAttributes.getResourceId(l.y6, obj4) != obj4) {
                    i = 1;
                }
                obj3 = i;
            } else {
                obj3 = l.f(context, attributeSet2, i3Arr3, i4, i5, i6Arr6);
            }
        } else {
        }
        styledAttributes.recycle();
        if (obj3 == null) {
        } else {
        }
        obj3 = new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        throw obj3;
    }

    private static void e(Context context, int[] i2Arr2, String string3) {
        if (!l.g(context, i2Arr2)) {
        } else {
        }
        StringBuilder obj2 = new StringBuilder();
        obj2.append("The style on this component requires your app theme to be ");
        obj2.append(string3);
        obj2.append(" (or a descendant).");
        IllegalArgumentException obj1 = new IllegalArgumentException(obj2.toString());
        throw obj1;
    }

    private static boolean f(Context context, AttributeSet attributeSet2, int[] i3Arr3, int i4, int i5, int... i6Arr6) {
        int i;
        int obj4;
        int obj5;
        TypedArray obj1 = context.obtainStyledAttributes(attributeSet2, i3Arr3, i4, i5);
        final int obj3 = 0;
        obj4 = obj3;
        while (obj4 < i6Arr6.length) {
            i = -1;
            obj4++;
        }
        obj1.recycle();
        return 1;
    }

    private static boolean g(Context context, int[] i2Arr2) {
        int i;
        boolean value;
        TypedArray obj3 = context.obtainStyledAttributes(i2Arr2);
        final int i2 = 0;
        i = i2;
        while (i < i2Arr2.length) {
            i++;
        }
        obj3.recycle();
        return 1;
    }

    public static TypedArray h(Context context, AttributeSet attributeSet2, int[] i3Arr3, int i4, int i5, int... i6Arr6) {
        l.b(context, attributeSet2, i4, i5);
        l.d(context, attributeSet2, i3Arr3, i4, i5, i6Arr6);
        return context.obtainStyledAttributes(attributeSet2, i3Arr3, i4, i5);
    }

    public static t0 i(Context context, AttributeSet attributeSet2, int[] i3Arr3, int i4, int i5, int... i6Arr6) {
        l.b(context, attributeSet2, i4, i5);
        l.d(context, attributeSet2, i3Arr3, i4, i5, i6Arr6);
        return t0.v(context, attributeSet2, i3Arr3, i4, i5);
    }
}
