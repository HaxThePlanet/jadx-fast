package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class b4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.b4, com.google.android.gms.internal.measurement.z3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.b4 zza;
    private int zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    static {
        b4 b4Var = new b4();
        b4.zza = b4Var;
        w8.o(b4.class, b4Var);
    }

    private b4() {
        super();
        this.zzf = "";
    }

    static com.google.android.gms.internal.measurement.b4 x() {
        return b4.zza;
    }

    static void z(com.google.android.gms.internal.measurement.b4 b4, String string2) {
        string2.getClass();
        b4.zze = zze |= 1;
        b4.zzf = string2;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean A() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean B() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        if (zze &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean D() {
        if (zze &= 4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean E() {
        if (zze &= 8 != 0) {
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
                        return b4.zza;
                    }
                    z3 obj5 = new z3(obj6);
                    return obj5;
                }
                obj5 = new b4();
                return obj5;
            }
            obj5 = new Object[obj7];
            obj5[0] = "zze";
            obj5[obj6] = "zzf";
            obj5[i4] = "zzg";
            obj5[i3] = "zzh";
            obj5[i2] = "zzi";
            return w8.n(b4.zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", obj5);
        }
        return Byte.valueOf(obj6);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String y() {
        return this.zzf;
    }
}
