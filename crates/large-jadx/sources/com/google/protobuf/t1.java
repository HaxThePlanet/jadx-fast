package com.google.protobuf;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class t1 {

    private static final com.google.protobuf.t1 f;
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;
    static {
        final int i = 0;
        t1 t1Var = new t1(i, new int[i], new Object[i], i);
        t1.f = t1Var;
    }

    private t1() {
        int i = 8;
        super(0, new int[i], new Object[i], 1);
    }

    private t1(int i, int[] i2Arr2, Object[] object3Arr3, boolean z4) {
        super();
        this.d = -1;
        this.a = i;
        this.b = i2Arr2;
        this.c = object3Arr3;
        this.e = z4;
    }

    private void b() {
        int copyOf;
        int[] iArr;
        int length;
        copyOf = this.a;
        iArr = this.b;
        if (copyOf == iArr.length) {
            length = copyOf < 4 ? 8 : copyOf >> 1;
            copyOf += length;
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public static com.google.protobuf.t1 c() {
        return t1.f;
    }

    private static int f(int[] iArr, int i2) {
        int i;
        int i4;
        int i3;
        i = 17;
        i4 = 0;
        while (i4 < i2) {
            i5 += i3;
            i4++;
        }
        return i;
    }

    private static int g(Object[] objectArr, int i2) {
        int i4;
        int i;
        int i3;
        i4 = 17;
        i = 0;
        while (i < i2) {
            i5 += i3;
            i++;
        }
        return i4;
    }

    private com.google.protobuf.t1 j(com.google.protobuf.k k) {
        int i;
        i = k.F();
        while (i != 0) {
            if (i(i, k)) {
            }
            i = k.F();
        }
        return this;
    }

    static com.google.protobuf.t1 m(com.google.protobuf.t1 t1, com.google.protobuf.t1 t12) {
        i += i3;
        int[] copyOf = Arrays.copyOf(t1.b, i2);
        final int i6 = 0;
        System.arraycopy(t12.b, i6, copyOf, t1.a, t12.a);
        Object[] copyOf2 = Arrays.copyOf(t1.c, i2);
        System.arraycopy(t12.c, i6, copyOf2, t1.a, t12.a);
        t1 obj6 = new t1(i2, copyOf, copyOf2, 1);
        return obj6;
    }

    static com.google.protobuf.t1 n() {
        t1 t1Var = new t1();
        return t1Var;
    }

    private static boolean o(Object[] objectArr, Object[] object2Arr2, int i3) {
        int i;
        boolean equals;
        Object obj;
        final int i2 = 0;
        i = i2;
        while (i < i3) {
            i++;
        }
        return 1;
    }

    private static boolean r(int[] iArr, int[] i2Arr2, int i3) {
        int i2;
        int i4;
        int i;
        final int i5 = 0;
        i2 = i5;
        while (i2 < i3) {
            i2++;
        }
        return 1;
    }

    private static void t(int i, Object object2, com.google.protobuf.z1 z13) {
        int aSCENDING;
        long obj2;
        final int i2 = y1.a(i);
        obj2 = y1.b(i);
        if (obj2 != null) {
            if (obj2 != 1) {
                if (obj2 != 2) {
                    if (obj2 != 3) {
                        if (obj2 != 5) {
                        } else {
                            z13.f(i2, (Integer)object2.intValue());
                        }
                        obj2 = new RuntimeException(InvalidProtocolBufferException.e());
                        throw obj2;
                    }
                    if (z13.l() == z1.a.ASCENDING) {
                        z13.u(i2);
                        (t1)object2.u(z13);
                        z13.H(i2);
                    } else {
                        z13.H(i2);
                        (t1)object2.u(z13);
                        z13.u(i2);
                    }
                } else {
                    z13.v(i2, (j)object2);
                }
            } else {
                z13.k(i2, (Long)object2.longValue());
            }
        } else {
            z13.q(i2, (Long)object2.longValue());
        }
    }

    void a() {
        if (!this.e) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int d() {
        int i;
        int i2;
        int i3;
        int i4;
        long longValue;
        long l;
        int i5 = this.d;
        if (i5 != -1) {
            return i5;
        }
        i2 = i;
        while (i < this.a) {
            int i8 = this.b[i];
            i4 = y1.a(i8);
            int i9 = y1.b(i8);
            i3 = CodedOutputStream.Z(i4, (Long)this.c[i].longValue());
            i2 += i3;
            i++;
            i3 = CodedOutputStream.p(i4, (Long)this.c[i].longValue());
            longValue = 2;
            i3 = CodedOutputStream.h(i4, (j)this.c[i]);
            i11 += i4;
            i3 = CodedOutputStream.n(i4, (Integer)this.c[i].intValue());
        }
        this.d = i2;
        return i2;
    }

    public int e() {
        int i;
        int i3;
        int i2;
        Object obj;
        int i4 = this.d;
        if (i4 != -1) {
            return i4;
        }
        i3 = i;
        while (i < this.a) {
            i3 += i2;
            i++;
        }
        this.d = i3;
        return i3;
    }

    public boolean equals(Object object) {
        int i;
        int i2;
        int[] iArr;
        Object obj6;
        final int i3 = 1;
        if (this == object) {
            return i3;
        }
        final int i4 = 0;
        if (object == null) {
            return i4;
        }
        if (!object instanceof t1) {
            return i4;
        }
        i = this.a;
        if (i == object.a && t1.r(this.b, object.b, i) && !t1.o(this.c, object.c, this.a)) {
            if (t1.r(this.b, object.b, i)) {
                if (!t1.o(this.c, object.c, this.a)) {
                }
                return i3;
            }
        }
        return i4;
    }

    public void h() {
        this.e = false;
    }

    public int hashCode() {
        int i = this.a;
        return i8 += i3;
    }

    boolean i(int i, com.google.protobuf.k k2) {
        a();
        int i5 = y1.b(i);
        final int i6 = 1;
        final int i9 = 4;
        if (i5 != 0 && i5 != i6 && i5 != 2 && i5 != 3 && i5 != i9) {
            if (i5 != i6) {
                if (i5 != 2) {
                    i9 = 4;
                    if (i5 != 3) {
                        if (i5 != i9) {
                            if (i5 != 5) {
                            } else {
                                q(i, Integer.valueOf(k2.t()));
                                return i6;
                            }
                            throw InvalidProtocolBufferException.e();
                        }
                        return 0;
                    }
                    t1 t1Var = new t1();
                    t1Var.j(k2);
                    k2.a(y1.c(y1.a(i), i9));
                    q(i, t1Var);
                    return i6;
                }
                q(i, k2.q());
                return i6;
            }
            q(i, Long.valueOf(k2.u()));
            return i6;
        }
        q(i, Long.valueOf(k2.x()));
        return i6;
    }

    com.google.protobuf.t1 k(int i, com.google.protobuf.j j2) {
        a();
        if (i == 0) {
        } else {
            q(y1.c(i, 2), j2);
            return this;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Zero is not a valid field number.");
        throw obj2;
    }

    com.google.protobuf.t1 l(int i, int i2) {
        a();
        if (i == 0) {
        } else {
            q(y1.c(i, 0), Long.valueOf((long)i2));
            return this;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Zero is not a valid field number.");
        throw obj3;
    }

    final void p(StringBuilder stringBuilder, int i2) {
        int i;
        String valueOf;
        Object obj;
        i = 0;
        while (i < this.a) {
            v0.c(stringBuilder, i2, String.valueOf(y1.a(this.b[i])), this.c[i]);
            i++;
        }
    }

    void q(int i, Object object2) {
        a();
        b();
        int i2 = this.a;
        this.b[i2] = i;
        this.c[i2] = object2;
        this.a = i2++;
    }

    void s(com.google.protobuf.z1 z1) {
        int i;
        com.google.protobuf.z1.a dESCENDING;
        Object obj;
        if (z1.l() == z1.a.DESCENDING) {
            i2--;
            while (i >= 0) {
                z1.e(y1.a(this.b[i]), this.c[i]);
                i--;
            }
        } else {
            i = 0;
            while (i < this.a) {
                z1.e(y1.a(this.b[i]), this.c[i]);
                i++;
            }
        }
    }

    public void u(com.google.protobuf.z1 z1) {
        int i;
        com.google.protobuf.z1.a aSCENDING;
        Object obj;
        if (this.a == 0) {
        }
        if (z1.l() == z1.a.ASCENDING) {
            i = 0;
            while (i < this.a) {
                t1.t(this.b[i], this.c[i], z1);
                i++;
            }
        } else {
            i3--;
            while (i >= 0) {
                t1.t(this.b[i], this.c[i], z1);
                i--;
            }
        }
    }
}
