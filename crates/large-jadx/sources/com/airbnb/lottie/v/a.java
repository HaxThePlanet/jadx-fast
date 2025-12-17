package com.airbnb.lottie.v;

import android.graphics.PointF;

/* loaded from: classes.dex */
public class a {

    private final PointF a;
    private final PointF b;
    private final PointF c;
    public a() {
        super();
        PointF pointF = new PointF();
        this.a = pointF;
        PointF pointF2 = new PointF();
        this.b = pointF2;
        PointF pointF3 = new PointF();
        this.c = pointF3;
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        super();
        this.a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }

    public PointF a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public PointF c() {
        return this.c;
    }

    public void d(float f, float f2) {
        this.a.set(f, f2);
    }

    public void e(float f, float f2) {
        this.b.set(f, f2);
    }

    public void f(float f, float f2) {
        this.c.set(f, f2);
    }
}
