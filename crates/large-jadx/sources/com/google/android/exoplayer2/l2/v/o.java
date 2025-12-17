package com.google.android.exoplayer2.l2.v;

import android.util.Pair;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class o implements com.google.android.exoplayer2.l2.v.n {

    private static final double[] q;
    private String a;
    private s b;
    private final com.google.android.exoplayer2.l2.v.g0 c;
    private final d0 d = null;
    private final com.google.android.exoplayer2.l2.v.v e = null;
    private final boolean[] f;
    private final com.google.android.exoplayer2.l2.v.o.a g;
    private long h;
    private boolean i;
    private boolean j;
    private long k;
    private long l = -9223372036854775807L;
    private long m;
    private long n = -9223372036854775807L;
    private boolean o;
    private boolean p;

    private static final class a {

        private static final byte[] e;
        private boolean a;
        public int b;
        public int c;
        public byte[] d;
        static {
            byte[] bArr = new byte[3];
            bArr = new byte[]{0, 0, 1};
            o.a.e = bArr;
        }

        public a(int i) {
            super();
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i2, int i3) {
            byte[] copyOf;
            int i;
            if (!this.a) {
            }
            i3 -= i2;
            copyOf = this.d;
            i = this.b;
            if (copyOf.length < i + obj7) {
                this.d = Arrays.copyOf(copyOf, i5 *= 2);
            }
            System.arraycopy(bArr, i2, this.d, this.b, obj7);
            this.b = obj5 += obj7;
        }

        public boolean b(int i, int i2) {
            boolean z;
            int obj5;
            final int i4 = 1;
            final int i5 = 0;
            i3 -= i2;
            this.b = z;
            if (this.a && this.c == 0 && i == 181) {
                i3 -= i2;
                this.b = z;
                if (this.c == 0) {
                    if (i == 181) {
                        this.c = z;
                        final byte[] obj4 = o.a.e;
                        a(obj4, i5, obj4.length);
                        return i5;
                    }
                }
                this.a = i5;
                return i4;
            }
            if (i == 179) {
                this.a = i4;
            }
        }

        public void c() {
            final int i = 0;
            this.a = i;
            this.b = i;
            this.c = i;
        }
    }
    static {
        double[] dArr = new double[8];
        dArr = new long[]{4627441868472394375L, 4627448617123184640L, 4627730092099895296L, 4629129031169960744L, 4629137466983448576L, 4632233691727265792L, 4633632630797331240L, 4633641066610819072L};
        o.q = dArr;
    }

    o(com.google.android.exoplayer2.l2.v.g0 g0) {
        int aVar;
        d0 obj3;
        super();
        this.c = g0;
        this.f = new boolean[4];
        final int i2 = 128;
        aVar = new o.a(i2);
        this.g = aVar;
        if (g0 != null) {
            obj3 = new v(178, i2);
            this.e = obj3;
            obj3 = new d0();
            this.d = obj3;
        } else {
            obj3 = 0;
        }
        long l = -9223372036854775807L;
    }

    private static Pair<i1, Long> a(com.google.android.exoplayer2.l2.v.o.a o$a, String string2) {
        float f;
        int i7;
        double d;
        int i5;
        int i3;
        int i6;
        int i9;
        double[] i2;
        int i8;
        float i4;
        i1.b bVar;
        int i;
        int obj8;
        byte[] copyOf = Arrays.copyOf(a.d, a.b);
        int i11 = 4;
        b2 &= 255;
        i16 |= i26;
        i21 |= i25;
        i2 = 7;
        i27 >>= i11;
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != i11) {
                    i7 = 1065353216;
                } else {
                    f = (float)i13;
                    i8 = i17 * 100;
                    f /= i4;
                }
            } else {
                f = (float)i14;
                i8 = i17 * 9;
            }
        } else {
            f = (float)i12;
            i8 = i17 * 3;
        }
        bVar = new i1.b();
        bVar.S(string2);
        bVar.e0("video/mpeg2");
        bVar.j0(i17);
        bVar.Q(i22);
        bVar.a0(i7);
        bVar.T(Collections.singletonList(copyOf));
        i5 = 0;
        i23--;
        i2 = o.q;
        obj8 += 9;
        i3 = i9 >> 5;
        obj8 &= 31;
        if (i9 >= 0 && i9 < i2.length && i3 != obj8) {
            i2 = o.q;
            if (i9 < i2.length) {
                obj8 += 9;
                i3 = i9 >> 5;
                obj8 &= 31;
                if (i3 != obj8) {
                    d *= i3;
                }
                i5 = (long)i6;
            }
        }
        return Pair.create(bVar.E(), Long.valueOf(i5));
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        int i7;
        int i6;
        int cmp;
        int i10;
        boolean z;
        s sVar;
        boolean z2;
        int cmp2;
        int i12;
        int i4;
        int i11;
        com.google.android.exoplayer2.l2.v.v vVar;
        boolean second;
        int i9;
        int i2;
        int i5;
        com.google.android.exoplayer2.l2.v.o.a longValue;
        Object first;
        boolean z3;
        int i8;
        int i13;
        int i;
        int i3;
        final Object obj = this;
        g.h(obj.b);
        i7 = d0.e();
        final int i17 = d0.f();
        final byte[] bArr2 = d0.d();
        obj.h = l += l5;
        obj.b.c(d0, d0.a());
        sVar = a0.c(bArr2, i7, i17, obj.f);
        while (sVar == i17) {
            i4 = sVar + 3;
            b &= 255;
            i11 = sVar - i7;
            i2 = 0;
            i5 = 1;
            if (!obj.j && i11 > 0) {
            }
            vVar = obj.e;
            if (vVar != null) {
            }
            if (i12 != 0) {
            } else {
            }
            int i14 = i17 - sVar;
            i11 = -9223372036854775807L;
            first = obj.n;
            if (obj.p && obj.j && Long.compare(first, i11) != 0) {
            } else {
            }
            i3 = i12;
            if (obj.i) {
            } else {
            }
            obj.m = l2 -= i5;
            if (Long.compare(sVar, i11) != 0) {
            } else {
            }
            long l3 = obj.n;
            if (Long.compare(l3, i11) != 0) {
            } else {
            }
            sVar = i11;
            obj.n = sVar;
            obj.o = i2;
            obj.l = i11;
            obj.i = true;
            if (i3 == 0) {
            }
            obj.p = i2;
            i7 = i4;
            sVar = a0.c(bArr2, i7, i17, obj.f);
            i2 = i6;
            l3 += i5;
            if (obj.p) {
            } else {
            }
            i6 = 1;
            if (obj.j) {
            } else {
            }
            first = obj.n;
            if (Long.compare(first, i11) != 0) {
            } else {
            }
            i3 = i12;
            obj.b.d(first, obj14, obj.o, cmp2 - i14, i14);
            if (i12 == 179) {
            } else {
            }
            if (i12 == 184) {
            }
            obj.o = i5;
            if (i11 > 0) {
            } else {
            }
            i10 = -i11;
            if (obj.e.b(i10)) {
            }
            if (i12 == 178 && d0.d()[sVar + 2] == i5) {
            }
            if (d0.d()[sVar + 2] == i5) {
            }
            obj.e.e(i12);
            com.google.android.exoplayer2.l2.v.v vVar2 = obj.e;
            d0 d0Var2 = obj.d;
            p0.i(d0Var2);
            vVar = vVar4.d;
            d0Var2.G(vVar, a0.k(vVar2.d, vVar2.e));
            z = obj.c;
            p0.i(z);
            z.a(obj.n, vVar);
            vVar.a(bArr2, i7, sVar);
            i10 = i2;
            if (i11 > 0) {
            }
            if (i11 < 0) {
            } else {
            }
            i9 = i2;
            if (obj.g.b(i12, i9)) {
            }
            String str = obj.a;
            g.e(str);
            Pair pair = o.a(obj.g, str);
            obj.b.e((i1)pair.first);
            obj.k = (Long)pair.second.longValue();
            obj.j = i5;
            i9 = -i11;
            obj.g.a(bArr2, i7, sVar);
        }
        if (!obj.j) {
            obj.g.a(bArr2, i7, i17);
        }
        com.google.android.exoplayer2.l2.v.v vVar3 = obj.e;
        if (vVar3 != null) {
            vVar3.a(bArr2, i7, i17);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        a0.a(this.f);
        this.g.c();
        com.google.android.exoplayer2.l2.v.v vVar = this.e;
        if (vVar != null) {
            vVar.d();
        }
        this.h = 0;
        this.i = false;
        long l = -9223372036854775807L;
        this.l = l;
        this.n = l;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.a = d2.b();
        this.b = k.t(d2.c(), 2);
        com.google.android.exoplayer2.l2.v.g0 g0Var = this.c;
        if (g0Var != null) {
            g0Var.b(k, d2);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        this.l = l;
    }
}
