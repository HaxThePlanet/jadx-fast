package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class d8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.d8, com.google.android.gms.internal.firebase-auth-api.c8> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.d8 zzb;
    private int zze;
    private int zzf;
    static {
        d8 d8Var = new d8();
        d8.zzb = d8Var;
        xr.h(d8.class, d8Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.c8 A() {
        return (c8)d8.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.d8 B() {
        return d8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.d8 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (d8)xr.v(d8.zzb, wq, lr2);
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.d8 d8, int i2) {
        d8.zze = 64;
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
                        return d8.zzb;
                    }
                    c8 obj2 = new c8(obj4);
                    return obj2;
                }
                obj2 = new d8();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(d8.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
