package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class s8 implements com.google.android.gms.internal.measurement.w9 {

    private static final com.google.android.gms.internal.measurement.s8 a;
    static {
        s8 s8Var = new s8();
        s8.a = s8Var;
    }

    public static com.google.android.gms.internal.measurement.s8 c() {
        return s8.a;
    }

    public final com.google.android.gms.internal.measurement.u9 a(Class<?> class) {
        String obj5;
        Class<com.google.android.gms.internal.measurement.w8> obj = w8.class;
        if (!obj.isAssignableFrom(class)) {
            obj5 = String.valueOf(class.getName());
            String str = "Unsupported message type: ";
            if (obj5.length() != 0) {
                obj5 = str.concat(obj5);
            } else {
                obj5 = new String(str);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(obj5);
            throw illegalArgumentException;
        }
        int i2 = 0;
        return (u9)w8.r(class.asSubclass(obj)).v(3, i2, i2);
    }

    public final boolean b(Class<?> class) {
        return w8.class.isAssignableFrom(class);
    }
}
