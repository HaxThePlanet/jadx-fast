package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: classes3.dex */
public final class w {

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

        private final kotlin.reflect.jvm.internal.impl.protobuf.w.c javaType;
        private final int wireType;
        @Override // java.lang.Enum
        public kotlin.reflect.jvm.internal.impl.protobuf.w.c getJavaType() {
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
    }
    static {
        int i = 1;
        final int i3 = 3;
        w.c(i, i3);
        w.c(i, 4);
        int i2 = 2;
        w.c(i2, 0);
        w.c(i3, i2);
    }

    public static int a(int i) {
        return i >>>= 3;
    }

    static int b(int i) {
        return i &= 7;
    }

    static int c(int i, int i2) {
        return obj0 |= i2;
    }
}
