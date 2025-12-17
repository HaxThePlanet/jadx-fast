package com.google.android.exoplayer2;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.source.ads.c;
import com.google.android.exoplayer2.source.ads.c.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
public abstract class g2 {

    public static final com.google.android.exoplayer2.g2 a;

    public static final class b {

        public static final com.google.android.exoplayer2.v0<com.google.android.exoplayer2.g2.b> h;
        public Object a;
        public Object b;
        public int c;
        public long d;
        public long e;
        public boolean f;
        private c g;
        static {
            g2.b.h = n0.a;
        }

        public b() {
            super();
            this.g = c.g;
        }

        public int a(int i) {
            return obj2.b;
        }

        public long b(int i, int i2) {
            long l;
            long[] obj3;
            obj3 = this.g.a(i);
            l = obj3.b != -1 ? obj3[i2] : -9223372036854775807L;
            return l;
        }

        public int c() {
            return cVar.b;
        }

        public int d(long l) {
            return this.g.b(l, obj5);
        }

        public int e(long l) {
            return this.g.c(l, obj5);
        }

        public boolean equals(Object object) {
            int i;
            c cmp;
            boolean equals;
            boolean obj;
            Class class;
            long l;
            boolean obj7;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (!g2.b.class.equals(object.getClass())) {
                } else {
                    if (p0.b(this.a, object.a) && p0.b(this.b, object.b) && this.c == object.c && Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && this.f == object.f && p0.b(this.g, object.g)) {
                        if (p0.b(this.b, object.b)) {
                            if (this.c == object.c) {
                                if (Long.compare(l2, l) == 0) {
                                    if (Long.compare(l3, l) == 0) {
                                        if (this.f == object.f) {
                                            if (p0.b(this.g, object.g)) {
                                            } else {
                                                i = i2;
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
                }
                return i;
            }
            return i2;
        }

        public long f(int i) {
            return obj3.a;
        }

        public long g() {
            return cVar.c;
        }

        public long h(int i) {
            return obj3.f;
        }

        public int hashCode() {
            int i;
            int i2;
            Object obj = this.a;
            if (obj == null) {
                i = i2;
            } else {
                i = obj.hashCode();
            }
            Object obj2 = this.b;
            if (obj2 == null) {
            } else {
                i2 = obj2.hashCode();
            }
            long l = this.d;
            int i23 = 32;
            long l2 = this.e;
            return i21 += i8;
        }

        public long i() {
            return this.d;
        }

        public int j(int i) {
            return this.g.a(i).c();
        }

        public int k(int i, int i2) {
            return this.g.a(i).d(i2);
        }

        public long l() {
            return w0.e(this.e);
        }

        public long m() {
            return this.e;
        }

        public int n() {
            return cVar.e;
        }

        public boolean o(int i) {
            return obj2 ^= 1;
        }

        public boolean p(int i) {
            return obj2.g;
        }

        public com.google.android.exoplayer2.g2.b q(Object object, Object object2, int i3, long l4, long l5) {
            this.r(object, object2, i3, l4, obj5, obj16, obj7);
            return this;
        }

        public com.google.android.exoplayer2.g2.b r(Object object, Object object2, int i3, long l4, long l5, c c6, boolean z7) {
            this.a = object;
            this.b = object2;
            this.c = i3;
            this.d = l4;
            this.e = c6;
            this.g = obj8;
            this.f = obj9;
            return this;
        }
    }

    public static final class c {

        public static final Object r;
        private static final Object s;
        private static final com.google.android.exoplayer2.m1 t;
        public static final com.google.android.exoplayer2.v0<com.google.android.exoplayer2.g2.c> u;
        public Object a;
        @Deprecated
        public Object b;
        public com.google.android.exoplayer2.m1 c;
        public Object d;
        public long e;
        public long f;
        public long g;
        public boolean h;
        public boolean i;
        @Deprecated
        public boolean j;
        public com.google.android.exoplayer2.m1.f k;
        public boolean l;
        public long m;
        public long n;
        public int o;
        public int p;
        public long q;
        static {
            Object object = new Object();
            g2.c.r = object;
            Object object2 = new Object();
            g2.c.s = object2;
            m1.c cVar = new m1.c();
            cVar.c("com.google.android.exoplayer2.Timeline");
            cVar.f(Uri.EMPTY);
            g2.c.t = cVar.a();
            g2.c.u = o0.a;
        }

        public c() {
            super();
            this.a = g2.c.r;
            this.c = g2.c.t;
        }

        public long a() {
            return p0.R(this.g);
        }

        public long b() {
            return w0.e(this.m);
        }

        public long c() {
            return this.m;
        }

        public long d() {
            return w0.e(this.n);
        }

        public long e() {
            return this.q;
        }

        public boolean equals(Object object) {
            int i;
            long cmp;
            boolean equals;
            int obj;
            Class class;
            long l;
            int obj7;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (!g2.c.class.equals(object.getClass())) {
                } else {
                    if (p0.b(this.a, object.a) && p0.b(this.c, object.c) && p0.b(this.d, object.d) && p0.b(this.k, object.k) && Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && Long.compare(l4, l) == 0 && this.h == object.h && this.i == object.i && this.l == object.l && Long.compare(l5, l) == 0 && Long.compare(l6, l) == 0 && this.o == object.o && this.p == object.p && Long.compare(cmp, l) == 0) {
                        if (p0.b(this.c, object.c)) {
                            if (p0.b(this.d, object.d)) {
                                if (p0.b(this.k, object.k)) {
                                    if (Long.compare(l2, l) == 0) {
                                        if (Long.compare(l3, l) == 0) {
                                            if (Long.compare(l4, l) == 0) {
                                                if (this.h == object.h) {
                                                    if (this.i == object.i) {
                                                        if (this.l == object.l) {
                                                            if (Long.compare(l5, l) == 0) {
                                                                if (Long.compare(l6, l) == 0) {
                                                                    if (this.o == object.o) {
                                                                        if (this.p == object.p) {
                                                                            if (Long.compare(cmp, l) == 0) {
                                                                            } else {
                                                                                i = i2;
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
                }
                return i;
            }
            return i2;
        }

        public boolean f() {
            int i3;
            int i;
            int i2;
            i2 = 1;
            final int i4 = 0;
            i = this.k != null ? i2 : i4;
            i3 = this.j == i ? i2 : i4;
            g.f(i3);
            if (this.k != null) {
            } else {
                i2 = i4;
            }
            return i2;
        }

        public com.google.android.exoplayer2.g2.c g(Object object, com.google.android.exoplayer2.m1 m12, Object object3, long l4, long l5, long l6, boolean z7, boolean z8, com.google.android.exoplayer2.m1.f m1$f9, long l10, long l11, int i12, int i13, long l14) {
            int i;
            Object obj;
            com.google.android.exoplayer2.m1 m1Var;
            int i2;
            final Object obj2 = this;
            obj = m12;
            com.google.android.exoplayer2.m1.f fVar = i12;
            obj2.a = object;
            m1Var = obj != null ? obj : g2.c.t;
            obj2.c = m1Var;
            obj = obj.b;
            if (obj != null && obj != null) {
                obj = obj.b;
                i = obj != null ? obj.h : 0;
            } else {
            }
            obj2.b = i;
            obj2.d = object3;
            obj2.e = l4;
            obj2.f = l6;
            obj2.g = z8;
            obj2.h = l10;
            obj2.i = l11;
            int i3 = 0;
            i2 = fVar != null ? 1 : i3;
            obj2.j = i2;
            obj2.k = fVar;
            obj2.m = i13;
            obj2.n = obj20;
            obj2.o = obj22;
            obj2.p = obj23;
            obj2.q = obj24;
            obj2.l = i3;
            return obj2;
        }

        public int hashCode() {
            int i2;
            int i;
            Object obj2 = this.d;
            if (obj2 == null) {
                i2 = i;
            } else {
                i2 = obj2.hashCode();
            }
            com.google.android.exoplayer2.m1.f fVar = this.k;
            if (fVar == null) {
            } else {
                i = fVar.hashCode();
            }
            long l = this.e;
            int i5 = 32;
            long l2 = this.f;
            long l3 = this.g;
            long l4 = this.m;
            long l5 = this.n;
            long l6 = this.q;
            return i35 += i6;
        }
    }

    class a extends com.google.android.exoplayer2.g2 {
        @Override // com.google.android.exoplayer2.g2
        public int b(Object object) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.g2
        public com.google.android.exoplayer2.g2.b g(int i, com.google.android.exoplayer2.g2.b g2$b2, boolean z3) {
            IndexOutOfBoundsException obj1 = new IndexOutOfBoundsException();
            throw obj1;
        }

        @Override // com.google.android.exoplayer2.g2
        public int i() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.g2
        public Object m(int i) {
            IndexOutOfBoundsException obj1 = new IndexOutOfBoundsException();
            throw obj1;
        }

        @Override // com.google.android.exoplayer2.g2
        public com.google.android.exoplayer2.g2.c o(int i, com.google.android.exoplayer2.g2.c g2$c2, long l3) {
            IndexOutOfBoundsException obj1 = new IndexOutOfBoundsException();
            throw obj1;
        }

        @Override // com.google.android.exoplayer2.g2
        public int p() {
            return 0;
        }
    }
    static {
        g2.a aVar = new g2.a();
        g2.a = aVar;
        com.google.android.exoplayer2.m0 m0Var = m0.a;
    }

    public int a(boolean z) {
        int obj1;
        obj1 = q() ? -1 : 0;
        return obj1;
    }

    public abstract int b(Object object);

    public int c(boolean z) {
        int obj1;
        if (q()) {
            obj1 = -1;
        } else {
            obj1--;
        }
        return obj1;
    }

    public final int d(int i, com.google.android.exoplayer2.g2.b g2$b2, com.google.android.exoplayer2.g2.c g2$c3, int i4, boolean z5) {
        int obj3 = obj3.c;
        int obj2 = e(obj3, i4, z5);
        obj3 = -1;
        if (cVar.p == i && obj2 == obj3) {
            obj2 = e(obj3, i4, z5);
            obj3 = -1;
            if (obj2 == obj3) {
                return obj3;
            }
            return obj2.o;
        }
        return i++;
    }

    public int e(int i, int i2, boolean z3) {
        int obj3;
        final int i3 = 1;
        if (i2 != 0 && i2 != i3) {
            if (i2 != i3) {
                if (i2 != 2) {
                } else {
                    if (i == c(z3)) {
                        obj3 = a(z3);
                    } else {
                        i += i3;
                    }
                    return obj3;
                }
                obj3 = new IllegalStateException();
                throw obj3;
            }
            return i;
        }
        obj3 = i == c(z3) ? -1 : i + i3;
        return obj3;
    }

    public boolean equals(Object object) {
        int i3;
        int i4;
        int i;
        com.google.android.exoplayer2.g2.c cVar2;
        int i2;
        boolean equals;
        com.google.android.exoplayer2.g2.c cVar;
        final int i5 = 1;
        if (this == object) {
            return i5;
        }
        final int i6 = 0;
        if (!object instanceof g2) {
            return i6;
        }
        if ((g2)object.p() == p()) {
            if (object.i() != i()) {
            } else {
                g2.c cVar3 = new g2.c();
                g2.b bVar = new g2.b();
                cVar2 = new g2.c();
                g2.b bVar3 = new g2.b();
                i2 = i6;
                while (i2 < p()) {
                    i2++;
                }
                i4 = i6;
                while (i4 < i()) {
                    i4++;
                }
            }
            return i5;
        }
        return i6;
    }

    public final com.google.android.exoplayer2.g2.b f(int i, com.google.android.exoplayer2.g2.b g2$b2) {
        return g(i, b2, false);
    }

    public abstract com.google.android.exoplayer2.g2.b g(int i, com.google.android.exoplayer2.g2.b g2$b2, boolean z3);

    public com.google.android.exoplayer2.g2.b h(Object object, com.google.android.exoplayer2.g2.b g2$b2) {
        return g(b(object), b2, true);
    }

    public int hashCode() {
        int i;
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        g2.c cVar = new g2.c();
        g2.b bVar2 = new g2.b();
        i10 += i9;
        i5 = i2;
        while (i5 < p()) {
            i13 += i6;
            i5++;
        }
        i11 += i;
        while (i2 < i()) {
            i12 += i;
            i2++;
        }
        return i3;
    }

    public abstract int i();

    public final Pair<Object, Long> j(com.google.android.exoplayer2.g2.c g2$c, com.google.android.exoplayer2.g2.b g2$b2, int i3, long l4) {
        final Pair obj9 = this.k(c, b2, i3, l4, obj5);
        g.e(obj9);
        return (Pair)obj9;
    }

    public final Pair<Object, Long> k(com.google.android.exoplayer2.g2.c g2$c, com.google.android.exoplayer2.g2.b g2$b2, int i3, long l4, long l5) {
        int cmp2;
        long l;
        int cmp;
        int obj4;
        int obj6;
        long obj7;
        int obj8;
        long obj9;
        g.c(i3, 0, p());
        o(i3, c, obj9);
        obj9 = -9223372036854775807L;
        if (Long.compare(l4, obj9) == 0 && Long.compare(obj7, obj9) == 0) {
            if (Long.compare(obj7, obj9) == 0) {
                return 0;
            }
        }
        f(c.o, b2);
        while (obj6 < c.p) {
            if (Long.compare(l2, obj7) != 0) {
            }
            cmp2 = obj6 + 1;
            if (Long.compare(l6, obj7) <= 0) {
            }
            obj6 = cmp2;
        }
        g(obj6, b2, true);
        l = b2.d;
        if (Long.compare(l, obj9) != 0) {
            obj7 = Math.min(obj7 -= l3, l5);
        }
        obj6 = Math.max(0, obj10);
        if (Long.compare(obj6, obj8) == 0) {
            v.c("XXX", "YYY");
        }
        obj4 = b2.b;
        g.e(obj4);
        return Pair.create(obj4, Long.valueOf(obj6));
    }

    public int l(int i, int i2, boolean z3) {
        int obj3;
        final int i3 = 1;
        if (i2 != 0 && i2 != i3) {
            if (i2 != i3) {
                if (i2 != 2) {
                } else {
                    if (i == a(z3)) {
                        obj3 = c(z3);
                    } else {
                        i -= i3;
                    }
                    return obj3;
                }
                obj3 = new IllegalStateException();
                throw obj3;
            }
            return i;
        }
        obj3 = i == a(z3) ? -1 : i - i3;
        return obj3;
    }

    public abstract Object m(int i);

    public final com.google.android.exoplayer2.g2.c n(int i, com.google.android.exoplayer2.g2.c g2$c2) {
        return o(i, c2, 0);
    }

    public abstract com.google.android.exoplayer2.g2.c o(int i, com.google.android.exoplayer2.g2.c g2$c2, long l3);

    public abstract int p();

    public final boolean q() {
        int i;
        i = p() == 0 ? 1 : 0;
        return i;
    }

    public final boolean r(int i, com.google.android.exoplayer2.g2.b g2$b2, com.google.android.exoplayer2.g2.c g2$c3, int i4, boolean z5) {
        int obj1;
        obj1 = d(i, b2, c3, i4, z5) == -1 ? 1 : 0;
        return obj1;
    }
}
