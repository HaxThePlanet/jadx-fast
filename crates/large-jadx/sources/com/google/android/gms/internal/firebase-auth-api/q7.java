package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class q7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.q7, com.google.android.gms.internal.firebase-auth-api.p7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.q7 zzb;
    private int zze;
    private int zzf;
    static {
        q7 q7Var = new q7();
        q7.zzb = q7Var;
        xr.h(q7.class, q7Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.p7 A() {
        return (p7)q7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.q7 B() {
        return q7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.q7 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (q7)xr.v(q7.zzb, wq, lr2);
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.q7 q7, int i2) {
        q7.zze = i2;
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
                        return q7.zzb;
                    }
                    p7 obj2 = new p7(obj4);
                    return obj2;
                }
                obj2 = new q7();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(q7.zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
