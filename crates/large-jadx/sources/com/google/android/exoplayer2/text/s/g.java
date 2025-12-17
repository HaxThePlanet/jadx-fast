package com.google.android.exoplayer2.text.s;

import android.text.Layout.Alignment;

/* loaded from: classes2.dex */
final class g {

    private String a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k;
    private String l;
    private int m = -1;
    private int n = -1;
    private Layout.Alignment o;
    private Layout.Alignment p;
    private int q = -1;
    private com.google.android.exoplayer2.text.s.b r;
    private float s = 340282350000000000000000000000000000000f;
    public g() {
        super();
        int i = -1;
        int i2 = 2139095039;
    }

    private com.google.android.exoplayer2.text.s.g r(com.google.android.exoplayer2.text.s.g g, boolean z2) {
        int cmp;
        boolean z;
        int i7;
        int i3;
        String str;
        int i6;
        int i;
        int i9;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        int i8;
        int i2;
        com.google.android.exoplayer2.text.s.b bVar;
        int i5;
        int i4;
        Object obj4;
        int obj5;
        if (g != null && !this.c && g.c) {
            if (!this.c) {
                if (g.c) {
                    w(g.b);
                }
            }
            i5 = -1;
            if (this.h == i5) {
                this.h = g.h;
            }
            if (this.i == i5) {
                this.i = g.i;
            }
            str = g.a;
            if (this.a == null && str != null) {
                str = g.a;
                if (str != null) {
                    this.a = str;
                }
            }
            if (this.f == i5) {
                this.f = g.f;
            }
            if (this.g == i5) {
                this.g = g.g;
            }
            if (this.n == i5) {
                this.n = g.n;
            }
            alignment = g.o;
            if (this.o == null && alignment != null) {
                alignment = g.o;
                if (alignment != null) {
                    this.o = alignment;
                }
            }
            alignment2 = g.p;
            if (this.p == null && alignment2 != null) {
                alignment2 = g.p;
                if (alignment2 != null) {
                    this.p = alignment2;
                }
            }
            if (this.q == i5) {
                this.q = g.q;
            }
            if (this.j == i5) {
                this.j = g.j;
                this.k = g.k;
            }
            if (this.r == null) {
                this.r = g.r;
            }
            if (Float.compare(f, i4) == 0) {
                this.s = g.s;
            }
            if (z2 != 0 && !this.e && g.e) {
                if (!this.e) {
                    if (g.e) {
                        u(g.d);
                    }
                }
            }
            obj4 = g.m;
            if (z2 != 0 && this.m == i5 && obj4 != i5) {
                if (this.m == i5) {
                    obj4 = g.m;
                    if (obj4 != i5) {
                        this.m = obj4;
                    }
                }
            }
        }
        return this;
    }

    public com.google.android.exoplayer2.text.s.g A(String string) {
        this.l = string;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g B(boolean z) {
        this.i = z;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g C(boolean z) {
        this.f = z;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g D(Layout.Alignment layout$Alignment) {
        this.p = alignment;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g E(int i) {
        this.n = i;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g F(int i) {
        this.m = i;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g G(float f) {
        this.s = f;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g H(Layout.Alignment layout$Alignment) {
        this.o = alignment;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g I(boolean z) {
        this.q = z;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g J(com.google.android.exoplayer2.text.s.b b) {
        this.r = b;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g K(boolean z) {
        this.g = z;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g a(com.google.android.exoplayer2.text.s.g g) {
        r(g, true);
        return this;
    }

    public int b() {
        if (!this.e) {
        } else {
            return this.d;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Background color has not been defined.");
        throw illegalStateException;
    }

    public int c() {
        if (!this.c) {
        } else {
            return this.b;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Font color has not been defined.");
        throw illegalStateException;
    }

    public String d() {
        return this.a;
    }

    public float e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    public String g() {
        return this.l;
    }

    public Layout.Alignment h() {
        return this.p;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.m;
    }

    public float k() {
        return this.s;
    }

    public int l() {
        int i;
        int i3;
        int i2;
        int i4 = this.h;
        int i6 = -1;
        if (i4 == i6 && this.i == i6) {
            if (this.i == i6) {
                return i6;
            }
        }
        int i7 = 1;
        i = i4 == i7 ? i7 : i3;
        if (this.i == i7) {
            i3 = 2;
        }
        return i |= i3;
    }

    public Layout.Alignment m() {
        return this.o;
    }

    public boolean n() {
        int i;
        if (this.q == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public com.google.android.exoplayer2.text.s.b o() {
        return this.r;
    }

    public boolean p() {
        return this.e;
    }

    public boolean q() {
        return this.c;
    }

    public boolean s() {
        int i;
        if (this.f == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public boolean t() {
        int i;
        if (this.g == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public com.google.android.exoplayer2.text.s.g u(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g v(boolean z) {
        this.h = z;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g w(int i) {
        this.b = i;
        this.c = true;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g x(String string) {
        this.a = string;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g y(float f) {
        this.k = f;
        return this;
    }

    public com.google.android.exoplayer2.text.s.g z(int i) {
        this.j = i;
        return this;
    }
}
