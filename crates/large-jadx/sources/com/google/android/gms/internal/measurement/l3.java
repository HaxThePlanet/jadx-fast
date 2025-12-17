package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class l3 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.l3, com.google.android.gms.internal.measurement.k3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.l3 zza;
    private int zze;
    private int zzf;
    private String zzg;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.n3> zzh;
    private boolean zzi;
    private com.google.android.gms.internal.measurement.r3 zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    static {
        l3 l3Var = new l3();
        l3.zza = l3Var;
        w8.o(l3.class, l3Var);
    }

    private l3() {
        super();
        this.zzg = "";
        this.zzh = w8.k();
    }

    static void E(com.google.android.gms.internal.measurement.l3 l3, String string2) {
        l3.zze = zze |= 2;
        l3.zzg = string2;
    }

    static void F(com.google.android.gms.internal.measurement.l3 l3, int i2, com.google.android.gms.internal.measurement.n3 n33) {
        com.google.android.gms.internal.measurement.c9 zzh;
        n33.getClass();
        zzh = l3.zzh;
        if (!zzh.zzc()) {
            l3.zzh = w8.l(zzh);
        }
        l3.zzh.set(i2, n33);
    }

    public static com.google.android.gms.internal.measurement.k3 y() {
        return (k3)l3.zza.p();
    }

    static com.google.android.gms.internal.measurement.l3 z() {
        return l3.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.n3 A(int i) {
        return (n3)this.zzh.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.r3 B() {
        com.google.android.gms.internal.measurement.r3 zzj;
        if (this.zzj == null) {
            zzj = r3.x();
        }
        return zzj;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final String C() {
        return this.zzg;
    }

    public final List<com.google.android.gms.internal.measurement.n3> D() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean G() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean H() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean I() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean J() {
        if (zze &= 8 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean K() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean L() {
        if (zze &= 64 != 0) {
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
                        return l3.zza;
                    }
                    k3 obj6 = new k3(obj7);
                    return obj6;
                }
                obj6 = new l3();
                return obj6;
            }
            obj6 = new Object[10];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = "zzh";
            obj6[i2] = n3.class;
            obj6[obj8] = "zzi";
            obj6[6] = "zzj";
            obj6[7] = "zzk";
            obj6[8] = "zzl";
            obj6[9] = "zzm";
            return w8.n(l3.zza, "\u0001\u0008\u0000\u0001\u0001\u0008\u0008\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\u0008ဇ\u0006", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int x() {
        return this.zzf;
    }
}
