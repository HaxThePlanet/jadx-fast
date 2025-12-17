package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class l4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.l4, com.google.android.gms.internal.measurement.k4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.l4 zza;
    private int zze;
    private int zzf;
    private com.google.android.gms.internal.measurement.f5 zzg;
    private com.google.android.gms.internal.measurement.f5 zzh;
    private boolean zzi;
    static {
        l4 l4Var = new l4();
        l4.zza = l4Var;
        w8.o(l4.class, l4Var);
    }

    static void B(com.google.android.gms.internal.measurement.l4 l4, int i2) {
        l4.zze = zze |= 1;
        l4.zzf = i2;
    }

    static void C(com.google.android.gms.internal.measurement.l4 l4, com.google.android.gms.internal.measurement.f5 f52) {
        f52.getClass();
        l4.zzg = f52;
        l4.zze = obj1 |= 2;
    }

    static void D(com.google.android.gms.internal.measurement.l4 l4, com.google.android.gms.internal.measurement.f5 f52) {
        l4.zzh = f52;
        l4.zze = obj1 |= 4;
    }

    static void E(com.google.android.gms.internal.measurement.l4 l4, boolean z2) {
        l4.zze = zze |= 8;
        l4.zzi = z2;
    }

    public static com.google.android.gms.internal.measurement.k4 x() {
        return (k4)l4.zza.p();
    }

    static com.google.android.gms.internal.measurement.l4 y() {
        return l4.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.f5 A() {
        com.google.android.gms.internal.measurement.f5 zzh;
        if (this.zzh == null) {
            zzh = f5.D();
        }
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean F() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean G() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean H() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean I() {
        if (zze &= 4 != 0) {
            return 1;
        }
        return 0;
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
                        return l4.zza;
                    }
                    k4 obj5 = new k4(obj6);
                    return obj5;
                }
                obj5 = new l4();
                return obj5;
            }
            obj5 = new Object[obj7];
            obj5[0] = "zze";
            obj5[obj6] = "zzf";
            obj5[i4] = "zzg";
            obj5[i3] = "zzh";
            obj5[i2] = "zzi";
            return w8.n(l4.zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", obj5);
        }
        return Byte.valueOf(obj6);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.f5 z() {
        com.google.android.gms.internal.measurement.f5 zzg;
        if (this.zzg == null) {
            zzg = f5.D();
        }
        return zzg;
    }
}
