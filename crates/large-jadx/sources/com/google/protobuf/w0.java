package com.google.protobuf;

import android.accounts.Account;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class w0<T>  implements com.google.protobuf.l1<T> {

    private static final int[] r;
    private static final Unsafe s;
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final com.google.protobuf.t0 e;
    private final boolean f = false;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int l;
    private final com.google.protobuf.y0 m;
    private final com.google.protobuf.j0 n;
    private final com.google.protobuf.s1<?, ?> o;
    private final com.google.protobuf.r<?> p;
    private final com.google.protobuf.o0 q;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            w0.a.a = iArr;
            iArr[y1.b.BOOL.ordinal()] = 1;
            w0.a.a[y1.b.BYTES.ordinal()] = 2;
            w0.a.a[y1.b.DOUBLE.ordinal()] = 3;
            w0.a.a[y1.b.FIXED32.ordinal()] = 4;
            w0.a.a[y1.b.SFIXED32.ordinal()] = 5;
            w0.a.a[y1.b.FIXED64.ordinal()] = 6;
            w0.a.a[y1.b.SFIXED64.ordinal()] = 7;
            w0.a.a[y1.b.FLOAT.ordinal()] = 8;
            w0.a.a[y1.b.ENUM.ordinal()] = 9;
            w0.a.a[y1.b.INT32.ordinal()] = 10;
            w0.a.a[y1.b.UINT32.ordinal()] = 11;
            w0.a.a[y1.b.INT64.ordinal()] = 12;
            w0.a.a[y1.b.UINT64.ordinal()] = 13;
            w0.a.a[y1.b.MESSAGE.ordinal()] = 14;
            w0.a.a[y1.b.SINT32.ordinal()] = 15;
            w0.a.a[y1.b.SINT64.ordinal()] = 16;
            w0.a.a[y1.b.STRING.ordinal()] = 17;
        }
    }
    static {
        w0.r = new int[0];
        w0.s = w1.H();
    }

    private w0(int[] iArr, Object[] object2Arr2, int i3, int i4, com.google.protobuf.t0 t05, boolean z6, boolean z7, int[] i8Arr8, int i9, int i10, com.google.protobuf.y0 y011, com.google.protobuf.j0 j012, com.google.protobuf.s1<?, ?> s113, com.google.protobuf.r<?> r14, com.google.protobuf.o0 o015) {
        boolean obj1;
        super();
        this.a = iArr;
        this.b = object2Arr2;
        this.c = i3;
        this.d = i4;
        this.g = t05 instanceof z;
        this.h = z6;
        if (r14 != null && r14.e(t05)) {
            obj1 = r14.e(t05) ? 1 : obj1;
        }
        obj1 = 0;
        this.i = z7;
        this.j = i8Arr8;
        this.k = i9;
        this.l = i10;
        this.m = y011;
        this.n = j012;
        this.o = s113;
        this.p = r14;
        this.e = t05;
        this.q = o015;
    }

    private static <T> int A(T t, long l2) {
        return w1.C(t, l2);
    }

    private static boolean B(int i) {
        int obj1;
        obj1 = i &= i2 != 0 ? 1 : 0;
        return obj1;
    }

    private boolean C(T t, int i2) {
        int i;
        int i3 = i0(i2);
        long l2 = (long)i6;
        i = 0;
        final int i9 = 1;
        if (Long.compare(l2, i8) == 0) {
            int obj8 = s0(i2);
            long l = w0.V(obj8);
            final int i7 = 0;
            switch (obj8) {
                case 0:
                    i = i9;
                    return i;
                case 1:
                    i = i9;
                    return i;
                case 2:
                    i = i9;
                    return i;
                case 3:
                    i = i9;
                    return i;
                case 4:
                    i = i9;
                    return i;
                case 5:
                    i = i9;
                    return i;
                case 6:
                    i = i9;
                    return i;
                case 7:
                    return w1.t(t, l);
                case 8:
                    Object obj7 = w1.G(t, l);
                    return obj7 ^= i9;
                    return obj7 ^= i9;
                    obj7 = new IllegalArgumentException();
                    throw obj7;
                case 9:
                    i = i9;
                    return i;
                case 10:
                    return obj7 ^= i9;
                case 11:
                    i = i9;
                    return i;
                case 12:
                    i = i9;
                    return i;
                case 13:
                    i = i9;
                    return i;
                case 14:
                    i = i9;
                    return i;
                case 15:
                    i = i9;
                    return i;
                case 16:
                    i = i9;
                    return i;
                case 17:
                    i = i9;
                    return i;
                default:
                    obj7 = new IllegalArgumentException();
                    throw obj7;
            }
        }
        if (obj7 &= obj8 != 0) {
            i = i9;
        }
        return i;
    }

    private boolean D(T t, int i2, int i3, int i4, int i5) {
        int obj2;
        if (i3 == 1048575) {
            return C(t, i2);
        }
        obj2 = i4 & i5 != 0 ? 1 : 0;
        return obj2;
    }

    private static boolean E(Object object, int i2, com.google.protobuf.l1 l13) {
        return l13.d(w1.G(object, w0.V(i2)));
    }

    private <N> boolean F(Object object, int i2, int i3) {
        int i;
        boolean z;
        final Object obj4 = w1.G(object, w0.V(i2));
        int i4 = 1;
        if ((List)obj4.isEmpty()) {
            return i4;
        }
        final int obj6 = 0;
        i = obj6;
        while (i < obj4.size()) {
            i++;
        }
        return i4;
    }

    private boolean G(T t, int i2, int i3) {
        long class;
        int obj5;
        com.google.protobuf.y1.c obj6;
        Map obj4 = this.q.h(w1.G(t, w0.V(i2)));
        int i = 1;
        if (obj4.isEmpty()) {
            return i;
        }
        if (obj5.c.getJavaType() != y1.c.MESSAGE) {
            return i;
        }
        obj5 = 0;
        obj4 = obj4.values().iterator();
        while (obj4.hasNext()) {
            obj6 = obj4.next();
            if (obj5 == null) {
            }
            obj5 = g1.a().d(obj6.getClass());
        }
        return i;
    }

    private boolean H(T t, T t2, int i3) {
        int obj3;
        long l = (long)obj5;
        obj3 = w1.C(t, l) == w1.C(t2, l) ? 1 : 0;
        return obj3;
    }

    private boolean I(T t, int i2, int i3) {
        int obj3;
        obj3 = w1.C(t, (long)obj5) == i2 ? 1 : 0;
        return obj3;
    }

    private static boolean J(int i) {
        int obj1;
        obj1 = i &= i2 != 0 ? 1 : 0;
        return obj1;
    }

    private static List<?> K(Object object, long l2) {
        return (List)w1.G(object, l2);
    }

    private static <T> long L(T t, long l2) {
        return w1.E(t, l2);
    }

    private <UT, UB, ET extends com.google.protobuf.v.b<ET>> void M(com.google.protobuf.s1<UT, UB> s1, com.google.protobuf.r<ET> r2, T t3, com.google.protobuf.j1 j14, com.google.protobuf.q q5) {
        int i2;
        int i4;
        int i6;
        boolean arr;
        int valueOf;
        int i3;
        int double;
        com.google.protobuf.j1 inRange;
        long double2;
        long l;
        Object obj;
        int i5;
        int i;
        boolean z;
        final Object obj8 = this;
        final com.google.protobuf.s1 s1Var = s1;
        final Object obj9 = t3;
        com.google.protobuf.j1 j1Var = j14;
        final com.google.protobuf.q qVar = q5;
        final int i16 = 0;
        i = i5;
        arr = j14.A();
        i3 = obj8.g0(arr);
        while (i3 < 0) {
            if (!obj8.f) {
            } else {
            }
            i3 = arr;
            if (i5 == 0) {
            }
            if (s1Var.m(i5, j1Var)) {
                break;
            }
            arr = j14.A();
            i3 = obj8.g0(arr);
            z = r2;
            double = obj8.s0(i3);
            valueOf = w0.r0(double);
            if (i5 == 0) {
            }
            i5 = s1.n();
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            valueOf = j14.t();
            inRange = obj8.t(i3);
            if (inRange != null) {
            } else {
            }
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            if (inRange.isInRange(valueOf)) {
            } else {
            }
            i5 = n1.L(arr, valueOf, i5, s1Var);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            if (obj8.I(obj9, arr, i3)) {
            } else {
            }
            w1.V(obj9, w0.V(double), inRange);
            obj8.o0(obj9, i3);
            obj8.p0(obj9, arr, i3);
            inRange = j1Var.C(obj8.v(i3), qVar);
            w1.V(obj9, w0.V(double), inRange);
            obj8.l0(obj9, double, j1Var);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            w1.V(obj9, w0.V(double), inRange);
            obj8.p0(obj9, arr, i3);
            this.N(t3, i3, obj8.u(i3), q5, j14);
            double = w0.V(double);
            this.j0(t3, double, double, j14, obj8.v(i3));
            j1Var.e(obj8.n.e(obj9, w0.V(double)));
            j1Var.a(obj8.n.e(obj9, w0.V(double)));
            j1Var.q(obj8.n.e(obj9, w0.V(double)));
            j1Var.d(obj8.n.e(obj9, w0.V(double)));
            valueOf = obj8.n.e(obj9, w0.V(double));
            j1Var.s(valueOf);
            i5 = n1.A(arr, valueOf, obj8.t(i3), i5, s1Var);
            j1Var.g(obj8.n.e(obj9, w0.V(double)));
            j1Var.x(obj8.n.e(obj9, w0.V(double)));
            j1Var.u(obj8.n.e(obj9, w0.V(double)));
            j1Var.O(obj8.n.e(obj9, w0.V(double)));
            j1Var.r(obj8.n.e(obj9, w0.V(double)));
            j1Var.m(obj8.n.e(obj9, w0.V(double)));
            j1Var.p(obj8.n.e(obj9, w0.V(double)));
            j1Var.G(obj8.n.e(obj9, w0.V(double)));
            j1Var.L(obj8.n.e(obj9, w0.V(double)));
            j1Var.e(obj8.n.e(obj9, w0.V(double)));
            j1Var.a(obj8.n.e(obj9, w0.V(double)));
            j1Var.q(obj8.n.e(obj9, w0.V(double)));
            j1Var.d(obj8.n.e(obj9, w0.V(double)));
            valueOf = obj8.n.e(obj9, w0.V(double));
            j1Var.s(valueOf);
            i5 = n1.A(arr, valueOf, obj8.t(i3), i5, s1Var);
            j1Var.g(obj8.n.e(obj9, w0.V(double)));
            j1Var.K(obj8.n.e(obj9, w0.V(double)));
            this.k0(t3, double, j14, obj8.v(i3), q5);
            obj8.m0(obj9, double, j1Var);
            j1Var.x(obj8.n.e(obj9, w0.V(double)));
            j1Var.u(obj8.n.e(obj9, w0.V(double)));
            j1Var.O(obj8.n.e(obj9, w0.V(double)));
            j1Var.r(obj8.n.e(obj9, w0.V(double)));
            j1Var.m(obj8.n.e(obj9, w0.V(double)));
            j1Var.p(obj8.n.e(obj9, w0.V(double)));
            j1Var.G(obj8.n.e(obj9, w0.V(double)));
            j1Var.L(obj8.n.e(obj9, w0.V(double)));
            if (obj8.C(obj9, i3)) {
            } else {
            }
            w1.V(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.V(obj9, w0.V(double), i3);
            w1.U(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.T(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.U(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.T(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            valueOf = j14.t();
            inRange = obj8.t(i3);
            if (inRange != null) {
            } else {
            }
            w1.T(obj9, w0.V(double), inRange);
            obj8.o0(obj9, i3);
            if (inRange.isInRange(valueOf)) {
            } else {
            }
            i5 = n1.L(arr, valueOf, i5, s1Var);
            w1.T(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.V(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            if (obj8.C(obj9, i3)) {
            } else {
            }
            w1.V(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.V(obj9, w0.V(double), i3);
            obj8.l0(obj9, double, j1Var);
            obj8.o0(obj9, i3);
            w1.L(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.T(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.U(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.T(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.U(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.U(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.S(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            w1.R(obj9, w0.V(double), valueOf);
            obj8.o0(obj9, i3);
            i5 = s1Var.f(obj9);
            if (j14.I()) {
                break;
            }
            if (i == 0) {
            }
            i5 = r2.g(j14, i3, q5, i, i5, s1);
            i = r2.d(t3);
            z = r2;
            i3 = i16;
        }
        i6 = obj8.k;
        while (i6 < obj8.l) {
            i5 = obj8.q(obj9, obj8.j[i6], i5, s1Var);
            i6++;
        }
        if (i5 != 0) {
            s1Var.o(obj9, i5);
        }
    }

    private final <K, V> void N(Object object, int i2, Object object3, com.google.protobuf.q q4, com.google.protobuf.j1 j15) {
        boolean z;
        com.google.protobuf.o0 o0Var;
        Object obj6;
        final long l = w0.V(s0(i2));
        obj6 = w1.G(object, l);
        if (obj6 == null) {
            w1.V(object, l, obj1);
        } else {
            if (this.q.g(obj6)) {
                z = this.q.e(object3);
                this.q.a(z, obj6);
                w1.V(object, l, obj1);
                obj6 = z;
            }
        }
        j15.D(this.q.d(obj6), this.q.c(object3), q4);
    }

    private void O(T t, T t2, int i3) {
        Object obj5;
        long l = w0.V(s0(i3));
        if (!C(t2, i3)) {
        }
        Object obj = w1.G(t, l);
        obj5 = w1.G(t2, l);
        if (obj != null && obj5 != null) {
            if (obj5 != null) {
                w1.V(t, l, obj1);
                o0(t, i3);
            } else {
                if (obj5 != null) {
                    w1.V(t, l, obj1);
                    o0(t, i3);
                }
            }
        } else {
        }
    }

    private void P(T t, T t2, int i3) {
        int i;
        Object obj7;
        final int i4 = U(i3);
        final long l = w0.V(s0(i3));
        if (!I(t2, i4, i3)) {
        }
        i = 0;
        if (I(t, i4, i3)) {
            i = w1.G(t, l);
        }
        obj7 = w1.G(t2, l);
        if (i != 0 && obj7 != null) {
            if (obj7 != null) {
                w1.V(t, l, obj3);
                p0(t, i4, i3);
            } else {
                if (obj7 != null) {
                    w1.V(t, l, obj3);
                    p0(t, i4, i3);
                }
            }
        } else {
        }
    }

    private void Q(T t, T t2, int i3) {
        boolean i4;
        int i;
        Object obj7;
        int obj8;
        int i5 = s0(i3);
        final long l = w0.V(i5);
        i = U(i3);
        switch (i4) {
            case 0:
                w1.R(t, l, obj2);
                o0(t, i3);
                break;
            case 1:
                w1.S(t, l, obj2);
                o0(t, i3);
                break;
            case 2:
                w1.U(t, l, obj2);
                o0(t, i3);
                break;
            case 3:
                w1.U(t, l, obj2);
                o0(t, i3);
                break;
            case 4:
                w1.T(t, l, obj2);
                o0(t, i3);
                break;
            case 5:
                w1.U(t, l, obj2);
                o0(t, i3);
                break;
            case 6:
                w1.T(t, l, obj2);
                o0(t, i3);
                break;
            case 7:
                w1.L(t, l, obj2);
                o0(t, i3);
                break;
            case 8:
                w1.V(t, l, obj2);
                o0(t, i3);
                break;
            case 9:
                O(t, t2, i3);
                break;
            case 10:
                w1.V(t, l, obj2);
                o0(t, i3);
                break;
            case 11:
                w1.T(t, l, obj2);
                o0(t, i3);
                break;
            case 12:
                w1.T(t, l, obj2);
                o0(t, i3);
                break;
            case 13:
                w1.T(t, l, obj2);
                o0(t, i3);
                break;
            case 14:
                w1.U(t, l, obj2);
                o0(t, i3);
                break;
            case 15:
                w1.T(t, l, obj2);
                o0(t, i3);
                break;
            case 16:
                w1.U(t, l, obj2);
                o0(t, i3);
                break;
            case 17:
                O(t, t2, i3);
                break;
            case 18:
                this.n.d(t, t2, l);
                break;
            case 19:
                n1.F(this.q, t, t2, l);
                break;
            case 20:
                w1.V(t, l, obj2);
                p0(t, i, i3);
                break;
            case 21:
                P(t, t2, i3);
                break;
            case 22:
                w1.V(t, l, obj2);
                p0(t, i, i3);
                break;
            case 23:
                P(t, t2, i3);
                break;
            default:
        }
    }

    static <T> com.google.protobuf.w0<T> R(Class<T> class, com.google.protobuf.r0 r02, com.google.protobuf.y0 y03, com.google.protobuf.j0 j04, com.google.protobuf.s1<?, ?> s15, com.google.protobuf.r<?> r6, com.google.protobuf.o0 o07) {
        if (r02 instanceof i1) {
            return w0.T((i1)r02, y03, j04, s15, r6, o07);
        }
        return w0.S((p1)r02, y03, j04, s15, r6, o07);
    }

    static <T> com.google.protobuf.w0<T> S(com.google.protobuf.p1 p1, com.google.protobuf.y0 y02, com.google.protobuf.j0 j03, com.google.protobuf.s1<?, ?> s14, com.google.protobuf.r<?> r5, com.google.protobuf.o0 o06) {
        com.google.protobuf.f1 f1Var;
        int[] iArr;
        int i;
        int i3 = 0;
        i = p1.c() == f1.PROTO3 ? f1Var : i3;
        com.google.protobuf.u[] objArr = p1.e();
        int i4 = 0;
        if (objArr.length != 0) {
        } else {
            int length3 = objArr.length;
            if (objArr.length > 0) {
            } else {
                if (p1.d() == null) {
                    iArr = w0.r;
                }
                if (objArr.length > 0) {
                } else {
                    int[] iArr2 = w0.r;
                    int[] iArr3 = w0.r;
                    final int[] iArr5 = new int[i8 += length12];
                    System.arraycopy(iArr, i3, iArr5, i3, iArr.length);
                    System.arraycopy(iArr2, i3, iArr5, iArr.length, iArr2.length);
                    System.arraycopy(iArr3, i3, iArr5, length10 += length14, iArr3.length);
                    super(new int[length3 * 3], new Object[length3 *= 2], 0, 0, p1.b(), i, 1, iArr5, iArr.length, length5 + length, y02, j03, s14, r5, o06);
                    return w0Var;
                }
                objArr[i3].a();
                throw i4;
            }
            objArr[i3].c();
            throw i4;
        }
        objArr[i3].a();
        throw i4;
    }

    static <T> com.google.protobuf.w0<T> T(com.google.protobuf.i1 i1, com.google.protobuf.y0 y02, com.google.protobuf.j0 j03, com.google.protobuf.s1<?, ?> s14, com.google.protobuf.r<?> r5, com.google.protobuf.o0 o06) {
        String str2;
        int i46;
        int length;
        int i5;
        int i63;
        char charAt12;
        int i42;
        char charAt10;
        int i55;
        int i13;
        int i16;
        int i;
        char charAt6;
        int i62;
        int i14;
        char charAt7;
        int i31;
        int i37;
        int charAt4;
        char charAt11;
        int i47;
        int i34;
        int charAt15;
        int i17;
        int i49;
        int i35;
        char charAt9;
        char c4;
        int i57;
        char charAt8;
        int i19;
        int i64;
        char charAt14;
        int i66;
        int i65;
        int i33;
        int i56;
        int i30;
        char charAt13;
        Object obj;
        int i10;
        int i18;
        int i38;
        int i25;
        int i20;
        int i6;
        char charAt2;
        int i27;
        int i8;
        int i4;
        char charAt5;
        int i28;
        int i7;
        int i61;
        Object obj2;
        boolean z;
        int i2;
        int i70;
        int i58;
        int i15;
        int i41;
        int i21;
        int i22;
        int i29;
        int i44;
        int[] iArr;
        int i39;
        int i51;
        char charAt;
        int i50;
        char charAt3;
        int i43;
        int i45;
        int i48;
        int i40;
        char c;
        int i52;
        int i24;
        int i67;
        int i3;
        int i53;
        Object obj3;
        int i9;
        int i11;
        int i59;
        char c5;
        int i54;
        char c3;
        int i26;
        int i12;
        int i32;
        int i60;
        int type;
        int i23;
        int i68;
        int i36;
        String str;
        int i69;
        char c2;
        int i81 = 0;
        i6 = i1.c() == f1.PROTO3 ? 1 : i81;
        str2 = i1.e();
        length = str2.length();
        charAt15 = 55296;
        if (str2.charAt(i81) >= charAt15) {
            i34 = 1;
            while (str2.charAt(i34) >= charAt15) {
                i34 = i49;
            }
        } else {
            i49 = 1;
        }
        i31 = i49 + 1;
        charAt9 = str2.charAt(i49);
        if (charAt9 >= charAt15) {
            charAt9 &= 8191;
            i64 = 13;
            i30 = i31 + 1;
            char charAt17 = str2.charAt(i31);
            while (charAt17 >= charAt15) {
                i35 |= i91;
                i64 += 13;
                i31 = i30;
                i30 = i31 + 1;
                charAt17 = str2.charAt(i31);
            }
            i35 |= i89;
            i31 = i30;
        }
        if (charAt9 == 0) {
            iArr = iArr3;
            c4 = i53;
        } else {
            i57 = i31 + 1;
            charAt11 = str2.charAt(i31);
            if (charAt11 >= charAt15) {
                charAt11 &= 8191;
                i64 = 13;
                i30 = i57 + 1;
                char charAt18 = str2.charAt(i57);
                while (charAt18 >= charAt15) {
                    i47 |= i97;
                    i64 += 13;
                    i57 = i30;
                    i30 = i57 + 1;
                    charAt18 = str2.charAt(i57);
                }
                i47 |= i95;
                i57 = i30;
            }
            i33 = i57 + 1;
            charAt8 = str2.charAt(i57);
            if (charAt8 >= charAt15) {
                charAt8 &= 8191;
                i30 = 13;
                i27 = i33 + 1;
                char charAt19 = str2.charAt(i33);
                while (charAt19 >= charAt15) {
                    i19 |= i103;
                    i30 += 13;
                    i33 = i27;
                    i27 = i33 + 1;
                    charAt19 = str2.charAt(i33);
                }
                i19 |= i101;
                i33 = i27;
            }
            i25 = i33 + 1;
            charAt14 = str2.charAt(i33);
            if (charAt14 >= charAt15) {
                charAt14 &= 8191;
                i27 = 13;
                i22 = i25 + 1;
                char charAt21 = str2.charAt(i25);
                while (charAt21 >= charAt15) {
                    i56 |= i111;
                    i27 += 13;
                    i25 = i22;
                    i22 = i25 + 1;
                    charAt21 = str2.charAt(i25);
                }
                i56 |= i109;
                i25 = i22;
            }
            i8 = i25 + 1;
            charAt13 = str2.charAt(i25);
            if (charAt13 >= charAt15) {
                charAt13 &= 8191;
                i22 = 13;
                i39 = i8 + 1;
                char charAt22 = str2.charAt(i8);
                while (charAt22 >= charAt15) {
                    i20 |= i117;
                    i22 += 13;
                    i8 = i39;
                    i39 = i8 + 1;
                    charAt22 = str2.charAt(i8);
                }
                i20 |= i115;
                i8 = i39;
            }
            i29 = i8 + 1;
            charAt2 = str2.charAt(i8);
            if (charAt2 >= charAt15) {
                charAt2 &= 8191;
                i39 = 13;
                i52 = i29 + 1;
                char charAt23 = str2.charAt(i29);
                while (charAt23 >= charAt15) {
                    i4 |= i134;
                    i39 += 13;
                    i29 = i52;
                    i52 = i29 + 1;
                    charAt23 = str2.charAt(i29);
                }
                i4 |= i132;
                i29 = i52;
            }
            i51 = i29 + 1;
            charAt5 = str2.charAt(i29);
            if (charAt5 >= charAt15) {
                charAt5 &= 8191;
                i52 = 13;
                i3 = i51 + 1;
                char charAt24 = str2.charAt(i51);
                while (charAt24 >= charAt15) {
                    i44 |= i138;
                    i52 += 13;
                    i51 = i3;
                    i3 = i51 + 1;
                    charAt24 = str2.charAt(i51);
                }
                i44 |= i136;
                i51 = i3;
            }
            i24 = i51 + 1;
            charAt = str2.charAt(i51);
            if (charAt >= charAt15) {
                charAt &= 8191;
                i3 = 13;
                i9 = i24 + 1;
                char charAt26 = str2.charAt(i24);
                while (charAt26 >= charAt15) {
                    i50 |= i145;
                    i3 += 13;
                    i24 = i9;
                    i9 = i24 + 1;
                    charAt26 = str2.charAt(i24);
                }
                i50 |= i143;
                i24 = i9;
            }
            i3 = i24 + 1;
            charAt3 = str2.charAt(i24);
            if (charAt3 >= charAt15) {
                charAt3 &= 8191;
                i9 = 13;
                i11 = i3 + 1;
                char charAt27 = str2.charAt(i3);
                while (charAt27 >= charAt15) {
                    i67 |= i148;
                    i9 += 13;
                    i3 = i11;
                    i11 = i3 + 1;
                    charAt27 = str2.charAt(i3);
                }
                i67 |= i146;
                i3 = i11;
            }
            iArr = new int[charAt += i149];
            i150 += charAt8;
            c4 = charAt11;
            i31 = i3;
        }
        Unsafe unsafe = w0.s;
        Object[] objArr2 = i1.d();
        Class class = i1.b().getClass();
        int[] iArr4 = new int[charAt2 * 3];
        Object[] arr = new Object[charAt2 *= 2];
        final int i151 = charAt3 + charAt5;
        c5 = charAt3;
        i54 = i151;
        i28 = 0;
        i59 = 0;
        while (i31 < length) {
            i26 = i31 + 1;
            charAt4 = str2.charAt(i31);
            if (charAt4 >= charAt15) {
            } else {
            }
            i = i26;
            i12 = i + 1;
            charAt6 = str2.charAt(i);
            if (charAt6 >= charAt15) {
            } else {
            }
            i23 = length;
            i5 = i12;
            int i93 = charAt6 & 255;
            if (charAt6 & 1024 != 0) {
            }
            if (i93 >= 51) {
            } else {
            }
            c = charAt14;
            c2 = charAt13;
            i65 = i53 + 1;
            Field field = w0.n0(class, (String)objArr2[i53]);
            if (i93 != 9) {
            } else {
            }
            i32 = 1;
            arr[i126++] = field.getType();
            i21 = i65;
            if (charAt6 & 4096 == 4096) {
            } else {
            }
            i18 = 0;
            if (i18 != 0 && i93 <= 17) {
            } else {
            }
            str = str2;
            i46 = i6;
            i10 = 1048575;
            i68 = i5;
            i42 = 0;
            if (i93 >= 18 && i93 <= 49) {
            }
            i53 = type;
            int i112 = i59 + 1;
            iArr4[i59] = charAt4;
            int i92 = i112 + 1;
            if (charAt6 & 512 != 0) {
            } else {
            }
            i2 = 0;
            if (charAt6 &= 256 != 0) {
            } else {
            }
            i62 = 0;
            iArr4[i112] = i88 |= i66;
            i59 = i92 + 1;
            iArr4[i92] = i75 |= i10;
            i6 = i46;
            charAt14 = c;
            charAt3 = c3;
            length = i23;
            i31 = i68;
            i28 = i36;
            str2 = str;
            charAt13 = c2;
            charAt15 = 55296;
            i62 = 268435456;
            i2 = 536870912;
            if (i93 <= 49) {
            }
            iArr[i54] = (int)objectFieldOffset3;
            i54 = i6;
            if (i93 <= 17) {
            } else {
            }
            charAt10 = str2.charAt(i5);
            int i131 = 55296;
            if (charAt10 >= i131) {
            } else {
            }
            i68 = i38;
            i105 += i60;
            z = objArr2[i106];
            str = str2;
            if (z instanceof Field) {
            } else {
            }
            objArr2[i106] = w0.n0(class, (String)z);
            i46 = i6;
            i10 = (int)objectFieldOffset4;
            charAt10 %= 32;
            charAt10 &= 8191;
            i60 = 13;
            char charAt20 = str2.charAt(i38);
            while (charAt20 >= i131) {
                i55 |= i108;
                i60 += 13;
                i38 = i68;
                charAt20 = str2.charAt(i38);
            }
            i55 |= i38;
            i55 |= i108;
            i60 += 13;
            i38 = i68;
            i18 = i32;
            if (i93 == 17) {
            } else {
            }
            if (i93 != 27) {
            } else {
            }
            i32 = 1;
            type = i65 + 1;
            arr[i128++] = objArr2[i65];
            i21 = type;
            if (i93 == 49) {
            } else {
            }
            if (i93 != 12 && i93 != 30) {
            } else {
            }
            if (i6 == 0) {
            } else {
            }
            i32 = 1;
            i32 = 1;
            type = i65 + 1;
            arr[i130++] = objArr2[i65];
            if (i93 != 30) {
            } else {
            }
            if (i93 == 44) {
            } else {
            }
            if (i93 == 50) {
            } else {
            }
            i70 = c5 + 1;
            iArr[c5] = i59;
            i152 *= 2;
            type = i65 + 1;
            arr[i153] = objArr2[i65];
            if (charAt6 & 2048 != 0) {
            } else {
            }
            c5 = i70;
            i21 = type;
            i32 = 1;
            i65 = type + 1;
            arr[i153++] = objArr2[type];
            c5 = i70;
            i45 = i5 + 1;
            charAt12 = str2.charAt(i5);
            if (charAt12 >= 55296) {
            }
            i61 = i93 + -51;
            if (i61 != 9) {
            } else {
            }
            i48 = i53 + 1;
            arr[i121 += i140] = objArr2[i53];
            i53 = i48;
            charAt12 *= 2;
            obj2 = objArr2[i72];
            if (obj2 instanceof Field) {
            } else {
            }
            objArr2[i72] = w0.n0(class, (String)obj2);
            c = charAt14;
            c2 = charAt13;
            i72++;
            obj = objArr2[i73];
            if (obj instanceof Field) {
            } else {
            }
            objArr2[i73] = w0.n0(class, (String)obj);
            str = str2;
            i10 = i100;
            i46 = i6;
            i68 = i69;
            i32 = 1;
            i66 = i74;
            i42 = 0;
            if (i61 == 17) {
            } else {
            }
            if (i61 == 12 && i6 == 0) {
            }
            if (i6 == 0) {
            }
            i48 = i53 + 1;
            arr[i123 += i141] = objArr2[i53];
            charAt12 &= 8191;
            i69 = 13;
            c2 = i45 + 1;
            char charAt25 = str2.charAt(i45);
            while (charAt25 >= i7) {
                i63 |= i119;
                i69 += 13;
                i45 = c2;
                i7 = 55296;
                c2 = i45 + 1;
                charAt25 = str2.charAt(i45);
            }
            i63 |= i7;
            i45 = c2;
            i63 |= i119;
            i69 += 13;
            i45 = c2;
            i7 = 55296;
            iArr[i28] = i59;
            i28 = i43;
            charAt6 &= 8191;
            i17 = i12;
            i12 = 13;
            type = i17 + 1;
            charAt15 = str2.charAt(i17);
            while (charAt15 >= 55296) {
                i14 |= i80;
                i12 += 13;
                i17 = type;
                length = i23;
                type = i17 + 1;
                charAt15 = str2.charAt(i17);
            }
            i14 |= i78;
            i5 = type;
            i14 |= i80;
            i12 += 13;
            i17 = type;
            length = i23;
            charAt4 &= 8191;
            i16 = i26;
            i26 = 13;
            i60 = i16 + 1;
            char charAt16 = str2.charAt(i16);
            while (charAt16 >= charAt15) {
                i37 |= i85;
                i26 += 13;
                i16 = i60;
                i60 = i16 + 1;
                charAt16 = str2.charAt(i16);
            }
            i37 |= i83;
            i = i60;
            i37 |= i85;
            i26 += 13;
            i16 = i60;
        }
        int i71 = i6;
        super(iArr4, arr, charAt14, charAt13, i1.b(), i6, 0, iArr, charAt3, i151, y02, j03, s14, r5, o06);
        return w0Var;
    }

    private int U(int i) {
        return this.a[i];
    }

    private static long V(int i) {
        return (long)obj2;
    }

    private static <T> boolean W(T t, long l2) {
        return (Boolean)w1.G(t, l2).booleanValue();
    }

    private static <T> double X(T t, long l2) {
        return (Double)w1.G(t, l2).doubleValue();
    }

    private static <T> float Y(T t, long l2) {
        return (Float)w1.G(t, l2).floatValue();
    }

    private static <T> int Z(T t, long l2) {
        return (Integer)w1.G(t, l2).intValue();
    }

    private static <T> long a0(T t, long l2) {
        return (Long)w1.G(t, l2).longValue();
    }

    private <K, V> int b0(T t, byte[] b2Arr2, int i3, int i4, int i5, long l6, com.google.protobuf.f.b f$b7) {
        Object object;
        boolean z;
        com.google.protobuf.o0 o0Var;
        final Object obj4 = this;
        Object obj = t;
        long l = l6;
        Unsafe unsafe = w0.s;
        int i7 = i5;
        Object obj3 = u(i5);
        object = unsafe.getObject(t, l);
        if (obj4.q.g(object)) {
            z = obj4.q.e(obj3);
            obj4.q.a(z, object);
            unsafe.putObject(t, l, obj2);
            object = z;
        }
        return this.m(b2Arr2, i3, i4, obj4.q.c(obj3), obj4.q.d(object), obj17);
    }

    private int c0(T t, byte[] b2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long l10, int i11, com.google.protobuf.f.b f$b12) {
        Object obj;
        int i;
        int valueOf2;
        byte[] valueOf;
        Long valueOf3;
        int i2;
        String inRange;
        java.nio.charset.Charset i10;
        int i12;
        Object object;
        final Object obj2 = this;
        obj = t;
        valueOf = b2Arr2;
        valueOf3 = i3;
        valueOf2 = i5;
        final int i24 = i6;
        inRange = i7;
        final long l7 = l10;
        i10 = b12;
        final Object obj5 = obj29;
        final Unsafe unsafe = w0.s;
        long l8 = (long)i22;
        i12 = 5;
        object = 2;
        switch (i9) {
            case 51:
                unsafe.putObject(obj, l7, obj10);
                i = valueOf3 + 8;
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 52:
                unsafe.putObject(obj, l7, obj10);
                i = valueOf3 + 4;
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 53:
                i = f.L(valueOf, valueOf3, obj5);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 54:
                i = f.I(valueOf, valueOf3, obj5);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 55:
                unsafe.putObject(obj, l7, obj10);
                i = valueOf3 + 8;
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 56:
                unsafe.putObject(obj, l7, obj10);
                i = valueOf3 + 4;
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 57:
                i = f.L(valueOf, valueOf3, obj5);
                object = 1;
                object = 0;
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 58:
                i = f.I(valueOf, valueOf3, obj5);
                valueOf3 = obj5.a;
                unsafe.putObject(obj, l7, obj10);
                throw InvalidProtocolBufferException.d();
                inRange = new String(valueOf, i, valueOf3, c0.a);
                unsafe.putObject(obj, l7, obj10);
                i += valueOf3;
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 59:
                i = f.p(obj2.v(i10), valueOf, valueOf3, i4, obj5);
                object = unsafe.getObject(obj, l7);
                object = 0;
                unsafe.putObject(obj, l7, obj10);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 60:
                i = f.b(valueOf, valueOf3, obj5);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 61:
                valueOf3 = obj5.a;
                inRange = obj2.t(i10);
                inRange = inRange.isInRange(valueOf3);
                w0.w(t).q(valueOf2, Long.valueOf((long)valueOf3));
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf;
                i = valueOf3;
                break;
            case 62:
                i = f.I(valueOf, valueOf3, obj5);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 63:
                i = f.L(valueOf, valueOf3, obj5);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            case 64:
                i = f.n(obj2.v(i10), b2Arr2, i3, i4, i14 | 4, obj29);
                object = unsafe.getObject(obj, l7);
                object = 0;
                unsafe.putObject(obj, l7, obj10);
                unsafe.putObject(obj, l7, obj10);
                unsafe.putInt(obj, l8, obj14);
                i = valueOf3;
                break;
            default:
                i = valueOf3;
        }
        return i;
    }

    private int e0(T t, byte[] b2Arr2, int i3, int i4, com.google.protobuf.f.b f$b5) {
        int i9;
        byte b2;
        Object object;
        Unsafe unsafe4;
        long l3;
        int cmp;
        int i19;
        boolean z;
        int int;
        int i24;
        int i23;
        byte[] bArr;
        long l5;
        int i17;
        int i22;
        int i5;
        int i16;
        byte b3;
        int i14;
        int i12;
        Unsafe unsafe3;
        long l2;
        Unsafe unsafe;
        int i11;
        com.google.protobuf.f.b i20;
        byte[] bArr2;
        int i;
        Object obj2;
        Object obj;
        byte b;
        int i18;
        int i15;
        int i21;
        long l4;
        int i13;
        int i6;
        int i7;
        int i2;
        long l;
        Unsafe unsafe2;
        int i8;
        int obj33;
        obj = this;
        obj2 = t;
        bArr2 = b2Arr2;
        i = i4;
        i20 = b5;
        unsafe = w0.s;
        final int i41 = 0;
        i9 = i3;
        cmp = i11;
        i14 = i24;
        i12 = 1048575;
        while (i9 < i) {
            i5 = i9 + 1;
            b2 = bArr2[i9];
            if (b2 < 0) {
            } else {
            }
            b = b2;
            i16 = i5;
            b3 = b >>> 3;
            i22 = b & 7;
            if (b3 > cmp) {
            } else {
            }
            i9 = obj.g0(b3);
            i17 = i9;
            if (i17 == i11) {
            } else {
            }
            int = obj.a[i17 + 1];
            i9 = w0.r0(int);
            i18 = unsafe;
            l2 = w0.V(int);
            obj33 = b3;
            if (i9 <= 17) {
            } else {
            }
            i15 = obj33;
            i6 = int;
            i = i17;
            i11 = i18;
            if (i9 == 27) {
            } else {
            }
            if (i9 <= 49) {
            } else {
            }
            obj33 = i22;
            obj = i16;
            i7 = i14;
            i2 = i12;
            l = l2;
            unsafe2 = i11;
            i21 = i;
            i18 = -1;
            unsafe = i6;
            if (unsafe == 50) {
            } else {
            }
            if (this.c0(t, b2Arr2, obj, i4, b, i15, obj33, i6, unsafe, l, i20, i21) != obj) {
            } else {
            }
            i23 = i9;
            i14 = i7;
            i12 = i2;
            i9 = f.G(b, b2Arr2, i23, i4, w0.w(t), b5);
            obj = this;
            obj2 = t;
            bArr2 = b2Arr2;
            i = i4;
            i20 = b5;
            i11 = i18;
            cmp = i15;
            i24 = i21;
            unsafe = unsafe2;
            obj = this;
            obj2 = t;
            bArr2 = b2Arr2;
            i = i4;
            i20 = b5;
            i11 = i18;
            cmp = i15;
            i24 = i21;
            i14 = i7;
            i12 = i2;
            i12 = obj33;
            if (i12 == 2) {
            } else {
            }
            i23 = obj;
            if (this.b0(t, b2Arr2, obj, i4, i21, l, i12) != obj) {
            } else {
            }
            i7 = i14;
            i2 = i12;
            int i36 = i18;
            unsafe2 = i11;
            i18 = -1;
            i21 = i;
            if (this.f0(t, b2Arr2, i16, i4, b, i15, i22, i, (long)i33, i11, i9, l2) != i16) {
            } else {
            }
            if (i22 == 2) {
            } else {
            }
            obj = i16;
            i7 = i14;
            i2 = i12;
            unsafe2 = i11;
            i21 = i;
            i18 = -1;
            object = i11.getObject(obj2, l2);
            if (!(c0.j)object.c2()) {
            }
            i9 = f.q(obj.v(i), b, b2Arr2, i16, i4, object, b5);
            i14 = l2;
            unsafe = i11;
            i24 = i;
            cmp = i15;
            i11 = -1;
            i = i4;
            int size = object.size();
            if (size == 0) {
            } else {
            }
            size *= 2;
            i11.putObject(obj2, l2, unsafe);
            z = 10;
            int i38 = obj.a[i17 + 2];
            b3 = 1;
            l4 = b3 << i44;
            int i40 = 1048575;
            i38 &= i40;
            int i42 = i17;
            if (i39 != i12) {
            } else {
            }
            i11 = i18;
            cmp = 5;
            i18 = i40;
            i = i42;
            i15 = obj33;
            i23 = i16;
            unsafe2 = i11;
            i21 = i;
            i18 = -1;
            if (i22 == 0) {
            } else {
            }
            i = i42;
            i15 = obj33;
            i18 = 1048575;
            b = f.L(bArr2, i16, i20);
            i = i42;
            i15 = obj33;
            i11.putLong(t, l2, i22);
            i14 |= l4;
            unsafe = i11;
            i24 = i;
            i9 = b;
            i = i42;
            i15 = obj33;
            if (i22 == 0) {
            } else {
            }
            i9 = f.I(bArr2, i16, i20);
            i11.putInt(obj2, l2, unsafe);
            i14 |= l4;
            i = i42;
            i15 = obj33;
            if (i22 == 0) {
            } else {
            }
            i9 = f.I(bArr2, i16, i20);
            i11.putInt(obj2, l2, unsafe);
            i = i42;
            i15 = obj33;
            if (i22 == 2) {
            } else {
            }
            i9 = f.b(bArr2, i16, i20);
            i11.putObject(obj2, l2, unsafe);
            i15 = obj33;
            if (i22 == 2) {
            } else {
            }
            i17 = i4;
            i18 = 1048575;
            i9 = f.p(obj.v(i42), bArr2, i16, i4, i20);
            Object object2 = i11.getObject(obj2, l2);
            if (object2 == null) {
            } else {
            }
            i11.putObject(obj2, l2, unsafe);
            i14 |= l4;
            unsafe = i11;
            cmp = i15;
            i11 = -1;
            i = i17;
            i24 = i8;
            i11.putObject(obj2, l2, unsafe);
            i17 = i4;
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == 2) {
            } else {
            }
            if (i6 & i26 == 0) {
            } else {
            }
            i9 = f.F(bArr2, i16, i20);
            i11.putObject(obj2, l2, unsafe);
            i9 = f.C(bArr2, i16, i20);
            i17 = i4;
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == 0) {
            } else {
            }
            i9 = f.L(bArr2, i16, i20);
            if (Long.compare(i22, i13) != 0) {
            } else {
            }
            b3 = i41;
            w1.L(obj2, l2, unsafe);
            i17 = i4;
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == cmp) {
            } else {
            }
            i11.putInt(obj2, l2, unsafe);
            i9 = i16 + 4;
            i17 = i4;
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == b3) {
            } else {
            }
            i11.putLong(t, l2, i22);
            i9 = l2 + 8;
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == 0) {
            } else {
            }
            i9 = f.I(bArr2, i16, i20);
            i11.putInt(obj2, l2, unsafe);
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == 0) {
            } else {
            }
            b = f.L(bArr2, i16, i20);
            i11.putLong(t, l2, i22);
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == cmp) {
            } else {
            }
            w1.S(obj2, l2, unsafe);
            i9 = i16 + 4;
            i18 = i40;
            i = i42;
            i15 = obj33;
            if (i22 == b3) {
            } else {
            }
            w1.R(obj2, l2, unsafe);
            i9 = i16 + 8;
            if (i12 != i40) {
            } else {
            }
            unsafe3 = i18;
            if (i39 != i40) {
            }
            i11 = unsafe3;
            i12 = i8;
            i14 = int;
            i18.putInt(obj2, (long)i12, i17);
            i23 = i16;
            i15 = b3;
            unsafe2 = unsafe;
            i18 = i11;
            i21 = i41;
            i9 = obj.h0(b3, i24 /= 3);
            i16 = b2;
            b = i5;
        }
        if (i12 != 1048575) {
            unsafe.putInt(t, (long)i12, i24);
        }
        if (i9 != i4) {
        } else {
            return i9;
        }
        throw InvalidProtocolBufferException.h();
    }

    private int f0(T t, byte[] b2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, long l9, int i10, long l11, com.google.protobuf.f.b f$b12) {
        int i13;
        Object obj2;
        int i11;
        int i12;
        byte[] obj;
        com.google.protobuf.t1 unknownFields;
        int i9;
        int i;
        int i2;
        com.google.protobuf.f.b bVar;
        Object object;
        boolean z2;
        byte[] obj19;
        int obj20;
        int obj21;
        Object obj22;
        com.google.protobuf.f.b obj23;
        Object obj24;
        com.google.protobuf.f.b obj25;
        obj2 = t;
        obj = b2Arr2;
        i9 = i3;
        i12 = i7;
        final int i17 = i8;
        long l = b12;
        bVar = obj27;
        final Unsafe unsafe = w0.s;
        object = unsafe.getObject(t, l);
        final int i18 = 2;
        if (!(c0.j)object.c2()) {
            int size = object.size();
            z2 = size == 0 ? 10 : size * i18;
            unsafe.putObject(t, l, obj6);
        }
        i = 5;
        i2 = 1;
        switch (l11) {
            case 18:
                i11 = f.s(b2Arr2, i9, object, bVar);
                i11 = f.e(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 19:
                i11 = f.v(b2Arr2, i9, object, bVar);
                i11 = f.m(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 20:
                i11 = f.z(b2Arr2, i9, object, bVar);
                i11 = f.M(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 21:
                i11 = f.y(b2Arr2, i9, object, bVar);
                i11 = f.J(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 22:
                i11 = f.u(b2Arr2, i9, object, bVar);
                i11 = f.k(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 23:
                i11 = f.t(b2Arr2, i9, object, bVar);
                i11 = f.i(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 24:
                i11 = f.r(b2Arr2, i9, object, bVar);
                i11 = f.a(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 25:
                i11 = f.D(i5, b2Arr2, i3, i4, object, obj27);
                i11 = f.E(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 26:
                i11 = f.q(v(i17), i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 27:
                i11 = f.c(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 28:
                i12 = f.y(b2Arr2, i9, object, bVar);
                i12 = f.J(i5, b2Arr2, i3, i4, object, obj27);
                unknownFields = 0;
                obj = n1.A(i6, object, t(i17), unknownFields, obj3.o);
                obj2.unknownFields = (t1)obj;
                i11 = i12;
                i11 = i9;
                break;
            case 29:
                i11 = f.w(b2Arr2, i9, object, bVar);
                i11 = f.A(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 30:
                i11 = f.x(b2Arr2, i9, object, bVar);
                i11 = f.B(i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            case 31:
                i11 = f.o(v(i17), i5, b2Arr2, i3, i4, object, obj27);
                i11 = i9;
                break;
            default:
                i11 = i9;
        }
        return i11;
    }

    private int g0(int i) {
        int i2;
        if (i >= this.c && i <= this.d) {
            if (i <= this.d) {
                return q0(i, 0);
            }
        }
        return -1;
    }

    private int h0(int i, int i2) {
        int i3;
        if (i >= this.c && i <= this.d) {
            if (i <= this.d) {
                return q0(i, i2);
            }
        }
        return -1;
    }

    private int i0(int i) {
        return this.a[i += 2];
    }

    private <E> void j0(Object object, long l2, com.google.protobuf.j1 j13, com.google.protobuf.l1<E> l14, com.google.protobuf.q q5) {
        l14.f(this.n.e(object, l2), q5, obj7);
    }

    private boolean k(T t, T t2, int i3) {
        int obj1;
        obj1 = C(t, i3) == C(t2, i3) ? 1 : 0;
        return obj1;
    }

    private <E> void k0(Object object, int i2, com.google.protobuf.j1 j13, com.google.protobuf.l1<E> l14, com.google.protobuf.q q5) {
        j13.k(this.n.e(object, w0.V(i2)), l14, q5);
    }

    private static <T> boolean l(T t, long l2) {
        return w1.t(t, l2);
    }

    private void l0(Object object, int i2, com.google.protobuf.j1 j13) {
        long l;
        Object obj4;
        if (w0.B(i2)) {
            w1.V(object, w0.V(i2), obj1);
        } else {
            if (this.g) {
                w1.V(object, w0.V(i2), obj1);
            } else {
                w1.V(object, w0.V(i2), obj1);
            }
        }
    }

    private <K, V> int m(byte[] bArr, int i2, int i3, com.google.protobuf.m0.a<K, V> m0$a4, Map<K, V> map5, com.google.protobuf.f.b f$b6) {
        int i4;
        byte b;
        Object wireType;
        int i5;
        Object obj;
        int i6;
        int i7;
        int i;
        int class;
        com.google.protobuf.f.b bVar;
        Object obj2;
        Object obj3;
        final int i11 = i3;
        final Object obj8 = a4;
        final com.google.protobuf.f.b bVar4 = b6;
        i4 = f.I(bArr, i2, bVar4);
        int i10 = bVar4.a;
        if (i10 < 0) {
        } else {
            if (i10 > i11 - i4) {
            } else {
                final int i12 = i4 + i10;
                obj2 = wireType;
                obj3 = obj;
                while (i4 < i12) {
                    i5 = i4 + 1;
                    b = bArr[i4];
                    if (b < 0) {
                    } else {
                    }
                    obj = i5;
                    wireType = b >>> 3;
                    i7 = b & 7;
                    if (wireType != 1) {
                    } else {
                    }
                    if (i7 == obj8.a.getWireType()) {
                    } else {
                    }
                    i4 = f.N(b, bArr, obj, i11, bVar4);
                    i4 = this.n(bArr, obj, i3, obj8.a, 0, b6);
                    obj2 = bVar4.c;
                    if (wireType != 2) {
                    } else {
                    }
                    if (i7 == obj8.c.getWireType()) {
                    } else {
                    }
                    i4 = this.n(bArr, obj, i3, obj8.c, obj8.d.getClass(), b6);
                    obj3 = bVar4.c;
                    obj = i9;
                    b = i5;
                }
                if (i4 != i12) {
                } else {
                    map5.put(obj2, obj3);
                    return i12;
                }
                throw InvalidProtocolBufferException.h();
            }
        }
        throw InvalidProtocolBufferException.m();
    }

    private void m0(Object object, int i2, com.google.protobuf.j1 j13) {
        com.google.protobuf.j0 j0Var;
        long l;
        List obj4;
        if (w0.B(i2)) {
            j13.E(this.n.e(object, w0.V(i2)));
        } else {
            j13.B(this.n.e(object, w0.V(i2)));
        }
    }

    private int n(byte[] bArr, int i2, int i3, com.google.protobuf.y1.b y1$b4, Class<?> class5, com.google.protobuf.f.b f$b6) {
        Number obj2;
        int obj3;
        long obj4;
        int obj5;
        obj5 = w0.a.a[b4.ordinal()];
        switch (obj5) {
            case 1:
                obj2 = f.L(bArr, i2, b6);
                obj3 = 1;
                obj3 = 0;
                b6.c = Boolean.valueOf(obj3);
                return obj2;
            case 2:
                obj2 = f.b(bArr, i2, b6);
                return obj2;
            case 3:
                b6.c = Double.valueOf(f.d(bArr, i2));
                obj2 = i2 + 8;
                return obj2;
            case 4:
                b6.c = Integer.valueOf(f.h(bArr, i2));
                break;
            case 5:
                b6.c = Long.valueOf(f.j(bArr, i2));
                obj2 = i2 + 8;
                return obj2;
            case 6:
                b6.c = Float.valueOf(f.l(bArr, i2));
                break;
            case 7:
                obj2 = f.I(bArr, i2, b6);
                b6.c = Integer.valueOf(b6.a);
                return obj2;
            case 8:
                obj2 = f.L(bArr, i2, b6);
                b6.c = Long.valueOf(b6.b);
                return obj2;
            case 9:
                obj2 = f.p(g1.a().d(class5), bArr, i2, i3, b6);
                return obj2;
            case 10:
                obj2 = f.I(bArr, i2, b6);
                b6.c = Integer.valueOf(k.b(b6.a));
                return obj2;
            case 11:
                obj2 = f.L(bArr, i2, b6);
                b6.c = Long.valueOf(k.c(b6.b));
                return obj2;
            case 12:
                obj2 = f.F(bArr, i2, b6);
                return obj2;
            default:
                obj2 = new RuntimeException("unsupported field type.");
                throw obj2;
        }
        obj2 = i2 + 4;
    }

    private static Field n0(Class<?> class, String string2) {
        int runtimeException;
        int stringBuilder;
        try {
            return class.getDeclaredField(string2);
            Field[] declaredFields = class.getDeclaredFields();
            runtimeException = declaredFields.length;
            stringBuilder = 0;
            Field str = declaredFields[stringBuilder];
            String equals = str.getName();
            equals = string2.equals(equals);
        }
        stringBuilder = new StringBuilder();
        str = "Field ";
        stringBuilder.append(str);
        stringBuilder.append(string2);
        string2 = " for ";
        stringBuilder.append(string2);
        class = class.getName();
        stringBuilder.append(class);
        class = " not found. Known fields are ";
        stringBuilder.append(class);
        class = Arrays.toString(declaredFields);
        stringBuilder.append(class);
        class = stringBuilder.toString();
        runtimeException = new RuntimeException(class);
        throw runtimeException;
    }

    private static <T> double o(T t, long l2) {
        return w1.A(t, l2);
    }

    private void o0(T t, int i2) {
        int obj6 = i0(i2);
        long l = (long)i3;
        if (Long.compare(l, i4) == 0) {
        }
        w1.T(t, l, obj1);
    }

    private boolean p(T t, T t2, int i3) {
        long z;
        int i2;
        long doubleToLongBits;
        Object obj8;
        Object obj9;
        int i4 = s0(i3);
        final long l = w0.V(i4);
        i2 = 0;
        final int i6 = 1;
        switch (i5) {
            case 0:
                i2 = i6;
                return i2;
            case 1:
                i2 = i6;
                return i2;
            case 2:
                i2 = i6;
                return i2;
            case 3:
                i2 = i6;
                return i2;
            case 4:
                i2 = i6;
                return i2;
            case 5:
                i2 = i6;
                return i2;
            case 6:
                i2 = i6;
                return i2;
            case 7:
                i2 = i6;
                return i2;
            case 8:
                i2 = i6;
                return i2;
            case 9:
                i2 = i6;
                return i2;
            case 10:
                i2 = i6;
                return i2;
            case 11:
                i2 = i6;
                return i2;
            case 12:
                i2 = i6;
                return i2;
            case 13:
                i2 = i6;
                return i2;
            case 14:
                i2 = i6;
                return i2;
            case 15:
                i2 = i6;
                return i2;
            case 16:
                i2 = i6;
                return i2;
            case 17:
                i2 = i6;
                return i2;
            case 18:
                return n1.K(w1.G(t, l), w1.G(t2, l));
            case 19:
                return n1.K(w1.G(t, l), w1.G(t2, l));
            case 20:
                i2 = i6;
                return i2;
            default:
                return i6;
        }
    }

    private void p0(T t, int i2, int i3) {
        w1.T(t, (long)obj5, obj1);
    }

    private final <UT, UB> UB q(Object object, int i2, UB ub3, com.google.protobuf.s1<UT, UB> s14) {
        Object obj8 = w1.G(object, w0.V(s0(i2)));
        if (obj8 == null) {
            return ub3;
        }
        final com.google.protobuf.c0.e eVar = t(i2);
        if (eVar == null) {
            return ub3;
        }
        return this.r(i2, U(i2), this.q.d(obj8), eVar, ub3, s14);
    }

    private int q0(int i, int i2) {
        int i6;
        int i3;
        int i5;
        int i4;
        int obj6;
        i7--;
        while (obj6 <= i6) {
            i8 >>>= 1;
            i5 = i9 * 3;
            i4 = U(i5);
            if (i < i4) {
            } else {
            }
            obj6 = i3;
            i6 = i3;
        }
        return -1;
    }

    private final <K, V, UT, UB> UB r(int i, int i2, Map<K, V> map3, com.google.protobuf.c0.e c0$e4, UB ub5, com.google.protobuf.s1<UT, UB> s16) {
        com.google.protobuf.o0 next;
        boolean inRange;
        com.google.protobuf.CodedOutputStream outputStream;
        Object key;
        Object obj9;
        com.google.protobuf.m0.a obj5 = this.q.c(u(i));
        Iterator obj7 = map3.entrySet().iterator();
        while (obj7.hasNext()) {
            next = obj7.next();
            if (!e4.isInRange((Integer)(Map.Entry)next.getValue().intValue()) && obj9 == null) {
            }
            if (obj9 == null) {
            }
            inRange = j.D(m0.b(obj5, next.getKey(), next.getValue()));
            m0.e(inRange.b(), obj5, next.getKey(), next.getValue());
            s16.d(obj9, i2, inRange.a());
            obj7.remove();
            obj9 = s16.n();
        }
        return obj9;
    }

    private static int r0(int i) {
        return obj1 >>>= 20;
    }

    private static <T> float s(T t, long l2) {
        return w1.B(t, l2);
    }

    private int s0(int i) {
        return this.a[i++];
    }

    private com.google.protobuf.c0.e t(int i) {
        return (c0.e)this.b[obj2++];
    }

    private void t0(T t, com.google.protobuf.z1 z12) {
        int i6;
        int i11;
        int i13;
        int i4;
        boolean z;
        int object2;
        int next;
        boolean z2;
        int i14;
        long object;
        int i3;
        int i5;
        int i10;
        int int;
        int i8;
        int i;
        int i12;
        int i7;
        int i9;
        final Object obj = this;
        final Object obj2 = t;
        final com.google.protobuf.z1 z1Var = z12;
        z = obj.p.c(obj2);
        if (obj.f && !z.n()) {
            z = obj.p.c(obj2);
            if (!z.n()) {
                next = z.s().next();
            } else {
                i4 = 0;
                next = 0;
            }
        } else {
        }
        final Unsafe unsafe = w0.s;
        i10 = i14;
        i5 = 0;
        int = 0;
        while (i5 < iArr2.length) {
            i = obj.s0(i5);
            i12 = obj.U(i5);
            i7 = w0.r0(i);
            if (i7 <= 17) {
            } else {
            }
            object2 = 0;
            while (next != 0) {
                if (obj.p.a(next) <= i12) {
                }
                obj.p.j(z1Var, next);
                if (i4.hasNext()) {
                } else {
                }
                next = 0;
                next = i4.next();
            }
            object = w0.V(i);
            i8 = 0;
            i5 += 3;
            i14 = 1048575;
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.s(i12, unsafe.getObject(obj2, object), obj.v(i5));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.F(i12, w0.a0(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.N(i12, w0.Z(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.z(i12, w0.a0(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.t(i12, w0.Z(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.J(i12, w0.Z(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.d(i12, w0.Z(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.v(i12, (j)unsafe.getObject(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.j(i12, unsafe.getObject(obj2, object), obj.v(i5));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            obj.x0(i12, unsafe.getObject(obj2, object), z1Var);
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.r(i12, w0.W(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.f(i12, w0.Z(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.k(i12, w0.a0(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.w(i12, w0.Z(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.o(i12, w0.a0(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.q(i12, w0.a0(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.G(i12, w0.Y(obj2, object));
            if (obj.I(obj2, i12, i5) != 0) {
            }
            z1Var.g(i12, w0.X(obj2, object));
            obj.w0(z1Var, i12, unsafe.getObject(obj2, object), i5);
            n1.U(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, obj.v(i5));
            n1.b0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.a0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.Z(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.Y(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.Q(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.d0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.N(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.R(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.S(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.V(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.e0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.W(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.T(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.P(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, true);
            n1.b0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.a0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.Z(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.Y(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.Q(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.d0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.O(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var);
            n1.X(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, obj.v(i5));
            n1.c0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var);
            n1.N(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.R(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.S(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.V(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.e0(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.W(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.T(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            n1.P(obj.U(i5), (List)unsafe.getObject(obj2, object), z1Var, false);
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.s(i12, unsafe.getObject(obj2, object), obj.v(i5));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.F(i12, unsafe.getLong(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.N(i12, unsafe.getInt(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.z(i12, unsafe.getLong(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.t(i12, unsafe.getInt(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.J(i12, unsafe.getInt(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.d(i12, unsafe.getInt(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.v(i12, (j)unsafe.getObject(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.j(i12, unsafe.getObject(obj2, object), obj.v(i5));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            obj.x0(i12, unsafe.getObject(obj2, object), z1Var);
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.r(i12, w0.l(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.f(i12, unsafe.getInt(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.k(i12, unsafe.getLong(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.w(i12, unsafe.getInt(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.o(i12, unsafe.getLong(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.q(i12, unsafe.getLong(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.G(i12, w0.s(obj2, object));
            i8 = 0;
            if (object2 &= int != 0) {
            }
            z1Var.g(i12, w0.o(obj2, object));
            if (obj.p.a(next) <= i12) {
            }
            obj.p.j(z1Var, next);
            if (i4.hasNext()) {
            } else {
            }
            next = 0;
            next = i4.next();
            int i16 = obj.a[i5 + 2];
            int i18 = i16 & i14;
            if (i18 != i10) {
            }
            object2 = i3 << i17;
            int = unsafe.getInt(obj2, (long)i18);
            i10 = i18;
        }
        while (next != 0) {
            obj.p.j(z1Var, next);
            if (i4.hasNext()) {
            } else {
            }
            next = 0;
            next = object2;
        }
        obj.y0(obj.o, obj2, z1Var);
    }

    private Object u(int i) {
        return this.b[obj2 *= 2];
    }

    private void u0(T t, com.google.protobuf.z1 z12) {
        int i6;
        boolean z2;
        int length2;
        int next;
        int i5;
        int length;
        int i2;
        int i;
        int i7;
        int i3;
        boolean z;
        int i4;
        long l;
        final int i9 = 0;
        z2 = this.p.c(t);
        if (this.f && !z2.n()) {
            z2 = this.p.c(t);
            if (!z2.n()) {
                next = z2.s().next();
            } else {
                next = i6;
            }
        } else {
        }
        final int i10 = 0;
        i = i10;
        while (i < iArr.length) {
            i7 = s0(i);
            i3 = U(i);
            while (next != 0) {
                if (this.p.a(next) <= i3) {
                }
                this.p.j(z12, next);
                if (i6.hasNext()) {
                } else {
                }
                next = i9;
                next = i6.next();
            }
            i4 = 1;
            i += 3;
            if (I(t, i3, i)) {
            }
            z12.s(i3, w1.G(t, w0.V(i7)), v(i));
            if (I(t, i3, i)) {
            }
            z12.F(i3, w0.a0(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.N(i3, w0.Z(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.z(i3, w0.a0(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.t(i3, w0.Z(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.J(i3, w0.Z(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.d(i3, w0.Z(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.v(i3, (j)w1.G(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.j(i3, w1.G(t, w0.V(i7)), v(i));
            if (I(t, i3, i)) {
            }
            x0(i3, w1.G(t, w0.V(i7)), z12);
            if (I(t, i3, i)) {
            }
            z12.r(i3, w0.W(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.f(i3, w0.Z(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.k(i3, w0.a0(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.w(i3, w0.Z(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.o(i3, w0.a0(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.q(i3, w0.a0(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.G(i3, w0.Y(t, w0.V(i7)));
            if (I(t, i3, i)) {
            }
            z12.g(i3, w0.X(t, w0.V(i7)));
            w0(z12, i3, w1.G(t, w0.V(i7)), i);
            n1.U(U(i), (List)w1.G(t, w0.V(i7)), z12, v(i));
            n1.b0(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.a0(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.Z(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.Y(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.Q(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.d0(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.N(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.R(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.S(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.V(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.e0(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.W(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.T(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.P(U(i), (List)w1.G(t, w0.V(i7)), z12, i4);
            n1.b0(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.a0(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.Z(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.Y(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.Q(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.d0(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.O(U(i), (List)w1.G(t, w0.V(i7)), z12);
            n1.X(U(i), (List)w1.G(t, w0.V(i7)), z12, v(i));
            n1.c0(U(i), (List)w1.G(t, w0.V(i7)), z12);
            n1.N(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.R(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.S(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.V(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.e0(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.W(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.T(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            n1.P(U(i), (List)w1.G(t, w0.V(i7)), z12, i10);
            if (C(t, i)) {
            }
            z12.s(i3, w1.G(t, w0.V(i7)), v(i));
            if (C(t, i)) {
            }
            z12.F(i3, w0.L(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.N(i3, w0.A(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.z(i3, w0.L(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.t(i3, w0.A(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.J(i3, w0.A(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.d(i3, w0.A(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.v(i3, (j)w1.G(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.j(i3, w1.G(t, w0.V(i7)), v(i));
            if (C(t, i)) {
            }
            x0(i3, w1.G(t, w0.V(i7)), z12);
            if (C(t, i)) {
            }
            z12.r(i3, w0.l(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.f(i3, w0.A(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.k(i3, w0.L(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.w(i3, w0.A(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.o(i3, w0.L(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.q(i3, w0.L(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.G(i3, w0.s(t, w0.V(i7)));
            if (C(t, i)) {
            }
            z12.g(i3, w0.o(t, w0.V(i7)));
            if (this.p.a(next) <= i3) {
            }
            this.p.j(z12, next);
            if (i6.hasNext()) {
            } else {
            }
            next = i9;
            next = i6.next();
        }
        while (next != 0) {
            this.p.j(z12, next);
            if (i6.hasNext()) {
            } else {
            }
            next = i9;
            next = i6.next();
        }
        y0(this.o, t, z12);
    }

    private com.google.protobuf.l1 v(int i) {
        obj4 *= 2;
        Object obj = this.b[obj4];
        if ((l1)obj != null) {
            return (l1)obj;
        }
        com.google.protobuf.l1 l1Var = g1.a().d((Class)this.b[obj4 + 1]);
        this.b[obj4] = l1Var;
        return l1Var;
    }

    private void v0(T t, com.google.protobuf.z1 z12) {
        int i;
        boolean z;
        int length;
        int next;
        int i5;
        int i2;
        int i6;
        int length2;
        boolean z2;
        int i3;
        int i4;
        Object obj11;
        y0(this.o, t, z12);
        final int i8 = 0;
        z = this.p.c(t);
        if (this.f && !z.n()) {
            z = this.p.c(t);
            if (!z.n()) {
                next = z.g().next();
            } else {
                next = i;
            }
        } else {
        }
        length3 += -3;
        while (i2 >= 0) {
            i6 = s0(i2);
            length2 = U(i2);
            while (next != 0) {
                if (this.p.a(next) > length2) {
                }
                this.p.j(z12, next);
                if (i.hasNext()) {
                } else {
                }
                next = i8;
                next = i.next();
            }
            i3 = 1;
            i4 = 0;
            i2 += -3;
            if (I(t, length2, i2)) {
            }
            z12.s(length2, w1.G(t, w0.V(i6)), v(i2));
            if (I(t, length2, i2)) {
            }
            z12.F(length2, w0.a0(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.N(length2, w0.Z(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.z(length2, w0.a0(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.t(length2, w0.Z(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.J(length2, w0.Z(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.d(length2, w0.Z(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.v(length2, (j)w1.G(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.j(length2, w1.G(t, w0.V(i6)), v(i2));
            if (I(t, length2, i2)) {
            }
            x0(length2, w1.G(t, w0.V(i6)), z12);
            if (I(t, length2, i2)) {
            }
            z12.r(length2, w0.W(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.f(length2, w0.Z(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.k(length2, w0.a0(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.w(length2, w0.Z(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.o(length2, w0.a0(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.q(length2, w0.a0(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.G(length2, w0.Y(t, w0.V(i6)));
            if (I(t, length2, i2)) {
            }
            z12.g(length2, w0.X(t, w0.V(i6)));
            w0(z12, length2, w1.G(t, w0.V(i6)), i2);
            n1.U(U(i2), (List)w1.G(t, w0.V(i6)), z12, v(i2));
            n1.b0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.a0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.Z(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.Y(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.Q(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.d0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.N(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.R(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.S(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.V(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.e0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.W(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.T(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.P(U(i2), (List)w1.G(t, w0.V(i6)), z12, i3);
            n1.b0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.a0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.Z(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.Y(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.Q(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.d0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.O(U(i2), (List)w1.G(t, w0.V(i6)), z12);
            n1.X(U(i2), (List)w1.G(t, w0.V(i6)), z12, v(i2));
            n1.c0(U(i2), (List)w1.G(t, w0.V(i6)), z12);
            n1.N(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.R(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.S(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.V(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.e0(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.W(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.T(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            n1.P(U(i2), (List)w1.G(t, w0.V(i6)), z12, i4);
            if (C(t, i2)) {
            }
            z12.s(length2, w1.G(t, w0.V(i6)), v(i2));
            if (C(t, i2)) {
            }
            z12.F(length2, w0.L(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.N(length2, w0.A(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.z(length2, w0.L(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.t(length2, w0.A(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.J(length2, w0.A(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.d(length2, w0.A(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.v(length2, (j)w1.G(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.j(length2, w1.G(t, w0.V(i6)), v(i2));
            if (C(t, i2)) {
            }
            x0(length2, w1.G(t, w0.V(i6)), z12);
            if (C(t, i2)) {
            }
            z12.r(length2, w0.l(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.f(length2, w0.A(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.k(length2, w0.L(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.w(length2, w0.A(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.o(length2, w0.L(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.q(length2, w0.L(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.G(length2, w0.s(t, w0.V(i6)));
            if (C(t, i2)) {
            }
            z12.g(length2, w0.o(t, w0.V(i6)));
            if (this.p.a(next) > length2) {
            }
            this.p.j(z12, next);
            if (i.hasNext()) {
            } else {
            }
            next = i8;
            next = i.next();
        }
        while (next != 0) {
            this.p.j(z12, next);
            if (i.hasNext() != null) {
            } else {
            }
            next = i8;
            next = obj11;
        }
    }

    static com.google.protobuf.t1 w(Object object) {
        com.google.protobuf.t1 unknownFields;
        if (object.unknownFields == t1.c()) {
            object.unknownFields = t1.n();
        }
        return unknownFields;
    }

    private <K, V> void w0(com.google.protobuf.z1 z1, int i2, Object object3, int i4) {
        com.google.protobuf.o0 o0Var;
        Object obj4;
        int obj5;
        if (object3 != null) {
            z1.C(i2, this.q.c(u(i4)), this.q.h(object3));
        }
    }

    private int x(T t) {
        int str;
        Object obj;
        int str2;
        boolean z2;
        int i8;
        int i10;
        int i2;
        int object;
        int i12;
        int i;
        int i16;
        int i9;
        int i7;
        int int;
        int i4;
        int i11;
        int i3;
        int i15;
        int i13;
        boolean z;
        long l;
        int i6;
        int i14;
        final Object obj2 = this;
        obj = t;
        Unsafe unsafe = w0.s;
        i7 = i10;
        i = 0;
        i16 = 0;
        int = 0;
        while (i < iArr.length) {
            int i27 = obj2.s0(i);
            i11 = obj2.U(i);
            i15 = w0.r0(i27);
            if (i15 <= 17) {
            } else {
            }
            if (obj2.i && i15 >= w.DOUBLE_LIST_PACKED.id() && i15 <= w.SINT64_LIST_PACKED.id()) {
            } else {
            }
            i13 = 0;
            i14 = 0;
            l = w0.V(i27);
            i4 = 0;
            i2 = 0;
            i3 = 0;
            i += 3;
            i10 = 1048575;
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.t(i11, (t0)unsafe.getObject(obj, l), obj2.v(i));
            i16 += i2;
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.S(i11, w0.a0(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.Q(i11, w0.Z(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.O(i11, i2);
            if (obj2.I(obj, i11, i)) {
            }
            object = CodedOutputStream.M(i11, 0);
            i16 += object;
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.l(i11, w0.Z(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.X(i11, w0.Z(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.h(i11, (j)unsafe.getObject(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = n1.o(i11, unsafe.getObject(obj, l), obj2.v(i));
            if (obj2.I(obj, i11, i)) {
            }
            Object object21 = unsafe.getObject(obj, l);
            if (object21 instanceof j) {
            } else {
            }
            i2 = CodedOutputStream.U(i11, (String)object21);
            i2 = CodedOutputStream.h(i11, (j)object21);
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.e(i11, true);
            if (obj2.I(obj, i11, i)) {
            }
            object = CodedOutputStream.n(i11, 0);
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.p(i11, i2);
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.w(i11, w0.Z(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.Z(i11, w0.a0(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.y(i11, w0.a0(obj, l));
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.r(i11, i4);
            if (obj2.I(obj, i11, i)) {
            }
            i2 = CodedOutputStream.j(i11, 0);
            i2 = obj2.q.f(i11, unsafe.getObject(obj, l), obj2.u(i));
            i2 = n1.j(i11, (List)unsafe.getObject(obj, l), obj2.v(i));
            i2 = n1.t((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            i26 += i2;
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.r((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.i((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.g((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.e((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.w((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.b((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.g((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.i((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.l((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.y((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.n((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.g((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.i((List)unsafe.getObject(obj, l));
            if (i2 > 0 && obj2.i) {
            }
            if (obj2.i) {
            }
            i12 = CodedOutputStream.W(i11);
            i4 = CodedOutputStream.Y(i2);
            unsafe.putInt(obj, (long)i13, i13);
            i2 = n1.s(i11, (List)unsafe.getObject(obj, l), false);
            i16 += i2;
            i3 = object;
            i2 = n1.q(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.h(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.f(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.d(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.v(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.c(i11, (List)unsafe.getObject(obj, l));
            i2 = n1.p(i11, (List)unsafe.getObject(obj, l), obj2.v(i));
            i2 = n1.u(i11, (List)unsafe.getObject(obj, l));
            i2 = n1.a(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.f(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.h(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.k(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.x(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.m(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.f(i11, (List)unsafe.getObject(obj, l), false);
            i2 = n1.h(i11, (List)unsafe.getObject(obj, l), false);
            if (int & i14) {
            }
            i2 = CodedOutputStream.t(i11, (t0)unsafe.getObject(obj, l), obj2.v(i));
            if (int & i14) {
            }
            i2 = CodedOutputStream.S(i11, unsafe.getLong(obj, l));
            if (int & i14) {
            }
            i2 = CodedOutputStream.Q(i11, unsafe.getInt(obj, l));
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.O(i11, i2);
            if (int & i14) {
            }
            object = CodedOutputStream.M(i11, 0);
            if (int & i14) {
            }
            i2 = CodedOutputStream.l(i11, unsafe.getInt(obj, l));
            if (int & i14) {
            }
            i2 = CodedOutputStream.X(i11, unsafe.getInt(obj, l));
            if (int & i14) {
            }
            i2 = CodedOutputStream.h(i11, (j)unsafe.getObject(obj, l));
            if (int & i14) {
            }
            i2 = n1.o(i11, unsafe.getObject(obj, l), obj2.v(i));
            if (int & i14) {
            }
            Object object7 = unsafe.getObject(obj, l);
            if (object7 instanceof j != 0) {
            } else {
            }
            i2 = CodedOutputStream.U(i11, (String)object7);
            i2 = CodedOutputStream.h(i11, (j)object7);
            if (int & i14) {
            }
            i2 = CodedOutputStream.e(i11, true);
            if (int & i14) {
            } else {
            }
            i2 = CodedOutputStream.n(i11, 0);
            i16 += i2;
            i3 = 0;
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.p(i11, i2);
            i3 = 0;
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.w(i11, unsafe.getInt(obj, l));
            i3 = 0;
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.Z(i11, unsafe.getLong(obj, l));
            i3 = 0;
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.y(i11, unsafe.getLong(obj, l));
            i3 = 0;
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.r(i11, i4);
            i3 = 0;
            if (int & i14 != 0) {
            }
            i2 = CodedOutputStream.j(i11, 0);
            if (i15 >= w.DOUBLE_LIST_PACKED.id()) {
            } else {
            }
            if (i15 <= w.SINT64_LIST_PACKED.id()) {
            } else {
            }
            i29 &= i10;
            i13 = obj2.a[i + 2];
            i6 = i13 & i10;
            i14 = i30 << i32;
            if (i6 != i7) {
            }
            int = unsafe.getInt(obj, (long)i6);
            i7 = i6;
        }
        if (obj2.f) {
            i9 += obj;
        }
        return i9;
    }

    private void x0(int i, Object object2, com.google.protobuf.z1 z13) {
        if (object2 instanceof String != null) {
            z13.n(i, (String)object2);
        } else {
            z13.v(i, (j)object2);
        }
    }

    private int y(T t) {
        int i10;
        int i13;
        int i2;
        int i11;
        int i4;
        int i9;
        int i;
        int i3;
        int i6;
        int i14;
        int i15;
        long l;
        int i5;
        int i7;
        int i8;
        final Object obj = this;
        Object obj2 = t;
        Unsafe unsafe = w0.s;
        final int i17 = 0;
        i9 = i4;
        while (i4 < iArr.length) {
            int i19 = s0(i4);
            i14 = w0.r0(i19);
            i15 = U(i4);
            l = w0.V(i19);
            if (i14 >= w.DOUBLE_LIST_PACKED.id() && i14 <= w.SINT64_LIST_PACKED.id()) {
            } else {
            }
            i = i17;
            i5 = 1;
            i7 = 0;
            i8 = 0;
            i4 += 3;
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.t(i15, (t0)w1.G(obj2, l), v(i4));
            i9 += i;
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.S(i15, w0.a0(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.Q(i15, w0.Z(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.O(i15, i8);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.M(i15, i17);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.l(i15, w0.Z(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.X(i15, w0.Z(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.h(i15, (j)w1.G(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = n1.o(i15, w1.G(obj2, l), v(i4));
            if (I(obj2, i15, i4)) {
            }
            Object obj9 = w1.G(obj2, l);
            if (obj9 instanceof j) {
            } else {
            }
            i = CodedOutputStream.U(i15, (String)obj9);
            i = CodedOutputStream.h(i15, (j)obj9);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.e(i15, i5);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.n(i15, i17);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.p(i15, i8);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.w(i15, w0.Z(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.Z(i15, w0.a0(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.y(i15, w0.a0(obj2, l));
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.r(i15, i7);
            if (I(obj2, i15, i4)) {
            }
            i = CodedOutputStream.j(i15, 0);
            i = obj.q.f(i15, w1.G(obj2, l), u(i4));
            i = n1.j(i15, w0.K(obj2, l), v(i4));
            i14 = n1.t((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            i29 += i14;
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.r((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.i((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.g((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.e((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.w((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.b((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.g((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.i((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.l((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.y((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.n((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.g((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i14 = n1.i((List)unsafe.getObject(obj2, l));
            if (i14 > 0 && obj.i) {
            }
            if (obj.i) {
            }
            i3 = CodedOutputStream.W(i15);
            i15 = CodedOutputStream.Y(i14);
            unsafe.putInt(obj2, (long)i, obj10);
            i = n1.s(i15, w0.K(obj2, l), i17);
            i = n1.q(i15, w0.K(obj2, l), i17);
            i = n1.h(i15, w0.K(obj2, l), i17);
            i = n1.f(i15, w0.K(obj2, l), i17);
            i = n1.d(i15, w0.K(obj2, l), i17);
            i = n1.v(i15, w0.K(obj2, l), i17);
            i = n1.c(i15, w0.K(obj2, l));
            i = n1.p(i15, w0.K(obj2, l), v(i4));
            i = n1.u(i15, w0.K(obj2, l));
            i = n1.a(i15, w0.K(obj2, l), i17);
            i = n1.f(i15, w0.K(obj2, l), i17);
            i = n1.h(i15, w0.K(obj2, l), i17);
            i = n1.k(i15, w0.K(obj2, l), i17);
            i = n1.x(i15, w0.K(obj2, l), i17);
            i = n1.m(i15, w0.K(obj2, l), i17);
            i = n1.f(i15, w0.K(obj2, l), i17);
            i = n1.h(i15, w0.K(obj2, l), i17);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.t(i15, (t0)w1.G(obj2, l), v(i4));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.S(i15, w1.E(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.Q(i15, w1.C(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.O(i15, i8);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.M(i15, i17);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.l(i15, w1.C(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.X(i15, w1.C(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.h(i15, (j)w1.G(obj2, l));
            if (C(obj2, i4)) {
            }
            i = n1.o(i15, w1.G(obj2, l), v(i4));
            if (C(obj2, i4)) {
            }
            Object obj8 = w1.G(obj2, l);
            if (obj8 instanceof j != 0) {
            } else {
            }
            i = CodedOutputStream.U(i15, (String)obj8);
            i = CodedOutputStream.h(i15, (j)obj8);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.e(i15, i5);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.n(i15, i17);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.p(i15, i8);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.w(i15, w1.C(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.Z(i15, w1.E(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.y(i15, w1.E(obj2, l));
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.r(i15, i7);
            if (C(obj2, i4)) {
            }
            i = CodedOutputStream.j(i15, 0);
            if (i14 <= w.SINT64_LIST_PACKED.id()) {
            } else {
            }
            i31 &= i5;
        }
        return i9 += i16;
    }

    private <UT, UB> void y0(com.google.protobuf.s1<UT, UB> s1, T t2, com.google.protobuf.z1 z13) {
        s1.t(s1.g(t2), z13);
    }

    private <UT, UB> int z(com.google.protobuf.s1<UT, UB> s1, T t2) {
        return s1.h(s1.g(t2));
    }

    public void a(T t, T t2) {
        int i;
        boolean z;
        int length;
        Objects.requireNonNull(t2);
        i = 0;
        while (i < iArr.length) {
            Q(t, t2, i);
            i += 3;
        }
        n1.G(this.o, t, t2);
        if (this.f) {
            n1.E(this.p, t, t2);
        }
    }

    public void b(T t, com.google.protobuf.z1 z12) {
        com.google.protobuf.z1.a aVar;
        if (z12.l() == z1.a.DESCENDING) {
            v0(t, z12);
        } else {
            if (this.h) {
                u0(t, z12);
            } else {
                t0(t, z12);
            }
        }
    }

    public void c(T t) {
        int i;
        boolean z;
        long l;
        int i2;
        long l2;
        Object obj;
        com.google.protobuf.o0 o0Var;
        i = this.k;
        while (i < this.l) {
            l = w0.V(s0(this.j[i]));
            obj = w1.G(t, l);
            if (obj == null) {
            } else {
            }
            w1.V(t, l, obj2);
            i++;
        }
        while (i2 < iArr.length) {
            this.n.c(t, (long)i5);
            i2++;
        }
        this.o.j(t);
        if (this.f) {
            this.p.f(t);
        }
    }

    public final boolean d(T t) {
        int i7;
        boolean z2;
        boolean i11;
        boolean z;
        int int;
        int i6;
        Object obj;
        int i10;
        int i4;
        int i8;
        int i9;
        int i14;
        int i5;
        int i13;
        int i;
        int i12;
        int i2;
        int i3;
        final Object obj4 = this;
        final Object obj5 = t;
        final int i18 = 1048575;
        final int i19 = 0;
        i7 = i18;
        i14 = int;
        i4 = 1;
        while (i14 < obj4.k) {
            i5 = obj4.j[i14];
            i = obj4.s0(i5);
            int i16 = obj4.a[i5 + 2];
            i8 = i16 & i18;
            i16 >>>= 20;
            i12 = i4 << i10;
            if (i8 != i7) {
            } else {
            }
            i2 = i7;
            i3 = int;
            i11 = w0.r0(i);
            i14++;
            i7 = i2;
            int = i3;
            i4 = 1;
            if (i8 != i18) {
            }
            i3 = int;
            i2 = i8;
            int = w0.s.getInt(obj5, (long)i8);
        }
        if (obj4.f && !obj4.p.c(obj5).p()) {
            if (!obj4.p.c(obj5).p()) {
                return i19;
            }
        }
        return i4;
    }

    int d0(T t, byte[] b2Arr2, int i3, int i4, int i5, com.google.protobuf.f.b f$b6) {
        int i17;
        byte b;
        Object object;
        boolean z2;
        int i8;
        int i18;
        int i13;
        int i14;
        int i2;
        int i;
        int valueOf;
        Object obj7;
        Object obj8;
        int z;
        byte[] bArr2;
        int i27;
        int i26;
        int inRange;
        Object i7;
        long l3;
        byte[] bArr;
        int i20;
        int i19;
        int i12;
        Object obj5;
        Object obj6;
        int int;
        com.google.protobuf.t0 t0Var;
        int i11;
        int i9;
        int i6;
        com.google.protobuf.f.b l4;
        Unsafe unsafe;
        Object obj4;
        byte b2;
        byte[] bArr3;
        long l;
        Object obj2;
        Object obj;
        Object obj3;
        int i21;
        int i22;
        int i23;
        int i24;
        int i16;
        long l5;
        int i15;
        int i25;
        int i10;
        Unsafe unsafe2;
        long l2;
        int obj33;
        obj3 = this;
        obj = t;
        bArr3 = b2Arr2;
        l = i4;
        b2 = i5;
        l4 = b6;
        unsafe = w0.s;
        final int i51 = 0;
        i17 = i3;
        int = i20;
        i8 = -1;
        i11 = 1048575;
        while (i17 < l) {
            b = bArr3[i17];
            if (b < 0) {
            } else {
            }
            obj5 = b;
            i17 = obj5 >>> 3;
            i9 = obj5 & 7;
            if (i17 > i8) {
            } else {
            }
            i2 = obj3.g0(i17);
            inRange = i2;
            valueOf = -1;
            valueOf = obj3.a[inRange + 1];
            i6 = w0.r0(valueOf);
            long l10 = w0.V(valueOf);
            i23 = obj5;
            i24 = valueOf;
            i21 = i17;
            obj5 = obj;
            i22 = -1;
            l = l10;
            b2 = i23;
            i23 = 1048575;
            bArr3 = b2Arr2;
            i16 = inRange;
            obj3 = i19;
            unsafe2 = unsafe;
            l4 = obj33;
            i6 = i5;
            i27 = i17;
            l4 = i23;
            Object obj13 = this;
            long l11 = b6;
            if (obj13.f && l11.d != q.b()) {
            } else {
            }
            i17 = f.G(l4, b2Arr2, i27, i4, w0.w(t), b6);
            obj = t;
            bArr3 = b2Arr2;
            l = i4;
            i20 = l4;
            obj3 = obj13;
            l4 = l11;
            i8 = i21;
            i27 = i16;
            int = i15;
            i11 = i25;
            unsafe = unsafe2;
            b2 = i6;
            if (l11.d != q.b()) {
            } else {
            }
            i17 = f.g(l4, b2Arr2, i27, i4, t, obj13.e, obj13.o, b6);
            obj3 = this;
            obj = t;
            bArr3 = b2Arr2;
            l = i4;
            b2 = i5;
            l4 = b6;
            i8 = i21;
            i20 = i23;
            i27 = i16;
            int = i15;
            i11 = i25;
            unsafe = unsafe2;
            i6 = i5;
            i27 = obj3;
            unsafe2 = unsafe;
            i23 = b2;
            i16 = inRange;
            i15 = int;
            i25 = i11;
            obj3 = i19;
            unsafe2 = unsafe;
            i23 = b2;
            object = unsafe.getObject(obj5, l);
            if (!(c0.j)object.c2()) {
            }
            i25 = i11;
            i17 = f.q(obj3.v(inRange), b2, b2Arr2, i19, i4, object, b6);
            obj = t;
            l = i4;
            i20 = b2;
            i8 = i21;
            i27 = i16;
            int = i15;
            i11 = i25;
            b2 = i5;
            int size = object.size();
            if (size == 0) {
            } else {
            }
            size *= 2;
            unsafe.putObject(obj5, l, obj);
            z = 10;
            int i46 = obj3.a[inRange + 2];
            i16 = i << i55;
            l = 1048575;
            i46 &= l;
            int i52 = inRange;
            if (i47 != i11) {
            } else {
            }
            i25 = i11;
            i11 = int;
            valueOf = 5;
            bArr3 = b2Arr2;
            obj5 = obj;
            i6 = i52;
            b2 = i23;
            i22 = -1;
            i21 = i17;
            i23 = l;
            i27 = i19;
            i15 = i11;
            i16 = i6;
            unsafe2 = unsafe;
            l4 = b2;
            i6 = i5;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            bArr3 = b2Arr2;
            obj5 = obj;
            b2 = i23;
            int i42 = i52;
            i22 = -1;
            i17 = f.n(obj3.v(i42), b2Arr2, i19, i4, i37 | 4, b6);
            if (i11 & i16 == 0) {
            } else {
            }
            unsafe.putObject(obj, l10, bArr3);
            int = i11 | i16;
            bArr3 = b2Arr2;
            l = i4;
            b2 = i5;
            i20 = i9;
            i27 = i6;
            i8 = i21;
            i11 = i25;
            unsafe.putObject(obj, l10, bArr3);
            i6 = i52;
            byte b7 = i23;
            i22 = -1;
            i21 = i17;
            bArr3 = b2Arr2;
            b2 = b7;
            obj5 = t;
            b2 = b7;
            unsafe.putLong(t, l10, i19);
            int = i11 | i16;
            obj = t;
            l = i4;
            i17 = i9;
            i27 = i6;
            i20 = b2;
            i8 = i21;
            i6 = i52;
            b2 = i23;
            i22 = -1;
            i21 = i17;
            obj5 = t;
            i23 = 1048575;
            i17 = f.I(b2Arr2, i19, l4);
            unsafe.putInt(t, l10, obj);
            int = i11 | i16;
            l = i4;
            obj = obj5;
            obj5 = obj;
            i22 = -1;
            i21 = i17;
            i17 = f.I(b2Arr2, i19, l4);
            valueOf = l4.a;
            inRange = obj3.t(i52);
            if (inRange != null) {
            } else {
            }
            unsafe.putInt(obj5, l10, obj);
            if (inRange.isInRange(valueOf)) {
            } else {
            }
            w0.w(t).q(i23, Long.valueOf((long)valueOf));
            l = i4;
            obj = obj5;
            int = i11;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i17 = f.b(b2Arr2, i19, l4);
            unsafe.putObject(obj, l10, obj);
            obj5 = obj;
            i22 = -1;
            i21 = i17;
            l = l10;
            b2 = i23;
            int = i4;
            i23 = 1048575;
            i17 = f.p(obj3.v(i52), b2Arr2, i19, i4, l4);
            if (i11 & i16 == 0) {
            } else {
            }
            unsafe.putObject(obj5, l, obj);
            obj = obj5;
            l = int;
            i27 = i6;
            i20 = b2;
            i11 = i25;
            b2 = i5;
            int = i36;
            i8 = i21;
            unsafe.putObject(obj5, l, obj);
            int = i4;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            bArr3 = b2Arr2;
            b2 = i23;
            i23 = l;
            if (i24 & i29 == 0) {
            } else {
            }
            i17 = f.F(bArr3, i19, l4);
            unsafe.putObject(obj, l10, obj);
            i17 = f.C(bArr3, i19, l4);
            int = i4;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            i17 = f.L(b2Arr2, i19, l4);
            if (Long.compare(l7, i10) != 0) {
            } else {
            }
            valueOf = i51;
            w1.L(obj, l10, obj);
            valueOf = 1;
            int = i4;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            unsafe.putInt(obj, l10, obj);
            i17 = i19 + 4;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            obj2 = obj5;
            unsafe.putLong(t, l10, i19);
            i17 = i9 + 8;
            int = i11 | i16;
            i27 = i6;
            i20 = b2;
            obj = obj2;
            i8 = i21;
            i11 = i25;
            l = i4;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            i17 = f.I(b2Arr2, i19, l4);
            unsafe.putInt(obj, l10, obj);
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            obj2 = obj5;
            unsafe.putLong(t, l10, i19);
            int = i11 | i16;
            i17 = i9;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            w1.S(obj, l10, obj);
            i17 = i19 + 4;
            i6 = i52;
            i22 = -1;
            i21 = i17;
            b2 = i23;
            i23 = l;
            w1.R(obj, l10, obj);
            i17 = i19 + 8;
            if (i11 != l) {
            }
            int = unsafe.getInt(obj, (long)i47);
            i25 = i47;
            unsafe.putInt(obj, (long)i11, inRange);
            i21 = i17;
            i22 = valueOf;
            i27 = i19;
            l4 = obj5;
            i15 = int;
            i25 = i11;
            unsafe2 = unsafe;
            i6 = b2;
            i16 = i51;
            i2 = obj3.h0(i17, i27 /= i50);
            obj5 = i44;
            i19 = b;
        }
        i15 = int;
        i25 = i11;
        unsafe2 = unsafe;
        i6 = b2;
        obj4 = obj3;
        i18 = 1048575;
        if (i11 != i18) {
            unsafe2.putInt(t, (long)i11, i27);
        } else {
            obj6 = t;
        }
        i13 = 0;
        i26 = obj4.k;
        while (i26 < obj4.l) {
            i13 = obj4.q(obj6, obj4.j[i26], i13, obj4.o);
            i26++;
        }
        if (i13 != 0) {
            obj4.o.o(obj6, i13);
        }
        if (i6 == 0) {
            if (i17 != i4) {
            } else {
                return i17;
            }
            throw InvalidProtocolBufferException.h();
        }
        if (i17 > i4) {
        } else {
            if (i20 != i6) {
            } else {
            }
        }
        throw InvalidProtocolBufferException.h();
    }

    public void e(T t, com.google.protobuf.j1 j12, com.google.protobuf.q q3) {
        Objects.requireNonNull(q3);
        this.M(this.o, this.p, t, j12, q3);
    }

    public void f(T t, byte[] b2Arr2, int i3, int i4, com.google.protobuf.f.b f$b5) {
        Object obj2;
        Object obj;
        byte[] bArr;
        int i;
        int i2;
        int i5;
        com.google.protobuf.f.b bVar;
        if (this.h) {
            e0(t, b2Arr2, i3, i4, b5);
        } else {
            this.d0(t, b2Arr2, i3, i4, 0, b5);
        }
    }

    public boolean g(T t, T t2) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < iArr.length) {
            i += 3;
        }
        if (!this.o.g(t).equals(this.o.g(t2))) {
            return i2;
        }
        if (this.f) {
            return this.p.c(t).equals(this.p.c(t2));
        }
        return 1;
    }

    public int h(T t) {
        int obj2;
        if (this.h) {
            obj2 = y(t);
        } else {
            obj2 = x(t);
        }
        return obj2;
    }

    public T i() {
        return this.m.a(this.e);
    }

    public int j(T t) {
        boolean z;
        int length;
        int i;
        int i3;
        int i2;
        int i6;
        boolean floatToIntBits;
        int i7;
        long l;
        int i4;
        Object obj9;
        i3 = i;
        while (i < iArr.length) {
            int i12 = s0(i);
            i7 = U(i);
            l = w0.V(i12);
            i4 = 37;
            i += 3;
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w1.G(t, l).hashCode();
            i6 += floatToIntBits;
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.f(w0.a0(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w0.Z(t, l);
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.f(w0.a0(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w0.Z(t, l);
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w0.Z(t, l);
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w0.Z(t, l);
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w1.G(t, l).hashCode();
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w1.G(t, l).hashCode();
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = (String)w1.G(t, l).hashCode();
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.c(w0.W(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w0.Z(t, l);
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.f(w0.a0(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = w0.Z(t, l);
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.f(w0.a0(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.f(w0.a0(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = Float.floatToIntBits(w0.Y(t, l));
            if (I(t, i7, i)) {
            }
            i3 *= 53;
            floatToIntBits = c0.f(Double.doubleToLongBits(w0.X(t, l)));
            i3 *= 53;
            floatToIntBits = w1.G(t, l).hashCode();
            i3 *= 53;
            floatToIntBits = w1.G(t, l).hashCode();
            floatToIntBits = w1.G(t, l);
            if (floatToIntBits != null) {
            }
            i11 += i4;
            i4 = floatToIntBits.hashCode();
            i3 *= 53;
            floatToIntBits = c0.f(w1.E(t, l));
            i3 *= 53;
            floatToIntBits = w1.C(t, l);
            i3 *= 53;
            floatToIntBits = c0.f(w1.E(t, l));
            i3 *= 53;
            floatToIntBits = w1.C(t, l);
            i3 *= 53;
            floatToIntBits = w1.C(t, l);
            i3 *= 53;
            floatToIntBits = w1.C(t, l);
            i3 *= 53;
            floatToIntBits = w1.G(t, l).hashCode();
            floatToIntBits = w1.G(t, l);
            if (floatToIntBits != null) {
            }
            i4 = floatToIntBits.hashCode();
            i3 *= 53;
            floatToIntBits = (String)w1.G(t, l).hashCode();
            i3 *= 53;
            floatToIntBits = c0.c(w1.t(t, l));
            i3 *= 53;
            floatToIntBits = w1.C(t, l);
            i3 *= 53;
            floatToIntBits = c0.f(w1.E(t, l));
            i3 *= 53;
            floatToIntBits = w1.C(t, l);
            i3 *= 53;
            floatToIntBits = c0.f(w1.E(t, l));
            i3 *= 53;
            floatToIntBits = c0.f(w1.E(t, l));
            i3 *= 53;
            floatToIntBits = Float.floatToIntBits(w1.B(t, l));
            i3 *= 53;
            floatToIntBits = c0.f(Double.doubleToLongBits(w1.A(t, l)));
        }
        if (this.f) {
            i10 += obj9;
        }
        return i2;
    }
}
