package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class k7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.k7, com.google.android.gms.internal.firebase-auth-api.j7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.k7 zzb;
    private int zze;
    static {
        k7 k7Var = new k7();
        k7.zzb = k7Var;
        xr.h(k7.class, k7Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.j7 A() {
        return (j7)k7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.k7 B() {
        return k7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.k7 C() {
        return k7.zzb;
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.k7 k7, int i2) {
        k7.zze = 16;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj2 = 1;
        int obj3 = 0;
        if (obj1 != null && obj1 != 2 && obj1 != 3 && obj1 != 4 && obj1 != 5) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    obj3 = 0;
                    if (obj1 != 4) {
                        if (obj1 != 5) {
                            return obj3;
                        }
                        return k7.zzb;
                    }
                    j7 obj1 = new j7(obj3);
                    return obj1;
                }
                obj1 = new k7();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(k7.zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", obj1);
        }
        return Byte.valueOf(obj2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
