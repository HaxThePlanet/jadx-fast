package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class r8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.r8, com.google.android.gms.internal.firebase-auth-api.q8> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.r8 zzb;
    private com.google.android.gms.internal.firebase-auth-api.v8 zze;
    static {
        r8 r8Var = new r8();
        r8.zzb = r8Var;
        xr.h(r8.class, r8Var);
    }

    static com.google.android.gms.internal.firebase-auth-api.r8 A() {
        return r8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.r8 B(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (r8)xr.v(r8.zzb, wq, lr2);
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.r8 r8, com.google.android.gms.internal.firebase-auth-api.v8 v82) {
        v82.getClass();
        r8.zze = v82;
    }

    public static com.google.android.gms.internal.firebase-auth-api.q8 z() {
        return (q8)r8.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.v8 C() {
        com.google.android.gms.internal.firebase-auth-api.v8 zze;
        if (this.zze == null) {
            zze = v8.D();
        }
        return zze;
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
                        return r8.zzb;
                    }
                    q8 obj1 = new q8(obj3);
                    return obj1;
                }
                obj1 = new r8();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(r8.zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", obj1);
        }
        return Byte.valueOf(obj2);
    }
}
