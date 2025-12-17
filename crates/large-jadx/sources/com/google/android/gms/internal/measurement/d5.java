package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class d5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.d5, com.google.android.gms.internal.measurement.a5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.d5 zza;
    private int zze;
    private int zzf = 1;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.r4> zzg;
    static {
        d5 d5Var = new d5();
        d5.zza = d5Var;
        w8.o(d5.class, d5Var);
    }

    private d5() {
        super();
        int i = 1;
        this.zzg = w8.k();
    }

    static com.google.android.gms.internal.measurement.d5 w() {
        return d5.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
        i--;
        int obj6 = 1;
        int obj7 = 5;
        final int i2 = 4;
        final int i3 = 3;
        final int i4 = 2;
        obj6 = 0;
        if (obj5 != null && obj5 != i4 && obj5 != i3 && obj5 != i2 && obj5 != obj7) {
            obj7 = 5;
            i2 = 4;
            i3 = 3;
            i4 = 2;
            if (obj5 != i4) {
                if (obj5 != i3) {
                    obj6 = 0;
                    if (obj5 != i2) {
                        if (obj5 != obj7) {
                            return obj6;
                        }
                        return d5.zza;
                    }
                    a5 obj5 = new a5(obj6);
                    return obj5;
                }
                obj5 = new d5();
                return obj5;
            }
            obj5 = new Object[obj7];
            obj5[0] = "zze";
            obj5[obj6] = "zzf";
            obj5[i4] = c5.a;
            obj5[i3] = "zzg";
            obj5[i2] = r4.class;
            return w8.n(d5.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", obj5);
        }
        return Byte.valueOf(obj6);
    }
}
