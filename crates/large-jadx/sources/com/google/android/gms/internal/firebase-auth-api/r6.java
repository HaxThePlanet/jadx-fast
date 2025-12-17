package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class r6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.r6, com.google.android.gms.internal.firebase-auth-api.q6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.r6 zzb;
    private com.google.android.gms.internal.firebase-auth-api.y6 zze;
    private com.google.android.gms.internal.firebase-auth-api.r9 zzf;
    static {
        r6 r6Var = new r6();
        r6.zzb = r6Var;
        xr.h(r6.class, r6Var);
    }

    static com.google.android.gms.internal.firebase-auth-api.r6 A() {
        return r6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.r6 B(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (r6)xr.v(r6.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.r6 r6, com.google.android.gms.internal.firebase-auth-api.y6 y62) {
        y62.getClass();
        r6.zze = y62;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.r6 r6, com.google.android.gms.internal.firebase-auth-api.r9 r92) {
        r92.getClass();
        r6.zzf = r92;
    }

    public static com.google.android.gms.internal.firebase-auth-api.q6 z() {
        return (q6)r6.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.y6 C() {
        com.google.android.gms.internal.firebase-auth-api.y6 zze;
        if (this.zze == null) {
            zze = y6.C();
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.r9 D() {
        com.google.android.gms.internal.firebase-auth-api.r9 zzf;
        if (this.zzf == null) {
            zzf = r9.C();
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj3 = 1;
        int obj4 = 2;
        obj4 = 0;
        if (obj2 != null && obj2 != obj4 && obj2 != 3 && obj2 != 4 && obj2 != 5) {
            obj4 = 2;
            if (obj2 != obj4) {
                if (obj2 != 3) {
                    obj4 = 0;
                    if (obj2 != 4) {
                        if (obj2 != 5) {
                            return obj4;
                        }
                        return r6.zzb;
                    }
                    q6 obj2 = new q6(obj4);
                    return obj2;
                }
                obj2 = new r6();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(r6.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", obj2);
        }
        return Byte.valueOf(obj3);
    }
}
