package com.google.android.exoplayer2;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.j2.h1;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.n2.j;
import com.google.android.exoplayer2.n2.n;
import com.google.android.exoplayer2.n2.n.a;
import com.google.android.exoplayer2.n2.o;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.w.a;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.text.l;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.s.a;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.s;
import com.google.common.collect.v;
import com.google.common.collect.v.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class g1 implements Handler.Callback, w.a, n.a, com.google.android.exoplayer2.s1.d, com.google.android.exoplayer2.b1.a, com.google.android.exoplayer2.w1.a {

    private final Looper A;
    private final com.google.android.exoplayer2.g2.c B;
    private final com.google.android.exoplayer2.g2.b C;
    private final long D;
    private final boolean E;
    private final com.google.android.exoplayer2.b1 F;
    private final ArrayList<com.google.android.exoplayer2.g1.d> G;
    private final i H;
    private final com.google.android.exoplayer2.g1.f I;
    private final com.google.android.exoplayer2.q1 J;
    private final com.google.android.exoplayer2.s1 K;
    private final com.google.android.exoplayer2.k1 L;
    private final long M;
    private com.google.android.exoplayer2.d2 N;
    private com.google.android.exoplayer2.t1 O;
    private com.google.android.exoplayer2.g1.e P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private final com.google.android.exoplayer2.z1[] a;
    private int a0;
    private final com.google.android.exoplayer2.a2[] b;
    private com.google.android.exoplayer2.g1.h b0;
    private final n c;
    private long c0;
    private int d0;
    private boolean e0;
    private com.google.android.exoplayer2.ExoPlaybackException f0;
    private final o v;
    private final com.google.android.exoplayer2.l1 w;
    private final g x;
    private final s y;
    private final HandlerThread z;

    private static final class b {

        private final List<com.google.android.exoplayer2.s1.c> a;
        private final h0 b;
        private final int c;
        private final long d;
        private b(List<com.google.android.exoplayer2.s1.c> list, h0 h02, int i3, long l4) {
            super();
            this.a = list;
            this.b = h02;
            this.c = i3;
            this.d = l4;
        }

        b(List list, h0 h02, int i3, long l4, com.google.android.exoplayer2.g1.a g1$a5) {
            super(list, h02, i3, l4, a5);
        }

        static int a(com.google.android.exoplayer2.g1.b g1$b) {
            return b.c;
        }

        static List b(com.google.android.exoplayer2.g1.b g1$b) {
            return b.a;
        }

        static h0 c(com.google.android.exoplayer2.g1.b g1$b) {
            return b.b;
        }

        static long d(com.google.android.exoplayer2.g1.b g1$b) {
            return b.d;
        }
    }

    private static class c {

        public final int a;
        public final int b;
        public final int c;
        public final h0 d;
    }

    private static final class d implements Comparable<com.google.android.exoplayer2.g1.d> {

        public final com.google.android.exoplayer2.w1 a;
        public int b;
        public long c;
        public Object v;
        public d(com.google.android.exoplayer2.w1 w1) {
            super();
            this.a = w1;
        }

        @Override // java.lang.Comparable
        public int a(com.google.android.exoplayer2.g1.d g1$d) {
            int i3;
            int i2;
            int i;
            Object obj = this.v;
            i3 = 1;
            int i7 = 0;
            i2 = obj == null ? i3 : i7;
            i = d.v == null ? i3 : i7;
            if (i2 != i && obj != null) {
                if (obj != null) {
                    i3 = -1;
                }
                return i3;
            }
            if (obj == null) {
                return i7;
            }
            int i6 = d.b;
            i4 -= i6;
            if (i5 != 0) {
                return i5;
            }
            return p0.n(this.c, i6);
        }

        @Override // java.lang.Comparable
        public void c(int i, long l2, Object object3) {
            this.b = i;
            this.c = l2;
            this.v = obj4;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((g1.d)object);
        }
    }

    public static final class e {

        private boolean a;
        public com.google.android.exoplayer2.t1 b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;
        public e(com.google.android.exoplayer2.t1 t1) {
            super();
            this.b = t1;
        }

        static boolean a(com.google.android.exoplayer2.g1.e g1$e) {
            return e.a;
        }

        public void b(int i) {
            int i2;
            i2 = i > 0 ? 1 : 0;
            this.a = z |= i2;
            this.c = i4 += i;
        }

        public void c(int i) {
            final int i2 = 1;
            this.a = i2;
            this.f = i2;
            this.g = i;
        }

        public void d(com.google.android.exoplayer2.t1 t1) {
            int i;
            i = this.b != t1 ? 1 : 0;
            this.a = z |= i;
            this.b = t1;
        }

        public void e(int i) {
            boolean z;
            int i2;
            int i3;
            i2 = 1;
            i3 = 5;
            if (this.d && this.e != i3) {
                i3 = 5;
                if (this.e != i3) {
                    if (i == i3) {
                    } else {
                        i2 = 0;
                    }
                    g.a(i2);
                }
            }
            this.a = i2;
            this.d = i2;
            this.e = i;
        }
    }

    public interface f {
        public abstract void a(com.google.android.exoplayer2.g1.e g1$e);
    }

    private static final class g {

        public final y.a a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public g(y.a y$a, long l2, long l3, boolean z4, boolean z5, boolean z6) {
            super();
            this.a = a;
            this.b = l2;
            this.c = z4;
            this.d = z6;
            this.e = obj7;
            this.f = obj8;
        }
    }

    private static final class h {

        public final com.google.android.exoplayer2.g2 a;
        public final int b;
        public final long c;
        public h(com.google.android.exoplayer2.g2 g2, int i2, long l3) {
            super();
            this.a = g2;
            this.b = i2;
            this.c = l3;
        }
    }

    class a implements com.google.android.exoplayer2.z1.a {

        final com.google.android.exoplayer2.g1 a;
        a(com.google.android.exoplayer2.g1 g1) {
            this.a = g1;
            super();
        }

        @Override // com.google.android.exoplayer2.z1$a
        public void a() {
            g1.f(this.a).f(2);
        }

        @Override // com.google.android.exoplayer2.z1$a
        public void b(long l) {
            int obj3;
            int obj4;
            if (Long.compare(l, i) >= 0) {
                g1.e(this.a, true);
            }
        }
    }
    public g1(com.google.android.exoplayer2.z1[] z1Arr, n n2, o o3, com.google.android.exoplayer2.l1 l14, g g5, int i6, boolean z7, h1 h18, com.google.android.exoplayer2.d2 d29, com.google.android.exoplayer2.k1 k110, long l11, boolean z12, Looper looper13, i i14, com.google.android.exoplayer2.g1.f g1$f15) {
        int i;
        com.google.android.exoplayer2.g1.e eVar;
        long l;
        final Object obj = this;
        com.google.android.exoplayer2.z1[] objArr = z1Arr;
        final h1 h1Var = h18;
        final i iVar = f15;
        super();
        obj.I = obj26;
        obj.a = objArr;
        obj.c = n2;
        obj.v = o3;
        obj.w = l14;
        obj.x = g5;
        obj.V = i6;
        obj.W = z7;
        obj.N = d29;
        obj.L = k110;
        obj.M = l11;
        obj.R = looper13;
        obj.H = iVar;
        obj.D = l14.f();
        obj.E = l14.e();
        com.google.android.exoplayer2.t1 t1Var = t1.k(o3);
        obj.O = t1Var;
        eVar = new g1.e(t1Var);
        obj.P = eVar;
        obj.b = new a2[objArr.length];
        i = 0;
        for (Object z1Var2 : obj1) {
            objArr[i].f(i);
            obj.b[i] = z1Var2.m();
        }
        b1 b1Var = new b1(this, iVar);
        obj.F = b1Var;
        ArrayList arrayList = new ArrayList();
        obj.G = arrayList;
        g2.c cVar = new g2.c();
        obj.B = cVar;
        g2.b bVar = new g2.b();
        obj.C = bVar;
        n2.b(this, g5);
        obj.e0 = true;
        Handler handler = new Handler(i14);
        q1 q1Var = new q1(h1Var, handler);
        obj.J = q1Var;
        s1 s1Var = new s1(this, h1Var, handler);
        obj.K = s1Var;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        obj.z = handlerThread;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        obj.A = looper;
        obj.y = iVar.c(looper, this);
    }

    private long A() {
        return B(t1Var.q);
    }

    private long B(long l) {
        com.google.android.exoplayer2.o1 o1Var = this.J.i();
        final int i = 0;
        if (o1Var == null) {
            return i;
        }
        return Math.max(i, obj2);
    }

    private void B0(boolean z) {
        int cmp;
        y.a aVar;
        int i2;
        long l;
        com.google.android.exoplayer2.t1 t1Var;
        int i;
        com.google.android.exoplayer2.t1 obj12;
        y.a aVar2 = p1Var.a;
        final int i3 = 0;
        long l4 = this.E0(aVar2, t1Var2.s, obj4, true);
        if (Long.compare(l4, l2) != 0) {
            com.google.android.exoplayer2.t1 t1Var4 = this.O;
            this.O = this.J(aVar2, l4, obj4, t1Var4.c, i3, t1Var4.d);
        }
    }

    private void C(w w) {
        if (!this.J.u(w)) {
        }
        this.J.y(this.c0);
        U();
    }

    private void C0(com.google.android.exoplayer2.g1.h g1$h) {
        int obj;
        int i5;
        int pair;
        long l2;
        int cmp2;
        int cmp;
        int l5;
        int i4;
        int i6;
        int z;
        int i3;
        int i2;
        y.a aVar;
        int i10;
        boolean z2;
        int i7;
        long l;
        Object first;
        int i8;
        int i9;
        int i11;
        long l3;
        long longValue;
        boolean i;
        com.google.android.exoplayer2.g2 g2Var;
        long l4;
        final Object obj5 = this;
        obj = h;
        i7 = 1;
        obj5.P.b(i7);
        pair = g1.x0(t1Var4.a, h, true, obj5.V, obj5.W, obj5.B, obj5.C);
        cmp2 = 0;
        l5 = -9223372036854775807L;
        i3 = 0;
        if (pair == null) {
            Pair pair2 = obj5.y(t1Var11.a);
            first = pair2.first;
            longValue = (Long)pair2.second.longValue();
            i9 = aVar;
            l4 = l5;
            i6 = longValue;
            l3 = l4;
        } else {
        }
        if (t1Var10.a.q()) {
            obj5.b0 = obj;
            i10 = i6;
        } else {
            obj = 4;
            if (pair == null) {
                if (t1Var6.e != i7) {
                    obj5.Y0(obj);
                }
                obj5.q0(i3, i7, i3, i7);
            } else {
                if (first.equals(t1Var5.b)) {
                    com.google.android.exoplayer2.o1 o1Var = obj5.J.o();
                    if (o1Var != null && o1Var.d && Long.compare(i6, cmp2) != 0) {
                        if (o1Var.d) {
                            if (Long.compare(i6, cmp2) != 0) {
                                l2 = o1Var.a.m(i6, z);
                            } else {
                                l2 = i6;
                            }
                        } else {
                        }
                    } else {
                    }
                    cmp = obj5.O;
                    i3 = cmp.e;
                    if (Long.compare(i, i3) == 0 && i3 != 2 && i3 == 3) {
                        cmp = obj5.O;
                        i3 = cmp.e;
                        if (i3 != 2) {
                            if (i3 == 3) {
                            }
                        }
                        long l12 = cmp.s;
                        obj5.O = this.J(first, l12, i6, l3, i3, l12);
                    }
                } else {
                    l2 = i6;
                }
                i5 = t1Var7.e == obj ? i7 : 0;
                i = obj5.D0(first, l2, cmp2);
                if (Long.compare(i6, i) != 0) {
                } else {
                    i7 = 0;
                }
                obj = obj5.O;
                i6 = obj.a;
                this.j1(i6, first, i6, obj.b, l3);
                i9 = i7;
                i10 = i;
            }
        }
        obj5.O = this.J(first, i10, i6, l3, i3, i10);
    }

    private void D(IOException iOException, int i2) {
        com.google.android.exoplayer2.ExoPlaybackException obj2;
        Object obj3;
        obj3 = this.J.o();
        if (obj3 != null) {
            obj2 = ExoPlaybackException.c(iOException, i2).a(obj3.a);
        }
        v.d("ExoPlayerImplInternal", "Playback error", obj2);
        obj3 = 0;
        g1(obj3, obj3);
        this.O = this.O.f(obj2);
    }

    private long D0(y.a y$a, long l2, boolean z3) {
        int i;
        i = this.J.o() != this.J.p() ? 1 : 0;
        return this.E0(a, l2, obj4, i);
    }

    private void E(boolean z) {
        Object o1Var;
        y.a aVar;
        com.google.android.exoplayer2.t1 t1Var;
        long l;
        boolean obj6;
        o1Var = this.J.i();
        aVar = o1Var == null ? t1Var4.b : p1Var.a;
        equals ^= 1;
        if (i != 0) {
            this.O = this.O.b(aVar);
        }
        com.google.android.exoplayer2.t1 t1Var2 = this.O;
        if (o1Var == null) {
            l = t1Var2.s;
        } else {
            l = o1Var.i();
        }
        t1Var2.q = l;
        t1Var3.r = A();
        if (i == 0) {
            if (z && o1Var != null && o1Var.d) {
                if (o1Var != null) {
                    if (o1Var.d) {
                        k1(o1Var.n(), o1Var.o());
                    }
                }
            }
        } else {
        }
    }

    private long E0(y.a y$a, long l2, boolean z3, boolean z4) {
        int i;
        com.google.android.exoplayer2.o1 o1Var;
        boolean equals;
        com.google.android.exoplayer2.z1 z1Var;
        int obj7;
        long obj8;
        w obj9;
        long obj10;
        int obj11;
        h1();
        final int i2 = 0;
        this.T = i2;
        final int i3 = 2;
        if (obj11 == null) {
            if (obj11.e == 3) {
                Y0(i3);
            }
        } else {
        }
        obj11 = this.J.o();
        o1Var = obj11;
        while (o1Var != null) {
            if (a.equals(p1Var.a)) {
                break;
            } else {
            }
            o1Var = o1Var.j();
        }
        int i4 = 0;
        if (z4 == 0 && obj11 == o1Var) {
            if (obj11 == o1Var) {
                if (o1Var != null && Long.compare(obj10, i4) < 0) {
                    if (Long.compare(obj10, i4) < 0) {
                        obj7 = this.a;
                        obj11 = i2;
                        while (obj11 < obj7.length) {
                            l(obj7[obj11]);
                            obj11++;
                        }
                        if (o1Var != null) {
                        }
                    }
                }
            } else {
            }
        } else {
        }
        if (o1Var != null) {
            this.J.z(o1Var);
            if (!o1Var.d) {
                o1Var.f = o1Var.f.b(l2);
            } else {
                if (o1Var.e) {
                    obj7 = o1Var.a.l(l2);
                    o1Var.a.u(obj7 - obj10, obj11);
                    obj8 = obj7;
                }
            }
            s0(obj8);
            U();
        } else {
            this.J.e();
            s0(l2);
        }
        E(i2);
        this.y.f(i3);
        return obj8;
    }

    private void F(com.google.android.exoplayer2.g2 g2, boolean z2) {
        boolean z3;
        boolean cmp;
        com.google.android.exoplayer2.g2 g2Var3;
        com.google.android.exoplayer2.t1 t1Var2;
        int equals;
        boolean z;
        com.google.android.exoplayer2.q1 q1Var;
        com.google.android.exoplayer2.t1 t1Var3;
        com.google.android.exoplayer2.g2 g2Var2;
        Object equals2;
        Object g2Var;
        y.a aVar3;
        long hVar;
        long aVar4;
        int i10;
        y.a aVar2;
        long i8;
        long aVar;
        int i;
        long l;
        Object obj;
        long gVar;
        com.google.android.exoplayer2.t1 t1Var;
        int l3;
        int i4;
        long l4;
        int i13;
        int i9;
        int i6;
        int i2;
        int i5;
        int i7;
        int i11;
        int i12;
        long l2;
        int i3;
        final Object obj3 = this;
        final com.google.android.exoplayer2.g2 g2Var7 = g2;
        gVar = g1.w0(g2, obj3.O, obj3.b0, obj3.J, obj3.V, obj3.W, obj3.B, obj3.C);
        y.a aVar8 = gVar.a;
        l3 = gVar.c;
        l4 = gVar.b;
        int i19 = 1;
        i8 = 0;
        if (t1Var11.b.equals(aVar8)) {
            if (Long.compare(l4, l6) != 0) {
                i6 = i19;
            } else {
                i6 = i8;
            }
        } else {
        }
        i5 = 3;
        int i16 = 4;
        if (gVar.e && t1Var12.e != i19) {
            if (t1Var12.e != i19) {
                obj3.Y0(i16);
            }
            obj3.q0(i8, i8, i8, i19);
        }
        if (i6 == 0) {
            int i20 = -1;
            i12 = 4;
            if (!obj3.J.F(g2, obj3.c0, i16)) {
                obj3.B0(i8);
            }
        } else {
            i12 = i16;
            i9 = i8;
            if (!g2.q()) {
                q1Var = obj3.J.o();
                while (q1Var != null) {
                    if (p1Var.a.equals(aVar8)) {
                    }
                    q1Var = q1Var.j();
                    q1Var.f = obj3.J.q(g2Var7, q1Var.f);
                    q1Var.A();
                }
                l4 = z3;
            }
        }
        com.google.android.exoplayer2.t1 t1Var4 = obj3.O;
        com.google.android.exoplayer2.g2 g2Var6 = t1Var4.a;
        l = gVar.f ? l4 : l8;
        this.j1(g2, aVar8, g2Var6, t1Var4.b, l);
        if (i6 == 0) {
            if (Long.compare(l3, l5) != 0) {
                com.google.android.exoplayer2.t1 t1Var5 = obj3.O;
                Object obj2 = aVar6.a;
                g2Var3 = t1Var5.a;
                if (i6 != 0 && z2 && !g2Var3.q() && !bVar.f) {
                    if (z2) {
                        if (!g2Var3.q()) {
                            i3 = !bVar.f ? 1 : i9;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (g2Var7.b(obj2) == -1) {
                    i5 = i12;
                }
                obj3.O = this.J(aVar8, l4, g2Var6, l3, l, t1Var6.d);
            }
        } else {
        }
        r0();
        obj3.v0(g2Var7, t1Var7.a);
        obj3.O = obj3.O.j(g2Var7);
        if (!g2.q()) {
            obj3.b0 = 0;
        }
        obj3.E(i9);
    }

    private void F0(com.google.android.exoplayer2.w1 w1) {
        ArrayList dVar;
        com.google.android.exoplayer2.g1.d dVar2;
        long l;
        com.google.android.exoplayer2.g2 g2Var;
        com.google.android.exoplayer2.g2 g2Var2;
        int i;
        boolean z;
        com.google.android.exoplayer2.g2.c cVar;
        com.google.android.exoplayer2.g2.b bVar;
        Object obj10;
        if (Long.compare(l2, l) == 0) {
            G0(w1);
        } else {
            if (t1Var.a.q()) {
                dVar2 = new g1.d(w1);
                this.G.add(dVar2);
            } else {
                dVar = new g1.d(w1);
                g2Var2 = t1Var2.a;
                if (g1.u0(dVar, g2Var2, g2Var2, this.V, this.W, this.B, this.C)) {
                    this.G.add(dVar);
                    Collections.sort(this.G);
                } else {
                    w1.k(false);
                }
            }
        }
    }

    private void G(w w) {
        Object o1Var;
        Object oVar;
        y.a aVar;
        long l3;
        long l2;
        long l;
        int i;
        int i2;
        Object obj12;
        if (!this.J.u(w)) {
        }
        obj12 = this.J.i();
        obj12.p(u1Var.a, t1Var.a);
        oVar = obj12.o();
        k1(obj12.n(), oVar);
        if (obj12 == this.J.o()) {
            s0(p1Var.b);
            p();
            o1Var = this.O;
            l = obj12.b;
            this.O = this.J(o1Var.b, l, obj4, o1Var.c, obj6, l);
        }
        U();
    }

    private void G0(com.google.android.exoplayer2.w1 w1) {
        int i;
        int i2;
        s obj3;
        if (w1.c() == this.A) {
            k(w1);
            obj3 = obj3.e;
            i2 = 2;
            if (obj3 != 3) {
                if (obj3 == i2) {
                    this.y.f(i2);
                }
            } else {
            }
        } else {
            this.y.j(15, w1).a();
        }
    }

    private void H(com.google.android.exoplayer2.u1 u1, float f2, boolean z3, boolean z4) {
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        float f;
        com.google.android.exoplayer2.g1.e obj6;
        int obj7;
        if (z3 != null && z4 != 0) {
            if (z4 != 0) {
                this.P.b(1);
            }
            this.O = this.O.g(u1);
        }
        n1(u1.a);
        obj6 = this.a;
        i = 0;
        while (i < obj6.length) {
            z1Var = obj6[i];
            if (z1Var != null) {
            }
            i++;
            z1Var.p(f2, u1.a);
        }
    }

    private void H0(com.google.android.exoplayer2.w1 w1) {
        Looper looper = w1.c();
        if (!looper.getThread().isAlive()) {
            v.h("TAG", "Trying to send message on a dead thread.");
            w1.k(false);
        }
        b0 b0Var = new b0(this, w1);
        this.H.c(looper, 0).b(b0Var);
    }

    private void I(com.google.android.exoplayer2.u1 u1, boolean z2) {
        H(u1, u1.a, true, z2);
    }

    private void I0(long l) {
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        com.google.android.exoplayer2.source.f0 stream;
        final com.google.android.exoplayer2.z1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            z1Var = objArr[i];
            if (z1Var.getStream() != null) {
            }
            i++;
            J0(z1Var, l);
        }
    }

    private com.google.android.exoplayer2.t1 J(y.a y$a, long l2, long l3, long l4, boolean z5, int i6) {
        int i;
        Object list;
        boolean equals;
        long l;
        Object l0Var2;
        Object oVar;
        boolean equals2;
        com.google.android.exoplayer2.p1 p1Var;
        int cmp;
        l0 l0Var;
        o oVar2;
        Object vVar;
        final Object obj = this;
        y.a aVar2 = a;
        long l6 = l4;
        if (!obj.e0 && Long.compare(l2, l) == 0) {
            if (Long.compare(l2, l) == 0) {
                if (!a.equals(t1Var5.b)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        obj.e0 = i;
        r0();
        com.google.android.exoplayer2.t1 t1Var = obj.O;
        if (obj.K.r()) {
            list = obj.J.o();
            if (list == null) {
                l0Var2 = l0.v;
            } else {
                l0Var2 = list.n();
            }
            if (list == null) {
                oVar = obj.v;
            } else {
                oVar = list.o();
            }
            p1Var = list.f;
            if (list != null && Long.compare(l9, l6) != 0) {
                p1Var = list.f;
                if (Long.compare(l9, l6) != 0) {
                    list.f = p1Var.a(l6);
                }
            }
            l0Var = l0Var2;
            oVar2 = oVar;
            vVar = equals2;
        } else {
            if (!a.equals(t1Var6.b)) {
                l0Var = list;
                oVar2 = l0Var2;
                vVar = oVar;
            } else {
                vVar = list;
                l0Var = l0Var2;
                oVar2 = oVar;
            }
        }
        if (obj22 != null) {
            obj.P.e(obj23);
        }
        return obj.O.c(a, l2, oVar, l4, obj6, i6, p1Var, A());
    }

    private void J0(com.google.android.exoplayer2.z1 z1, long l2) {
        z1.l();
        if (z1 instanceof l) {
            (l)z1.a0(l2);
        }
    }

    private boolean K(com.google.android.exoplayer2.z1 z1, com.google.android.exoplayer2.o1 o12) {
        com.google.android.exoplayer2.o1 o1Var;
        Object obj3;
        boolean obj4;
        o1Var = o12.j();
        if (obj4.f && o1Var.d) {
            if (o1Var.d) {
                if (!z1 instanceof l) {
                    obj3 = Long.compare(obj3, o1Var) >= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void K0(boolean z, AtomicBoolean atomicBoolean2) {
        boolean length;
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        boolean z2;
        boolean obj5;
        this.X = z;
        if (this.X != z && !z) {
            this.X = z;
            if (!z) {
                obj5 = this.a;
                i = 0;
                while (i < obj5.length) {
                    z1Var = obj5[i];
                    if (!g1.N(z1Var)) {
                    }
                    i++;
                    z1Var.reset();
                }
            }
        }
        if (atomicBoolean2 != null) {
            atomicBoolean2.set(true);
            notifyAll();
            synchronized (this) {
                atomicBoolean2.set(true);
                notifyAll();
            }
        }
    }

    private boolean L() {
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        com.google.android.exoplayer2.source.f0 f0Var;
        com.google.android.exoplayer2.source.f0 stream;
        com.google.android.exoplayer2.o1 o1Var = this.J.p();
        final int i3 = 0;
        if (!o1Var.d) {
            return i3;
        }
        i = i3;
        com.google.android.exoplayer2.z1[] objArr = this.a;
        for (Object z1Var : obj3) {
            f0Var = o1Var.c[i];
            objArr = this.a;
        }
        return 1;
    }

    private void L0(com.google.android.exoplayer2.g1.b g1$b) {
        int hVar;
        int x1Var;
        int i;
        long l;
        this.P.b(1);
        if (g1.b.a(b) != -1) {
            x1Var = new x1(g1.b.b(b), g1.b.c(b));
            hVar = new g1.h(x1Var, g1.b.a(b), g1.b.d(b), obj4);
            this.b0 = hVar;
        }
        F(this.K.C(g1.b.b(b), g1.b.c(b)), false);
    }

    private boolean M() {
        com.google.android.exoplayer2.o1 o1Var = this.J.i();
        final int i2 = 0;
        if (o1Var == null) {
            return i2;
        }
        if (Long.compare(l, l2) == 0) {
            return i2;
        }
        return 1;
    }

    private static boolean N(com.google.android.exoplayer2.z1 z1) {
        int obj0;
        obj0 = z1.getState() != 0 ? 1 : 0;
        return obj0;
    }

    private void N0(boolean z) {
        com.google.android.exoplayer2.t1 t1Var;
        int i;
        Object obj4;
        if (z == this.Z) {
        }
        this.Z = z;
        t1Var = this.O;
        final int i2 = t1Var.e;
        if (!z && i2 != 4) {
            if (i2 != 4) {
                if (i2 == 1) {
                    this.O = t1Var.d(z);
                } else {
                    this.y.f(2);
                }
            } else {
            }
        } else {
        }
    }

    private boolean O() {
        int cmp;
        int i;
        long l;
        com.google.android.exoplayer2.o1 o1Var = this.J.o();
        long l2 = p1Var.e;
        if (o1Var.d) {
            if (Long.compare(l2, l) != 0 && Long.compare(l, l2) >= 0) {
                if (Long.compare(l, l2) >= 0) {
                    i = !b1() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void O0(boolean z) {
        com.google.android.exoplayer2.o1 o1Var;
        boolean obj2;
        this.R = z;
        r0();
        if (this.S && this.J.p() != this.J.o()) {
            if (this.J.p() != this.J.o()) {
                B0(true);
                E(false);
            }
        }
    }

    private static boolean P(com.google.android.exoplayer2.t1 t1, com.google.android.exoplayer2.g2.b g2$b2) {
        Object aVar;
        int obj2;
        obj2 = t1.a;
        if (!obj2.q()) {
            if (obj2.f) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    private Boolean Q() {
        return Boolean.valueOf(this.Q);
    }

    private void Q0(boolean z, int i2, boolean z3, int i4) {
        boolean obj2;
        int obj3;
        com.google.android.exoplayer2.t1 obj4;
        this.P.b(z3);
        this.P.c(i4);
        this.O = this.O.e(z, i2);
        this.T = false;
        f0(z);
        if (!b1()) {
            h1();
            m1();
        } else {
            obj2 = obj2.e;
            obj4 = 2;
            if (obj2 == 3) {
                e1();
                this.y.f(obj4);
            } else {
                if (obj2 == obj4) {
                    this.y.f(obj4);
                }
            }
        }
    }

    private void R0(com.google.android.exoplayer2.u1 u1) {
        this.F.h(u1);
        I(this.F.e(), true);
    }

    private void S(com.google.android.exoplayer2.w1 w1) {
        try {
            k(w1);
            String runtimeException = "ExoPlayerImplInternal";
            v.d(runtimeException, "Unexpected error delivering message on external thread.", w1);
            runtimeException = new RuntimeException(w1);
            throw runtimeException;
        }
    }

    private void T0(int i) {
        boolean obj3;
        this.V = i;
        if (!this.J.G(t1Var.a, i)) {
            B0(true);
        }
        E(false);
    }

    private void U() {
        boolean z;
        long l;
        z = a1();
        this.U = z;
        if (z) {
            this.J.i().d(this.c0);
        }
        i1();
    }

    private void U0(com.google.android.exoplayer2.d2 d2) {
        this.N = d2;
    }

    private void V() {
        boolean eVar;
        com.google.android.exoplayer2.t1 t1Var;
        this.P.d(this.O);
        if (g1.e.a(this.P)) {
            this.I.a(this.P);
            eVar = new g1.e(this.O);
            this.P = eVar;
        }
    }

    private boolean W(long l, long l2) {
        boolean z;
        if (this.Z && this.Y) {
            if (this.Y) {
                return 0;
            }
        }
        z0(l, l2);
        return 1;
    }

    private void W0(boolean z) {
        boolean obj3;
        this.W = z;
        if (!this.J.H(t1Var.a, z)) {
            B0(true);
        }
        E(false);
    }

    private void X(long l, long l2) {
        boolean empty;
        boolean z;
        int i2;
        int i;
        Object cmp;
        int size;
        int cmp3;
        int cmp2;
        int obj8;
        if (!this.G.isEmpty()) {
            if (t1Var.b.b()) {
            } else {
                if (this.e0) {
                    l -= i3;
                    this.e0 = false;
                }
                com.google.android.exoplayer2.t1 t1Var2 = this.O;
                empty = t1Var2.a.b(aVar2.a);
                i2 = Math.min(this.d0, this.G.size());
                i = 0;
                if (i2 > 0) {
                    cmp = this.G.get(i2 + -1);
                } else {
                    cmp = i;
                }
                while (cmp != null) {
                    cmp3 = cmp.b;
                    i2--;
                    if (i2 <= 0) {
                        break;
                    } else {
                    }
                    cmp = this.G.get(i2 + -1);
                    if (cmp3 == empty) {
                        break;
                    }
                    if (Long.compare(l3, obj8) > 0) {
                        break;
                    }
                }
                if (i2 < this.G.size()) {
                    cmp = this.G.get(i2);
                } else {
                    cmp = i;
                }
                while (cmp != null) {
                    if (cmp.v != null) {
                        break;
                    }
                    cmp3 = cmp.b;
                    i2++;
                    if (i2 >= this.G.size()) {
                        break;
                    } else {
                    }
                    cmp = this.G.get(i2);
                    if (cmp3 == empty) {
                        break;
                    }
                    if (Long.compare(l4, obj8) <= 0) {
                        break;
                    }
                }
                while (cmp != null) {
                    if (cmp.v != null) {
                    }
                    if (cmp.b == empty) {
                    }
                    cmp3 = cmp.c;
                    if (Long.compare(cmp3, obj8) > 0) {
                    }
                    if (Long.compare(cmp3, obj10) <= 0) {
                    }
                    G0(cmp.a);
                    if (cmp.a.b() == 0) {
                    } else {
                    }
                    this.G.remove(i2);
                    if (i2 < this.G.size()) {
                    } else {
                    }
                    cmp = i;
                    cmp = this.G.get(i2);
                    if (cmp.a.j()) {
                    } else {
                    }
                    i2++;
                }
                this.d0 = i2;
            }
        }
    }

    private void X0(h0 h0) {
        this.P.b(1);
        F(this.K.D(h0), false);
    }

    private void Y() {
        boolean z;
        boolean z2;
        com.google.android.exoplayer2.o1 o1Var;
        long l;
        Object obj;
        com.google.android.exoplayer2.t1 t1Var;
        com.google.android.exoplayer2.q1 q1Var;
        com.google.android.exoplayer2.a2[] objArr;
        n nVar;
        com.google.android.exoplayer2.upstream.f fVar;
        com.google.android.exoplayer2.s1 s1Var;
        com.google.android.exoplayer2.p1 p1Var;
        o oVar;
        this.J.y(this.c0);
        z = this.J.n(this.c0, obj2);
        q1Var = this.J;
        l = q1Var.f(this.b, this.c, this.w.k(), this.K, z, this.v);
        l.a.p(this, z.b);
        if (this.J.D() && z != null && this.J.o() == l) {
            z = this.J.n(this.c0, obj2);
            if (z != null) {
                q1Var = this.J;
                l = q1Var.f(this.b, this.c, this.w.k(), this.K, z, this.v);
                l.a.p(this, z.b);
                if (this.J.o() == l) {
                    s0(l.m());
                }
                E(false);
            }
        }
        if (this.U) {
            this.U = M();
            i1();
        } else {
            U();
        }
    }

    private void Y0(int i) {
        int obj3;
        final com.google.android.exoplayer2.t1 t1Var = this.O;
        if (t1Var.e != i) {
            this.O = t1Var.h(i);
        }
    }

    private void Z() {
        int i;
        com.google.android.exoplayer2.p1 p1Var;
        com.google.android.exoplayer2.t1 t1Var;
        Object obj;
        com.google.android.exoplayer2.g2 g2Var;
        y.a aVar;
        long l;
        y.a aVar2;
        boolean z;
        long l2;
        int i2;
        int i3;
        i = 0;
        while (Z0()) {
            if (i != 0) {
            }
            com.google.android.exoplayer2.o1 o1Var2 = this.J.a();
            com.google.android.exoplayer2.p1 p1Var3 = o1Var2.f;
            l2 = p1Var3.b;
            obj = this;
            t1Var = obj.J(p1Var3.a, l2, l, p1Var3.c, z, l2);
            this.O = t1Var;
            l = t1Var.a;
            obj.j1(l, p1Var.a, l, p1Var2.a, -9223372036854775807L);
            r0();
            m1();
            i = 1;
            V();
        }
    }

    private boolean Z0() {
        com.google.android.exoplayer2.o1 o1Var;
        int i;
        int cmp;
        long l;
        i = 0;
        if (!b1()) {
            return i;
        }
        if (this.S) {
            return i;
        }
        com.google.android.exoplayer2.o1 o1Var2 = this.J.o();
        if (o1Var2 == null) {
            return i;
        }
        o1Var = o1Var2.j();
        if (o1Var != null && Long.compare(l2, l) >= 0 && o1Var.g) {
            if (Long.compare(l2, l) >= 0) {
                if (o1Var.g) {
                    i = 1;
                }
            }
        }
        return i;
    }

    private void a0() {
        boolean cmp2;
        com.google.android.exoplayer2.o1 o1Var;
        boolean z;
        long cmp4;
        int i;
        boolean z2;
        int i2;
        long length;
        long cmp;
        boolean equals;
        com.google.android.exoplayer2.source.f0 stream;
        long cmp3;
        com.google.android.exoplayer2.b2 b2Var;
        com.google.android.exoplayer2.o1 o1Var2 = this.J.p();
        if (o1Var2 == null) {
        }
        cmp4 = -9223372036854775807L;
        i2 = 0;
        if (o1Var2.j() != null) {
            if (this.S) {
            } else {
                if (!L()) {
                }
                if (!o1Var3.d && Long.compare(length, cmp3) < 0) {
                    if (Long.compare(length, cmp3) < 0) {
                    }
                }
                o oVar = o1Var2.o();
                com.google.android.exoplayer2.o1 o1Var5 = this.J.b();
                o oVar2 = o1Var5.o();
                if (o1Var5.d && Long.compare(equals, cmp4) != 0) {
                    if (Long.compare(equals, cmp4) != 0) {
                        I0(o1Var5.m());
                    }
                }
                i = i2;
                for (Object z2 : obj3) {
                    if (oVar.c(i) && !this.a[i].z()) {
                    }
                    if (!this.a[i].z()) {
                    }
                    if (this.b[i].i() == 7) {
                    } else {
                    }
                    z2 = i2;
                    cmp3 = oVar.b[i];
                    if (oVar2.c(i) && oVar2.b[i].equals(cmp3)) {
                    } else {
                    }
                    J0(z2, o1Var5.m());
                    if (b2Var.equals(cmp3)) {
                    } else {
                    }
                    if (z2 != 0) {
                    }
                    z2 = 1;
                }
            }
        }
        if (!p1Var.i && this.S) {
            if (this.S) {
            }
        }
    }

    private boolean a1() {
        long l;
        long l2;
        long l3;
        long l4;
        if (!M()) {
            return 0;
        }
        com.google.android.exoplayer2.o1 o1Var = this.J.i();
        if (o1Var == this.J.o()) {
            l4 = l;
        } else {
            l4 = l2;
        }
        return this.w.j(l4, obj5, B(o1Var.k()));
    }

    private void b0() {
        com.google.android.exoplayer2.o1 o1Var2;
        com.google.android.exoplayer2.o1 o1Var;
        o1Var2 = this.J.p();
        if (o1Var2 != null && this.J.o() != o1Var2) {
            if (this.J.o() != o1Var2) {
                if (o1Var2.g) {
                } else {
                    if (o0()) {
                        p();
                    }
                }
            }
        }
    }

    private boolean b1() {
        com.google.android.exoplayer2.t1 t1Var;
        int i;
        t1Var = this.O;
        if (t1Var.l && t1Var.m == 0) {
            i = t1Var.m == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    private void c0() {
        F(this.K.h(), true);
    }

    private boolean c1(boolean z) {
        int i;
        boolean z3;
        int i2;
        long l;
        com.google.android.exoplayer2.l1 l1Var;
        long l2;
        float f;
        boolean z2;
        com.google.android.exoplayer2.k1 obj13;
        if (this.a0 == 0) {
            return O();
        }
        i = 0;
        if (!z) {
            return i;
        }
        obj13 = this.O;
        final int i4 = 1;
        if (!obj13.g) {
            return i4;
        }
        if (d1(obj13.a, p1Var.a)) {
            l = this.L.c();
        } else {
            l = -9223372036854775807L;
        }
        obj13 = this.J.i();
        if (obj13.q() && p1Var2.i) {
            i2 = p1Var2.i ? i4 : i;
        } else {
        }
        if (p1Var3.a.b() && !obj13.d) {
            obj13 = !obj13.d ? i4 : i;
        } else {
        }
        if (i2 == 0 && obj13 == null) {
            if (obj13 == null) {
                if (this.w.i(A(), obj7, obj13.a, this.T)) {
                    i = i4;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void d0(com.google.android.exoplayer2.g1.c g1$c) {
        this.P.b(1);
        F(this.K.v(c.a, c.b, c.c, c.d), false);
    }

    private boolean d1(com.google.android.exoplayer2.g2 g2, y.a y$a2) {
        boolean z;
        int i;
        long l;
        boolean obj5;
        Object obj6;
        i = 0;
        if (!a2.b()) {
            if (g2.q()) {
            } else {
                g2.n(obj6.c, this.B);
                obj5 = this.B;
                if (this.B.f() && obj5.i && Long.compare(obj5, l) != 0) {
                    obj5 = this.B;
                    if (obj5.i) {
                        if (Long.compare(obj5, l) != 0) {
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    static boolean e(com.google.android.exoplayer2.g1 g1, boolean z2) {
        g1.Y = z2;
        return z2;
    }

    private void e0() {
        com.google.android.exoplayer2.o1 o1Var;
        g[] objArr;
        int length;
        int i;
        g gVar;
        o1Var = this.J.o();
        while (o1Var != null) {
            objArr = oVar.c;
            i = 0;
            while (i < objArr.length) {
                gVar = objArr[i];
                if (gVar != null) {
                }
                i++;
                gVar.r();
            }
            o1Var = o1Var.j();
            gVar = objArr[i];
            if (gVar != null) {
            }
            i++;
            gVar.r();
        }
    }

    private void e1() {
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        boolean z;
        this.T = false;
        this.F.f();
        com.google.android.exoplayer2.z1[] objArr = this.a;
        while (i < objArr.length) {
            z1Var = objArr[i];
            if (g1.N(z1Var)) {
            }
            i++;
            z1Var.start();
        }
    }

    static s f(com.google.android.exoplayer2.g1 g1) {
        return g1.y;
    }

    private void f0(boolean z) {
        com.google.android.exoplayer2.o1 o1Var;
        g[] objArr;
        int length;
        int i;
        g gVar;
        o1Var = this.J.o();
        while (o1Var != null) {
            objArr = oVar.c;
            i = 0;
            while (i < objArr.length) {
                gVar = objArr[i];
                if (gVar != null) {
                }
                i++;
                gVar.f(z);
            }
            o1Var = o1Var.j();
            gVar = objArr[i];
            if (gVar != null) {
            }
            i++;
            gVar.f(z);
        }
    }

    private void g(com.google.android.exoplayer2.g1.b g1$b, int i2) {
        int obj4;
        this.P.b(1);
        com.google.android.exoplayer2.s1 s1Var = this.K;
        if (i2 == -1) {
            obj4 = s1Var.p();
        }
        F(s1Var.e(obj4, g1.b.b(b), g1.b.c(b)), false);
    }

    private void g0() {
        com.google.android.exoplayer2.o1 o1Var;
        g[] objArr;
        int length;
        int i;
        g gVar;
        o1Var = this.J.o();
        while (o1Var != null) {
            objArr = oVar.c;
            i = 0;
            while (i < objArr.length) {
                gVar = objArr[i];
                if (gVar != null) {
                }
                i++;
                gVar.s();
            }
            o1Var = o1Var.j();
            gVar = objArr[i];
            if (gVar != null) {
            }
            i++;
            gVar.s();
        }
    }

    private void g1(boolean z, boolean z2) {
        int obj3;
        final int i = 0;
        final int i2 = 1;
        if (!z) {
            if (!this.X) {
                obj3 = i2;
            } else {
                obj3 = i;
            }
        } else {
        }
        q0(obj3, i, i2, i);
        this.P.b(z2);
        this.w.l();
        Y0(i2);
    }

    private void h() {
        B0(true);
    }

    private void h1() {
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        boolean z;
        this.F.g();
        com.google.android.exoplayer2.z1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            z1Var = objArr[i];
            if (g1.N(z1Var)) {
            }
            i++;
            r(z1Var);
        }
    }

    private void i1() {
        int i;
        com.google.android.exoplayer2.o1 o1Var;
        o1Var = this.J.i();
        if (!this.U) {
            if (o1Var != null && o1Var.a.c()) {
                if (o1Var.a.c()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        com.google.android.exoplayer2.t1 t1Var = this.O;
        if (i != t1Var.g) {
            this.O = t1Var.a(i);
        }
    }

    private void j0() {
        int i;
        int i3 = 1;
        this.P.b(i3);
        int i2 = 0;
        q0(i2, i2, i2, i3);
        this.w.d();
        int i4 = 2;
        i = t1Var.a.q() ? 4 : i4;
        Y0(i);
        this.K.w(this.x.d());
        this.y.f(i4);
    }

    private void j1(com.google.android.exoplayer2.g2 g2, y.a y$a2, com.google.android.exoplayer2.g2 g23, y.a y$a4, long l5) {
        boolean z;
        int obj4;
        int obj5;
        com.google.android.exoplayer2.k1 obj6;
        Object obj7;
        boolean obj8;
        if (!g2.q()) {
            if (!d1(g2, a2)) {
            } else {
                g2.n(bVar.c, this.B);
                com.google.android.exoplayer2.m1.f fVar = cVar2.k;
                p0.i(fVar);
                this.L.a((m1.f)fVar);
                long l = -9223372036854775807L;
                if (Long.compare(l5, l) != 0) {
                    obj5 = a2.a;
                    this.L.e(w(g2, obj5, l5));
                } else {
                    obj5 = 0;
                    if (!g23.q()) {
                        obj5 = obj5.a;
                    }
                    if (!p0.b(obj5, obj4.a)) {
                        this.L.e(l);
                    }
                }
            }
        }
        obj5 = obj5.n;
        if (Float.compare(obj4, obj6) != 0) {
            this.F.h(obj5);
        }
    }

    private void k(com.google.android.exoplayer2.w1 w1) {
        if (w1.j()) {
        }
        w1.f().v(w1.h(), w1.d());
        w1.k(true);
    }

    private void k1(l0 l0, o o2) {
        this.w.g(this.a, l0, o2.c);
    }

    private void l(com.google.android.exoplayer2.z1 z1) {
        if (!g1.N(z1)) {
        }
        this.F.a(z1);
        r(z1);
        z1.g();
        this.a0 = obj2--;
    }

    private void l0() {
        final int i = 1;
        int i2 = 0;
        q0(i, i2, i, i2);
        this.w.h();
        Y0(i);
        this.z.quit();
        this.Q = i;
        notifyAll();
        return;
        synchronized (this) {
            i = 1;
            i2 = 0;
            q0(i, i2, i, i2);
            this.w.h();
            Y0(i);
            this.z.quit();
            this.Q = i;
            notifyAll();
        }
    }

    private void l1() {
        boolean z;
        if (!t1Var.a.q()) {
            if (!this.K.r()) {
            } else {
                Y();
                a0();
                b0();
                Z();
            }
        }
    }

    private void m() {
        int i14;
        s l;
        int i13;
        com.google.android.exoplayer2.o1 cmp2;
        boolean z2;
        int z;
        int i6;
        boolean l2;
        int i8;
        long cmp3;
        int i;
        int i7;
        int i2;
        int i12;
        com.google.android.exoplayer2.t1 t1Var2;
        int i10;
        com.google.android.exoplayer2.source.f0 stream;
        int i3;
        int cmp;
        int stream2;
        int length;
        int i4;
        int i5;
        com.google.android.exoplayer2.z1[] i11;
        boolean length2;
        int i9;
        com.google.android.exoplayer2.t1 t1Var;
        final Object obj = this;
        l = obj.H.b();
        l1();
        int i16 = t1Var4.e;
        i10 = 1;
        if (i16 != i10) {
            i3 = 4;
            if (i16 == i3) {
            } else {
                cmp2 = obj.J.o();
                if (cmp2 == null) {
                    obj.z0(l, obj2);
                }
                n0.a("doSomeWork");
                m1();
                final int i20 = 0;
                if (cmp2.d) {
                    cmp2.a.u(l6 -= l4, obj11);
                    i4 = length;
                    cmp = i20;
                    i11 = obj.a;
                    while (cmp < i11.length) {
                        i5 = i11[cmp];
                        if (!g1.N(i5)) {
                        } else {
                        }
                        i5.u(obj.c0, i10);
                        if (length != 0 && i5.c()) {
                        } else {
                        }
                        length = i20;
                        if (cmp2.c[cmp] != i5.getStream()) {
                        } else {
                        }
                        i8 = i20;
                        if (i8 == 0 && i5.j()) {
                        } else {
                        }
                        i10 = i20;
                        if (i8 == 0 && i10 == 0 && !i5.a()) {
                        } else {
                        }
                        i6 = 1;
                        if (i4 != 0 && i6 != 0) {
                        } else {
                        }
                        i4 = i20;
                        if (i6 == 0) {
                        }
                        cmp++;
                        i10 = 1;
                        i11 = obj.a;
                        i5.w();
                        if (i6 != 0) {
                        } else {
                        }
                        i4 = 1;
                        if (i10 == 0) {
                        } else {
                        }
                        if (!i5.a()) {
                        } else {
                        }
                        if (i5.c()) {
                        } else {
                        }
                        i6 = i20;
                        if (i5.j()) {
                        } else {
                        }
                        i10 = 1;
                        i8 = 1;
                        if (i5.c()) {
                        } else {
                        }
                        length = 1;
                    }
                } else {
                    cmp2.a.k();
                    length = 1;
                    i4 = 1;
                }
                cmp3 = p1Var.e;
                if (length != 0 && cmp2.d) {
                    if (cmp2.d) {
                        if (Long.compare(cmp3, l5) != 0) {
                            i = Long.compare(cmp3, cmp) <= 0 ? 1 : i20;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (i != 0 && obj.S) {
                    if (obj.S) {
                        obj.S = i20;
                        obj.Q0(i20, t1Var10.m, i20, 5);
                    }
                }
                int i19 = 3;
                if (i != 0 && p1Var2.i) {
                    if (p1Var2.i) {
                        obj.Y0(i3);
                        h1();
                    } else {
                        if (t1Var7.e == 2 && obj.c1(i4)) {
                            if (obj.c1(i4)) {
                                obj.Y0(i19);
                                obj.f0 = 0;
                                if (b1()) {
                                    e1();
                                }
                            } else {
                                if (t1Var8.e == i19) {
                                    if (obj.a0 == 0) {
                                        if (O()) {
                                        } else {
                                            obj.T = b1();
                                            obj.Y0(2);
                                            if (obj.T) {
                                                g0();
                                                obj.L.d();
                                            }
                                            h1();
                                        }
                                    } else {
                                        obj.T = b1();
                                        obj.Y0(2);
                                        if (i4 == 0 && obj.T) {
                                        }
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
                if (t1Var9.e == 2) {
                    i2 = i20;
                    stream2 = obj.a;
                    for (Object stream2 : obj7) {
                        if (g1.N(stream2[i2]) && obj.a[i2].getStream() == cmp2.c[i2]) {
                        }
                        stream2 = obj.a;
                        if (obj.a[i2].getStream() == cmp2.c[i2]) {
                        }
                        stream2.w();
                    }
                    cmp2 = obj.O;
                    if (!cmp2.g && Long.compare(l3, stream2) < 0) {
                        if (Long.compare(l3, stream2) < 0) {
                            if (M()) {
                            } else {
                            }
                            IllegalStateException illegalStateException = new IllegalStateException("Playback stuck buffering and not loading");
                            throw illegalStateException;
                        }
                    }
                }
                z2 = obj.Z;
                t1Var2 = obj.O;
                if (z2 != t1Var2.o) {
                    obj.O = t1Var2.d(z2);
                }
                if (b1()) {
                    if (t1Var5.e != i19) {
                        z = t1Var6.e;
                        if (z == 2) {
                            z3 ^= i13;
                        } else {
                            t1Var2 = obj.a0;
                            if (t1Var2 != 0 && z != i3) {
                                if (z != i3) {
                                    obj.z0(l, obj2);
                                } else {
                                    obj.y.i(2);
                                }
                            } else {
                            }
                            i14 = i20;
                        }
                    } else {
                    }
                } else {
                }
                com.google.android.exoplayer2.t1 t1Var3 = obj.O;
                if (t1Var3.p != i14) {
                    obj.O = t1Var3.i(i14);
                }
            }
            obj.Y = i20;
            n0.c();
        }
        obj.y.i(2);
    }

    private void m0(int i, int i2, h0 h03) {
        this.P.b(1);
        F(this.K.A(i, i2, h03), false);
    }

    private void m1() {
        int cmp4;
        com.google.android.exoplayer2.t1 cmp3;
        w z;
        int cmp2;
        boolean cmp;
        long l4;
        long l;
        int i2;
        long l2;
        long l3;
        long l5;
        int i3;
        int i;
        com.google.android.exoplayer2.o1 o1Var = this.J.o();
        if (o1Var == null) {
        }
        l4 = -9223372036854775807L;
        if (o1Var.d) {
            l5 = l3;
        } else {
            l5 = l4;
        }
        final int i4 = 0;
        if (Long.compare(l5, l4) != 0) {
            s0(l5);
            if (Long.compare(l5, l6) != 0) {
                com.google.android.exoplayer2.t1 t1Var2 = this.O;
                this.O = this.J(t1Var2.b, l5, obj3, t1Var2.c, obj5, l5);
            }
        } else {
            i2 = o1Var != this.J.p() ? 1 : i4;
            cmp2 = this.F.i(i2);
            this.c0 = cmp2;
            cmp4 = o1Var.y(cmp2);
            X(t1Var8.s, obj3);
            l4.s = cmp4;
        }
        t1Var6.q = this.J.i().i();
        t1Var3.r = A();
        cmp3 = this.O;
        l = 3;
        cmp3 = this.L.b(u(), l);
        if (cmp3.l && cmp3.e == l && d1(cmp3.a, cmp3.b) && Float.compare(f, cmp) == 0 && Float.compare(f2, cmp3) != 0) {
            l = 3;
            if (cmp3.e == l) {
                if (d1(cmp3.a, cmp3.b)) {
                    if (Float.compare(f, cmp) == 0) {
                        cmp3 = this.L.b(u(), l);
                        if (Float.compare(f2, cmp3) != 0) {
                            this.F.h(t1Var7.n.b(cmp3));
                            H(t1Var5.n, u1Var4.a, i4, i4);
                        }
                    }
                }
            }
        }
    }

    private void n1(float f) {
        com.google.android.exoplayer2.o1 o1Var;
        g[] objArr;
        int length;
        int i;
        g gVar;
        o1Var = this.J.o();
        while (o1Var != null) {
            objArr = oVar.c;
            i = 0;
            while (i < objArr.length) {
                gVar = objArr[i];
                if (gVar != null) {
                }
                i++;
                gVar.p(f);
            }
            o1Var = o1Var.j();
            gVar = objArr[i];
            if (gVar != null) {
            }
            i++;
            gVar.p(f);
        }
    }

    private void o(int i, boolean z2) {
        int z;
        int i5;
        int i2;
        int i4;
        int i3;
        final Object obj = this;
        com.google.android.exoplayer2.z1 z1Var = obj.a[i];
        if (g1.N(z1Var)) {
        }
        com.google.android.exoplayer2.o1 o1Var = obj.J.p();
        int i9 = 0;
        int i10 = 1;
        i4 = o1Var == obj.J.o() ? i10 : i9;
        o oVar = o1Var.o();
        final com.google.android.exoplayer2.i1[] objArr6 = g1.v(oVar.c[i]);
        if (b1() && t1Var.e == 3) {
            i3 = t1Var.e == 3 ? i10 : i9;
        } else {
        }
        if (!z2 && i3 != 0) {
            i2 = i3 != 0 ? i10 : i9;
        } else {
        }
        obj.a0 = i7 += i10;
        z1Var.s(oVar.b[i], objArr6, o1Var.c[i], obj.c0, objArr6, i2, i4, o1Var.m());
        g1.a aVar = new g1.a(obj);
        z1Var.v(103, aVar);
        obj.F.b(z1Var);
        if (i3 != 0) {
            z1Var.start();
        }
    }

    private boolean o0() {
        int i3;
        int i;
        boolean z;
        int length;
        int i2;
        com.google.android.exoplayer2.z1 z1Var;
        com.google.android.exoplayer2.i1[] objArr;
        com.google.android.exoplayer2.source.f0 f0Var;
        long l;
        long l2;
        com.google.android.exoplayer2.o1 o1Var = this.J.p();
        final o oVar = o1Var.o();
        final int i5 = 0;
        i = i3;
        com.google.android.exoplayer2.z1[] objArr2 = this.a;
        i2 = 1;
        for (Object f0Var : obj5) {
            z1Var = objArr2[i3];
            if (!g1.N(z1Var)) {
            } else {
            }
            if (z1Var.getStream() != o1Var.c[i3]) {
            } else {
            }
            z = i5;
            if (oVar.c(i3) && z == 0) {
            } else {
            }
            if (!z1Var.z()) {
            } else {
            }
            if (z1Var.c()) {
            } else {
            }
            i = i2;
            objArr2 = this.a;
            i2 = 1;
            l(z1Var);
            z1Var.k(g1.v(oVar.c[i3]), f0Var, o1Var.m(), obj12);
            if (z == 0) {
            } else {
            }
            z = i2;
        }
        return i ^ 1;
    }

    private void o1(s<Boolean> s, long l2) {
        int i;
        i iVar;
        boolean booleanValue;
        Object obj6;
        int obj7;
        i = 0;
        synchronized (this) {
            try {
                while (!(Boolean)s.get().booleanValue()) {
                    if (Long.compare(obj7, i4) > 0) {
                    }
                    this.H.d();
                    wait(obj7);
                    obj7 = i2 - obj7;
                    l2 = 1;
                    int i3 = l2;
                }
                if (Long.compare(obj7, i4) > 0) {
                }
                this.H.d();
                wait(obj7);
                l2 = 1;
                i3 = l2;
                obj7 = i2 - obj7;
                if (i != 0) {
                }
                Thread.currentThread().interrupt();
                throw s;
            } catch (java.lang.InterruptedException interrupted) {
            } catch (Throwable th1) {
            }
        }
    }

    private void p() {
        q(new boolean[objArr.length]);
    }

    private void p0() {
        com.google.android.exoplayer2.t1 cmp;
        boolean[] zArr;
        int i;
        com.google.android.exoplayer2.o1 o1Var;
        y.a aVar;
        int i6;
        long l4;
        int length;
        int stream;
        int i7;
        long z;
        boolean z2;
        long l3;
        boolean[] zArr2;
        int i5;
        int i4;
        com.google.android.exoplayer2.o1 o1Var2;
        long l;
        o oVar;
        int i3;
        int i2;
        long l2;
        boolean[] zArr4;
        boolean[] zArr3;
        final Object obj2 = this;
        o1Var = obj2.J.o();
        stream = 1;
        while (o1Var != null) {
            oVar = o1Var.v(u1Var.a, t1Var5.a);
            i4 = 0;
            z2 = 1;
            if (o1Var == obj2.J.p()) {
            }
            o1Var = o1Var.j();
            stream = i7;
        }
    }

    private void q(boolean[] zArr) {
        int i2;
        int i;
        boolean z;
        com.google.android.exoplayer2.o1 o1Var = this.J.p();
        final o oVar = o1Var.o();
        i = i2;
        for (Object z : obj4) {
            if (!oVar.c(i)) {
            }
            z.reset();
        }
        while (i2 < objArr.length) {
            if (oVar.c(i2)) {
            }
            i2++;
            o(i2, zArr[i2]);
        }
        o1Var.g = true;
    }

    private void q0(boolean z, boolean z2, boolean z3, boolean z4) {
        com.google.android.exoplayer2.b1 b1Var;
        com.google.android.exoplayer2.t1 equals;
        int i2;
        Object obj;
        boolean z5;
        boolean z6;
        com.google.android.exoplayer2.ExoPlaybackException i;
        l0 l0Var;
        o oVar;
        com.google.android.exoplayer2.z1[] objArr;
        y.a first;
        int length;
        long longValue;
        int i3;
        String str;
        long l;
        String str2;
        final Object obj2 = this;
        obj2.y.i(2);
        i = 0;
        obj2.f0 = i;
        int i6 = 0;
        obj2.T = i6;
        obj2.F.g();
        obj2.c0 = 0;
        objArr = obj2.a;
        i3 = i6;
        str = "ExoPlayerImplInternal";
        while (i3 < objArr.length) {
            obj2.l(objArr[i3]);
            i3++;
            str = "ExoPlayerImplInternal";
            str2 = "Disable failed.";
            v.d(obj7, str2, str3);
        }
        if (z) {
            objArr = obj2.a;
            i3 = i6;
            while (i3 < objArr.length) {
                objArr[i3].reset();
                i3++;
                str2 = str3;
                Throwable str3 = "Reset failed.";
                v.d(obj7, str3, str2);
            }
        }
        obj2.a0 = i6;
        com.google.android.exoplayer2.t1 t1Var = obj2.O;
        first = t1Var.b;
        longValue = t1Var.s;
        if (!t1Var2.b.b()) {
            if (g1.P(obj2.O, obj2.C)) {
                l = equals.c;
            } else {
                l = equals.s;
            }
        } else {
        }
        obj2.b0 = i;
        Pair pair = obj2.y(t1Var4.a);
        longValue = (Long)pair.second.longValue();
        l = -9223372036854775807L;
        if (z2 && !(y.a)pair.first.equals(t1Var5.b)) {
            obj2.b0 = i;
            pair = obj2.y(t1Var4.a);
            longValue = (Long)pair.second.longValue();
            l = -9223372036854775807L;
            i2 = !(y.a)pair.first.equals(t1Var5.b) ? 1 : i6;
        } else {
        }
        final y.a aVar4 = first;
        final long l4 = longValue;
        obj2.J.e();
        obj2.U = i6;
        com.google.android.exoplayer2.t1 t1Var8 = obj2.O;
        if (z4) {
        } else {
            i = t1Var8.f;
        }
        l0Var = i2 != 0 ? l0.v : t1Var8.h;
        oVar = i2 != 0 ? obj2.v : t1Var8.i;
        if (i2 != 0) {
            obj = v.z();
        } else {
            try {
                obj = t1Var8.j;
                com.google.android.exoplayer2.t1 t1Var3 = obj2.O;
                super(t1Var8.a, aVar4, l, str2, l4, obj10, t1Var8.e, i, 0, l0Var, oVar, obj, aVar4, t1Var3.l, t1Var3.m, t1Var3.n, l4, obj22, 0, obj24, l4, obj26, obj2.Z, 0);
                obj2.O = t1Var7;
                if (z3) {
                }
                obj2.K.y();
            } catch (RuntimeException e) {
            }
        }
    }

    private void r(com.google.android.exoplayer2.z1 z1) {
        if (z1.getState() == 2) {
            z1.stop();
        }
    }

    private void r0() {
        int i;
        com.google.android.exoplayer2.o1 o1Var;
        o1Var = this.J.o();
        if (o1Var != null && p1Var.h && this.R) {
            if (p1Var.h) {
                i = this.R ? 1 : 0;
            } else {
            }
        } else {
        }
        this.S = i;
    }

    private void s0(long l) {
        int i;
        com.google.android.exoplayer2.z1 z1Var;
        boolean z;
        long obj5;
        com.google.android.exoplayer2.o1 o1Var = this.J.o();
        if (o1Var == null) {
        } else {
            obj5 = o1Var.z(l);
        }
        this.c0 = obj5;
        this.F.c(obj5);
        obj5 = this.a;
        i = 0;
        while (i < obj5.length) {
            z1Var = obj5[i];
            if (g1.N(z1Var)) {
            }
            i++;
            z1Var.y(this.c0);
        }
        e0();
    }

    private v<a> t(g[] gArr) {
        int i;
        int i2;
        Object aVar;
        com.google.android.exoplayer2.m2.a.b[] arr;
        v obj8;
        v.a aVar2 = new v.a();
        final int i3 = 0;
        i2 = i;
        while (i < gArr.length) {
            aVar = gArr[i];
            if (aVar != null) {
            }
            i++;
            aVar = i1Var.B;
            if (aVar == null) {
            } else {
            }
            aVar2.d(aVar);
            i2 = 1;
            aVar = new a(new a.b[i3]);
            aVar2.d(aVar);
        }
        if (i2 != 0) {
            obj8 = aVar2.e();
        } else {
            obj8 = v.z();
        }
        return obj8;
    }

    private static void t0(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.g1.d g1$d2, com.google.android.exoplayer2.g2.c g2$c3, com.google.android.exoplayer2.g2.b g2$b4) {
        int i;
        int l;
        int obj6 = obj6.p;
        long l2 = b4.d;
        i = Long.compare(l2, l) != 0 ? l2 - l : 9223372036854775807L;
        d2.c(obj6, i, obj1);
    }

    private long u() {
        com.google.android.exoplayer2.t1 t1Var = this.O;
        return w(t1Var.a, aVar.a, t1Var.s);
    }

    private static boolean u0(com.google.android.exoplayer2.g1.d g1$d, com.google.android.exoplayer2.g2 g22, com.google.android.exoplayer2.g2 g23, int i4, boolean z5, com.google.android.exoplayer2.g2.c g2$c6, com.google.android.exoplayer2.g2.b g2$b7) {
        int first;
        long l;
        boolean z;
        int longValue;
        int i2;
        int i;
        final Object obj = d;
        final com.google.android.exoplayer2.g2 g2Var4 = g22;
        first = g23;
        final com.google.android.exoplayer2.g2.c cVar4 = c6;
        final com.google.android.exoplayer2.g2.b bVar4 = b7;
        Object obj3 = obj.v;
        final int i12 = 0;
        final int i13 = 1;
        final long l8 = Long.MIN_VALUE;
        if (obj3 == null) {
            if (Long.compare(l3, l8) == 0) {
                l = -9223372036854775807L;
            } else {
                l = w0.d(obj.a.e());
            }
            g1.h hVar2 = new g1.h(obj.a.g(), obj.a.i(), l, obj3);
            int i10 = i4;
            Pair pair2 = g1.x0(g22, hVar2, false, i10, z5, c6, b7);
            if (pair2 == null) {
                return i12;
            }
            d.c(g2Var4.b(pair2.first), (Long)pair2.second.longValue(), i10);
            if (Long.compare(l5, l8) == 0) {
                g1.t0(g2Var4, d, cVar4, bVar4);
            }
            return i13;
        }
        int i3 = g2Var4.b(obj3);
        if (i3 == -1) {
            return i12;
        }
        if (Long.compare(l6, l8) == 0) {
            g1.t0(g2Var4, d, cVar4, bVar4);
            return i13;
        }
        obj.b = i3;
        first.h(obj.v, bVar4);
        if (bVar4.f && cVar.o == first.b(obj.v)) {
            if (cVar.o == first.b(obj.v)) {
                i2 = bVar.c;
                Pair pair = g22.j(c6, b7, i2, l2 + l7);
                d.c(g2Var4.b(pair.first), (Long)pair.second.longValue(), i2);
            }
        }
        return i13;
    }

    private static com.google.android.exoplayer2.i1[] v(g g) {
        int i;
        int length;
        com.google.android.exoplayer2.i1 i1Var;
        if (g != null) {
            length = g.length();
        } else {
            length = i;
        }
        final com.google.android.exoplayer2.i1[] arr = new i1[length];
        while (i < length) {
            arr[i] = g.h(i);
            i++;
        }
        return arr;
    }

    private void v0(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.g2 g22) {
        boolean z;
        int i2;
        boolean z3;
        Object obj;
        com.google.android.exoplayer2.g2 g2Var;
        com.google.android.exoplayer2.g2 g2Var2;
        int i;
        boolean z2;
        com.google.android.exoplayer2.g2.c cVar;
        com.google.android.exoplayer2.g2.b bVar;
        if (g2.q() && g22.q()) {
            if (g22.q()) {
            }
        }
        size--;
        while (i2 >= 0) {
            if (!g1.u0((g1.d)this.G.get(i2), g2, g22, this.V, this.W, this.B, this.C)) {
            }
            i2--;
            obj3.a.k(false);
            this.G.remove(i2);
        }
        Collections.sort(this.G);
    }

    private long w(com.google.android.exoplayer2.g2 g2, Object object2, long l3) {
        com.google.android.exoplayer2.g2.c obj5;
        int obj6;
        g2.n(obj6.c, this.B);
        obj5 = this.B;
        final long l5 = -9223372036854775807L;
        obj5 = this.B;
        obj6 = obj5.i;
        if (Long.compare(l, l5) != 0 && obj5.f() && obj6 == null) {
            if (obj5.f()) {
                obj5 = this.B;
                obj6 = obj5.i;
                if (obj6 == null) {
                }
                return obj5 -= obj7;
            }
        }
        return l5;
    }

    private static com.google.android.exoplayer2.g1.g w0(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.t1 t12, com.google.android.exoplayer2.g1.h g1$h3, com.google.android.exoplayer2.q1 q14, int i5, boolean z6, com.google.android.exoplayer2.g2.c g2$c7, com.google.android.exoplayer2.g2.b g2$b8) {
        long l;
        int i14;
        long longValue;
        int i15;
        Object first;
        long longValue2;
        long obj4;
        y.a aVar;
        int i12;
        int i2;
        int i8;
        int i11;
        int i4;
        int i9;
        int i3;
        boolean equals;
        Object g2Var;
        y.a aVar3;
        int i16;
        com.google.android.exoplayer2.g2.c cVar;
        int i6;
        Object first2;
        int i10;
        y.a aVar2;
        long l2;
        int i13;
        int i;
        int i7;
        com.google.android.exoplayer2.g2 g2Var9 = g2;
        Object obj7 = t12;
        Object obj8 = h3;
        final boolean z8 = z6;
        final com.google.android.exoplayer2.g2.b bVar8 = b8;
        if (g2.q()) {
            super(t1.l(), 0, obj4, -9223372036854775807L, obj6, 0, 1, 0);
            return gVar2;
        }
        y.a aVar6 = obj7.b;
        first2 = aVar6.a;
        final boolean z9 = g1.P(obj7, bVar8);
        if (!obj7.b.b()) {
            if (z9) {
                l = obj7.c;
            } else {
                l = obj7.s;
            }
        } else {
        }
        final long l6 = l;
        final long l7 = -9223372036854775807L;
        i16 = -1;
        i10 = 0;
        final int i33 = 1;
        if (obj8 != null) {
            aVar2 = aVar6;
            Pair pair3 = g1.x0(g2, h3, true, i5, z6, c7, b8);
            if (pair3 == null) {
                i16 = i20;
                longValue = l6;
                i9 = longValue2;
                i3 = i33;
            } else {
                if (Long.compare(l4, l7) == 0) {
                    i16 = bVar4.c;
                    longValue = l6;
                    longValue2 = i10;
                } else {
                    first2 = pair3.first;
                    longValue = (Long)pair3.second.longValue();
                    i16 = i6;
                    longValue2 = i33;
                }
                i9 = obj7.e == 4 ? i33 : i10;
                i3 = i10;
            }
            cVar = c7;
            i7 = longValue2;
            i13 = i9;
            i = i3;
            i2 = i16;
            aVar3 = aVar2;
        } else {
            aVar2 = aVar6;
            i6 = i16;
            if (obj7.a.q()) {
                i15 = g2Var9.a(z8);
                cVar = c7;
                i2 = i15;
                longValue = l6;
                i7 = i;
            } else {
            }
        }
        if (i2 != i6) {
            Pair pair2 = g2.j(c7, b8, i2, -9223372036854775807L);
            first2 = pair2.first;
            longValue = (Long)pair2.second.longValue();
            obj4 = q14;
            l2 = l7;
        } else {
            obj4 = q14;
            l2 = longValue;
        }
        aVar = obj4.A(g2Var9, first2, longValue);
        if (aVar.e != i6) {
            i4 = aVar3.e;
            if (i4 != i6 && aVar.b >= i4) {
                if (aVar.b >= i4) {
                    i8 = i33;
                } else {
                    i8 = i10;
                }
            } else {
            }
        } else {
        }
        equals = aVar3.a.equals(first2);
        if (equals && !aVar3.b() && !aVar.b() && i8 != 0) {
            if (!aVar3.b()) {
                if (!aVar.b()) {
                    i11 = i8 != 0 ? i33 : i10;
                } else {
                }
            } else {
            }
        } else {
        }
        g2Var9.h(first2, bVar8);
        if (equals && !z9 && Long.compare(l6, l2) == 0) {
            if (!z9) {
                if (Long.compare(l6, l2) == 0) {
                    if (aVar.b()) {
                        if (!bVar8.p(aVar.b)) {
                            if (aVar3.b() && bVar8.p(aVar3.b)) {
                                if (bVar8.p(aVar3.b)) {
                                    i10 = i33;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }
        if (i11 == 0) {
            if (i10 != 0) {
                aVar = aVar3;
            }
        } else {
        }
        if (aVar.b()) {
            if (aVar.equals(aVar3)) {
                longValue = obj7.s;
            } else {
                g2Var9.h(aVar.a, bVar8);
                if (aVar.c == bVar8.j(aVar.b)) {
                    longValue = b8.g();
                } else {
                    longValue = 0;
                }
            }
        }
        super(aVar, longValue, obj24, l2, obj26, i13, i, i7);
        return gVar;
    }

    private long x() {
        long l2;
        int i;
        boolean stream;
        int length;
        long l;
        int cmp;
        com.google.android.exoplayer2.o1 o1Var = this.J.p();
        if (o1Var == null) {
            return 0;
        }
        if (!o1Var.d) {
            return o1Var.l();
        }
        i = 0;
        com.google.android.exoplayer2.z1[] objArr = this.a;
        for (Object z1Var3 : obj4) {
            objArr = this.a;
            length = o1Var.c[i];
            stream = z1Var3.x();
            l = Long.MIN_VALUE;
            l2 = Math.max(stream, length);
        }
        return l2;
    }

    private static Pair<Object, Long> x0(com.google.android.exoplayer2.g2 g2, com.google.android.exoplayer2.g1.h g1$h2, boolean z3, int i4, boolean z5, com.google.android.exoplayer2.g2.c g2$c6, com.google.android.exoplayer2.g2.b g2$b7) {
        Object obj;
        Object pair;
        int i;
        boolean z;
        int i2;
        int first;
        long l;
        com.google.android.exoplayer2.g2 g2Var2;
        com.google.android.exoplayer2.g2 g2Var;
        com.google.android.exoplayer2.g2.c cVar;
        obj = h2;
        final com.google.android.exoplayer2.g2.b bVar6 = b7;
        com.google.android.exoplayer2.g2 g2Var3 = obj.a;
        final int i6 = 0;
        if (g2.q()) {
            return i6;
        }
        g2Var = g2Var3.q() ? obj3 : g2Var3;
        l = obj.c;
        pair = g2Var.j(c6, b7, obj.b, l);
        if (g2.equals(g2Var)) {
            return pair;
        }
        if (g2.b(pair.first) != -1 && bVar4.f && cVar6.o == g2Var.b(pair.first)) {
            if (bVar4.f) {
                if (cVar6.o == g2Var.b(pair.first)) {
                    pair = g2.j(c6, b7, bVar2.c, obj.c);
                }
            }
            return pair;
        }
        com.google.android.exoplayer2.g2.c cVar7 = c6;
        l = g2Var;
        obj = g1.y0(c6, b7, i4, z5, pair.first, l, g2);
        if (z3 && obj != null) {
            l = g2Var;
            obj = g1.y0(c6, b7, i4, z5, pair.first, l, g2);
            if (obj != null) {
                return g2.j(c6, b7, bVar.c, -9223372036854775807L);
            }
        }
        return i6;
    }

    private Pair<y.a, Long> y(com.google.android.exoplayer2.g2 g2) {
        boolean z;
        int i;
        long longValue;
        int obj10;
        i = 0;
        if (g2.q()) {
            return Pair.create(t1.l(), Long.valueOf(i));
        }
        final com.google.android.exoplayer2.g2.b bVar3 = this.C;
        Pair pair = g2.j(this.B, bVar3, g2.a(this.W), -9223372036854775807L);
        y.a aVar = this.J.A(g2, pair.first, i);
        longValue = (Long)pair.second.longValue();
        g2.h(aVar.a, this.C);
        if (aVar.b() && aVar.c == this.C.j(aVar.b)) {
            g2.h(aVar.a, this.C);
            if (aVar.c == this.C.j(aVar.b)) {
                i = this.C.g();
            }
            longValue = i;
        }
        return Pair.create(aVar, Long.valueOf(longValue));
    }

    static Object y0(com.google.android.exoplayer2.g2.c g2$c, com.google.android.exoplayer2.g2.b g2$b2, int i3, boolean z4, Object object5, com.google.android.exoplayer2.g2 g26, com.google.android.exoplayer2.g2 g27) {
        int i4;
        Object obj;
        int i2;
        com.google.android.exoplayer2.g2.b bVar;
        com.google.android.exoplayer2.g2.c cVar;
        int i;
        boolean z;
        int obj9;
        int obj13;
        final int i6 = -1;
        i4 = 0;
        i2 = obj13;
        obj13 = i6;
        while (i4 < g26.i()) {
            if (obj13 == i6) {
                break;
            }
            i2 = g26.d(i2, b2, c, i3, z4);
            if (i2 == i6) {
                break;
            } else {
            }
            obj13 = g27.b(g26.m(i2));
            i4++;
        }
        if (obj13 == i6) {
            obj9 = 0;
        } else {
            obj9 = g27.m(obj13);
        }
        return obj9;
    }

    private void z0(long l, long l2) {
        final int i = 2;
        this.y.i(i);
        this.y.h(i, l += obj5);
    }

    @Override // android.os.Handler$Callback
    public void A0(com.google.android.exoplayer2.g2 g2, int i2, long l3) {
        g1.h hVar = new g1.h(g2, i2, l3, obj6);
        this.y.j(3, hVar).a();
    }

    public void M0(List<com.google.android.exoplayer2.s1.c> list, int i2, long l3, h0 h04) {
        super(list, obj14, i2, l3, obj6, 0);
        this.y.j(17, bVar2).a();
    }

    @Override // android.os.Handler$Callback
    public void P0(boolean z, int i2) {
        this.y.a(1, z, i2).a();
    }

    @Override // android.os.Handler$Callback
    public Boolean R() {
        return Q();
    }

    @Override // android.os.Handler$Callback
    public void S0(int i) {
        this.y.a(11, i, 0).a();
    }

    @Override // android.os.Handler$Callback
    public void T(com.google.android.exoplayer2.w1 w1) {
        S(w1);
    }

    @Override // android.os.Handler$Callback
    public void V0(boolean z) {
        this.y.a(12, z, 0).a();
    }

    @Override // android.os.Handler$Callback
    public void a(com.google.android.exoplayer2.w1 w1) {
        boolean alive;
        synchronized (this) {
            try {
                if (!this.z.isAlive()) {
                }
                this.y.j(14, w1).a();
                v.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                w1.k(false);
                throw w1;
            }
        }
    }

    @Override // android.os.Handler$Callback
    public void b() {
        this.y.f(22);
    }

    @Override // android.os.Handler$Callback
    public void c(com.google.android.exoplayer2.u1 u1) {
        this.y.j(16, u1).a();
    }

    @Override // android.os.Handler$Callback
    public void f1() {
        this.y.c(6).a();
    }

    @Override // android.os.Handler$Callback
    public void h0(w w) {
        this.y.j(9, w).a();
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        String str;
        String str4;
        String str2;
        int i2;
        int i;
        boolean z;
        int what;
        int arg2;
        int obj8;
        str = "Playback error";
        str2 = "ExoPlayerImplInternal";
        i = 1000;
        final int i3 = 0;
        final int i4 = 1;
        switch (what) {
            case 0:
                j0();
                break;
            case 1:
                what = i4;
                what = i3;
                Q0(what, message.arg2, i4, i4);
                break;
            case 2:
                m();
                break;
            case 3:
                C0((g1.h)message.obj);
                break;
            case 4:
                R0((u1)message.obj);
                break;
            case 5:
                U0((d2)message.obj);
                break;
            case 6:
                g1(i3, i4);
                break;
            case 7:
                l0();
                return i4;
            case 8:
                G((w)message.obj);
                break;
            case 9:
                C((w)message.obj);
                break;
            case 10:
                p0();
                break;
            case 11:
                T0(message.arg1);
                break;
            case 12:
                obj8 = i4;
                obj8 = i3;
                W0(obj8);
                break;
            case 13:
                what = i4;
                what = i3;
                K0(what, (AtomicBoolean)message.obj);
                break;
            case 14:
                F0((w1)message.obj);
                break;
            case 15:
                H0((w1)message.obj);
                break;
            case 16:
                I((u1)message.obj, i3);
                break;
            case 17:
                L0((g1.b)message.obj);
                break;
            case 18:
                g((g1.b)message.obj, message.arg1);
                break;
            case 19:
                d0((g1.c)message.obj);
                break;
            case 20:
                m0(message.arg1, message.arg2, (h0)message.obj);
                break;
            case 21:
                X0((h0)message.obj);
                break;
            case 22:
                c0();
                break;
            case 23:
                obj8 = i4;
                obj8 = i3;
                O0(obj8);
                break;
            case 24:
                obj8 = i4;
                obj8 = i3;
                N0(obj8);
                break;
            case 25:
                h();
                break;
            default:
                return i3;
        }
        V();
        return i4;
    }

    @Override // android.os.Handler$Callback
    public void i(g0 g0) {
        h0((w)g0);
    }

    @Override // android.os.Handler$Callback
    public void i0() {
        this.y.c(0).a();
    }

    @Override // android.os.Handler$Callback
    public boolean k0() {
        boolean alive;
        synchronized (this) {
            try {
                if (!this.z.isAlive()) {
                }
                this.y.f(7);
                a0 a0Var = new a0(this);
                o1(a0Var, this.M);
                return this.Q;
                return 1;
                throw th;
            }
        }
    }

    @Override // android.os.Handler$Callback
    public void n(w w) {
        this.y.j(8, w).a();
    }

    @Override // android.os.Handler$Callback
    public void n0(int i, int i2, h0 h03) {
        this.y.g(20, i, i2, h03).a();
    }

    @Override // android.os.Handler$Callback
    public void s(long l) {
    }

    @Override // android.os.Handler$Callback
    public Looper z() {
        return this.A;
    }
}
