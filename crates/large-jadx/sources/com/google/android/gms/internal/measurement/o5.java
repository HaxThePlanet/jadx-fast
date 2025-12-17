package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class o5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.o5, com.google.android.gms.internal.measurement.n5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.o5 zza;
    private int zze;
    private String zzf;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.u5> zzg;
    static {
        o5 o5Var = new o5();
        o5.zza = o5Var;
        w8.o(o5.class, o5Var);
    }

    private o5() {
        super();
        this.zzf = "";
        this.zzg = w8.k();
    }

    static com.google.android.gms.internal.measurement.o5 w() {
        return o5.zza;
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
                        return o5.zza;
                    }
                    n5 obj4 = new n5(obj5);
                    return obj4;
                }
                obj4 = new o5();
                return obj4;
            }
            obj4 = new Object[obj6];
            obj4[0] = "zze";
            obj4[obj5] = "zzf";
            obj4[i3] = "zzg";
            obj4[i2] = u5.class;
            return w8.n(o5.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", obj4);
        }
        return Byte.valueOf(obj5);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String x() {
        return this.zzf;
    }

    public final List<com.google.android.gms.internal.measurement.u5> y() {
        return this.zzg;
    }
}
