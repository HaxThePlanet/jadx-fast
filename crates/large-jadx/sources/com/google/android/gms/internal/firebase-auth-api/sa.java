package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
public final class sa extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.sa, com.google.android.gms.internal.firebase-auth-api.pa> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.sa zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.d<com.google.android.gms.internal.firebase-auth-api.ra> zzf;
    static {
        sa saVar = new sa();
        sa.zzb = saVar;
        xr.h(sa.class, saVar);
    }

    private sa() {
        super();
        this.zzf = xr.y();
    }

    static com.google.android.gms.internal.firebase-auth-api.sa B() {
        return sa.zzb;
    }

    static void C(com.google.android.gms.internal.firebase-auth-api.sa sa, int i2) {
        sa.zze = i2;
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.sa sa, com.google.android.gms.internal.firebase-auth-api.ra ra2) {
        com.google.android.gms.internal.firebase-auth-api.d zzf;
        ra2.getClass();
        zzf = sa.zzf;
        if (!zzf.zzc()) {
            sa.zzf = xr.d(zzf);
        }
        sa.zzf.add(ra2);
    }

    public static com.google.android.gms.internal.firebase-auth-api.pa z() {
        return (pa)sa.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.ra A(int i) {
        return (ra)this.zzf.get(0);
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
                        return sa.zzb;
                    }
                    pa obj3 = new pa(obj5);
                    return obj3;
                }
                obj3 = new sa();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = ra.class;
            return xr.f(sa.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", obj3);
        }
        return Byte.valueOf(obj4);
    }
}
