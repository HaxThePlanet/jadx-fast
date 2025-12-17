package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class z implements com.google.android.exoplayer2.l2.v.e0 {

    private final com.google.android.exoplayer2.l2.v.y a;
    private final d0 b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    public z(com.google.android.exoplayer2.l2.v.y y) {
        super();
        this.a = y;
        d0 obj2 = new d0(32);
        this.b = obj2;
    }

    @Override // com.google.android.exoplayer2.l2.v.e0
    public void a(m0 m0, k k2, com.google.android.exoplayer2.l2.v.e0.d e0$d3) {
        this.a.a(m0, k2, d3);
        this.f = true;
    }

    @Override // com.google.android.exoplayer2.l2.v.e0
    public void b(d0 d0, int i2) {
        int i5;
        boolean z;
        int i3;
        int i4;
        int i;
        int obj8;
        final int i6 = 1;
        final int i7 = 0;
        obj8 = i2 &= i6 != 0 ? i6 : i7;
        final int i8 = -1;
        if (obj8 != null) {
            i22 += i5;
        } else {
            i4 = i8;
        }
        if (this.f && obj8 == null) {
            if (obj8 == null) {
            }
            this.f = i7;
            d0.I(i4);
            this.d = i7;
        }
        while (d0.a() > 0) {
            obj8 = this.d;
            z = true;
            obj8 = Math.min(d0.a(), i10 -= i21);
            d0.j(this.b.d(), this.d, obj8);
            i12 += obj8;
            this.d = z;
            obj8 = this.c;
            this.b.H(obj8);
            this.b.I(i7);
            this.a.b(this.b);
            this.d = i7;
            this.b.H(i14 += -4);
            obj8 = Math.min(d0.a(), i15 - 3);
            d0.j(this.b.d(), this.d, obj8);
            i17 += obj8;
            this.d = i4;
            if (i4 == z) {
            }
            this.b.I(i7);
            this.b.H(z);
            this.b.J(i6);
            obj8 = this.b.x();
            if (obj8 & 128 != 0) {
            } else {
            }
            i = i7;
            this.e = i;
            this.c = obj8 += z;
            z = this.c;
            if (this.b.b() < z) {
            }
            this.b.c(Math.min(4098, Math.max(z, i18 *= 2)));
            i = i6;
            d0.I(i19 -= i6);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.e0
    public void c() {
        this.f = true;
    }
}
