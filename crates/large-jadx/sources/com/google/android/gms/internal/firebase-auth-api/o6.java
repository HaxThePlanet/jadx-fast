package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class o6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.o6, com.google.android.gms.internal.firebase-auth-api.n6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.o6 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.v6 zzf;
    private com.google.android.gms.internal.firebase-auth-api.o9 zzg;
    static {
        o6 o6Var = new o6();
        o6.zzb = o6Var;
        xr.h(o6.class, o6Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.n6 A() {
        return (n6)o6.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.o6 B() {
        return o6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.o6 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (o6)xr.v(o6.zzb, wq, lr2);
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.o6 o6, int i2) {
        o6.zze = i2;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.o6 o6, com.google.android.gms.internal.firebase-auth-api.v6 v62) {
        v62.getClass();
        o6.zzf = v62;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.o6 o6, com.google.android.gms.internal.firebase-auth-api.o9 o92) {
        o92.getClass();
        o6.zzg = o92;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.v6 D() {
        com.google.android.gms.internal.firebase-auth-api.v6 zzf;
        if (this.zzf == null) {
            zzf = v6.C();
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.o9 E() {
        com.google.android.gms.internal.firebase-auth-api.o9 zzg;
        if (this.zzg == null) {
            zzg = o9.C();
        }
        return zzg;
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
                        return o6.zzb;
                    }
                    n6 obj3 = new n6(obj5);
                    return obj3;
                }
                obj3 = new o6();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(o6.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
