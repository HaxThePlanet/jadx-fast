package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class a8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.a8, com.google.android.gms.internal.firebase-auth-api.z7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.a8 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.wq zzf;
    static {
        a8 a8Var = new a8();
        a8.zzb = a8Var;
        xr.h(a8.class, a8Var);
    }

    private a8() {
        super();
        this.zzf = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.z7 A() {
        return (z7)a8.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.a8 B() {
        return a8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.a8 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (a8)xr.v(a8.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.a8 a8, int i2) {
        a8.zze = 0;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.a8 a8, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        a8.zzf = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq D() {
        return this.zzf;
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
                        return a8.zzb;
                    }
                    z7 obj2 = new z7(obj4);
                    return obj2;
                }
                obj2 = new a8();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(a8.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
