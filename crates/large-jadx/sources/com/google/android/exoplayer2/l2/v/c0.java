package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
final class c0 {

    private final int a;
    private final m0 b;
    private final d0 c;
    private boolean d;
    private boolean e;
    private boolean f;
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    c0(int i) {
        super();
        this.a = i;
        m0 obj3 = new m0(0, obj1);
        this.b = obj3;
        long l = -9223372036854775807L;
        obj3 = new d0();
        this.c = obj3;
    }

    private int a(j j) {
        this.c.F(p0.f);
        this.d = true;
        j.i();
        return 0;
    }

    private int f(j j, p p2, int i3) {
        int i2 = (int)l2;
        final int i5 = 0;
        final long l3 = (long)i5;
        int i4 = 1;
        if (Long.compare(position, l3) != 0) {
            p2.a = l3;
            return i4;
        }
        this.c.E(i2);
        j.i();
        j.m(this.c.d(), i5, i2);
        this.g = g(this.c, i3);
        this.e = i4;
        return i5;
    }

    private long g(d0 d0, int i2) {
        int i3;
        long cmp;
        byte b;
        int i;
        i3 = d0.e();
        cmp = -9223372036854775807L;
        while (i3 < d0.f()) {
            b = f0.c(d0, i3, i2);
            i3++;
            cmp = -9223372036854775807L;
        }
        return cmp;
    }

    private int h(j j, p p2, int i3) {
        long length = j.getLength();
        int i5 = (int)l2;
        length -= l3;
        final int i6 = 1;
        if (Long.compare(position, i) != 0) {
            p2.a = i;
            return i6;
        }
        this.c.E(i5);
        j.i();
        int i2 = 0;
        j.m(this.c.d(), i2, i5);
        this.h = i(this.c, i3);
        this.f = i6;
        return i2;
    }

    private long i(d0 d0, int i2) {
        int i;
        long cmp;
        boolean z;
        final int i3 = d0.e();
        final int i4 = d0.f();
        i = i4 + -188;
        cmp = -9223372036854775807L;
        while (i >= i3) {
            z = f0.c(d0, i, i2);
            i--;
            cmp = -9223372036854775807L;
        }
        return cmp;
    }

    public long b() {
        return this.i;
    }

    public m0 c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e(j j, p p2, int i3) {
        int obj8;
        int obj9;
        if (i3 <= 0) {
            return a(j);
        }
        if (!this.f) {
            return h(j, p2, i3);
        }
        final long l3 = -9223372036854775807L;
        if (Long.compare(l, l3) == 0) {
            return a(j);
        }
        if (!this.e) {
            return f(j, p2, i3);
        }
        obj8 = this.g;
        if (Long.compare(obj8, l3) == 0) {
            return a(j);
        }
        l2 -= obj8;
        this.i = i;
        if (Long.compare(i, obj8) < 0) {
            obj9 = new StringBuilder(65);
            obj9.append("Invalid duration: ");
            obj9.append(i);
            obj9.append(". Using TIME_UNSET instead.");
            v.h("TsDurationReader", obj9.toString());
            this.i = l3;
        }
        return a(j);
    }
}
