package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class q5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.q5, com.google.android.gms.internal.measurement.p5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.q5 zza;
    private int zze;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.u5> zzf;
    private com.google.android.gms.internal.measurement.m5 zzg;
    static {
        q5 q5Var = new q5();
        q5.zza = q5Var;
        w8.o(q5.class, q5Var);
    }

    private q5() {
        super();
        this.zzf = w8.k();
    }

    static com.google.android.gms.internal.measurement.q5 x() {
        return q5.zza;
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
                        return q5.zza;
                    }
                    p5 obj4 = new p5(obj5);
                    return obj4;
                }
                obj4 = new q5();
                return obj4;
            }
            obj4 = new Object[obj6];
            obj4[0] = "zze";
            obj4[obj5] = "zzf";
            obj4[i3] = u5.class;
            obj4[i2] = "zzg";
            return w8.n(q5.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", obj4);
        }
        return Byte.valueOf(obj5);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.m5 w() {
        com.google.android.gms.internal.measurement.m5 zzg;
        if (this.zzg == null) {
            zzg = m5.y();
        }
        return zzg;
    }

    public final List<com.google.android.gms.internal.measurement.u5> y() {
        return this.zzf;
    }
}
