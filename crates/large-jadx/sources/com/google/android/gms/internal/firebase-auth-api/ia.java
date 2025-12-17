package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
@Deprecated
public final class ia extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.ia, com.google.android.gms.internal.firebase-auth-api.ha> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.ia zzb;
    private String zze;
    private String zzf;
    private int zzg;
    private boolean zzh;
    private String zzi;
    static {
        ia iaVar = new ia();
        ia.zzb = iaVar;
        xr.h(ia.class, iaVar);
    }

    private ia() {
        super();
        final String str = "";
        this.zze = str;
        this.zzf = str;
        this.zzi = str;
    }

    static com.google.android.gms.internal.firebase-auth-api.ia z() {
        return ia.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj6 = 1;
        int obj7 = 5;
        final int i2 = 4;
        final int i3 = 3;
        final int i4 = 2;
        obj6 = 0;
        if (obj5 != null && obj5 != i4 && obj5 != i3 && obj5 != i2 && obj5 != obj7) {
            obj7 = 5;
            i2 = 4;
            i3 = 3;
            i4 = 2;
            if (obj5 != i4) {
                if (obj5 != i3) {
                    obj6 = 0;
                    if (obj5 != i2) {
                        if (obj5 != obj7) {
                            return obj6;
                        }
                        return ia.zzb;
                    }
                    ha obj5 = new ha(obj6);
                    return obj5;
                }
                obj5 = new ia();
                return obj5;
            }
            obj5 = new Object[obj7];
            obj5[0] = "zze";
            obj5[obj6] = "zzf";
            obj5[i4] = "zzg";
            obj5[i3] = "zzh";
            obj5[i2] = "zzi";
            return xr.f(ia.zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", obj5);
        }
        return Byte.valueOf(obj6);
    }
}
