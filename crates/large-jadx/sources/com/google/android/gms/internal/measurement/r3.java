package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class r3 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.r3, com.google.android.gms.internal.measurement.o3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.r3 zza;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    static {
        r3 r3Var = new r3();
        r3.zza = r3Var;
        w8.o(r3.class, r3Var);
    }

    private r3() {
        super();
        final String str = "";
        this.zzh = str;
        this.zzi = str;
        this.zzj = str;
    }

    static com.google.android.gms.internal.measurement.r3 w() {
        return r3.zza;
    }

    public static com.google.android.gms.internal.measurement.r3 x() {
        return r3.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String A() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean B() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
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
        if (zze &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean F() {
        if (zze &= 16 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean G() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int H() {
        int i;
        if (q3.a(this.zzf) == 0) {
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
                        return r3.zza;
                    }
                    o3 obj6 = new o3(obj7);
                    return obj6;
                }
                obj6 = new r3();
                return obj6;
            }
            obj6 = new Object[7];
            obj6[obj7] = "zzf";
            obj6[i4] = p3.a;
            obj6[i3] = "zzg";
            obj6[i2] = "zzh";
            obj6[obj8] = "zzi";
            obj6[6] = "zzj";
            return w8.n(r3.zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String y() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String z() {
        return this.zzj;
    }
}
