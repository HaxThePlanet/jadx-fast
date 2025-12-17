package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class d4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.d4, com.google.android.gms.internal.measurement.c4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.d4 zza;
    private int zze;
    private long zzf;
    private String zzg;
    private int zzh;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.f4> zzi;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.b4> zzj;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.j3> zzk;
    private String zzl;
    private boolean zzm;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.q5> zzn;
    static {
        d4 d4Var = new d4();
        d4.zza = d4Var;
        w8.o(d4.class, d4Var);
    }

    private d4() {
        super();
        String str = "";
        this.zzg = str;
        this.zzi = w8.k();
        this.zzj = w8.k();
        this.zzk = w8.k();
        this.zzl = str;
        this.zzn = w8.k();
    }

    public static com.google.android.gms.internal.measurement.c4 A() {
        return (c4)d4.zza.p();
    }

    static com.google.android.gms.internal.measurement.d4 B() {
        return d4.zza;
    }

    public static com.google.android.gms.internal.measurement.d4 C() {
        return d4.zza;
    }

    static void H(com.google.android.gms.internal.measurement.d4 d4, int i2, com.google.android.gms.internal.measurement.b4 b43) {
        com.google.android.gms.internal.measurement.c9 zzj;
        b43.getClass();
        zzj = d4.zzj;
        if (!zzj.zzc()) {
            d4.zzj = w8.l(zzj);
        }
        d4.zzj.set(i2, b43);
    }

    static void I(com.google.android.gms.internal.measurement.d4 d4) {
        d4.zzk = w8.k();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String D() {
        return this.zzg;
    }

    public final List<com.google.android.gms.internal.measurement.j3> E() {
        return this.zzk;
    }

    public final List<com.google.android.gms.internal.measurement.q5> F() {
        return this.zzn;
    }

    public final List<com.google.android.gms.internal.measurement.f4> G() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean J() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean K() {
        if (zze &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean L() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
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
                        return d4.zza;
                    }
                    c4 obj6 = new c4(obj7);
                    return obj6;
                }
                obj6 = new d4();
                return obj6;
            }
            obj6 = new Object[14];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = "zzh";
            obj6[i2] = "zzi";
            obj6[obj8] = f4.class;
            obj6[6] = "zzj";
            obj6[7] = b4.class;
            obj6[8] = "zzk";
            obj6[9] = j3.class;
            obj6[10] = "zzl";
            obj6[11] = "zzm";
            obj6[12] = "zzn";
            obj6[13] = q5.class;
            return w8.n(d4.zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\u0008ဇ\u0004\t\u001b", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzn.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int x() {
        return this.zzj.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long y() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.b4 z(int i) {
        return (b4)this.zzj.get(i);
    }
}
