package com.google.protobuf;

import android.accounts.Account;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class g implements com.google.protobuf.j1 {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            g.a.a = iArr;
            iArr[y1.b.BOOL.ordinal()] = 1;
            g.a.a[y1.b.BYTES.ordinal()] = 2;
            g.a.a[y1.b.DOUBLE.ordinal()] = 3;
            g.a.a[y1.b.ENUM.ordinal()] = 4;
            g.a.a[y1.b.FIXED32.ordinal()] = 5;
            g.a.a[y1.b.FIXED64.ordinal()] = 6;
            g.a.a[y1.b.FLOAT.ordinal()] = 7;
            g.a.a[y1.b.INT32.ordinal()] = 8;
            g.a.a[y1.b.INT64.ordinal()] = 9;
            g.a.a[y1.b.MESSAGE.ordinal()] = 10;
            g.a.a[y1.b.SFIXED32.ordinal()] = 11;
            g.a.a[y1.b.SFIXED64.ordinal()] = 12;
            g.a.a[y1.b.SINT32.ordinal()] = 13;
            g.a.a[y1.b.SINT64.ordinal()] = 14;
            g.a.a[y1.b.STRING.ordinal()] = 15;
            g.a.a[y1.b.UINT32.ordinal()] = 16;
            g.a.a[y1.b.UINT64.ordinal()] = 17;
        }
    }

    private static final class b extends com.google.protobuf.g {

        private final boolean a;
        private final byte[] b;
        private int c;
        private int d;
        private int e;
        private int f;
        public b(ByteBuffer byteBuffer, boolean z2) {
            super(0);
            this.a = z2;
            this.b = byteBuffer.array();
            this.c = obj3 += position;
            this.d = obj3 += obj2;
        }

        private boolean Q() {
            int i;
            i = this.c == this.d ? 1 : 0;
            return i;
        }

        private byte R() {
            int i = this.c;
            if (i == this.d) {
            } else {
                this.c = i + 1;
                return this.b[i];
            }
            throw InvalidProtocolBufferException.m();
        }

        private Object S(com.google.protobuf.y1.b y1$b, Class<?> class2, com.google.protobuf.q q3) {
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

        private <T> T T(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
            this.f = y1.c(y1.a(this.e), 4);
            Object obj = l1.i();
            l1.e(obj, this, q2);
            l1.c(obj);
            if (this.e != this.f) {
            } else {
                this.f = this.f;
                return obj;
            }
            throw InvalidProtocolBufferException.h();
        }

        private int U() {
            e0(4);
            return V();
        }

        private int V() {
            int i = this.c;
            final byte[] bArr = this.b;
            this.c = i + 4;
            return i4 |= i9;
        }

        private long W() {
            e0(8);
            return X();
        }

        private long X() {
            int i = this.c;
            final byte[] bArr = this.b;
            this.c = i + 8;
            int i14 = 255;
            return i4 |= i13;
        }

        private <T> T Y(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
            int i = b0();
            e0(i);
            i3 += i;
            this.d = i4;
            Object obj = l1.i();
            l1.e(obj, this, q2);
            l1.c(obj);
            if (this.c != i4) {
            } else {
                this.d = this.d;
                return obj;
            }
            throw InvalidProtocolBufferException.h();
        }

        private int b0() {
            int i2;
            int i3;
            int i5;
            byte[] bArr;
            int i4;
            int i;
            int i6 = this.c;
            int i12 = this.d;
            if (i12 == i6) {
            } else {
                bArr = this.b;
                int i14 = i6 + 1;
                byte b = bArr[i6];
                if (b >= 0) {
                    this.c = i14;
                    return b;
                }
                if (i12 -= i14 < 9) {
                    return (int)l;
                }
                i3 = i14 + 1;
                b ^= i4;
                if (i8 < 0) {
                    i8 ^= -128;
                } else {
                    i4 = i3 + 1;
                    i8 ^= i5;
                    if (i9 >= 0) {
                        i9 ^= 16256;
                        i3 = i4;
                    } else {
                    }
                }
                this.c = i3;
                return i2;
            }
            throw InvalidProtocolBufferException.m();
        }

        private long d0() {
            int i2;
            int i;
            int i4;
            int i3;
            i2 = 0;
            i = 0;
            while (i < 64) {
                byte b = R();
                i += 7;
            }
            throw InvalidProtocolBufferException.f();
        }

        private void e0(int i) {
            int i3;
            int i2;
            if (i < 0) {
            } else {
                if (i > i4 -= i2) {
                } else {
                }
            }
            throw InvalidProtocolBufferException.m();
        }

        private void f0(int i) {
            if (this.c != i) {
            } else {
            }
            throw InvalidProtocolBufferException.m();
        }

        private void g0(int i) {
            if (y1.b(this.e) != i) {
            } else {
            }
            throw InvalidProtocolBufferException.e();
        }

        private void h0(int i) {
            e0(i);
            this.c = i2 += i;
        }

        private void i0() {
            int i;
            int i2;
            this.f = y1.c(y1.a(this.e), 4);
            while (A() != Integer.MAX_VALUE) {
                if (I() != 0) {
                }
            }
            if (this.e != this.f) {
            } else {
                this.f = this.f;
            }
            throw InvalidProtocolBufferException.h();
        }

        private void j0() {
            int i2;
            int i;
            int i4;
            int i3;
            final int i6 = 10;
            if (i5 -= i >= i6) {
                i4 = 0;
                while (i4 < i6) {
                    i3 = i + 1;
                    i4++;
                    i = i3;
                }
            }
            k0();
        }

        private void k0() {
            int i;
            byte b;
            i = 0;
            while (i < 10) {
                i++;
            }
            throw InvalidProtocolBufferException.f();
        }

        private void l0(int i) {
            e0(i);
            if (i &= 3 != 0) {
            } else {
            }
            throw InvalidProtocolBufferException.h();
        }

        private void m0(int i) {
            e0(i);
            if (i &= 7 != 0) {
            } else {
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.g
        public int A() {
            final int i3 = Integer.MAX_VALUE;
            if (Q()) {
                return i3;
            }
            int i = b0();
            this.e = i;
            if (i == this.f) {
                return i3;
            }
            return y1.a(i);
        }

        public void B(List<String> list) {
            a0(list, false);
        }

        public <T> T C(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
            g0(2);
            return Y(l1, q2);
        }

        public <K, V> void D(Map<K, V> map, com.google.protobuf.m0.a<K, V> m0$a2, com.google.protobuf.q q3) {
            Object obj;
            Object obj2;
            boolean z;
            int class;
            String str;
            final int i = 2;
            g0(i);
            int i2 = b0();
            e0(i2);
            this.d = i4 += i2;
            obj = a2.b;
            obj2 = a2.d;
            int i6 = A();
            while (i6 == Integer.MAX_VALUE) {
                class = 0;
                obj = S(a2.a, class, class);
                i6 = A();
                obj2 = S(a2.c, a2.d.getClass(), q3);
            }
            map.put(obj, obj2);
            this.d = this.d;
        }

        public void E(List<String> list) {
            a0(list, true);
        }

        @Override // com.google.protobuf.g
        public com.google.protobuf.j F() {
            com.google.protobuf.j jVar;
            int i;
            g0(2);
            int i3 = b0();
            if (i3 == 0) {
                return j.a;
            }
            e0(i3);
            if (this.a) {
                jVar = j.X(this.b, this.c, i3);
            } else {
                jVar = j.t(this.b, this.c, i3);
            }
            this.c = i4 += i3;
            return jVar;
        }

        public void G(List<Float> list) {
            int i5;
            int valueOf;
            int i3;
            int intBitsToFloat;
            int i6;
            int i4;
            int i2;
            int i;
            i4 = 5;
            i = 2;
            if (list instanceof x) {
                i3 = y1.b(this.e);
                if (i3 != i && i3 == i4) {
                    if (i3 != i4) {
                    }
                    throw InvalidProtocolBufferException.e();
                }
                intBitsToFloat = b0();
                l0(intBitsToFloat);
                while (this.c < i12 += intBitsToFloat) {
                    (x)list.h(Float.intBitsToFloat(V()));
                }
            } else {
                i5 = y1.b(this.e);
                if (i5 != i && i5 == i4) {
                    if (i5 != i4) {
                    }
                    throw InvalidProtocolBufferException.e();
                }
                valueOf = b0();
                l0(valueOf);
                while (this.c < i11 += valueOf) {
                    list.add(Float.valueOf(Float.intBitsToFloat(V())));
                }
            }
        }

        @Override // com.google.protobuf.g
        public int H() {
            g0(0);
            return b0();
        }

        @Override // com.google.protobuf.g
        public boolean I() {
            boolean z;
            int i;
            if (!Q()) {
                z = this.e;
                if (z == this.f) {
                } else {
                    int i3 = y1.b(z);
                    int i7 = 1;
                    if (i3 != 0 && i3 != i7 && i3 != 2 && i3 != 3) {
                        if (i3 != i7) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5) {
                                    } else {
                                        h0(4);
                                        return i7;
                                    }
                                    throw InvalidProtocolBufferException.e();
                                }
                                i0();
                                return i7;
                            }
                            h0(b0());
                            return i7;
                        }
                        h0(8);
                        return i7;
                    }
                }
                j0();
                return i7;
            }
            return 0;
        }

        @Override // com.google.protobuf.g
        public int J() {
            g0(5);
            return U();
        }

        public void K(List<com.google.protobuf.j> list) {
            int i;
            int i2;
            int i3;
            if (y1.b(this.e) != 2) {
            }
            throw InvalidProtocolBufferException.e();
        }

        public void L(List<Double> list) {
            int valueOf;
            int i2;
            int i;
            int i3;
            int i4;
            int longBitsToDouble;
            int obj5;
            i3 = 2;
            longBitsToDouble = 1;
            i = list;
            obj5 = y1.b(this.e);
            if (list instanceof n && obj5 != longBitsToDouble) {
                i = list;
                obj5 = y1.b(this.e);
                if (obj5 != longBitsToDouble) {
                    if (obj5 != i3) {
                    } else {
                        obj5 = b0();
                        m0(obj5);
                        while (this.c < i7 += obj5) {
                            (n)(n)i.h(Double.longBitsToDouble(X()));
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i.h(readDouble());
                while (Q()) {
                    i.h(readDouble());
                }
            }
            i2 = y1.b(this.e);
            if (i2 != longBitsToDouble) {
                if (i2 != i3) {
                } else {
                    valueOf = b0();
                    m0(valueOf);
                    while (this.c < i6 += valueOf) {
                        list.add(Double.valueOf(Double.longBitsToDouble(X())));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Double.valueOf(readDouble()));
            while (Q()) {
                list.add(Double.valueOf(readDouble()));
            }
        }

        @Override // com.google.protobuf.g
        public long M() {
            g0(0);
            return c0();
        }

        @Override // com.google.protobuf.g
        public String N() {
            return Z(true);
        }

        public void O(List<Long> list) {
            int valueOf;
            int i2;
            int i4;
            int i3;
            int i;
            int i5;
            int obj5;
            i3 = 2;
            i5 = 1;
            i4 = list;
            obj5 = y1.b(this.e);
            if (list instanceof k0 && obj5 != i5) {
                i4 = list;
                obj5 = y1.b(this.e);
                if (obj5 != i5) {
                    if (obj5 != i3) {
                    } else {
                        obj5 = b0();
                        m0(obj5);
                        while (this.c < i8 += obj5) {
                            (k0)(k0)i4.i(X());
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i4.i(c());
                while (Q()) {
                    i4.i(c());
                }
            }
            i2 = y1.b(this.e);
            if (i2 != i5) {
                if (i2 != i3) {
                } else {
                    valueOf = b0();
                    m0(valueOf);
                    while (this.c < i7 += valueOf) {
                        list.add(Long.valueOf(X()));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Long.valueOf(c()));
            while (Q()) {
                list.add(Long.valueOf(c()));
            }
        }

        @Override // com.google.protobuf.g
        public String Z(boolean z) {
            int i;
            int i2;
            boolean obj5;
            g0(2);
            int i4 = b0();
            if (i4 == 0) {
                return "";
            }
            e0(i4);
            if (z) {
                i = this.c;
                if (!x1.t(this.b, i, i + i4)) {
                } else {
                }
                throw InvalidProtocolBufferException.d();
            }
            obj5 = new String(this.b, this.c, i4, c0.a);
            this.c = i5 += i4;
            return obj5;
        }

        public void a(List<Integer> list) {
            int valueOf;
            int i5;
            int i2;
            int i4;
            int i;
            int i3;
            int obj4;
            i4 = 2;
            i2 = list;
            obj4 = y1.b(this.e);
            if (list instanceof b0 && obj4 != null) {
                i2 = list;
                obj4 = y1.b(this.e);
                if (obj4 != null) {
                    if (obj4 != i4) {
                    } else {
                        while (this.c < i11 += obj4) {
                            (b0)(b0)i2.V(k.b(b0()));
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i2.V(v());
                while (Q()) {
                    i2.V(v());
                }
            }
            i5 = y1.b(this.e);
            if (i5 != 0) {
                if (i5 != i4) {
                } else {
                    while (this.c < i10 += valueOf) {
                        list.add(Integer.valueOf(k.b(b0())));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Integer.valueOf(v()));
            while (Q()) {
                list.add(Integer.valueOf(v()));
            }
        }

        public void a0(List<String> list, boolean z2) {
            boolean z;
            int i2;
            int i;
            Object obj4;
            boolean obj5;
            if (y1.b(this.e) != 2) {
            } else {
                if (list instanceof i0 && !z2) {
                    if (!z2) {
                        (i0)list.T(F());
                        while (Q()) {
                            obj.T(F());
                        }
                    }
                }
                list.add(Z(z2));
                while (Q()) {
                    list.add(Z(z2));
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.protobuf.g
        public long b() {
            g0(0);
            return c0();
        }

        @Override // com.google.protobuf.g
        public long c() {
            g0(1);
            return W();
        }

        @Override // com.google.protobuf.g
        public long c0() {
            long cmp;
            int i3;
            int l3;
            long l;
            byte[] bArr;
            int i2;
            int i;
            long l4;
            long l2;
            int i4 = this.c;
            int i11 = this.d;
            if (i11 == i4) {
            } else {
                bArr = this.b;
                int i17 = i4 + 1;
                byte b = bArr[i4];
                if (b >= 0) {
                    this.c = i17;
                    return (long)b;
                }
                if (i11 -= i17 < 9) {
                    return d0();
                }
                i3 = i17 + 1;
                b ^= i2;
                if (i5 < 0) {
                    i5 ^= -128;
                    l = (long)cmp;
                } else {
                }
                this.c = i3;
                return l;
            }
            throw InvalidProtocolBufferException.m();
        }

        public void d(List<Integer> list) {
            int i5;
            int valueOf;
            int i;
            int i3;
            int i2;
            int i6;
            int i4;
            int i7;
            i6 = 5;
            i7 = 2;
            if (list instanceof b0) {
                i = y1.b(this.e);
                if (i != i7 && i == i6) {
                    if (i != i6) {
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i3 = b0();
                l0(i3);
                while (this.c < i14 += i3) {
                    (b0)list.V(V());
                }
            } else {
                i5 = y1.b(this.e);
                if (i5 != i7 && i5 == i6) {
                    if (i5 != i6) {
                    }
                    throw InvalidProtocolBufferException.e();
                }
                valueOf = b0();
                l0(valueOf);
                while (this.c < i13 += valueOf) {
                    list.add(Integer.valueOf(V()));
                }
            }
        }

        public void e(List<Long> list) {
            int valueOf;
            int i4;
            int i2;
            int i3;
            int i;
            long l;
            int obj5;
            i3 = 2;
            i2 = list;
            obj5 = y1.b(this.e);
            if (list instanceof k0 && obj5 != null) {
                i2 = list;
                obj5 = y1.b(this.e);
                if (obj5 != null) {
                    if (obj5 != i3) {
                    } else {
                        while (this.c < i7 += obj5) {
                            (k0)(k0)i2.i(k.c(c0()));
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i2.i(w());
                while (Q()) {
                    i2.i(w());
                }
            }
            i4 = y1.b(this.e);
            if (i4 != 0) {
                if (i4 != i3) {
                } else {
                    while (this.c < i6 += valueOf) {
                        list.add(Long.valueOf(k.c(c0())));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Long.valueOf(w()));
            while (Q()) {
                list.add(Long.valueOf(w()));
            }
        }

        public <T> void f(List<T> list, com.google.protobuf.l1<T> l12, com.google.protobuf.q q3) {
            int i;
            int i2;
            if (y1.b(this.e) != 3) {
            } else {
                list.add(T(l12, q3));
                while (Q()) {
                    list.add(T(l12, q3));
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public void g(List<Integer> list) {
            int valueOf;
            int i5;
            int i2;
            int i3;
            int i;
            int i4;
            int obj4;
            i3 = 2;
            i2 = list;
            obj4 = y1.b(this.e);
            if (list instanceof b0 && obj4 != null) {
                i2 = list;
                obj4 = y1.b(this.e);
                if (obj4 != null) {
                    if (obj4 != i3) {
                    } else {
                        while (this.c < i10 += obj4) {
                            (b0)(b0)i2.V(b0());
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i2.V(o());
                while (Q()) {
                    i2.V(o());
                }
            }
            i5 = y1.b(this.e);
            if (i5 != 0) {
                if (i5 != i3) {
                } else {
                    while (this.c < i9 += valueOf) {
                        list.add(Integer.valueOf(b0()));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Integer.valueOf(o()));
            while (Q()) {
                list.add(Integer.valueOf(o()));
            }
        }

        @Override // com.google.protobuf.g
        public int getTag() {
            return this.e;
        }

        public <T> T h(Class<T> class, com.google.protobuf.q q2) {
            g0(2);
            return Y(g1.a().d(class), q2);
        }

        @Override // com.google.protobuf.g
        public int i() {
            g0(5);
            return U();
        }

        @Override // com.google.protobuf.g
        public boolean j() {
            int i;
            g0(0);
            if (b0() != 0) {
                i = 1;
            }
            return i;
        }

        public <T> void k(List<T> list, com.google.protobuf.l1<T> l12, com.google.protobuf.q q3) {
            int i2;
            int i;
            if (y1.b(this.e) != 2) {
            } else {
                list.add(Y(l12, q3));
                while (Q()) {
                    list.add(Y(l12, q3));
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // com.google.protobuf.g
        public long l() {
            g0(1);
            return W();
        }

        public void m(List<Long> list) {
            int i2;
            int valueOf;
            int i5;
            int i3;
            int i4;
            int i;
            int obj5;
            i3 = 2;
            i5 = list;
            obj5 = y1.b(this.e);
            if (list instanceof k0 && obj5 != null) {
                i5 = list;
                obj5 = y1.b(this.e);
                if (obj5 != null) {
                    if (obj5 != i3) {
                    } else {
                        i8 += obj5;
                        while (this.c < i4) {
                            (k0)(k0)i5.i(c0());
                        }
                        f0(i4);
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i5.i(b());
                while (Q()) {
                    i5.i(b());
                }
            }
            i2 = y1.b(this.e);
            if (i2 != 0) {
                if (i2 != i3) {
                } else {
                    i7 += valueOf;
                    while (this.c < i4) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(i4);
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Long.valueOf(b()));
            while (Q()) {
                list.add(Long.valueOf(b()));
            }
        }

        public <T> T n(com.google.protobuf.l1<T> l1, com.google.protobuf.q q2) {
            g0(3);
            return T(l1, q2);
        }

        @Override // com.google.protobuf.g
        public int o() {
            g0(0);
            return b0();
        }

        public void p(List<Long> list) {
            int i5;
            int valueOf;
            int i2;
            int i3;
            int i4;
            int i;
            int obj5;
            i3 = 2;
            i2 = list;
            obj5 = y1.b(this.e);
            if (list instanceof k0 && obj5 != null) {
                i2 = list;
                obj5 = y1.b(this.e);
                if (obj5 != null) {
                    if (obj5 != i3) {
                    } else {
                        i8 += obj5;
                        while (this.c < i4) {
                            (k0)(k0)i2.i(c0());
                        }
                        f0(i4);
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i2.i(M());
                while (Q()) {
                    i2.i(M());
                }
            }
            i5 = y1.b(this.e);
            if (i5 != 0) {
                if (i5 != i3) {
                } else {
                    i7 += valueOf;
                    while (this.c < i4) {
                        list.add(Long.valueOf(c0()));
                    }
                    f0(i4);
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Long.valueOf(M()));
            while (Q()) {
                list.add(Long.valueOf(M()));
            }
        }

        public void q(List<Long> list) {
            int valueOf;
            int i;
            int i2;
            int i5;
            int i3;
            int i4;
            int obj5;
            i5 = 2;
            i4 = 1;
            i2 = list;
            obj5 = y1.b(this.e);
            if (list instanceof k0 && obj5 != i4) {
                i2 = list;
                obj5 = y1.b(this.e);
                if (obj5 != i4) {
                    if (obj5 != i5) {
                    } else {
                        obj5 = b0();
                        m0(obj5);
                        while (this.c < i8 += obj5) {
                            (k0)(k0)i2.i(X());
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i2.i(l());
                while (Q()) {
                    i2.i(l());
                }
            }
            i = y1.b(this.e);
            if (i != i4) {
                if (i != i5) {
                } else {
                    valueOf = b0();
                    m0(valueOf);
                    while (this.c < i7 += valueOf) {
                        list.add(Long.valueOf(X()));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Long.valueOf(l()));
            while (Q()) {
                list.add(Long.valueOf(l()));
            }
        }

        public void r(List<Integer> list) {
            int i4;
            int valueOf;
            int i5;
            int i3;
            int i;
            int i2;
            int obj4;
            i3 = 2;
            i5 = list;
            obj4 = y1.b(this.e);
            if (list instanceof b0 && obj4 != null) {
                i5 = list;
                obj4 = y1.b(this.e);
                if (obj4 != null) {
                    if (obj4 != i3) {
                    } else {
                        i10 += obj4;
                        while (this.c < i) {
                            (b0)(b0)i5.V(b0());
                        }
                        f0(i);
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i5.V(H());
                while (Q()) {
                    i5.V(H());
                }
            }
            i4 = y1.b(this.e);
            if (i4 != 0) {
                if (i4 != i3) {
                } else {
                    i9 += valueOf;
                    while (this.c < i) {
                        list.add(Integer.valueOf(b0()));
                    }
                    f0(i);
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Integer.valueOf(H()));
            while (Q()) {
                list.add(Integer.valueOf(H()));
            }
        }

        @Override // com.google.protobuf.g
        public double readDouble() {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // com.google.protobuf.g
        public float readFloat() {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        public void s(List<Integer> list) {
            int valueOf;
            int i5;
            int i4;
            int i;
            int i2;
            int i3;
            int obj4;
            i = 2;
            i4 = list;
            obj4 = y1.b(this.e);
            if (list instanceof b0 && obj4 != null) {
                i4 = list;
                obj4 = y1.b(this.e);
                if (obj4 != null) {
                    if (obj4 != i) {
                    } else {
                        while (this.c < i10 += obj4) {
                            (b0)(b0)i4.V(b0());
                        }
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i4.V(t());
                while (Q()) {
                    i4.V(t());
                }
            }
            i5 = y1.b(this.e);
            if (i5 != 0) {
                if (i5 != i) {
                } else {
                    while (this.c < i9 += valueOf) {
                        list.add(Integer.valueOf(b0()));
                    }
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Integer.valueOf(t()));
            while (Q()) {
                list.add(Integer.valueOf(t()));
            }
        }

        @Override // com.google.protobuf.g
        public int t() {
            g0(0);
            return b0();
        }

        public void u(List<Integer> list) {
            int i2;
            int valueOf;
            int i3;
            int i6;
            int i7;
            int i5;
            int i;
            int i4;
            i5 = 5;
            i4 = 2;
            if (list instanceof b0) {
                i3 = y1.b(this.e);
                if (i3 != i4 && i3 == i5) {
                    if (i3 != i5) {
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i6 = b0();
                l0(i6);
                while (this.c < i14 += i6) {
                    (b0)list.V(V());
                }
            } else {
                i2 = y1.b(this.e);
                if (i2 != i4 && i2 == i5) {
                    if (i2 != i5) {
                    }
                    throw InvalidProtocolBufferException.e();
                }
                valueOf = b0();
                l0(valueOf);
                while (this.c < i13 += valueOf) {
                    list.add(Integer.valueOf(V()));
                }
            }
        }

        @Override // com.google.protobuf.g
        public int v() {
            g0(0);
            return k.b(b0());
        }

        @Override // com.google.protobuf.g
        public long w() {
            g0(0);
            return k.c(c0());
        }

        public void x(List<Boolean> list) {
            int i2;
            int valueOf;
            int i4;
            int i;
            int i5;
            int i6;
            int i3;
            Object obj5;
            i5 = 1;
            i6 = 0;
            int i9 = 2;
            i = list;
            obj5 = y1.b(this.e);
            if (list instanceof h && obj5 != null) {
                i = list;
                obj5 = y1.b(this.e);
                if (obj5 != null) {
                    if (obj5 != i9) {
                    } else {
                        i11 += obj5;
                        while (this.c < i3) {
                            if (b0() != 0) {
                            } else {
                            }
                            obj5 = i6;
                            (h)(h)i.i(obj5);
                            obj5 = i5;
                        }
                        f0(i3);
                    }
                    throw InvalidProtocolBufferException.e();
                }
                i.i(j());
                while (Q()) {
                    i.i(j());
                }
            }
            i2 = y1.b(this.e);
            if (i2 != 0) {
                if (i2 != i9) {
                } else {
                    i10 += valueOf;
                    while (this.c < i3) {
                        if (b0() != 0) {
                        } else {
                        }
                        i4 = i6;
                        list.add(Boolean.valueOf(i4));
                        i4 = i5;
                    }
                    f0(i3);
                }
                throw InvalidProtocolBufferException.e();
            }
            list.add(Boolean.valueOf(j()));
            while (Q()) {
                list.add(Boolean.valueOf(j()));
            }
        }

        @Override // com.google.protobuf.g
        public String y() {
            return Z(false);
        }

        public <T> T z(Class<T> class, com.google.protobuf.q q2) {
            g0(3);
            return T(g1.a().d(class), q2);
        }
    }
    g(com.google.protobuf.g.a g$a) {
        super();
    }

    public static com.google.protobuf.g P(ByteBuffer byteBuffer, boolean z2) {
        if (!byteBuffer.hasArray()) {
        } else {
            g.b bVar = new g.b(byteBuffer, z2);
            return bVar;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Direct buffers not yet supported");
        throw obj1;
    }
}
