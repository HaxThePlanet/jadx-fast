package com.google.android.exoplayer2.l2.v;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.l2.b;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class d0 implements i {

    private final int a;
    private final int b;
    private final List<m0> c;
    private final d0 d;
    private final SparseIntArray e;
    private final com.google.android.exoplayer2.l2.v.e0.c f;
    private final SparseArray<com.google.android.exoplayer2.l2.v.e0> g;
    private final SparseBooleanArray h;
    private final SparseBooleanArray i;
    private final com.google.android.exoplayer2.l2.v.c0 j;
    private com.google.android.exoplayer2.l2.v.b0 k;
    private k l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private com.google.android.exoplayer2.l2.v.e0 q;
    private int r;
    private int s;

    private class a implements com.google.android.exoplayer2.l2.v.y {

        private final c0 a;
        final com.google.android.exoplayer2.l2.v.d0 b;
        public a(com.google.android.exoplayer2.l2.v.d0 d0) {
            this.b = d0;
            super();
            c0 obj2 = new c0(new byte[4]);
            this.a = obj2;
        }

        @Override // com.google.android.exoplayer2.l2.v.y
        public void a(m0 m0, k k2, com.google.android.exoplayer2.l2.v.e0.d e0$d3) {
        }

        @Override // com.google.android.exoplayer2.l2.v.y
        public void b(d0 d0) {
            int i;
            c0 c0Var;
            int i2;
            int zVar;
            com.google.android.exoplayer2.l2.v.d0.b bVar;
            com.google.android.exoplayer2.l2.v.d0 d0Var;
            int obj10;
            if (d0.x() != 0) {
            }
            if (i4 &= 128 == 0) {
            }
            d0.J(6);
            final int i10 = 4;
            final int i11 = 0;
            i = i11;
            while (i < i7 /= i10) {
                d0.i(this.a, i10);
                this.a.q(3);
                i2 = 13;
                if (this.a.h(16) == 0) {
                } else {
                }
                c0Var = this.a.h(i2);
                if (d0.e(this.b).get(c0Var) == null) {
                }
                i++;
                bVar = new d0.b(this.b, c0Var);
                zVar = new z(bVar);
                d0.e(this.b).put(c0Var, zVar);
                d0.j(this.b);
                this.a.q(i2);
            }
            if (d0.k(this.b) != 2) {
                d0.e(this.b).remove(i11);
            }
        }
    }

    private class b implements com.google.android.exoplayer2.l2.v.y {

        private final c0 a;
        private final SparseArray<com.google.android.exoplayer2.l2.v.e0> b;
        private final SparseIntArray c;
        private final int d;
        final com.google.android.exoplayer2.l2.v.d0 e;
        public b(com.google.android.exoplayer2.l2.v.d0 d0, int i2) {
            this.e = d0;
            super();
            c0 obj2 = new c0(new byte[5]);
            this.a = obj2;
            obj2 = new SparseArray();
            this.b = obj2;
            obj2 = new SparseIntArray();
            this.c = obj2;
            this.d = i2;
        }

        private com.google.android.exoplayer2.l2.v.e0.b c(d0 d0, int i2) {
            int trim;
            int arrayList;
            int trim2;
            int i5;
            int cmp2;
            int aVar;
            int i6;
            int cmp;
            int i4;
            int bArr;
            int i;
            int i3;
            final int i7 = d0.e();
            i2 += i7;
            trim2 = i8;
            arrayList = trim;
            while (d0.e() < obj15) {
                cmp2 = d0.x();
                i12 += aVar;
                if (i6 > obj15) {
                    break;
                } else {
                }
                cmp = 89;
                if (cmp2 == 5) {
                } else {
                }
                if (cmp2 == 106) {
                } else {
                }
                if (cmp2 == 122) {
                } else {
                }
                if (cmp2 == 127) {
                } else {
                }
                if (cmp2 == 123) {
                } else {
                }
                i4 = 3;
                if (cmp2 == 10) {
                } else {
                }
                if (cmp2 == cmp) {
                } else {
                }
                if (cmp2 == 111) {
                }
                d0.J(i6 -= i5);
                trim2 = 257;
                arrayList = new ArrayList();
                while (d0.e() < i6) {
                    int i11 = 4;
                    bArr = new byte[i11];
                    d0.j(bArr, 0, i11);
                    aVar = new e0.a(d0.u(i4).trim(), d0.x(), bArr);
                    arrayList.add(aVar);
                }
                trim2 = cmp;
                i11 = 4;
                bArr = new byte[i11];
                d0.j(bArr, 0, i11);
                aVar = new e0.a(d0.u(i4).trim(), d0.x(), bArr);
                arrayList.add(aVar);
                trim = d0.u(i4).trim();
                trim2 = 138;
                if (d0.x() == 21) {
                }
                trim2 = i4;
                trim2 = bArr;
                trim2 = i;
                cmp2 = d0.z();
                if (Long.compare(cmp2, i3) == 0) {
                } else {
                }
                if (Long.compare(cmp2, i) == 0) {
                } else {
                }
                if (Long.compare(cmp2, bArr) == 0) {
                } else {
                }
                if (Long.compare(cmp2, cmp) == 0) {
                }
                trim2 = 36;
            }
            d0.I(obj15);
            e0.b bVar = new e0.b(trim2, trim, arrayList, Arrays.copyOfRange(d0.d(), i7, obj15));
            return bVar;
        }

        @Override // com.google.android.exoplayer2.l2.v.y
        public void a(m0 m0, k k2, com.google.android.exoplayer2.l2.v.e0.d e0$d3) {
        }

        @Override // com.google.android.exoplayer2.l2.v.y
        public void b(d0 d0) {
            boolean z;
            Object m0Var;
            int i2;
            int i3;
            int i5;
            int i7;
            int i4;
            List list;
            int keyAt;
            k kVar2;
            int i6;
            int valueAt;
            int valueAt2;
            com.google.android.exoplayer2.l2.v.e0.b bVar;
            int i;
            boolean z2;
            int dVar;
            k kVar;
            com.google.android.exoplayer2.l2.v.e0.d dVar2;
            final Object obj = this;
            d0 d0Var = d0;
            i3 = 2;
            if (d0.x() != i3) {
            }
            i5 = 0;
            final int i12 = 1;
            if (d0.k(obj.e) != i12 && d0.k(obj.e) != i3) {
                if (d0.k(obj.e) != i3) {
                    if (d0.f(obj.e) == i12) {
                        m0Var = d0.l(obj.e).get(i5);
                    } else {
                        m0Var = new m0((m0)d0.l(obj.e).get(i5).c(), obj7);
                        d0.l(obj.e).add(m0Var);
                    }
                } else {
                }
            } else {
            }
            if (i13 &= 128 == 0) {
            }
            d0Var.J(i12);
            int i15 = d0.D();
            keyAt = 3;
            d0Var.J(keyAt);
            d0Var.i(obj.a, i3);
            obj.a.q(keyAt);
            d0.m(obj.e, obj.a.h(13));
            d0Var.i(obj.a, i3);
            obj.a.q(4);
            dVar = 12;
            d0Var.J(obj.a.h(dVar));
            final int i22 = 8192;
            final int i23 = 21;
            if (d0.k(obj.e) == i3 && d0.n(obj.e) == null) {
                if (d0.n(obj.e) == null) {
                    int i24 = 0;
                    e0.b bVar2 = new e0.b(i23, i24, i24, p0.f);
                    com.google.android.exoplayer2.l2.v.d0 d0Var32 = obj.e;
                    d0.o(d0Var32, d0.p(d0Var32).a(i23, bVar2));
                    dVar2 = new e0.d(i15, i23, i22);
                    d0.n(obj.e).a(m0Var, d0.q(obj.e), dVar2);
                }
            }
            obj.b.clear();
            obj.c.clear();
            valueAt = d0.a();
            while (valueAt > 0) {
                dVar2 = 5;
                d0Var.i(obj.a, dVar2);
                i4 = obj.a.h(8);
                obj.a.q(keyAt);
                kVar = obj.a.h(i);
                obj.a.q(valueAt2);
                int i16 = obj.a.h(dVar);
                bVar = obj.c(d0Var, i16);
                if (i4 != 6) {
                } else {
                }
                i4 = bVar.a;
                valueAt -= i17;
                if (d0.k(obj.e) == i3) {
                } else {
                }
                kVar2 = kVar;
                if (d0.r(obj.e).get(kVar2)) {
                } else {
                }
                if (d0.k(obj.e) == i3 && i4 == i23) {
                } else {
                }
                i4 = d0.p(obj.e).a(i4, bVar);
                if (d0.k(obj.e) == i3) {
                } else {
                }
                obj.c.put(kVar2, kVar);
                obj.b.put(kVar2, i4);
                i5 = 0;
                keyAt = 3;
                valueAt2 = 4;
                i = 13;
                if (kVar < obj.c.get(kVar2, i22)) {
                }
                if (i4 == i23) {
                } else {
                }
                i4 = d0.n(obj.e);
                kVar2 = i4;
                if (i4 == dVar2) {
                }
            }
            i7 = 0;
            while (i7 < obj.c.size()) {
                keyAt = obj.c.keyAt(i7);
                valueAt = obj.c.valueAt(i7);
                d0.r(obj.e).put(keyAt, i12);
                d0.s(obj.e).put(valueAt, i12);
                valueAt2 = obj.b.valueAt(i7);
                if ((e0)valueAt2 != 0 && (e0)valueAt2 != d0.n(obj.e)) {
                }
                i7++;
                if ((e0)valueAt2 != d0.n(obj.e)) {
                }
                d0.e(obj.e).put(valueAt, (e0)valueAt2);
                dVar = new e0.d(i15, keyAt, i22);
                valueAt2.a(m0Var, d0.q(obj.e), dVar);
            }
            if (d0.k(obj.e) == i3) {
                if (!d0.g(obj.e)) {
                    d0.q(obj.e).n();
                    d0.i(obj.e, 0);
                    d0.h(obj.e, i12);
                }
            } else {
                d0.e(obj.e).remove(obj.d);
                com.google.android.exoplayer2.l2.v.d0 d0Var7 = obj.e;
                if (d0.k(d0Var7) == i12) {
                    i7 = m0Var;
                } else {
                    i7 = m0Var + -1;
                }
                d0.i(d0Var7, i7);
                if (d0.f(obj.e) == 0) {
                    d0.q(obj.e).n();
                    d0.h(obj.e, i12);
                }
            }
        }
    }
    static {
        final com.google.android.exoplayer2.l2.v.d dVar = d.a;
    }

    public d0(int i, m0 m02, com.google.android.exoplayer2.l2.v.e0.c e0$c3) {
        super(i, m02, c3, 112800);
    }

    public d0(int i, m0 m02, com.google.android.exoplayer2.l2.v.e0.c e0$c3, int i4) {
        Object obj1;
        int obj3;
        super();
        g.e(c3);
        this.f = (e0.c)c3;
        this.b = i4;
        this.a = i;
        if (i != 1) {
            if (i == 2) {
                this.c = Collections.singletonList(m02);
            } else {
                obj1 = new ArrayList();
                this.c = obj1;
                obj1.add(m02);
            }
        } else {
        }
        obj1 = new d0(new byte[9400], 0);
        this.d = obj1;
        obj1 = new SparseBooleanArray();
        this.h = obj1;
        obj1 = new SparseBooleanArray();
        this.i = obj1;
        obj1 = new SparseArray();
        this.g = obj1;
        obj1 = new SparseIntArray();
        this.e = obj1;
        obj1 = new c0(i4);
        this.j = obj1;
        this.s = -1;
        w();
    }

    static SparseArray e(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.g;
    }

    static int f(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.m;
    }

    static boolean g(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.n;
    }

    static boolean h(com.google.android.exoplayer2.l2.v.d0 d0, boolean z2) {
        d0.n = z2;
        return z2;
    }

    static int i(com.google.android.exoplayer2.l2.v.d0 d0, int i2) {
        d0.m = i2;
        return i2;
    }

    static int j(com.google.android.exoplayer2.l2.v.d0 d0) {
        final int i = d0.m;
        d0.m = i + 1;
        return i;
    }

    static int k(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.a;
    }

    static List l(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.c;
    }

    static int m(com.google.android.exoplayer2.l2.v.d0 d0, int i2) {
        d0.s = i2;
        return i2;
    }

    static com.google.android.exoplayer2.l2.v.e0 n(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.q;
    }

    static com.google.android.exoplayer2.l2.v.e0 o(com.google.android.exoplayer2.l2.v.d0 d0, com.google.android.exoplayer2.l2.v.e0 e02) {
        d0.q = e02;
        return e02;
    }

    static com.google.android.exoplayer2.l2.v.e0.c p(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.f;
    }

    static k q(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.l;
    }

    static SparseBooleanArray r(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.h;
    }

    static SparseBooleanArray s(com.google.android.exoplayer2.l2.v.d0 d0) {
        return d0.i;
    }

    private boolean t(j j) {
        int i;
        int read;
        d0 d0Var;
        byte[] bArr = this.d.d();
        final int i5 = 0;
        final int i6 = 188;
        i = this.d.a();
        if (i2 - 9400 < i6 && i > 0) {
            i = this.d.a();
            if (i > 0) {
                System.arraycopy(bArr, this.d.e(), bArr, i5, i);
            }
            this.d.G(bArr, i);
        }
        while (this.d.a() < i6) {
            int i4 = this.d.f();
            read = j.read(bArr, i4, i4 - 9400);
            this.d.H(i4 += read);
        }
        return 1;
    }

    private int u() {
        int i2;
        int i;
        int i3;
        int i4 = this.d.e();
        i = this.d.f();
        i3 = f0.a(this.d.d(), i4, i);
        this.d.I(i3);
        int i8 = i3 + 188;
        if (i8 > i) {
            i6 += i7;
            this.r = i;
            if (this.a == 2) {
                if (i > 376) {
                } else {
                }
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", 0);
            }
        } else {
            this.r = 0;
        }
        return i8;
    }

    private void v(long l) {
        boolean b0Var2;
        com.google.android.exoplayer2.l2.v.b0 b0Var;
        long l2;
        long l3;
        int i;
        int i2;
        int i3;
        k obj10;
        com.google.android.exoplayer2.l2.q obj11;
        if (!this.o) {
            this.o = true;
            if (Long.compare(l4, l2) != 0) {
                super(this.j.c(), this.j.b(), obj4, l, obj6, this.s, this.b);
                this.k = b0Var2;
                this.l.d(b0Var2.b());
            } else {
                obj11 = new q.b(this.j.b(), obj1);
                this.l.d(obj11);
            }
        }
    }

    private void w() {
        int i;
        SparseArray sparseArray;
        int keyAt;
        Object valueAt;
        this.h.clear();
        this.g.clear();
        SparseArray sparseArray3 = this.f.b();
        final int i3 = 0;
        i = i3;
        while (i < sparseArray3.size()) {
            this.g.put(sparseArray3.keyAt(i), (e0)sparseArray3.valueAt(i));
            i++;
        }
        d0.a aVar = new d0.a(this);
        z zVar = new z(aVar);
        this.g.put(i3, zVar);
        this.q = 0;
    }

    private boolean x(int i) {
        int i2;
        int i3;
        int obj4;
        if (this.a != 2 && !this.n) {
            if (!this.n) {
                if (!this.i.get(i, false)) {
                    i3 = 1;
                }
            } else {
            }
        } else {
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void a(k k) {
        this.l = k;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public boolean b(j j) {
        int i;
        int i6;
        int i3;
        int i4;
        int i5;
        int i2;
        byte[] bArr = this.d.d();
        final int i7 = 0;
        j.m(bArr, i7, 940);
        i = i7;
        while (i < 188) {
            i3 = i7;
            i5 = 1;
            while (i3 < 5) {
                i3++;
                i5 = 1;
            }
            i6 = i5;
            i++;
            if (bArr[i10 += i] != 71) {
            } else {
            }
            i3++;
            i6 = i7;
        }
        return i7;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        int cmp3;
        boolean z2;
        int i3;
        boolean z;
        int i10;
        boolean cmp;
        int cmp2;
        int i7;
        boolean z3;
        int i9;
        SparseIntArray sparseIntArray;
        int i4;
        int i5;
        int i2;
        long position;
        int i;
        int i11;
        int i8;
        int i6;
        final Object obj = this;
        j jVar = j;
        p pVar = p2;
        long length = j.getLength();
        final int i24 = 2;
        final int i25 = 1;
        final int i26 = 0;
        if (obj.n) {
            if (Long.compare(length, i7) != 0 && obj.a != i24) {
                i10 = obj.a != i24 ? i25 : i26;
            } else {
            }
            if (i10 != 0 && !obj.j.d()) {
                if (!obj.j.d()) {
                    return obj.j.e(jVar, pVar, obj.s);
                }
            }
            obj.v(length);
            obj.p = i26;
            i4 = 0;
            obj.d(i4, obj12);
            if (obj.p && Long.compare(position, i4) != 0) {
                obj.p = i26;
                i4 = 0;
                obj.d(i4, obj12);
                if (Long.compare(position, i4) != 0) {
                    pVar.a = i4;
                    return i25;
                }
            }
            z2 = obj.k;
            if (z2 != null && z2.d()) {
                if (z2.d()) {
                    return obj.k.c(jVar, pVar);
                }
            }
        }
        if (!t(j)) {
            return -1;
        }
        int i13 = u();
        int i16 = obj.d.f();
        if (i13 > i16) {
            return i26;
        }
        i3 = obj.d.n();
        if (i27 &= i3 != 0) {
            obj.d.I(i13);
            return i26;
        }
        i5 = i29 &= i3 != 0 ? i25 : i26;
        i32 >>= 8;
        i = i3 & 32 != 0 ? i25 : i26;
        i11 = i3 & 16 != 0 ? i25 : i26;
        if (i11 != 0) {
            i8 = obj.g.get(i33);
        } else {
            i8 = 0;
        }
        if (i8 == 0) {
            obj.d.I(i13);
            return i26;
        }
        i3 &= 15;
        int i22 = obj.e.get(i33, i3 + -1);
        obj.e.put(i33, i3);
        if (obj.a != i24 && i22 == i3) {
            i3 &= 15;
            i22 = obj.e.get(i33, i3 + -1);
            obj.e.put(i33, i3);
            if (i22 == i3) {
                obj.d.I(i13);
                return i26;
            }
            if (i3 != i23 &= 15) {
                i8.c();
            }
        }
        if (i != 0) {
            i9 = i19 &= 64 != 0 ? i24 : i26;
            i2 |= i9;
            obj.d.J(i18 -= i25);
        }
        if (obj.x(i33)) {
            obj.d.H(i13);
            i8.b(obj.d, i2);
            obj.d.H(i16);
        }
        if (obj.a != i24 && !obj.n && obj.n && Long.compare(length, z) != 0) {
            if (!obj.n) {
                if (obj.n) {
                    if (Long.compare(length, z) != 0) {
                        obj.p = i25;
                    }
                }
            }
        }
        obj.d.I(i13);
        return i26;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void d(long l, long l2) {
        int i2;
        int cmp;
        Object obj;
        int i;
        long cmp2;
        int obj10;
        int obj11;
        obj11 = 1;
        final int i3 = 0;
        obj10 = this.a != 2 ? obj11 : i3;
        g.f(obj10);
        i2 = i3;
        cmp = 0;
        while (i2 < this.c.size()) {
            obj = this.c.get(i2);
            cmp2 = -9223372036854775807L;
            if (Long.compare(l3, cmp2) == 0) {
            } else {
            }
            i = i3;
            if (i == 0) {
            }
            if (i != 0) {
            }
            i2++;
            cmp = 0;
            obj.g(obj12);
            long l4 = obj.c();
            if (Long.compare(l4, cmp2) != 0 && Long.compare(l4, cmp) != 0 && Long.compare(l4, obj12) != 0) {
            } else {
            }
            i = i3;
            if (Long.compare(l4, cmp) != 0) {
            } else {
            }
            if (Long.compare(l4, obj12) != 0) {
            } else {
            }
            i = obj11;
            i = obj11;
        }
        obj10 = this.k;
        if (Long.compare(obj12, cmp) != 0 && obj10 != null) {
            obj10 = this.k;
            if (obj10 != null) {
                obj10.h(obj12);
            }
        }
        this.d.E(i3);
        this.e.clear();
        obj10 = i3;
        while (obj10 < this.g.size()) {
            (e0)this.g.valueAt(obj10).c();
            obj10++;
        }
        this.r = i3;
    }
}
