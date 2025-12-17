package com.google.protobuf;

/* loaded from: classes2.dex */
public final class r1 extends com.google.protobuf.z<com.google.protobuf.r1, com.google.protobuf.r1.b> implements com.google.protobuf.u0 {

    private static final com.google.protobuf.r1 DEFAULT_INSTANCE = null;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static volatile com.google.protobuf.d1<com.google.protobuf.r1> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private int nanos_;
    private long seconds_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            r1.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            r1.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            r1.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            r1.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            r1.a.a[z.f.GET_PARSER.ordinal()] = 5;
            r1.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            r1.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends com.google.protobuf.z.a<com.google.protobuf.r1, com.google.protobuf.r1.b> implements com.google.protobuf.u0 {
        private b() {
            super(r1.b());
        }

        b(com.google.protobuf.r1.a r1$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.protobuf.r1.b b(int i) {
            copyOnWrite();
            r1.d((r1)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.protobuf.r1.b c(long l) {
            copyOnWrite();
            r1.c((r1)this.instance, l);
            return this;
        }
    }
    static {
        r1 r1Var = new r1();
        r1.DEFAULT_INSTANCE = r1Var;
        z.registerDefaultInstance(r1.class, r1Var);
    }

    static com.google.protobuf.r1 b() {
        return r1.DEFAULT_INSTANCE;
    }

    static void c(com.google.protobuf.r1 r1, long l2) {
        r1.k(l2);
    }

    static void d(com.google.protobuf.r1 r1, int i2) {
        r1.j(i2);
    }

    public static com.google.protobuf.r1 e() {
        return r1.DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.r1.b h() {
        return (r1.b)r1.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.protobuf.r1.b i(com.google.protobuf.r1 r1) {
        return (r1.b)r1.DEFAULT_INSTANCE.createBuilder(r1);
    }

    private void j(int i) {
        this.nanos_ = i;
    }

    private void k(long l) {
        this.seconds_ = l;
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(com.google.protobuf.z.f z$f, Object object2, Object object3) {
        com.google.protobuf.d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new r1();
                return obj2;
            case 2:
                obj2 = new r1.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "nanos_";
                return z.newMessageInfo(r1.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", obj2);
            case 4:
                return r1.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = r1.class;
        synchronized (obj3) {
            obj2 = new z.b(r1.DEFAULT_INSTANCE);
            r1.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public int f() {
        return this.nanos_;
    }

    @Override // com.google.protobuf.z
    public long g() {
        return this.seconds_;
    }
}
