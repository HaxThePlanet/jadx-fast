package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class t3 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.t3, com.google.android.gms.internal.measurement.s3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.t3 zza;
    private int zze;
    private int zzf;
    private String zzg;
    private com.google.android.gms.internal.measurement.n3 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    static {
        t3 t3Var = new t3();
        t3.zza = t3Var;
        w8.o(t3.class, t3Var);
    }

    private t3() {
        super();
        this.zzg = "";
    }

    static void B(com.google.android.gms.internal.measurement.t3 t3, String string2) {
        t3.zze = zze |= 2;
        t3.zzg = string2;
    }

    public static com.google.android.gms.internal.measurement.s3 y() {
        return (s3)t3.zza.p();
    }

    static com.google.android.gms.internal.measurement.t3 z() {
        return t3.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String A() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean D() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean E() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean F() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean G() {
        if (zze &= 32 != 0) {
            return 1;
        }
        return 0;
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
                        return t3.zza;
                    }
                    s3 obj6 = new s3(obj7);
                    return obj6;
                }
                obj6 = new t3();
                return obj6;
            }
            obj6 = new Object[7];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = "zzh";
            obj6[i2] = "zzi";
            obj6[obj8] = "zzj";
            obj6[6] = "zzk";
            return w8.n(t3.zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.n3 x() {
        com.google.android.gms.internal.measurement.n3 zzh;
        if (this.zzh == null) {
            zzh = n3.x();
        }
        return zzh;
    }
}
