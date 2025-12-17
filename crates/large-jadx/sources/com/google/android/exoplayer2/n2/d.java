package com.google.android.exoplayer2.n2;

import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.source.m0.e;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.collect.a0;
import com.google.common.collect.i0;
import com.google.common.collect.k0;
import com.google.common.collect.k0.c;
import com.google.common.collect.k0.d;
import com.google.common.collect.v;
import com.google.common.collect.v.a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class d extends com.google.android.exoplayer2.n2.e {

    private final g g;
    private final long h;
    private final long i;
    private final long j;
    private final float k;
    private final float l;
    private final v<com.google.android.exoplayer2.n2.d.a> m;
    private final i n;
    private float o = 1f;
    private int p;
    private int q = 0;
    private long r = -9223372036854775807L;
    private d s;

    public static final class a {

        public final long a;
        public final long b;
        public a(long l, long l2) {
            super();
            this.a = l;
            this.b = obj3;
        }

        public boolean equals(Object object) {
            int i;
            long l2;
            long l;
            Object obj8;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof d.a) {
                return i2;
            }
            if (Long.compare(l2, l) == 0 && Long.compare(l2, l) == 0) {
                if (Long.compare(l2, l) == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            return i2 += i4;
        }
    }

    public static class b implements com.google.android.exoplayer2.n2.g.b {

        private final int a;
        private final int b;
        private final int c;
        private final float d;
        private final float e;
        private final i f;
        public b() {
            super(10000, 25000, 25000, 1060320051, 1061158912, i.a);
        }

        public b(int i, int i2, int i3, float f4, float f5, i i6) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = f4;
            this.e = f5;
            this.f = i6;
        }

        @Override // com.google.android.exoplayer2.n2.g$b
        public final com.google.android.exoplayer2.n2.g[] a(com.google.android.exoplayer2.n2.g.a[] g$aArr, g g2, y.a y$a3, g2 g24) {
            int i;
            com.google.android.exoplayer2.n2.g.a aVar;
            com.google.android.exoplayer2.n2.d hVar;
            k0 k0Var;
            int[] iArr;
            int i2;
            g gVar;
            Object obj;
            com.google.android.exoplayer2.n2.g[] obj13 = new g[aArr.length];
            final int i3 = 0;
            i = i3;
            while (i < aArr.length) {
                aVar = aArr[i];
                if (aVar != null) {
                }
                i++;
                iArr = aVar.b;
                if (iArr.length == 0) {
                } else {
                }
                if (iArr.length == 1) {
                } else {
                }
                hVar = this.b(aVar.a, iArr, aVar.c, g2, (v)d.w(aArr).get(i));
                obj13[i] = hVar;
                hVar = new h(aVar.a, iArr[i3], aVar.c);
            }
            return obj13;
        }

        protected com.google.android.exoplayer2.n2.d b(k0 k0, int[] i2Arr2, int i3, g g4, v<com.google.android.exoplayer2.n2.d.a> v5) {
            final Object obj = this;
            super(k0, i2Arr2, i3, g4, (long)i, obj7, (long)i2, obj9, (long)i4, obj11, obj.d, obj.e, v5, obj.f);
            return dVar2;
        }
    }
    protected d(k0 k0, int[] i2Arr2, int i3, g g4, long l5, long l6, long l7, float f8, float f9, List<com.google.android.exoplayer2.n2.d.a> list10, i i11) {
        int obj1;
        int[] obj2;
        long obj9;
        super(k0, i2Arr2, i3);
        if (Long.compare(f9, l5) < 0) {
            v.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            obj9 = l5;
        }
        this.g = g4;
        obj1 = 1000;
        this.h = l5 *= obj1;
        this.i = l7 *= obj1;
        this.j = obj9 *= obj1;
        this.k = i11;
        this.l = obj12;
        this.m = v.u(obj13);
        this.n = obj14;
        obj1 = 1065353216;
        obj1 = 0;
        obj1 = -9223372036854775807L;
    }

    private static v<v<com.google.android.exoplayer2.n2.d.a>> A(com.google.android.exoplayer2.n2.g.a[] g$aArr) {
        int i5;
        int i3;
        int i4;
        v.a aVar2;
        int[] iArr;
        Object length;
        int i2;
        int i;
        com.google.android.exoplayer2.n2.d.a aVar;
        int intValue;
        long[] length2;
        int length3;
        long l;
        ArrayList arrayList = new ArrayList();
        i5 = 0;
        i3 = i5;
        i2 = 0;
        aVar = 1;
        while (i3 < aArr.length) {
            if (aArr[i3] != null && iArr2.length > aVar) {
            } else {
            }
            arrayList.add(0);
            i3++;
            i2 = 0;
            aVar = 1;
            if (iArr2.length > aVar) {
            } else {
            }
            aVar2 = v.s();
            aVar = new d.a(i2, obj5, i2, obj5);
            aVar2.d(aVar);
            arrayList.add(aVar2);
        }
        long[][] arr = d.F(aArr);
        iArr = new int[arr.length];
        long[] lArr = new long[arr.length];
        intValue = i5;
        for (Object length2 : obj2) {
            if (lArr2.length == 0) {
            } else {
            }
            l = length2[i5];
            lArr[intValue] = l;
            l = i2;
        }
        d.x(arrayList, lArr);
        v vVar = d.G(arr);
        i = i5;
        while (i < vVar.size()) {
            intValue = (Integer)vVar.get(i).intValue();
            i6 += aVar;
            iArr[intValue] = i7;
            lArr[intValue] = arr[intValue][i7];
            d.x(arrayList, lArr);
            i++;
        }
        i4 = i5;
        while (i4 < aArr.length) {
            if (arrayList.get(i4) != null) {
            }
            i4++;
            lArr[i4] = l2 *= i;
        }
        d.x(arrayList, lArr);
        v.a obj12 = v.s();
        while (i5 < arrayList.size()) {
            Object obj = arrayList.get(i5);
            if ((v.a)obj == null) {
            } else {
            }
            i4 = (v.a)obj.e();
            obj12.d(i4);
            i5++;
            i4 = v.z();
        }
        return obj12.e();
    }

    private long B(long l) {
        int i;
        int cmp;
        long obj7 = H(l);
        if (this.m.isEmpty()) {
            return obj7;
        }
        int i2 = 1;
        i = i2;
        while (i < size -= i2) {
            if (Long.compare(l5, obj7) < 0) {
            }
            i++;
        }
        Object obj = this.m.get(i + -1);
        Object obj2 = this.m.get(i);
        long l3 = obj.a;
        long l4 = obj.b;
        return l4 += obj7;
    }

    private long C(List<? extends d> list) {
        long l2;
        long l;
        Object obj8;
        l2 = -9223372036854775807L;
        if (list.isEmpty()) {
            return l2;
        }
        obj8 = a0.c(list);
        final long l3 = obj8.g;
        l = obj8.h;
        if (Long.compare(l3, l2) != 0 && Long.compare(l, l2) != 0) {
            l = obj8.h;
            if (Long.compare(l, l2) != 0) {
                l2 = l - l3;
            }
        }
        return l2;
    }

    private long E(e[] eArr, List<? extends d> list2) {
        int next;
        int i;
        Object obj;
        boolean next2;
        next = this.p;
        if (next < eArr.length && eArr[next].next()) {
            if (eArr[next].next()) {
                Object obj5 = eArr[this.p];
                return l2 -= obj5;
            }
        }
        i = 0;
        while (i < eArr.length) {
            obj = eArr[i];
            i++;
        }
        return C(list2);
    }

    private static long[][] F(com.google.android.exoplayer2.n2.g.a[] g$aArr) {
        int i;
        long[] lArr;
        int i2;
        int[] iArr;
        int length;
        long l;
        long[][] lArr2 = new long[aArr.length];
        final int i3 = 0;
        i = i3;
        while (i < aArr.length) {
            Object obj = aArr[i];
            if (obj == null) {
            } else {
            }
            lArr2[i] = new long[iArr2.length];
            i2 = i3;
            iArr = obj.b;
            for (int i4 : obj5) {
                lArr2[i][i2] = (long)iArr;
                iArr = obj.b;
            }
            Arrays.sort(lArr2[i]);
            i++;
            lArr2[i][i2] = (long)iArr;
            i2++;
            lArr2[i] = new long[i3];
        }
        return lArr2;
    }

    private static v<Integer> G(long[][] lArrArr) {
        int i;
        int length;
        int dArr;
        int i2;
        int i5;
        int length2;
        int i7;
        int i3;
        Double valueOf;
        int i6;
        double valueOf2;
        int i4;
        double d;
        Object[] objArr = lArrArr;
        com.google.common.collect.c0 c0Var = k0.a().a().c();
        final int i8 = 0;
        i = i8;
        for (Object obj5 : obj0) {
            if (obj.length <= 1) {
            } else {
            }
            int length4 = obj2.length;
            dArr = new double[length4];
            i5 = i8;
            for (long l : obj7) {
                if (Long.compare(i3, valueOf2) == 0) {
                } else {
                }
                i7 = Math.log((double)l);
                dArr[i5] = i7;
            }
            length4--;
            d2 -= d3;
            i3 = i8;
            while (i3 < length) {
                if (Double.compare(i2, i7) == 0) {
                } else {
                }
                i6 = i4 / i2;
                c0Var.put(Double.valueOf(i6), Integer.valueOf(i));
                i6 = 4607182418800017408L;
            }
            if (Double.compare(i2, i7) == 0) {
            } else {
            }
            i6 = i4 / i2;
            c0Var.put(Double.valueOf(i6), Integer.valueOf(i));
            i6 = 4607182418800017408L;
            if (Long.compare(i3, valueOf2) == 0) {
            } else {
            }
            long l = objArr[i][i5];
            i7 = Math.log((double)l);
            dArr[i5] = i7;
            i5++;
        }
        return v.u(c0Var.values());
    }

    private long H(long l) {
        long cmp;
        long l3 = (long)i;
        long l4 = this.g.a();
        cmp = -9223372036854775807L;
        if (Long.compare(l4, cmp) != 0 && Long.compare(l, cmp) == 0) {
            if (Long.compare(l, cmp) == 0) {
            }
            float obj8 = (float)l;
            return (long)i3;
        }
        return (long)obj8;
    }

    private long I(long l) {
        int cmp;
        int i;
        long obj3;
        float obj4;
        if (Long.compare(l, l2) != 0 && Long.compare(l, l3) <= 0) {
            i = Long.compare(l, l3) <= 0 ? 1 : 0;
        } else {
        }
        if (i != 0) {
            obj3 = (long)obj3;
        } else {
            obj3 = this.h;
        }
        return obj3;
    }

    static v w(com.google.android.exoplayer2.n2.g.a[] g$aArr) {
        return d.A(aArr);
    }

    private static void x(List<v.a<com.google.android.exoplayer2.n2.d.a>> list, long[] l2Arr2) {
        int i2;
        int i;
        int i3;
        long l;
        int aVar;
        long l2;
        i = 0;
        i3 = i2;
        for (long l : l2Arr2) {
            i += l;
        }
        while (i2 < list.size()) {
            i3 = list.get(i2);
            if ((v.a)i3 == 0) {
            } else {
            }
            aVar = new d.a(i, obj2, l2Arr2[i2], obj6);
            (v.a)i3.d(aVar);
            i2++;
        }
    }

    private int z(long l, long l2) {
        int i;
        int i2;
        boolean cmp;
        i2 = i;
        while (i < this.b) {
            i1 i1Var = h(i);
            i2 = i;
            i++;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.n2.e
    protected long D() {
        return this.j;
    }

    protected boolean J(long l, List<? extends d> list2) {
        long l2;
        int obj5;
        d obj6;
        l2 = this.r;
        if (Long.compare(l2, l3) != 0 && Long.compare(obj5, l2) < 0) {
            if (Long.compare(obj5, l2) < 0) {
                if (!obj7.isEmpty() && !(d)a0.c(obj7).equals(this.s)) {
                    if (!(d)a0.c(obj7).equals(this.s)) {
                        obj5 = 1;
                    } else {
                        obj5 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj5;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public int b() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public void g() {
        this.s = 0;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public void i() {
        this.r = -9223372036854775807L;
        this.s = 0;
    }

    public int k(long l, List<? extends d> list2) {
        List cmp;
        int i2;
        int i;
        long l3;
        long l4;
        long l2;
        long l5 = this.n.a();
        if (!J(l5, obj1)) {
            return obj13.size();
        }
        this.r = l5;
        if (obj13.isEmpty()) {
            i2 = 0;
        } else {
            i2 = a0.c(obj13);
        }
        this.s = i2;
        if (obj13.isEmpty()) {
            return 0;
        }
        int size = obj13.size();
        long l8 = D();
        if (Long.compare(l7, l8) < 0) {
            return size;
        }
        i1 i1Var = h(z(l5, obj1));
        while (i < size) {
            Object obj = obj13.get(i);
            l3 = obj.d;
            i++;
            cmp = l3.J;
            l4 = -1;
            l3 = l3.I;
        }
        return size;
    }

    public void l(long l, long l2, long l3, List<? extends d> list4, e[] e5Arr5) {
        long l4;
        int i3;
        int i2;
        int i;
        boolean obj6;
        long obj7;
        long obj10;
        Object obj12;
        int obj13;
        obj6 = this.n.a();
        l4 = E(obj13, obj12);
        if (this.q == 0) {
            this.q = 1;
            this.p = z(obj6, l2);
        }
        i2 = this.p;
        final int i4 = -1;
        if (obj12.isEmpty()) {
            i = i4;
        } else {
            i = u(obj.d);
        }
        if (i != i4) {
            obj13 = obj12.e;
            i2 = i;
        }
        if (!d(i2, obj6)) {
            obj6 = h(i2);
            obj7 = h(z(obj6, l2));
            if (obj7.z > obj6.z && Long.compare(l3, obj10) < 0) {
                if (Long.compare(l3, obj10) < 0) {
                    obj12 = i2;
                } else {
                    if (obj7.z < obj6.z && Long.compare(l3, obj6) >= 0) {
                        if (Long.compare(l3, obj6) >= 0) {
                        }
                    }
                }
            } else {
            }
        }
        if (obj12 == i2) {
        } else {
            obj13 = 3;
        }
        this.q = obj13;
        this.p = obj12;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public int o() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public void p(float f) {
        this.o = f;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public Object q() {
        return null;
    }

    @Override // com.google.android.exoplayer2.n2.e
    protected boolean y(i1 i1, int i2, long l3) {
        int obj1;
        obj1 = Long.compare(obj1, l3) <= 0 ? 1 : 0;
        return obj1;
    }
}
