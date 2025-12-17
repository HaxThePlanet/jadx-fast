package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class cb extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.cb, com.google.android.gms.internal.firebase-auth-api.bb> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.cb zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.fb zzf;
    static {
        cb cbVar = new cb();
        cb.zzb = cbVar;
        xr.h(cb.class, cbVar);
    }

    public static com.google.android.gms.internal.firebase-auth-api.bb A() {
        return (bb)cb.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.cb B() {
        return cb.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.cb C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (cb)xr.v(cb.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.cb cb, int i2) {
        cb.zze = 0;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.cb cb, com.google.android.gms.internal.firebase-auth-api.fb fb2) {
        fb2.getClass();
        cb.zzf = fb2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.fb D() {
        com.google.android.gms.internal.firebase-auth-api.fb zzf;
        if (this.zzf == null) {
            zzf = fb.B();
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
                        return cb.zzb;
                    }
                    bb obj2 = new bb(obj4);
                    return obj2;
                }
                obj2 = new cb();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(cb.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
