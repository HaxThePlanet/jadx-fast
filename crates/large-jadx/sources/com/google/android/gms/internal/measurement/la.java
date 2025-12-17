package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class la {

    private static final Class<?> a = null;
    private static final com.google.android.gms.internal.measurement.xa<?, ?> b;
    private static final com.google.android.gms.internal.measurement.xa<?, ?> c;
    private static final com.google.android.gms.internal.measurement.xa<?, ?> d;
    static {
        try {
            Class forName = Class.forName("com.google.protobuf.GeneratedMessage");
            int zaVar = 0;
            zaVar = 0;
            zaVar = la.C(zaVar);
            la.b = zaVar;
            zaVar = 1;
            zaVar = la.C(zaVar);
            la.c = zaVar;
            zaVar = new za();
            la.d = zaVar;
        }
    }

    static int A(int i, List<?> list2, boolean z3) {
        int obj1 = list2.size();
        if (obj1 == null) {
            return 0;
        }
        return obj1 *= obj0;
    }

    public static void B(int i, List<Long> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.k(i, list2, z4);
            }
        }
    }

    private static com.google.android.gms.internal.measurement.xa<?, ?> C(boolean z) {
        Class forName;
        forName = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        if (forName == null) {
            return 0;
        }
        int i2 = 1;
        final Class[] arr2 = new Class[i2];
        final int i3 = 0;
        arr2[i3] = Boolean.TYPE;
        Object[] arr = new Object[i2];
        arr[i3] = Boolean.valueOf(z);
        return (xa)forName.getConstructor(arr2).newInstance(arr);
    }

    static int D(List<?> list) {
        return list.size();
    }

    static int E(int i, List<com.google.android.gms.internal.measurement.x7> list2) {
        int i3;
        int i2;
        int obj2;
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        size *= obj2;
        while (i2 < list2.size()) {
            i3 += obj2;
            i2++;
        }
        return i3;
    }

    static int F(int i, List<Integer> list2, boolean z3) {
        int obj2 = list2.size();
        if (obj2 == null) {
            return 0;
        }
        return obj1 += obj2;
    }

    static int G(List<Integer> list) {
        int i2;
        int i3;
        int i;
        final int size = list.size();
        i2 = 0;
        if (size == 0) {
            return i2;
        }
        if (list instanceof x8) {
            i3 = i2;
            while (i2 < size) {
                i3 += i;
                i2++;
            }
        } else {
            i3 = i2;
            while (i2 < size) {
                i3 += i;
                i2++;
            }
        }
        return i3;
    }

    static int H(int i, List<?> list2, boolean z3) {
        int obj1 = list2.size();
        if (obj1 == null) {
            return 0;
        }
        return obj1 *= obj0;
    }

    static int I(List<?> list) {
        return obj0 *= 4;
    }

    static int J(int i, List<?> list2, boolean z3) {
        int obj1 = list2.size();
        if (obj1 == null) {
            return 0;
        }
        return obj1 *= obj0;
    }

    static int K(List<?> list) {
        return obj0 *= 8;
    }

    static int L(int i, List<com.google.android.gms.internal.measurement.y9> list2, com.google.android.gms.internal.measurement.ja ja3) {
        int i4;
        int i2;
        int i3;
        final int size = list2.size();
        i4 = 0;
        if (size != 0) {
            i2 = i4;
            while (i4 < size) {
                i2 += i3;
                i4++;
            }
            return i2;
        }
        return i4;
    }

    static int M(int i, List<Integer> list2, boolean z3) {
        int obj2 = list2.size();
        if (obj2 == null) {
            return 0;
        }
        return obj1 += obj2;
    }

    static int N(List<Integer> list) {
        int i3;
        int i;
        int i2;
        final int size = list.size();
        i3 = 0;
        if (size == 0) {
            return i3;
        }
        if (list instanceof x8) {
            i = i3;
            while (i3 < size) {
                i += i2;
                i3++;
            }
        } else {
            i = i3;
            while (i3 < size) {
                i += i2;
                i3++;
            }
        }
        return i;
    }

    static int O(int i, List<Long> list2, boolean z3) {
        if (list2.size() == 0) {
            return 0;
        }
        return obj2 += obj1;
    }

    static int P(List<Long> list) {
        int i;
        int i2;
        int i3;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        if (list instanceof m9) {
            i2 = i;
            while (i < size) {
                i2 += i3;
                i++;
            }
        } else {
            i2 = i;
            while (i < size) {
                i2 += i3;
                i++;
            }
        }
        return i2;
    }

    static int Q(int i, Object object2, com.google.android.gms.internal.measurement.ja ja3) {
        if (object2 instanceof f9) {
            int obj2 = (f9)object2.a();
            return obj1 += obj3;
        }
        return obj1 += obj2;
    }

    static int R(int i, List<?> list2, com.google.android.gms.internal.measurement.ja ja3) {
        int i3;
        int i2;
        boolean z;
        int obj4;
        final int size = list2.size();
        if (size == 0) {
            return 0;
        }
        obj4 *= size;
        while (i3 < size) {
            Object obj = list2.get(i3);
            if (obj instanceof f9) {
            } else {
            }
            i2 = e8.B((y9)obj, ja3);
            obj4 += i2;
            i3++;
            i2 = e8.A((f9)obj);
        }
        return obj4;
    }

    static int S(int i, List<Integer> list2, boolean z3) {
        int obj2 = list2.size();
        if (obj2 == null) {
            return 0;
        }
        return obj1 += obj2;
    }

    static int T(List<Integer> list) {
        int i2;
        int i3;
        int i4;
        int i;
        final int size = list.size();
        i2 = 0;
        if (size == 0) {
            return i2;
        }
        if (list instanceof x8) {
            i3 = i2;
            while (i2 < size) {
                int i5 = (x8)list.d(i2);
                i3 += i4;
                i2++;
            }
        } else {
            i3 = i2;
            while (i2 < size) {
                int intValue = (Integer)list.get(i2).intValue();
                i3 += i4;
                i2++;
            }
        }
        return i3;
    }

    static int U(int i, List<Long> list2, boolean z3) {
        int obj2 = list2.size();
        if (obj2 == null) {
            return 0;
        }
        return obj1 += obj2;
    }

    static int V(List<Long> list) {
        int i;
        int i2;
        int i4;
        int i3;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        final int i5 = 63;
        if (list instanceof m9) {
            i2 = i;
            while (i < size) {
                long l = (m9)list.e(i);
                i2 += i4;
                i++;
            }
        } else {
            i2 = i;
            while (i < size) {
                long longValue = (Long)list.get(i).longValue();
                i2 += i4;
                i++;
            }
        }
        return i2;
    }

    static int W(int i, List<?> list2) {
        int i2;
        boolean z2;
        boolean z;
        int obj4;
        final int size = list2.size();
        if (size == 0) {
            return 0;
        }
        obj4 *= size;
        if (list2 instanceof h9) {
            while (i2 < size) {
                Object obj = (h9)list2.j(i2);
                if (obj instanceof x7) {
                } else {
                }
                z2 = e8.C((String)obj);
                obj4 += z2;
                i2++;
                z2 = e8.x((x7)obj);
            }
        }
        return obj4;
    }

    static int X(int i, List<Integer> list2, boolean z3) {
        int obj2 = list2.size();
        if (obj2 == null) {
            return 0;
        }
        return obj1 += obj2;
    }

    static int Y(List<Integer> list) {
        int i2;
        int i3;
        int i;
        final int size = list.size();
        i2 = 0;
        if (size == 0) {
            return i2;
        }
        if (list instanceof x8) {
            i3 = i2;
            while (i2 < size) {
                i3 += i;
                i2++;
            }
        } else {
            i3 = i2;
            while (i2 < size) {
                i3 += i;
                i2++;
            }
        }
        return i3;
    }

    static int Z(int i, List<Long> list2, boolean z3) {
        int obj2 = list2.size();
        if (obj2 == null) {
            return 0;
        }
        return obj1 += obj2;
    }

    public static com.google.android.gms.internal.measurement.xa<?, ?> a() {
        return la.c;
    }

    static int a0(List<Long> list) {
        int i;
        int i2;
        int i3;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        if (list instanceof m9) {
            i2 = i;
            while (i < size) {
                i2 += i3;
                i++;
            }
        } else {
            i2 = i;
            while (i < size) {
                i2 += i3;
                i++;
            }
        }
        return i2;
    }

    public static com.google.android.gms.internal.measurement.xa<?, ?> b() {
        return la.d;
    }

    public static com.google.android.gms.internal.measurement.xa<?, ?> b0() {
        return la.b;
    }

    static <UT, UB> UB c(int i, List<Integer> list2, com.google.android.gms.internal.measurement.z8 z83, UB ub4, com.google.android.gms.internal.measurement.xa<UT, UB> xa5) {
        boolean intValue;
        int size;
        int i3;
        int i2;
        int intValue2;
        boolean z;
        Object obj6;
        Object obj8;
        if (z83 == null) {
            return ub4;
        }
        if (list2 instanceof RandomAccess) {
            size = list2.size();
            i2 = i3;
            while (i3 < size) {
                intValue2 = (Integer)list2.get(i3).intValue();
                if (z83.e(intValue2)) {
                } else {
                }
                obj8 = la.d(i, intValue2, obj8, xa5);
                i3++;
                if (i3 != i2) {
                }
                i2++;
                list2.set(i2, Integer.valueOf(intValue2));
            }
            if (i2 == size) {
                return obj8;
            }
            list2.subList(i2, size).clear();
            return obj8;
        }
        obj6 = list2.iterator();
        while (obj6.hasNext()) {
            intValue = (Integer)obj6.next().intValue();
            if (!z83.e(intValue)) {
            }
            obj8 = la.d(i, intValue, obj8, xa5);
            obj6.remove();
        }
    }

    static <UT, UB> UB d(int i, int i2, UB ub3, com.google.android.gms.internal.measurement.xa<UT, UB> xa4) {
        Object obj4;
        if (ub3 == null) {
            obj4 = xa4.e();
        }
        xa4.f(obj4, i, (long)i2);
        return obj4;
    }

    static <T, FT extends com.google.android.gms.internal.measurement.n8<FT>> void e(com.google.android.gms.internal.measurement.k8<FT> k8, T t2, T t3) {
        k8.a(t3);
        throw 0;
    }

    static <T, UT, UB> void f(com.google.android.gms.internal.measurement.xa<UT, UB> xa, T t2, T t3) {
        xa.h(t2, xa.d(xa.c(t2), xa.c(t3)));
    }

    public static void g(Class<?> class) {
        boolean assignableFrom;
        Class obj1;
        assignableFrom = la.a;
        if (!w8.class.isAssignableFrom(class) && assignableFrom != null) {
            assignableFrom = la.a;
            if (assignableFrom != null) {
                if (!assignableFrom.isAssignableFrom(class)) {
                } else {
                }
                obj1 = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                throw obj1;
            }
        }
    }

    static boolean h(Object object, Object object2) {
        int i;
        boolean obj2;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    i = i2;
                }
                return 0;
            }
        } else {
        }
        return i;
    }

    static <T> void i(com.google.android.gms.internal.measurement.s9 s9, T t2, T t3, long l4) {
        hb.x(t2, l4, obj4);
    }

    public static void j(int i, List<Boolean> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.n(i, list2, z4);
            }
        }
    }

    public static void k(int i, List<com.google.android.gms.internal.measurement.x7> list2, com.google.android.gms.internal.measurement.f8 f83) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.p(i, list2);
            }
        }
    }

    public static void l(int i, List<Double> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.r(i, list2, z4);
            }
        }
    }

    public static void m(int i, List<Integer> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.u(i, list2, z4);
            }
        }
    }

    public static void n(int i, List<Integer> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.w(i, list2, z4);
            }
        }
    }

    public static void o(int i, List<Long> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.y(i, list2, z4);
            }
        }
    }

    public static void p(int i, List<Float> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.A(i, list2, z4);
            }
        }
    }

    public static void q(int i, List<?> list2, com.google.android.gms.internal.measurement.f8 f83, com.google.android.gms.internal.measurement.ja ja4) {
        int empty;
        Object size;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                empty = 0;
                while (empty < list2.size()) {
                    f83.B(i, list2.get(empty), ja4);
                    empty++;
                }
            }
        }
    }

    public static void r(int i, List<Integer> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.D(i, list2, z4);
            }
        }
    }

    public static void s(int i, List<Long> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.F(i, list2, z4);
            }
        }
    }

    public static void t(int i, List<?> list2, com.google.android.gms.internal.measurement.f8 f83, com.google.android.gms.internal.measurement.ja ja4) {
        int empty;
        Object size;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                empty = 0;
                while (empty < list2.size()) {
                    f83.G(i, list2.get(empty), ja4);
                    empty++;
                }
            }
        }
    }

    public static void u(int i, List<Integer> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.I(i, list2, z4);
            }
        }
    }

    public static void v(int i, List<Long> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.K(i, list2, z4);
            }
        }
    }

    public static void w(int i, List<Integer> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.b(i, list2, z4);
            }
        }
    }

    public static void x(int i, List<Long> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.d(i, list2, z4);
            }
        }
    }

    public static void y(int i, List<String> list2, com.google.android.gms.internal.measurement.f8 f83) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.g(i, list2);
            }
        }
    }

    public static void z(int i, List<Integer> list2, com.google.android.gms.internal.measurement.f8 f83, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                f83.i(i, list2, z4);
            }
        }
    }
}
