package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class v6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.v6, com.google.android.gms.internal.firebase-auth-api.u6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.v6 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.b7 zzf;
    private com.google.android.gms.internal.firebase-auth-api.wq zzg;
    static {
        v6 v6Var = new v6();
        v6.zzb = v6Var;
        xr.h(v6.class, v6Var);
    }

    private v6() {
        super();
        this.zzg = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.u6 A() {
        return (u6)v6.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.v6 B() {
        return v6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.v6 C() {
        return v6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.v6 D(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (v6)xr.v(v6.zzb, wq, lr2);
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.v6 v6, int i2) {
        v6.zze = 0;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.v6 v6, com.google.android.gms.internal.firebase-auth-api.b7 b72) {
        b72.getClass();
        v6.zzf = b72;
    }

    static void I(com.google.android.gms.internal.firebase-auth-api.v6 v6, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        v6.zzg = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.b7 E() {
        com.google.android.gms.internal.firebase-auth-api.b7 zzf;
        if (this.zzf == null) {
            zzf = b7.C();
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq F() {
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
                        return v6.zzb;
                    }
                    u6 obj3 = new u6(obj5);
                    return obj3;
                }
                obj3 = new v6();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(v6.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
