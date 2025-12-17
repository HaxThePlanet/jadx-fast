package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class o9 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.o9, com.google.android.gms.internal.firebase-auth-api.n9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.o9 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.u9 zzf;
    private com.google.android.gms.internal.firebase-auth-api.wq zzg;
    static {
        o9 o9Var = new o9();
        o9.zzb = o9Var;
        xr.h(o9.class, o9Var);
    }

    private o9() {
        super();
        this.zzg = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.n9 A() {
        return (n9)o9.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.o9 B() {
        return o9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.o9 C() {
        return o9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.o9 D(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (o9)xr.v(o9.zzb, wq, lr2);
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.o9 o9, int i2) {
        o9.zze = 0;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.o9 o9, com.google.android.gms.internal.firebase-auth-api.u9 u92) {
        u92.getClass();
        o9.zzf = u92;
    }

    static void I(com.google.android.gms.internal.firebase-auth-api.o9 o9, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        o9.zzg = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.u9 E() {
        com.google.android.gms.internal.firebase-auth-api.u9 zzf;
        if (this.zzf == null) {
            zzf = u9.D();
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
                        return o9.zzb;
                    }
                    n9 obj3 = new n9(obj5);
                    return obj3;
                }
                obj3 = new o9();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(o9.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
