package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.j2.h1;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.n2.k;
import com.google.android.exoplayer2.n2.n;
import com.google.android.exoplayer2.n2.o;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.source.h0.a;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.video.a0;
import com.google.common.collect.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
final class f1 extends com.google.android.exoplayer2.t0 implements com.google.android.exoplayer2.v1 {

    private h0 A;
    private com.google.android.exoplayer2.v1.b B;
    private com.google.android.exoplayer2.n1 C;
    private com.google.android.exoplayer2.t1 D;
    private int E;
    private int F;
    private long G;
    final o b;
    final com.google.android.exoplayer2.v1.b c;
    private final com.google.android.exoplayer2.z1[] d;
    private final n e;
    private final s f;
    private final com.google.android.exoplayer2.g1.f g;
    private final com.google.android.exoplayer2.g1 h;
    private final u<com.google.android.exoplayer2.v1.c> i;
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.e1> j;
    private final com.google.android.exoplayer2.g2.b k;
    private final List<com.google.android.exoplayer2.f1.a> l;
    private final boolean m;
    private final a0 n;
    private final h1 o;
    private final Looper p;
    private final g q;
    private final long r;
    private final long s;
    private final i t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z;

    private static final class a implements com.google.android.exoplayer2.r1 {

        private final Object a;
        private com.google.android.exoplayer2.g2 b;
        public a(Object object, com.google.android.exoplayer2.g2 g22) {
            super();
            this.a = object;
            this.b = g22;
        }

        static com.google.android.exoplayer2.g2 b(com.google.android.exoplayer2.f1.a f1$a, com.google.android.exoplayer2.g2 g22) {
            a.b = g22;
            return g22;
        }

        @Override // com.google.android.exoplayer2.r1
        public com.google.android.exoplayer2.g2 a() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.r1
        public Object getUid() {
            return this.a;
        }
    }
    public f1(com.google.android.exoplayer2.z1[] z1Arr, n n2, a0 a03, com.google.android.exoplayer2.l1 l14, g g5, h1 h16, boolean z7, com.google.android.exoplayer2.d2 d28, long l9, long l10, com.google.android.exoplayer2.k1 k111, long l12, boolean z13, i i14, Looper looper15, com.google.android.exoplayer2.v1 v116, com.google.android.exoplayer2.v1.b v1$b17) {
        int i;
        Object handler;
        Object obj = this;
        Object obj4 = z1Arr;
        g gVar = g5;
        h1 h1Var = h16;
        i iVar = b17;
        Looper looper = obj36;
        super();
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str5 = p0.e;
        StringBuilder stringBuilder = new StringBuilder(i6 += length4);
        stringBuilder.append("Init ");
        stringBuilder.append(hexString);
        stringBuilder.append(" [");
        stringBuilder.append("ExoPlayerLib/2.15.1");
        stringBuilder.append("] [");
        stringBuilder.append(str5);
        stringBuilder.append("]");
        v.f("ExoPlayerImpl", stringBuilder.toString());
        int i2 = 0;
        i = obj4.length > 0 ? 1 : i2;
        g.f(i);
        g.e(z1Arr);
        obj.d = (z1[])obj4;
        g.e(n2);
        obj.e = (n)n2;
        obj.n = a03;
        obj.q = gVar;
        obj.o = h1Var;
        obj.m = z7;
        obj.r = l9;
        obj.s = k111;
        obj.p = looper;
        obj.t = iVar;
        obj.u = i2;
        handler = obj37 != null ? obj37 : obj;
        n nVar = new n(handler);
        u uVar = new u(looper, iVar, nVar);
        obj.i = uVar;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        obj.j = copyOnWriteArraySet;
        ArrayList arrayList = new ArrayList();
        obj.l = arrayList;
        h0.a aVar2 = new h0.a(i2);
        obj.A = aVar2;
        int i9 = 0;
        o oVar = new o(new b2[obj4.length], new g[obj4.length], i9);
        obj.b = oVar;
        g2.b bVar = new g2.b();
        obj.k = bVar;
        v1.b.a aVar = new v1.b.a();
        int[] iArr = new int[10];
        iArr = new int[]{1, 2, 12, 13, 14, 15, 16, 17, 18, 19};
        aVar.c(iArr);
        aVar.b(obj38);
        com.google.android.exoplayer2.v1.b bVar2 = aVar.e();
        obj.c = bVar2;
        v1.b.a aVar3 = new v1.b.a();
        aVar3.b(bVar2);
        aVar3.a(3);
        aVar3.a(9);
        obj.B = aVar3.e();
        obj.C = n1.F;
        obj.E = -1;
        obj.f = iVar.c(looper, i9);
        r rVar = new r(obj);
        obj.g = rVar;
        obj.D = t1.k(oVar);
        if (h1Var != null) {
            h1Var.H1(handler, looper);
            obj.D(h1Var);
            handler = new Handler(looper);
            gVar.h(handler, h1Var);
        }
        super(z1Arr, n2, oVar, l14, g5, obj.u, obj.v, h16, d28, z13, i14, g1Var4, v116, obj36, b17, rVar);
        obj2.h = g1Var4;
    }

    private com.google.android.exoplayer2.v1.f A0(long l) {
        int i2;
        Object i3;
        Object obj;
        int i;
        long l2;
        Object obj2;
        boolean obj14;
        final int i4 = x();
        if (!t1Var.a.q()) {
            com.google.android.exoplayer2.t1 t1Var2 = this.D;
            Object obj3 = aVar.a;
            t1Var2.a.h(obj3, this.k);
            i = i2;
            obj = obj3;
            i3 = obj2;
        } else {
            i = i2;
            obj = i3;
        }
        final long l3 = w0.e(l);
        if (obj14.b.b()) {
            l2 = w0.e(f1.C0(this.D));
        } else {
            l2 = l3;
        }
        obj14 = obj14.b;
        super(i3, i4, obj, i, l3, obj6, l2, obj8, obj14.b, obj14.c);
        return obj13;
    }

    private com.google.android.exoplayer2.v1.f B0(int i, com.google.android.exoplayer2.t1 t12, int i3) {
        long l2;
        long l;
        boolean z;
        boolean z2;
        int i7;
        int i10;
        long i5;
        int i6;
        Object obj;
        com.google.android.exoplayer2.g2.c cVar;
        int i8;
        int i2;
        int i9;
        int i4;
        final Object obj2 = this;
        Object obj3 = t12;
        g2.b bVar = new g2.b();
        i7 = -1;
        if (!obj3.a.q()) {
            i10 = aVar7.a;
            obj3.a.h(i10, bVar);
            z = bVar.c;
            i2 = z;
            i9 = i10;
            i4 = i6;
            i8 = obj;
        } else {
            i2 = i3;
            i4 = i7;
            i9 = i8;
        }
        if (i == 0) {
            l3 += obj;
            if (obj3.b.b()) {
                y.a aVar6 = obj3.b;
                i5 = bVar.b(aVar6.b, aVar6.c);
                l2 = f1.C0(t12);
            } else {
                if (aVar2.e != i7 && t1Var.b.b()) {
                    if (t1Var.b.b()) {
                        i5 = f1.C0(obj2.D);
                    }
                }
                l2 = i5;
            }
        } else {
            if (obj3.b.b()) {
                i5 = obj3.s;
                l2 = f1.C0(t12);
            } else {
                i5 = l + i7;
            }
        }
        y.a aVar = obj3.b;
        super(i8, i2, i9, i4, w0.e(i5), obj14, w0.e(l2), obj16, aVar.b, aVar.c);
        return fVar;
    }

    private static long C0(com.google.android.exoplayer2.t1 t1) {
        long l;
        int bVar;
        int cmp;
        Object obj6;
        g2.c cVar = new g2.c();
        bVar = new g2.b();
        t1.a.h(aVar.a, bVar);
        if (Long.compare(l3, l4) == 0) {
            l = t1.a.n(bVar.c, cVar).c();
        } else {
            l2 += cmp;
        }
        return l;
    }

    private void D0(com.google.android.exoplayer2.g1.e g1$e) {
        Object obj;
        int i;
        com.google.android.exoplayer2.g2 g2Var;
        boolean z4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean equals;
        int i2;
        int i4;
        int i5;
        int i3;
        y.a l3;
        int size;
        int size2;
        long l2;
        y.a aVar;
        int i6;
        long l;
        i7 -= i8;
        this.w = i;
        i2 = 1;
        if (e.d) {
            this.x = e.e;
            this.y = i2;
        }
        if (e.f) {
            this.z = e.g;
        }
        g2Var = t1Var.a;
        int i9 = 0;
        if (i == 0 && !t1Var3.a.q() && g2Var.q()) {
            g2Var = t1Var.a;
            i9 = 0;
            if (!t1Var3.a.q()) {
                if (g2Var.q()) {
                    this.E = -1;
                    this.G = 0;
                    this.F = i9;
                }
            }
            if (!g2Var.q()) {
                z3 = (x1)g2Var.E();
                i3 = z3.size() == this.l.size() ? i2 : i9;
                g.f(i3);
                i5 = i9;
                while (i5 < z3.size()) {
                    f1.a.b((f1.a)this.l.get(i5), (g2)z3.get(i5));
                    i5++;
                }
            }
            l3 = -9223372036854775807L;
            if (this.y) {
                if (t1Var4.b.equals(t1Var8.b)) {
                    if (Long.compare(aVar, l) != 0) {
                    } else {
                        i2 = i9;
                    }
                }
                if (i2 != 0) {
                    if (!g2Var.q()) {
                        if (t1Var7.b.b()) {
                            g2Var = t1Var2.d;
                        } else {
                            equals = e.b;
                            g2Var = i1(g2Var, equals.b, equals.d);
                        }
                    } else {
                    }
                    l2 = g2Var;
                } else {
                    l2 = l3;
                }
                i5 = i2;
            } else {
                l2 = l3;
                i5 = i9;
            }
            this.y = i9;
            this.t1(e.b, 1, this.z, false, i5, this.x, l2, obj8);
        }
    }

    private static boolean E0(com.google.android.exoplayer2.t1 t1) {
        boolean i;
        int obj2;
        if (t1.e == 3 && t1.l && t1.m == 0) {
            if (t1.l) {
                obj2 = t1.m == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    static void F0(com.google.android.exoplayer2.v1 v1, com.google.android.exoplayer2.v1.c v1$c2, q q3) {
        v1.d dVar = new v1.d(q3);
        c2.p(v1, dVar);
    }

    private void G0(com.google.android.exoplayer2.g1.e g1$e) {
        D0(e);
    }

    private void I0(com.google.android.exoplayer2.g1.e g1$e) {
        x xVar = new x(this, e);
        this.f.b(xVar);
    }

    private void K0(com.google.android.exoplayer2.v1.c v1$c) {
        c.m(this.C);
    }

    static void M0(com.google.android.exoplayer2.v1.c v1$c) {
        ExoTimeoutException exoTimeoutException = new ExoTimeoutException(1);
        c.g(ExoPlaybackException.e(exoTimeoutException, 1003));
    }

    static void N0(int i, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.i(i);
    }

    static void O0(boolean z, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.n(z);
    }

    private void P0(com.google.android.exoplayer2.v1.c v1$c) {
        c.h(this.B);
    }

    static void R0(com.google.android.exoplayer2.m1 m1, int i2, com.google.android.exoplayer2.v1.c v1$c3) {
        c3.s(m1, i2);
    }

    static void S0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.y(t1.f);
    }

    static void T0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.g(t1.f);
    }

    static void U0(com.google.android.exoplayer2.t1 t1, k k2, com.google.android.exoplayer2.v1.c v1$c3) {
        c3.w(t1.h, k2);
    }

    static void V0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.G(t1.j);
    }

    static void W0(com.google.android.exoplayer2.n1 n1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.m(n1);
    }

    static void X0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.B(t1.g);
        c2.f(t1.g);
    }

    static void Y0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.S(t1.l, t1.e);
    }

    static void Z0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.l(t1.e);
    }

    static void a1(com.google.android.exoplayer2.t1 t1, int i2, com.google.android.exoplayer2.v1.c v1$c3) {
        c3.v(t1.l, i2);
    }

    static void b1(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.e(t1.m);
    }

    static void c1(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.A(f1.E0(t1));
    }

    static void d1(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.v1.c v1$c2) {
        c2.c(t1.n);
    }

    static void e1(com.google.android.exoplayer2.t1 t1, int i2, com.google.android.exoplayer2.v1.c v1$c3) {
        c3.j(t1.a, i2);
    }

    static void f1(int i, com.google.android.exoplayer2.v1.f v1$f2, com.google.android.exoplayer2.v1.f v1$f3, com.google.android.exoplayer2.v1.c v1$c4) {
        c4.C(i);
        c4.d(f2, f3, i);
    }

    private com.google.android.exoplayer2.t1 g1(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.g2 g22, Pair<Object, Long> pair3) {
        Object obj3;
        Object obj2;
        y.a l;
        l0 l0Var2;
        boolean cmp;
        o oVar3;
        Object list2;
        int i3;
        Object obj;
        com.google.android.exoplayer2.g2.b bVar;
        com.google.android.exoplayer2.t1 i;
        Object g2Var;
        com.google.android.exoplayer2.t1 t1Var;
        y.a i2;
        y.a aVar2;
        long l3;
        long first;
        long l2;
        long longValue;
        int aVar;
        o oVar;
        l0 l0Var;
        o oVar2;
        List list;
        obj2 = this;
        l = g22;
        Object obj4 = pair3;
        i = 1;
        if (!g22.q()) {
            if (obj4 != null) {
                i3 = i;
            } else {
                i3 = 0;
            }
        } else {
        }
        g.a(i3);
        g2Var = obj6.a;
        t1Var = t1.j(g22);
        boolean z5 = g22.q();
        if (z5) {
            y.a aVar4 = t1.l();
            long l11 = w0.d(obj2.G);
            com.google.android.exoplayer2.t1 t1Var2 = t1Var.c(aVar4, l11, obj9, l11, obj11, l11, obj13, 0).b(aVar4);
            t1Var2.q = t1Var2.s;
            return t1Var2;
        }
        obj = aVar6.a;
        p0.i(pair3);
        equals2 ^= i;
        if (i2 != 0) {
            aVar2 = new y.a(obj4.first);
        } else {
            aVar2 = t1Var.b;
        }
        aVar = aVar2;
        longValue = (Long)obj4.second.longValue();
        if (!g2Var.q()) {
            l3 -= cmp;
        }
        if (i2 == 0) {
            cmp = Long.compare(longValue, l3);
            if (cmp < 0) {
                y.a aVar3 = aVar;
                g.f(z ^= i);
                l0Var2 = i2 != 0 ? l0.v : t1Var.h;
                l = aVar3;
                oVar3 = i2 != 0 ? obj3.b : t1Var.i;
                if (i2 != 0) {
                    list2 = v.z();
                } else {
                    list2 = t1Var.j;
                }
                t1Var.q = longValue;
            } else {
                if (cmp == 0) {
                    cmp = l.b(aVar5.a);
                    if (cmp != -1) {
                        if (bVar4.c != bVar8.c) {
                            l.h(aVar.a, obj2.k);
                            if (aVar.b()) {
                                l = obj2.k.b(aVar.b, aVar.c);
                            } else {
                                l = bVar2.d;
                            }
                            oVar = t1Var.i;
                            t1Var.q = l;
                        }
                    } else {
                    }
                } else {
                    obj2 = aVar;
                    g.f(z2 ^= i);
                    aVar = Math.max(0, cmp);
                    l = t1Var.q;
                    if (t1Var.k.equals(t1Var.b)) {
                        l = longValue + aVar;
                    }
                    t1Var.q = l;
                }
                obj3 = this;
            }
        } else {
        }
        return t1Var;
    }

    private long i1(com.google.android.exoplayer2.g2 g2, y.a y$a2, long l3) {
        g2.h(a2.a, this.k);
        return l3 += obj2;
    }

    private com.google.android.exoplayer2.t1 k1(int i, int i2) {
        int i4;
        int i3;
        int size2;
        com.google.android.exoplayer2.t1 t1Var;
        int size;
        int i5 = 1;
        if (i >= 0 && i2 >= i && i2 <= this.l.size()) {
            if (i2 >= i) {
                i3 = i2 <= this.l.size() ? i5 : i4;
            } else {
            }
        } else {
        }
        g.a(i3);
        this.w = i7 += i5;
        l1(i, i2);
        com.google.android.exoplayer2.g2 g2Var3 = p0();
        t1Var = g1(this.D, g2Var3, x0(O(), g2Var3));
        int i9 = t1Var.e;
        int i10 = 4;
        if (i9 != i5 && i9 != i10 && i < i2 && i2 == this.l.size() && x() >= t1Var.a.p()) {
            if (i9 != i10) {
                if (i < i2) {
                    if (i2 == this.l.size()) {
                        if (x() >= t1Var.a.p()) {
                            i4 = i5;
                        }
                    }
                }
            }
        }
        if (i4 != 0) {
            t1Var = t1Var.h(i10);
        }
        this.h.n0(i, i2, this.A);
        return t1Var;
    }

    private void l1(int i, int i2) {
        int i3;
        List list;
        i3 = i2 + -1;
        while (i3 >= i) {
            this.l.remove(i3);
            i3--;
        }
        this.A = this.A.a(i, i2);
    }

    private List<com.google.android.exoplayer2.s1.c> o0(int i, List<y> list2) {
        int i2;
        com.google.android.exoplayer2.g2 g2Var;
        List list;
        int i3;
        com.google.android.exoplayer2.f1.a aVar;
        Object obj;
        ArrayList arrayList = new ArrayList();
        i2 = 0;
        while (i2 < list2.size()) {
            s1.c cVar = new s1.c((y)list2.get(i2), this.m);
            arrayList.add(cVar);
            aVar = new f1.a(cVar.b, cVar.a.K());
            this.l.add(i2 + i, aVar);
            i2++;
        }
        this.A = this.A.e(i, arrayList.size());
        return arrayList;
    }

    private com.google.android.exoplayer2.g2 p0() {
        x1 x1Var = new x1(this.l, this.A);
        return x1Var;
    }

    private void p1(List<y> list, int i2, long l3, boolean z4) {
        int i;
        boolean equals;
        long l;
        boolean z2;
        int i4;
        boolean empty;
        int i5;
        boolean z;
        int i3;
        final Object obj4 = this;
        i = i2;
        long l2 = Y();
        i5 = 1;
        obj4.w = i9 += i5;
        int i13 = 0;
        if (!obj4.l.isEmpty()) {
            obj4.l1(i13, obj4.l.size());
        }
        com.google.android.exoplayer2.g2 g2Var2 = p0();
        if (!g2Var2.q()) {
            if (i >= g2Var2.p()) {
            } else {
            }
            IllegalSeekPositionException illegalSeekPositionException = new IllegalSeekPositionException(g2Var2, i, l3, obj8);
            throw illegalSeekPositionException;
        }
        int i17 = -1;
        if (obj22 != null) {
            l = -9223372036854775807L;
            i3 = i;
        } else {
            l = i == i17 ? l2 : l5;
        }
        com.google.android.exoplayer2.t1 t1Var2 = obj4.g1(obj4.D, g2Var2, obj4.y0(g2Var2, i3, l));
        if (i3 != i17 && t1Var2.e != i5) {
            if (t1Var2.e != i5) {
                if (!g2Var2.q()) {
                    if (i3 >= g2Var2.p()) {
                        i4 = 4;
                    } else {
                        i4 = 2;
                    }
                } else {
                }
            }
        }
        com.google.android.exoplayer2.t1 t1Var6 = t1Var2.h(i4);
        obj4.h.M0(obj4.o0(i13, list), i3, w0.d(l), obj15);
        if (!aVar.a.equals(aVar2.a) && !t1Var4.a.q()) {
            if (!t1Var4.a.q()) {
            } else {
                i5 = i13;
            }
        } else {
        }
        final long l7 = obj4.v0(t1Var6);
        this.t1(t1Var6, 0, 1, false, i5, 4, l7, l7);
    }

    private Pair<Boolean, Integer> r0(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.t1 t12, boolean z3, int i4, boolean z5) {
        boolean z;
        int i;
        Object obj7;
        Object obj8;
        int obj10;
        com.google.android.exoplayer2.g2 g2Var = t12.a;
        com.google.android.exoplayer2.g2 g2Var2 = t1.a;
        Integer valueOf = -1;
        if (g2Var2.q() && g2Var.q()) {
            if (g2Var.q()) {
                obj7 = new Pair(Boolean.FALSE, valueOf);
                return obj7;
            }
        }
        if (g2Var2.q() != g2Var.q()) {
            obj7 = new Pair(Boolean.TRUE, 3);
            return obj7;
        }
        if (!cVar.a.equals(cVar2.a)) {
            obj7 = 1;
            if (z3 && i4 == 0) {
                if (i4 == 0) {
                    i = obj7;
                    obj7 = new Pair(Boolean.TRUE, Integer.valueOf(i));
                    return obj7;
                } else {
                    if (z3 && i4 == obj7) {
                        if (i4 == obj7) {
                            i = 2;
                        } else {
                            if (!z5) {
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            obj7 = new IllegalStateException();
            throw obj7;
        }
        if (z3 && i4 == 0 && Long.compare(obj8, obj10) < 0) {
            if (i4 == 0) {
                if (Long.compare(obj8, obj10) < 0) {
                    obj7 = new Pair(Boolean.TRUE, 0);
                    return obj7;
                }
            }
        }
        obj7 = new Pair(Boolean.FALSE, valueOf);
        return obj7;
    }

    private void s1() {
        boolean equals;
        com.google.android.exoplayer2.v1.b bVar;
        com.google.android.exoplayer2.v vVar;
        bVar = b(this.c);
        this.B = bVar;
        if (!bVar.equals(this.B)) {
            vVar = new v(this);
            this.i.g(14, vVar);
        }
    }

    private void t1(com.google.android.exoplayer2.t1 t1, int i2, int i3, boolean z4, boolean z5, int i6, long l7, int i8) {
        Object exc;
        Object kVar;
        boolean equals2;
        boolean z;
        u i5;
        int i4;
        boolean z6;
        int i10;
        boolean z7;
        boolean equals;
        boolean iterator;
        boolean iterator2;
        boolean booleanValue;
        Object hVar;
        Object oVar2;
        List list;
        boolean z3;
        com.google.android.exoplayer2.g gVar;
        int i11;
        boolean z2;
        int i;
        boolean z9;
        com.google.android.exoplayer2.u1 u1Var;
        boolean next;
        boolean next2;
        com.google.android.exoplayer2.n1 n1Var;
        boolean wVar;
        int i12;
        boolean z8;
        int lVar;
        int i9;
        boolean equals3;
        int i13;
        com.google.android.exoplayer2.g2 g2Var;
        com.google.android.exoplayer2.q qVar;
        int i7;
        com.google.android.exoplayer2.o oVar;
        final Object obj4 = this;
        final com.google.android.exoplayer2.t1 t1Var3 = t1;
        final int i17 = i6;
        final com.google.android.exoplayer2.t1 t1Var4 = obj4.D;
        obj4.D = t1Var3;
        final int i18 = 1;
        Pair pair = this.r0(t1, t1Var4, z5, i6, equals4 ^ 1);
        booleanValue = (Boolean)pair.first.booleanValue();
        n1Var = obj4.C;
        lVar = 0;
        if (booleanValue && !t1Var3.a.q()) {
            if (!t1Var3.a.q()) {
                lVar = z8.c;
            }
            n1Var = lVar != 0 ? lVar.d : n1.F;
        }
        if (!t1Var4.j.equals(t1Var3.j)) {
            com.google.android.exoplayer2.n1.b bVar = n1Var.a();
            bVar.I(t1Var3.j);
            n1Var = bVar.F();
        }
        obj4.C = n1Var;
        if (!t1Var4.a.equals(t1Var3.a)) {
            qVar = new q(t1, i2);
            obj4.i.g(0, qVar);
        }
        if (z5) {
            oVar = new o(i17, B0(i17, t1Var4, obj23), A0(l7));
            obj4.i.g(12, oVar);
        }
        if (booleanValue) {
            wVar = new m(lVar, (Integer)pair.second.intValue());
            obj4.i.g(i18, wVar);
        }
        hVar = new h(t1);
        wVar = 11;
        obj4.i.g(wVar, hVar);
        if (t1Var4.f != t1Var3.f && t1Var3.f != null) {
            hVar = new h(t1);
            wVar = 11;
            obj4.i.g(wVar, hVar);
            if (t1Var3.f != null) {
                hVar = new e(t1);
                obj4.i.g(wVar, hVar);
            }
        }
        oVar2 = t1Var3.i;
        if (t1Var4.i != oVar2) {
            obj4.e.c(oVar2.d);
            kVar = new k(oVar3.c);
            lVar = new l(t1, kVar);
            obj4.i.g(2, lVar);
        }
        if (!t1Var4.j.equals(t1Var3.j)) {
            wVar = new i(t1);
            obj4.i.g(3, wVar);
        }
        if (equals5 ^= i18 != 0) {
            lVar = new u(obj4.C);
            obj4.i.g(15, lVar);
        }
        if (t1Var4.g != t1Var3.g) {
            wVar = new w(t1);
            obj4.i.g(4, wVar);
        }
        i12 = -1;
        if (t1Var4.e == t1Var3.e) {
            if (t1Var4.l != t1Var3.l) {
                gVar = new g(t1);
                obj4.i.g(i12, gVar);
            }
        } else {
        }
        if (t1Var4.e != t1Var3.e) {
            lVar = new z(t1);
            obj4.i.g(5, lVar);
        }
        if (t1Var4.l != t1Var3.l) {
            lVar = new k(t1, i3);
            obj4.i.g(6, lVar);
        }
        if (t1Var4.m != t1Var3.m) {
            lVar = new y(t1);
            obj4.i.g(7, lVar);
        }
        if (f1.E0(t1Var4) != f1.E0(t1)) {
            lVar = new j(t1);
            obj4.i.g(8, lVar);
        }
        if (!t1Var4.n.equals(t1Var3.n)) {
            lVar = new p(t1);
            obj4.i.g(13, lVar);
        }
        if (z4) {
            obj4.i.g(i12, a.a);
        }
        s1();
        obj4.i.c();
        if (t1Var4.o != t1Var3.o) {
            iterator = obj4.j.iterator();
            for (e1 next : iterator) {
                next.X(t1Var3.o);
            }
        }
        if (t1Var4.p != t1Var3.p) {
            iterator2 = obj4.j.iterator();
            for (e1 next2 : iterator2) {
                next2.K(t1Var3.p);
            }
        }
    }

    private long v0(com.google.android.exoplayer2.t1 t1) {
        if (t1.a.q()) {
            return w0.d(this.G);
        }
        if (t1.b.b()) {
            return t1.s;
        }
        return i1(t1.a, t1.b, t1.s);
    }

    private int w0() {
        if (t1Var.a.q()) {
            return this.E;
        }
        com.google.android.exoplayer2.t1 t1Var2 = this.D;
        return bVar.c;
    }

    private Pair<Object, Long> x0(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.g2 g22) {
        long l;
        boolean z;
        int i;
        boolean obj14;
        final long l3 = -9223372036854775807L;
        i = -1;
        if (!g2.q()) {
            if (g22.q()) {
            } else {
                Pair pair = g2.j(this.a, this.k, x(), w0.d(C()));
                p0.i(pair);
                Object first = pair2.first;
                int i2 = g22.b(first);
                if (i2 != i) {
                    return pair;
                }
                obj14 = g1.y0(this.a, this.k, this.u, this.v, first, g2, g22);
                if (obj14 != null) {
                    g22.h(obj14, this.k);
                    obj14 = obj14.c;
                    return y0(g22, obj14, g22.n(obj14, this.a).b());
                }
            }
            return y0(g22, i, l3);
        }
        if (!g2.q() && g22.q()) {
            obj14 = g22.q() ? 1 : 0;
        } else {
        }
        if (obj14 != null) {
        } else {
            i = w0();
        }
        if (obj14 != null) {
            l = l3;
        }
        return y0(g22, i, l);
    }

    private Pair<Object, Long> y0(com.google.android.exoplayer2.g2 g2, int i2, long l3) {
        int i;
        int obj8;
        long obj9;
        this.E = i2;
        if (g2.q() && Long.compare(l3, obj7) == 0) {
            this.E = i2;
            if (Long.compare(l3, obj7) == 0) {
                obj9 = 0;
            }
            this.G = obj9;
            this.F = 0;
            return 0;
        }
        if (i2 != -1) {
            if (i2 >= g2.p()) {
                obj9 = g2.n(g2.a(this.v), this.a).b();
            }
        } else {
        }
        return g2.j(this.a, this.k, obj8, w0.d(obj9));
    }

    @Override // com.google.android.exoplayer2.t0
    public void A(boolean z) {
        q1(z, 0, 1);
    }

    @Override // com.google.android.exoplayer2.t0
    public long B() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.t0
    public long C() {
        int i;
        int cmp;
        long l;
        if (h()) {
            com.google.android.exoplayer2.t1 t1Var = this.D;
            t1Var.a.h(aVar.a, this.k);
            com.google.android.exoplayer2.t1 t1Var2 = this.D;
            final long l6 = -9223372036854775807L;
            if (Long.compare(l4, l6) == 0) {
                i = t1Var2.a.n(x(), this.a).b();
            } else {
                l3 += l;
            }
            return i;
        }
        return Y();
    }

    @Override // com.google.android.exoplayer2.t0
    public void D(com.google.android.exoplayer2.v1.e v1$e) {
        n0(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public int E() {
        return t1Var.e;
    }

    @Override // com.google.android.exoplayer2.t0
    public List G() {
        return u0();
    }

    @Override // com.google.android.exoplayer2.t0
    public int H() {
        int i;
        if (h()) {
            i = aVar.b;
        } else {
            i = -1;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.t0
    public void H0(com.google.android.exoplayer2.g1.e g1$e) {
        G0(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public void J(int i) {
        int i3;
        int i2;
        com.google.android.exoplayer2.d dVar;
        int obj4;
        if (this.u != i) {
            this.u = i;
            this.h.S0(i);
            dVar = new d(i);
            this.i.g(9, dVar);
            s1();
            this.i.c();
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public void J0(com.google.android.exoplayer2.g1.e g1$e) {
        I0(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public void K(SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.t0
    public int L() {
        return t1Var.m;
    }

    @Override // com.google.android.exoplayer2.t0
    public void L0(com.google.android.exoplayer2.v1.c v1$c) {
        K0(c);
    }

    @Override // com.google.android.exoplayer2.t0
    public l0 M() {
        return t1Var.h;
    }

    @Override // com.google.android.exoplayer2.t0
    public int N() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.g2 O() {
        return t1Var.a;
    }

    @Override // com.google.android.exoplayer2.t0
    public Looper P() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean Q() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.t0
    public void Q0(com.google.android.exoplayer2.v1.c v1$c) {
        P0(c);
    }

    @Override // com.google.android.exoplayer2.t0
    public long R() {
        long l;
        int cmp;
        boolean z;
        long cmp2;
        if (t1Var.a.q()) {
            return this.G;
        }
        com.google.android.exoplayer2.t1 t1Var2 = this.D;
        if (Long.compare(l6, cmp2) != 0) {
            return t1Var2.a.n(x(), this.a).d();
        }
        l = t1Var2.q;
        if (t1Var5.k.b()) {
            com.google.android.exoplayer2.t1 t1Var3 = this.D;
            com.google.android.exoplayer2.g2.b bVar = t1Var3.a.h(aVar.a, this.k);
            cmp = bVar.f(aVar3.b);
            l = Long.compare(cmp, l7) == 0 ? bVar.d : cmp;
        }
        com.google.android.exoplayer2.t1 t1Var6 = this.D;
        return w0.e(i1(t1Var6.a, t1Var6.k, l));
    }

    @Override // com.google.android.exoplayer2.t0
    public void U(TextureView textureView) {
    }

    @Override // com.google.android.exoplayer2.t0
    public k V() {
        k kVar = new k(oVar.c);
        return kVar;
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.n1 X() {
        return this.C;
    }

    @Override // com.google.android.exoplayer2.t0
    public long Y() {
        return w0.e(v0(this.D));
    }

    @Override // com.google.android.exoplayer2.t0
    public long Z() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.t0
    public void a() {
        boolean z;
        String str2;
        int i;
        Object str;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str7 = p0.e;
        str = h1.b();
        StringBuilder stringBuilder = new StringBuilder(i5 += length3);
        stringBuilder.append("Release ");
        stringBuilder.append(hexString);
        stringBuilder.append(" [");
        stringBuilder.append("ExoPlayerLib/2.15.1");
        String str5 = "] [";
        stringBuilder.append(str5);
        stringBuilder.append(str7);
        stringBuilder.append(str5);
        stringBuilder.append(str);
        stringBuilder.append("]");
        v.f("ExoPlayerImpl", stringBuilder.toString());
        if (!this.h.k0()) {
            this.i.j(11, t.a);
        }
        this.i.h();
        this.f.k(0);
        h1 h1Var = this.o;
        if (h1Var != null) {
            this.q.e(h1Var);
        }
        com.google.android.exoplayer2.t1 t1Var2 = this.D.h(1);
        this.D = t1Var2;
        com.google.android.exoplayer2.t1 t1Var3 = t1Var2.b(t1Var2.b);
        this.D = t1Var3;
        t1Var3.q = t1Var3.s;
        t1Var4.r = 0;
    }

    @Override // com.google.android.exoplayer2.t0
    public long d() {
        if (h()) {
            com.google.android.exoplayer2.t1 t1Var = this.D;
            y.a aVar = t1Var.b;
            t1Var.a.h(aVar.a, this.k);
            int i = aVar.c;
            return w0.e(this.k.b(aVar.b, i));
        }
        return c();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.u1 e() {
        return t1Var.n;
    }

    @Override // com.google.android.exoplayer2.t0
    public void f() {
        int i;
        com.google.android.exoplayer2.t1 t1Var = this.D;
        final int i6 = 1;
        if (t1Var.e != i6) {
        }
        com.google.android.exoplayer2.t1 t1Var2 = t1Var.f(0);
        i = t1Var2.a.q() ? 4 : 2;
        this.w = i2 += i6;
        this.h.i0();
        this.t1(t1Var2.h(i), 1, 1, false, false, 5, -9223372036854775807L, obj11);
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean h() {
        return t1Var.b.b();
    }

    @Override // com.google.android.exoplayer2.t0
    public void h1(a a) {
        com.google.android.exoplayer2.n1.b bVar = this.C.a();
        bVar.H(a);
        com.google.android.exoplayer2.n1 obj3 = bVar.F();
        if (obj3.equals(this.C)) {
        }
        this.C = obj3;
        s sVar = new s(this);
        this.i.j(15, sVar);
    }

    @Override // com.google.android.exoplayer2.t0
    public long i() {
        return w0.e(t1Var.r);
    }

    @Override // com.google.android.exoplayer2.t0
    public void j(int i, long l2) {
        int i3;
        int i2;
        final Object obj2 = this;
        int i4 = i;
        long l = l2;
        com.google.android.exoplayer2.g2 g2Var = t1Var3.a;
        if (i4 < 0) {
        } else {
            if (!g2Var.q() && i4 < g2Var.p()) {
                if (i4 >= g2Var.p()) {
                } else {
                    i2 = 1;
                    obj2.w = i7 += i2;
                    if (h()) {
                        v.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                        g1.e eVar = new g1.e(obj2.D);
                        eVar.b(i2);
                        obj2.g.a(eVar);
                    }
                    if (E() == i2) {
                    } else {
                        i2 = 2;
                    }
                }
            } else {
            }
            com.google.android.exoplayer2.t1 t1Var6 = g1(obj2.D.h(i2), g2Var, y0(g2Var, i, l));
            obj2.h.A0(g2Var, i, w0.d(l2));
            this.t1(t1Var6, 0, 1, true, true, 1, v0(t1Var6), obj8);
        }
        IllegalSeekPositionException illegalSeekPositionException = new IllegalSeekPositionException(g2Var, i, l, obj2);
        throw illegalSeekPositionException;
    }

    @Override // com.google.android.exoplayer2.t0
    public void j1(com.google.android.exoplayer2.v1.c v1$c) {
        this.i.i(c);
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.v1.b k() {
        return this.B;
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean l() {
        return t1Var.l;
    }

    @Override // com.google.android.exoplayer2.t0
    public void m(boolean z) {
        boolean z2;
        int i;
        com.google.android.exoplayer2.f fVar;
        boolean obj4;
        if (this.v != z) {
            this.v = z;
            this.h.V0(z);
            fVar = new f(z);
            this.i.g(10, fVar);
            s1();
            this.i.c();
        }
    }

    @Override // com.google.android.exoplayer2.t0
    public void m0(com.google.android.exoplayer2.e1 e1) {
        this.j.add(e1);
    }

    @Override // com.google.android.exoplayer2.t0
    public void m1(y y) {
        n1(Collections.singletonList(y));
    }

    @Override // com.google.android.exoplayer2.t0
    public void n(boolean z) {
        r1(z, 0);
    }

    @Override // com.google.android.exoplayer2.t0
    public void n0(com.google.android.exoplayer2.v1.c v1$c) {
        this.i.a(c);
    }

    public void n1(List<y> list) {
        o1(list, true);
    }

    @Override // com.google.android.exoplayer2.t0
    public int o() {
        return 3000;
    }

    public void o1(List<y> list, boolean z2) {
        this.p1(list, -1, -9223372036854775807L, obj4);
    }

    @Override // com.google.android.exoplayer2.t0
    public int p() {
        if (t1Var.a.q()) {
            return this.F;
        }
        com.google.android.exoplayer2.t1 t1Var2 = this.D;
        return t1Var2.a.b(aVar.a);
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.w1 q0(com.google.android.exoplayer2.w1.b w1$b) {
        super(this.h, b, t1Var.a, x(), this.t, this.h.z());
        return w1Var2;
    }

    @Override // com.google.android.exoplayer2.t0
    public void q1(boolean z, int i2, int i3) {
        boolean z2;
        com.google.android.exoplayer2.t1 t1Var = this.D;
        if (t1Var.l == z && t1Var.m == i2) {
            if (t1Var.m == i2) {
            }
        }
        this.w = i++;
        this.h.P0(z, i2);
        this.t1(t1Var.e(z, i2), 0, i3, false, false, 5, -9223372036854775807L, obj10);
    }

    @Override // com.google.android.exoplayer2.t0
    public void r(TextureView textureView) {
    }

    @Override // com.google.android.exoplayer2.t0
    public void r1(boolean z, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException2) {
        int i2;
        int i;
        com.google.android.exoplayer2.t1 obj13;
        final int i3 = 0;
        if (z) {
            obj13 = k1(i3, this.l.size()).f(0);
        } else {
            obj13 = this.D;
            obj13 = obj13.b(obj13.b);
            obj13.q = obj13.s;
            obj13.r = 0;
        }
        int i4 = 1;
        if (exoPlaybackException2 != null) {
            obj13 = obj13.h(i4).f(exoPlaybackException2);
        }
        final com.google.android.exoplayer2.t1 t1Var = obj13;
        this.w = obj13 += i4;
        this.h.f1();
        if (t1Var.a.q() && !obj13.a.q()) {
            i = !obj13.a.q() ? i4 : i3;
        } else {
        }
        this.t1(t1Var, 0, 1, false, i, 4, v0(t1Var), obj10);
    }

    @Override // com.google.android.exoplayer2.t0
    public a0 s() {
        return a0.e;
    }

    @Override // com.google.android.exoplayer2.t0
    public boolean s0() {
        return t1Var.p;
    }

    @Override // com.google.android.exoplayer2.t0
    public void t(com.google.android.exoplayer2.v1.e v1$e) {
        j1(e);
    }

    @Override // com.google.android.exoplayer2.t0
    public void t0(long l) {
        this.h.s(l);
    }

    @Override // com.google.android.exoplayer2.t0
    public int u() {
        int i;
        if (h()) {
            i = aVar.c;
        } else {
            i = -1;
        }
        return i;
    }

    public v<c> u0() {
        return v.z();
    }

    @Override // com.google.android.exoplayer2.t0
    public void v(SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.t0
    public int x() {
        int i;
        if (w0() == -1) {
            i = 0;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.PlaybackException z() {
        return z0();
    }

    @Override // com.google.android.exoplayer2.t0
    public com.google.android.exoplayer2.ExoPlaybackException z0() {
        return t1Var.f;
    }
}
