package com.google.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class m implements com.google.protobuf.z1 {

    private final com.google.protobuf.CodedOutputStream a;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            m.a.a = iArr;
            iArr[y1.b.BOOL.ordinal()] = 1;
            m.a.a[y1.b.FIXED32.ordinal()] = 2;
            m.a.a[y1.b.INT32.ordinal()] = 3;
            m.a.a[y1.b.SFIXED32.ordinal()] = 4;
            m.a.a[y1.b.SINT32.ordinal()] = 5;
            m.a.a[y1.b.UINT32.ordinal()] = 6;
            m.a.a[y1.b.FIXED64.ordinal()] = 7;
            m.a.a[y1.b.INT64.ordinal()] = 8;
            m.a.a[y1.b.SFIXED64.ordinal()] = 9;
            m.a.a[y1.b.SINT64.ordinal()] = 10;
            m.a.a[y1.b.UINT64.ordinal()] = 11;
            m.a.a[y1.b.STRING.ordinal()] = 12;
        }
    }
    private m(com.google.protobuf.CodedOutputStream codedOutputStream) {
        super();
        c0.b(codedOutputStream, "output");
        this.a = (CodedOutputStream)codedOutputStream;
        codedOutputStream.a = this;
    }

    public static com.google.protobuf.m P(com.google.protobuf.CodedOutputStream codedOutputStream) {
        com.google.protobuf.m mVar = codedOutputStream.a;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(codedOutputStream);
        return mVar2;
    }

    private <V> void Q(int i, boolean z2, V v3, com.google.protobuf.m0.a<Boolean, V> m0$a4) {
        this.a.Y0(i, 2);
        this.a.a1(m0.b(a4, Boolean.valueOf(z2), v3));
        m0.e(this.a, a4, Boolean.valueOf(z2), v3);
    }

    private <V> void R(int i, com.google.protobuf.m0.a<Integer, V> m0$a2, Map<Integer, V> map3) {
        Iterator valueOf;
        int i2;
        int i3;
        int intValue;
        boolean next;
        int i4;
        final int size = map3.size();
        final int[] iArr = new int[size];
        valueOf = map3.keySet().iterator();
        i3 = i2;
        for (Integer next2 : valueOf) {
            iArr[i3] = next2.intValue();
            i3 = i4;
        }
        Arrays.sort(iArr);
        while (i2 < size) {
            int i5 = iArr[i2];
            i3 = map3.get(Integer.valueOf(i5));
            this.a.Y0(i, 2);
            this.a.a1(m0.b(a2, Integer.valueOf(i5), i3));
            m0.e(this.a, a2, Integer.valueOf(i5), i3);
            i2++;
        }
    }

    private <V> void S(int i, com.google.protobuf.m0.a<Long, V> m0$a2, Map<Long, V> map3) {
        Iterator iterator;
        int i3;
        int valueOf;
        long longValue;
        com.google.protobuf.CodedOutputStream outputStream;
        int i2;
        final int size = map3.size();
        final long[] lArr = new long[size];
        iterator = map3.keySet().iterator();
        valueOf = i3;
        boolean next = iterator.hasNext();
        for (Long next2 : iterator) {
            lArr[valueOf] = next2.longValue();
            valueOf = i2;
            next = iterator.hasNext();
        }
        Arrays.sort(lArr);
        while (i3 < size) {
            long l = lArr[i3];
            iterator = map3.get(Long.valueOf(l));
            this.a.Y0(i, 2);
            this.a.a1(m0.b(a2, Long.valueOf(l), iterator));
            m0.e(this.a, a2, Long.valueOf(l), iterator);
            i3++;
        }
    }

    private <K, V> void T(int i, com.google.protobuf.m0.a<K, V> m0$a2, Map<K, V> map3) {
        int tRUE;
        int ordinal;
        Object obj5;
        switch (tRUE) {
            case 1:
                Object obj = map3.get(Boolean.FALSE);
                Q(i, false, obj, a2);
                obj5 = map3.get(Boolean.TRUE);
                Q(i, true, obj5, a2);
                break;
            case 2:
                R(i, a2, map3);
                break;
            case 3:
                S(i, a2, map3);
                break;
            case 4:
                U(i, a2, map3);
                break;
            default:
                obj5 = new StringBuilder();
                obj5.append("does not support key type: ");
                obj5.append(a2.a);
                IllegalArgumentException obj3 = new IllegalArgumentException(obj5.toString());
                throw obj3;
        }
    }

    private <V> void U(int i, com.google.protobuf.m0.a<String, V> m0$a2, Map<String, V> map3) {
        Iterator iterator;
        int i2;
        int i3;
        Object next2;
        boolean next;
        int i4;
        final int size = map3.size();
        final String[] strArr = new String[size];
        iterator = map3.keySet().iterator();
        i3 = i2;
        for (String next2 : iterator) {
            strArr[i3] = next2;
            i3 = i4;
        }
        Arrays.sort(strArr);
        while (i2 < size) {
            iterator = strArr[i2];
            i3 = map3.get(iterator);
            this.a.Y0(i, 2);
            this.a.a1(m0.b(a2, iterator, i3));
            m0.e(this.a, a2, iterator, i3);
            i2++;
        }
    }

    private void V(int i, Object object2) {
        com.google.protobuf.CodedOutputStream outputStream;
        if (object2 instanceof String != null) {
            this.a.W0(i, (String)object2);
        } else {
            this.a.p0(i, (j)object2);
        }
    }

    public void A(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.a1(obj5);
            while (i2 < list2.size()) {
                this.a.w0((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public void B(int i, List<Boolean> list2, boolean z3) {
        int i3;
        boolean booleanValue;
        int i2;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i2;
                obj3++;
            }
            this.a.a1(obj5);
            while (i3 < list2.size()) {
                this.a.m0((Boolean)list2.get(i3).booleanValue());
                i3++;
            }
        }
    }

    public <K, V> void C(int i, com.google.protobuf.m0.a<K, V> m0$a2, Map<K, V> map3) {
        boolean value2;
        com.google.protobuf.CodedOutputStream outputStream;
        Object key;
        Object value;
        if (this.a.f0()) {
            T(i, a2, map3);
        }
        Iterator obj7 = map3.entrySet().iterator();
        for (Map.Entry next2 : obj7) {
            this.a.Y0(i, 2);
            this.a.a1(m0.b(a2, next2.getKey(), next2.getValue()));
            m0.e(this.a, a2, next2.getKey(), next2.getValue());
        }
    }

    public void D(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.a1(obj5);
            while (i2 < list2.size()) {
                this.a.a1((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public void E(int i, List<Long> list2, boolean z3) {
        int i3;
        long longValue;
        int i2;
        int obj4;
        com.google.protobuf.CodedOutputStream obj6;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i2;
                obj4++;
            }
            this.a.a1(obj6);
            while (i3 < list2.size()) {
                this.a.V0((Long)list2.get(i3).longValue());
                i3++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void F(int i, long l2) {
        this.a.U0(i, l2);
    }

    @Override // com.google.protobuf.z1
    public void G(int i, float f2) {
        this.a.z0(i, f2);
    }

    @Override // com.google.protobuf.z1
    public void H(int i) {
        this.a.Y0(i, 4);
    }

    public void I(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i2;
                obj3++;
            }
            this.a.a1(obj5);
            while (i3 < list2.size()) {
                this.a.T0((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void J(int i, int i2) {
        this.a.t0(i, i2);
    }

    public void K(int i, List<Long> list2, boolean z3) {
        int i3;
        long longValue;
        int i2;
        int obj4;
        com.google.protobuf.CodedOutputStream obj6;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i2;
                obj4++;
            }
            this.a.a1(obj6);
            while (i3 < list2.size()) {
                this.a.I0((Long)list2.get(i3).longValue());
                i3++;
            }
        }
    }

    public void L(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.a1(obj5);
            while (i2 < list2.size()) {
                this.a.u0((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    public void M(int i, List<Double> list2, boolean z3) {
        int i3;
        double doubleValue;
        int i2;
        int obj4;
        com.google.protobuf.CodedOutputStream obj6;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i2;
                obj4++;
            }
            this.a.a1(obj6);
            while (i3 < list2.size()) {
                this.a.s0((Double)list2.get(i3).doubleValue());
                i3++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void N(int i, int i2) {
        this.a.S0(i, i2);
    }

    public void O(int i, List<com.google.protobuf.j> list2) {
        int i2;
        com.google.protobuf.CodedOutputStream outputStream;
        Object obj;
        i2 = 0;
        while (i2 < list2.size()) {
            this.a.p0(i, (j)list2.get(i2));
            i2++;
        }
    }

    public void a(int i, List<?> list2, com.google.protobuf.l1 l13) {
        int i2;
        Object obj;
        i2 = 0;
        while (i2 < list2.size()) {
            j(i, list2.get(i2), l13);
            i2++;
        }
    }

    public void b(int i, List<?> list2, com.google.protobuf.l1 l13) {
        int i2;
        Object obj;
        i2 = 0;
        while (i2 < list2.size()) {
            s(i, list2.get(i2), l13);
            i2++;
        }
    }

    public void c(int i, List<Float> list2, boolean z3) {
        int i2;
        float floatValue;
        int i3;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.a1(obj5);
            while (i2 < list2.size()) {
                this.a.A0((Float)list2.get(i2).floatValue());
                i2++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void d(int i, int i2) {
        this.a.Z0(i, i2);
    }

    @Override // com.google.protobuf.z1
    public final void e(int i, Object object2) {
        com.google.protobuf.CodedOutputStream outputStream;
        if (object2 instanceof j) {
            this.a.M0(i, (j)object2);
        } else {
            this.a.L0(i, (t0)object2);
        }
    }

    @Override // com.google.protobuf.z1
    public void f(int i, int i2) {
        this.a.v0(i, i2);
    }

    @Override // com.google.protobuf.z1
    public void g(int i, double d2) {
        this.a.r0(i, d2);
    }

    public void h(int i, List<Long> list2, boolean z3) {
        int i3;
        long longValue;
        int i2;
        int obj4;
        com.google.protobuf.CodedOutputStream obj6;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i2;
                obj4++;
            }
            this.a.a1(obj6);
            while (i3 < list2.size()) {
                this.a.R0((Long)list2.get(i3).longValue());
                i3++;
            }
        }
    }

    public void i(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.protobuf.CodedOutputStream obj6;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i3;
                obj4++;
            }
            this.a.a1(obj6);
            while (i2 < list2.size()) {
                this.a.c1((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void j(int i, Object object2, com.google.protobuf.l1 l13) {
        this.a.J0(i, (t0)object2, l13);
    }

    @Override // com.google.protobuf.z1
    public void k(int i, long l2) {
        this.a.x0(i, l2);
    }

    @Override // com.google.protobuf.z1
    public com.google.protobuf.z1.a l() {
        return z1.a.ASCENDING;
    }

    public void m(int i, List<String> list2) {
        Object size;
        boolean z;
        int i2;
        Object size2;
        i2 = 0;
        if (list2 instanceof i0) {
            while (i2 < list2.size()) {
                V(i, (i0)list2.O1(i2));
                i2++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void n(int i, String string2) {
        this.a.W0(i, string2);
    }

    @Override // com.google.protobuf.z1
    public void o(int i, long l2) {
        this.a.b1(i, l2);
    }

    public void p(int i, List<Integer> list2, boolean z3) {
        int i2;
        int intValue;
        int i3;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i3;
                obj3++;
            }
            this.a.a1(obj5);
            while (i2 < list2.size()) {
                this.a.G0((Integer)list2.get(i2).intValue());
                i2++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void q(int i, long l2) {
        this.a.H0(i, l2);
    }

    @Override // com.google.protobuf.z1
    public void r(int i, boolean z2) {
        this.a.l0(i, z2);
    }

    @Override // com.google.protobuf.z1
    public void s(int i, Object object2, com.google.protobuf.l1 l13) {
        this.a.C0(i, (t0)object2, l13);
    }

    @Override // com.google.protobuf.z1
    public void t(int i, int i2) {
        this.a.O0(i, i2);
    }

    @Override // com.google.protobuf.z1
    public void u(int i) {
        this.a.Y0(i, 3);
    }

    @Override // com.google.protobuf.z1
    public void v(int i, com.google.protobuf.j j2) {
        this.a.p0(i, j2);
    }

    @Override // com.google.protobuf.z1
    public void w(int i, int i2) {
        this.a.F0(i, i2);
    }

    public void x(int i, List<Long> list2, boolean z3) {
        int i2;
        long longValue;
        int i3;
        int obj4;
        com.google.protobuf.CodedOutputStream obj6;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj6 = obj4;
            while (obj4 < list2.size()) {
                obj6 += i3;
                obj4++;
            }
            this.a.a1(obj6);
            while (i2 < list2.size()) {
                this.a.y0((Long)list2.get(i2).longValue());
                i2++;
            }
        }
    }

    public void y(int i, List<Integer> list2, boolean z3) {
        int i3;
        int intValue;
        int i2;
        int obj3;
        com.google.protobuf.CodedOutputStream obj5;
        if (z3 != null) {
            this.a.Y0(i, 2);
            obj5 = obj3;
            while (obj3 < list2.size()) {
                obj5 += i2;
                obj3++;
            }
            this.a.a1(obj5);
            while (i3 < list2.size()) {
                this.a.P0((Integer)list2.get(i3).intValue());
                i3++;
            }
        }
    }

    @Override // com.google.protobuf.z1
    public void z(int i, long l2) {
        this.a.Q0(i, l2);
    }
}
