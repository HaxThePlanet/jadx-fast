package com.airbnb.lottie.z;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {

    private final d a;
    public final T b;
    public T c;
    public final Interpolator d;
    public final Interpolator e;
    public final Interpolator f;
    public final float g;
    public Float h;
    private float i = -3987645.8f;
    private float j = -3987645.8f;
    private int k = 784923401;
    private int l = 784923401;
    private float m = 0.000000000000000000000000000000000000000000001f;
    private float n = 0.000000000000000000000000000000000000000000001f;
    public PointF o = null;
    public PointF p = null;
    public a(d dVar, T t, T t2, Interpolator interpolator, float f, Float float) {
        super();
        interpolator = null;
        this.a = dVar;
        this.b = t;
        this.c = t2;
        this.d = interpolator;
        this.e = interpolator;
        this.f = interpolator;
        this.g = f;
        this.h = float;
    }

    public boolean a(float f) {
        int cmp;
        boolean z = false;
        float f2 = e();
        if (f >= f2) {
            float f3 = b();
            f = f < f3 ? 1 : 0;
        }
        return (f < f3 ? 1 : 0);
    }

    public float b() {
        float f = 1f;
        if (this.a == null) {
            return f;
        }
        float f2 = 0.000000000000000000000000000000000000000000001f;
        if (this.n == 0.000000000000000000000000000000000000000000001f && this.h == null) {
            this.n = f;
        }
        return this.n;
    }

    public float c() {
        if (this.j == -898407689) {
            this.j = (Float)this.c.floatValue();
        }
        return this.j;
    }

    public int d() {
        if (this.l == 784923401) {
            this.l = (Integer)this.c.intValue();
        }
        return this.l;
    }

    public float e() {
        if (this.a == null) {
            return 0;
        }
        if (this.m == 1) {
            this.m = (this.g - this.a.o()) / this.a.e();
        }
        return this.m;
    }

    public float f() {
        if (this.i == -898407689) {
            this.i = (Float)this.b.floatValue();
        }
        return this.i;
    }

    public int g() {
        if (this.k == 784923401) {
            this.k = (Integer)this.b.intValue();
        }
        return this.k;
    }

    public boolean h() {
        boolean z = true;
        int r0 = this.d == null && this.e == null && this.f == null ? 1 : 0;
        return (this.d == null && this.e == null && this.f == null ? 1 : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Keyframe{startValue=";
        String str3 = ", endValue=";
        String str4 = ", startFrame=";
        String str5 = ", endFrame=";
        String str6 = ", interpolator=";
        str = str2 + this.b + str3 + this.c + str4 + this.g + str5 + this.h + str6 + this.d + 125;
        return str;
    }

    public a(d dVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float float) {
        super();
        this.a = dVar;
        this.b = t;
        this.c = t2;
        this.d = null;
        this.e = interpolator;
        this.f = interpolator2;
        this.g = f;
        this.h = float;
    }

    protected a(d dVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float float) {
        super();
        this.a = dVar;
        this.b = t;
        this.c = t2;
        this.d = interpolator;
        this.e = interpolator2;
        this.f = interpolator3;
        this.g = f;
        this.h = float;
    }

    public a(T t) {
        super();
        final d dVar = null;
        this.a = dVar;
        this.b = t;
        this.c = t;
        this.d = dVar;
        this.e = dVar;
        this.f = dVar;
        this.g = 0.000000000000000000000000000000000000000000001f;
        this.h = 340282350000000000000000000000000000000f;
    }
}
