package com.google.protobuf;

/* loaded from: classes2.dex */
public final class y1 {

    static final int a;
    static final int b;
    static final int c;
    static final int d;

    static class a {
    }

    public static enum b {

        DOUBLE(field_1, true),
        FLOAT("DOUBLE", 5),
        INT64("FLOAT", false),
        UINT64("FLOAT", false),
        INT32(field_11, false),
        FIXED64("FLOAT", true),
        FIXED32(field_11, 5),
        BOOL(4, false),
        STRING(4, 2),
        GROUP(4, 3),
        MESSAGE(4, 5),
        BYTES(4, 5),
        UINT32(field_11, false),
        ENUM(4, false),
        SFIXED32(field_11, 2),
        SFIXED64("FLOAT", false),
        SINT32(field_11, 5),
        SINT64("FLOAT", 5);

        private final com.google.protobuf.y1.c javaType;
        private final int wireType;
        @Override // java.lang.Enum
        public com.google.protobuf.y1.c getJavaType() {
            return this.javaType;
        }

        @Override // java.lang.Enum
        public int getWireType() {
            return this.wireType;
        }

        @Override // java.lang.Enum
        public boolean isPackable() {
            return 1;
        }
    }

    public static enum c {

        INT(/* unknown */),
        LONG("INT"),
        FLOAT("LONG"),
        DOUBLE("FLOAT"),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(""),
        ENUM(5),
        MESSAGE(5);

        private final Object defaultDefault;
        @Override // java.lang.Enum
        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }
    static {
        int i = 1;
        final int i5 = 3;
        y1.a = y1.c(i, i5);
        y1.b = y1.c(i, 4);
        int i3 = 2;
        y1.c = y1.c(i3, 0);
        y1.d = y1.c(i5, i3);
    }

    public static int a(int i) {
        return i >>>= 3;
    }

    public static int b(int i) {
        return i &= 7;
    }

    static int c(int i, int i2) {
        return obj0 |= i2;
    }
}
