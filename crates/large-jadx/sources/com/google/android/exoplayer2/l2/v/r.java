package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class r implements com.google.android.exoplayer2.l2.v.n {

    private final com.google.android.exoplayer2.l2.v.a0 a;
    private String b;
    private s c;
    private com.google.android.exoplayer2.l2.v.r.a d;
    private boolean e;
    private final boolean[] f;
    private final com.google.android.exoplayer2.l2.v.v g;
    private final com.google.android.exoplayer2.l2.v.v h;
    private final com.google.android.exoplayer2.l2.v.v i;
    private final com.google.android.exoplayer2.l2.v.v j;
    private final com.google.android.exoplayer2.l2.v.v k;
    private long l;
    private long m = -9223372036854775807L;
    private final d0 n;

    private static final class a {

        private final s a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;
        public a(s s) {
            super();
            this.a = s;
        }

        private static boolean b(int i) {
            int i2;
            int obj1;
            if (32 <= i) {
                if (i > 35) {
                    obj1 = i == 39 ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj1;
        }

        private static boolean c(int i) {
            int i2;
            int obj1;
            if (i >= 32) {
                if (i == 40) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }

        private void d(int i) {
            final long l = this.l;
            if (Long.compare(l, l2) == 0) {
            }
            this.a.d(l, obj2, this.m, (int)i2, i);
        }

        public void a(long l, int i2, boolean z3) {
            boolean z;
            int obj3;
            int obj5;
            boolean obj6;
            if (this.j && this.g) {
                if (this.g) {
                    this.m = this.c;
                    this.j = false;
                } else {
                    if (!this.h) {
                        if (this.g && obj6 != null && this.i) {
                            if (obj6 != null) {
                                if (this.i) {
                                    d(z3 += obj3);
                                }
                            }
                            this.k = this.b;
                            this.l = this.e;
                            this.m = this.c;
                            this.i = true;
                        }
                    } else {
                    }
                }
            } else {
            }
        }

        public void e(byte[] bArr, int i2, int i3) {
            boolean z;
            int i;
            int obj3;
            int obj4;
            int obj5;
            if (this.f) {
                i = this.d;
                i4 -= i;
                if (z < i3) {
                    obj4 = 0;
                    obj3 = obj3 &= 128 != 0 ? 1 : obj4;
                    this.g = obj3;
                    this.f = obj4;
                } else {
                    this.d = i += obj5;
                }
            }
        }

        public void f() {
            final int i = 0;
            this.f = i;
            this.g = i;
            this.h = i;
            this.i = i;
            this.j = i;
        }

        public void g(long l, int i2, int i3, long l4, boolean z5) {
            int i;
            boolean obj2;
            i = 0;
            this.g = i;
            this.h = i;
            this.e = z5;
            this.d = i;
            this.b = l;
            final int obj3 = 1;
            if (!r.a.c(l4) && this.i && !this.j && obj8 != null) {
                if (this.i) {
                    if (!this.j) {
                        if (obj8 != null) {
                            d(i3);
                        }
                        this.i = i;
                    }
                }
                if (r.a.b(l4)) {
                    this.h = obj2 ^= obj3;
                    this.j = obj3;
                }
            }
            if (l4 >= 16 && l4 <= 21) {
                obj2 = l4 <= 21 ? obj3 : i;
            } else {
            }
            this.c = obj2;
            if (obj2 == null) {
                if (l4 <= 9) {
                    i = obj3;
                }
            } else {
            }
            this.f = i;
        }
    }
    public r(com.google.android.exoplayer2.l2.v.a0 a0) {
        super();
        this.a = a0;
        this.f = new boolean[3];
        final int i6 = 128;
        v obj3 = new v(32, i6);
        this.g = obj3;
        obj3 = new v(33, i6);
        this.h = obj3;
        obj3 = new v(34, i6);
        this.i = obj3;
        obj3 = new v(39, i6);
        this.j = obj3;
        obj3 = new v(40, i6);
        this.k = obj3;
        long l = -9223372036854775807L;
        obj3 = new d0();
        this.n = obj3;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void a() {
        g.h(this.c);
        p0.i(this.d);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long l, int i2, int i3, long l4) {
        Object aVar;
        boolean z;
        boolean obj3;
        int obj4;
        boolean obj5;
        int obj6;
        this.d.a(l, i2, i3);
        this.g.b(l4);
        this.h.b(l4);
        this.i.b(l4);
        if (!this.e && this.g.c() && this.h.c() && this.i.c()) {
            this.g.b(l4);
            this.h.b(l4);
            this.i.b(l4);
            if (this.g.c()) {
                if (this.h.c()) {
                    if (this.i.c()) {
                        this.c.e(r.i(this.b, this.g, this.h, this.i));
                        this.e = true;
                    }
                }
            }
        }
        obj4 = 5;
        if (this.j.b(l4)) {
            obj3 = this.j;
            this.n.G(vVar.d, a0.k(obj3.d, obj3.e));
            this.n.J(obj4);
            this.a.a(obj7, obj8);
        }
        if (this.k.b(l4)) {
            obj3 = this.k;
            this.n.G(obj6.d, a0.k(obj3.d, obj3.e));
            this.n.J(obj4);
            this.a.a(obj7, obj8);
        }
    }

    @RequiresNonNull("sampleReader")
    private void h(byte[] bArr, int i2, int i3) {
        boolean z;
        this.d.e(bArr, i2, i3);
        if (!this.e) {
            this.g.a(bArr, i2, i3);
            this.h.a(bArr, i2, i3);
            this.i.a(bArr, i2, i3);
        }
        this.j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    private static i1 i(String string, com.google.android.exoplayer2.l2.v.v v2, com.google.android.exoplayer2.l2.v.v v3, com.google.android.exoplayer2.l2.v.v v4) {
        int i;
        boolean z;
        int z3;
        int i12;
        int string2;
        boolean z2;
        int i9;
        boolean str;
        int i8;
        int i10;
        int i2;
        boolean z5;
        int i11;
        boolean z4;
        int i3;
        int stringBuilder;
        int i4;
        int i13;
        int i7;
        int i5;
        int i6;
        Object obj = v2;
        Object obj2 = v3;
        Object obj3 = v4;
        int i20 = obj.e;
        byte[] bArr4 = new byte[i24 += i26];
        final int i31 = 0;
        System.arraycopy(obj.d, i31, bArr4, i31, i20);
        System.arraycopy(obj2.d, i31, bArr4, obj.e, obj2.e);
        System.arraycopy(obj3.d, i31, bArr4, i14 += i28, obj3.e);
        e0 e0Var = new e0(obj2.d, i31, obj2.e);
        e0Var.l(44);
        int i19 = 3;
        int i22 = e0Var.e(i19);
        e0Var.k();
        e0Var.l(88);
        string2 = 8;
        e0Var.l(string2);
        i8 = i9;
        while (i9 < i22) {
            if (e0Var.d()) {
            }
            if (e0Var.d()) {
            }
            i9++;
            i8 += 8;
            i8 += 89;
        }
        e0Var.l(i8);
        int i33 = 2;
        if (i22 > 0) {
            e0Var.l(i38 *= i33);
        }
        e0Var.h();
        i2 = e0Var.h();
        if (i2 == i19) {
            e0Var.k();
        }
        stringBuilder = 1;
        if (e0Var.d()) {
            if (i2 != stringBuilder) {
                if (i2 == i33) {
                    i5 = i33;
                } else {
                    i5 = stringBuilder;
                }
            } else {
            }
            i10 = i2 == stringBuilder ? i33 : stringBuilder;
            i -= i6;
            i11 -= i2;
        }
        e0Var.h();
        e0Var.h();
        i3 = e0Var.d() ? i31 : i22;
        while (i3 <= i22) {
            e0Var.h();
            e0Var.h();
            e0Var.h();
            i3++;
        }
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        if (e0Var.d() && e0Var.d()) {
            if (e0Var.d()) {
                r.j(e0Var);
            }
        }
        e0Var.l(i33);
        if (e0Var.d()) {
            e0Var.l(string2);
            e0Var.h();
            e0Var.h();
            e0Var.k();
        }
        r.k(e0Var);
        if (e0Var.d()) {
            z3 = i31;
            while (z3 < e0Var.h()) {
                e0Var.l(i41 += stringBuilder);
                z3++;
            }
        }
        e0Var.l(i33);
        i12 = 1065353216;
        int i37 = 24;
        if (e0Var.d() && e0Var.d()) {
            if (e0Var.d()) {
                string2 = e0Var.e(string2);
                if (string2 == 255) {
                    int i30 = 16;
                    str = e0Var.e(i30);
                    string2 = e0Var.e(i30);
                    if (str != null && string2 != null) {
                        if (string2 != null) {
                            f /= string2;
                        }
                    }
                } else {
                    str = a0.b;
                    if (string2 < str.length) {
                        i12 = str[string2];
                    } else {
                        stringBuilder = new StringBuilder(46);
                        stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                        stringBuilder.append(string2);
                        v.h("H265Reader", stringBuilder.toString());
                    }
                }
            }
            if (e0Var.d()) {
                e0Var.k();
            }
            e0Var.l(4);
            if (e0Var.d() && e0Var.d()) {
                e0Var.l(i40);
                if (e0Var.d()) {
                    e0Var.l(i37);
                }
            }
            if (e0Var.d()) {
                e0Var.h();
                e0Var.h();
            }
            e0Var.k();
            if (e0Var.d()) {
                i11 *= 2;
            }
        }
        e0Var.i(obj2.d, i31, obj2.e);
        e0Var.l(i37);
        i1.b bVar = new i1.b();
        bVar.S(string);
        bVar.e0("video/hevc");
        bVar.I(j.c(e0Var));
        bVar.j0(i);
        bVar.Q(i11);
        bVar.a0(i12);
        bVar.T(Collections.singletonList(bArr4));
        return bVar.E();
    }

    private static void j(e0 e0) {
        int i;
        int i6;
        int i5;
        int i2;
        int z;
        int i3;
        int i4;
        final int i7 = 0;
        i = i7;
        i6 = 4;
        while (i < i6) {
            i5 = i7;
            while (i5 < 6) {
                i3 = 1;
                if (!e0.d()) {
                } else {
                }
                if (i > i3) {
                }
                i4 = i7;
                while (i4 < Math.min(64, i3 << i10)) {
                    e0.g();
                    i4++;
                }
                i2 = 3;
                if (i == i2) {
                }
                i5 += i3;
                i3 = i2;
                e0.g();
                i4++;
                e0.g();
                e0.h();
            }
            i++;
            i6 = 4;
            i3 = 1;
            if (!e0.d()) {
            } else {
            }
            if (i > i3) {
            }
            i4 = i7;
            while (i4 < Math.min(64, i3 << i10)) {
                e0.g();
                i4++;
            }
            i2 = 3;
            if (i == i2) {
            }
            i5 += i3;
            i3 = i2;
            e0.g();
            i4++;
            e0.g();
            e0.h();
        }
    }

    private static void k(e0 e0) {
        int i;
        int i7;
        int i3;
        int i5;
        int i6;
        int i2;
        int i4;
        final int i9 = 0;
        i3 = i7;
        while (i < e0.h()) {
            if (i != 0) {
            }
            if (i7 != 0) {
            } else {
            }
            int i10 = e0.h();
            i6 = e0.h();
            i4 = i9;
            while (i4 < i10) {
                e0.h();
                e0.k();
                i4++;
            }
            i5 = i9;
            while (i5 < i6) {
                e0.h();
                e0.k();
                i5++;
            }
            i3 = i2;
            i++;
            e0.h();
            e0.k();
            i5++;
            e0.h();
            e0.k();
            i4++;
            e0.k();
            e0.h();
            i6 = i9;
            while (i6 <= i3) {
                if (e0.d()) {
                }
                i6++;
                e0.k();
            }
            if (e0.d()) {
            }
            i6++;
            e0.k();
            i7 = e0.d();
        }
    }

    @RequiresNonNull("sampleReader")
    private void l(long l, int i2, int i3, long l4) {
        boolean obj9;
        this.d.g(l, obj2, i3, l4, obj13);
        if (!this.e) {
            this.g.e(l4);
            this.h.e(l4);
            this.i.e(l4);
        }
        this.j.e(l4);
        this.k.e(l4);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        int i8;
        int i7;
        s sVar;
        int i9;
        long l;
        int i4;
        long l2;
        int i;
        byte[] bArr;
        d0 d0Var;
        int i6;
        int i3;
        int i2;
        int i5;
        final Object obj2 = this;
        a();
        while (d0.a() > 0) {
            i8 = d0.e();
            i = d0.f();
            bArr = d0.d();
            obj2.l = l3 += l;
            obj2.c.c(d0, d0.a());
            while (i8 < i) {
                i6 = a0.c(bArr, i8, i, obj2.f);
                int i12 = i6 - i8;
                if (i12 > 0) {
                }
                i2 = i - i6;
                i9 = obj2.l;
                if (i12 < 0) {
                } else {
                }
                i7 = 0;
                Object obj = this;
                sVar = i5;
                l = i2;
                obj.g(sVar, i9, l, i7);
                obj.l(sVar, i9, l, a0.e(bArr, i6));
                i8 = i6 + 3;
                i7 = -i12;
                obj2.h(bArr, i8, i6);
            }
            i6 = a0.c(bArr, i8, i, obj2.f);
            i12 = i6 - i8;
            if (i12 > 0) {
            }
            i2 = i - i6;
            i9 = obj2.l;
            if (i12 < 0) {
            } else {
            }
            i7 = 0;
            obj = this;
            sVar = i5;
            l = i2;
            obj.g(sVar, i9, l, i7);
            obj.l(sVar, i9, l, a0.e(bArr, i6));
            i8 = i6 + 3;
            i7 = -i12;
            obj2.h(bArr, i8, i6);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        this.l = 0;
        this.m = -9223372036854775807L;
        a0.a(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        com.google.android.exoplayer2.l2.v.r.a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.b = d2.b();
        s sVar = k.t(d2.c(), 2);
        this.c = sVar;
        r.a aVar = new r.a(sVar);
        this.d = aVar;
        this.a.b(k, d2);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.m = l;
        }
    }
}
