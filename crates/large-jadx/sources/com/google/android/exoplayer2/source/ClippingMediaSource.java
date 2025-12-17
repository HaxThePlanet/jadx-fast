package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.g2.b;
import com.google.android.exoplayer2.g2.c;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ClippingMediaSource extends com.google.android.exoplayer2.source.l<Void> {

    private final com.google.android.exoplayer2.source.y j;
    private final long k;
    private final long l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final ArrayList<com.google.android.exoplayer2.source.k> p;
    private final g2.c q;
    private com.google.android.exoplayer2.source.ClippingMediaSource.a r;
    private com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException s;
    private long t;
    private long u;

    public static final class IllegalClippingException extends IOException {

        public final int reason;
        public IllegalClippingException(int i) {
            String concat;
            String valueOf = String.valueOf(ClippingMediaSource.IllegalClippingException.a(i));
            final String str2 = "Illegal clipping: ";
            if (valueOf.length() != 0) {
                concat = str2.concat(valueOf);
            } else {
                concat = new String(str2);
            }
            super(concat);
            this.reason = i;
        }

        private static String a(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return "unknown";
                    }
                    return "start exceeds end";
                }
                return "not seekable to start";
            }
            return "invalid period count";
        }
    }

    private static final class a extends com.google.android.exoplayer2.source.r {

        private final long c = 2;
        private final long d = 0;
        private final long e = -9223372036854775807L;
        private final boolean f = true;
        public a(g2 g2, long l2, long l3) {
            boolean cmp;
            long obj11;
            super(g2);
            final int i2 = 0;
            final int i3 = 1;
            if (g2.i() != i3) {
            } else {
                g2.c cVar = new g2.c();
                g2.c obj8 = g2.n(i2, cVar);
                int i4 = 0;
                long obj9 = Math.max(i4, obj4);
                if (!obj8.l && Long.compare(obj9, i4) != 0) {
                    if (Long.compare(obj9, i4) != 0) {
                        if (!obj8.h) {
                        } else {
                        }
                        obj8 = new ClippingMediaSource.IllegalClippingException(i3);
                        throw obj8;
                    }
                }
                if (Long.compare(obj11, l4) == 0) {
                    obj11 = obj8.n;
                } else {
                    obj11 = Math.max(i4, obj4);
                }
                long l = obj8.n;
                obj11 = Long.compare(obj11, l) > 0 ? l : obj11;
                if (Long.compare(obj9, obj11) > 0) {
                } else {
                }
                obj8 = new ClippingMediaSource.IllegalClippingException(2);
                throw obj8;
            }
            obj8 = new ClippingMediaSource.IllegalClippingException(i2);
            throw obj8;
        }

        @Override // com.google.android.exoplayer2.source.r
        public g2.b g(int i, g2.b g2$b2, boolean z3) {
            long l;
            long l2;
            this.b.g(0, b2, z3);
            final int i4 = l3 - l4;
            l = this.e;
            long l5 = -9223372036854775807L;
            l2 = Long.compare(l, l5) == 0 ? l5 : l;
            b2.q(b2.a, b2.b, 0, l2, obj9);
            return b2;
        }

        @Override // com.google.android.exoplayer2.source.r
        public g2.c o(int i, g2.c g2$c2, long l3) {
            long l4;
            long l2;
            long l;
            int obj5;
            long obj7;
            this.b.o(0, c2, 0);
            l4 = this.c;
            c2.q = obj7 += l4;
            c2.n = this.e;
            c2.i = this.f;
            obj7 = c2.m;
            final long l6 = -9223372036854775807L;
            if (Long.compare(obj7, l6) != 0) {
                obj7 = Math.max(obj7, obj8);
                c2.m = obj7;
                long l5 = this.d;
                if (Long.compare(l5, l6) == 0) {
                } else {
                    obj7 = Math.min(obj7, obj8);
                }
                c2.m = obj7;
                c2.m = obj7 -= l4;
            }
            obj7 = w0.e(this.c);
            l2 = c2.e;
            if (Long.compare(l2, l6) != 0) {
                c2.e = l2 += obj7;
            }
            l = c2.f;
            if (Long.compare(l, l6) != 0) {
                c2.f = l += obj7;
            }
            return c2;
        }
    }
    public ClippingMediaSource(com.google.android.exoplayer2.source.y y, long l2, long l3) {
        super(y, l2, obj3, obj13, obj5, 1, 0, 0);
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.y y, long l2, long l3, boolean z4, boolean z5, boolean z6) {
        int i;
        super();
        i = Long.compare(l2, i2) >= 0 ? 1 : 0;
        g.a(i);
        g.e(y);
        this.j = (y)y;
        this.k = l2;
        this.l = z4;
        this.m = z6;
        this.n = obj9;
        this.o = obj10;
        ArrayList obj3 = new ArrayList();
        this.p = obj3;
        obj3 = new g2.c();
        this.q = obj3;
    }

    private void H(g2 g2) {
        int size;
        com.google.android.exoplayer2.source.ClippingMediaSource.a empty;
        boolean z;
        int i2;
        Object obj;
        int i;
        long l3;
        int l;
        long l4;
        long l2;
        long l5;
        final Object obj2 = this;
        g2.n(0, obj2.q);
        l3 = obj2.q.e();
        l = Long.MIN_VALUE;
        if (obj2.r != null && !obj2.p.isEmpty()) {
            if (!obj2.p.isEmpty()) {
                if (obj2.n) {
                    if (obj2.o) {
                        l5 = obj2.q.c();
                        l4 += l5;
                        l2 += l5;
                    }
                    obj2.t = l3 + l4;
                    if (Long.compare(l5, l) == 0) {
                    } else {
                        l = l3 + l2;
                    }
                    obj2.u = l;
                    while (i2 < obj2.p.size()) {
                        (k)obj2.p.get(i2).v(obj2.t, obj6);
                        i2++;
                    }
                    i = l4;
                    l = l2;
                } else {
                    if (Long.compare(l4, l) == 0) {
                    } else {
                        l7 -= l3;
                    }
                    i = i2;
                }
            } else {
            }
        } else {
        }
        super(g2, i, obj6, l, obj8);
        obj2.r = aVar;
        x(aVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    protected void E(Object object, com.google.android.exoplayer2.source.y y2, g2 g23) {
        G((Void)object, y2, g23);
    }

    @Override // com.google.android.exoplayer2.source.l
    protected void G(Void void, com.google.android.exoplayer2.source.y y2, g2 g23) {
        if (this.s != null) {
        }
        H(g23);
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.w a(com.google.android.exoplayer2.source.y.a y$a, f f2, long l3) {
        super(this.j.a(a, f2, l3), this.m, this.t, obj4, this.u, obj6);
        this.p.add(kVar2);
        return kVar2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public m1 g() {
        return this.j.g();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void j() {
        final com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException exc = this.s;
        if (exc != null) {
        } else {
            super.j();
        }
        throw exc;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void l(com.google.android.exoplayer2.source.w w) {
        boolean obj2;
        g.f(this.p.remove(w));
        this.j.l(w.a);
        if (this.p.isEmpty() && !this.n) {
            if (!this.n) {
                obj2 = this.r;
                g.e(obj2);
                H(obj2.b);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    protected void w(b0 b0) {
        super.w(b0);
        F(0, this.j);
    }

    @Override // com.google.android.exoplayer2.source.l
    protected void y() {
        super.y();
        final int i = 0;
        this.s = i;
        this.r = i;
    }
}
