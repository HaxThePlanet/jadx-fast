package com.airbnb.lottie.z;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;

/* loaded from: classes.dex */
public class a<T>  {

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
    public a(d d, T t2, T t3, Interpolator interpolator4, float f5, Float float6) {
        super();
        int i = -898407689;
        int i2 = 784923401;
        int i3 = 1;
        int i4 = 0;
        this.a = d;
        this.b = t2;
        this.c = t3;
        this.d = interpolator4;
        this.e = i4;
        this.f = i4;
        this.g = f5;
        this.h = float6;
    }

    public a(d d, T t2, T t3, Interpolator interpolator4, Interpolator interpolator5, float f6, Float float7) {
        super();
        int i = -898407689;
        int i2 = 784923401;
        int i3 = 1;
        this.a = d;
        this.b = t2;
        this.c = t3;
        this.d = 0;
        this.e = interpolator4;
        this.f = interpolator5;
        this.g = f6;
        this.h = float7;
    }

    protected a(d d, T t2, T t3, Interpolator interpolator4, Interpolator interpolator5, Interpolator interpolator6, float f7, Float float8) {
        super();
        int i = -898407689;
        int i2 = 784923401;
        int i3 = 1;
        int i4 = 0;
        this.a = d;
        this.b = t2;
        this.c = t3;
        this.d = interpolator4;
        this.e = interpolator5;
        this.f = interpolator6;
        this.g = f7;
        this.h = float8;
    }

    public a(T t) {
        super();
        int i = -898407689;
        int i2 = 784923401;
        final int i4 = 0;
        this.a = i4;
        this.b = t;
        this.c = t;
        this.d = i4;
        this.e = i4;
        this.f = i4;
        this.g = 1;
        this.h = 340282350000000000000000000000000000000f;
    }

    public boolean a(float f) {
        int cmp;
        float obj2;
        if (Float.compare(f, f2) >= 0 && Float.compare(f, cmp) < 0) {
            obj2 = Float.compare(f, cmp) < 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public float b() {
        int cmp;
        int i;
        int i2;
        i = 1065353216;
        if (this.a == null) {
            return i;
        }
        if (Float.compare(f, i2) == 0) {
            if (this.h == null) {
                this.n = i;
            } else {
                this.n = f2 += i;
            }
        }
        return this.n;
    }

    public float c() {
        int floatValue;
        if (Float.compare(f, i) == 0) {
            this.j = (Float)this.c.floatValue();
        }
        return this.j;
    }

    public int d() {
        int intValue;
        if (this.l == 784923401) {
            this.l = (Integer)this.c.intValue();
        }
        return this.l;
    }

    public float e() {
        d dVar;
        int cmp;
        dVar = this.a;
        if (dVar == null) {
            return 0;
        }
        if (Float.compare(f3, i3) == 0) {
            this.m = i2 /= dVar;
        }
        return this.m;
    }

    public float f() {
        int floatValue;
        if (Float.compare(f, i) == 0) {
            this.i = (Float)this.b.floatValue();
        }
        return this.i;
    }

    public int g() {
        int intValue;
        if (this.k == 784923401) {
            this.k = (Integer)this.b.intValue();
        }
        return this.k;
    }

    public boolean h() {
        int i;
        Interpolator interpolator;
        if (this.d == null && this.e == null && this.f == null) {
            if (this.e == null) {
                i = this.f == null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Keyframe{startValue=");
        stringBuilder.append(this.b);
        stringBuilder.append(", endValue=");
        stringBuilder.append(this.c);
        stringBuilder.append(", startFrame=");
        stringBuilder.append(this.g);
        stringBuilder.append(", endFrame=");
        stringBuilder.append(this.h);
        stringBuilder.append(", interpolator=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
