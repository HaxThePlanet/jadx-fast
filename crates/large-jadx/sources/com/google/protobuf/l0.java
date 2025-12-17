package com.google.protobuf;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class l0 implements com.google.protobuf.m1 {

    private static final com.google.protobuf.s0 b;
    private final com.google.protobuf.s0 a;

    static class a implements com.google.protobuf.s0 {
        public com.google.protobuf.r0 a(Class<?> class) {
            IllegalStateException obj2 = new IllegalStateException("This should never be called.");
            throw obj2;
        }

        public boolean b(Class<?> class) {
            return 0;
        }
    }

    private static class b implements com.google.protobuf.s0 {

        private com.google.protobuf.s0[] a;
        b(com.google.protobuf.s0... s0Arr) {
            super();
            this.a = s0Arr;
        }

        public com.google.protobuf.r0 a(Class<?> class) {
            int i;
            com.google.protobuf.s0 s0Var;
            boolean z;
            com.google.protobuf.s0[] objArr = this.a;
            i = 0;
            while (i < objArr.length) {
                s0Var = objArr[i];
                i++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No factory is available for message type: ");
            stringBuilder.append(class.getName());
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
            throw unsupportedOperationException;
        }

        public boolean b(Class<?> class) {
            int i;
            boolean z;
            final com.google.protobuf.s0[] objArr = this.a;
            final int i2 = 0;
            i = i2;
            while (i < objArr.length) {
                i++;
            }
            return i2;
        }
    }
    static {
        l0.a aVar = new l0.a();
        l0.b = aVar;
    }

    public l0() {
        super(l0.b());
    }

    private l0(com.google.protobuf.s0 s0) {
        super();
        c0.b(s0, "messageInfoFactory");
        this.a = (s0)s0;
    }

    private static com.google.protobuf.s0 b() {
        com.google.protobuf.s0[] arr = new s0[2];
        l0.b bVar = new l0.b(arr);
        return bVar;
    }

    private static com.google.protobuf.s0 c() {
        try {
            int i2 = 0;
            return (s0)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[i2]).invoke(0, new Object[i2]);
            return l0.b;
        }
    }

    private static boolean d(com.google.protobuf.r0 r0) {
        int obj1;
        obj1 = r0.c() == f1.PROTO2 ? 1 : 0;
        return obj1;
    }

    private static <T> com.google.protobuf.l1<T> e(Class<T> class, com.google.protobuf.r0 r02) {
        Class z;
        Class z2;
        Object r0Var;
        Object r0Var2;
        Object y0Var;
        Object y0Var2;
        Object j0Var;
        Object j0Var2;
        Object s1Var;
        Object s1Var2;
        int i;
        int i2;
        Object o0Var;
        Object o0Var2;
        com.google.protobuf.o0 o0Var3;
        com.google.protobuf.w0 obj8;
        if (z.class.isAssignableFrom(class)) {
            if (l0.d(r02)) {
                obj8 = w0.R(class, r02, a1.b(), j0.b(), n1.M(), t.b(), q0.b());
            } else {
                obj8 = w0.R(class, r02, a1.b(), j0.b(), n1.M(), 0, q0.b());
            }
            return obj8;
        }
        if (l0.d(r02)) {
            obj8 = w0.R(class, r02, a1.a(), j0.a(), n1.H(), t.a(), q0.a());
        } else {
            obj8 = w0.R(class, r02, a1.a(), j0.a(), n1.I(), 0, q0.a());
        }
        return obj8;
    }

    public <T> com.google.protobuf.l1<T> a(Class<T> class) {
        n1.J(class);
        com.google.protobuf.r0 r0Var = this.a.a(class);
        if (r0Var.a() && z.class.isAssignableFrom(class)) {
            if (z.class.isAssignableFrom(class)) {
                return x0.m(n1.M(), t.b(), r0Var.b());
            }
            return x0.m(n1.H(), t.a(), r0Var.b());
        }
        return l0.e(class, r0Var);
    }
}
