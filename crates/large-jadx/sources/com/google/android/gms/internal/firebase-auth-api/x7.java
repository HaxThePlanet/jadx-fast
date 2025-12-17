package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class x7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.x7, com.google.android.gms.internal.firebase-auth-api.w7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.x7 zzb;
    private int zze;
    private int zzf;
    static {
        x7 x7Var = new x7();
        x7.zzb = x7Var;
        xr.h(x7.class, x7Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.w7 A() {
        return (w7)x7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.x7 B() {
        return x7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.x7 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (x7)xr.v(x7.zzb, wq, lr2);
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.x7 x7, int i2) {
        x7.zze = i2;
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
                        return x7.zzb;
                    }
                    w7 obj2 = new w7(obj4);
                    return obj2;
                }
                obj2 = new x7();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zzf";
            obj2[obj3] = "zze";
            return xr.f(x7.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
