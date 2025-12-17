package com.google.android.exoplayer2;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.n2.o;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.y.a;
import com.google.common.collect.v;
import java.util.List;

/* loaded from: classes.dex */
final class t1 {

    private static final y.a t;
    public final com.google.android.exoplayer2.g2 a;
    public final y.a b;
    public final long c;
    public final long d;
    public final int e;
    public final com.google.android.exoplayer2.ExoPlaybackException f;
    public final boolean g;
    public final l0 h;
    public final o i;
    public final List<a> j;
    public final y.a k;
    public final boolean l;
    public final int m;
    public final com.google.android.exoplayer2.u1 n;
    public final boolean o;
    public final boolean p;
    public volatile long q;
    public volatile long r;
    public volatile long s;
    static {
        Object object = new Object();
        y.a aVar = new y.a(object);
        t1.t = aVar;
    }

    public t1(com.google.android.exoplayer2.g2 g2, y.a y$a2, long l3, long l4, int i5, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException6, boolean z7, l0 l08, o o9, List<a> list10, y.a y$a11, boolean z12, int i13, com.google.android.exoplayer2.u1 u114, long l15, long l16, long l17, boolean z18, boolean z19) {
        final Object obj = this;
        super();
        obj.a = g2;
        obj.b = a2;
        obj.c = l3;
        obj.d = i5;
        obj.e = z7;
        obj.f = l08;
        obj.g = o9;
        obj.h = list10;
        obj.i = a11;
        obj.j = z12;
        obj.k = i13;
        obj.l = u114;
        obj.m = l15;
        obj.n = l16;
        obj.q = l17;
        obj.r = z19;
        obj.s = obj24;
        obj.o = obj26;
        obj.p = obj27;
    }

    public static com.google.android.exoplayer2.t1 k(o o) {
        final y.a aVar3 = t1.t;
        super(g2.a, aVar3, -9223372036854775807L, obj4, 0, obj6, 1, 0, 0, l0.v, o, v.z(), aVar3, 0, 0, u1.d, 0, obj18, 0, obj20, 0, obj22, 0, 0);
        return t1Var2;
    }

    public static y.a l() {
        return t1.t;
    }

    public com.google.android.exoplayer2.t1 a(boolean z) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, z, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 b(y.a y$a) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, a, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 c(y.a y$a, long l2, long l3, long l4, long l5, l0 l06, o o7, List<a> list8) {
        final Object obj = this;
        super(obj.a, a, l4, obj5, l06, obj7, obj.e, obj.f, obj.g, obj37, obj38, obj39, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, list8, obj21, l2, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 d(boolean z) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, z, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 e(boolean z, int i2) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, z, i2, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 f(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, exoPlaybackException, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 g(com.google.android.exoplayer2.u1 u1) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, u1, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 h(int i) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, i, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 i(boolean z) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, z);
        return t1Var3;
    }

    public com.google.android.exoplayer2.t1 j(com.google.android.exoplayer2.g2 g2) {
        final Object obj = this;
        super(g2, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.q, obj19, obj.r, obj21, obj.s, obj23, obj.o, obj.p);
        return t1Var3;
    }
}
