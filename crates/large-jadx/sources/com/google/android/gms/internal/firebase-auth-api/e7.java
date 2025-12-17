package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class e7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.e7, com.google.android.gms.internal.firebase-auth-api.d7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.e7 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.k7 zzf;
    private com.google.android.gms.internal.firebase-auth-api.wq zzg;
    static {
        e7 e7Var = new e7();
        e7.zzb = e7Var;
        xr.h(e7.class, e7Var);
    }

    private e7() {
        super();
        this.zzg = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.d7 A() {
        return (d7)e7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.e7 B() {
        return e7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.e7 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (e7)xr.v(e7.zzb, wq, lr2);
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.e7 e7, int i2) {
        e7.zze = 0;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.e7 e7, com.google.android.gms.internal.firebase-auth-api.k7 k72) {
        k72.getClass();
        e7.zzf = k72;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.e7 e7, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        e7.zzg = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.k7 D() {
        com.google.android.gms.internal.firebase-auth-api.k7 zzf;
        if (this.zzf == null) {
            zzf = k7.C();
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq E() {
        return this.zzg;
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
                        return e7.zzb;
                    }
                    d7 obj3 = new d7(obj5);
                    return obj3;
                }
                obj3 = new e7();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(e7.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
