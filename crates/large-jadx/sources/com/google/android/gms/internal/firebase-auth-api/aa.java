package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class aa extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.aa, com.google.android.gms.internal.firebase-auth-api.x9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.aa zzb;
    private String zze;
    private com.google.android.gms.internal.firebase-auth-api.wq zzf;
    private int zzg;
    static {
        aa aaVar = new aa();
        aa.zzb = aaVar;
        xr.h(aa.class, aaVar);
    }

    private aa() {
        super();
        this.zze = "";
        this.zzf = wq.a;
    }

    static com.google.android.gms.internal.firebase-auth-api.aa B() {
        return aa.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.aa C() {
        return aa.zzb;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.aa aa, String string2) {
        aa.zze = string2;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.aa aa, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        aa.zzf = wq2;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.aa aa, com.google.android.gms.internal.firebase-auth-api.z9 z92) {
        aa.zzg = z92.zza();
    }

    public static com.google.android.gms.internal.firebase-auth-api.x9 z() {
        return (x9)aa.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.z9 A() {
        com.google.android.gms.internal.firebase-auth-api.z9 zzf;
        if (z9.zzb(this.zzg) == null) {
            zzf = z9.zzf;
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq D() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final String E() {
        return this.zze;
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
                        return aa.zzb;
                    }
                    x9 obj3 = new x9(obj5);
                    return obj3;
                }
                obj3 = new aa();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(aa.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\u000c", obj3);
        }
        return Byte.valueOf(obj4);
    }
}
