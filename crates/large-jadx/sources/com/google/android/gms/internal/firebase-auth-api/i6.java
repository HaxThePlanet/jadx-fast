package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class i6 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.i6, com.google.android.gms.internal.firebase-auth-api.h6> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.i6 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.l6 zzf;
    static {
        i6 i6Var = new i6();
        i6.zzb = i6Var;
        xr.h(i6.class, i6Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.h6 A() {
        return (h6)i6.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.i6 B() {
        return i6.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.i6 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (i6)xr.v(i6.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.i6 i6, int i2) {
        i6.zze = 32;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.i6 i6, com.google.android.gms.internal.firebase-auth-api.l6 l62) {
        l62.getClass();
        i6.zzf = l62;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.l6 D() {
        com.google.android.gms.internal.firebase-auth-api.l6 zzf;
        if (this.zzf == null) {
            zzf = l6.C();
        }
        return zzf;
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
                        return i6.zzb;
                    }
                    h6 obj2 = new h6(obj4);
                    return obj2;
                }
                obj2 = new i6();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(i6.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
