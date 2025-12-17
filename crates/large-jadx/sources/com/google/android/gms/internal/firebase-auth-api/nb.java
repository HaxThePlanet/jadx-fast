package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class nb extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.nb, com.google.android.gms.internal.firebase-auth-api.mb> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.nb zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.wq zzf;
    static {
        nb nbVar = new nb();
        nb.zzb = nbVar;
        xr.h(nb.class, nbVar);
    }

    private nb() {
        super();
        this.zzf = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.mb A() {
        return (mb)nb.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.nb B() {
        return nb.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.nb C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (nb)xr.v(nb.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.nb nb, int i2) {
        nb.zze = 0;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.nb nb, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        nb.zzf = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq D() {
        return this.zzf;
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
                        return nb.zzb;
                    }
                    mb obj2 = new mb(obj4);
                    return obj2;
                }
                obj2 = new nb();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(nb.zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
