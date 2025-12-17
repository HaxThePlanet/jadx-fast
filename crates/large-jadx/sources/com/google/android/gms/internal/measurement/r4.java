package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class r4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.r4, com.google.android.gms.internal.measurement.q4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.r4 zza;
    private int zze;
    private String zzf;
    private long zzg;
    static {
        r4 r4Var = new r4();
        r4.zza = r4Var;
        w8.o(r4.class, r4Var);
    }

    private r4() {
        super();
        this.zzf = "";
    }

    static com.google.android.gms.internal.measurement.r4 w() {
        return r4.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
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
                        return r4.zza;
                    }
                    q4 obj3 = new q4(obj5);
                    return obj3;
                }
                obj3 = new r4();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return w8.n(r4.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", obj3);
        }
        return Byte.valueOf(obj4);
    }
}
