package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class ra extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.ra, com.google.android.gms.internal.firebase-auth-api.qa> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.ra zzb;
    private String zze;
    private int zzf;
    private int zzg;
    private int zzh;
    static {
        ra raVar = new ra();
        ra.zzb = raVar;
        xr.h(ra.class, raVar);
    }

    private ra() {
        super();
        this.zze = "";
    }

    public static com.google.android.gms.internal.firebase-auth-api.qa A() {
        return (qa)ra.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.ra B() {
        return ra.zzb;
    }

    static void C(com.google.android.gms.internal.firebase-auth-api.ra ra, String string2) {
        string2.getClass();
        ra.zze = string2;
    }

    static void D(com.google.android.gms.internal.firebase-auth-api.ra ra, com.google.android.gms.internal.firebase-auth-api.hb hb2) {
        ra.zzh = hb2.zza();
    }

    static void E(com.google.android.gms.internal.firebase-auth-api.ra ra, com.google.android.gms.internal.firebase-auth-api.ca ca2) {
        ra.zzf = ca2.zza();
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.ra ra, int i2) {
        ra.zzg = i2;
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
                        return ra.zzb;
                    }
                    qa obj4 = new qa(obj5);
                    return obj4;
                }
                obj4 = new ra();
                return obj4;
            }
            obj4 = new Object[obj6];
            obj4[0] = "zze";
            obj4[obj5] = "zzf";
            obj4[i3] = "zzg";
            obj4[i2] = "zzh";
            return xr.f(ra.zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u000c\u0003\u000b\u0004\u000c", obj4);
        }
        return Byte.valueOf(obj5);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zzg;
    }
}
