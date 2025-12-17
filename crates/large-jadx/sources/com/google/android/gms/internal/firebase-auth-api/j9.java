package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class j9 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.j9, com.google.android.gms.internal.firebase-auth-api.i9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.j9 zzb;
    private com.google.android.gms.internal.firebase-auth-api.wq zze;
    private com.google.android.gms.internal.firebase-auth-api.sa zzf;
    static {
        j9 j9Var = new j9();
        j9.zzb = j9Var;
        xr.h(j9.class, j9Var);
    }

    private j9() {
        super();
        this.zze = wq.a;
    }

    static com.google.android.gms.internal.firebase-auth-api.j9 A() {
        return j9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.j9 B(byte[] bArr, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (j9)xr.w(j9.zzb, bArr, lr2);
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.j9 j9, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        j9.zze = wq2;
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.j9 j9, com.google.android.gms.internal.firebase-auth-api.sa sa2) {
        sa2.getClass();
        j9.zzf = sa2;
    }

    public static com.google.android.gms.internal.firebase-auth-api.i9 z() {
        return (i9)j9.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq C() {
        return this.zze;
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
                        return j9.zzb;
                    }
                    i9 obj2 = new i9(obj4);
                    return obj2;
                }
                obj2 = new j9();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(j9.zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", obj2);
        }
        return Byte.valueOf(obj3);
    }
}
