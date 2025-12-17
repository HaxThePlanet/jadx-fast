package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.l2.f;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.k.h;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p0;
import com.google.common.base.b;
import com.google.common.collect.v;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.AbstractCollection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
final class m extends d {

    private static final AtomicInteger L;
    private final boolean A;
    private final boolean B;
    private com.google.android.exoplayer2.source.hls.n C;
    private com.google.android.exoplayer2.source.hls.q D;
    private int E;
    private boolean F;
    private volatile boolean G;
    private boolean H;
    private v<Integer> I;
    private boolean J;
    private boolean K;
    public final int k;
    public final int l;
    public final Uri m;
    public final boolean n;
    public final int o;
    private final l p;
    private final n q;
    private final com.google.android.exoplayer2.source.hls.n r;
    private final boolean s;
    private final boolean t;
    private final m0 u;
    private final com.google.android.exoplayer2.source.hls.k v;
    private final List<i1> w;
    private final t x;
    private final h y;
    private final d0 z;
    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        m.L = atomicInteger;
    }

    private m(com.google.android.exoplayer2.source.hls.k k, l l2, n n3, i1 i14, boolean z5, l l6, n n7, boolean z8, Uri uri9, List<i1> list10, int i11, Object object12, long l13, long l14, long l15, int i16, boolean z17, int i18, boolean z19, boolean z20, m0 m021, t t22, com.google.android.exoplayer2.source.hls.n n23, h h24, d0 d025, boolean z26) {
        int i;
        final Object obj4 = this;
        final n nVar3 = n7;
        super(l2, n3, i14, i11, object12, l13, obj7, l15, obj9, z17, obj11);
        obj4.A = z5;
        obj4.o = z19;
        obj4.K = z20;
        obj4.l = m021;
        obj4.q = nVar3;
        obj4.p = l6;
        i = nVar3 != null ? 1 : 0;
        obj4.F = i;
        obj4.B = z8;
        obj4.m = uri9;
        obj4.s = n23;
        obj4.u = h24;
        obj4.t = t22;
        obj4.v = k;
        obj4.w = list10;
        obj4.x = d025;
        obj4.r = z26;
        obj4.y = obj41;
        obj4.z = obj42;
        obj4.n = obj43;
        obj4.I = v.z();
        obj4.k = m.L.getAndIncrement();
    }

    private static l h(l l, byte[] b2Arr2, byte[] b3Arr3) {
        if (b2Arr2 != null) {
            g.e(b3Arr3);
            d dVar = new d(l, b2Arr2, b3Arr3);
            return dVar;
        }
        return l;
    }

    public static com.google.android.exoplayer2.source.hls.m i(com.google.android.exoplayer2.source.hls.k k, l l2, i1 i13, long l4, g g5, com.google.android.exoplayer2.source.hls.i.e i$e6, Uri uri7, List<i1> list8, int i9, Object object10, boolean z11, com.google.android.exoplayer2.source.hls.s s12, com.google.android.exoplayer2.source.hls.m m13, byte[] b14Arr14, byte[] b15Arr15, boolean z16) {
        int i8;
        Object hVar;
        int i;
        int nVar2;
        String str;
        d0 d0Var;
        n equals2;
        int i5;
        int i2;
        boolean equals;
        int i12;
        long l;
        int i10;
        Uri uri;
        int i3;
        n nVar;
        int i4;
        long l3;
        long l5;
        int i6;
        int i7;
        int i11;
        h hVar2;
        d0 d0Var2;
        int obj54;
        l lVar = l2;
        Object obj = e6;
        Object obj2 = uri7;
        hVar = b14Arr14;
        byte[] bArr = b15Arr15;
        final byte[] bArr2 = z16;
        com.google.android.exoplayer2.source.hls.playlist.g.e eVar = obj2.a;
        n.b bVar = new n.b();
        str = eVar.a;
        bVar.i(o0.d(obj.a, str));
        bVar.h(eVar.A);
        bVar.g(eVar.B);
        i = obj2.d ? 8 : 0;
        bVar.b(i);
        int i18 = 1;
        i10 = bArr != null ? i18 : 0;
        if (i10 != 0) {
            String str4 = eVar.z;
            g.e(str4);
            i5 = m.k(str4);
        } else {
            i5 = 0;
        }
        com.google.android.exoplayer2.source.hls.playlist.g.d dVar = eVar.b;
        if (dVar != null) {
            i5 = bArr2 != null ? i18 : 0;
            if (i5 != 0) {
                String str5 = dVar.z;
                g.e(str5);
                i12 = m.k(str5);
            } else {
                i12 = 0;
            }
            i6 = i10;
            super(o0.d(obj.a, dVar.a), dVar.A, obj20, dVar.B, obj22);
            i8 = m.h(lVar, bArr2, i12);
            i4 = obj54;
        } else {
            i6 = i10;
            i8 = 0;
            nVar2 = 0;
            i4 = 0;
        }
        l6 += l4;
        i14 += i19;
        if (hVar != null) {
            equals2 = hVar.q;
            if (nVar2 != equals2) {
                if (nVar2 != 0 && equals2 != null && nVar2.a.equals(equals2.a) && Long.compare(l12, l) == 0) {
                    if (equals2 != null) {
                        if (nVar2.a.equals(equals2.a)) {
                            if (Long.compare(l12, l) == 0) {
                                d0Var = i18;
                            } else {
                                d0Var = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (list8.equals(hVar.m) && hVar.H) {
                i7 = hVar.H ? i18 : 0;
            } else {
            }
            if (d0Var != 0 && i7 != 0 && !hVar.J && hVar.l == i15) {
                if (i7 != 0) {
                    if (!hVar.J) {
                        i3 = hVar.l == i15 ? hVar : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            hVar2 = i2;
            d0Var2 = i12;
            i11 = i3;
        } else {
            uri = list8;
            hVar = new h();
            d0Var = new d0(10);
            hVar2 = hVar;
            d0Var2 = d0Var;
            i11 = 0;
        }
        super(k, m.h(lVar, bArr, i5), bVar.a(), i13, i6, i8, nVar2, i4, list8, i9, object10, z11, i17, i7, i17 + l10, obj26, obj2.b, obj28, obj2.c, z ^ 1, i15, eVar.C, s12, m13.a(i15), eVar.x, i11, hVar2, d0Var2, obj56);
        return mVar;
    }

    @RequiresNonNull("output")
    private void j(l l, n n2, boolean z3) {
        int i;
        long position;
        long i1Var;
        long obj5;
        Object obj6;
        i = 0;
        if (z3) {
            if (this.E != 0) {
                i = obj6;
            }
            obj6 = n2;
        } else {
            obj6 = n2.e((long)obj6);
        }
        obj6 = u(l, obj6);
        if (i != 0) {
            obj6.j(this.E);
        }
        while (!this.G) {
            if (this.C.d(obj6) != 0) {
            }
        }
        position = obj6.getPosition();
        obj5 = n2.f;
        this.E = (int)i2;
        p0.l(l);
    }

    private static byte[] k(String string) {
        boolean startsWith;
        int i;
        String obj4;
        if (b.c(string).startsWith("0x")) {
            obj4 = string.substring(2);
        }
        int i2 = 16;
        BigInteger bigInteger = new BigInteger(obj4, i2);
        obj4 = bigInteger.toByteArray();
        byte[] bArr = new byte[i2];
        i = obj4.length > i2 ? length2 - i2 : 0;
        System.arraycopy(obj4, i, bArr, i3 += i, length4 -= i);
        return bArr;
    }

    private static boolean o(com.google.android.exoplayer2.source.hls.i.e i$e, g g2) {
        int obj2;
        com.google.android.exoplayer2.source.hls.playlist.g.e eVar = e.a;
        if (eVar instanceof g.b) {
            if (!eVar.D) {
                if (e.c == 0 && g2.c) {
                    if (g2.c) {
                        obj2 = 1;
                    } else {
                        obj2 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }
        return g2.c;
    }

    @RequiresNonNull("output")
    private void r() {
        try {
            this.u.h(this.s, this.g);
            j(this.i, this.b, this.A);
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            throw interruptedIOException;
        }
    }

    @RequiresNonNull("output")
    private void s() {
        if (!this.F) {
        }
        g.e(this.p);
        g.e(this.q);
        j(this.p, this.q, this.B);
        int i = 0;
        this.E = i;
        this.F = i;
    }

    private long t(j j) {
        int i;
        int i2;
        byte[] bArr;
        int equals;
        d0 str;
        j.i();
        long l = -9223372036854775807L;
        int i8 = 10;
        this.z.E(i8);
        final int i9 = 0;
        j.m(this.z.d(), i9, i8);
        if (this.z.A() != 4801587) {
            return l;
        }
        this.z.J(3);
        int i6 = this.z.w();
        i2 = i6 + 10;
        if (i2 > this.z.b()) {
            this.z.E(i2);
            System.arraycopy(this.z.d(), i9, this.z.d(), i9, i8);
        }
        j.m(this.z.d(), i8, i6);
        a obj9 = this.y.d(this.z.d(), i6);
        if (obj9 == null) {
            return l;
        }
        i = i9;
        while (i < obj9.d()) {
            bArr = obj9.c(i);
            i++;
        }
        return l;
    }

    @EnsuresNonNull("extractor")
    @RequiresNonNull("output")
    private f u(l l, n n2) {
        Object obj;
        com.google.android.exoplayer2.source.hls.n nVar2;
        com.google.android.exoplayer2.source.hls.q qVar;
        Object nVar;
        int i;
        long cmp;
        com.google.android.exoplayer2.source.hls.k kVar;
        Uri uri;
        i1 i1Var;
        List list;
        m0 m0Var;
        java.util.Map map;
        f fVar;
        final Object obj2 = this;
        obj = n2;
        final com.google.android.exoplayer2.upstream.i iVar = l;
        super(iVar, obj.f, obj5, l.c(n2), obj7);
        if (obj2.C == null) {
            long l2 = obj2.t(fVar3);
            fVar3.i();
            cmp = obj2.r;
            if (cmp != null) {
                nVar2 = cmp.f();
            } else {
                nVar2 = obj2.v.a(obj.a, obj2.d, obj2.w, obj2.u, l.h(), fVar3);
            }
            obj2.C = nVar2;
            if (nVar2.c()) {
                if (Long.compare(l2, l3) != 0) {
                    i = obj2.u.b(l2);
                } else {
                    i = obj2.g;
                }
                obj2.D.m0(i);
            } else {
                obj2.D.m0(0);
            }
            obj2.D.Y();
            obj2.C.a(obj2.D);
        }
        obj2.D.j0(obj2.x);
        return fVar3;
    }

    public static boolean w(com.google.android.exoplayer2.source.hls.m m, Uri uri2, g g3, com.google.android.exoplayer2.source.hls.i.e i$e4, long l5) {
        int i;
        Object obj3;
        boolean obj4;
        i = 0;
        if (m == null) {
            return i;
        }
        if (uri2.equals(m.m) && m.H) {
            if (m.H) {
                return i;
            }
        }
        if (m.o(e4, g3)) {
            if (Long.compare(obj7, obj3) < 0) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public void a() {
        com.google.android.exoplayer2.source.hls.n nVar;
        boolean z;
        g.e(this.D);
        nVar = this.r;
        if (this.C == null && nVar != null && nVar.e()) {
            nVar = this.r;
            if (nVar != null) {
                if (nVar.e()) {
                    this.C = this.r;
                    this.F = false;
                }
            }
        }
        s();
        if (!this.G && !this.t) {
            if (!this.t) {
                r();
            }
            this.H = z3 ^= 1;
        }
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public void b() {
        this.G = true;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public int l(int i) {
        g.f(z ^= 1);
        if (i >= this.I.size()) {
            return 0;
        }
        return (Integer)this.I.get(i).intValue();
    }

    public void m(com.google.android.exoplayer2.source.hls.q q, v<Integer> v2) {
        this.D = q;
        this.I = v2;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public void n() {
        this.J = true;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public boolean p() {
        return this.H;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public boolean q() {
        return this.K;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public void v() {
        this.K = true;
    }
}
