package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class l6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.l6, com.google.android.gms.internal.firebase-auth-api.k6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.l6 zzb;
    private int zze;
    static {
        l6 l6Var = new l6();
        l6.zzb = l6Var;
        xr.h(l6.class, l6Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.k6 A() {
        return (k6)l6.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.l6 B() {
        return l6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.l6 C() {
        return l6.zzb;
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.l6 l6, int i2) {
        l6.zze = 16;
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
                        return l6.zzb;
                    }
                    k6 obj1 = new k6(obj3);
                    return obj1;
                }
                obj1 = new l6();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(l6.zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", obj1);
        }
        return Byte.valueOf(obj2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
