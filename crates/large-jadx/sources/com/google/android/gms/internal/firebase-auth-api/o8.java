package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class o8 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.o8, com.google.android.gms.internal.firebase-auth-api.n8> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.o8 zzb;
    private com.google.android.gms.internal.firebase-auth-api.fa zze;
    static {
        o8 o8Var = new o8();
        o8.zzb = o8Var;
        xr.h(o8.class, o8Var);
    }

    static com.google.android.gms.internal.firebase-auth-api.o8 A() {
        return o8.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.o8 B() {
        return o8.zzb;
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.o8 o8, com.google.android.gms.internal.firebase-auth-api.fa fa2) {
        fa2.getClass();
        o8.zze = fa2;
    }

    public static com.google.android.gms.internal.firebase-auth-api.n8 z() {
        return (n8)o8.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.fa C() {
        com.google.android.gms.internal.firebase-auth-api.fa zze;
        if (this.zze == null) {
            zze = fa.B();
        }
        return zze;
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
                        return o8.zzb;
                    }
                    n8 obj1 = new n8(obj3);
                    return obj1;
                }
                obj1 = new o8();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(o8.zzb, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", obj1);
        }
        return Byte.valueOf(obj2);
    }
}
