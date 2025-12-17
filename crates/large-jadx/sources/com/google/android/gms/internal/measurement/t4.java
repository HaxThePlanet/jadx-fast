package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class t4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.s4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.t4 zza;
    private int zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private float zzi;
    private double zzj;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.t4> zzk;
    static {
        t4 t4Var = new t4();
        t4.zza = t4Var;
        w8.o(t4.class, t4Var);
    }

    private t4() {
        super();
        String str = "";
        this.zzf = str;
        this.zzg = str;
        this.zzk = w8.k();
    }

    public static com.google.android.gms.internal.measurement.s4 A() {
        return (s4)t4.zza.p();
    }

    static com.google.android.gms.internal.measurement.t4 B() {
        return t4.zza;
    }

    static void F(com.google.android.gms.internal.measurement.t4 t4, String string2) {
        string2.getClass();
        t4.zze = zze |= 1;
        t4.zzf = string2;
    }

    static void G(com.google.android.gms.internal.measurement.t4 t4, String string2) {
        string2.getClass();
        t4.zze = zze |= 2;
        t4.zzg = string2;
    }

    static void H(com.google.android.gms.internal.measurement.t4 t4) {
        t4.zze = zze &= -3;
        t4.zzg = zza.zzg;
    }

    static void I(com.google.android.gms.internal.measurement.t4 t4, long l2) {
        t4.zze = zze |= 4;
        t4.zzh = l2;
    }

    static void J(com.google.android.gms.internal.measurement.t4 t4) {
        t4.zze = zze &= -5;
        t4.zzh = 0;
    }

    static void K(com.google.android.gms.internal.measurement.t4 t4, double d2) {
        t4.zze = zze |= 16;
        t4.zzj = d2;
    }

    static void L(com.google.android.gms.internal.measurement.t4 t4) {
        t4.zze = zze &= -17;
        t4.zzj = 0;
    }

    static void M(com.google.android.gms.internal.measurement.t4 t4, com.google.android.gms.internal.measurement.t4 t42) {
        t42.getClass();
        t4.U();
        t4.zzk.add(t42);
    }

    static void N(com.google.android.gms.internal.measurement.t4 t4, Iterable iterable2) {
        t4.U();
        k7.h(iterable2, t4.zzk);
    }

    static void O(com.google.android.gms.internal.measurement.t4 t4) {
        t4.zzk = w8.k();
    }

    private final void U() {
        com.google.android.gms.internal.measurement.c9 zzk;
        zzk = this.zzk;
        if (!zzk.zzc()) {
            this.zzk = w8.l(zzk);
        }
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String C() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String D() {
        return this.zzg;
    }

    public final List<com.google.android.gms.internal.measurement.t4> E() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean P() {
        if (zze &= 16 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean Q() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean R() {
        if (zze &= 4 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean S() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean T() {
        if (zze &= 2 != 0) {
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
                        return t4.zza;
                    }
                    s4 obj6 = new s4(obj7);
                    return obj6;
                }
                obj6 = new t4();
                return obj6;
            }
            obj6 = new Object[8];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = "zzh";
            obj6[i2] = "zzi";
            obj6[obj8] = "zzj";
            obj6[6] = "zzk";
            obj6[7] = t4.class;
            return w8.n(t4.zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final double w() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final float x() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int y() {
        return this.zzk.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long z() {
        return this.zzh;
    }
}
