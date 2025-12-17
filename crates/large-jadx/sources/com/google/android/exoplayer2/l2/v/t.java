package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class t implements com.google.android.exoplayer2.l2.v.n {

    private final String a;
    private final d0 b;
    private final c0 c;
    private s d;
    private String e;
    private i1 f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k = -9223372036854775807L;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;
    public t(String string) {
        super();
        this.a = string;
        d0 obj3 = new d0(1024);
        this.b = obj3;
        c0 c0Var = new c0(obj3.d());
        this.c = c0Var;
        long l = -9223372036854775807L;
    }

    private static long a(c0 c0) {
        return (long)obj2;
    }

    @RequiresNonNull("output")
    private void g(c0 c0) {
        boolean z;
        boolean z2;
        if (!c0.g()) {
            this.l = true;
            l(c0);
        } else {
            if (!this.l) {
            }
        }
        final int i4 = 0;
        if (this.m != 0) {
        } else {
            if (this.n != 0) {
            } else {
                k(c0, j(c0));
                if (this.p) {
                    c0.q((int)l);
                }
            }
            throw ParserException.a(i4, i4);
        }
        throw ParserException.a(i4, i4);
    }

    private int h(c0 c0) {
        com.google.android.exoplayer2.audio.m.b bVar = m.e(c0, true);
        this.u = bVar.c;
        this.r = bVar.a;
        this.t = bVar.b;
        return i -= obj4;
    }

    private void i(c0 c0) {
        int i2;
        int i;
        int i3;
        i2 = 3;
        final int i4 = c0.h(i2);
        this.o = i4;
        if (i4 != 0) {
            i = 1;
            if (i4 != i) {
                i3 = 6;
                if (i4 != i2 && i4 != 4 && i4 != 5) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            if (i4 != i3) {
                                if (i4 != 7) {
                                } else {
                                }
                                IllegalStateException obj5 = new IllegalStateException();
                                throw obj5;
                            }
                            c0.q(i);
                        } else {
                            c0.q(i3);
                        }
                    } else {
                    }
                } else {
                }
            } else {
                c0.q(9);
            }
        } else {
            c0.q(8);
        }
    }

    private int j(c0 c0) {
        int i;
        int i2;
        int i3;
        if (this.o != 0) {
        } else {
            i = 0;
            i2 = c0.h(8);
            while (i2 != 255) {
                i2 = c0.h(8);
            }
            return i += i2;
        }
        int obj4 = 0;
        throw ParserException.a(obj4, obj4);
    }

    @RequiresNonNull("output")
    private void k(c0 c0, int i2) {
        int i5;
        long l;
        int i6;
        int i;
        int i7;
        int i3;
        int i4;
        int i8;
        d0 obj9;
        int i9 = c0.e();
        if (i9 & 7 == 0) {
            this.b.I(i9 >>= 3);
        } else {
            i = 0;
            c0.i(this.b.d(), i, i2 * 8);
            this.b.I(i);
        }
        this.d.c(this.b, i2);
        long l2 = this.k;
        if (Long.compare(l2, l) != 0) {
            this.d.d(l2, obj3, 1, i2, 0);
            this.k = obj9 += l;
        }
    }

    @RequiresNonNull("output")
    private void l(c0 c0) {
        int i3;
        int i5;
        int i4;
        int i;
        int equals;
        int i2;
        int i6;
        long l;
        i3 = 1;
        i5 = c0.h(i3);
        int i8 = 0;
        if (i5 == i3) {
            i = c0.h(i3);
        } else {
            i = i8;
        }
        this.m = i;
        int i15 = 0;
        if (i != 0) {
        } else {
            if (i5 == i3) {
                t.a(c0);
            }
            if (!c0.g()) {
            } else {
                this.n = c0.h(6);
                if (c0.h(4) != 0) {
                } else {
                    if (c0.h(3) != 0) {
                    } else {
                        int i14 = 8;
                        if (i5 == 0) {
                            int i23 = h(c0);
                            c0.o(c0.e());
                            byte[] bArr = new byte[i17 /= i14];
                            c0.i(bArr, i8, i23);
                            i1.b bVar = new i1.b();
                            bVar.S(this.e);
                            bVar.e0("audio/mp4a-latm");
                            bVar.I(this.u);
                            bVar.H(this.t);
                            bVar.f0(this.r);
                            bVar.T(Collections.singletonList(bArr));
                            bVar.V(this.a);
                            i4 = bVar.E();
                            if (!i4.equals(this.f)) {
                                this.f = i4;
                                this.s = i19 /= l;
                                this.d.e(i4);
                            }
                        } else {
                            c0.q(i9 -= equals);
                        }
                        i(c0);
                        boolean z2 = c0.g();
                        this.p = z2;
                        this.q = 0;
                        if (z2 && i5 == i3) {
                            if (i5 == i3) {
                                this.q = t.a(c0);
                            }
                        }
                        if (c0.g()) {
                            c0.q(i14);
                        }
                    }
                }
                throw ParserException.a(i15, i15);
            }
            throw ParserException.a(i15, i15);
        }
        throw ParserException.a(i15, i15);
    }

    private void m(int i) {
        this.b.E(i);
        this.c.m(this.b.d());
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        s sVar;
        int i2;
        int length;
        int i;
        int i3;
        int i4;
        g.h(this.d);
        while (d0.a() > 0) {
            int i6 = this.g;
            i2 = 86;
            length = 1;
            if (d0.x() == i2) {
            }
            this.g = length;
            i = 2;
            i3 = 0;
            sVar = d0.x();
            if (sVar & 224 == 224) {
            } else {
            }
            if (sVar != i2) {
            }
            this.g = i3;
            this.j = sVar;
            this.g = i;
            i2 = 3;
            i9 |= i15;
            this.i = sVar;
            if (sVar > bArr2.length) {
            }
            this.h = i3;
            this.g = i2;
            m(this.i);
            int i11 = Math.min(d0.a(), i12 -= i16);
            d0.j(c0Var2.a, this.h, i11);
            i14 += i11;
            this.h = i2;
            if (i2 == this.i) {
            }
            this.c.o(i3);
            g(this.c);
            this.g = i3;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        final int i = 0;
        this.g = i;
        this.k = -9223372036854775807L;
        this.l = i;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.d = k.t(d2.c(), 1);
        this.e = d2.b();
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.k = l;
        }
    }
}
