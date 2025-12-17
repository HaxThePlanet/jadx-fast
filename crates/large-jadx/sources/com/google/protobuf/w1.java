package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class w1 {

    private static final Unsafe a;
    private static final Class<?> b;
    private static final boolean c;
    private static final boolean d;
    private static final com.google.protobuf.w1.e e;
    private static final boolean f;
    private static final boolean g;
    static final long h;
    private static final long i;
    static final boolean j = false;

    static class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        public Unsafe a() {
            int i2;
            Object obj;
            boolean instance;
            int i;
            Class<Unsafe> obj2 = Unsafe.class;
            final Field[] declaredFields = obj2.getDeclaredFields();
            i2 = 0;
            int i3 = 0;
            while (i2 < declaredFields.length) {
                Field field = declaredFields[i2];
                field.setAccessible(true);
                obj = field.get(i3);
                i2++;
                i3 = 0;
            }
            return i3;
        }

        @Override // java.security.PrivilegedExceptionAction
        public Object run() {
            return a();
        }
    }

    private static abstract class e {

        Unsafe a;
        e(Unsafe unsafe) {
            super();
            this.a = unsafe;
        }

        public final int a(Class<?> class) {
            return this.a.arrayBaseOffset(class);
        }

        public final int b(Class<?> class) {
            return this.a.arrayIndexScale(class);
        }

        public abstract void c(long l, byte[] b2Arr2, long l3, long l4);

        public abstract boolean d(Object object, long l2);

        public abstract byte e(long l);

        public abstract byte f(Object object, long l2);

        public abstract double g(Object object, long l2);

        public abstract float h(Object object, long l2);

        public final int i(Object object, long l2) {
            return this.a.getInt(object, l2);
        }

        public abstract long j(long l);

        public final long k(Object object, long l2) {
            return this.a.getLong(object, l2);
        }

        public final Object l(Object object, long l2) {
            return this.a.getObject(object, l2);
        }

        public final long m(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void n(Object object, long l2, boolean z3);

        public abstract void o(Object object, long l2, byte b3);

        public abstract void p(Object object, long l2, double d3);

        public abstract void q(Object object, long l2, float f3);

        public final void r(Object object, long l2, int i3) {
            this.a.putInt(object, l2, i3);
        }

        public final void s(Object object, long l2, long l3) {
            this.a.putLong(object, l2, obj3);
        }

        public final void t(Object object, long l2, Object object3) {
            this.a.putObject(object, l2, object3);
        }

        public boolean u() {
            final Class<Object> obj = Object.class;
            Unsafe unsafe = this.a;
            final int i = 0;
            if (unsafe == null) {
                return i;
            }
            Class class = unsafe.getClass();
            final int i2 = 1;
            Class[] arr = new Class[i2];
            arr[i] = Field.class;
            class.getMethod("objectFieldOffset", arr);
            Class[] arr2 = new Class[i2];
            arr2[i] = Class.class;
            class.getMethod("arrayBaseOffset", arr2);
            Class[] arr3 = new Class[i2];
            arr3[i] = Class.class;
            class.getMethod("arrayIndexScale", arr3);
            int i3 = 2;
            Class[] arr4 = new Class[i3];
            arr4[i] = obj;
            final Class tYPE = Long.TYPE;
            arr4[i2] = tYPE;
            class.getMethod("getInt", arr4);
            int i4 = 3;
            Class[] arr6 = new Class[i4];
            arr6[i] = obj;
            arr6[i2] = tYPE;
            arr6[i3] = Integer.TYPE;
            class.getMethod("putInt", arr6);
            Class[] arr7 = new Class[i3];
            arr7[i] = obj;
            arr7[i2] = tYPE;
            class.getMethod("getLong", arr7);
            Class[] arr8 = new Class[i4];
            arr8[i] = obj;
            arr8[i2] = tYPE;
            arr8[i3] = tYPE;
            class.getMethod("putLong", arr8);
            Class[] arr9 = new Class[i3];
            arr9[i] = obj;
            arr9[i2] = tYPE;
            class.getMethod("getObject", arr9);
            Class[] arr5 = new Class[i4];
            arr5[i] = obj;
            arr5[i2] = tYPE;
            arr5[i3] = obj;
            class.getMethod("putObject", arr5);
            return i2;
        }

        public boolean v() {
            Unsafe unsafe = this.a;
            final int i = 0;
            if (unsafe == null) {
                return i;
            }
            Class class = unsafe.getClass();
            final int i2 = 1;
            Class[] arr = new Class[i2];
            arr[i] = Field.class;
            class.getMethod("objectFieldOffset", arr);
            Class[] arr2 = new Class[2];
            arr2[i] = Object.class;
            arr2[i2] = Long.TYPE;
            class.getMethod("getLong", arr2);
            if (w1.b() == null) {
                return i;
            }
            return i2;
        }
    }

    private static final class b extends com.google.protobuf.w1.e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.w1$e
        public void c(long l, byte[] b2Arr2, long l3, long l4) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.protobuf.w1$e
        public boolean d(Object object, long l2) {
            if (w1.j) {
                return w1.g(object, l2);
            }
            return w1.h(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public byte e(long l) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.protobuf.w1$e
        public byte f(Object object, long l2) {
            if (w1.j) {
                return w1.c(object, l2);
            }
            return w1.d(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public double g(Object object, long l2) {
            return Double.longBitsToDouble(k(object, l2));
        }

        @Override // com.google.protobuf.w1$e
        public float h(Object object, long l2) {
            return Float.intBitsToFloat(i(object, l2));
        }

        @Override // com.google.protobuf.w1$e
        public long j(long l) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.protobuf.w1$e
        public void n(Object object, long l2, boolean z3) {
            if (w1.j) {
                w1.i(object, l2, z3);
            } else {
                w1.j(object, l2, z3);
            }
        }

        @Override // com.google.protobuf.w1$e
        public void o(Object object, long l2, byte b3) {
            if (w1.j) {
                w1.e(object, l2, b3);
            } else {
                w1.f(object, l2, b3);
            }
        }

        @Override // com.google.protobuf.w1$e
        public void p(Object object, long l2, double d3) {
            this.s(object, l2, obj3);
        }

        @Override // com.google.protobuf.w1$e
        public void q(Object object, long l2, float f3) {
            r(object, l2, f3);
        }

        @Override // com.google.protobuf.w1$e
        public boolean v() {
            return 0;
        }
    }

    private static final class c extends com.google.protobuf.w1.e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.w1$e
        public void c(long l, byte[] b2Arr2, long l3, long l4) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.protobuf.w1$e
        public boolean d(Object object, long l2) {
            if (w1.j) {
                return w1.g(object, l2);
            }
            return w1.h(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public byte e(long l) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.protobuf.w1$e
        public byte f(Object object, long l2) {
            if (w1.j) {
                return w1.c(object, l2);
            }
            return w1.d(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public double g(Object object, long l2) {
            return Double.longBitsToDouble(k(object, l2));
        }

        @Override // com.google.protobuf.w1$e
        public float h(Object object, long l2) {
            return Float.intBitsToFloat(i(object, l2));
        }

        @Override // com.google.protobuf.w1$e
        public long j(long l) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.protobuf.w1$e
        public void n(Object object, long l2, boolean z3) {
            if (w1.j) {
                w1.i(object, l2, z3);
            } else {
                w1.j(object, l2, z3);
            }
        }

        @Override // com.google.protobuf.w1$e
        public void o(Object object, long l2, byte b3) {
            if (w1.j) {
                w1.e(object, l2, b3);
            } else {
                w1.f(object, l2, b3);
            }
        }

        @Override // com.google.protobuf.w1$e
        public void p(Object object, long l2, double d3) {
            this.s(object, l2, obj3);
        }

        @Override // com.google.protobuf.w1$e
        public void q(Object object, long l2, float f3) {
            r(object, l2, f3);
        }

        @Override // com.google.protobuf.w1$e
        public boolean v() {
            return 0;
        }
    }

    private static final class d extends com.google.protobuf.w1.e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.w1$e
        public void c(long l, byte[] b2Arr2, long l3, long l4) {
            obj.a.copyMemory(0, l, obj4, l3, l2 + l4);
        }

        @Override // com.google.protobuf.w1$e
        public boolean d(Object object, long l2) {
            return this.a.getBoolean(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public byte e(long l) {
            return this.a.getByte(l);
        }

        @Override // com.google.protobuf.w1$e
        public byte f(Object object, long l2) {
            return this.a.getByte(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public double g(Object object, long l2) {
            return this.a.getDouble(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public float h(Object object, long l2) {
            return this.a.getFloat(object, l2);
        }

        @Override // com.google.protobuf.w1$e
        public long j(long l) {
            return this.a.getLong(l);
        }

        @Override // com.google.protobuf.w1$e
        public void n(Object object, long l2, boolean z3) {
            this.a.putBoolean(object, l2, z3);
        }

        @Override // com.google.protobuf.w1$e
        public void o(Object object, long l2, byte b3) {
            this.a.putByte(object, l2, b3);
        }

        @Override // com.google.protobuf.w1$e
        public void p(Object object, long l2, double d3) {
            this.a.putDouble(object, l2, obj3);
        }

        @Override // com.google.protobuf.w1$e
        public void q(Object object, long l2, float f3) {
            this.a.putFloat(object, l2, f3);
        }

        @Override // com.google.protobuf.w1$e
        public boolean u() {
            Class<Object> obj = Object.class;
            final int i = 0;
            if (!super.u()) {
                return i;
            }
            Class class = this.a.getClass();
            final int i2 = 2;
            Class[] arr = new Class[i2];
            arr[i] = obj;
            final Class tYPE2 = Long.TYPE;
            final int i4 = 1;
            arr[i4] = tYPE2;
            class.getMethod("getByte", arr);
            int i3 = 3;
            Class[] arr3 = new Class[i3];
            arr3[i] = obj;
            arr3[i4] = tYPE2;
            arr3[i2] = Byte.TYPE;
            class.getMethod("putByte", arr3);
            Class[] arr4 = new Class[i2];
            arr4[i] = obj;
            arr4[i4] = tYPE2;
            class.getMethod("getBoolean", arr4);
            Class[] arr5 = new Class[i3];
            arr5[i] = obj;
            arr5[i4] = tYPE2;
            arr5[i2] = Boolean.TYPE;
            class.getMethod("putBoolean", arr5);
            Class[] arr6 = new Class[i2];
            arr6[i] = obj;
            arr6[i4] = tYPE2;
            class.getMethod("getFloat", arr6);
            Class[] arr7 = new Class[i3];
            arr7[i] = obj;
            arr7[i4] = tYPE2;
            arr7[i2] = Float.TYPE;
            class.getMethod("putFloat", arr7);
            Class[] arr8 = new Class[i2];
            arr8[i] = obj;
            arr8[i4] = tYPE2;
            class.getMethod("getDouble", arr8);
            Class[] arr2 = new Class[i3];
            arr2[i] = obj;
            arr2[i4] = tYPE2;
            arr2[i2] = Double.TYPE;
            class.getMethod("putDouble", arr2);
            return i4;
        }

        @Override // com.google.protobuf.w1$e
        public boolean v() {
            Class<Object> obj = Object.class;
            final String str = "copyMemory";
            final int i2 = 0;
            if (!super.v()) {
                return i2;
            }
            Class class = this.a.getClass();
            final int i4 = 1;
            Class[] arr = new Class[i4];
            final Class tYPE = Long.TYPE;
            arr[i2] = tYPE;
            class.getMethod("getByte", arr);
            int i5 = 2;
            Class[] arr2 = new Class[i5];
            arr2[i2] = tYPE;
            arr2[i4] = Byte.TYPE;
            class.getMethod("putByte", arr2);
            Class[] arr3 = new Class[i4];
            arr3[i2] = tYPE;
            class.getMethod("getInt", arr3);
            Class[] arr4 = new Class[i5];
            arr4[i2] = tYPE;
            arr4[i4] = Integer.TYPE;
            class.getMethod("putInt", arr4);
            Class[] arr5 = new Class[i4];
            arr5[i2] = tYPE;
            class.getMethod("getLong", arr5);
            Class[] arr6 = new Class[i5];
            arr6[i2] = tYPE;
            arr6[i4] = tYPE;
            class.getMethod("putLong", arr6);
            int i3 = 3;
            Class[] arr7 = new Class[i3];
            arr7[i2] = tYPE;
            arr7[i4] = tYPE;
            arr7[i5] = tYPE;
            class.getMethod(str, arr7);
            Class[] arr8 = new Class[5];
            arr8[i2] = obj;
            arr8[i4] = tYPE;
            arr8[i5] = obj;
            arr8[i3] = tYPE;
            arr8[4] = tYPE;
            class.getMethod(str, arr8);
            return i4;
        }
    }
    static {
        Class<Object[]> obj = Object[].class;
        Class<double[]> obj2 = double[].class;
        final Class<float[]> obj3 = float[].class;
        final Class<long[]> obj4 = long[].class;
        final Class<int[]> obj5 = int[].class;
        final Class<boolean[]> obj6 = boolean[].class;
        w1.a = w1.H();
        w1.b = d.b();
        w1.c = w1.q(Long.TYPE);
        w1.d = w1.q(Integer.TYPE);
        w1.e = w1.F();
        w1.f = w1.X();
        w1.g = w1.W();
        w1.h = (long)i3;
        w1.m(obj6);
        w1.n(obj6);
        w1.m(obj5);
        w1.n(obj5);
        w1.m(obj4);
        w1.n(obj4);
        w1.m(obj3);
        w1.n(obj3);
        w1.m(obj2);
        w1.n(obj2);
        w1.m(obj);
        w1.n(obj);
        w1.i = w1.s(w1.o());
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            int i = 1;
        }
        int i2 = 0;
    }

    static double A(Object object, long l2) {
        return w1.e.g(object, l2);
    }

    static float B(Object object, long l2) {
        return w1.e.h(object, l2);
    }

    static int C(Object object, long l2) {
        return w1.e.i(object, l2);
    }

    static long D(long l) {
        return w1.e.j(l);
    }

    static long E(Object object, long l2) {
        return w1.e.k(object, l2);
    }

    private static com.google.protobuf.w1.e F() {
        int bVar;
        final Unsafe unsafe = w1.a;
        if (unsafe == null) {
            return null;
        }
        if (d.c() && w1.c) {
            if (w1.c) {
                w1.c cVar = new w1.c(unsafe);
                return cVar;
            }
            if (w1.d) {
                bVar = new w1.b(unsafe);
            }
            return bVar;
        }
        w1.d dVar = new w1.d(unsafe);
        return dVar;
    }

    static Object G(Object object, long l2) {
        return w1.e.l(object, l2);
    }

    static Unsafe H() {
        Object doPrivileged;
        try {
            w1.a aVar = new w1.a();
            doPrivileged = AccessController.doPrivileged(aVar);
            int i = 0;
            return doPrivileged;
        }
    }

    static boolean I() {
        return w1.g;
    }

    static boolean J() {
        return w1.f;
    }

    private static void K(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
        stringBuilder.append(throwable);
        Logger.getLogger(w1.class.getName()).log(Level.WARNING, stringBuilder.toString());
    }

    static void L(Object object, long l2, boolean z3) {
        w1.e.n(object, l2, z3);
    }

    private static void M(Object object, long l2, boolean z3) {
        w1.P(object, l2, z3);
    }

    private static void N(Object object, long l2, boolean z3) {
        w1.Q(object, l2, z3);
    }

    static void O(byte[] bArr, long l2, byte b3) {
        w1.e.o(bArr, l += l2, obj2);
    }

    private static void P(Object object, long l2, byte b3) {
        i &= l2;
        obj5 <<= 3;
        int obj6 = 255;
        w1.T(object, i2, obj1);
    }

    private static void Q(Object object, long l2, byte b3) {
        i &= l2;
        obj5 <<= 3;
        int obj6 = 255;
        w1.T(object, i2, obj1);
    }

    static void R(Object object, long l2, double d3) {
        w1.e.p(object, l2, obj3);
    }

    static void S(Object object, long l2, float f3) {
        w1.e.q(object, l2, f3);
    }

    static void T(Object object, long l2, int i3) {
        w1.e.r(object, l2, i3);
    }

    static void U(Object object, long l2, long l3) {
        w1.e.s(object, l2, obj3);
    }

    static void V(Object object, long l2, Object object3) {
        w1.e.t(object, l2, object3);
    }

    private static boolean W() {
        com.google.protobuf.w1.e eVar = w1.e;
        if (eVar == null) {
            return 0;
        }
        return eVar.u();
    }

    private static boolean X() {
        com.google.protobuf.w1.e eVar = w1.e;
        if (eVar == null) {
            return 0;
        }
        return eVar.v();
    }

    static void a(Throwable throwable) {
        w1.K(throwable);
    }

    static Field b() {
        return w1.o();
    }

    static byte c(Object object, long l2) {
        return w1.y(object, l2);
    }

    static byte d(Object object, long l2) {
        return w1.z(object, l2);
    }

    static void e(Object object, long l2, byte b3) {
        w1.P(object, l2, b3);
    }

    static void f(Object object, long l2, byte b3) {
        w1.Q(object, l2, b3);
    }

    static boolean g(Object object, long l2) {
        return w1.u(object, l2);
    }

    static boolean h(Object object, long l2) {
        return w1.v(object, l2);
    }

    static void i(Object object, long l2, boolean z3) {
        w1.M(object, l2, z3);
    }

    static void j(Object object, long l2, boolean z3) {
        w1.N(object, l2, z3);
    }

    static long k(ByteBuffer byteBuffer) {
        return w1.e.k(byteBuffer, w1.i);
    }

    static <T> T l(Class<T> class) {
        try {
            return w1.a.allocateInstance(class);
            IllegalStateException illegalStateException = new IllegalStateException(class);
            throw illegalStateException;
        }
    }

    private static int m(Class<?> class) {
        com.google.protobuf.w1.e z;
        int obj1;
        if (w1.g) {
            obj1 = w1.e.a(class);
        } else {
            obj1 = -1;
        }
        return obj1;
    }

    private static int n(Class<?> class) {
        com.google.protobuf.w1.e z;
        int obj1;
        if (w1.g) {
            obj1 = w1.e.b(class);
        } else {
            obj1 = -1;
        }
        return obj1;
    }

    private static Field o() {
        boolean z;
        int field;
        String str;
        Object type;
        Class tYPE;
        z = w1.r(Buffer.class, "effectiveDirectAddress");
        if (d.c() && z != null) {
            z = w1.r(Buffer.class, "effectiveDirectAddress");
            if (z != null) {
                return z;
            }
        }
        field = w1.r(Buffer.class, "address");
        if (field != null && field.getType() == Long.TYPE) {
            if (field.getType() == Long.TYPE) {
            } else {
                field = 0;
            }
        } else {
        }
        return field;
    }

    static void p(long l, byte[] b2Arr2, long l3, long l4) {
        w1.e.c(l, obj2, l3, l4);
    }

    static boolean q(Class<?> class) {
        final Class<byte[]> obj = byte[].class;
        final int i = 0;
        if (!d.c()) {
            return i;
        }
        Class cls = w1.b;
        final int i2 = 2;
        Class[] arr = new Class[i2];
        arr[i] = class;
        Class tYPE = Boolean.TYPE;
        final int i5 = 1;
        arr[i5] = tYPE;
        cls.getMethod("peekLong", arr);
        int i3 = 3;
        Class[] arr5 = new Class[i3];
        arr5[i] = class;
        arr5[i5] = Long.TYPE;
        arr5[i2] = tYPE;
        cls.getMethod("pokeLong", arr5);
        Class[] arr6 = new Class[i3];
        arr6[i] = class;
        Class tYPE4 = Integer.TYPE;
        arr6[i5] = tYPE4;
        arr6[i2] = tYPE;
        cls.getMethod("pokeInt", arr6);
        Class[] arr7 = new Class[i2];
        arr7[i] = class;
        arr7[i5] = tYPE;
        cls.getMethod("peekInt", arr7);
        Class[] arr2 = new Class[i2];
        arr2[i] = class;
        arr2[i5] = Byte.TYPE;
        cls.getMethod("pokeByte", arr2);
        Class[] arr3 = new Class[i5];
        arr3[i] = class;
        cls.getMethod("peekByte", arr3);
        int i4 = 4;
        Class[] arr8 = new Class[i4];
        arr8[i] = class;
        arr8[i5] = obj;
        arr8[i2] = tYPE4;
        arr8[i3] = tYPE4;
        cls.getMethod("pokeByteArray", arr8);
        Class[] arr4 = new Class[i4];
        arr4[i] = class;
        arr4[i5] = obj;
        arr4[i2] = tYPE4;
        arr4[i3] = tYPE4;
        cls.getMethod("peekByteArray", arr4);
        return i5;
    }

    private static Field r(Class<?> class, String string2) {
        Field obj0;
        try {
            obj0 = class.getDeclaredField(string2);
            class = 0;
            return obj0;
        }
    }

    private static long s(Field field) {
        long l;
        com.google.protobuf.w1.e eVar;
        if (field != null) {
            eVar = w1.e;
            if (eVar == null) {
                l = -1;
            } else {
                l = eVar.m(field);
            }
        } else {
        }
        return l;
    }

    static boolean t(Object object, long l2) {
        return w1.e.d(object, l2);
    }

    private static boolean u(Object object, long l2) {
        int obj0;
        obj0 = w1.y(object, l2) != 0 ? 1 : 0;
        return obj0;
    }

    private static boolean v(Object object, long l2) {
        int obj0;
        obj0 = w1.z(object, l2) != 0 ? 1 : 0;
        return obj0;
    }

    static byte w(long l) {
        return w1.e.e(l);
    }

    static byte x(byte[] bArr, long l2) {
        return w1.e.f(bArr, l += l2);
    }

    private static byte y(Object object, long l2) {
        return (byte)obj2;
    }

    private static byte z(Object object, long l2) {
        return (byte)obj2;
    }
}
