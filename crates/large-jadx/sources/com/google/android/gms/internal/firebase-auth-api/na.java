package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
public final class na extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.na, com.google.android.gms.internal.firebase-auth-api.ka> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.na zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.d<com.google.android.gms.internal.firebase-auth-api.ma> zzf;
    static {
        na naVar = new na();
        na.zzb = naVar;
        xr.h(na.class, naVar);
    }

    private na() {
        super();
        this.zzf = xr.y();
    }

    public static com.google.android.gms.internal.firebase-auth-api.ka B() {
        return (ka)na.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.na D() {
        return na.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.na E(byte[] bArr, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (na)xr.w(na.zzb, bArr, lr2);
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.na na, int i2) {
        na.zze = i2;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.na na, com.google.android.gms.internal.firebase-auth-api.ma ma2) {
        com.google.android.gms.internal.firebase-auth-api.d zzf;
        ma2.getClass();
        zzf = na.zzf;
        if (!zzf.zzc()) {
            na.zzf = xr.d(zzf);
        }
        na.zzf.add(ma2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int A() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.ma C(int i) {
        return (ma)this.zzf.get(i);
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.ma> F() {
        return this.zzf;
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
                        return na.zzb;
                    }
                    ka obj3 = new ka(obj5);
                    return obj3;
                }
                obj3 = new na();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = ma.class;
            return xr.f(na.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzf.size();
    }
}
