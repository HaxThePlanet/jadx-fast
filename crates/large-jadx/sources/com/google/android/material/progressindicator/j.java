package com.google.android.material.progressindicator;

import d.v.a.a.b;

/* loaded from: classes2.dex */
abstract class j<T extends android.animation.Animator>  {

    protected com.google.android.material.progressindicator.k a;
    protected final float[] b;
    protected final int[] c;
    protected j(int i) {
        super();
        this.b = new float[i * 2];
        this.c = new int[i];
    }

    abstract void a();

    protected float b(int i, int i2, int i3) {
        return obj1 /= obj2;
    }

    public abstract void c();

    public abstract void d(b b);

    protected void e(com.google.android.material.progressindicator.k k) {
        this.a = k;
    }

    abstract void f();

    abstract void g();

    public abstract void h();
}
