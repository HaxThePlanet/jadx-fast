package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.e0.c.a;

/* loaded from: classes2.dex */
class a extends a {

    private final c.a d;
    public a(Context context, int i2) {
        super();
        c.a aVar = new c.a(16, context.getString(i2));
        this.d = aVar;
    }

    @Override // d.h.l.a
    public void g(View view, c c2) {
        super.g(view, c2);
        c2.b(this.d);
    }
}
