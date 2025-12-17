package com.google.android.material.bottomappbar;

import f.c.a.e.d0.f;
import f.c.a.e.d0.m;

/* loaded from: classes2.dex */
public class a extends f implements java.lang.Cloneable {

    private float a;
    private float b;
    private float c;
    private float v;
    private float w;
    private float x;
    @Override // f.c.a.e.d0.f
    public void b(float f, float f2, float f3, m m4) {
        int i5;
        int i11;
        Object obj4;
        float cmp;
        int i;
        int f4;
        int i8;
        int i6;
        int i4;
        int i3;
        int i7;
        int i9;
        int i10;
        int i2;
        int i12;
        final Object obj = this;
        final float f5 = f;
        final Object obj6 = m4;
        cmp = obj.c;
        final int i66 = 0;
        if (Float.compare(cmp, i66) == 0) {
            obj6.m(f5, i66);
        }
        final int i67 = 1073741824;
        final int i68 = i18 / i67;
        final int i69 = f3 * f10;
        final int i70 = f2 + f11;
        int i35 = 1065353216;
        i19 += i46;
        if (Float.compare(i47, i35) >= 0) {
            obj6.m(f5, i66);
        }
        f4 = obj.x;
        final int i71 = f4 * f3;
        if (Float.compare(f4, i48) != 0) {
            if (Float.compare(f8, f4) < 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
        } else {
        }
        i9 = i5;
        if (i9 == 0) {
            i11 = 1071644672;
            i10 = i66;
        } else {
            i10 = i20;
            i11 = i66;
        }
        int i21 = i68 + i69;
        int i36 = i10 + i69;
        float f13 = (float)sqrt;
        int i50 = i70 - f13;
        final int i73 = i70 + f13;
        float f15 = (float)degrees;
        i2 = i26 + i11;
        obj6.m(i50, i66);
        final int i74 = i69 * i67;
        final float f17 = f15;
        m4.a(i50 - i69, 0, i50 += i69, i74, 1132920832, f15);
        int i13 = 1127481344;
        if (i9 != 0) {
            m4.a(i70 - i68, i42 -= i10, i70 + i68, i68 - i10, i13 - i2, i2 - i13);
        } else {
            float f14 = obj.b;
            int i72 = i71 * i67;
            int i52 = i70 - i68;
            m4.a(i52, -i56, i52 + i38, f14 + i71, i13 - i2, i29 / i67);
            i6 = i70 + i68;
            float f6 = obj.b;
            obj6.m(i6 - i32, f6 += i71);
            float f7 = obj.b;
            m4.a(i6 - i9, -i40, i6, f7 + i71, 1119092736, i2 + i15);
        }
        m4.a(i73 - i69, 0, i73 + i69, i74, i16 - f17, f17);
        obj6.m(f5, i66);
    }

    @Override // f.c.a.e.d0.f
    float c() {
        return this.v;
    }

    @Override // f.c.a.e.d0.f
    public float d() {
        return this.x;
    }

    @Override // f.c.a.e.d0.f
    float e() {
        return this.b;
    }

    @Override // f.c.a.e.d0.f
    float f() {
        return this.a;
    }

    @Override // f.c.a.e.d0.f
    public float g() {
        return this.c;
    }

    @Override // f.c.a.e.d0.f
    void h(float f) {
        if (Float.compare(f, i) < 0) {
        } else {
            this.v = f;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("cradleVerticalOffset must be positive.");
        throw obj2;
    }

    @Override // f.c.a.e.d0.f
    public void j(float f) {
        this.x = f;
    }

    @Override // f.c.a.e.d0.f
    void k(float f) {
        this.b = f;
    }

    @Override // f.c.a.e.d0.f
    void l(float f) {
        this.a = f;
    }

    @Override // f.c.a.e.d0.f
    public void m(float f) {
        this.c = f;
    }

    @Override // f.c.a.e.d0.f
    void n(float f) {
        this.w = f;
    }
}
