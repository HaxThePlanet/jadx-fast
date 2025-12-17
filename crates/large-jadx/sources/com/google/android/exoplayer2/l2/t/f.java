package com.google.android.exoplayer2.l2.t;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.audio.b0.a;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.h;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.n;
import com.google.android.exoplayer2.l2.o;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.k.h.a;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import java.io.EOFException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class f implements i {

    private static final h.a u;
    private final int a;
    private final long b;
    private final d0 c;
    private final b0.a d;
    private final n e;
    private final o f;
    private final s g;
    private k h;
    private s i;
    private s j;
    private int k;
    private a l;
    private long m;
    private long n;
    private long o;
    private int p;
    private com.google.android.exoplayer2.l2.t.g q;
    private boolean r;
    private boolean s;
    private long t;
    static {
        com.google.android.exoplayer2.l2.t.a aVar = a.a;
        f.u = b.a;
    }

    public f() {
        super(0);
    }

    public f(int i) {
        super(i, -9223372036854775807L, obj1);
    }

    public f(int i, long l2) {
        super();
        this.a = i;
        this.b = l2;
        d0 obj1 = new d0(10);
        this.c = obj1;
        obj1 = new b0.a();
        this.d = obj1;
        obj1 = new n();
        this.e = obj1;
        this.m = -9223372036854775807L;
        obj1 = new o();
        this.f = obj1;
        obj1 = new h();
        this.g = obj1;
        this.j = obj1;
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void e() {
        g.h(this.i);
        p0.i(this.h);
    }

    private com.google.android.exoplayer2.l2.t.g f(j j) {
        long l2;
        com.google.android.exoplayer2.l2.t.d dVar2;
        com.google.android.exoplayer2.l2.t.e eVar;
        int durationUs;
        com.google.android.exoplayer2.l2.t.d dVar;
        long l;
        long position;
        int i;
        dVar2 = n(j);
        eVar = f.m(this.l, j.getPosition());
        if (this.r) {
            g.a obj12 = new g.a();
            return obj12;
        }
        if (i3 &= 2 != 0) {
            if (eVar != null) {
                durationUs = eVar.getDurationUs();
                l2 = eVar.a();
                i = l2;
                l = durationUs;
            } else {
            }
            super(l, obj6, j.getPosition(), obj8, i, obj10);
        } else {
            if (eVar != null) {
                dVar2 = eVar;
            } else {
                if (dVar2 != null) {
                } else {
                    dVar2 = durationUs;
                }
            }
        }
        if (dVar2 != null) {
            if (!dVar2.b() && i2 &= 1 != 0) {
                if (i2 &= 1 != 0) {
                    dVar2 = h(j);
                }
            }
        } else {
        }
        return dVar2;
    }

    private long g(long l) {
        return l2 += obj5;
    }

    private com.google.android.exoplayer2.l2.t.g h(j j) {
        int i = 0;
        j.m(this.c.d(), i, 4);
        this.c.I(i);
        this.d.a(this.c.n());
        super(j.getLength(), obj4, j.getPosition(), obj6, this.d);
        return cVar;
    }

    private static long i(a a) {
        int i;
        int i2;
        com.google.android.exoplayer2.m2.a.b bVar;
        boolean equals;
        String str;
        if (a != null) {
            i2 = 0;
            while (i2 < a.d()) {
                bVar = a.c(i2);
                i2++;
            }
        }
        return -9223372036854775807L;
    }

    private static int j(d0 d0, int i2) {
        int i;
        int obj2;
        int obj3;
        d0.I(i2);
        obj3 = d0.n();
        if (d0.f() >= i2 + 4 && obj3 != 1483304551 && obj3 == 1231971951) {
            d0.I(i2);
            obj3 = d0.n();
            if (obj3 != 1483304551) {
                if (obj3 == 1231971951) {
                }
            }
            return obj3;
        }
        d0.I(36);
        obj3 = 1447187017;
        if (d0.f() >= 40 && d0.n() == obj3) {
            d0.I(36);
            obj3 = 1447187017;
            if (d0.n() == obj3) {
                return obj3;
            }
        }
        return 0;
    }

    private static boolean k(int i, long l2) {
        int obj4;
        obj4 = Long.compare(l, obj4) == 0 ? 1 : 0;
        return obj4;
    }

    static boolean l(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int obj3;
        int obj4;
        final int i7 = 2;
        final int i8 = 77;
        if (i2 == 67 && i3 == 79 && i4 == i8) {
            if (i3 == 79) {
                if (i4 == i8) {
                    if (i5 != i8 && i != i7) {
                        if (i != i7) {
                            obj4 = 76;
                            if (i2 == i8 && i3 == obj4 && i4 == obj4) {
                                obj4 = 76;
                                if (i3 == obj4) {
                                    if (i4 == obj4) {
                                        if (i5 != 84) {
                                            obj3 = i == i7 ? 1 : 0;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private static com.google.android.exoplayer2.l2.t.e m(a a, long l2) {
        int i;
        int i2;
        com.google.android.exoplayer2.m2.a.b bVar;
        boolean z;
        if (a != null) {
            i2 = 0;
            while (i2 < a.d()) {
                bVar = a.c(i2);
                i2++;
            }
        }
        return null;
    }

    private com.google.android.exoplayer2.l2.t.g n(j j) {
        int i3;
        com.google.android.exoplayer2.l2.t.i iVar;
        int i4;
        long position;
        int i;
        b0.a aVar;
        int i2;
        d0 d0Var4 = new d0(aVar2.c);
        final int i11 = 0;
        j.m(d0Var4.d(), i11, aVar4.c);
        b0.a aVar3 = this.d;
        position = 1;
        i9 &= position;
        i = 21;
        if (i4 != 0) {
            if (aVar3.e != position) {
                i = 36;
            }
        } else {
            if (aVar3.e != position) {
            } else {
                i = 13;
            }
        }
        i2 = i;
        final int i12 = f.j(d0Var4, i2);
        final int i13 = 1231971951;
        if (i12 != 1483304551) {
            if (i12 == i13) {
                iVar = i.d(j.getLength(), i4, j.getPosition(), i);
                if (iVar != null && !this.e.a()) {
                    if (!this.e.a()) {
                        j.i();
                        j.g(i2 += 141);
                        j.m(this.c.d(), i11, 3);
                        this.c.I(i11);
                        this.e.d(this.c.A());
                    }
                }
                j.j(aVar5.c);
                if (iVar != null && !iVar.b() && i12 == i13) {
                    if (!iVar.b()) {
                        if (i12 == i13) {
                            return h(j);
                        }
                    }
                }
            } else {
                if (i12 == 1447187017) {
                    iVar = h.d(j.getLength(), i4, j.getPosition(), i);
                    j.j(aVar6.c);
                } else {
                    iVar = 0;
                    j.i();
                }
            }
        } else {
        }
        return iVar;
    }

    private boolean o(j j) {
        com.google.android.exoplayer2.l2.t.g cmp;
        long l;
        int i2;
        int i;
        cmp = this.q;
        final int i3 = 1;
        l = cmp.a();
        if (cmp != null && Long.compare(l, i2) != 0 && Long.compare(i2, l) > 0) {
            l = cmp.a();
            if (Long.compare(l, i2) != 0) {
                if (Long.compare(i2, l) > 0) {
                    return i3;
                }
            }
        }
        return obj9 ^= i3;
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int p(j j) {
        int i;
        int position;
        com.google.android.exoplayer2.i1 i1Var;
        int i2;
        int cmp;
        if (this.k == 0) {
            r(j, false);
        }
        if (this.q == null) {
            com.google.android.exoplayer2.l2.t.g gVar2 = f(j);
            this.q = gVar2;
            this.h.d(gVar2);
            i1.b bVar = new i1.b();
            bVar.e0(aVar.b);
            bVar.W(4096);
            bVar.H(aVar2.e);
            bVar.f0(aVar3.d);
            bVar.M(nVar.a);
            bVar.N(nVar2.b);
            if (i8 &= 4 != 0) {
                try {
                    i2 = 0;
                    i2 = this.l;
                    bVar.X(i2);
                    this.j.e(bVar.E());
                    this.o = j.getPosition();
                }
            } else {
            }
        } else {
            position = j.getPosition();
            i2 = this.o;
            if (Long.compare(l, i2) != 0 && Long.compare(position, i2) < 0) {
                position = j.getPosition();
                i2 = this.o;
                if (Long.compare(position, i2) < 0) {
                    j.j((int)i2);
                }
            }
        }
        return q(j);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int q(j j) {
        int i2;
        int cmp;
        com.google.android.exoplayer2.l2.t.g gVar;
        long l4;
        boolean z;
        long l2;
        long l3;
        int i;
        int i3;
        long l;
        final int i10 = 1;
        final int i11 = -1;
        final int i12 = 0;
        j.i();
        if (this.p == 0 && o(j)) {
            j.i();
            if (o(j)) {
                return i11;
            }
            this.c.I(i12);
            int i7 = this.c.n();
            if (f.k(i7, (long)i14) && b0.j(i7) == i11) {
                if (b0.j(i7) == i11) {
                }
                this.d.a(i7);
                l3 = -9223372036854775807L;
                this.m = this.q.c(j.getPosition());
                if (Long.compare(l4, l3) == 0 && Long.compare(l4, l3) != 0) {
                    this.m = this.q.c(j.getPosition());
                    if (Long.compare(l4, l3) != 0) {
                        this.m = l12 += i3;
                    }
                }
                i2 = this.d;
                this.p = i2.c;
                gVar = this.q;
                (d)gVar.e(g(l11 += l13), l3);
                if (gVar instanceof d && this.s && gVar.d(this.t)) {
                    (d)gVar.e(g(l11 += l13), l3);
                    if (this.s) {
                        if (gVar.d(this.t)) {
                            this.s = i12;
                            this.j = this.i;
                        }
                    }
                }
            }
            j.j(i10);
            this.k = i12;
            return i12;
        }
        int obj12 = this.j.b(j, this.p, i10);
        if (obj12 == i11) {
            return i11;
        }
        i4 -= obj12;
        this.p = i5;
        if (i5 > 0) {
            return i12;
        }
        this.j.d(g(this.n), l3, 1, obj12.c, 0);
        this.n = l6 += l7;
        this.p = i12;
        return i12;
    }

    private boolean r(j j, boolean z2) {
        int i;
        int i3;
        h.a aVar;
        int i2;
        Object oVar;
        int i7;
        int i5;
        int i6;
        int i4;
        boolean z;
        long l;
        i = z2 ? 32768 : 131072;
        j.i();
        final int i10 = 0;
        int i12 = 4;
        final int i13 = 1;
        final int i14 = 0;
        if (Long.compare(position, i11) == 0) {
            i3 = i8 &= i12 == 0 ? i13 : i14;
            aVar = i3 != 0 ? i10 : f.u;
            a aVar2 = this.f.a(j, aVar);
            this.l = aVar2;
            if (aVar2 != null) {
                this.e.c(aVar2);
            }
            if (!z2) {
                j.j((int)l2);
            }
            i7 = i14;
        } else {
            i7 = i2;
        }
        i6 = i5;
        while (o(j)) {
            this.c.I(i14);
            i4 = this.c.n();
            z = b0.j(i4);
            i5++;
            j.g(z += -4);
            this.d.a(i4);
            i7 = i4;
            int i15 = i6 + 1;
            if (z2) {
            } else {
            }
            j.j(i13);
            i6 = i15;
            i7 = i5;
            j.i();
            j.g(i2 + i15);
        }
        if (i5 <= 0) {
        } else {
            if (z2) {
                j.j(i2 += i6);
            } else {
                j.i();
            }
            this.k = i7;
            return i13;
        }
        EOFException obj13 = new EOFException();
        throw obj13;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void a(k k) {
        this.h = k;
        s obj3 = k.t(0, 1);
        this.i = obj3;
        this.j = obj3;
        this.h.n();
    }

    @Override // com.google.android.exoplayer2.l2.i
    public boolean b(j j) {
        return r(j, true);
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        long l;
        long durationUs;
        int obj6;
        e();
        final int obj5 = p(j);
        l = g(this.n);
        if (obj5 == -1 && obj6 instanceof d && Long.compare(durationUs, l) != 0) {
            if (obj6 instanceof d) {
                l = g(this.n);
                if (Long.compare(durationUs, l) != 0) {
                    (d)this.q.f(l);
                    this.h.d(this.q);
                }
            }
        }
        return obj5;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void d(long l, long l2) {
        com.google.android.exoplayer2.l2.t.g obj3;
        obj3 = 0;
        this.k = obj3;
        this.m = -9223372036854775807L;
        this.n = 0;
        this.p = obj3;
        this.t = obj5;
        obj3 = this.q;
        if (obj3 instanceof d && !(d)obj3.d(obj5)) {
            if (!(d)obj3.d(obj5)) {
                this.s = true;
                this.j = this.g;
            }
        }
    }
}
