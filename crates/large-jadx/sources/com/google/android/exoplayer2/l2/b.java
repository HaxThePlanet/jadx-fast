package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public abstract class b {

    protected final com.google.android.exoplayer2.l2.b.a a;
    protected final com.google.android.exoplayer2.l2.b.f b;
    protected com.google.android.exoplayer2.l2.b.c c;
    private final int d;

    protected static class c {

        private final long a;
        private final long b;
        private final long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;
        protected c(long l, long l2, long l3, long l4, long l5, long l6, long l7) {
            super();
            this.a = l;
            this.b = l3;
            this.d = l5;
            this.e = l7;
            this.f = obj9;
            this.g = obj11;
            this.c = obj13;
            this.h = b.c.h(l3, l4, l5, l6, l7, obj8);
        }

        static long a(com.google.android.exoplayer2.l2.b.c b$c) {
            return c.l();
        }

        static long b(com.google.android.exoplayer2.l2.b.c b$c) {
            return c.j();
        }

        static long c(com.google.android.exoplayer2.l2.b.c b$c) {
            return c.i();
        }

        static long d(com.google.android.exoplayer2.l2.b.c b$c) {
            return c.k();
        }

        static long e(com.google.android.exoplayer2.l2.b.c b$c) {
            return c.m();
        }

        static void f(com.google.android.exoplayer2.l2.b.c b$c, long l2, long l3) {
            c.o(l2, l3);
        }

        static void g(com.google.android.exoplayer2.l2.b.c b$c, long l2, long l3) {
            c.p(l2, l3);
        }

        protected static long h(long l, long l2, long l3, long l4, long l5, long l6) {
            int cmp;
            int i = 1;
            if (Long.compare(i3, obj15) < 0 && Long.compare(i4, l5) >= 0) {
                if (Long.compare(i4, l5) >= 0) {
                }
                long l8 = (long)i6;
                return p0.q(i8 -= i13, l2, obj13);
            }
            return obj13;
        }

        private long i() {
            return this.g;
        }

        private long j() {
            return this.f;
        }

        private long k() {
            return this.h;
        }

        private long l() {
            return this.a;
        }

        private long m() {
            return this.b;
        }

        private void n() {
            this.h = b.c.h(this.b, obj1, this.d, obj3, this.e, obj5);
        }

        private void o(long l, long l2) {
            this.e = l;
            this.g = obj3;
            n();
        }

        private void p(long l, long l2) {
            this.d = l;
            this.f = obj3;
            n();
        }
    }

    protected interface d {
        public abstract long a(long l);
    }

    public static final class e {

        public static final com.google.android.exoplayer2.l2.b.e d;
        private final int a;
        private final long b;
        private final long c;
        static {
            super(-3, -9223372036854775807L, obj3, -1, obj5);
            b.e.d = eVar2;
        }

        private e(int i, long l2, long l3) {
            super();
            this.a = i;
            this.b = l2;
            this.c = obj4;
        }

        static int a(com.google.android.exoplayer2.l2.b.e b$e) {
            return e.a;
        }

        static long b(com.google.android.exoplayer2.l2.b.e b$e) {
            return e.b;
        }

        static long c(com.google.android.exoplayer2.l2.b.e b$e) {
            return e.c;
        }

        public static com.google.android.exoplayer2.l2.b.e d(long l, long l2) {
            super(-1, l, obj3, obj9, obj5);
            return eVar2;
        }

        public static com.google.android.exoplayer2.l2.b.e e(long l) {
            super(0, -9223372036854775807L, obj3, l, obj5);
            return eVar2;
        }

        public static com.google.android.exoplayer2.l2.b.e f(long l, long l2) {
            super(-2, l, obj3, obj9, obj5);
            return eVar2;
        }
    }

    protected interface f {
        public void a() {
        }

        public abstract com.google.android.exoplayer2.l2.b.e b(com.google.android.exoplayer2.l2.j j, long l2);
    }

    public static class a implements com.google.android.exoplayer2.l2.q {

        private final com.google.android.exoplayer2.l2.b.d a;
        private final long b;
        private final long c;
        private final long d;
        private final long e;
        private final long f;
        public a(com.google.android.exoplayer2.l2.b.d b$d, long l2, long l3, long l4, long l5, long l6, long l7) {
            super();
            this.a = d;
            this.b = l4;
            this.c = l6;
            this.d = obj8;
            this.e = obj10;
            this.f = obj12;
        }

        static long d(com.google.android.exoplayer2.l2.b.a b$a) {
            return a.b;
        }

        static long e(com.google.android.exoplayer2.l2.b.a b$a) {
            return a.c;
        }

        static long f(com.google.android.exoplayer2.l2.b.a b$a) {
            return a.d;
        }

        static long g(com.google.android.exoplayer2.l2.b.a b$a) {
            return a.e;
        }

        static long h(com.google.android.exoplayer2.l2.b.a b$a) {
            return a.f;
        }

        @Override // com.google.android.exoplayer2.l2.q
        public long i(long l) {
            this.a.a(l);
            return l;
        }
    }

    public static final class b implements com.google.android.exoplayer2.l2.b.d {
        @Override // com.google.android.exoplayer2.l2.b$d
        public long a(long l) {
            return l;
        }
    }
    protected b(com.google.android.exoplayer2.l2.b.d b$d, com.google.android.exoplayer2.l2.b.f b$f2, long l3, long l4, long l5, long l6, long l7, long l8, int i9) {
        final Object obj = this;
        super();
        obj.b = f2;
        obj.d = obj31;
        super(d, l3, obj4, l5, obj6, l7, obj8, i9, obj10, obj27, obj12, obj29, obj14);
        obj.a = aVar2;
    }

    protected com.google.android.exoplayer2.l2.b.c a(long l) {
        final Object obj = this;
        final long l3 = l;
        obj.a.i(l3);
        super(l, obj3, l3, obj5, b.a.d(obj.a), obj7, b.a.e(obj.a), obj9, b.a.f(obj.a), obj11, b.a.g(obj.a), obj13, b.a.h(obj.a), obj15);
        return cVar2;
    }

    public final com.google.android.exoplayer2.l2.q b() {
        return this.a;
    }

    public int c(com.google.android.exoplayer2.l2.j j, com.google.android.exoplayer2.l2.p p2) {
        com.google.android.exoplayer2.l2.b.e eVar;
        com.google.android.exoplayer2.l2.p pVar;
        int i;
        long l;
        com.google.android.exoplayer2.l2.b.c cVar = this.c;
        g.h(cVar);
        long l3 = b.c.b((b.c)cVar);
        final long l8 = b.c.d(cVar);
        int cmp = Long.compare(i4, l9);
        int i6 = 0;
        while (cmp <= 0) {
            j.i();
            eVar = this.b.b(j, b.c.e(cVar));
            int i3 = b.e.a(eVar);
            i = -2;
            b.c.g(cVar, b.e.b(eVar), i);
            cVar = this.c;
            g.h(cVar);
            l3 = b.c.b((b.c)cVar);
            l8 = b.c.d(cVar);
            cmp = Long.compare(i4, l9);
            i6 = 0;
            i = -1;
            b.c.f(cVar, b.e.b(eVar), i);
        }
        e(i6, l3);
        return g(j, l3, pVar);
    }

    public final boolean d() {
        int i;
        i = this.c != null ? 1 : 0;
        return i;
    }

    protected final void e(boolean z, long l2) {
        this.c = 0;
        this.b.a();
        f(z, l2);
    }

    protected void f(boolean z, long l2) {
    }

    protected final int g(com.google.android.exoplayer2.l2.j j, long l2, com.google.android.exoplayer2.l2.p p3) {
        if (Long.compare(l2, position) == 0) {
            return 0;
        }
        obj6.a = l2;
        return 1;
    }

    public final void h(long l) {
        com.google.android.exoplayer2.l2.b.c cmp;
        cmp = this.c;
        if (cmp != null && Long.compare(l2, l) == 0) {
            if (Long.compare(l2, l) == 0) {
            }
        }
        this.c = a(l);
    }

    protected final boolean i(com.google.android.exoplayer2.l2.j j, long l2) {
        int cmp;
        l2 -= position;
        if (Long.compare(obj4, i) >= 0 && Long.compare(obj4, i2) <= 0) {
            if (Long.compare(obj4, i2) <= 0) {
                j.j((int)obj4);
                return 1;
            }
        }
        return 0;
    }
}
