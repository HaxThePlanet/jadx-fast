package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes2.dex */
abstract class i<S extends com.google.android.material.progressindicator.c>  {

    S a;
    protected com.google.android.material.progressindicator.h b;
    public i(S s) {
        super();
        this.a = s;
    }

    abstract void a(Canvas canvas, float f2);

    abstract void b(Canvas canvas, Paint paint2, float f3, float f4, int i5);

    abstract void c(Canvas canvas, Paint paint2);

    abstract int d();

    abstract int e();

    protected void f(com.google.android.material.progressindicator.h h) {
        this.b = h;
    }

    void g(Canvas canvas, float f2) {
        this.a.e();
        a(canvas, f2);
    }
}
