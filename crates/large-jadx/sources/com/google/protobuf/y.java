package com.google.protobuf;

/* loaded from: classes2.dex */
class y implements com.google.protobuf.s0 {

    private static final com.google.protobuf.y a;
    static {
        y yVar = new y();
        y.a = yVar;
    }

    public static com.google.protobuf.y c() {
        return y.a;
    }

    public com.google.protobuf.r0 a(Class<?> class) {
        Class<com.google.protobuf.z> obj = z.class;
        if (!obj.isAssignableFrom(class)) {
        } else {
            return (r0)z.getDefaultInstance(class.asSubclass(obj)).buildMessageInfo();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported message type: ");
        stringBuilder.append(class.getName());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public boolean b(Class<?> class) {
        return z.class.isAssignableFrom(class);
    }
}
