package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.l;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public final class f extends com.google.android.material.progressindicator.c {

    public int g;
    public int h;
    public int i;
    public f(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.k);
    }

    public f(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, CircularProgressIndicator.G);
    }

    public f(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        final int i7 = 0;
        final TypedArray obj11 = l.h(context, attributeSet2, l.f1, i3, i4, new int[i7]);
        this.g = Math.max(c.c(context, obj11, l.i1, context.getResources().getDimensionPixelSize(d.j0)), obj13 *= 2);
        this.h = c.c(context, obj11, l.h1, context.getResources().getDimensionPixelSize(d.i0));
        this.i = obj11.getInt(l.g1, i7);
        obj11.recycle();
        e();
    }

    @Override // com.google.android.material.progressindicator.c
    void e() {
    }
}
