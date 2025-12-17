package com.google.android.exoplayer2.l2.u;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.o;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.t.b;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.c;
import com.google.android.exoplayer2.l2.d;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.n;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q.b;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.m2.i.a;
import com.google.android.exoplayer2.m2.i.c;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class g implements i {

    private static final byte[] I;
    private static final i1 J;
    private int A;
    private int B;
    private int C;
    private boolean D;
    private k E;
    private s[] F;
    private s[] G;
    private boolean H;
    private final int a;
    private final com.google.android.exoplayer2.l2.u.j b;
    private final List<i1> c;
    private final SparseArray<com.google.android.exoplayer2.l2.u.g.b> d;
    private final d0 e;
    private final d0 f;
    private final d0 g;
    private final byte[] h;
    private final d0 i;
    private final m0 j;
    private final c k;
    private final d0 l;
    private final ArrayDeque<com.google.android.exoplayer2.l2.u.c.a> m;
    private final ArrayDeque<com.google.android.exoplayer2.l2.u.g.a> n;
    private final s o;
    private int p;
    private int q;
    private long r;
    private int s;
    private d0 t;
    private long u;
    private int v;
    private long w;
    private long x;
    private long y;
    private com.google.android.exoplayer2.l2.u.g.b z;

    private static final class a {

        public final long a;
        public final int b;
        public a(long l, int i2) {
            super();
            this.a = l;
            this.b = obj3;
        }
    }

    private static final class b {

        public final s a;
        public final com.google.android.exoplayer2.l2.u.l b;
        public final d0 c;
        public com.google.android.exoplayer2.l2.u.m d;
        public com.google.android.exoplayer2.l2.u.e e;
        public int f;
        public int g;
        public int h;
        public int i;
        private final d0 j;
        private final d0 k;
        private boolean l;
        public b(s s, com.google.android.exoplayer2.l2.u.m m2, com.google.android.exoplayer2.l2.u.e e3) {
            super();
            this.a = s;
            this.d = m2;
            this.e = e3;
            l obj2 = new l();
            this.b = obj2;
            obj2 = new d0();
            this.c = obj2;
            obj2 = new d0(1);
            this.j = obj2;
            obj2 = new d0();
            this.k = obj2;
            j(m2, e3);
        }

        static boolean a(com.google.android.exoplayer2.l2.u.g.b g$b) {
            return b.l;
        }

        static boolean b(com.google.android.exoplayer2.l2.u.g.b g$b, boolean z2) {
            b.l = z2;
            return z2;
        }

        public int c() {
            int i2;
            int i;
            com.google.android.exoplayer2.l2.u.k kVar;
            if (!this.l) {
                i2 = mVar.f[this.f];
            } else {
                i2 = lVar.l[this.f] ? 1 : 0;
            }
            if (g() != null) {
                i2 |= kVar;
            }
            return i2;
        }

        public long d() {
            long[] lArr;
            long l;
            if (!this.l) {
                l = mVar.c[this.f];
            } else {
                l = lVar.g[this.h];
            }
            return l;
        }

        public long e() {
            long[] lArr;
            long l;
            if (!this.l) {
                l = mVar.e[this.f];
            } else {
                l = this.b.c(this.f);
            }
            return l;
        }

        public int f() {
            int i;
            int i2;
            if (!this.l) {
                i = mVar.d[this.f];
            } else {
                i = lVar.i[this.f];
            }
            return i;
        }

        public com.google.android.exoplayer2.l2.u.k g() {
            int i;
            int i2;
            com.google.android.exoplayer2.l2.u.k kVar;
            if (!this.l) {
                return null;
            }
            com.google.android.exoplayer2.l2.u.e eVar = lVar.a;
            p0.i(eVar);
            if (lVar2.o != null) {
            } else {
                kVar = mVar.a.a(eVar.a);
            }
            if (kVar != null && kVar.a) {
                if (kVar.a) {
                    i2 = kVar;
                }
            }
            return i2;
        }

        public boolean h() {
            final int i5 = 1;
            this.f = i += i5;
            final int i6 = 0;
            if (!this.l) {
                return i6;
            }
            i3 += i5;
            this.g = i4;
            int i8 = this.h;
            if (i4 == lVar.h[i8]) {
                this.h = i8 += i5;
                this.g = i6;
                return i6;
            }
            return i5;
        }

        public int i(int i, int i2) {
            d0 d0Var;
            int i5;
            int i4;
            int i3;
            int length;
            int i7;
            int i6;
            d0 d0Var2;
            d0 obj11;
            int obj12;
            com.google.android.exoplayer2.l2.u.k kVar = g();
            i4 = 0;
            if (kVar == null) {
                return i4;
            }
            if (kVar.d != 0) {
                d0Var = lVar.p;
            } else {
                byte[] bArr = kVar.e;
                p0.i(bArr);
                this.k.G((byte[])bArr, bArr.length);
                i3 = length2;
                d0Var = d0Var2;
            }
            boolean z = this.b.g(this.f);
            int i23 = 1;
            if (!z) {
                if (i2 != 0) {
                    i7 = i23;
                } else {
                    i7 = i4;
                }
            } else {
            }
            i6 = i7 != 0 ? 128 : i4;
            this.j.d()[i4] = (byte)i26;
            this.j.I(i4);
            this.a.f(this.j, i23, i23);
            this.a.f(d0Var, i3, i23);
            if (i7 == 0) {
                return i3 += i23;
            }
            i5 = 6;
            int i24 = 3;
            int i25 = 2;
            int i27 = 8;
            if (!z) {
                this.c.E(i27);
                byte[] bArr2 = this.c.d();
                bArr2[i4] = i4;
                bArr2[i23] = i23;
                bArr2[i25] = (byte)i9;
                bArr2[i24] = (byte)obj12;
                bArr2[4] = (byte)i11;
                bArr2[5] = (byte)i13;
                bArr2[i5] = (byte)obj12;
                bArr2[7] = (byte)obj11;
                this.a.f(this.c, i27, i23);
                return i17 += i27;
            }
            obj11 = obj11.p;
            obj11.J(-2);
            i20 += i25;
            if (i2 != 0) {
                this.c.E(i21);
                i5 = this.c.d();
                obj11.j(i5, i4, i21);
                obj11 += i2;
                i5[i25] = (byte)obj12;
                i5[i24] = (byte)obj11;
                obj11 = this.c;
            }
            this.a.f(obj11, i21, i23);
            return i15 += i21;
        }

        public void j(com.google.android.exoplayer2.l2.u.m m, com.google.android.exoplayer2.l2.u.e e2) {
            this.d = m;
            this.e = e2;
            this.a.e(obj1.f);
            k();
        }

        public void k() {
            this.b.f();
            int i = 0;
            this.f = i;
            this.h = i;
            this.g = i;
            this.i = i;
            this.l = i;
        }

        public void l(long l) {
            int i;
            boolean z;
            com.google.android.exoplayer2.l2.u.l cmp;
            int i2;
            i = this.f;
            cmp = this.b;
            while (i < cmp.f) {
                if (Long.compare(l2, l) < 0) {
                }
                if (lVar.l[i]) {
                }
                i++;
                cmp = this.b;
                this.i = i;
            }
        }

        public void m() {
            boolean z;
            com.google.android.exoplayer2.l2.u.k kVar = g();
            if (kVar == null) {
            }
            d0 d0Var = lVar2.p;
            int i = kVar.d;
            if (i != 0) {
                d0Var.J(i);
            }
            if (this.b.g(this.f)) {
                d0Var.J(i2 *= 6);
            }
        }

        public void n(t t) {
            String str;
            com.google.android.exoplayer2.l2.u.e eVar = lVar.a;
            p0.i(eVar);
            com.google.android.exoplayer2.l2.u.k kVar = mVar.a.a(eVar.a);
            str = kVar != null ? kVar.b : 0;
            i1.b bVar = jVar2.f.a();
            bVar.L(t.c(str));
            this.a.e(bVar.E());
        }
    }
    static {
        com.google.android.exoplayer2.l2.u.a aVar = a.a;
        byte[] bArr = new byte[16];
        bArr = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        g.I = bArr;
        i1.b bVar = new i1.b();
        bVar.e0("application/x-emsg");
        g.J = bVar.E();
    }

    public g(int i, m0 m02, com.google.android.exoplayer2.l2.u.j j3, List<i1> list4) {
        super(i, m02, j3, list4, 0);
    }

    public g(int i, m0 m02, com.google.android.exoplayer2.l2.u.j j3, List<i1> list4, s s5) {
        super();
        this.a = i;
        this.j = m02;
        this.b = j3;
        this.c = Collections.unmodifiableList(list4);
        this.o = s5;
        c obj1 = new c();
        this.k = obj1;
        int obj2 = 16;
        obj1 = new d0(obj2);
        this.l = obj1;
        obj1 = new d0(a0.a);
        this.e = obj1;
        obj1 = new d0(5);
        this.f = obj1;
        obj1 = new d0();
        this.g = obj1;
        obj1 = new byte[obj2];
        this.h = obj1;
        obj2 = new d0(obj1);
        this.i = obj2;
        obj1 = new ArrayDeque();
        this.m = obj1;
        obj1 = new ArrayDeque();
        this.n = obj1;
        obj1 = new SparseArray();
        this.d = obj1;
        obj1 = -9223372036854775807L;
        this.x = obj1;
        this.w = obj1;
        this.y = obj1;
        this.E = k.e;
        obj1 = 0;
        this.F = new s[obj1];
        this.G = new s[obj1];
    }

    private static com.google.android.exoplayer2.l2.u.g.b A(d0 d0, SparseArray<com.google.android.exoplayer2.l2.u.g.b> sparseArray2, boolean z3) {
        int i2;
        int i;
        int i3;
        int i4;
        int obj4;
        Object obj5;
        int obj6;
        d0.I(8);
        int i7 = c.b(d0.n());
        if (z3 != 0) {
            obj5 = sparseArray2.valueAt(0);
        } else {
            obj5 = sparseArray2.get(d0.n());
        }
        if ((g.b)obj5 == null) {
            return null;
        }
        if (i7 & 1 != 0) {
            i2 = d0.C();
            obj6 = obj5.b;
            obj6.c = i2;
            obj6.d = i2;
        }
        obj6 = obj5.e;
        if (i7 & 2 != 0) {
            i10--;
        } else {
            i = obj6.a;
        }
        if (i7 & 8 != 0) {
            i3 = d0.n();
        } else {
            i3 = obj6.b;
        }
        if (i7 & 16 != 0) {
            i4 = d0.n();
        } else {
            i4 = obj6.c;
        }
        if (i7 &= 32 != 0) {
            obj4 = d0.n();
        } else {
            obj4 = obj6.d;
        }
        e eVar = new e(i, i3, i4, obj4);
        obj6.a = eVar;
        return (g.b)obj5;
    }

    private static void B(com.google.android.exoplayer2.l2.u.c.a c$a, SparseArray<com.google.android.exoplayer2.l2.u.g.b> sparseArray2, boolean z3, int i4, byte[] b5Arr5) {
        long l;
        int i2;
        boolean z;
        int i;
        int obj7;
        Object obj9;
        com.google.android.exoplayer2.l2.u.c.b bVar = a.g(1952868452);
        g.e(bVar);
        obj7 = g.A(bVar.b, sparseArray2, z3);
        if (obj7 == null) {
        }
        final com.google.android.exoplayer2.l2.u.l obj8 = obj7.b;
        obj7.k();
        final int i5 = 1;
        g.b.b(obj7, i5);
        com.google.android.exoplayer2.l2.u.c.b bVar2 = a.g(1952867444);
        if (bVar2 != null && i4 & 2 == 0) {
            if (i4 & 2 == 0) {
                obj8.r = g.z(bVar2.b);
                obj8.s = i5;
            } else {
                obj8.r = obj8.r;
                obj8.s = obj8.s;
            }
        } else {
        }
        g.E(a, obj7, i4);
        obj9 = obj8.a;
        g.e(obj9);
        obj7 = obj7.a.a(obj9.a);
        obj9 = a.g(1935763834);
        if (obj9 != null) {
            g.e(obj7);
            g.u((k)obj7, obj9.b, obj8);
        }
        obj9 = a.g(1935763823);
        if (obj9 != null) {
            g.t(obj9.b, obj8);
        }
        obj9 = a.g(1936027235);
        if (obj9 != null) {
            g.x(obj9.b, obj8);
        }
        obj7 = obj7 != null ? obj7.b : 0;
        g.v(a, obj7, obj8);
        obj9 = 0;
        while (obj9 < a.c.size()) {
            l = a.c.get(obj9);
            if (l.a == true) {
            }
            obj9++;
            g.F(l.b, obj8, b5Arr5);
        }
    }

    private static Pair<Integer, com.google.android.exoplayer2.l2.u.e> C(d0 d0) {
        d0.I(12);
        e eVar = new e(i3--, d0.n(), d0.n(), d0.n());
        return Pair.create(Integer.valueOf(d0.n()), eVar);
    }

    private static int D(com.google.android.exoplayer2.l2.u.g.b g$b, int i2, int i3, d0 d04, int i5) {
        Object obj;
        int i;
        int i25;
        boolean z;
        int i22;
        int i6;
        long l3;
        int i18;
        int i14;
        int i19;
        int i15;
        long l2;
        int i12;
        int i17;
        int i21;
        int i11;
        int i20;
        int i27;
        int i9;
        int cmp;
        int i28;
        int i23;
        long length;
        int i24;
        long l7;
        int i10;
        long l;
        long l6;
        int i8;
        long l4;
        long l5;
        int i26;
        int i4;
        int i7;
        int i16;
        int i13;
        obj = b;
        d04.I(8);
        int i33 = c.b(d04.n());
        com.google.android.exoplayer2.l2.u.j jVar = mVar.a;
        final com.google.android.exoplayer2.l2.u.l lVar = obj.b;
        final com.google.android.exoplayer2.l2.u.e eVar = lVar.a;
        p0.i(eVar);
        lVar.h[i2] = d04.B();
        long[] lArr = lVar.g;
        lArr[i2] = lVar.c;
        if (i33 & 1 != 0) {
            lArr[i2] = l11 += l2;
        }
        i15 = 0;
        int i39 = 1;
        i18 = i33 & 4 != 0 ? i39 : i15;
        i12 = eVar.d;
        if (i18 != 0) {
            i12 = d04.n();
        }
        i21 = i33 & 256 != 0 ? i39 : i15;
        i20 = i33 & 512 != 0 ? i39 : i15;
        i9 = i33 & 1024 != 0 ? i39 : i15;
        i25 = i33 &= 2048 != 0 ? i39 : i15;
        cmp = jVar.h;
        if (cmp != null && cmp.length == i39) {
            if (cmp.length == i39) {
                if (Long.compare(length, i24) == 0) {
                    cmp = jVar.i;
                    p0.i(cmp);
                    i23 = p0.y0((long[])cmp[i15], obj15, 1000000);
                } else {
                    i23 = i24;
                }
            } else {
                i24 = 0;
            }
        } else {
        }
        int[] iArr3 = lVar.j;
        i22 = 1;
        if (jVar.b == 2 && i3 & 1 != 0) {
            i22 = 1;
            i6 = i3 & 1 != 0 ? 1 : 0;
        } else {
        }
        i40 += i5;
        l3 = jVar.c;
        final long[] lArr3 = lArr2;
        l5 = l16;
        i28 = i5;
        while (i28 < i41) {
            if (i21 != 0) {
            } else {
            }
            i23 = eVar.b;
            g.e(i23);
            if (i20 != 0) {
            } else {
            }
            i10 = i21;
            i11 = eVar.c;
            g.e(i11);
            if (i9 != 0) {
            } else {
            }
            if (i28 == 0 && i18 != 0) {
            } else {
            }
            i26 = i18;
            i14 = eVar.d;
            if (i25 != 0) {
            } else {
            }
            i4 = i25;
            i7 = i20;
            i16 = i9;
            iArr3[i28] = 0;
            lArr3[i28] = l14 -= i49;
            if (!lVar.s) {
            }
            lVar.i[i28] = i11;
            int i36 = 1;
            if (i29 &= i36 == 0) {
            } else {
            }
            i = i24;
            lVar.l[i28] = i;
            l5 = l8 + l12;
            i28++;
            obj = b;
            i21 = i10;
            l3 = l;
            i18 = i26;
            i25 = i4;
            i20 = i7;
            i9 = i16;
            if (i6 != 0) {
            } else {
            }
            i = i36;
            if (i28 == 0) {
            } else {
            }
            lArr3[i28] = l15 += obj;
            i4 = i25;
            i7 = i20;
            i16 = i9;
            iArr3[i28] = (int)i20;
            i24 = 0;
            if (i18 != 0) {
            } else {
            }
            i26 = i18;
            i14 = i47;
            i26 = i18;
            i14 = l6;
            i10 = i21;
            i11 = i13;
            i23 = d04.n();
        }
        lVar.r = l5;
        return i41;
    }

    private static void E(com.google.android.exoplayer2.l2.u.c.a c$a, com.google.android.exoplayer2.l2.u.g.b g$b2, int i3) {
        int i4;
        int i7;
        int i5;
        int i6;
        int i8;
        int i;
        int i2;
        Object obj;
        int i9;
        final List obj8 = a.c;
        final int size = obj8.size();
        i4 = 0;
        i = i6;
        i2 = 1953658222;
        while (i7 < size) {
            obj = obj8.get(i7);
            d0 d0Var = obj.b;
            d0Var.I(12);
            i2 = d0Var.B();
            if (obj.a == i2 && i2 > 0) {
            }
            i7++;
            i2 = 1953658222;
            d0Var = obj.b;
            d0Var.I(12);
            i2 = d0Var.B();
            if (i2 > 0) {
            }
            i += i2;
            i6++;
        }
        b2.h = i4;
        b2.g = i4;
        b2.f = i4;
        b2.b.e(i6, i);
        i8 = i5;
        while (i4 < size) {
            i = obj8.get(i4);
            if (i.a == i2) {
            }
            i4++;
            i8 = i10;
            i5 = obj;
        }
    }

    private static void F(d0 d0, com.google.android.exoplayer2.l2.u.l l2, byte[] b3Arr3) {
        d0.I(8);
        final int i3 = 16;
        d0.j(b3Arr3, 0, i3);
        if (!Arrays.equals(b3Arr3, g.I)) {
        }
        g.w(d0, i3, l2);
    }

    private void G(long l) {
        boolean empty;
        while (!this.m.isEmpty()) {
            if (Long.compare(l2, l) == 0) {
            }
            l((c.a)this.m.pop());
        }
        f();
    }

    private boolean H(j j) {
        int i2;
        int empty;
        int cmp;
        boolean i5;
        int size;
        int i3;
        com.google.android.exoplayer2.l2.u.c.a aVar;
        long l;
        long length;
        long l3;
        int i4;
        long i;
        int i6;
        q.b bVar;
        long l2;
        int obj12;
        final int i14 = 8;
        aVar = 0;
        final int i15 = 1;
        if (this.s == 0 && !j.a(this.l.d(), aVar, i14, i15)) {
            if (!j.a(this.l.d(), aVar, i14, i15)) {
                return aVar;
            }
            this.s = i14;
            this.l.I(aVar);
            this.r = this.l.z();
            this.q = this.l.n();
        }
        length = this.r;
        if (Long.compare(length, i4) == 0) {
            j.readFully(this.l.d(), i14, i14);
            this.s = i12 += i14;
            this.r = this.l.C();
        } else {
            i4 = -1;
            if (Long.compare(length, i4) == 0 && Long.compare(length, i4) == 0 && !this.m.isEmpty()) {
                i4 = -1;
                if (Long.compare(length, i4) == 0) {
                    if (!this.m.isEmpty()) {
                        length = empty.b;
                    }
                }
                if (Long.compare(length, i4) != 0) {
                    this.r = i16 += i4;
                }
            }
        }
        if (Long.compare(l5, l7) < 0) {
        } else {
            position2 -= l8;
            i5 = this.q;
            i = 1835295092;
            i6 = 1836019558;
            if (i5 != i6) {
                if (i5 == i && !this.H) {
                    if (!this.H) {
                        bVar = new q.b(this.x, obj10, i17, obj5);
                        this.E.d(bVar);
                        this.H = i15;
                    }
                }
            } else {
            }
            if (this.q == i6) {
                i6 = aVar;
                while (i6 < this.d.size()) {
                    bVar = valueAt.b;
                    bVar.b = i17;
                    bVar.d = i17;
                    bVar.c = i17;
                    i6++;
                }
            }
            int i9 = this.q;
            int i21 = 0;
            if (i9 == i) {
                this.z = i21;
                this.u = i17 += l4;
                this.p = 2;
                return i15;
            }
            if (g.L(i9)) {
                i10 -= i19;
                aVar = new c.a(this.q, i3, i14);
                this.m.push(aVar);
                if (Long.compare(l3, i) == 0) {
                    G(i3);
                } else {
                    f();
                }
                return i15;
            } else {
                l3 = Integer.MAX_VALUE;
                if (g.M(this.q)) {
                    if (this.s != i14) {
                    } else {
                        i = this.r;
                        if (Long.compare(i, l3) > 0) {
                        } else {
                            obj12 = new d0((int)i);
                            System.arraycopy(this.l.d(), aVar, obj12.d(), aVar, i14);
                            this.t = obj12;
                            this.p = i15;
                        }
                        throw ParserException.d("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    throw ParserException.d("Leaf atom defines extended atom size (unsupported).");
                }
                if (Long.compare(i3, l3) > 0) {
                } else {
                    this.t = i21;
                    this.p = i15;
                }
            }
            throw ParserException.d("Skipping atom with length > 2147483647 (unsupported).");
        }
        throw ParserException.d("Atom size less than header length (unsupported).");
    }

    private void I(j j) {
        com.google.android.exoplayer2.l2.u.c.b bVar;
        long position;
        int i;
        int i2;
        i3 -= i4;
        position = this.t;
        if (position != null) {
            j.readFully(position.d(), 8, bVar);
            i = this.q;
            bVar = new c.b(i, position);
            n(bVar, j.getPosition());
        } else {
            j.j(bVar);
        }
        G(j.getPosition());
    }

    private void J(j j) {
        long l;
        int i2;
        int i;
        com.google.android.exoplayer2.l2.u.l lVar;
        boolean z;
        int cmp;
        final int i4 = 0;
        l = Long.MAX_VALUE;
        i2 = 0;
        i = i4;
        while (i2 < this.d.size()) {
            lVar = valueAt2.b;
            lVar = lVar.d;
            if (lVar.q && Long.compare(lVar, l) < 0) {
            }
            i2++;
            lVar = lVar.d;
            if (Long.compare(lVar, l) < 0) {
            }
            i = valueAt;
            l = lVar;
        }
        if (i == 0) {
            this.p = 3;
        }
        int i3 = (int)i5;
        if (i3 < 0) {
        } else {
            j.j(i3);
            i.b.a(j);
        }
        throw ParserException.a("Offset to encryption data was negative.", i4);
    }

    private boolean K(j j) {
        int i5;
        boolean z;
        com.google.android.exoplayer2.l2.u.g.b bVar;
        int i16;
        int i11;
        int i8;
        int i14;
        int i;
        com.google.android.exoplayer2.l2.u.j jVar;
        String str2;
        int i6;
        int i17;
        int length;
        int i15;
        long position;
        int i9;
        int i7;
        int i12;
        String str;
        int i2;
        int i3;
        long l;
        byte[] i13;
        int i4;
        int m0Var;
        int i10;
        final Object obj = this;
        com.google.android.exoplayer2.upstream.i iVar = j;
        i16 = 0;
        int i26 = 0;
        bVar = g.i(obj.d);
        if (obj.z == null && bVar == null) {
            bVar = g.i(obj.d);
            if (bVar == null) {
                int i20 = (int)i35;
                if (i20 < 0) {
                } else {
                    iVar.j(i20);
                    f();
                    return i26;
                }
                throw ParserException.a("Offset to end of mdat was negative.", i16);
            }
            if ((int)i36 < 0) {
                v.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                i11 = i26;
            }
            iVar.j(i11);
            obj.z = bVar;
        }
        i6 = 3;
        i7 = 1;
        i8 = bVar.f();
        obj.A = i8;
        iVar.j(i8);
        bVar.m();
        if (obj.p == i6 && bVar.f < bVar.i && !bVar.h()) {
            i8 = bVar.f();
            obj.A = i8;
            if (bVar.f < bVar.i) {
                iVar.j(i8);
                bVar.m();
                if (!bVar.h()) {
                    obj.z = i16;
                }
                obj.p = i6;
                return i7;
            }
            if (jVar3.g == i7) {
                i12 = 8;
                obj.A = i8 -= i12;
                iVar.j(i12);
            }
            if ("audio/ac4".equals(i1Var.D)) {
                str = 7;
                obj.B = bVar.i(obj.A, str);
                o.a(obj.A, obj.i);
                bVar.a.c(obj.i, str);
                obj.B = i32 += str;
            } else {
                obj.B = bVar.i(obj.A, i26);
            }
            obj.A = i27 += i2;
            obj.p = 4;
            obj.C = i26;
        }
        jVar = mVar2.a;
        s sVar2 = bVar.a;
        m0Var = obj.j;
        if (m0Var != null) {
            l = m0Var.a(bVar.e());
        }
        long l6 = l;
        if (jVar.j != 0) {
            i13 = obj.f.d();
            i13[i26] = i26;
            i13[i7] = i26;
            i13[2] = i26;
            int i48 = jVar.j;
            i4 = i48 - 4;
            while (obj.B < obj.A) {
                int i37 = obj.C;
                if (obj.D) {
                } else {
                }
                i15 = sVar2.b(iVar, i37, i26);
                obj.B = i21 += i15;
                obj.C = i23 -= i15;
                i16 = 0;
                i6 = 3;
                i9 = 4;
                i7 = 1;
                obj.g.E(i37);
                iVar.readFully(obj.g.d(), i26, obj.C);
                sVar2.c(obj.g, obj.C);
                i15 = obj.C;
                obj.g.I("video/hevc".equals(i1Var3.D));
                obj.g.H(a0.k(obj.g.d(), obj.g.f()));
                c.a(l6, obj15, obj.g);
                iVar.readFully(i13, i4, i48 + 1);
                obj.f.I(i26);
                int i38 = obj.f.n();
                obj.C = i38--;
                obj.e.I(i26);
                sVar2.c(obj.e, i9);
                sVar2.c(obj.f, i7);
                if (objArr.length > 0 && a0.g(i1Var2.D, i13[i9])) {
                } else {
                }
                i17 = i26;
                obj.D = i17;
                obj.B = i40 += 5;
                obj.A = i42 += i4;
                i6 = 3;
                if (a0.g(i1Var2.D, i13[i9])) {
                } else {
                }
                i17 = i7;
            }
        }
        com.google.android.exoplayer2.l2.u.k kVar = bVar.g();
        i5 = kVar != null ? kVar.c : 0;
        sVar2.d(l6, i4, bVar.c(), obj.A, 0);
        obj.q(l6);
        if (!bVar.h()) {
            obj.z = 0;
        }
        obj.p = 3;
        return 1;
    }

    private static boolean L(int i) {
        int i2;
        int obj1;
        if (i != 1836019574 && i != 1953653099 && i != 1835297121 && i != 1835626086 && i != 1937007212 && i != 1836019558 && i != 1953653094 && i != 1836475768) {
            if (i != 1953653099) {
                if (i != 1835297121) {
                    if (i != 1835626086) {
                        if (i != 1937007212) {
                            if (i != 1836019558) {
                                if (i != 1953653094) {
                                    if (i != 1836475768) {
                                        if (i == 1701082227) {
                                            obj1 = 1;
                                        } else {
                                            obj1 = 0;
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
        return obj1;
    }

    private static boolean M(int i) {
        int i2;
        int obj1;
        if (i != 1751411826 && i != 1835296868 && i != 1836476516 && i != 1936286840 && i != 1937011556 && i != 1937011827 && i != 1668576371 && i != 1937011555 && i != 1937011578 && i != 1937013298 && i != 1937007471 && i != 1668232756 && i != 1937011571 && i != 1952867444 && i != 1952868452 && i != 1953196132 && i != 1953654136 && i != 1953658222 && i != 1886614376 && i != 1935763834 && i != 1935763823 && i != 1936027235 && i != 1970628964 && i != 1935828848 && i != 1936158820 && i != 1701606260 && i != 1835362404) {
            if (i != 1835296868) {
                if (i != 1836476516) {
                    if (i != 1936286840) {
                        if (i != 1937011556) {
                            if (i != 1937011827) {
                                if (i != 1668576371) {
                                    if (i != 1937011555) {
                                        if (i != 1937011578) {
                                            if (i != 1937013298) {
                                                if (i != 1937007471) {
                                                    if (i != 1668232756) {
                                                        if (i != 1937011571) {
                                                            if (i != 1952867444) {
                                                                if (i != 1952868452) {
                                                                    if (i != 1953196132) {
                                                                        if (i != 1953654136) {
                                                                            if (i != 1953658222) {
                                                                                if (i != 1886614376) {
                                                                                    if (i != 1935763834) {
                                                                                        if (i != 1935763823) {
                                                                                            if (i != 1936027235) {
                                                                                                if (i != 1970628964) {
                                                                                                    if (i != 1935828848) {
                                                                                                        if (i != 1936158820) {
                                                                                                            if (i != 1701606260) {
                                                                                                                if (i != 1835362404) {
                                                                                                                    if (i == 1701671783) {
                                                                                                                        obj1 = 1;
                                                                                                                    } else {
                                                                                                                        obj1 = 0;
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
        return obj1;
    }

    private static int e(int i) {
        if (i < 0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Unexpected negative value: ");
        stringBuilder.append(i);
        throw ParserException.a(stringBuilder.toString(), 0);
    }

    private void f() {
        final int i = 0;
        this.p = i;
        this.s = i;
    }

    private com.google.android.exoplayer2.l2.u.e g(SparseArray<com.google.android.exoplayer2.l2.u.e> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return (e)sparseArray.valueAt(0);
        }
        Object obj3 = sparseArray.get(i2);
        g.e((e)obj3);
        return (e)obj3;
    }

    private static t h(List<com.google.android.exoplayer2.l2.u.c.b> list) {
        t tVar;
        int i;
        int arrayList;
        Object str;
        int str2;
        int bVar;
        String str3;
        i = 0;
        arrayList = tVar;
        while (i < list.size()) {
            str = list.get(i);
            if (str.a == 1886614376 && arrayList == null) {
            }
            i++;
            if (arrayList == null) {
            }
            str = str.b.d();
            str2 = h.f(str);
            if (str2 == null) {
            } else {
            }
            bVar = new t.b(str2, "video/mp4", str);
            arrayList.add(bVar);
            v.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
            arrayList = new ArrayList();
        }
        if (arrayList == null) {
        } else {
            tVar = new t(arrayList);
        }
        return tVar;
    }

    private static com.google.android.exoplayer2.l2.u.g.b i(SparseArray<com.google.android.exoplayer2.l2.u.g.b> sparseArray) {
        int i;
        long l;
        int i2;
        Object valueAt;
        int i3;
        int i4;
        int cmp;
        i = 0;
        l = Long.MAX_VALUE;
        i2 = 0;
        while (i2 < sparseArray.size()) {
            valueAt = sparseArray.valueAt(i2);
            if (!g.b.a((g.b)valueAt)) {
            } else {
            }
            if (g.b.a(valueAt) && valueAt.h == lVar.e) {
            } else {
            }
            i3 = valueAt.d();
            if (Long.compare(i3, l) < 0) {
            }
            i2++;
            i = valueAt;
            l = i3;
            if (valueAt.h == lVar.e) {
            } else {
            }
            if (valueAt.f != mVar.b) {
            }
        }
        return i;
    }

    private void j() {
        s[] arr;
        int i2;
        int length;
        int i;
        int i3;
        int i7;
        int i6;
        k kVar;
        int i5;
        int i4;
        s[] arr2 = new s[2];
        this.F = arr2;
        s sVar = this.o;
        i = 0;
        i2 = sVar != null ? 1 : i;
        if (i9 &= 4 != 0) {
            arr2[i2] = this.E.t(100, 5);
            i2 = i3;
            i6 = i5;
        }
        Object[] objArr2 = p0.s0(this.F, i2);
        this.F = (s[])objArr2;
        i7 = i;
        while (i7 < objArr2.length) {
            objArr2[i7].e(g.J);
            i7++;
        }
        this.G = new s[this.c.size()];
        while (i < objArr3.length) {
            arr = this.E.t(i6, 3);
            arr.e((i1)this.c.get(i));
            this.G[i] = arr;
            i++;
            i6 = length;
        }
    }

    private void l(com.google.android.exoplayer2.l2.u.c.a c$a) {
        int empty;
        int i;
        empty = a.a;
        if (empty == 1836019574) {
            p(a);
        } else {
            if (empty == 1836019558) {
                o(a);
            } else {
                if (!this.m.isEmpty()) {
                    (c.a)this.m.peek().d(a);
                }
            }
        }
    }

    private void m(d0 d0) {
        String str4;
        int i2;
        com.google.android.exoplayer2.l2.u.g.a aVar2;
        long l5;
        int i3;
        long l7;
        String str;
        int l4;
        long l;
        int i4;
        long l8;
        int i;
        long l6;
        long l9;
        s sVar;
        int i5;
        a aVar;
        String str2;
        String str3;
        long l3;
        long l2;
        final Object obj = this;
        Object obj2 = d0;
        if (objArr.length == 0) {
        }
        obj2.I(8);
        int i10 = c.c(d0.n());
        long l10 = -9223372036854775807L;
        if (i10 != 0) {
            if (i10 != 1) {
                StringBuilder stringBuilder = new StringBuilder(46);
                stringBuilder.append("Skipping unsupported emsg version: ");
                stringBuilder.append(i10);
                v.h("FragmentedMp4Extractor", stringBuilder.toString());
            }
            long l15 = l8;
            l6 = p0.y0(d0.C(), obj6, 1000000);
            str4 = d0.s();
            g.e(str4);
            str = d0.s();
            g.e(str);
            str2 = str4;
            l3 = l5;
            l2 = l14;
            str3 = str;
            l7 = l10;
        } else {
            str4 = d0.s();
            g.e(str4);
            String str7 = d0.s();
            g.e(str7);
            long l13 = d0.z();
            l4 = obj.y;
            i5 = Long.compare(l4, l10) != 0 ? l4 : l10;
            str2 = str4;
            l3 = l5;
            str3 = str;
            l2 = l;
            l6 = i5;
        }
        byte[] bArr2 = new byte[d0.a()];
        i3 = 0;
        obj2.j(bArr2, i3, d0.a());
        super(str2, str3, l3, obj22, l2, obj24, bArr2);
        d0 d0Var = new d0(obj.k.a(aVar3));
        int i7 = d0Var.a();
        s[] objArr2 = obj.F;
        i4 = i3;
        while (i4 < objArr2.length) {
            d0Var.I(i3);
            objArr2[i4].c(d0Var, i7);
            i4++;
        }
        if (Long.compare(l6, l10) == 0) {
            aVar2 = new g.a(l7, obj8, i7);
            obj.n.addLast(aVar2);
            obj.v = i12 += i7;
        } else {
            m0 m0Var = obj.j;
            if (m0Var != null) {
                l6 = m0Var.a(l6);
            }
            i2 = obj.F;
            while (i3 < i2.length) {
                i2[i3].d(l6, obj17, 1, i7, null);
                i3++;
            }
        }
    }

    private void n(com.google.android.exoplayer2.l2.u.c.b c$b, long l2) {
        boolean empty;
        int i;
        com.google.android.exoplayer2.l2.u.c.b obj3;
        Object obj4;
        if (!this.m.isEmpty()) {
            (c.a)this.m.peek().e(b);
        } else {
            empty = b.a;
            if (empty == 1936286840) {
                obj3 = g.y(b.b, l2);
                this.y = (Long)obj3.first.longValue();
                this.E.d((q)obj3.second);
                this.H = true;
            } else {
                if (empty == 1701671783) {
                    m(b.b);
                }
            }
        }
    }

    private void o(com.google.android.exoplayer2.l2.u.c.a c$a) {
        SparseArray size;
        long valueAt2;
        int i2;
        int i;
        int valueAt;
        long l;
        int obj8;
        i = 0;
        i2 = this.b != null ? 1 : i;
        g.s(a, this.d, i2, this.a, this.h);
        obj8 = g.h(a.c);
        if (obj8 != null) {
            i2 = i;
            while (i2 < this.d.size()) {
                (g.b)this.d.valueAt(i2).n(obj8);
                i2++;
            }
        }
        long l2 = -9223372036854775807L;
        if (Long.compare(valueAt2, l2) != 0) {
            while (i < this.d.size()) {
                (g.b)this.d.valueAt(i).l(this.w);
                i++;
            }
            this.w = l2;
        }
    }

    private void p(com.google.android.exoplayer2.l2.u.c.a c$a) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int size;
        Object second;
        n nVar;
        long l;
        long intValue;
        long l2;
        int i6;
        Object obj14;
        i3 = 1;
        i4 = 0;
        i = this.b == null ? i3 : i4;
        g.g(i, "Unexpected moov box.");
        final t tVar = g.h(a.c);
        com.google.android.exoplayer2.l2.u.c.a aVar = a.f(1836475768);
        g.e(aVar);
        SparseArray sparseArray4 = new SparseArray();
        l2 = l3;
        i5 = i4;
        while (i5 < aVar.c.size()) {
            second = aVar.c.get(i5);
            intValue = second.a;
            if (intValue == 1953654136) {
            } else {
            }
            if (intValue == 1835362404) {
            }
            i5++;
            l2 = g.r(second.b);
            Pair pair = g.C(second.b);
            sparseArray4.put((Integer)pair.first.intValue(), (e)pair.second);
        }
        nVar = new n();
        i2 = i8 &= 16 != 0 ? i3 : i4;
        b bVar3 = new b(this);
        obj14 = d.v(a, nVar, l2, intValue, tVar, i2, 0);
        int size2 = obj14.size();
        if (this.d.size() == 0) {
        } else {
            if (this.d.size() == size2) {
            } else {
                i3 = i4;
            }
            g.f(i3);
            while (i4 < size2) {
                i3 = obj14.get(i4);
                com.google.android.exoplayer2.l2.u.j jVar3 = i3.a;
                (g.b)this.d.get(jVar3.a).j((m)i3, g(sparseArray4, jVar3.a));
                i4++;
            }
        }
    }

    private void q(long l) {
        int i2;
        int i8;
        int i6;
        int i4;
        int i7;
        int i3;
        int i;
        int i5;
        while (!this.n.isEmpty()) {
            Object first = this.n.removeFirst();
            final int i11 = first.b;
            this.v = i9 -= i11;
            m0 m0Var = this.j;
            if (m0Var != null) {
            }
            final s[] objArr = this.F;
            i5 = i8;
            while (i5 < objArr.length) {
                objArr[i5].d(i2, obj5, 1, first.b, this.v);
                i5++;
            }
            objArr[i5].d(i2, obj5, 1, first.b, this.v);
            i5++;
            i2 = m0Var.a(l2 += l);
        }
    }

    private static long r(d0 d0) {
        long l;
        d0.I(8);
        if (c.c(d0.n()) == 0) {
            l = d0.z();
        } else {
            l = d0.C();
        }
        return l;
    }

    private static void s(com.google.android.exoplayer2.l2.u.c.a c$a, SparseArray<com.google.android.exoplayer2.l2.u.g.b> sparseArray2, boolean z3, int i4, byte[] b5Arr5) {
        int i;
        Object obj;
        int i3;
        int i2;
        i = 0;
        while (i < a.d.size()) {
            obj = a.d.get(i);
            if (obj.a == 1953653094) {
            }
            i++;
            g.B((c.a)obj, sparseArray2, z3, i4, b5Arr5);
        }
    }

    private static void t(d0 d0, com.google.android.exoplayer2.l2.u.l l2) {
        long l;
        int i = 8;
        d0.I(i);
        int i4 = d0.n();
        int i8 = 1;
        if (i6 &= i8 == i8) {
            d0.J(i);
        }
        int i2 = d0.B();
        if (i2 != i8) {
        } else {
            if (c.c(i4) == 0) {
                l = d0.z();
            } else {
                l = d0.C();
            }
            l2.d = l3 += l;
        }
        StringBuilder obj6 = new StringBuilder(40);
        obj6.append("Unexpected saio entry count: ");
        obj6.append(i2);
        throw ParserException.a(obj6.toString(), 0);
    }

    private static void u(com.google.android.exoplayer2.l2.u.k k, d0 d02, com.google.android.exoplayer2.l2.u.l l3) {
        boolean[] zArr;
        int i2;
        int i3;
        int i4;
        int i;
        int obj7;
        obj7 = k.d;
        int i5 = 8;
        d02.I(i5);
        i2 = 1;
        if (i8 &= i2 == i2) {
            d02.J(i5);
        }
        int i6 = d02.x();
        int i10 = d02.B();
        int i11 = l3.f;
        if (i10 > i11) {
        } else {
            int i12 = 0;
            if (i6 == 0) {
                i4 = i3;
                while (i3 < i10) {
                    int i13 = d02.x();
                    i4 += i13;
                    if (i13 > obj7) {
                    } else {
                    }
                    i = i12;
                    l3.n[i3] = i;
                    i3++;
                    i = i2;
                }
            } else {
                if (i6 > obj7) {
                } else {
                    i2 = i12;
                }
                i4 = zArr + 0;
                Arrays.fill(l3.n, i12, i10, i2);
            }
            Arrays.fill(l3.n, i10, l3.f, i12);
            if (i4 > 0) {
                l3.d(i4);
            }
        }
        StringBuilder obj8 = new StringBuilder(78);
        obj8.append("Saiz sample count ");
        obj8.append(i10);
        obj8.append(" is greater than fragment sample count");
        obj8.append(i11);
        throw ParserException.a(obj8.toString(), 0);
    }

    private static void v(com.google.android.exoplayer2.l2.u.c.a c$a, String string2, com.google.android.exoplayer2.l2.u.l l3) {
        int cmp;
        int i;
        int bArr;
        int i3;
        long l;
        int i4;
        int i9;
        int i2;
        d0 d0Var;
        int i5;
        int i6;
        int i7;
        int i8;
        Object obj = a;
        final Object obj2 = l3;
        final int i14 = 0;
        i9 = i4;
        i3 = i14;
        while (i3 < obj.c.size()) {
            Object obj3 = obj.c.get(i3);
            d0Var = obj3.b;
            i2 = obj3.a;
            i6 = 1936025959;
            i8 = 12;
            if (i2 == 1935828848) {
            } else {
            }
            d0Var.I(i8);
            if (i2 == 1936158820 && d0Var.n() == i6) {
            }
            i3++;
            d0Var.I(i8);
            if (d0Var.n() == i6) {
            }
            i9 = d0Var;
            d0Var.I(i8);
            if (d0Var.n() == i6) {
            }
            i4 = d0Var;
        }
        if (i4 != 0) {
            if (i9 == 0) {
            } else {
                int i10 = 8;
                i4.I(i10);
                int i19 = 4;
                i4.J(i19);
                int i20 = 1;
                if (c.c(i4.n()) == i20) {
                    i4.J(i19);
                }
                if (i4.n() != i20) {
                } else {
                    i9.I(i10);
                    cmp = c.c(i9.n());
                    i9.J(i19);
                    if (cmp == i20) {
                        if (Long.compare(l, i5) == 0) {
                        } else {
                            if (Long.compare(l2, i21) != 0) {
                            } else {
                                i9.J(i20);
                                int i12 = i9.x();
                                i7 = i9.x() == i20 ? i20 : i14;
                                if (i7 == 0) {
                                }
                                final int i22 = i9.x();
                                i = 16;
                                final byte[] bArr2 = new byte[i];
                                i9.j(bArr2, i14, i);
                                if (i22 == 0) {
                                    i = i9.x();
                                    i9.j(new byte[i], i14, i);
                                }
                                obj2.m = i20;
                                super(i7, string2, i22, bArr2, i18 >> 4, i12 & 15, bArr);
                                obj2.o = kVar;
                            }
                            throw ParserException.d("Entry count in sgpd != 1 (unsupported).");
                        }
                        throw ParserException.d("Variable length description in sgpd found (unsupported)");
                    }
                    if (cmp >= 2) {
                        i9.J(i19);
                    }
                }
            }
            throw ParserException.d("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static void w(d0 d0, int i2, com.google.android.exoplayer2.l2.u.l l3) {
        int obj4;
        d0.I(i2 += 8);
        obj4 = c.b(d0.n());
        if (obj4 & 1 != 0) {
        } else {
            int i3 = 0;
            obj4 = obj4 &= 2 != 0 ? 1 : i3;
            final int i4 = d0.B();
            if (i4 == 0) {
                Arrays.fill(l3.n, i3, l3.f, i3);
            }
            int i5 = l3.f;
            if (i4 != i5) {
            } else {
                Arrays.fill(l3.n, i3, i4, obj4);
                l3.d(d0.a());
                l3.b(d0);
            }
            obj4 = new StringBuilder(80);
            obj4.append("Senc sample count ");
            obj4.append(i4);
            obj4.append(" is different from fragment sample count");
            obj4.append(i5);
            throw ParserException.a(obj4.toString(), 0);
        }
        throw ParserException.d("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void x(d0 d0, com.google.android.exoplayer2.l2.u.l l2) {
        g.w(d0, 0, l2);
    }

    private static Pair<Long, d> y(d0 d0, long l2) {
        int i;
        int i6;
        long l3;
        long l;
        long l5;
        long[] lArr;
        long[] lArr3;
        int[] iArr;
        long[] lArr4;
        int i5;
        long[] lArr5;
        int i3;
        long l4;
        int i4;
        int i2;
        long[] lArr2;
        long l6;
        int obj26;
        Object obj = d0;
        obj.I(8);
        obj.J(4);
        final long l13 = d0.z();
        if (c.c(d0.n()) == 0) {
            l3 = d0.z();
            l5 = d0.z();
        } else {
            l3 = d0.C();
            l5 = d0.C();
        }
        long l14 = l3;
        i3 = i14;
        final long l15 = p0.y0(l14, obj4, 1000000);
        obj.J(2);
        i = d0.D();
        iArr = new int[i];
        lArr4 = new long[i];
        lArr = new long[i];
        lArr3 = new long[i];
        l4 = l15;
        i5 = i12;
        l = l6;
        while (i5 < i) {
            int i20 = d0.n();
            iArr[i5] = i20 &= i2;
            lArr4[i5] = i3;
            lArr3[i5] = l4;
            int i22 = l + l16;
            lArr5 = lArr;
            long[] lArr6 = lArr3;
            int[] iArr2 = iArr;
            long l8 = p0.y0(i22, obj4, 1000000);
            lArr5[i5] = l8 - l9;
            int i18 = 4;
            obj.J(i18);
            i3 += l10;
            i5++;
            iArr = iArr2;
            lArr3 = lArr6;
            i6 = i18;
            lArr = lArr5;
            lArr4 = lArr2;
            i = obj26;
            l = i22;
            l4 = l6;
        }
        d dVar = new d(iArr, lArr4, lArr, lArr3);
        return Pair.create(Long.valueOf(l15), dVar);
    }

    private static long z(d0 d0) {
        long l;
        d0.I(8);
        if (c.c(d0.n()) == 1) {
            l = d0.C();
        } else {
            l = d0.z();
        }
        return l;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void a(k k) {
        Object mVar;
        com.google.android.exoplayer2.l2.u.g.b bVar;
        int i2;
        com.google.android.exoplayer2.l2.u.e eVar;
        com.google.android.exoplayer2.l2.u.j jVar;
        long[] lArr2;
        int[] iArr2;
        int i3;
        long[] lArr;
        int[] iArr;
        int i;
        k obj13;
        this.E = k;
        f();
        j();
        mVar = this.b;
        if (mVar != null) {
            i2 = 0;
            super(this.b, new long[i2], new int[i2], 0, new long[i2], new int[i2], 0, obj11);
            eVar = new e(i2, i2, i2, i2);
            bVar = new g.b(k.t(i2, mVar.b), mVar, eVar);
            this.d.put(i2, bVar);
            this.E.n();
        }
    }

    @Override // com.google.android.exoplayer2.l2.i
    public boolean b(j j) {
        return i.b(j);
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        int i;
        boolean obj3;
        obj3 = this.p;
        do {
            obj3 = this.p;
            I(j);
            J(j);
        } while (obj3 != null);
        return 0;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void d(long l, long l2) {
        int i;
        Object valueAt;
        final int obj4 = 0;
        i = obj4;
        while (i < this.d.size()) {
            (g.b)this.d.valueAt(i).k();
            i++;
        }
        this.n.clear();
        this.v = obj4;
        this.w = obj5;
        this.m.clear();
        f();
    }

    @Override // com.google.android.exoplayer2.l2.i
    protected com.google.android.exoplayer2.l2.u.j k(com.google.android.exoplayer2.l2.u.j j) {
        return j;
    }
}
