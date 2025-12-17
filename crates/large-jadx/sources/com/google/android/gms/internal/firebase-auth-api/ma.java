package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class ma extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.ma, com.google.android.gms.internal.firebase-auth-api.la> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.ma zzb;
    private com.google.android.gms.internal.firebase-auth-api.aa zze;
    private int zzf;
    private int zzg;
    private int zzh;
    static {
        ma maVar = new ma();
        ma.zzb = maVar;
        xr.h(ma.class, maVar);
    }

    public static com.google.android.gms.internal.firebase-auth-api.la C() {
        return (la)ma.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.ma D() {
        return ma.zzb;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.ma ma, com.google.android.gms.internal.firebase-auth-api.aa aa2) {
        aa2.getClass();
        ma.zze = aa2;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.ma ma, com.google.android.gms.internal.firebase-auth-api.hb hb2) {
        ma.zzh = hb2.zza();
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.ma ma, com.google.android.gms.internal.firebase-auth-api.ca ca2) {
        ma.zzf = ca2.zza();
    }

    static void I(com.google.android.gms.internal.firebase-auth-api.ma ma, int i2) {
        ma.zzg = i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.aa A() {
        com.google.android.gms.internal.firebase-auth-api.aa zze;
        if (this.zze == null) {
            zze = aa.C();
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.ca B() {
        com.google.android.gms.internal.firebase-auth-api.ca zze;
        if (ca.zzb(this.zzf) == null) {
            zze = ca.zze;
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.hb E() {
        com.google.android.gms.internal.firebase-auth-api.hb zzf;
        if (hb.zzb(this.zzh) == null) {
            zzf = hb.zzf;
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final boolean J() {
        if (this.zze != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj5 = 1;
        int obj6 = 4;
        final int i2 = 3;
        final int i3 = 2;
        obj5 = 0;
        if (obj4 != null && obj4 != i3 && obj4 != i2 && obj4 != obj6 && obj4 != 5) {
            obj6 = 4;
            i2 = 3;
            i3 = 2;
            if (obj4 != i3) {
                if (obj4 != i2) {
                    obj5 = 0;
                    if (obj4 != obj6) {
                        if (obj4 != 5) {
                            return obj5;
                        }
                        return ma.zzb;
                    }
                    la obj4 = new la(obj5);
                    return obj4;
                }
                obj4 = new ma();
                return obj4;
            }
            obj4 = new Object[obj6];
            obj4[0] = "zze";
            obj4[obj5] = "zzf";
            obj4[i3] = "zzg";
            obj4[i2] = "zzh";
            return xr.f(ma.zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\u000c\u0003\u000b\u0004\u000c", obj4);
        }
        return Byte.valueOf(obj5);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzg;
    }
}
