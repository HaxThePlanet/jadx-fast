package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.l;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.l;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public abstract class c {

    public int a;
    public int b;
    public int[] c;
    public int d;
    public int e;
    public int f;
    protected c(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super();
        final int i = 0;
        this.c = new int[i];
        final TypedArray obj10 = l.h(context, attributeSet2, l.A, i3, i4, new int[i]);
        this.a = c.c(context, obj10, l.I, context.getResources().getDimensionPixelSize(d.k0));
        this.b = Math.min(c.c(context, obj10, l.H, i), obj12 /= 2);
        this.e = obj10.getInt(l.E, i);
        this.f = obj10.getInt(l.B, i);
        c(context, obj10);
        d(context, obj10);
        obj10.recycle();
    }

    private void c(Context context, TypedArray typedArray2) {
        int i = l.C;
        final int i3 = 0;
        final int i4 = -1;
        final int i5 = 1;
        if (!typedArray2.hasValue(i)) {
            int[] obj7 = new int[i5];
            obj7[i3] = a.b(context, b.o, i4);
            this.c = obj7;
        }
        if (peekValue.type != i5) {
            int[] obj6 = new int[i5];
            obj6[i3] = typedArray2.getColor(i, i4);
            this.c = obj6;
        }
        obj6 = context.getResources().getIntArray(typedArray2.getResourceId(i, i4));
        this.c = obj6;
        if (obj6.length == 0) {
        } else {
        }
        obj6 = new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        throw obj6;
    }

    private void d(Context context, TypedArray typedArray2) {
        int i = l.G;
        if (typedArray2.hasValue(i)) {
            this.d = typedArray2.getColor(i, -1);
        }
        int i2 = 0;
        this.d = this.c[i2];
        int[] obj4 = new int[1];
        obj4[i2] = 16842803;
        TypedArray obj3 = context.getTheme().obtainStyledAttributes(obj4);
        obj3.recycle();
        this.d = a.a(this.d, (int)obj4);
    }

    public boolean a() {
        int i;
        i = this.f != 0 ? 1 : 0;
        return i;
    }

    public boolean b() {
        int i;
        i = this.e != 0 ? 1 : 0;
        return i;
    }

    abstract void e();
}
