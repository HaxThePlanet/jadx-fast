package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class e9 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.e9, com.google.android.gms.internal.firebase-auth-api.d9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.e9 zzb;
    private int zze;
    private int zzf;
    private com.google.android.gms.internal.firebase-auth-api.wq zzg;
    static {
        e9 e9Var = new e9();
        e9.zzb = e9Var;
        xr.h(e9.class, e9Var);
    }

    private e9() {
        super();
        this.zzg = wq.a;
    }

    static com.google.android.gms.internal.firebase-auth-api.e9 A() {
        return e9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.e9 B() {
        return e9.zzb;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.e9 e9, com.google.android.gms.internal.firebase-auth-api.g9 g92) {
        e9.zze = g92.zza();
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.e9 e9, com.google.android.gms.internal.firebase-auth-api.l9 l92) {
        e9.zzf = l92.zza();
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.e9 e9, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        e9.zzg = wq2;
    }

    public static com.google.android.gms.internal.firebase-auth-api.d9 z() {
        return (d9)e9.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.g9 C() {
        com.google.android.gms.internal.firebase-auth-api.g9 zzf;
        if (g9.zzb(this.zze) == null) {
            zzf = g9.zzf;
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.l9 D() {
        com.google.android.gms.internal.firebase-auth-api.l9 zzg;
        if (l9.zzb(this.zzf) == null) {
            zzg = l9.zzg;
        }
        return zzg;
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
                        return e9.zzb;
                    }
                    d9 obj3 = new d9(obj5);
                    return obj3;
                }
                obj3 = new e9();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(e9.zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\u000c\u0002\u000c\u000b\n", obj3);
        }
        return Byte.valueOf(obj4);
    }
}
