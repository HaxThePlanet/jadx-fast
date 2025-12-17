package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class hb {

    private static final Unsafe a;
    private static final Class<?> b;
    private static final boolean c;
    private static final boolean d;
    private static final com.google.android.gms.internal.measurement.gb e;
    private static final boolean f;
    private static final boolean g;
    static final long h;
    static final boolean i = false;
    static {
        Class<double[]> obj;
        int i2;
        Class<Object> obj2;
        String str2;
        int i;
        Object class;
        Class tYPE;
        String str;
        int fbVar;
        Class[] str4;
        Class<Field> str3;
        Class<Object[]> obj3 = Object[].class;
        obj = double[].class;
        final Class<float[]> obj4 = float[].class;
        final Class<long[]> obj5 = long[].class;
        final Class<int[]> obj6 = int[].class;
        final Class<boolean[]> obj7 = boolean[].class;
        obj2 = Object.class;
        Unsafe unsafe = hb.l();
        hb.a = unsafe;
        hb.b = m7.a();
        tYPE = Long.TYPE;
        boolean z = hb.A(tYPE);
        hb.c = z;
        boolean z2 = hb.A(Integer.TYPE);
        hb.d = z2;
        fbVar = 0;
        if (unsafe == null) {
        } else {
            if (z) {
                fbVar = new fb(unsafe);
            } else {
                if (z2) {
                    fbVar = new eb(unsafe);
                }
            }
        }
        hb.e = fbVar;
        str2 = "getLong";
        str = "objectFieldOffset";
        int i4 = 2;
        int i5 = 1;
        final int i7 = 0;
        if (fbVar == 0) {
            i = i7;
        } else {
        }
        hb.f = i;
        class = hb.e;
        if (class == null) {
            i2 = i7;
        } else {
        }
        hb.g = i2;
        hb.h = (long)i3;
        hb.E(obj7);
        hb.a(obj7);
        hb.E(obj6);
        hb.a(obj6);
        hb.E(obj5);
        hb.a(obj5);
        hb.E(obj4);
        hb.a(obj4);
        hb.E(obj);
        hb.a(obj);
        hb.E(obj3);
        hb.a(obj3);
        Field field = hb.b();
        obj = hb.e;
        if (field != null && obj != null) {
            obj = hb.e;
            if (obj != null) {
                obj.l(field);
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
        }
        int i6 = i7;
    }

    static boolean A(Class<?> class) {
        final Class<byte[]> obj = byte[].class;
        int i = m7.a;
        int i2 = 0;
        final Class cls = hb.b;
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
        return hb.e.g(object, l2);
    }

    static boolean C() {
        return hb.g;
    }

    static boolean D() {
        return hb.f;
    }

    private static int E(Class<?> class) {
        if (hb.g) {
            return hb.e.h(class);
        }
        return -1;
    }

    private static int a(Class<?> class) {
        if (hb.g) {
            return hb.e.i(class);
        }
        return -1;
    }

    private static Field b() {
        Field field;
        Object type;
        Class tYPE;
        int i = m7.a;
        Field field2 = hb.c(Buffer.class, "address");
        if (hb.c(Buffer.class, "effectiveDirectAddress") == null && field2 != null && field2.getType() == Long.TYPE) {
            field2 = hb.c(Buffer.class, "address");
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
        final com.google.android.gms.internal.measurement.gb gbVar = hb.e;
        obj6 <<= 3;
        int obj7 = 255;
        gbVar.n(object, i2, obj1);
    }

    private static void e(Object object, long l2, byte b3) {
        i &= l2;
        final com.google.android.gms.internal.measurement.gb gbVar = hb.e;
        obj6 <<= 3;
        int obj7 = 255;
        gbVar.n(object, i2, obj1);
    }

    static double f(Object object, long l2) {
        return hb.e.a(object, l2);
    }

    static float g(Object object, long l2) {
        return hb.e.b(object, l2);
    }

    static int h(Object object, long l2) {
        return hb.e.j(object, l2);
    }

    static long i(Object object, long l2) {
        return hb.e.k(object, l2);
    }

    static <T> T j(Class<T> class) {
        try {
            return hb.a.allocateInstance(class);
            IllegalStateException illegalStateException = new IllegalStateException(class);
            throw illegalStateException;
        }
    }

    static Object k(Object object, long l2) {
        return hb.e.m(object, l2);
    }

    static Unsafe l() {
        Object doPrivileged;
        try {
            db dbVar = new db();
            doPrivileged = AccessController.doPrivileged(dbVar);
            int i = 0;
            return doPrivileged;
        }
    }

    static void m(Throwable throwable) {
        Logger.getLogger(hb.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(throwable.toString()));
    }

    static void n(Object object, long l2, byte b3) {
        hb.d(object, l2, b3);
    }

    static void o(Object object, long l2, byte b3) {
        hb.e(object, l2, b3);
    }

    static void p(Object object, long l2, boolean z3) {
        hb.d(object, l2, z3);
    }

    static void q(Object object, long l2, boolean z3) {
        hb.e(object, l2, z3);
    }

    static void r(Object object, long l2, boolean z3) {
        hb.e.c(object, l2, z3);
    }

    static void s(byte[] bArr, long l2, byte b3) {
        hb.e.d(bArr, l += l2, obj2);
    }

    static void t(Object object, long l2, double d3) {
        hb.e.e(object, l2, obj3);
    }

    static void u(Object object, long l2, float f3) {
        hb.e.f(object, l2, f3);
    }

    static void v(Object object, long l2, int i3) {
        hb.e.n(object, l2, i3);
    }

    static void w(Object object, long l2, long l3) {
        hb.e.o(object, l2, obj3);
    }

    static void x(Object object, long l2, Object object3) {
        hb.e.p(object, l2, object3);
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
