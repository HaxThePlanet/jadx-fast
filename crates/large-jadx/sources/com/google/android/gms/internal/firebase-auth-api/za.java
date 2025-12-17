package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class za extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.za, com.google.android.gms.internal.firebase-auth-api.ya> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.za zzb;
    private String zze;
    static {
        za zaVar = new za();
        za.zzb = zaVar;
        xr.h(za.class, zaVar);
    }

    private za() {
        super();
        this.zze = "";
    }

    public static com.google.android.gms.internal.firebase-auth-api.za A() {
        return za.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.za B(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (za)xr.v(za.zzb, wq, lr2);
    }

    static com.google.android.gms.internal.firebase-auth-api.za z() {
        return za.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final String C() {
        return this.zze;
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
                        return za.zzb;
                    }
                    ya obj1 = new ya(obj3);
                    return obj1;
                }
                obj1 = new za();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(za.zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", obj1);
        }
        return Byte.valueOf(obj2);
    }
}
