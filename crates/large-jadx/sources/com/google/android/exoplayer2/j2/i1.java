package com.google.android.exoplayer2.j2;

import android.util.SparseArray;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.n2.k;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.v1.b;
import com.google.android.exoplayer2.v1.f;
import com.google.android.exoplayer2.video.a0;
import com.google.common.base.k;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public interface i1 {

    public static final class a {

        public final long a;
        public final g2 b;
        public final int c;
        public final y.a d;
        public final long e;
        public final g2 f;
        public final int g;
        public final y.a h;
        public final long i;
        public final long j;
        public a(long l, g2 g22, int i3, y.a y$a4, long l5, g2 g26, int i7, y.a y$a8, long l9, long l10) {
            super();
            this.a = l;
            this.b = i3;
            this.c = a4;
            this.d = l5;
            this.e = g26;
            this.f = a8;
            this.g = l9;
            this.h = l10;
            this.i = obj11;
            this.j = obj13;
        }

        public boolean equals(Object object) {
            int i;
            y.a cmp;
            Class<com.google.android.exoplayer2.j2.i1.a> obj;
            Object class;
            long l;
            boolean obj7;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (i1.a.class != object.getClass()) {
                } else {
                    if (Long.compare(l2, l) == 0 && this.c == object.c && Long.compare(l3, l) == 0 && this.g == object.g && Long.compare(l4, l) == 0 && Long.compare(l5, l) == 0 && k.a(this.b, object.b) && k.a(this.d, object.d) && k.a(this.f, object.f) && k.a(this.h, object.h)) {
                        if (this.c == object.c) {
                            if (Long.compare(l3, l) == 0) {
                                if (this.g == object.g) {
                                    if (Long.compare(l4, l) == 0) {
                                        if (Long.compare(l5, l) == 0) {
                                            if (k.a(this.b, object.b)) {
                                                if (k.a(this.d, object.d)) {
                                                    if (k.a(this.f, object.f)) {
                                                        if (k.a(this.h, object.h)) {
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
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            Object[] arr = new Object[10];
            int i8 = 3;
            arr[i8] = this.d;
            arr[4] = Long.valueOf(this.e);
            arr[5] = this.f;
            arr[6] = Integer.valueOf(this.g);
            int i12 = 7;
            arr[i12] = this.h;
            int i13 = 8;
            arr[i13] = Long.valueOf(this.i);
            arr[9] = Long.valueOf(this.j);
            return k.b(arr);
        }
    }

    public static final class b {
        public b(q q, SparseArray<com.google.android.exoplayer2.j2.i1.a> sparseArray2) {
            int i;
            int i2;
            Object obj;
            super();
            SparseArray sparseArray = new SparseArray(q.d());
            i = 0;
            while (i < q.d()) {
                i2 = q.c(i);
                obj = sparseArray2.get(i2);
                g.e((i1.a)obj);
                sparseArray.append(i2, (i1.a)obj);
                i++;
            }
        }
    }
    public void A(com.google.android.exoplayer2.j2.i1.a i1$a, a a2) {
    }

    public void B(com.google.android.exoplayer2.j2.i1.a i1$a, int i2) {
    }

    public void C(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    public void D(v1 v1, com.google.android.exoplayer2.j2.i1.b i1$b2) {
    }

    @Deprecated
    public void E(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, int i3) {
    }

    public void F(com.google.android.exoplayer2.j2.i1.a i1$a, a0 a02) {
    }

    public void G(com.google.android.exoplayer2.j2.i1.a i1$a, int i2) {
    }

    @Deprecated
    public void H(com.google.android.exoplayer2.j2.i1.a i1$a, i1 i12) {
    }

    public void I(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    @Deprecated
    public void J(com.google.android.exoplayer2.j2.i1.a i1$a, i1 i12) {
    }

    public void K(com.google.android.exoplayer2.j2.i1.a i1$a, float f2) {
    }

    public void L(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3) {
    }

    public void M(com.google.android.exoplayer2.j2.i1.a i1$a, l0 l02, k k3) {
    }

    public void N(com.google.android.exoplayer2.j2.i1.a i1$a, long l2) {
    }

    public void O(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, int i3) {
    }

    public void P(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2) {
    }

    public void Q(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2) {
    }

    public void R(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2) {
    }

    public void S(com.google.android.exoplayer2.j2.i1.a i1$a, v v2) {
    }

    public void T(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3) {
    }

    public void U(com.google.android.exoplayer2.j2.i1.a i1$a, v v2) {
    }

    public void V(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, long l3) {
    }

    public void W(com.google.android.exoplayer2.j2.i1.a i1$a, v1.f v1$f2, v1.f v1$f3, int i4) {
    }

    public void X(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2) {
    }

    public void Y(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2) {
    }

    public void Z(com.google.android.exoplayer2.j2.i1.a i1$a, String string2) {
    }

    public void a(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, long l3, long l4) {
    }

    public void a0(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, int i3) {
    }

    @Deprecated
    public void b(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, int i3, int i4, float f5) {
    }

    public void b0(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, long l3, long l4) {
    }

    public void c(com.google.android.exoplayer2.j2.i1.a i1$a, String string2) {
    }

    public void c0(com.google.android.exoplayer2.j2.i1.a i1$a, i1 i12, e e3) {
    }

    @Deprecated
    public void d(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, i1 i13) {
    }

    public void d0(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2) {
    }

    public void e(com.google.android.exoplayer2.j2.i1.a i1$a, long l2, int i3) {
    }

    public void e0(com.google.android.exoplayer2.j2.i1.a i1$a, int i2) {
    }

    public void f(com.google.android.exoplayer2.j2.i1.a i1$a, int i2) {
    }

    @Deprecated
    public void f0(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, long l3) {
    }

    @Deprecated
    public void g(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    @Deprecated
    public void g0(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    public void h(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3) {
    }

    public void h0(com.google.android.exoplayer2.j2.i1.a i1$a, m1 m12, int i3) {
    }

    @Deprecated
    public void i(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, String string3, long l4) {
    }

    public void i0(com.google.android.exoplayer2.j2.i1.a i1$a, i1 i12, e e3) {
    }

    public void j(com.google.android.exoplayer2.j2.i1.a i1$a, PlaybackException playbackException2) {
    }

    public void j0(com.google.android.exoplayer2.j2.i1.a i1$a, v1.b v1$b2) {
    }

    @Deprecated
    public void k(com.google.android.exoplayer2.j2.i1.a i1$a, int i2) {
    }

    public void k0(com.google.android.exoplayer2.j2.i1.a i1$a, Object object2, long l3) {
    }

    public void l(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2) {
    }

    @Deprecated
    public void l0(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, d d3) {
    }

    public void m(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    @Deprecated
    public void m0(com.google.android.exoplayer2.j2.i1.a i1$a, List<a> list2) {
    }

    public void n(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    @Deprecated
    public void n0(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    public void o(com.google.android.exoplayer2.j2.i1.a i1$a, int i2) {
    }

    public void o0(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2) {
    }

    public void p(com.google.android.exoplayer2.j2.i1.a i1$a, u1 u12) {
    }

    public void p0(com.google.android.exoplayer2.j2.i1.a i1$a, d d2) {
    }

    @Deprecated
    public void q(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2) {
    }

    public void q0(com.google.android.exoplayer2.j2.i1.a i1$a) {
    }

    public void r(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, long l3, long l4) {
    }

    public void s(com.google.android.exoplayer2.j2.i1.a i1$a, n1 n12) {
    }

    public void t(com.google.android.exoplayer2.j2.i1.a i1$a, d d2) {
    }

    public void u(com.google.android.exoplayer2.j2.i1.a i1$a, d d2) {
    }

    public void v(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3, IOException iOException4, boolean z5) {
    }

    @Deprecated
    public void w(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, d d3) {
    }

    public void x(com.google.android.exoplayer2.j2.i1.a i1$a, d d2) {
    }

    public void y(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, long l3, long l4) {
    }

    @Deprecated
    public void z(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, long l3) {
    }
}
