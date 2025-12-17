package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class n7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.n7, com.google.android.gms.internal.firebase-auth-api.m7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.n7 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.wq zzf;
    static {
        n7 n7Var = new n7();
        n7.zzb = n7Var;
        xr.h(n7.class, n7Var);
    }

    private n7() {
        super();
        this.zzf = wq.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.m7 A() {
        return (m7)n7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.n7 B() {
        return n7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.n7 C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (n7)xr.v(n7.zzb, wq, lr2);
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.n7 n7, int i2) {
        n7.zze = 0;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.n7 n7, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        n7.zzf = wq2;
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
                        return n7.zzb;
                    }
                    m7 obj2 = new m7(obj4);
                    return obj2;
                }
                obj2 = new n7();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(n7.zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
