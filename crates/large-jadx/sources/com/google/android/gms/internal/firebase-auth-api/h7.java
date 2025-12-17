package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class h7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.h7, com.google.android.gms.internal.firebase-auth-api.g7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.h7 zzb;
    private com.google.android.gms.internal.firebase-auth-api.k7 zze;
    private int zzf;
    static {
        h7 h7Var = new h7();
        h7.zzb = h7Var;
        xr.h(h7.class, h7Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.g7 A() {
        return (g7)h7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.h7 B() {
        return h7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.h7 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (h7)xr.v(h7.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.h7 h7, com.google.android.gms.internal.firebase-auth-api.k7 k72) {
        k72.getClass();
        h7.zze = k72;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.h7 h7, int i2) {
        h7.zzf = i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.k7 D() {
        com.google.android.gms.internal.firebase-auth-api.k7 zze;
        if (this.zze == null) {
            zze = k7.C();
        }
        return zze;
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
                        return h7.zzb;
                    }
                    g7 obj2 = new g7(obj4);
                    return obj2;
                }
                obj2 = new h7();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(h7.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzf;
    }
}
