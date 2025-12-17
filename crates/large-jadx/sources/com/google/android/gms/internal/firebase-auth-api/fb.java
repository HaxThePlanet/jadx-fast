package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class fb extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.fb, com.google.android.gms.internal.firebase-auth-api.eb> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.fb zzb;
    private String zze;
    private com.google.android.gms.internal.firebase-auth-api.fa zzf;
    static {
        fb fbVar = new fb();
        fb.zzb = fbVar;
        xr.h(fb.class, fbVar);
    }

    private fb() {
        super();
        this.zze = "";
    }

    static com.google.android.gms.internal.firebase-auth-api.fb A() {
        return fb.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.fb B() {
        return fb.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.fb C(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (fb)xr.v(fb.zzb, wq, lr2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final String D() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final boolean E() {
        if (this.zzf != null) {
            return 1;
        }
        return 0;
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
                        return fb.zzb;
                    }
                    eb obj2 = new eb(obj4);
                    return obj2;
                }
                obj2 = new fb();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = "zzf";
            return xr.f(fb.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.fa z() {
        com.google.android.gms.internal.firebase-auth-api.fa zzf;
        if (this.zzf == null) {
            zzf = fa.B();
        }
        return zzf;
    }
}
