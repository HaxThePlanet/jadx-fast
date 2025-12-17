package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.h;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class j implements com.google.android.exoplayer2.l2.v.n {

    private static final byte[] v;
    private final boolean a;
    private final c0 b;
    private final d0 c;
    private final String d;
    private String e;
    private s f;
    private s g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private s t;
    private long u;
    static {
        byte[] bArr = new byte[3];
        bArr = new byte[]{73, 68, 51};
        j.v = bArr;
    }

    public j(boolean z) {
        super(z, 0);
    }

    public j(boolean z, String string2) {
        super();
        c0 c0Var = new c0(new byte[7]);
        this.b = c0Var;
        d0 d0Var = new d0(Arrays.copyOf(j.v, 10));
        this.c = d0Var;
        s();
        int i = -1;
        this.m = i;
        this.n = i;
        long l = -9223372036854775807L;
        this.q = l;
        this.s = l;
        this.a = z;
        this.d = string2;
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void a() {
        g.e(this.f);
        p0.i(this.t);
        p0.i(this.g);
    }

    private void g(d0 d0) {
        boolean z;
        if (d0.a() == 0) {
        }
        c0Var.a[0] = d0.d()[d0.e()];
        this.b.o(2);
        int obj4 = this.b.h(4);
        int i4 = this.n;
        if (i4 != -1 && obj4 != i4) {
            if (obj4 != i4) {
                q();
            }
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = obj4;
        }
        t();
    }

    private boolean h(d0 d0, int i2) {
        int i4;
        int i;
        int i3;
        int obj9;
        d0.I(i2 + 1);
        i4 = 1;
        final int i8 = 0;
        if (!w(d0, c0Var.a, i4)) {
            return i8;
        }
        int i9 = 4;
        this.b.o(i9);
        int i6 = this.b.h(i4);
        int i13 = this.m;
        final int i18 = -1;
        if (i13 != i18 && i6 != i13) {
            if (i6 != i13) {
                return i8;
            }
        }
        final int i19 = 2;
        if (this.n != i18 && !w(d0, c0Var6.a, i4)) {
            if (!w(d0, c0Var6.a, i4)) {
                return i4;
            }
            this.b.o(i19);
            if (this.b.h(i9) != this.n) {
                return i8;
            }
            d0.I(i2 + 2);
        }
        if (!w(d0, c0Var9.a, i9)) {
            return i4;
        }
        this.b.o(14);
        int i10 = this.b.h(13);
        if (i10 < 7) {
            return i8;
        }
        byte[] bArr4 = d0.d();
        obj9 = d0.f();
        i2 += i10;
        if (obj10 >= obj9) {
            return i4;
        }
        obj10 += i4;
        if (bArr4[obj10] == i18 && obj10 == obj9) {
            obj10 += i4;
            if (obj10 == obj9) {
                return i4;
            }
            if (l(i18, bArr4[obj10]) && obj9 >>= 3 == i6) {
                if (obj9 >>= 3 == i6) {
                } else {
                    i4 = i8;
                }
            } else {
            }
            return i4;
        }
        if (bArr4[obj10] != 73) {
            return i8;
        }
        int i7 = obj10 + 1;
        if (i7 == obj9) {
            return i4;
        }
        if (bArr4[i7] != 68) {
            return i8;
        }
        obj10 += i19;
        if (obj10 == obj9) {
            return i4;
        }
        if (bArr4[obj10] == 51) {
        } else {
            i4 = i8;
        }
        return i4;
    }

    private boolean i(d0 d0, byte[] b2Arr2, int i3) {
        int obj3;
        int i2 = Math.min(d0.a(), i3 - i4);
        d0.j(b2Arr2, this.i, i2);
        obj3 += i2;
        this.i = obj3;
        obj3 = obj3 == i3 ? 1 : 0;
        return obj3;
    }

    private void j(d0 d0) {
        int i4;
        int i6;
        int i2;
        int i;
        int i3;
        boolean i8;
        int i5;
        int i7;
        i6 = d0.e();
        while (i6 < d0.f()) {
            i = i6 + 1;
            b &= 255;
            i5 = 512;
            i3 = this.j;
            i11 |= i3;
            this.j = 768;
            i6 = i;
            this.j = i5;
            this.j = 1024;
            i2 = 256;
            if (i3 != i2) {
            }
            this.j = i2;
            i--;
        }
        d0.I(i6);
    }

    private boolean l(byte b, byte b2) {
        return j.m(obj1 |= obj2);
    }

    public static boolean m(int i) {
        int obj1;
        obj1 = i &= i2 == 65520 ? 1 : 0;
        return obj1;
    }

    @RequiresNonNull("output")
    private void n() {
        Object obj;
        int i3;
        int i2;
        int i;
        s str;
        i1.b stringBuilder;
        long l;
        this.b.o(0);
        int i8 = 5;
        int i9 = 2;
        if (!this.p) {
            i = 1;
            i6 += i;
            if (i2 != i9) {
                stringBuilder = new StringBuilder(61);
                stringBuilder.append("Detected audio object type: ");
                stringBuilder.append(i2);
                stringBuilder.append(", but assuming AAC LC.");
                v.h("AdtsReader", stringBuilder.toString());
                i2 = i9;
            }
            this.b.q(i8);
            byte[] bArr = m.a(i2, this.n, this.b.h(3));
            com.google.android.exoplayer2.audio.m.b bVar = m.f(bArr);
            stringBuilder = new i1.b();
            stringBuilder.S(this.e);
            stringBuilder.e0("audio/mp4a-latm");
            stringBuilder.I(bVar.c);
            stringBuilder.H(bVar.b);
            stringBuilder.f0(bVar.a);
            stringBuilder.T(Collections.singletonList(bArr));
            stringBuilder.V(this.d);
            obj = stringBuilder.E();
            this.q = i14 /= l;
            this.f.e(obj);
            this.p = i;
        } else {
            this.b.q(10);
        }
        this.b.q(4);
        if (this.k) {
            i3 += -2;
        }
        this.v(this.f, this.q, str, 0);
    }

    @RequiresNonNull("id3Output")
    private void o() {
        this.g.c(this.c, 10);
        this.c.I(6);
        this.v(this.g, 0, obj6, 10);
    }

    @RequiresNonNull("currentOutput")
    private void p(d0 d0) {
        int i2;
        s sVar;
        int i;
        int i4;
        long l;
        int i3;
        int obj8;
        i = this.i;
        i2 = Math.min(d0.a(), i6 -= i);
        this.t.c(d0, i2);
        obj8 += i2;
        this.i = obj8;
        final int i8 = this.r;
        sVar = this.s;
        if (obj8 == i8 && Long.compare(sVar, l) != 0) {
            sVar = this.s;
            if (Long.compare(sVar, l) != 0) {
                this.t.d(sVar, i, 1, i8, 0);
                this.s = l2 += i;
            }
            s();
        }
    }

    private void q() {
        this.l = false;
        s();
    }

    private void r() {
        this.h = 1;
        this.i = 0;
    }

    private void s() {
        int i = 0;
        this.h = i;
        this.i = i;
        this.j = 256;
    }

    private void t() {
        this.h = 3;
        this.i = 0;
    }

    private void u() {
        this.h = 2;
        this.i = bArr.length;
        int i2 = 0;
        this.r = i2;
        this.c.I(i2);
    }

    private void v(s s, long l2, int i3, int i4) {
        this.h = 4;
        this.i = i4;
        this.t = s;
        this.u = l2;
        this.r = obj6;
    }

    private boolean w(d0 d0, byte[] b2Arr2, int i3) {
        final int i2 = 0;
        if (d0.a() < i3) {
            return i2;
        }
        d0.j(b2Arr2, i2, i3);
        return 1;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        boolean z;
        int i;
        int i2;
        a();
        while (d0.a() > 0) {
            z = this.h;
            j(d0);
            g(d0);
            if (i(d0, this.c.d(), 10)) {
            }
            o();
            if (this.k) {
            } else {
            }
            i = 5;
            if (i(d0, c0Var.a, i)) {
            }
            n();
            i = 7;
            p(d0);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        this.s = -9223372036854775807L;
        q();
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        i1.b bVar;
        int i;
        s obj3;
        com.google.android.exoplayer2.i1 obj4;
        d2.a();
        this.e = d2.b();
        s sVar = k.t(d2.c(), 1);
        this.f = sVar;
        this.t = sVar;
        if (this.a) {
            d2.a();
            obj3 = k.t(d2.c(), 5);
            this.g = obj3;
            bVar = new i1.b();
            bVar.S(d2.b());
            bVar.e0("application/id3");
            obj3.e(bVar.E());
        } else {
            obj3 = new h();
            this.g = obj3;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.s = l;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public long k() {
        return this.q;
    }
}
