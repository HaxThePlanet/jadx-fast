package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.d2;
import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class t implements com.google.android.exoplayer2.source.w, com.google.android.exoplayer2.source.w.a {

    private long A = -9223372036854775807L;
    public final com.google.android.exoplayer2.source.y.a a;
    private final long b;
    private final f c;
    private com.google.android.exoplayer2.source.y v;
    private com.google.android.exoplayer2.source.w w;
    private com.google.android.exoplayer2.source.w.a x;
    private com.google.android.exoplayer2.source.t.a y;
    private boolean z;

    public interface a {
        public abstract void a(com.google.android.exoplayer2.source.y.a y$a);

        public abstract void b(com.google.android.exoplayer2.source.y.a y$a, IOException iOException2);
    }
    public t(com.google.android.exoplayer2.source.y.a y$a, f f2, long l3) {
        super();
        this.a = a;
        this.c = f2;
        this.b = l3;
        final long obj1 = -9223372036854775807L;
    }

    private long t(long l) {
        long obj5;
        final long l2 = this.A;
        if (Long.compare(l2, l3) != 0) {
            obj5 = l2;
        }
        return obj5;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long a() {
        com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        return (w)wVar.a();
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean b(long l) {
        long obj2;
        final com.google.android.exoplayer2.source.w wVar = this.w;
        if (wVar != null && wVar.b(l)) {
            obj2 = wVar.b(l) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean c() {
        com.google.android.exoplayer2.source.w wVar;
        int i;
        wVar = this.w;
        if (wVar != null && wVar.c()) {
            i = wVar.c() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long e() {
        com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        return (w)wVar.e();
    }

    @Override // com.google.android.exoplayer2.source.w
    public void f(long l) {
        final com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        (w)wVar.f(l);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void g(com.google.android.exoplayer2.source.y.a y$a) {
        long l2 = t(this.b);
        com.google.android.exoplayer2.source.y yVar = this.v;
        g.e(yVar);
        final com.google.android.exoplayer2.source.w obj5 = (y)yVar.a(a, this.c, l2);
        this.w = obj5;
        if (this.x != null) {
            obj5.p(this, l2);
        }
    }

    @Override // com.google.android.exoplayer2.source.w
    public long h() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void i(com.google.android.exoplayer2.source.g0 g0) {
        v((w)g0);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void k() {
        Object wVar;
        boolean z;
        try {
            wVar = this.w;
            if (wVar != null) {
            } else {
            }
            wVar.k();
            wVar = this.v;
            if (wVar != null) {
            }
            wVar.j();
            com.google.android.exoplayer2.source.t.a aVar = this.y;
            if (aVar == null) {
            } else {
            }
            z = this.z;
            if (!z) {
            }
            z = true;
            this.z = z;
            z = this.a;
            aVar.b(z, th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.w
    public long l(long l) {
        final com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        return (w)wVar.l(l);
    }

    @Override // com.google.android.exoplayer2.source.w
    public long m(long l, d2 d22) {
        final com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        return (w)wVar.m(l, d22);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void n(com.google.android.exoplayer2.source.w w) {
        com.google.android.exoplayer2.source.y.a aVar;
        com.google.android.exoplayer2.source.w.a obj2 = this.x;
        p0.i(obj2);
        (w.a)obj2.n(this);
        obj2 = this.y;
        if (obj2 != null) {
            obj2.a(this.a);
        }
    }

    @Override // com.google.android.exoplayer2.source.w
    public long o() {
        com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        return (w)wVar.o();
    }

    @Override // com.google.android.exoplayer2.source.w
    public void p(com.google.android.exoplayer2.source.w.a w$a, long l2) {
        long obj2;
        this.x = a;
        final com.google.android.exoplayer2.source.w obj1 = this.w;
        if (obj1 != null) {
            obj1.p(this, t(this.b));
        }
    }

    @Override // com.google.android.exoplayer2.source.w
    public long q(g[] gArr, boolean[] z2Arr2, com.google.android.exoplayer2.source.f0[] f03Arr3, boolean[] z4Arr4, long l5) {
        int cmp;
        long l;
        final Object obj = this;
        long l2 = obj.A;
        final long l4 = -9223372036854775807L;
        if (Long.compare(l2, l4) != 0 && Long.compare(l5, l6) == 0) {
            l = Long.compare(l5, l6) == 0 ? l2 : l5;
        } else {
        }
        com.google.android.exoplayer2.source.w wVar = obj.w;
        p0.i(wVar);
        return (w)wVar.q(gArr, z2Arr2, f03Arr3, z4Arr4, l);
    }

    @Override // com.google.android.exoplayer2.source.w
    public com.google.android.exoplayer2.source.l0 r() {
        com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        return (w)wVar.r();
    }

    @Override // com.google.android.exoplayer2.source.w
    public long s() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void u(long l, boolean z2) {
        final com.google.android.exoplayer2.source.w wVar = this.w;
        p0.i(wVar);
        (w)wVar.u(l, z2);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void v(com.google.android.exoplayer2.source.w w) {
        final com.google.android.exoplayer2.source.w.a obj1 = this.x;
        p0.i(obj1);
        (w.a)obj1.i(this);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void w(long l) {
        this.A = l;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void x() {
        Object wVar2;
        com.google.android.exoplayer2.source.w wVar;
        if (this.w != null) {
            wVar2 = this.v;
            g.e(wVar2);
            (y)wVar2.l(this.w);
        }
    }

    @Override // com.google.android.exoplayer2.source.w
    public void y(com.google.android.exoplayer2.source.y y) {
        int i;
        i = this.v == null ? 1 : 0;
        g.f(i);
        this.v = y;
    }
}
