package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class j3 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.j3, com.google.android.gms.internal.measurement.i3> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.j3 zza;
    private int zze;
    private int zzf;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.t3> zzg;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.l3> zzh;
    private boolean zzi;
    private boolean zzj;
    static {
        j3 j3Var = new j3();
        j3.zza = j3Var;
        w8.o(j3.class, j3Var);
    }

    private j3() {
        super();
        this.zzg = w8.k();
        this.zzh = w8.k();
    }

    static void E(com.google.android.gms.internal.measurement.j3 j3, int i2, com.google.android.gms.internal.measurement.t3 t33) {
        com.google.android.gms.internal.measurement.c9 zzg;
        t33.getClass();
        zzg = j3.zzg;
        if (!zzg.zzc()) {
            j3.zzg = w8.l(zzg);
        }
        j3.zzg.set(i2, t33);
    }

    static void F(com.google.android.gms.internal.measurement.j3 j3, int i2, com.google.android.gms.internal.measurement.l3 l33) {
        com.google.android.gms.internal.measurement.c9 zzh;
        l33.getClass();
        zzh = j3.zzh;
        if (!zzh.zzc()) {
            j3.zzh = w8.l(zzh);
        }
        j3.zzh.set(i2, l33);
    }

    static com.google.android.gms.internal.measurement.j3 z() {
        return j3.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.l3 A(int i) {
        return (l3)this.zzh.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.t3 B(int i) {
        return (t3)this.zzg.get(i);
    }

    public final List<com.google.android.gms.internal.measurement.l3> C() {
        return this.zzh;
    }

    public final List<com.google.android.gms.internal.measurement.t3> D() {
        return this.zzg;
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
                        return j3.zza;
                    }
                    i3 obj6 = new i3(obj7);
                    return obj6;
                }
                obj6 = new j3();
                return obj6;
            }
            obj6 = new Object[8];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = t3.class;
            obj6[i2] = "zzh";
            obj6[obj8] = l3.class;
            obj6[6] = "zzi";
            obj6[7] = "zzj";
            return w8.n(j3.zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int x() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int y() {
        return this.zzg.size();
    }
}
