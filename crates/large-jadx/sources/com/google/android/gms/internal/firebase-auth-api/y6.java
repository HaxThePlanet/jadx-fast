package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class y6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.y6, com.google.android.gms.internal.firebase-auth-api.x6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.y6 zzb;
    private com.google.android.gms.internal.firebase-auth-api.b7 zze;
    private int zzf;
    static {
        y6 y6Var = new y6();
        y6.zzb = y6Var;
        xr.h(y6.class, y6Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.x6 A() {
        return (x6)y6.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.y6 B() {
        return y6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.y6 C() {
        return y6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.y6 D(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (y6)xr.v(y6.zzb, wq, lr2);
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.y6 y6, com.google.android.gms.internal.firebase-auth-api.b7 b72) {
        b72.getClass();
        y6.zze = b72;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.y6 y6, int i2) {
        y6.zzf = i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.b7 E() {
        com.google.android.gms.internal.firebase-auth-api.b7 zze;
        if (this.zze == null) {
            zze = b7.C();
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
                        return y6.zzb;
                    }
                    x6 obj2 = new x6(obj4);
                    return obj2;
                }
                obj2 = new y6();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(y6.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzf;
    }
}
