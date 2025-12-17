package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class f6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.f6, com.google.android.gms.internal.firebase-auth-api.e6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.f6 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.wq zzf;
    private com.google.android.gms.internal.firebase-auth-api.l6 zzg;
    static {
        f6 f6Var = new f6();
        f6.zzb = f6Var;
        xr.h(f6.class, f6Var);
    }

    private f6() {
        super();
        this.zzf = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.e6 A() {
        return (e6)f6.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.f6 B() {
        return f6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.f6 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (f6)xr.v(f6.zzb, wq, lr2);
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.f6 f6, int i2) {
        f6.zze = 0;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.f6 f6, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        f6.zzf = wq2;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.f6 f6, com.google.android.gms.internal.firebase-auth-api.l6 l62) {
        l62.getClass();
        f6.zzg = l62;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.l6 D() {
        com.google.android.gms.internal.firebase-auth-api.l6 zzg;
        if (this.zzg == null) {
            zzg = l6.C();
        }
        return zzg;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq E() {
        return this.zzf;
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
                        return f6.zzb;
                    }
                    e6 obj3 = new e6(obj5);
                    return obj3;
                }
                obj3 = new f6();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(f6.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
