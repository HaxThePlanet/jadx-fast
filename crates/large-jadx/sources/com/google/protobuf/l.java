package com.google.protobuf;

import android.accounts.Account;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class l implements com.google.protobuf.j1 {

    private final com.google.protobuf.k a;
    private int b;
    private int c;
    private int d = 0;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l.a.a = iArr;
            iArr[y1.b.BOOL.ordinal()] = 1;
            l.a.a[y1.b.BYTES.ordinal()] = 2;
            l.a.a[y1.b.DOUBLE.ordinal()] = 3;
            l.a.a[y1.b.ENUM.ordinal()] = 4;
            l.a.a[y1.b.FIXED32.ordinal()] = 5;
            l.a.a[y1.b.FIXED64.ordinal()] = 6;
            l.a.a[y1.b.FLOAT.ordinal()] = 7;
            l.a.a[y1.b.INT32.ordinal()] = 8;
            l.a.a[y1.b.INT64.ordinal()] = 9;
            l.a.a[y1.b.MESSAGE.ordinal()] = 10;
            l.a.a[y1.b.SFIXED32.ordinal()] = 11;
            l.a.a[y1.b.SFIXED64.ordinal()] = 12;
            l.a.a[y1.b.SINT32.ordinal()] = 13;
            l.a.a[y1.b.SINT64.ordinal()] = 14;
            l.a.a[y1.b.STRING.ordinal()] = 15;
            l.a.a[y1.b.UINT32.ordinal()] = 16;
            l.a.a[y1.b.UINT64.ordinal()] = 17;
        }
    }
    private l(com.google.protobuf.k k) {
        super();
        int i = 0;
        c0.b(k, "input");
        this.a = (k)k;
        k.d = this;
    }

    public static com.google.protobuf.l P(com.google.protobuf.k k) {
        com.google.protobuf.l lVar = k.d;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(k);
        return lVar2;
    }

    private Object Q(com.google.protobuf.y1.b y1$b, Class<?> class2, com.google.protobuf.q q3) {
        switch (obj2) {
            case 1:
                return Boolean.valueOf(j());
            case 2:
                return F();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(t());
            case 5:
                return Integer.valueOf(i());
            case 6:
                return Long.valueOf(c());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(H());
            case 9:
                return Long.valueOf(M());
            case 10:
                return h(class2, q3);
            case 11:
                return Integer.valueOf(J());
            case 12:
                return Long.valueOf(l());
            case 13:
                return Integer.valueOf(v());
            case 14:
                return Long.valueOf(w());
            case 15:
                return N();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(b());
            default:
                RuntimeException obj2 = new RuntimeException("unsupported field type.");
                throw obj2;
        }
    }

    private <T> T R(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
        this.c = y1.c(y1.a(this.b), 4);
        Object obj = l1.i();
        l1.e(obj, this, q2);
        l1.c(obj);
        if (this.b != this.c) {
        } else {
            this.c = this.c;
            return obj;
        }
        throw InvalidProtocolBufferException.h();
    }

    private <T> T S(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
        com.google.protobuf.k kVar2 = this.a;
        if (kVar2.a >= kVar2.b) {
        } else {
            Object obj = l1.i();
            com.google.protobuf.k kVar3 = this.a;
            kVar3.a = i5++;
            l1.e(obj, this, q2);
            l1.c(obj);
            this.a.a(0);
            com.google.protobuf.k obj5 = this.a;
            obj5.a = obj6--;
            obj5.n(kVar2.o(this.a.G()));
            return obj;
        }
        throw InvalidProtocolBufferException.i();
    }

    private void U(int i) {
        if (this.a.d() != i) {
        } else {
        }
        throw InvalidProtocolBufferException.m();
    }

    private void V(int i) {
        if (y1.b(this.b) != i) {
        } else {
        }
        throw InvalidProtocolBufferException.e();
    }

    private void W(int i) {
        if (i &= 3 != 0) {
        } else {
        }
        throw InvalidProtocolBufferException.h();
    }

    private void X(int i) {
        if (i &= 7 != 0) {
        } else {
        }
        throw InvalidProtocolBufferException.h();
    }

    @Override // com.google.protobuf.j1
    public int A() {
        int i;
        int i2;
        int i3 = this.d;
        if (i3 != 0) {
            this.b = i3;
            this.d = 0;
        } else {
            this.b = this.a.F();
        }
        int i4 = this.b;
        if (i4 != 0 && i4 == this.c) {
            if (i4 == this.c) {
            }
            return y1.a(i4);
        }
        return Integer.MAX_VALUE;
    }

    public void B(List<String> list) {
        T(list, false);
    }

    public <T> T C(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
        V(2);
        return S(l1, q2);
    }

    public <K, V> void D(Map<K, V> map, com.google.protobuf.m0.a<K, V> m0$a2, com.google.protobuf.q q3) {
        Object obj2;
        Object obj;
        boolean z;
        int class;
        int i;
        String str;
        final int i2 = 2;
        V(i2);
        obj2 = a2.b;
        obj = a2.d;
        int i5 = A();
        while (i5 != Integer.MAX_VALUE) {
            class = 0;
            obj2 = Q(a2.a, class, class);
            i5 = A();
            obj = Q(a2.c, a2.d.getClass(), q3);
        }
        map.put(obj2, obj);
        this.a.n(this.a.o(this.a.G()));
    }

    public void E(List<String> list) {
        T(list, true);
    }

    @Override // com.google.protobuf.j1
    public com.google.protobuf.j F() {
        V(2);
        return this.a.q();
    }

    public void G(List<Float> list) {
        int i;
        int i5;
        int i3;
        int i2;
        int i4;
        Object obj5;
        i3 = 5;
        final int i8 = 2;
        if (list instanceof x) {
            i5 = list;
            obj5 = y1.b(this.b);
            if (obj5 != i8 && obj5 == i3) {
                if (obj5 != i3) {
                }
                throw InvalidProtocolBufferException.e();
            }
            obj5 = this.a.G();
            W(obj5);
            (x)i5.h(this.a.v());
            while (this.a.d() >= i2 + obj5) {
                i5.h(this.a.v());
            }
        } else {
            i = y1.b(this.b);
            if (i != i8 && i == i3) {
                if (i != i3) {
                }
                throw InvalidProtocolBufferException.e();
            }
            i5 = this.a.G();
            W(i5);
            list.add(Float.valueOf(this.a.v()));
            while (this.a.d() >= i7 += i5) {
                list.add(Float.valueOf(this.a.v()));
            }
        }
    }

    @Override // com.google.protobuf.j1
    public int H() {
        V(0);
        return this.a.w();
    }

    @Override // com.google.protobuf.j1
    public boolean I() {
        boolean z;
        int i;
        z = this.b;
        if (!this.a.e() && z == this.c) {
            z = this.b;
            if (z == this.c) {
            }
            return this.a.J(z);
        }
        return 0;
    }

    @Override // com.google.protobuf.j1
    public int J() {
        V(5);
        return this.a.z();
    }

    public void K(List<com.google.protobuf.j> list) {
        int i;
        int i2;
        if (y1.b(this.b) != 2) {
        }
        throw InvalidProtocolBufferException.e();
    }

    public void L(List<Double> list) {
        int i2;
        int i5;
        int i;
        int i3;
        int i4;
        int obj5;
        i = 2;
        i4 = 1;
        i5 = list;
        obj5 = y1.b(this.b);
        if (list instanceof n && obj5 != i4) {
            i5 = list;
            obj5 = y1.b(this.b);
            if (obj5 != i4) {
                if (obj5 != i) {
                } else {
                    obj5 = this.a.G();
                    X(obj5);
                    (n)(n)i5.h(this.a.r());
                    while (this.a.d() >= i8 += obj5) {
                        i5.h(this.a.r());
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            i5.h(this.a.r());
            while (this.a.e()) {
                obj5 = this.a.F();
                i5.h(this.a.r());
            }
        }
        i2 = y1.b(this.b);
        if (i2 != i4) {
            if (i2 != i) {
            } else {
                i5 = this.a.G();
                X(i5);
                list.add(Double.valueOf(this.a.r()));
                while (this.a.d() >= i7 += i5) {
                    list.add(Double.valueOf(this.a.r()));
                }
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Double.valueOf(this.a.r()));
        while (this.a.e()) {
            i2 = this.a.F();
            list.add(Double.valueOf(this.a.r()));
        }
    }

    @Override // com.google.protobuf.j1
    public long M() {
        V(0);
        return this.a.x();
    }

    @Override // com.google.protobuf.j1
    public String N() {
        V(2);
        return this.a.E();
    }

    public void O(List<Long> list) {
        int i4;
        int i5;
        int i3;
        int i2;
        int i;
        int obj5;
        i3 = 2;
        i = 1;
        i5 = list;
        obj5 = y1.b(this.b);
        if (list instanceof k0 && obj5 != i) {
            i5 = list;
            obj5 = y1.b(this.b);
            if (obj5 != i) {
                if (obj5 != i3) {
                } else {
                    obj5 = this.a.G();
                    X(obj5);
                    (k0)(k0)i5.i(this.a.u());
                    while (this.a.d() >= i8 += obj5) {
                        i5.i(this.a.u());
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            i5.i(this.a.u());
            while (this.a.e()) {
                obj5 = this.a.F();
                i5.i(this.a.u());
            }
        }
        i4 = y1.b(this.b);
        if (i4 != i) {
            if (i4 != i3) {
            } else {
                i5 = this.a.G();
                X(i5);
                list.add(Long.valueOf(this.a.u()));
                while (this.a.d() >= i7 += i5) {
                    list.add(Long.valueOf(this.a.u()));
                }
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Long.valueOf(this.a.u()));
        while (this.a.e()) {
            i4 = this.a.F();
            list.add(Long.valueOf(this.a.u()));
        }
    }

    public void T(List<String> list, boolean z2) {
        boolean z;
        String str;
        int i;
        Object obj3;
        int obj4;
        if (y1.b(this.b) != 2) {
        } else {
            if (list instanceof i0 && z2 == 0) {
                if (z2 == 0) {
                    (i0)list.T(F());
                    while (this.a.e()) {
                        obj3 = this.a.F();
                        obj.T(F());
                    }
                }
            }
            while (z2 != 0) {
                str = N();
                list.add(str);
                z = this.a.F();
                str = y();
            }
        }
        throw InvalidProtocolBufferException.e();
    }

    public void a(List<Integer> list) {
        int i2;
        int i3;
        int i4;
        int i;
        int obj3;
        i4 = 2;
        i2 = list;
        obj3 = y1.b(this.b);
        if (list instanceof b0 && obj3 != null) {
            i2 = list;
            obj3 = y1.b(this.b);
            if (obj3 != null) {
                if (obj3 != i4) {
                } else {
                    i9 += obj3;
                    (b0)(b0)i2.V(this.a.B());
                    while (this.a.d() >= i) {
                        i2.V(this.a.B());
                    }
                    U(i);
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.V(this.a.B());
            while (this.a.e()) {
                obj3 = this.a.F();
                i2.V(this.a.B());
            }
        }
        i3 = y1.b(this.b);
        if (i3 != 0) {
            if (i3 != i4) {
            } else {
                i8 += i2;
                list.add(Integer.valueOf(this.a.B()));
                while (this.a.d() >= i) {
                    list.add(Integer.valueOf(this.a.B()));
                }
                U(i);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Integer.valueOf(this.a.B()));
        while (this.a.e()) {
            i3 = this.a.F();
            list.add(Integer.valueOf(this.a.B()));
        }
    }

    @Override // com.google.protobuf.j1
    public long b() {
        V(0);
        return this.a.H();
    }

    @Override // com.google.protobuf.j1
    public long c() {
        V(1);
        return this.a.u();
    }

    public void d(List<Integer> list) {
        int i;
        int i4;
        int i2;
        int i5;
        int i3;
        Object obj5;
        i2 = 5;
        final int i10 = 2;
        if (list instanceof b0) {
            i4 = list;
            obj5 = y1.b(this.b);
            if (obj5 != i10 && obj5 == i2) {
                if (obj5 != i2) {
                }
                throw InvalidProtocolBufferException.e();
            }
            obj5 = this.a.G();
            W(obj5);
            (b0)i4.V(this.a.z());
            while (this.a.d() >= i5 + obj5) {
                i4.V(this.a.z());
            }
        } else {
            i = y1.b(this.b);
            if (i != i10 && i == i2) {
                if (i != i2) {
                }
                throw InvalidProtocolBufferException.e();
            }
            i4 = this.a.G();
            W(i4);
            list.add(Integer.valueOf(this.a.z()));
            while (this.a.d() >= i9 += i4) {
                list.add(Integer.valueOf(this.a.z()));
            }
        }
    }

    public void e(List<Long> list) {
        int i2;
        int i;
        int i3;
        int i4;
        long l;
        int obj5;
        i3 = 2;
        i2 = list;
        obj5 = y1.b(this.b);
        if (list instanceof k0 && obj5 != null) {
            i2 = list;
            obj5 = y1.b(this.b);
            if (obj5 != null) {
                if (obj5 != i3) {
                } else {
                    i7 += obj5;
                    (k0)(k0)i2.i(this.a.C());
                    while (this.a.d() >= i4) {
                        i2.i(this.a.C());
                    }
                    U(i4);
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.i(this.a.C());
            while (this.a.e()) {
                obj5 = this.a.F();
                i2.i(this.a.C());
            }
        }
        i = y1.b(this.b);
        if (i != 0) {
            if (i != i3) {
            } else {
                i6 += i2;
                list.add(Long.valueOf(this.a.C()));
                while (this.a.d() >= i4) {
                    list.add(Long.valueOf(this.a.C()));
                }
                U(i4);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Long.valueOf(this.a.C()));
        while (this.a.e()) {
            i = this.a.F();
            list.add(Long.valueOf(this.a.C()));
        }
    }

    public <T> void f(List<T> list, com.google.protobuf.l1<T> l12, com.google.protobuf.q q3) {
        int i;
        if (y1.b(this.b) != 3) {
        } else {
            list.add(R(l12, q3));
            while (!this.a.e()) {
                i = this.a.F();
                list.add(R(l12, q3));
            }
        }
        throw InvalidProtocolBufferException.e();
    }

    public void g(List<Integer> list) {
        int i2;
        int i4;
        int i3;
        int i;
        int obj3;
        i3 = 2;
        i2 = list;
        obj3 = y1.b(this.b);
        if (list instanceof b0 && obj3 != null) {
            i2 = list;
            obj3 = y1.b(this.b);
            if (obj3 != null) {
                if (obj3 != i3) {
                } else {
                    i9 += obj3;
                    (b0)(b0)i2.V(this.a.G());
                    while (this.a.d() >= i) {
                        i2.V(this.a.G());
                    }
                    U(i);
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.V(this.a.G());
            while (this.a.e()) {
                obj3 = this.a.F();
                i2.V(this.a.G());
            }
        }
        i4 = y1.b(this.b);
        if (i4 != 0) {
            if (i4 != i3) {
            } else {
                i8 += i2;
                list.add(Integer.valueOf(this.a.G()));
                while (this.a.d() >= i) {
                    list.add(Integer.valueOf(this.a.G()));
                }
                U(i);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Integer.valueOf(this.a.G()));
        while (this.a.e()) {
            i4 = this.a.F();
            list.add(Integer.valueOf(this.a.G()));
        }
    }

    @Override // com.google.protobuf.j1
    public int getTag() {
        return this.b;
    }

    public <T> T h(Class<T> class, com.google.protobuf.q q2) {
        V(2);
        return S(g1.a().d(class), q2);
    }

    @Override // com.google.protobuf.j1
    public int i() {
        V(5);
        return this.a.t();
    }

    @Override // com.google.protobuf.j1
    public boolean j() {
        V(0);
        return this.a.p();
    }

    public <T> void k(List<T> list, com.google.protobuf.l1<T> l12, com.google.protobuf.q q3) {
        int i;
        if (y1.b(this.b) != 2) {
        } else {
            list.add(S(l12, q3));
            while (!this.a.e()) {
                i = this.a.F();
                list.add(S(l12, q3));
            }
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // com.google.protobuf.j1
    public long l() {
        V(1);
        return this.a.A();
    }

    public void m(List<Long> list) {
        int i2;
        int i;
        int i3;
        int i4;
        long l;
        int obj5;
        i3 = 2;
        i2 = list;
        obj5 = y1.b(this.b);
        if (list instanceof k0 && obj5 != null) {
            i2 = list;
            obj5 = y1.b(this.b);
            if (obj5 != null) {
                if (obj5 != i3) {
                } else {
                    i7 += obj5;
                    (k0)(k0)i2.i(this.a.H());
                    while (this.a.d() >= i4) {
                        i2.i(this.a.H());
                    }
                    U(i4);
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.i(this.a.H());
            while (this.a.e()) {
                obj5 = this.a.F();
                i2.i(this.a.H());
            }
        }
        i = y1.b(this.b);
        if (i != 0) {
            if (i != i3) {
            } else {
                i6 += i2;
                list.add(Long.valueOf(this.a.H()));
                while (this.a.d() >= i4) {
                    list.add(Long.valueOf(this.a.H()));
                }
                U(i4);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Long.valueOf(this.a.H()));
        while (this.a.e()) {
            i = this.a.F();
            list.add(Long.valueOf(this.a.H()));
        }
    }

    public <T> T n(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
        V(3);
        return R(l1, q2);
    }

    @Override // com.google.protobuf.j1
    public int o() {
        V(0);
        return this.a.G();
    }

    public void p(List<Long> list) {
        int i2;
        int i3;
        int i4;
        int i;
        long l;
        int obj5;
        i4 = 2;
        i2 = list;
        obj5 = y1.b(this.b);
        if (list instanceof k0 && obj5 != null) {
            i2 = list;
            obj5 = y1.b(this.b);
            if (obj5 != null) {
                if (obj5 != i4) {
                } else {
                    i7 += obj5;
                    (k0)(k0)i2.i(this.a.x());
                    while (this.a.d() >= i) {
                        i2.i(this.a.x());
                    }
                    U(i);
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.i(this.a.x());
            while (this.a.e()) {
                obj5 = this.a.F();
                i2.i(this.a.x());
            }
        }
        i3 = y1.b(this.b);
        if (i3 != 0) {
            if (i3 != i4) {
            } else {
                i6 += i2;
                list.add(Long.valueOf(this.a.x()));
                while (this.a.d() >= i) {
                    list.add(Long.valueOf(this.a.x()));
                }
                U(i);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Long.valueOf(this.a.x()));
        while (this.a.e()) {
            i3 = this.a.F();
            list.add(Long.valueOf(this.a.x()));
        }
    }

    public void q(List<Long> list) {
        int i4;
        int i2;
        int i;
        int i3;
        int i5;
        int obj5;
        i = 2;
        i5 = 1;
        i2 = list;
        obj5 = y1.b(this.b);
        if (list instanceof k0 && obj5 != i5) {
            i2 = list;
            obj5 = y1.b(this.b);
            if (obj5 != i5) {
                if (obj5 != i) {
                } else {
                    obj5 = this.a.G();
                    X(obj5);
                    (k0)(k0)i2.i(this.a.A());
                    while (this.a.d() >= i8 += obj5) {
                        i2.i(this.a.A());
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.i(this.a.A());
            while (this.a.e()) {
                obj5 = this.a.F();
                i2.i(this.a.A());
            }
        }
        i4 = y1.b(this.b);
        if (i4 != i5) {
            if (i4 != i) {
            } else {
                i2 = this.a.G();
                X(i2);
                list.add(Long.valueOf(this.a.A()));
                while (this.a.d() >= i7 += i2) {
                    list.add(Long.valueOf(this.a.A()));
                }
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Long.valueOf(this.a.A()));
        while (this.a.e()) {
            i4 = this.a.F();
            list.add(Long.valueOf(this.a.A()));
        }
    }

    public void r(List<Integer> list) {
        int i;
        int i3;
        int i4;
        int i2;
        int obj3;
        i4 = 2;
        i = list;
        obj3 = y1.b(this.b);
        if (list instanceof b0 && obj3 != null) {
            i = list;
            obj3 = y1.b(this.b);
            if (obj3 != null) {
                if (obj3 != i4) {
                } else {
                    i9 += obj3;
                    (b0)(b0)i.V(this.a.w());
                    while (this.a.d() >= i2) {
                        i.V(this.a.w());
                    }
                    U(i2);
                }
                throw InvalidProtocolBufferException.e();
            }
            i.V(this.a.w());
            while (this.a.e()) {
                obj3 = this.a.F();
                i.V(this.a.w());
            }
        }
        i3 = y1.b(this.b);
        if (i3 != 0) {
            if (i3 != i4) {
            } else {
                i8 += i;
                list.add(Integer.valueOf(this.a.w()));
                while (this.a.d() >= i2) {
                    list.add(Integer.valueOf(this.a.w()));
                }
                U(i2);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Integer.valueOf(this.a.w()));
        while (this.a.e()) {
            i3 = this.a.F();
            list.add(Integer.valueOf(this.a.w()));
        }
    }

    @Override // com.google.protobuf.j1
    public double readDouble() {
        V(1);
        return this.a.r();
    }

    @Override // com.google.protobuf.j1
    public float readFloat() {
        V(5);
        return this.a.v();
    }

    public void s(List<Integer> list) {
        int i2;
        int i;
        int i3;
        int i4;
        int obj3;
        i3 = 2;
        i2 = list;
        obj3 = y1.b(this.b);
        if (list instanceof b0 && obj3 != null) {
            i2 = list;
            obj3 = y1.b(this.b);
            if (obj3 != null) {
                if (obj3 != i3) {
                } else {
                    i9 += obj3;
                    (b0)(b0)i2.V(this.a.s());
                    while (this.a.d() >= i4) {
                        i2.V(this.a.s());
                    }
                    U(i4);
                }
                throw InvalidProtocolBufferException.e();
            }
            i2.V(this.a.s());
            while (this.a.e()) {
                obj3 = this.a.F();
                i2.V(this.a.s());
            }
        }
        i = y1.b(this.b);
        if (i != 0) {
            if (i != i3) {
            } else {
                i8 += i2;
                list.add(Integer.valueOf(this.a.s()));
                while (this.a.d() >= i4) {
                    list.add(Integer.valueOf(this.a.s()));
                }
                U(i4);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Integer.valueOf(this.a.s()));
        while (this.a.e()) {
            i = this.a.F();
            list.add(Integer.valueOf(this.a.s()));
        }
    }

    @Override // com.google.protobuf.j1
    public int t() {
        V(0);
        return this.a.s();
    }

    public void u(List<Integer> list) {
        int i5;
        int i;
        int i2;
        int i3;
        int i4;
        Object obj5;
        i2 = 5;
        final int i10 = 2;
        if (list instanceof b0) {
            i = list;
            obj5 = y1.b(this.b);
            if (obj5 != i10 && obj5 == i2) {
                if (obj5 != i2) {
                }
                throw InvalidProtocolBufferException.e();
            }
            obj5 = this.a.G();
            W(obj5);
            (b0)i.V(this.a.t());
            while (this.a.d() >= i3 + obj5) {
                i.V(this.a.t());
            }
        } else {
            i5 = y1.b(this.b);
            if (i5 != i10 && i5 == i2) {
                if (i5 != i2) {
                }
                throw InvalidProtocolBufferException.e();
            }
            i = this.a.G();
            W(i);
            list.add(Integer.valueOf(this.a.t()));
            while (this.a.d() >= i9 += i) {
                list.add(Integer.valueOf(this.a.t()));
            }
        }
    }

    @Override // com.google.protobuf.j1
    public int v() {
        V(0);
        return this.a.B();
    }

    @Override // com.google.protobuf.j1
    public long w() {
        V(0);
        return this.a.C();
    }

    public void x(List<Boolean> list) {
        int i4;
        int i;
        int i2;
        int i3;
        int obj3;
        i2 = 2;
        i4 = list;
        obj3 = y1.b(this.b);
        if (list instanceof h && obj3 != null) {
            i4 = list;
            obj3 = y1.b(this.b);
            if (obj3 != null) {
                if (obj3 != i2) {
                } else {
                    i7 += obj3;
                    (h)(h)i4.i(this.a.p());
                    while (this.a.d() >= i3) {
                        i4.i(this.a.p());
                    }
                    U(i3);
                }
                throw InvalidProtocolBufferException.e();
            }
            i4.i(this.a.p());
            while (this.a.e()) {
                obj3 = this.a.F();
                i4.i(this.a.p());
            }
        }
        i = y1.b(this.b);
        if (i != 0) {
            if (i != i2) {
            } else {
                i6 += i4;
                list.add(Boolean.valueOf(this.a.p()));
                while (this.a.d() >= i3) {
                    list.add(Boolean.valueOf(this.a.p()));
                }
                U(i3);
            }
            throw InvalidProtocolBufferException.e();
        }
        list.add(Boolean.valueOf(this.a.p()));
        while (this.a.e()) {
            i = this.a.F();
            list.add(Boolean.valueOf(this.a.p()));
        }
    }

    @Override // com.google.protobuf.j1
    public String y() {
        V(2);
        return this.a.D();
    }

    public <T> T z(Class<T> class, com.google.protobuf.q q2) {
        V(3);
        return R(g1.a().d(class), q2);
    }
}
