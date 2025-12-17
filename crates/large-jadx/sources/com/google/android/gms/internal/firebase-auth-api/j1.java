package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class j1 {

    private static final Unsafe a;
    private static final Class<?> b;
    private static final boolean c;
    private static final boolean d;
    private static final com.google.android.gms.internal.firebase-auth-api.i1 e;
    private static final boolean f;
    private static final boolean g;
    static final long h;
    static final boolean i = false;
    static {
        Class<double[]> obj2;
        int i2;
        Class<Object> obj;
        String str4;
        int i;
        Object class;
        Class tYPE;
        String str2;
        int h1Var;
        Class[] str3;
        Class<Field> str;
        Class<Object[]> obj3 = Object[].class;
        obj2 = double[].class;
        final Class<float[]> obj4 = float[].class;
        final Class<long[]> obj5 = long[].class;
        final Class<int[]> obj6 = int[].class;
        final Class<boolean[]> obj7 = boolean[].class;
        obj = Object.class;
        Unsafe unsafe = j1.l();
        j1.a = unsafe;
        j1.b = lq.a();
        tYPE = Long.TYPE;
        boolean z = j1.A(tYPE);
        j1.c = z;
        boolean z2 = j1.A(Integer.TYPE);
        j1.d = z2;
        h1Var = 0;
        if (unsafe == null) {
        } else {
            if (z) {
                h1Var = new h1(unsafe);
            } else {
                if (z2) {
                    h1Var = new g1(unsafe);
                }
            }
        }
        j1.e = h1Var;
        str4 = "getLong";
        str2 = "objectFieldOffset";
        int i4 = 2;
        int i5 = 1;
        final int i7 = 0;
        if (h1Var == 0) {
            i = i7;
        } else {
        }
        j1.f = i;
        class = j1.e;
        if (class == null) {
            i2 = i7;
        } else {
        }
        j1.g = i2;
        j1.h = (long)i3;
        j1.E(obj7);
        j1.a(obj7);
        j1.E(obj6);
        j1.a(obj6);
        j1.E(obj5);
        j1.a(obj5);
        j1.E(obj4);
        j1.a(obj4);
        j1.E(obj2);
        j1.a(obj2);
        j1.E(obj3);
        j1.a(obj3);
        Field field = j1.b();
        obj2 = j1.e;
        if (field != null && obj2 != null) {
            obj2 = j1.e;
            if (obj2 != null) {
                obj2.l(field);
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
        }
        int i6 = i7;
    }

    static boolean A(Class<?> class) {
        final Class<byte[]> obj = byte[].class;
        int i = lq.a;
        int i2 = 0;
        final Class cls = j1.b;
        final int i3 = 2;
        Class[] arr = new Class[i3];
        arr[i2] = class;
        Class tYPE = Boolean.TYPE;
        final int i6 = 1;
        arr[i6] = tYPE;
        cls.getMethod("peekLong", arr);
        int i4 = 3;
        Class[] arr5 = new Class[i4];
        arr5[i2] = class;
        arr5[i6] = Long.TYPE;
        arr5[i3] = tYPE;
        cls.getMethod("pokeLong", arr5);
        Class[] arr6 = new Class[i4];
        arr6[i2] = class;
        Class tYPE4 = Integer.TYPE;
        arr6[i6] = tYPE4;
        arr6[i3] = tYPE;
        cls.getMethod("pokeInt", arr6);
        Class[] arr7 = new Class[i3];
        arr7[i2] = class;
        arr7[i6] = tYPE;
        cls.getMethod("peekInt", arr7);
        Class[] arr2 = new Class[i3];
        arr2[i2] = class;
        arr2[i6] = Byte.TYPE;
        cls.getMethod("pokeByte", arr2);
        Class[] arr3 = new Class[i6];
        arr3[i2] = class;
        cls.getMethod("peekByte", arr3);
        int i5 = 4;
        Class[] arr8 = new Class[i5];
        arr8[i2] = class;
        arr8[i6] = obj;
        arr8[i3] = tYPE4;
        arr8[i4] = tYPE4;
        cls.getMethod("pokeByteArray", arr8);
        Class[] arr4 = new Class[i5];
        arr4[i2] = class;
        arr4[i6] = obj;
        arr4[i3] = tYPE4;
        arr4[i4] = tYPE4;
        cls.getMethod("peekByteArray", arr4);
        return i6;
    }

    static boolean B(Object object, long l2) {
        return j1.e.g(object, l2);
    }

    static boolean C() {
        return j1.g;
    }

    static boolean D() {
        return j1.f;
    }

    private static int E(Class<?> class) {
        if (j1.g) {
            return j1.e.h(class);
        }
        return -1;
    }

    private static int a(Class<?> class) {
        if (j1.g) {
            return j1.e.i(class);
        }
        return -1;
    }

    private static Field b() {
        Field field;
        Object type;
        Class tYPE;
        int i = lq.a;
        Field field2 = j1.c(Buffer.class, "address");
        if (j1.c(Buffer.class, "effectiveDirectAddress") == null && field2 != null && field2.getType() == Long.TYPE) {
            field2 = j1.c(Buffer.class, "address");
            if (field2 != null) {
                if (field2.getType() == Long.TYPE) {
                    return field2;
                }
            }
            field = 0;
        }
        return field;
    }

    private static Field c(Class<?> class, String string2) {
        Field obj0;
        try {
            obj0 = class.getDeclaredField(string2);
            class = 0;
            return obj0;
        }
    }

    private static void d(Object object, long l2, byte b3) {
        i &= l2;
        final com.google.android.gms.internal.firebase-auth-api.i1 i1Var = j1.e;
        obj6 <<= 3;
        int obj7 = 255;
        i1Var.n(object, i2, obj1);
    }

    private static void e(Object object, long l2, byte b3) {
        i &= l2;
        final com.google.android.gms.internal.firebase-auth-api.i1 i1Var = j1.e;
        obj6 <<= 3;
        int obj7 = 255;
        i1Var.n(object, i2, obj1);
    }

    static double f(Object object, long l2) {
        return j1.e.a(object, l2);
    }

    static float g(Object object, long l2) {
        return j1.e.b(object, l2);
    }

    static int h(Object object, long l2) {
        return j1.e.j(object, l2);
    }

    static long i(Object object, long l2) {
        return j1.e.k(object, l2);
    }

    static <T> T j(Class<T> class) {
        try {
            return j1.a.allocateInstance(class);
            IllegalStateException illegalStateException = new IllegalStateException(class);
            throw illegalStateException;
        }
    }

    static Object k(Object object, long l2) {
        return j1.e.m(object, l2);
    }

    static Unsafe l() {
        Object doPrivileged;
        try {
            f1 f1Var = new f1();
            doPrivileged = AccessController.doPrivileged(f1Var);
            int i = 0;
            return doPrivileged;
        }
    }

    static void m(Throwable throwable) {
        String obj4 = String.valueOf(throwable);
        StringBuilder stringBuilder = new StringBuilder(length += 71);
        stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
        stringBuilder.append(obj4);
        Logger.getLogger(j1.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", stringBuilder.toString());
    }

    static void n(Object object, long l2, byte b3) {
        j1.d(object, l2, b3);
    }

    static void o(Object object, long l2, byte b3) {
        j1.e(object, l2, b3);
    }

    static void p(Object object, long l2, boolean z3) {
        j1.d(object, l2, z3);
    }

    static void q(Object object, long l2, boolean z3) {
        j1.e(object, l2, z3);
    }

    static void r(Object object, long l2, boolean z3) {
        j1.e.c(object, l2, z3);
    }

    static void s(byte[] bArr, long l2, byte b3) {
        j1.e.d(bArr, l += l2, obj2);
    }

    static void t(Object object, long l2, double d3) {
        j1.e.e(object, l2, obj3);
    }

    static void u(Object object, long l2, float f3) {
        j1.e.f(object, l2, f3);
    }

    static void v(Object object, long l2, int i3) {
        j1.e.n(object, l2, i3);
    }

    static void w(Object object, long l2, long l3) {
        j1.e.o(object, l2, obj3);
    }

    static void x(Object object, long l2, Object object3) {
        j1.e.p(object, l2, object3);
    }

    static boolean y(Object object, long l2) {
        if ((byte)obj3 != 0) {
            return 1;
        }
        return 0;
    }

    static boolean z(Object object, long l2) {
        if ((byte)obj3 != 0) {
            return 1;
        }
        return 0;
    }
}
