package com.google.android.material.theme.a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d.a.o.d;
import f.c.a.e.b;

/* loaded from: classes2.dex */
public class a {

    private static final int[] a;
    private static final int[] b;
    static {
        int[] iArr = new int[2];
        final int i5 = 0;
        iArr[i5] = 16842752;
        final int i6 = 1;
        iArr[i6] = b.Y;
        a.a = iArr;
        int[] iArr2 = new int[i6];
        iArr2[i5] = b.F;
        a.b = iArr2;
    }

    private static int a(Context context, AttributeSet attributeSet2) {
        int resourceId;
        final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, a.a);
        int obj3 = 0;
        obj2.recycle();
        if (obj2.getResourceId(obj3, obj3) != 0) {
        } else {
            resourceId = obj3;
        }
        return resourceId;
    }

    private static int b(Context context, AttributeSet attributeSet2, int i3, int i4) {
        final TypedArray obj1 = context.obtainStyledAttributes(attributeSet2, a.b, i3, i4);
        int obj2 = 0;
        obj1.recycle();
        return obj1.getResourceId(obj2, obj2);
    }

    public static Context c(Context context, AttributeSet attributeSet2, int i3, int i4) {
        Object obj2;
        boolean obj4;
        final int obj3 = a.b(context, attributeSet2, i3, i4);
        final int i = 1;
        if (context instanceof d && (d)context.c() == obj3) {
            obj4 = (d)context.c() == obj3 ? i : 0;
        } else {
        }
        if (obj3 != null) {
            if (obj4 != null) {
            } else {
                obj4 = new d(context, obj3);
                final int obj1 = a.a(context, attributeSet2);
                if (obj1 != null) {
                    obj4.getTheme().applyStyle(obj1, i);
                }
            }
            return obj4;
        }
        return context;
    }
}
