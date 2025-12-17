package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class n3 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.n3, com.google.android.gms.internal.measurement.m3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.n3 zza;
    private int zze;
    private com.google.android.gms.internal.measurement.x3 zzf;
    private com.google.android.gms.internal.measurement.r3 zzg;
    private boolean zzh;
    private String zzi;
    static {
        n3 n3Var = new n3();
        n3.zza = n3Var;
        w8.o(n3.class, n3Var);
    }

    private n3() {
        super();
        this.zzi = "";
    }

    static void B(com.google.android.gms.internal.measurement.n3 n3, String string2) {
        n3.zze = zze |= 8;
        n3.zzi = string2;
    }

    static com.google.android.gms.internal.measurement.n3 w() {
        return n3.zza;
    }

    public static com.google.android.gms.internal.measurement.n3 x() {
        return n3.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String A() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        return this.zzh;
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
        if (zze &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean F() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
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
                        return n3.zza;
                    }
                    m3 obj5 = new m3(obj6);
                    return obj5;
                }
                obj5 = new n3();
                return obj5;
            }
            obj5 = new Object[obj7];
            obj5[0] = "zze";
            obj5[obj6] = "zzf";
            obj5[i4] = "zzg";
            obj5[i3] = "zzh";
            obj5[i2] = "zzi";
            return w8.n(n3.zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", obj5);
        }
        return Byte.valueOf(obj6);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.r3 y() {
        com.google.android.gms.internal.measurement.r3 zzg;
        if (this.zzg == null) {
            zzg = r3.x();
        }
        return zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.x3 z() {
        com.google.android.gms.internal.measurement.x3 zzf;
        if (this.zzf == null) {
            zzf = x3.y();
        }
        return zzf;
    }
}
