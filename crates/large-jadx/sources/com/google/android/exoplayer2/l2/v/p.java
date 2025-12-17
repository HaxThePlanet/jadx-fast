package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class p implements com.google.android.exoplayer2.l2.v.n {

    private static final float[] l;
    private final com.google.android.exoplayer2.l2.v.g0 a;
    private final d0 b = null;
    private final boolean[] c;
    private final com.google.android.exoplayer2.l2.v.p.a d;
    private final com.google.android.exoplayer2.l2.v.v e = null;
    private com.google.android.exoplayer2.l2.v.p.b f;
    private long g;
    private String h;
    private s i;
    private boolean j;
    private long k = -9223372036854775807L;

    private static final class a {

        private static final byte[] f;
        private boolean a;
        private int b;
        public int c;
        public int d;
        public byte[] e;
        static {
            byte[] bArr = new byte[3];
            bArr = new byte[]{0, 0, 1};
            p.a.f = bArr;
        }

        public a(int i) {
            super();
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i2, int i3) {
            byte[] copyOf;
            int i;
            if (!this.a) {
            }
            i3 -= i2;
            copyOf = this.e;
            i = this.c;
            if (copyOf.length < i + obj7) {
                this.e = Arrays.copyOf(copyOf, i5 *= 2);
            }
            System.arraycopy(bArr, i2, this.e, this.c, obj7);
            this.c = obj5 += obj7;
        }

        public boolean b(int i, int i2) {
            int i6;
            int i5;
            int i4;
            String str;
            String str2;
            int i3;
            int obj9;
            int obj10;
            i6 = this.b;
            final int i7 = 0;
            final int i8 = 1;
            if (i6 != 0) {
                i5 = 181;
                i4 = 2;
                str = "Unexpected start code value";
                str2 = "H263Reader";
                if (i6 != i8) {
                    i3 = 3;
                    if (i6 != i4) {
                        i4 = 4;
                        if (i6 != i3) {
                            if (i6 != i4) {
                            } else {
                                if (i != 179 && i == i5) {
                                    if (i == i5) {
                                    }
                                }
                                this.c = obj9 -= i2;
                                this.a = i7;
                                return i8;
                            }
                            obj9 = new IllegalStateException();
                            throw obj9;
                        }
                        if (i &= 240 != 32) {
                            v.h(str2, str);
                            c();
                        } else {
                            this.d = this.c;
                            this.b = i4;
                        }
                    } else {
                        if (i > 31) {
                            v.h(str2, str);
                            c();
                        } else {
                            this.b = i3;
                        }
                    }
                } else {
                    if (i != i5) {
                        v.h(str2, str);
                        c();
                    } else {
                        this.b = i4;
                    }
                }
            } else {
                if (i == 176) {
                    this.b = i8;
                    this.a = i8;
                }
            }
            obj9 = p.a.f;
            a(obj9, i7, obj9.length);
            return i7;
        }

        public void c() {
            final int i = 0;
            this.a = i;
            this.c = i;
            this.b = i;
        }
    }

    private static final class b {

        private final s a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private long g;
        private long h;
        public b(s s) {
            super();
            this.a = s;
        }

        public void a(byte[] bArr, int i2, int i3) {
            boolean z;
            int i;
            int obj3;
            int obj4;
            int obj5;
            if (this.c) {
                i = this.f;
                i4 -= i;
                if (z < i3) {
                    obj4 = 0;
                    obj3 = obj3 >>= 6 == 0 ? 1 : obj4;
                    this.d = obj3;
                    this.c = obj4;
                } else {
                    this.f = i += obj5;
                }
            }
        }

        public void b(long l, int i2, boolean z3) {
            int i3;
            int i;
            long l2;
            int i4;
            com.google.android.exoplayer2.l2.s.a aVar;
            int i5;
            boolean obj11;
            i = this.h;
            if (this.e == 182 && obj11 != null && this.b && Long.compare(i, l2) != 0) {
                if (obj11 != null) {
                    if (this.b) {
                        i = this.h;
                        if (Long.compare(i, l2) != 0) {
                            this.a.d(i, obj2, this.d, (int)i6, z3);
                        }
                    }
                }
            }
            if (this.e != 179) {
                this.g = l;
            }
        }

        public void c(int i, long l2) {
            int i3;
            int i2;
            int i4;
            this.e = i;
            final int i5 = 0;
            this.d = i5;
            final int i6 = 182;
            if (i != i6) {
                if (i == 179) {
                    i2 = i3;
                } else {
                    i2 = i5;
                }
            } else {
            }
            this.b = i2;
            if (i == i6) {
            } else {
                i3 = i5;
            }
            this.c = i3;
            this.f = i5;
            this.h = l2;
        }

        public void d() {
            int i = 0;
            this.b = i;
            this.c = i;
            this.d = i;
            this.e = -1;
        }
    }
    static {
        float[] fArr = new float[7];
        fArr = new int[]{1065353216, 1065353216, 1066115817, 1063828015, 1069166220, 1067132618, 1065353216};
        p.l = fArr;
    }

    p(com.google.android.exoplayer2.l2.v.g0 g0) {
        int aVar;
        d0 obj5;
        super();
        this.a = g0;
        this.c = new boolean[4];
        final int i2 = 128;
        aVar = new p.a(i2);
        this.d = aVar;
        final long l = -9223372036854775807L;
        if (g0 != null) {
            obj5 = new v(178, i2);
            this.e = obj5;
            obj5 = new d0();
            this.b = obj5;
        } else {
            obj5 = 0;
        }
    }

    private static i1 a(com.google.android.exoplayer2.l2.v.p.a p$a, int i2, String string3) {
        int i3;
        int z;
        int i;
        int length;
        int obj9;
        byte[] obj8 = Arrays.copyOf(a.e, a.c);
        c0 c0Var = new c0(obj8);
        c0Var.r(i2);
        obj9 = 4;
        c0Var.r(obj9);
        c0Var.p();
        int i4 = 8;
        c0Var.q(i4);
        final int i7 = 3;
        if (c0Var.g()) {
            c0Var.q(obj9);
            c0Var.q(i7);
        }
        obj9 = c0Var.h(obj9);
        i = 1065353216;
        final String str = "Invalid aspect ratio";
        final String str2 = "H263Reader";
        final int i8 = 15;
        if (obj9 == i8) {
            i3 = c0Var.h(i4);
            if (i3 == 0) {
                v.h(str2, str);
            } else {
                i = obj9;
            }
        } else {
            i3 = p.l;
            if (obj9 < i3.length) {
                i = i3[obj9];
            } else {
                v.h(str2, str);
            }
        }
        int i5 = 2;
        c0Var.q(i5);
        c0Var.q(1);
        if (c0Var.g() && c0Var.g()) {
            c0Var.q(i5);
            c0Var.q(1);
            if (c0Var.g()) {
                c0Var.q(i8);
                c0Var.p();
                c0Var.q(i8);
                c0Var.p();
                c0Var.q(i8);
                c0Var.p();
                c0Var.q(i7);
                c0Var.q(11);
                c0Var.p();
                c0Var.q(i8);
                c0Var.p();
            }
        }
        if (c0Var.h(i5) != 0) {
            v.h(str2, "Unhandled video object layer shape");
        }
        c0Var.p();
        obj9 = c0Var.h(16);
        c0Var.p();
        if (c0Var.g()) {
            if (obj9 == null) {
                v.h(str2, "Invalid vop_increment_time_resolution");
            } else {
                obj9--;
                z = 0;
                while (obj9 > 0) {
                    z++;
                    obj9 >>= 1;
                }
                c0Var.q(z);
            }
        }
        c0Var.p();
        obj9 = 13;
        c0Var.p();
        c0Var.p();
        c0Var.p();
        i1.b bVar = new i1.b();
        bVar.S(string3);
        bVar.e0("video/mp4v-es");
        bVar.j0(c0Var.h(obj9));
        bVar.Q(c0Var.h(obj9));
        bVar.a0(i);
        bVar.T(Collections.singletonList(obj8));
        return bVar.E();
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        int i5;
        boolean z3;
        s sVar;
        int i3;
        long l2;
        long l;
        int i;
        com.google.android.exoplayer2.l2.v.v vVar;
        boolean z2;
        int i6;
        boolean z;
        int i4;
        com.google.android.exoplayer2.l2.v.p.a aVar;
        int i2;
        String str;
        boolean obj14;
        g.h(this.f);
        g.h(this.i);
        i5 = d0.e();
        final int i10 = d0.f();
        final byte[] bArr2 = d0.d();
        this.g = l3 += l2;
        this.i.c(d0, d0.a());
        int i12 = a0.c(bArr2, i5, i10, this.c);
        while (i12 == i10) {
            l2 = i12 + 3;
            b &= 255;
            i = i12 - i5;
            int i15 = 1;
            if (!this.j && i > 0) {
            }
            this.f.a(bArr2, i5, i12);
            vVar = this.e;
            if (vVar != null) {
            }
            int i7 = i10 - i12;
            this.f.b(l4 -= l5, vVar, i7);
            this.f.c(i3, this.k);
            i5 = l2;
            i12 = a0.c(bArr2, i5, i10, this.c);
            if (i > 0) {
            } else {
            }
            i4 = -i;
            if (this.e.b(i4)) {
            }
            if (i3 == 178 && d0.d()[i12 + 2] == i15) {
            }
            if (d0.d()[i12 + 2] == i15) {
            }
            this.e.e(i3);
            com.google.android.exoplayer2.l2.v.v vVar3 = this.e;
            d0 d0Var = this.b;
            p0.i(d0Var);
            vVar = vVar4.d;
            (d0)d0Var.G(vVar, a0.k(vVar3.d, vVar3.e));
            z3 = this.a;
            p0.i(z3);
            (g0)z3.a(this.k, vVar);
            vVar.a(bArr2, i5, i12);
            if (i > 0) {
            }
            if (i < 0) {
            } else {
            }
            i6 = i4;
            if (this.d.b(i3, i6)) {
            }
            com.google.android.exoplayer2.l2.v.p.a aVar2 = this.d;
            str = this.h;
            g.e(str);
            this.i.e(p.a(aVar2, aVar2.d, (String)str));
            this.j = i15;
            i6 = -i;
            this.d.a(bArr2, i5, i12);
        }
        if (!this.j) {
            this.d.a(bArr2, i5, i10);
        }
        this.f.a(bArr2, i5, i10);
        obj14 = this.e;
        if (obj14 != null) {
            obj14.a(bArr2, i5, i10);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        a0.a(this.c);
        this.d.c();
        com.google.android.exoplayer2.l2.v.p.b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
        com.google.android.exoplayer2.l2.v.v vVar = this.e;
        if (vVar != null) {
            vVar.d();
        }
        this.g = 0;
        this.k = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.h = d2.b();
        s sVar = k.t(d2.c(), 2);
        this.i = sVar;
        p.b bVar = new p.b(sVar);
        this.f = bVar;
        com.google.android.exoplayer2.l2.v.g0 g0Var = this.a;
        if (g0Var != null) {
            g0Var.b(k, d2);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.k = l;
        }
    }
}
