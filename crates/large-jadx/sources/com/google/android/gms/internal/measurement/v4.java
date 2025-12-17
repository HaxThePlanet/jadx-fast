package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class v4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.v4, com.google.android.gms.internal.measurement.u4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.v4 zza;
    private int zze;
    private String zzf;
    private String zzg;
    private com.google.android.gms.internal.measurement.j4 zzh;
    static {
        v4 v4Var = new v4();
        v4.zza = v4Var;
        w8.o(v4.class, v4Var);
    }

    private v4() {
        super();
        final String str = "";
        this.zzf = str;
        this.zzg = str;
    }

    static com.google.android.gms.internal.measurement.v4 w() {
        return v4.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
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
                        return v4.zza;
                    }
                    u4 obj4 = new u4(obj5);
                    return obj4;
                }
                obj4 = new v4();
                return obj4;
            }
            obj4 = new Object[obj6];
            obj4[0] = "zze";
            obj4[obj5] = "zzf";
            obj4[i3] = "zzg";
            obj4[i2] = "zzh";
            return w8.n(v4.zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", obj4);
        }
        return Byte.valueOf(obj5);
    }
}
