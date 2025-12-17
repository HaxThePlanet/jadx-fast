package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.g2.b;
import com.google.android.exoplayer2.g2.c;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.ads.c;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class u extends com.google.android.exoplayer2.source.l<Void> {

    private final com.google.android.exoplayer2.source.y j;
    private final boolean k = false;
    private final g2.c l;
    private final g2.b m;
    private com.google.android.exoplayer2.source.u.a n;
    private com.google.android.exoplayer2.source.t o;
    private boolean p;
    private boolean q;
    private boolean r = true;

    public static final class b extends g2 {

        private final m1 b;
        public b(m1 m1) {
            super();
            this.b = m1;
        }

        @Override // com.google.android.exoplayer2.g2
        public int b(Object object) {
            int obj2;
            obj2 = object == u.a.e ? 0 : -1;
            return obj2;
        }

        @Override // com.google.android.exoplayer2.g2
        public g2.b g(int i, g2.b g2$b2, boolean z3) {
            Integer valueOf;
            Integer num;
            int obj12;
            if (z3) {
                num = valueOf;
            } else {
                num = obj12;
            }
            if (z3) {
                obj12 = u.a.e;
            }
            b2.r(num, obj12, 0, -9223372036854775807L, obj6, 0, obj8);
            return b2;
        }

        @Override // com.google.android.exoplayer2.g2
        public int i() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.g2
        public Object m(int i) {
            return u.a.e;
        }

        @Override // com.google.android.exoplayer2.g2
        public g2.c o(int i, g2.c g2$c2, long l3) {
            Object obj5 = c2;
            long l6 = -9223372036854775807L;
            c2.g(g2.c.r, obj4.b, 0, -9223372036854775807L, obj5, -9223372036854775807L, obj7, -9223372036854775807L, obj9, 0, 1, 0, 0, obj14);
            Object obj3 = c2;
            obj3.l = true;
            return obj3;
        }

        @Override // com.google.android.exoplayer2.g2
        public int p() {
            return 1;
        }
    }

    private static final class a extends com.google.android.exoplayer2.source.r {

        public static final Object e;
        private final Object c;
        private final Object d;
        static {
            Object object = new Object();
            u.a.e = object;
        }

        private a(g2 g2, Object object2, Object object3) {
            super(g2);
            this.c = object2;
            this.d = object3;
        }

        static Object s(com.google.android.exoplayer2.source.u.a u$a) {
            return a.d;
        }

        public static com.google.android.exoplayer2.source.u.a u(m1 m1) {
            u.b bVar = new u.b(m1);
            u.a aVar = new u.a(bVar, g2.c.r, u.a.e);
            return aVar;
        }

        public static com.google.android.exoplayer2.source.u.a v(g2 g2, Object object2, Object object3) {
            u.a aVar = new u.a(g2, object2, object3);
            return aVar;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int b(Object object) {
            boolean equals;
            Object obj3;
            equals = this.d;
            if (u.a.e.equals(object) && equals != null) {
                equals = this.d;
                if (equals != null) {
                    obj3 = equals;
                }
            }
            return this.b.b(obj3);
        }

        @Override // com.google.android.exoplayer2.source.r
        public g2.b g(int i, g2.b g2$b2, boolean z3) {
            boolean obj2;
            this.b.g(i, b2, z3);
            if (p0.b(b2.b, this.d) && z3) {
                if (z3) {
                    b2.b = u.a.e;
                }
            }
            return b2;
        }

        @Override // com.google.android.exoplayer2.source.r
        public Object m(int i) {
            Object obj2;
            if (p0.b(this.b.m(i), this.d)) {
                obj2 = u.a.e;
            }
            return obj2;
        }

        @Override // com.google.android.exoplayer2.source.r
        public g2.c o(int i, g2.c g2$c2, long l3) {
            boolean obj2;
            this.b.o(i, c2, l3);
            if (p0.b(c2.a, this.c)) {
                c2.a = g2.c.r;
            }
            return c2;
        }

        @Override // com.google.android.exoplayer2.source.r
        public com.google.android.exoplayer2.source.u.a t(g2 g2) {
            u.a aVar = new u.a(g2, this.c, this.d);
            return aVar;
        }
    }
    public u(com.google.android.exoplayer2.source.y y, boolean z2) {
        com.google.android.exoplayer2.source.u.a obj2;
        boolean obj3;
        super();
        this.j = y;
        if (z2 && y.k()) {
            obj3 = y.k() ? i : obj3;
        }
        obj3 = 0;
        obj3 = new g2.c();
        this.l = obj3;
        obj3 = new g2.b();
        this.m = obj3;
        obj3 = y.m();
        if (obj3 != null) {
            obj2 = 0;
            this.n = u.a.v(obj3, obj2, obj2);
        } else {
            this.n = u.a.u(y.g());
        }
    }

    private Object H(Object object) {
        Object equals;
        Object obj2;
        if (u.a.s(this.n) != null && u.a.s(this.n).equals(object)) {
            if (u.a.s(this.n).equals(object)) {
                obj2 = u.a.e;
            }
        }
        return obj2;
    }

    private Object I(Object object) {
        Object equals;
        Object obj2;
        if (u.a.s(this.n) != null && object.equals(u.a.e)) {
            if (object.equals(u.a.e)) {
                obj2 = u.a.s(this.n);
            }
        }
        return obj2;
    }

    @RequiresNonNull("unpreparedMaskingMediaPeriod")
    private void M(long l) {
        long l2;
        int cmp;
        long obj6;
        final com.google.android.exoplayer2.source.t tVar = this.o;
        int i = this.n.b(aVar2.a);
        if (i == -1) {
        }
        com.google.android.exoplayer2.source.u.a aVar3 = this.n;
        l2 = bVar.d;
        if (Long.compare(l2, l3) != 0 && Long.compare(l, l2) >= 0) {
            if (Long.compare(l, l2) >= 0) {
                obj6 = Math.max(0, obj7);
            }
        }
        tVar.w(obj6);
    }

    @Override // com.google.android.exoplayer2.source.l
    protected void E(Object object, com.google.android.exoplayer2.source.y y2, g2 g23) {
        L((Void)object, y2, g23);
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.t G(com.google.android.exoplayer2.source.y.a y$a, f f2, long l3) {
        com.google.android.exoplayer2.source.y.a obj2;
        Object obj3;
        t tVar = new t(a, f2, l3, obj5);
        tVar.y(this.j);
        if (this.q) {
            tVar.g(a.c(I(a.a)));
        } else {
            this.o = tVar;
            if (!this.p) {
                this.p = true;
                F(0, this.j);
            }
        }
        return tVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    protected com.google.android.exoplayer2.source.y.a J(Void void, com.google.android.exoplayer2.source.y.a y$a2) {
        return a2.c(H(a2.a));
    }

    @Override // com.google.android.exoplayer2.source.l
    public g2 K() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.source.l
    protected void L(Void void, com.google.android.exoplayer2.source.y y2, g2 g23) {
        Object first;
        long longValue;
        com.google.android.exoplayer2.source.t tVar;
        g2.c cVar2;
        int i2;
        Object obj;
        Object obj2;
        g2.c cVar;
        g2.b bVar;
        int i;
        long l;
        com.google.android.exoplayer2.source.u.a obj13;
        Object obj14;
        if (this.q) {
            this.n = this.n.t(g23);
            obj13 = this.o;
            if (obj13 != null) {
                M(obj13.h());
            }
            obj13 = 0;
        } else {
            if (g23.q()) {
                if (this.r) {
                    obj13 = this.n.t(g23);
                } else {
                    obj13 = u.a.v(g23, g2.c.r, u.a.e);
                }
                this.n = obj13;
            } else {
                obj14 = 0;
                g23.n(obj14, this.l);
                tVar = this.o;
                this.n.h(aVar3.a, this.m);
                l4 += l3;
                if (tVar != null && Long.compare(i2, tVar) != 0) {
                    this.n.h(aVar3.a, this.m);
                    l4 += l3;
                    l = Long.compare(i2, tVar) != 0 ? i2 : l2;
                } else {
                }
                obj14 = g23.j(this.l, this.m, 0, l);
                if (this.r) {
                    obj13 = this.n.t(g23);
                } else {
                    obj13 = u.a.v(g23, obj13.a, obj14.first);
                }
                this.n = obj13;
                obj13 = this.o;
                if (obj13 != null) {
                    M((Long)obj14.second.longValue());
                    obj13 = obj13.a;
                    obj13 = obj13.c(I(obj13.a));
                } else {
                }
            }
        }
        obj14 = 1;
        this.r = obj14;
        this.q = obj14;
        x(this.n);
        if (obj13 != null) {
            obj14 = this.o;
            g.e(obj14);
            (t)obj14.g(obj13);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.w a(com.google.android.exoplayer2.source.y.a y$a, f f2, long l3) {
        return G(a, f2, l3);
    }

    @Override // com.google.android.exoplayer2.source.l
    public m1 g() {
        return this.j.g();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void j() {
    }

    @Override // com.google.android.exoplayer2.source.l
    public void l(com.google.android.exoplayer2.source.w w) {
        com.google.android.exoplayer2.source.t obj2;
        (t)w.x();
        if (w == this.o) {
            this.o = 0;
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void w(b0 b0) {
        com.google.android.exoplayer2.source.y yVar;
        boolean obj2;
        super.w(b0);
        if (!this.k) {
            this.p = true;
            F(0, this.j);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void y() {
        final int i = 0;
        this.q = i;
        this.p = i;
        super.y();
    }

    @Override // com.google.android.exoplayer2.source.l
    protected com.google.android.exoplayer2.source.y.a z(Object object, com.google.android.exoplayer2.source.y.a y$a2) {
        return J((Void)object, a2);
    }
}
