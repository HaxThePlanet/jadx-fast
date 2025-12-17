package com.google.protobuf;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class n1 {

    private static final Class<?> a;
    private static final com.google.protobuf.s1<?, ?> b;
    private static final com.google.protobuf.s1<?, ?> c;
    private static final com.google.protobuf.s1<?, ?> d;
    static {
        n1.a = n1.B();
        n1.b = n1.C(false);
        n1.c = n1.C(true);
        u1 u1Var = new u1();
        n1.d = u1Var;
    }

    static <UT, UB> UB A(int i, List<Integer> list2, com.google.protobuf.c0.e c0$e3, UB ub4, com.google.protobuf.s1<UT, UB> s15) {
        int size;
        boolean intValue2;
        int inRange2;
        int i2;
        int intValue;
        boolean inRange;
        int obj5;
        Object obj6;
        Object obj8;
        if (e3 == null) {
            return ub4;
        }
        if (list2 instanceof RandomAccess) {
            size = list2.size();
            i2 = inRange2;
            while (inRange2 < size) {
                intValue = (Integer)list2.get(inRange2).intValue();
                if (e3.isInRange(intValue)) {
                } else {
                }
                obj8 = n1.L(i, intValue, obj8, s15);
                inRange2++;
                if (inRange2 != i2) {
                }
                i2++;
                list2.set(i2, Integer.valueOf(intValue));
            }
            if (i2 != size) {
                list2.subList(i2, size).clear();
            }
        } else {
            obj6 = list2.iterator();
            while (obj6.hasNext()) {
                intValue2 = (Integer)obj6.next().intValue();
                if (!e3.isInRange(intValue2)) {
                }
                obj8 = n1.L(i, intValue2, obj8, s15);
                obj6.remove();
            }
        }
        return obj8;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
            return 0;
        }
    }

    private static com.google.protobuf.s1<?, ?> C(boolean z) {
        Class cls = n1.D();
        if (cls == null) {
            try {
                return 0;
                int i2 = 1;
                final Class[] arr2 = new Class[i2];
                final int i3 = 0;
                arr2[i3] = Boolean.TYPE;
                Object[] arr = new Object[i2];
                arr[i3] = Boolean.valueOf(z);
                return (s1)cls.getConstructor(arr2).newInstance(arr);
                return obj0;
            }
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
            return 0;
        }
    }

    static <T, FT extends com.google.protobuf.v.b<FT>> void E(com.google.protobuf.r<FT> r, T t2, T t3) {
        com.google.protobuf.v obj1;
        final com.google.protobuf.v obj3 = r.c(t3);
        if (!obj3.n()) {
            r.d(t2).u(obj3);
        }
    }

    static <T> void F(com.google.protobuf.o0 o0, T t2, T t3, long l4) {
        w1.V(t2, l4, obj5);
    }

    static <T, UT, UB> void G(com.google.protobuf.s1<UT, UB> s1, T t2, T t3) {
        s1.p(t2, s1.k(s1.g(t2), s1.g(t3)));
    }

    public static com.google.protobuf.s1<?, ?> H() {
        return n1.b;
    }

    public static com.google.protobuf.s1<?, ?> I() {
        return n1.c;
    }

    public static void J(Class<?> class) {
        boolean assignableFrom;
        Class obj1;
        assignableFrom = n1.a;
        if (!z.class.isAssignableFrom(class) && assignableFrom != null) {
            assignableFrom = n1.a;
            if (assignableFrom != null) {
                if (!assignableFrom.isAssignableFrom(class)) {
                } else {
                }
                obj1 = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                throw obj1;
            }
        }
    }

    static boolean K(Object object, Object object2) {
        boolean obj0;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj0 = 1;
                } else {
                    obj0 = 0;
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    static <UT, UB> UB L(int i, int i2, UB ub3, com.google.protobuf.s1<UT, UB> s14) {
        Object obj4;
        if (ub3 == null) {
            obj4 = s14.n();
        }
        s14.e(obj4, i, (long)i2);
        return obj4;
    }

    public static com.google.protobuf.s1<?, ?> M() {
        return n1.d;
    }

    public static void N(int i, List<Boolean> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.B(i, list2, z4);
            }
        }
    }

    public static void O(int i, List<com.google.protobuf.j> list2, com.google.protobuf.z1 z13) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.O(i, list2);
            }
        }
    }

    public static void P(int i, List<Double> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.M(i, list2, z4);
            }
        }
    }

    public static void Q(int i, List<Integer> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.L(i, list2, z4);
            }
        }
    }

    public static void R(int i, List<Integer> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.A(i, list2, z4);
            }
        }
    }

    public static void S(int i, List<Long> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.x(i, list2, z4);
            }
        }
    }

    public static void T(int i, List<Float> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.c(i, list2, z4);
            }
        }
    }

    public static void U(int i, List<?> list2, com.google.protobuf.z1 z13, com.google.protobuf.l1 l14) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.b(i, list2, l14);
            }
        }
    }

    public static void V(int i, List<Integer> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.p(i, list2, z4);
            }
        }
    }

    public static void W(int i, List<Long> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.K(i, list2, z4);
            }
        }
    }

    public static void X(int i, List<?> list2, com.google.protobuf.z1 z13, com.google.protobuf.l1 l14) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.a(i, list2, l14);
            }
        }
    }

    public static void Y(int i, List<Integer> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.y(i, list2, z4);
            }
        }
    }

    public static void Z(int i, List<Long> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.h(i, list2, z4);
            }
        }
    }

    static int a(int i, List<?> list2, boolean z3) {
        int obj1 = list2.size();
        if (obj1 == null) {
            return 0;
        }
        if (z3) {
            return obj0 += obj1;
        }
        return obj1 *= obj0;
    }

    public static void a0(int i, List<Integer> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.I(i, list2, z4);
            }
        }
    }

    static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i, List<Long> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.E(i, list2, z4);
            }
        }
    }

    static int c(int i, List<com.google.protobuf.j> list2) {
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

    public static void c0(int i, List<String> list2, com.google.protobuf.z1 z13) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.m(i, list2);
            }
        }
    }

    static int d(int i, List<Integer> list2, boolean z3) {
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        int obj2 = n1.e(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 += i2;
    }

    public static void d0(int i, List<Integer> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.D(i, list2, z4);
            }
        }
    }

    static int e(List<Integer> list) {
        int i3;
        int i;
        int i2;
        final int size = list.size();
        i3 = 0;
        if (size == 0) {
            return i3;
        }
        if (list instanceof b0) {
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

    public static void e0(int i, List<Long> list2, com.google.protobuf.z1 z13, boolean z4) {
        boolean empty;
        if (list2 != null && !list2.isEmpty()) {
            if (!list2.isEmpty()) {
                z13.i(i, list2, z4);
            }
        }
    }

    static int f(int i, List<?> list2, boolean z3) {
        int obj2 = list2.size();
        final int i2 = 0;
        if (obj2 == null) {
            return i2;
        }
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 *= obj1;
    }

    static int g(List<?> list) {
        return obj0 *= 4;
    }

    static int h(int i, List<?> list2, boolean z3) {
        int obj3 = list2.size();
        if (obj3 == null) {
            return 0;
        }
        if (z3) {
            return obj2 += obj3;
        }
        return obj3 *= obj2;
    }

    static int i(List<?> list) {
        return obj0 *= 8;
    }

    static int j(int i, List<com.google.protobuf.t0> list2, com.google.protobuf.l1 l13) {
        int i2;
        int i4;
        int i3;
        final int size = list2.size();
        i2 = 0;
        if (size == 0) {
            return i2;
        }
        i4 = i2;
        while (i2 < size) {
            i4 += i3;
            i2++;
        }
        return i4;
    }

    static int k(int i, List<Integer> list2, boolean z3) {
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        int obj2 = n1.l(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 += i2;
    }

    static int l(List<Integer> list) {
        int i;
        int i3;
        int i2;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        if (list instanceof b0) {
            i3 = i;
            while (i < size) {
                i3 += i2;
                i++;
            }
        } else {
            i3 = i;
            while (i < size) {
                i3 += i2;
                i++;
            }
        }
        return i3;
    }

    static int m(int i, List<Long> list2, boolean z3) {
        if (list2.size() == 0) {
            return 0;
        }
        int i2 = n1.n(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return i2 += obj2;
    }

    static int n(List<Long> list) {
        int i;
        int i2;
        int i3;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        if (list instanceof k0) {
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

    static int o(int i, Object object2, com.google.protobuf.l1 l13) {
        if (object2 instanceof g0) {
            return CodedOutputStream.B(i, (g0)object2);
        }
        return CodedOutputStream.G(i, (t0)object2, l13);
    }

    static int p(int i, List<?> list2, com.google.protobuf.l1 l13) {
        int i2;
        int i3;
        boolean z;
        int obj4;
        final int size = list2.size();
        if (size == 0) {
            return 0;
        }
        obj4 *= size;
        while (i2 < size) {
            Object obj = list2.get(i2);
            if (obj instanceof g0) {
            } else {
            }
            i3 = CodedOutputStream.I((t0)obj, l13);
            obj4 += i3;
            i2++;
            i3 = CodedOutputStream.C((g0)obj);
        }
        return obj4;
    }

    static int q(int i, List<Integer> list2, boolean z3) {
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        int obj2 = n1.r(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 += i2;
    }

    static int r(List<Integer> list) {
        int i2;
        int i3;
        int i;
        final int size = list.size();
        i2 = 0;
        if (size == 0) {
            return i2;
        }
        if (list instanceof b0) {
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

    static int s(int i, List<Long> list2, boolean z3) {
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        int obj2 = n1.t(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 += i2;
    }

    static int t(List<Long> list) {
        int i2;
        int i;
        int i3;
        final int size = list.size();
        i2 = 0;
        if (size == 0) {
            return i2;
        }
        if (list instanceof k0) {
            i = i2;
            while (i2 < size) {
                i += i3;
                i2++;
            }
        } else {
            i = i2;
            while (i2 < size) {
                i += i3;
                i2++;
            }
        }
        return i;
    }

    static int u(int i, List<?> list2) {
        int i2;
        boolean z;
        boolean z2;
        int obj4;
        final int size = list2.size();
        if (size == 0) {
            return 0;
        }
        obj4 *= size;
        if (list2 instanceof i0) {
            while (i2 < size) {
                Object obj = (i0)list2.O1(i2);
                if (obj instanceof j) {
                } else {
                }
                z = CodedOutputStream.V((String)obj);
                obj4 += z;
                i2++;
                z = CodedOutputStream.i((j)obj);
            }
        }
        return obj4;
    }

    static int v(int i, List<Integer> list2, boolean z3) {
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        int obj2 = n1.w(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 += i2;
    }

    static int w(List<Integer> list) {
        int i;
        int i2;
        int i3;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        if (list instanceof b0) {
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

    static int x(int i, List<Long> list2, boolean z3) {
        int size = list2.size();
        if (size == 0) {
            return 0;
        }
        int obj2 = n1.y(list2);
        if (z3) {
            return obj1 += obj2;
        }
        return obj2 += i2;
    }

    static int y(List<Long> list) {
        int i;
        int i2;
        int i3;
        final int size = list.size();
        i = 0;
        if (size == 0) {
            return i;
        }
        if (list instanceof k0) {
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

    static <UT, UB> UB z(int i, List<Integer> list2, com.google.protobuf.c0.d<?> c0$d3, UB ub4, com.google.protobuf.s1<UT, UB> s15) {
        int size;
        boolean intValue;
        int valueByNumber2;
        int i2;
        int intValue2;
        com.google.protobuf.c0.c valueByNumber;
        int obj5;
        Object obj6;
        Object obj8;
        if (d3 == null) {
            return ub4;
        }
        if (list2 instanceof RandomAccess) {
            size = list2.size();
            i2 = valueByNumber2;
            while (valueByNumber2 < size) {
                intValue2 = (Integer)list2.get(valueByNumber2).intValue();
                if (d3.findValueByNumber(intValue2) != null) {
                } else {
                }
                obj8 = n1.L(i, intValue2, obj8, s15);
                valueByNumber2++;
                if (valueByNumber2 != i2) {
                }
                i2++;
                list2.set(i2, Integer.valueOf(intValue2));
            }
            if (i2 != size) {
                list2.subList(i2, size).clear();
            }
        } else {
            obj6 = list2.iterator();
            while (obj6.hasNext()) {
                intValue = (Integer)obj6.next().intValue();
                if (d3.findValueByNumber(intValue) == null) {
                }
                obj8 = n1.L(i, intValue, obj8, s15);
                obj6.remove();
            }
        }
        return obj8;
    }
}
