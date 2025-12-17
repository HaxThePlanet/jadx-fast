package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.g2.b;
import com.google.android.exoplayer2.g2.c;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m1.c;
import com.google.android.exoplayer2.m1.f;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
public final class i0 extends g2 {

    private static final Object o;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final Object l;
    private final m1 m;
    private final m1.f n;
    static {
        Object object = new Object();
        i0.o = object;
        m1.c cVar = new m1.c();
        cVar.c("SinglePeriodTimeline");
        cVar.f(Uri.EMPTY);
        cVar.a();
    }

    public i0(long l, long l2, long l3, long l4, long l5, long l6, long l7, boolean z8, boolean z9, boolean z10, Object object11, m1 m112, m1.f m1$f13) {
        final Object obj = this;
        super();
        obj.b = l;
        obj.c = l3;
        obj.d = l5;
        obj.e = l7;
        obj.f = z9;
        obj.g = object11;
        obj.h = f13;
        obj.i = obj18;
        obj.j = obj19;
        obj.k = obj20;
        obj.l = obj21;
        g.e(obj22);
        obj.m = (m1)obj22;
        obj.n = obj23;
    }

    @Override // com.google.android.exoplayer2.g2
    public int b(Object object) {
        int obj2;
        obj2 = i0.o.equals(object) ? 0 : -1;
        return obj2;
    }

    @Override // com.google.android.exoplayer2.g2
    public g2.b g(int i, g2.b g2$b2, boolean z3) {
        Object obj9;
        g.c(i, 0, 1);
        obj9 = z3 ? i0.o : 0;
        b2.q(0, obj9, 0, this.e, obj5);
        return b2;
    }

    @Override // com.google.android.exoplayer2.g2
    public int i() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.g2
    public Object m(int i) {
        g.c(i, 0, 1);
        return i0.o;
    }

    @Override // com.google.android.exoplayer2.g2
    public g2.c o(int i, g2.c g2$c2, long l3) {
        long l;
        boolean cmp;
        int cmp2;
        long l2;
        final Object obj = this;
        g.c(i, 0, 1);
        final boolean z2 = obj.j;
        long l6 = -9223372036854775807L;
        if (z2 && !obj.k && Long.compare(l3, i5) != 0) {
            if (!obj.k) {
                if (Long.compare(l3, i5) != 0) {
                    cmp = obj.f;
                    if (Long.compare(cmp, l6) == 0) {
                        l2 = l6;
                    } else {
                    }
                } else {
                    l2 = l;
                }
            } else {
            }
        } else {
        }
        c2.g(g2.c.r, obj.m, obj.l, obj.b, obj8, obj.c, obj10, obj.d, obj12, obj.i, z2, obj.n, l2, obj17);
        return c2;
    }

    @Override // com.google.android.exoplayer2.g2
    public int p() {
        return 1;
    }
}
