package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import f.c.a.e.a0.b;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.l;

/* loaded from: classes2.dex */
final class c {

    final com.google.android.material.datepicker.b a;
    final com.google.android.material.datepicker.b b;
    final com.google.android.material.datepicker.b c;
    final com.google.android.material.datepicker.b d;
    final com.google.android.material.datepicker.b e;
    final com.google.android.material.datepicker.b f;
    final com.google.android.material.datepicker.b g;
    final Paint h;
    c(Context context) {
        super();
        TypedArray styledAttributes = context.obtainStyledAttributes(b.d(context, b.B, i.class.getCanonicalName()), l.x2);
        int i5 = 0;
        this.a = b.a(context, styledAttributes.getResourceId(l.A2, i5));
        this.g = b.a(context, styledAttributes.getResourceId(l.y2, i5));
        this.b = b.a(context, styledAttributes.getResourceId(l.z2, i5));
        this.c = b.a(context, styledAttributes.getResourceId(l.B2, i5));
        this.d = b.a(context, styledAttributes.getResourceId(l.E2, i5));
        this.e = b.a(context, styledAttributes.getResourceId(l.D2, i5));
        this.f = b.a(context, styledAttributes.getResourceId(l.F2, i5));
        Paint obj5 = new Paint();
        this.h = obj5;
        obj5.setColor(c.a(context, styledAttributes, l.C2).getDefaultColor());
        styledAttributes.recycle();
    }
}
