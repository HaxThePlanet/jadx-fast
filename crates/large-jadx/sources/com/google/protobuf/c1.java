package com.google.protobuf;

/* loaded from: classes2.dex */
public enum c1 implements com.google.protobuf.c0.c {

    NULL_VALUE(false),
    UNRECOGNIZED(-1);

    private final int value;

    static class a implements com.google.protobuf.c0.d<com.google.protobuf.c1> {
        @Override // com.google.protobuf.c0$d
        public com.google.protobuf.c1 a(int i) {
            return c1.forNumber(i);
        }

        @Override // com.google.protobuf.c0$d
        public com.google.protobuf.c0.c findValueByNumber(int i) {
            return a(i);
        }
    }

    private static final class b implements com.google.protobuf.c0.e {

        static final com.google.protobuf.c0.e a;
        static {
            c1.b bVar = new c1.b();
            c1.b.a = bVar;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = c1.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.protobuf.c1 forNumber(int i) {
        if (i != 0) {
            return null;
        }
        return c1.NULL_VALUE;
    }

    public static com.google.protobuf.c0.d<com.google.protobuf.c1> internalGetValueMap() {
        return c1.internalValueMap;
    }

    public static com.google.protobuf.c0.e internalGetVerifier() {
        return c1.b.a;
    }

    @Deprecated
    public static com.google.protobuf.c1 valueOf(int i) {
        return c1.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        if (this == c1.UNRECOGNIZED) {
        } else {
            return this.value;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
