package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class u5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.u5, com.google.android.gms.internal.measurement.r5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.u5 zza;
    private int zze;
    private int zzf;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.u5> zzg;
    private String zzh;
    private String zzi;
    private boolean zzj;
    private double zzk;
    static {
        u5 u5Var = new u5();
        u5.zza = u5Var;
        w8.o(u5.class, u5Var);
    }

    private u5() {
        super();
        this.zzg = w8.k();
        String str = "";
        this.zzh = str;
        this.zzi = str;
    }

    static com.google.android.gms.internal.measurement.u5 x() {
        return u5.zza;
    }

    public final List<com.google.android.gms.internal.measurement.u5> A() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean B() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean D() {
        if (zze &= 16 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean E() {
        if (zze &= 4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int F() {
        int i;
        if (t5.a(this.zzf) == 0) {
            i = 1;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
        i--;
        int obj7 = 1;
        int obj8 = 5;
        final int i2 = 4;
        final int i3 = 3;
        final int i4 = 2;
        obj7 = 0;
        if (obj6 != null && obj6 != i4 && obj6 != i3 && obj6 != i2 && obj6 != obj8) {
            obj8 = 5;
            i2 = 4;
            i3 = 3;
            i4 = 2;
            if (obj6 != i4) {
                if (obj6 != i3) {
                    obj7 = 0;
                    if (obj6 != i2) {
                        if (obj6 != obj8) {
                            return obj7;
                        }
                        return u5.zza;
                    }
                    r5 obj6 = new r5(obj7);
                    return obj6;
                }
                obj6 = new u5();
                return obj6;
            }
            obj6 = new Object[9];
            obj6[obj7] = "zzf";
            obj6[i4] = s5.a;
            obj6[i3] = "zzg";
            obj6[i2] = u5.class;
            obj6[obj8] = "zzh";
            obj6[6] = "zzi";
            obj6[7] = "zzj";
            obj6[8] = "zzk";
            return w8.n(u5.zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final double w() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String y() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String z() {
        return this.zzi;
    }
}
