package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class r9 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.r9, com.google.android.gms.internal.firebase-auth-api.q9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.r9 zzb;
    private com.google.android.gms.internal.firebase-auth-api.u9 zze;
    private int zzf;
    private int zzg;
    static {
        r9 r9Var = new r9();
        r9.zzb = r9Var;
        xr.h(r9.class, r9Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.q9 A() {
        return (q9)r9.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.r9 B() {
        return r9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.r9 C() {
        return r9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.r9 D(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (r9)xr.v(r9.zzb, wq, lr2);
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.r9 r9, com.google.android.gms.internal.firebase-auth-api.u9 u92) {
        u92.getClass();
        r9.zze = u92;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.r9 r9, int i2) {
        r9.zzf = i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.u9 E() {
        com.google.android.gms.internal.firebase-auth-api.u9 zze;
        if (this.zze == null) {
            zze = u9.D();
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj4 = 1;
        int obj5 = 3;
        final int i2 = 2;
        obj5 = 0;
        if (obj3 != null && obj3 != i2 && obj3 != obj5 && obj3 != 4 && obj3 != 5) {
            obj5 = 3;
            i2 = 2;
            if (obj3 != i2) {
                if (obj3 != obj5) {
                    obj5 = 0;
                    if (obj3 != 4) {
                        if (obj3 != 5) {
                            return obj5;
                        }
                        return r9.zzb;
                    }
                    q9 obj3 = new q9(obj5);
                    return obj3;
                }
                obj3 = new r9();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(r9.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzf;
    }
}
