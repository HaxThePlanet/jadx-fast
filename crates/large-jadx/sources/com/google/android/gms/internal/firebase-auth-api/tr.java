package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class tr implements com.google.android.gms.internal.firebase-auth-api.w {

    private static final com.google.android.gms.internal.firebase-auth-api.tr a;
    static {
        tr trVar = new tr();
        tr.a = trVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.tr c() {
        return tr.a;
    }

    public final com.google.android.gms.internal.firebase-auth-api.v a(Class<?> class) {
        String obj5;
        Class<com.google.android.gms.internal.firebase-auth-api.xr> obj = xr.class;
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
        return (v)xr.u(class.asSubclass(obj)).q(3, i2, i2);
    }

    public final boolean b(Class<?> class) {
        return xr.class.isAssignableFrom(class);
    }
}
