package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class f4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.f4, com.google.android.gms.internal.measurement.e4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.f4 zza;
    private int zze;
    private String zzf;
    private String zzg;
    static {
        f4 f4Var = new f4();
        f4.zza = f4Var;
        w8.o(f4.class, f4Var);
    }

    private f4() {
        super();
        final String str = "";
        this.zzf = str;
        this.zzg = str;
    }

    static com.google.android.gms.internal.measurement.f4 w() {
        return f4.zza;
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
                        return f4.zza;
                    }
                    e4 obj3 = new e4(obj5);
                    return obj3;
                }
                obj3 = new f4();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return w8.n(f4.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String x() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String y() {
        return this.zzg;
    }
}
