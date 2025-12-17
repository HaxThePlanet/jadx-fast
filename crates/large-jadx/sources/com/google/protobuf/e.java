package com.google.protobuf;

/* loaded from: classes2.dex */
public final class e extends com.google.protobuf.z<com.google.protobuf.e, com.google.protobuf.e.b> implements com.google.protobuf.u0 {

    private static final com.google.protobuf.e DEFAULT_INSTANCE = null;
    private static volatile com.google.protobuf.d1<com.google.protobuf.e> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String typeUrl_;
    private com.google.protobuf.j value_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            e.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            e.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            e.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            e.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            e.a.a[z.f.GET_PARSER.ordinal()] = 5;
            e.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            e.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends com.google.protobuf.z.a<com.google.protobuf.e, com.google.protobuf.e.b> implements com.google.protobuf.u0 {
        private b() {
            super(e.b());
        }

        b(com.google.protobuf.e.a e$a) {
            super();
        }
    }
    static {
        e eVar = new e();
        e.DEFAULT_INSTANCE = eVar;
        z.registerDefaultInstance(e.class, eVar);
    }

    private e() {
        super();
        this.typeUrl_ = "";
        this.value_ = j.a;
    }

    static com.google.protobuf.e b() {
        return e.DEFAULT_INSTANCE;
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
                obj2 = new e();
                return obj2;
            case 2:
                obj2 = new e.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "value_";
                return z.newMessageInfo(e.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", obj2);
            case 4:
                return e.DEFAULT_INSTANCE;
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
        obj3 = e.class;
        synchronized (obj3) {
            obj2 = new z.b(e.DEFAULT_INSTANCE);
            e.PARSER = obj2;
        }
    }
}
