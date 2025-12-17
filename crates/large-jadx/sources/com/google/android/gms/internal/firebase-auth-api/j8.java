package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class j8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.j8, com.google.android.gms.internal.firebase-auth-api.i8> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.j8 zzb;
    static {
        j8 j8Var = new j8();
        j8.zzb = j8Var;
        xr.h(j8.class, j8Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.j8 A() {
        return j8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.j8 B(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (j8)xr.v(j8.zzb, wq, lr2);
    }

    static com.google.android.gms.internal.firebase-auth-api.j8 z() {
        return j8.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        final int obj3 = 0;
        if (obj1 != null && obj1 != 2 && obj1 != 3 && obj1 != 4 && obj1 != 5) {
            obj3 = 0;
            if (obj1 != 2) {
                if (obj1 != 3) {
                    if (obj1 != 4) {
                        if (obj1 != 5) {
                            return obj3;
                        }
                        return j8.zzb;
                    }
                    i8 obj1 = new i8(obj3);
                    return obj1;
                }
                obj1 = new j8();
                return obj1;
            }
            return xr.f(j8.zzb, "\u0000\u0000", obj3);
        }
        return (byte) 1;
    }
}
