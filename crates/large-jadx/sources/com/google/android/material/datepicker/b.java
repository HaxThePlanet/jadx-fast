package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import d.h.k.i;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.l;

/* loaded from: classes2.dex */
final class b {

    private final Rect a;
    private final ColorStateList b;
    private final ColorStateList c;
    private final ColorStateList d;
    private final int e;
    private final k f;
    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i4, k k5, Rect rect6) {
        super();
        i.b(rect6.left);
        i.b(rect6.top);
        i.b(rect6.right);
        i.b(rect6.bottom);
        this.a = rect6;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = i4;
        this.f = k5;
    }

    static com.google.android.material.datepicker.b a(Context context, int i2) {
        int i;
        int i3 = 0;
        i = i2 != 0 ? 1 : i3;
        i.a(i, "Cannot create a CalendarItemStyle with a styleResId of 0");
        final TypedArray obj13 = context.obtainStyledAttributes(i2, l.G2);
        Rect rect = new Rect(obj13.getDimensionPixelOffset(l.H2, i3), obj13.getDimensionPixelOffset(l.J2, i3), obj13.getDimensionPixelOffset(l.I2, i3), obj13.getDimensionPixelOffset(l.K2, i3));
        obj13.recycle();
        super(c.a(context, obj13, l.L2), c.a(context, obj13, l.Q2), c.a(context, obj13, l.O2), obj13.getDimensionPixelSize(l.P2, i3), k.b(context, obj13.getResourceId(l.M2, i3), obj13.getResourceId(l.N2, i3)).m(), rect);
        return obj12;
    }

    int b() {
        return rect.bottom;
    }

    int c() {
        return rect.top;
    }

    void d(TextView textView) {
        RippleDrawable rippleDrawable;
        ColorStateList alpha;
        int i;
        Object obj;
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.Z(this.c);
        gVar.h0((float)i2, this.d);
        textView.setTextColor(this.b);
        if (Build.VERSION.SDK_INT >= 21) {
            rippleDrawable = new RippleDrawable(this.b.withAlpha(30), gVar, gVar2);
            obj = rippleDrawable;
        } else {
            obj = gVar;
        }
        Rect rect = this.a;
        super(obj, rect.left, rect.top, rect.right, rect.bottom);
        u.o0(textView, insetDrawable);
    }
}
