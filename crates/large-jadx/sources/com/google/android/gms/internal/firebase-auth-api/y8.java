package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class y8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.y8, com.google.android.gms.internal.firebase-auth-api.x8> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.y8 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.b9 zzf;
    private com.google.android.gms.internal.firebase-auth-api.wq zzg;
    static {
        y8 y8Var = new y8();
        y8.zzb = y8Var;
        xr.h(y8.class, y8Var);
    }

    private y8() {
        super();
        this.zzg = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.x8 A() {
        return (x8)y8.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.y8 B() {
        return y8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.y8 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (y8)xr.v(y8.zzb, wq, lr2);
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.y8 y8, int i2) {
        y8.zze = 0;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.y8 y8, com.google.android.gms.internal.firebase-auth-api.b9 b92) {
        b92.getClass();
        y8.zzf = b92;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.y8 y8, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        y8.zzg = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.b9 D() {
        com.google.android.gms.internal.firebase-auth-api.b9 zzf;
        if (this.zzf == null) {
            zzf = b9.D();
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
                        return y8.zzb;
                    }
                    x8 obj3 = new x8(obj5);
                    return obj3;
                }
                obj3 = new y8();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(y8.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
