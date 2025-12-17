package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class va extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.va, com.google.android.gms.internal.firebase-auth-api.ua> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.va zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.za zzf;
    static {
        va vaVar = new va();
        va.zzb = vaVar;
        xr.h(va.class, vaVar);
    }

    public static com.google.android.gms.internal.firebase-auth-api.ua A() {
        return (ua)va.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.va B() {
        return va.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.va C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (va)xr.v(va.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.va va, int i2) {
        va.zze = 0;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.va va, com.google.android.gms.internal.firebase-auth-api.za za2) {
        za2.getClass();
        va.zzf = za2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.za D() {
        com.google.android.gms.internal.firebase-auth-api.za zzf;
        if (this.zzf == null) {
            zzf = za.A();
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
                        return va.zzb;
                    }
                    ua obj2 = new ua(obj4);
                    return obj2;
                }
                obj2 = new va();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(va.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
