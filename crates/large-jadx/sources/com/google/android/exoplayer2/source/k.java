package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.d2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;

/* loaded from: classes2.dex */
public final class k implements com.google.android.exoplayer2.source.w, com.google.android.exoplayer2.source.w.a {

    public final com.google.android.exoplayer2.source.w a;
    private com.google.android.exoplayer2.source.w.a b;
    private com.google.android.exoplayer2.source.k.a[] c;
    private long v = -9223372036854775807L;
    long w;
    long x;

    private final class a implements com.google.android.exoplayer2.source.f0 {

        public final com.google.android.exoplayer2.source.f0 a;
        private boolean b;
        final com.google.android.exoplayer2.source.k c;
        public a(com.google.android.exoplayer2.source.k k, com.google.android.exoplayer2.source.f0 f02) {
            this.c = k;
            super();
            this.a = f02;
        }

        @Override // com.google.android.exoplayer2.source.f0
        public boolean a() {
            boolean z;
            int i;
            if (!this.c.h() && this.a.a()) {
                i = this.a.a() ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // com.google.android.exoplayer2.source.f0
        public int b(j1 j1, DecoderInputBuffer decoderInputBuffer2, int i3) {
            int cmp3;
            int cmp;
            int cmp2;
            int i;
            int i2;
            long l;
            boolean obj11;
            i1 obj12;
            int obj13;
            cmp = -3;
            if (this.c.h()) {
                return cmp;
            }
            cmp2 = 4;
            i = -4;
            if (this.b) {
                decoderInputBuffer2.r(cmp2);
                return i;
            }
            obj13 = this.a.b(j1, decoderInputBuffer2, i3);
            int i4 = -5;
            final long l4 = Long.MIN_VALUE;
            if (obj13 == i4) {
                obj12 = j1.b;
                g.e(obj12);
                if (obj12.T == 0) {
                    com.google.android.exoplayer2.source.k kVar2 = this.c;
                    if (obj12.U != 0 && Long.compare(l3, i2) != 0) {
                        kVar2 = this.c;
                        if (Long.compare(l3, i2) != 0) {
                            obj13 = i;
                        }
                        if (Long.compare(l2, l4) != 0) {
                        } else {
                            i = obj12.U;
                        }
                        obj12 = (i1)obj12.a();
                        obj12.M(obj13);
                        obj12.N(i);
                        j1.b = obj12.E();
                    }
                } else {
                }
                return i4;
            }
            obj11 = this.c;
            long l5 = obj11.x;
            if (Long.compare(l5, l4) != 0) {
                if (obj13 == i) {
                    if (Long.compare(l, l5) < 0 && obj13 == cmp && Long.compare(cmp3, l4) == 0 && !decoderInputBuffer2.v) {
                        if (obj13 == cmp) {
                            if (Long.compare(cmp3, l4) == 0) {
                                if (!decoderInputBuffer2.v) {
                                }
                            }
                        }
                    }
                    decoderInputBuffer2.j();
                    decoderInputBuffer2.r(cmp2);
                    this.b = true;
                    return i;
                } else {
                }
            }
            return obj13;
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void c() {
            this.a.c();
        }

        @Override // com.google.android.exoplayer2.source.f0
        public int d(long l) {
            if (this.c.h()) {
                return -3;
            }
            return this.a.d(l);
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void e() {
            this.b = false;
        }
    }
    public k(com.google.android.exoplayer2.source.w w, boolean z2, long l3, long l4) {
        super();
        this.a = w;
        this.c = new k.a[0];
        long obj1 = z2 ? l3 : obj1;
        obj1 = -9223372036854775807L;
        this.w = l3;
        this.x = obj5;
    }

    private d2 g(long l, d2 d22) {
        int cmp;
        long l2;
        long l3;
        long obj9;
        long l5 = p0.q(obj11.a, obj1, 0);
        l2 = this.x;
        l3 = Long.compare(l2, l10) == 0 ? obj9 : l2;
        obj9 = p0.q(obj11.b, obj3, 0);
        if (Long.compare(l5, l8) == 0 && Long.compare(obj9, l9) == 0) {
            if (Long.compare(obj9, l9) == 0) {
                return obj11;
            }
        }
        d2 obj11 = new d2(l5, obj1, obj9, d22);
        return obj11;
    }

    private static boolean t(long l, g[] g2Arr2) {
        int i;
        Object obj;
        String str;
        int obj3;
        final int obj4 = 0;
        if (Long.compare(l, i) != 0) {
            i = obj4;
            while (i < obj5.length) {
                obj = obj5[i];
                i++;
                i1 i1Var = obj.n();
            }
        }
        return obj4;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long a() {
        long cmp2;
        int cmp;
        long l = this.a.a();
        final long l2 = Long.MIN_VALUE;
        cmp2 = this.x;
        if (Long.compare(l, l2) != 0 && Long.compare(cmp2, l2) != 0 && Long.compare(l, cmp2) >= 0) {
            cmp2 = this.x;
            if (Long.compare(cmp2, l2) != 0) {
                if (Long.compare(l, cmp2) >= 0) {
                }
            }
            return l;
        }
        return l2;
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean b(long l) {
        return this.a.b(l);
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean c() {
        return this.a.c();
    }

    @Override // com.google.android.exoplayer2.source.w
    public long e() {
        long cmp2;
        int cmp;
        long l = this.a.e();
        final long l2 = Long.MIN_VALUE;
        cmp2 = this.x;
        if (Long.compare(l, l2) != 0 && Long.compare(cmp2, l2) != 0 && Long.compare(l, cmp2) >= 0) {
            cmp2 = this.x;
            if (Long.compare(cmp2, l2) != 0) {
                if (Long.compare(l, cmp2) >= 0) {
                }
            }
            return l;
        }
        return l2;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void f(long l) {
        this.a.f(l);
    }

    @Override // com.google.android.exoplayer2.source.w
    boolean h() {
        int i;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void i(com.google.android.exoplayer2.source.g0 g0) {
        s((w)g0);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void k() {
        this.a.k();
    }

    @Override // com.google.android.exoplayer2.source.w
    public long l(long l) {
        int i;
        int cmp;
        com.google.android.exoplayer2.source.k.a aVar;
        int obj6;
        this.v = -9223372036854775807L;
        com.google.android.exoplayer2.source.k.a[] objArr = this.c;
        cmp = i;
        while (cmp < objArr.length) {
            aVar = objArr[cmp];
            if (aVar != null) {
            }
            cmp++;
            aVar.e();
        }
        long l3 = this.a.l(l);
        if (Long.compare(l3, l) != 0) {
            if (Long.compare(l3, obj6) >= 0) {
                obj6 = this.x;
                if (Long.compare(obj6, l4) != 0) {
                    if (Long.compare(l3, obj6) <= 0) {
                        i = 1;
                    }
                } else {
                }
            }
        } else {
        }
        g.f(i);
        return l3;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long m(long l, d2 d22) {
        long l2 = this.w;
        if (Long.compare(l, l2) == 0) {
            return l2;
        }
        return this.a.m(l, d22);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void n(com.google.android.exoplayer2.source.w w) {
        final com.google.android.exoplayer2.source.w.a obj1 = this.b;
        g.e(obj1);
        (w.a)obj1.n(this);
    }

    @Override // com.google.android.exoplayer2.source.w
    public long o() {
        int i2;
        int cmp;
        int i;
        long l;
        long l3 = -9223372036854775807L;
        l = this.v;
        this.v = l3;
        long l5 = o();
        if (h() && Long.compare(l5, l3) != 0) {
            l = this.v;
            this.v = l3;
            l5 = o();
            if (Long.compare(l5, l3) != 0) {
                l = l5;
            }
            return l;
        }
        long l4 = this.a.o();
        if (Long.compare(l4, l3) == 0) {
            return l3;
        }
        final int i3 = 0;
        i2 = Long.compare(l4, l2) >= 0 ? i : i3;
        g.f(i2);
        long l6 = this.x;
        if (Long.compare(l6, l7) != 0) {
            if (Long.compare(l4, l6) <= 0) {
            } else {
                i = i3;
            }
        }
        g.f(i);
        return l4;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void p(com.google.android.exoplayer2.source.w.a w$a, long l2) {
        this.b = a;
        this.a.p(this, l2);
    }

    @Override // com.google.android.exoplayer2.source.w
    public long q(g[] gArr, boolean[] z2Arr2, com.google.android.exoplayer2.source.f0[] f03Arr3, boolean[] z4Arr4, long l5) {
        int i;
        com.google.android.exoplayer2.source.k.a[] objArr;
        com.google.android.exoplayer2.source.k.a aVar;
        boolean z;
        long l;
        int cmp2;
        int i3;
        com.google.android.exoplayer2.source.k.a[] objArr2;
        com.google.android.exoplayer2.source.f0[] aVar2;
        boolean[] cmp;
        int i4;
        int i2;
        final Object obj = this;
        final int[] iArr = f03Arr3;
        obj.c = new k.a[iArr.length];
        final com.google.android.exoplayer2.source.f0[] arr2 = new f0[iArr.length];
        i4 = 0;
        i = i4;
        while (i < iArr.length) {
            objArr = obj.c;
            objArr[i] = (k.a)iArr[i];
            if (objArr[i] != null) {
            }
            arr2[i] = i2;
            i++;
            i2 = objArr.a;
        }
        aVar2 = arr2;
        long l2 = obj.a.q(gArr, z2Arr2, aVar2, z4Arr4, l5);
        z = obj.w;
        cmp = gArr;
        if (h() && Long.compare(l5, z) == 0 && k.t(z, aVar2)) {
            z = obj.w;
            if (Long.compare(l5, z) == 0) {
                cmp = gArr;
                l = k.t(z, aVar2) ? l2 : -9223372036854775807L;
            } else {
            }
        } else {
        }
        obj.v = l;
        if (Long.compare(l2, l5) != 0) {
            if (Long.compare(l2, l3) >= 0) {
                cmp2 = obj.x;
                if (Long.compare(cmp2, l4) != 0) {
                    if (Long.compare(l2, cmp2) <= 0) {
                        i3 = 1;
                    } else {
                        i3 = i4;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        g.f(i3);
        while (i4 < iArr.length) {
            if (arr2[i4] == null) {
            } else {
            }
            objArr2 = obj.c;
            if (objArr2[i4] != null) {
            } else {
            }
            aVar2 = new k.a(this, arr2[i4]);
            objArr2[i4] = aVar2;
            iArr[i4] = obj.c[i4];
            i4++;
            if (aVar3.a != arr2[i4]) {
            }
            obj.c[i4] = 0;
        }
        return l2;
    }

    @Override // com.google.android.exoplayer2.source.w
    public com.google.android.exoplayer2.source.l0 r() {
        return this.a.r();
    }

    @Override // com.google.android.exoplayer2.source.w
    public void s(com.google.android.exoplayer2.source.w w) {
        final com.google.android.exoplayer2.source.w.a obj1 = this.b;
        g.e(obj1);
        (w.a)obj1.i(this);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void u(long l, boolean z2) {
        this.a.u(l, z2);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void v(long l, long l2) {
        this.w = l;
        this.x = obj3;
    }
}
