package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class j5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.i5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.j5 zza;
    private int zze;
    private long zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private float zzj;
    private double zzk;
    static {
        j5 j5Var = new j5();
        j5.zza = j5Var;
        w8.o(j5.class, j5Var);
    }

    private j5() {
        super();
        final String str = "";
        this.zzg = str;
        this.zzh = str;
    }

    static com.google.android.gms.internal.measurement.j5 A() {
        return j5.zza;
    }

    static void D(com.google.android.gms.internal.measurement.j5 j5, long l2) {
        j5.zze = zze |= 1;
        j5.zzf = l2;
    }

    static void E(com.google.android.gms.internal.measurement.j5 j5, String string2) {
        string2.getClass();
        j5.zze = zze |= 2;
        j5.zzg = string2;
    }

    static void F(com.google.android.gms.internal.measurement.j5 j5, String string2) {
        string2.getClass();
        j5.zze = zze |= 4;
        j5.zzh = string2;
    }

    static void G(com.google.android.gms.internal.measurement.j5 j5) {
        j5.zze = zze &= -5;
        j5.zzh = zza.zzh;
    }

    static void H(com.google.android.gms.internal.measurement.j5 j5, long l2) {
        j5.zze = zze |= 8;
        j5.zzi = l2;
    }

    static void I(com.google.android.gms.internal.measurement.j5 j5) {
        j5.zze = zze &= -9;
        j5.zzi = 0;
    }

    static void J(com.google.android.gms.internal.measurement.j5 j5, double d2) {
        j5.zze = zze |= 32;
        j5.zzk = d2;
    }

    static void K(com.google.android.gms.internal.measurement.j5 j5) {
        j5.zze = zze &= -33;
        j5.zzk = 0;
    }

    public static com.google.android.gms.internal.measurement.i5 z() {
        return (i5)j5.zza.p();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String B() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String C() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean L() {
        if (zze &= 32 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean M() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean N() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean O() {
        if (zze &= 4 != 0) {
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
                        return j5.zza;
                    }
                    i5 obj6 = new i5(obj7);
                    return obj6;
                }
                obj6 = new j5();
                return obj6;
            }
            obj6 = new Object[7];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = "zzh";
            obj6[i2] = "zzi";
            obj6[obj8] = "zzj";
            obj6[6] = "zzk";
            return w8.n(j5.zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final double w() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long x() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long y() {
        return this.zzf;
    }
}
