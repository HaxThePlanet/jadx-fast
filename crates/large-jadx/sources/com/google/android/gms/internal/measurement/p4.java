package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class p4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.p4, com.google.android.gms.internal.measurement.o4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.p4 zza;
    private int zze;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.t4> zzf;
    private String zzg;
    private long zzh;
    private long zzi;
    private int zzj;
    static {
        p4 p4Var = new p4();
        p4.zza = p4Var;
        w8.o(p4.class, p4Var);
    }

    private p4() {
        super();
        this.zzf = w8.k();
        this.zzg = "";
    }

    public static com.google.android.gms.internal.measurement.o4 A() {
        return (o4)p4.zza.p();
    }

    static com.google.android.gms.internal.measurement.p4 B() {
        return p4.zza;
    }

    static void F(com.google.android.gms.internal.measurement.p4 p4, int i2, com.google.android.gms.internal.measurement.t4 t43) {
        t43.getClass();
        p4.Q();
        p4.zzf.set(i2, t43);
    }

    static void G(com.google.android.gms.internal.measurement.p4 p4, com.google.android.gms.internal.measurement.t4 t42) {
        t42.getClass();
        p4.Q();
        p4.zzf.add(t42);
    }

    static void H(com.google.android.gms.internal.measurement.p4 p4, Iterable iterable2) {
        p4.Q();
        k7.h(iterable2, p4.zzf);
    }

    static void I(com.google.android.gms.internal.measurement.p4 p4) {
        p4.zzf = w8.k();
    }

    static void J(com.google.android.gms.internal.measurement.p4 p4, int i2) {
        p4.Q();
        p4.zzf.remove(i2);
    }

    static void K(com.google.android.gms.internal.measurement.p4 p4, String string2) {
        string2.getClass();
        p4.zze = zze |= 1;
        p4.zzg = string2;
    }

    static void L(com.google.android.gms.internal.measurement.p4 p4, long l2) {
        p4.zze = zze |= 2;
        p4.zzh = l2;
    }

    static void M(com.google.android.gms.internal.measurement.p4 p4, long l2) {
        p4.zze = zze |= 4;
        p4.zzi = l2;
    }

    private final void Q() {
        com.google.android.gms.internal.measurement.c9 zzf;
        zzf = this.zzf;
        if (!zzf.zzc()) {
            this.zzf = w8.l(zzf);
        }
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.t4 C(int i) {
        return (t4)this.zzf.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String D() {
        return this.zzg;
    }

    public final List<com.google.android.gms.internal.measurement.t4> E() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean N() {
        if (zze &= 8 != 0) {
            return 1;
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
    public final boolean P() {
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
                        return p4.zza;
                    }
                    o4 obj6 = new o4(obj7);
                    return obj6;
                }
                obj6 = new p4();
                return obj6;
            }
            obj6 = new Object[7];
            obj6[obj7] = "zzf";
            obj6[i4] = t4.class;
            obj6[i3] = "zzg";
            obj6[i2] = "zzh";
            obj6[obj8] = "zzi";
            obj6[6] = "zzj";
            return w8.n(p4.zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int x() {
        return this.zzf.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long y() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long z() {
        return this.zzh;
    }
}
