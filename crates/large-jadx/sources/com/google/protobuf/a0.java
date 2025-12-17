package com.google.protobuf;

/* loaded from: classes2.dex */
public final class a0 extends com.google.protobuf.z<com.google.protobuf.a0, com.google.protobuf.a0.b> implements com.google.protobuf.u0 {

    private static final com.google.protobuf.a0 DEFAULT_INSTANCE = null;
    private static volatile com.google.protobuf.d1<com.google.protobuf.a0> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a0.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            a0.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            a0.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            a0.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            a0.a.a[z.f.GET_PARSER.ordinal()] = 5;
            a0.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            a0.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends com.google.protobuf.z.a<com.google.protobuf.a0, com.google.protobuf.a0.b> implements com.google.protobuf.u0 {
        private b() {
            super(a0.b());
        }

        b(com.google.protobuf.a0.a a0$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.protobuf.a0.b b(int i) {
            copyOnWrite();
            a0.c((a0)this.instance, i);
            return this;
        }
    }
    static {
        a0 a0Var = new a0();
        a0.DEFAULT_INSTANCE = a0Var;
        z.registerDefaultInstance(a0.class, a0Var);
    }

    static com.google.protobuf.a0 b() {
        return a0.DEFAULT_INSTANCE;
    }

    static void c(com.google.protobuf.a0 a0, int i2) {
        a0.setValue(i2);
    }

    public static com.google.protobuf.a0 d() {
        return a0.DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.a0.b e() {
        return (a0.b)a0.DEFAULT_INSTANCE.createBuilder();
    }

    private void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(com.google.protobuf.z.f z$f, Object object2, Object object3) {
        com.google.protobuf.d1 obj1;
        int obj2;
        int obj3;
        obj2 = 1;
        obj3 = 0;
        switch (obj1) {
            case 1:
                obj1 = new a0();
                return obj1;
            case 2:
                obj1 = new a0.b(obj3);
                return obj1;
            case 3:
                obj1 = new Object[obj2];
                obj1[0] = "value_";
                return z.newMessageInfo(a0.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", obj1);
            case 4:
                return a0.DEFAULT_INSTANCE;
            case 5:
                return obj1;
            case 6:
                return Byte.valueOf(obj2);
            case 7:
                return obj3;
            default:
                obj1 = new UnsupportedOperationException();
                throw obj1;
        }
        obj2 = a0.class;
        synchronized (obj2) {
            obj1 = new z.b(a0.DEFAULT_INSTANCE);
            a0.PARSER = obj1;
        }
    }

    @Override // com.google.protobuf.z
    public int getValue() {
        return this.value_;
    }
}
