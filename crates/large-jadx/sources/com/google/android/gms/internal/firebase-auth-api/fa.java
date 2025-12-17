package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class fa extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.fa, com.google.android.gms.internal.firebase-auth-api.ea> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.fa zzb;
    private String zze;
    private com.google.android.gms.internal.firebase-auth-api.wq zzf;
    private int zzg;
    static {
        fa faVar = new fa();
        fa.zzb = faVar;
        xr.h(fa.class, faVar);
    }

    private fa() {
        super();
        this.zze = "";
        this.zzf = wq.a;
    }

    static com.google.android.gms.internal.firebase-auth-api.fa A() {
        return fa.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.fa B() {
        return fa.zzb;
    }

    static void F(com.google.android.gms.internal.firebase-auth-api.fa fa, String string2) {
        string2.getClass();
        fa.zze = string2;
    }

    static void G(com.google.android.gms.internal.firebase-auth-api.fa fa, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        fa.zzf = wq2;
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.fa fa, com.google.android.gms.internal.firebase-auth-api.hb hb2) {
        fa.zzg = hb2.zza();
    }

    public static com.google.android.gms.internal.firebase-auth-api.ea z() {
        return (ea)fa.zzb.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.hb C() {
        com.google.android.gms.internal.firebase-auth-api.hb zzf;
        if (hb.zzb(this.zzg) == null) {
            zzf = hb.zzf;
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
                        return fa.zzb;
                    }
                    ea obj3 = new ea(obj5);
                    return obj3;
                }
                obj3 = new fa();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return xr.f(fa.zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\u000c", obj3);
        }
        return Byte.valueOf(obj4);
    }
}
