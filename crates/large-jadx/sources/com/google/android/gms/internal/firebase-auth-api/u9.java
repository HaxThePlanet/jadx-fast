package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class u9 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.u9, com.google.android.gms.internal.firebase-auth-api.t9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.u9 zzb;
    private int zze;
    private int zzf;
    static {
        u9 u9Var = new u9();
        u9.zzb = u9Var;
        xr.h(u9.class, u9Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.t9 B() {
        return (t9)u9.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.u9 C() {
        return u9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.u9 D() {
        return u9.zzb;
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.u9 u9, com.google.android.gms.internal.firebase-auth-api.l9 l92) {
        u9.zze = l92.zza();
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.u9 u9, int i2) {
        u9.zzf = i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.l9 A() {
        com.google.android.gms.internal.firebase-auth-api.l9 zzg;
        if (l9.zzb(this.zze) == null) {
            zzg = l9.zzg;
        }
        return zzg;
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
                        return u9.zzb;
                    }
                    t9 obj2 = new t9(obj4);
                    return obj2;
                }
                obj2 = new u9();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(u9.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000c\u0002\u000b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzf;
    }
}
