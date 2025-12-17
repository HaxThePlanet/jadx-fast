package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class b7 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.b7, com.google.android.gms.internal.firebase-auth-api.a7> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.b7 zzb;
    private int zze;
    static {
        b7 b7Var = new b7();
        b7.zzb = b7Var;
        xr.h(b7.class, b7Var);
    }

    public static com.google.android.gms.internal.firebase-auth-api.a7 A() {
        return (a7)b7.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.b7 B() {
        return b7.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.b7 C() {
        return b7.zzb;
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.b7 b7, int i2) {
        b7.zze = 16;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj2 = 1;
        int obj3 = 0;
        if (obj1 != null && obj1 != 2 && obj1 != 3 && obj1 != 4 && obj1 != 5) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    obj3 = 0;
                    if (obj1 != 4) {
                        if (obj1 != 5) {
                            return obj3;
                        }
                        return b7.zzb;
                    }
                    a7 obj1 = new a7(obj3);
                    return obj1;
                }
                obj1 = new b7();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(b7.zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", obj1);
        }
        return Byte.valueOf(obj2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
