package com.google.android.exoplayer2.l2.v;

import android.util.SparseArray;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.a0.a;
import com.google.android.exoplayer2.util.a0.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class q implements com.google.android.exoplayer2.l2.v.n {

    private final com.google.android.exoplayer2.l2.v.a0 a;
    private final boolean b;
    private final boolean c;
    private final com.google.android.exoplayer2.l2.v.v d;
    private final com.google.android.exoplayer2.l2.v.v e;
    private final com.google.android.exoplayer2.l2.v.v f;
    private long g;
    private final boolean[] h;
    private String i;
    private s j;
    private com.google.android.exoplayer2.l2.v.q.b k;
    private boolean l;
    private long m = -9223372036854775807L;
    private boolean n;
    private final d0 o;

    static class a {
    }

    private static final class b {

        private final s a;
        private final boolean b;
        private final boolean c;
        private final SparseArray<a0.b> d;
        private final SparseArray<a0.a> e;
        private final e0 f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private com.google.android.exoplayer2.l2.v.q.b.a m;
        private com.google.android.exoplayer2.l2.v.q.b.a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;
        public b(s s, boolean z2, boolean z3) {
            super();
            this.a = s;
            this.b = z2;
            this.c = z3;
            SparseArray obj1 = new SparseArray();
            this.d = obj1;
            obj1 = new SparseArray();
            this.e = obj1;
            int obj2 = 0;
            obj1 = new q.b.a(obj2);
            this.m = obj1;
            obj1 = new q.b.a(obj2);
            this.n = obj1;
            obj1 = new byte[128];
            this.g = obj1;
            final int obj3 = 0;
            obj2 = new e0(obj1, obj3, obj3);
            this.f = obj2;
            g();
        }

        private void d(int i) {
            final long l = this.q;
            if (Long.compare(l, l2) == 0) {
            }
            this.a.d(l, obj2, this.r, (int)i2, i);
        }

        public void a(byte[] bArr, int i2, int i3) {
            int obj;
            int i7;
            int i14;
            byte[] copyOf;
            boolean z;
            boolean z2;
            int i6;
            int i4;
            int i15;
            int i5;
            int i10;
            int i13;
            int i8;
            int i;
            int i16;
            int i11;
            int i9;
            int i12;
            final Object obj2 = this;
            int i17 = i2;
            if (!obj2.k) {
            }
            int i20 = i3 - i17;
            copyOf = obj2.g;
            i4 = obj2.h;
            final int i30 = 2;
            if (copyOf.length < i4 + i20) {
                obj2.g = Arrays.copyOf(copyOf, i29 *= i30);
            }
            System.arraycopy(bArr, i17, obj2.g, obj2.h, i20);
            i18 += i20;
            obj2.h = i19;
            int i24 = 0;
            obj2.f.i(obj2.g, i24, i19);
            if (!obj2.f.b(8)) {
            }
            obj2.f.k();
            i7 = 5;
            obj2.f.l(i7);
            if (!obj2.f.c()) {
            }
            obj2.f.h();
            if (!obj2.f.c()) {
            }
            final int i32 = obj2.f.h();
            if (!obj2.c) {
                obj2.k = i24;
                obj2.n.f(i32);
            }
            if (!obj2.f.c()) {
            }
            final int i34 = obj2.f.h();
            if (obj2.e.indexOfKey(i34) < 0) {
                obj2.k = i24;
            }
            obj = obj2.e.get(i34);
            final Object obj5 = obj3;
            if (obj5.h && !obj2.f.b(i30)) {
                if (!obj2.f.b(i30)) {
                }
                obj2.f.l(i30);
            }
            if (!obj2.f.b(obj5.j)) {
            }
            int i28 = 1;
            if (!obj5.i) {
                if (!obj2.f.b(i28)) {
                }
                z2 = obj2.f.d();
                if (z2) {
                    if (!obj2.f.b(i28)) {
                    }
                    i5 = z2;
                    i10 = i28;
                    i13 = i15;
                } else {
                    i5 = z2;
                    i10 = i24;
                    i13 = i10;
                }
            } else {
                i10 = i5;
            }
            i8 = obj2.i == i7 ? i28 : i24;
            if (i8 != 0) {
                if (!obj2.f.c()) {
                }
                i = i7;
            } else {
                i = i24;
            }
            i14 = obj5.k;
            if (i14 == 0) {
                if (!obj2.f.b(obj5.l)) {
                }
                i14 = obj2.f.e(obj5.l);
                if (obj.c && i5 == 0) {
                    if (i5 == 0) {
                        if (!obj2.f.c()) {
                        }
                        i11 = obj;
                        i16 = i14;
                        i9 = i24;
                    } else {
                        i16 = i14;
                        i11 = i24;
                        i9 = i11;
                    }
                } else {
                }
                i12 = i9;
            } else {
                if (i14 == i28 && !obj5.m) {
                    if (!obj5.m) {
                        if (!obj2.f.c()) {
                        }
                        i14 = obj2.f.g();
                        if (obj.c && i5 == 0) {
                            if (i5 == 0) {
                                if (!obj2.f.c()) {
                                }
                                i12 = obj;
                                i9 = i14;
                                i11 = i16;
                            } else {
                                i9 = i14;
                                i12 = i11;
                            }
                        } else {
                        }
                    } else {
                        i11 = i16;
                    }
                } else {
                }
            }
            obj2.n.e((a0.b)obj5, obj2.f.e(i30), i32, obj2.f.e(obj5.j), i34, i5, i10, i13, i8, i, i16, i11, i9, i12);
            obj2.k = i24;
        }

        public boolean b(long l, int i2, boolean z3, boolean z4) {
            int i;
            int i3;
            int i4;
            long obj6;
            int obj8;
            boolean obj9;
            boolean obj10;
            final int i5 = 1;
            if (this.i != 9) {
                if (this.c && q.b.a.a(this.n, this.m) && z4 && this.o) {
                    if (q.b.a.a(this.n, this.m)) {
                        if (z4) {
                            if (this.o) {
                                d(z3 += obj6);
                            }
                        }
                        this.p = this.j;
                        this.q = this.l;
                        this.r = false;
                        this.o = i5;
                    }
                }
            } else {
            }
            if (this.b) {
                obj10 = this.n.d();
            }
            final int obj7 = this.i;
            if (obj7 != 5) {
                if (obj10 != null && obj7 == i5) {
                    if (obj7 == i5) {
                        i3 = i5;
                    }
                }
            } else {
            }
            obj6 |= i3;
            this.r = obj6;
            return obj6;
        }

        public boolean c() {
            return this.c;
        }

        public void e(a0.a a0$a) {
            this.e.append(a.a, a);
        }

        public void f(a0.b a0$b) {
            this.d.append(b.d, b);
        }

        public void g() {
            int i = 0;
            this.k = i;
            this.o = i;
            this.n.b();
        }

        public void h(long l, int i2, long l3) {
            int obj1;
            com.google.android.exoplayer2.l2.v.q.b.a obj3;
            this.i = l3;
            this.l = obj4;
            this.j = l;
            final int obj2 = 1;
            if (this.b) {
                if (l3 != obj2) {
                    if (this.c) {
                        if (l3 != 5 && l3 != obj2) {
                            if (l3 != obj2) {
                                if (l3 == 2) {
                                    obj1 = this.m;
                                    this.m = this.n;
                                    this.n = obj1;
                                    obj1.b();
                                    this.h = 0;
                                    this.k = obj2;
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
        }
    }
    public q(com.google.android.exoplayer2.l2.v.a0 a0, boolean z2, boolean z3) {
        super();
        this.a = a0;
        this.b = z2;
        this.c = z3;
        this.h = new boolean[3];
        final int obj3 = 128;
        v obj1 = new v(7, obj3);
        this.d = obj1;
        obj1 = new v(8, obj3);
        this.e = obj1;
        obj1 = new v(6, obj3);
        this.f = obj1;
        obj1 = -9223372036854775807L;
        obj1 = new d0();
        this.o = obj1;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void a() {
        g.h(this.j);
        p0.i(this.k);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long l, int i2, int i3, long l4) {
        boolean z;
        Object vVar;
        int i;
        a0.b bVar;
        float f;
        s sVar;
        i1.b bVar2;
        String str;
        boolean obj8;
        boolean obj11;
        if (this.l) {
            if (this.k.c()) {
                this.d.b(l4);
                this.e.b(l4);
                i = 3;
                if (!this.l) {
                    if (this.d.c() && this.e.c()) {
                        if (this.e.c()) {
                            ArrayList arrayList = new ArrayList();
                            com.google.android.exoplayer2.l2.v.v vVar12 = this.d;
                            arrayList.add(Arrays.copyOf(vVar12.d, vVar12.e));
                            com.google.android.exoplayer2.l2.v.v vVar13 = this.e;
                            arrayList.add(Arrays.copyOf(vVar13.d, vVar13.e));
                            com.google.android.exoplayer2.l2.v.v vVar14 = this.d;
                            bVar = a0.i(vVar14.d, i, vVar14.e);
                            com.google.android.exoplayer2.l2.v.v vVar15 = this.e;
                            bVar2 = new i1.b();
                            bVar2.S(this.i);
                            bVar2.e0("video/avc");
                            bVar2.I(j.a(bVar.a, bVar.b, bVar.c));
                            bVar2.j0(bVar.e);
                            bVar2.Q(bVar.f);
                            bVar2.a0(bVar.g);
                            bVar2.T(arrayList);
                            this.j.e(bVar2.E());
                            this.l = true;
                            this.k.f(bVar);
                            this.k.e(a0.h(vVar15.d, i, vVar15.e));
                            this.d.d();
                            this.e.d();
                        }
                    }
                } else {
                    if (this.d.c()) {
                        com.google.android.exoplayer2.l2.v.v vVar8 = this.d;
                        this.k.f(a0.i(vVar8.d, i, vVar8.e));
                        this.d.d();
                    } else {
                        if (this.e.c()) {
                            com.google.android.exoplayer2.l2.v.v vVar10 = this.e;
                            this.k.e(a0.h(vVar10.d, i, vVar10.e));
                            this.e.d();
                        }
                    }
                }
            }
        } else {
        }
        if (this.f.b(l4)) {
            obj11 = this.f;
            this.o.G(vVar11.d, a0.k(obj11.d, obj11.e));
            this.o.I(4);
            this.a.a(obj12, obj13);
        }
        if (this.k.b(l, f, i3, this.l)) {
            this.n = false;
        }
    }

    @RequiresNonNull("sampleReader")
    private void h(byte[] bArr, int i2, int i3) {
        boolean z;
        if (this.l) {
            if (this.k.c()) {
                this.d.a(bArr, i2, i3);
                this.e.a(bArr, i2, i3);
            }
        } else {
        }
        this.f.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    @RequiresNonNull("sampleReader")
    private void i(long l, int i2, long l3) {
        boolean z;
        if (this.l) {
            if (this.k.c()) {
                this.d.e(l3);
                this.e.e(l3);
            }
        } else {
        }
        this.f.e(l3);
        this.k.h(l, obj3, l3);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        int i2;
        int i5;
        s sVar;
        int i3;
        int i6;
        long l2;
        int i4;
        int i;
        int i7;
        long l;
        d0 obj15;
        a();
        i2 = d0.e();
        final int i8 = d0.f();
        final byte[] bArr = d0.d();
        long l5 = (long)i11;
        this.g = l3 += l5;
        this.j.c(d0, d0.a());
        obj15 = a0.c(bArr, i2, i8, this.h);
        while (obj15 == i8) {
            int i10 = obj15 - i2;
            if (i10 > 0) {
            }
            i = i8 - obj15;
            l4 -= l6;
            if (i10 < 0) {
            } else {
            }
            i5 = 0;
            i4 = i3;
            this.g(i4, obj9, i, i5);
            this.i(i3, l5, a0.f(bArr, obj15));
            i2 = obj15 + 3;
            obj15 = a0.c(bArr, i2, i8, this.h);
            i5 = -i10;
            h(bArr, i2, obj15);
        }
        h(bArr, i2, i8);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        this.g = 0;
        this.n = false;
        this.m = -9223372036854775807L;
        a0.a(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        com.google.android.exoplayer2.l2.v.q.b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.i = d2.b();
        s sVar = k.t(d2.c(), 2);
        this.j = sVar;
        q.b bVar = new q.b(sVar, this.b, this.c);
        this.k = bVar;
        this.a.b(k, d2);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        int obj4;
        if (Long.compare(l, l2) != 0) {
            this.m = l;
        }
        obj4 = obj5 & 2 != 0 ? 1 : 0;
        this.n = obj3 |= obj4;
    }
}
