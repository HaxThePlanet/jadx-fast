package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class v8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.v8, com.google.android.gms.internal.firebase-auth-api.t8> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.v8 zzb;
    private com.google.android.gms.internal.firebase-auth-api.e9 zze;
    private com.google.android.gms.internal.firebase-auth-api.o8 zzf;
    private int zzg;
    static {
        v8 v8Var = new v8();
        v8.zzb = v8Var;
        xr.h(v8.class, v8Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.t8 B() {
        return (t8)v8.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.v8 C() {
        return v8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.v8 D() {
        return v8.zzb;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.v8 v8, com.google.android.gms.internal.firebase-auth-api.e9 e92) {
        e92.getClass();
        v8.zze = e92;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.v8 v8, com.google.android.gms.internal.firebase-auth-api.o8 o82) {
        o82.getClass();
        v8.zzf = o82;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.v8 v8, com.google.android.gms.internal.firebase-auth-api.l8 l82) {
        v8.zzg = l82.zza();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.o8 A() {
        com.google.android.gms.internal.firebase-auth-api.o8 zzf;
        if (this.zzf == null) {
            zzf = o8.B();
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.e9 E() {
        com.google.android.gms.internal.firebase-auth-api.e9 zze;
        if (this.zze == null) {
            zze = e9.B();
        }
        return zze;
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
                        return v8.zzb;
                    }
                    t8 obj3 = new t8(obj5);
                    return obj3;
                }
                obj3 = new v8();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(v8.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\u000c", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.l8 z() {
        com.google.android.gms.internal.firebase-auth-api.l8 zze;
        if (l8.zzb(this.zzg) == null) {
            zze = l8.zze;
        }
        return zze;
    }
}
