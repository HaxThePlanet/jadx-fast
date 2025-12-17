package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class h5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.h5, com.google.android.gms.internal.measurement.g5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.h5 zza;
    private int zze;
    private int zzf;
    private com.google.android.gms.internal.measurement.b9 zzg;
    static {
        h5 h5Var = new h5();
        h5.zza = h5Var;
        w8.o(h5.class, h5Var);
    }

    private h5() {
        super();
        this.zzg = w8.t();
    }

    static com.google.android.gms.internal.measurement.h5 A() {
        return h5.zza;
    }

    static void C(com.google.android.gms.internal.measurement.h5 h5, int i2) {
        h5.zze = zze |= 1;
        h5.zzf = i2;
    }

    static void D(com.google.android.gms.internal.measurement.h5 h5, Iterable iterable2) {
        com.google.android.gms.internal.measurement.b9 zzg;
        zzg = h5.zzg;
        if (!zzg.zzc()) {
            h5.zzg = w8.u(zzg);
        }
        k7.h(iterable2, h5.zzg);
    }

    public static com.google.android.gms.internal.measurement.g5 z() {
        return (g5)h5.zza.p();
    }

    public final List<Long> B() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean E() {
        final int i3 = 1;
        if (zze &= i3 != 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
        i--;
        int obj4 = 1;
        int obj5 = 3;
        final int i2 = 2;
        obj5 = 0;
        if (obj3 != null && obj3 != i2 && obj3 != obj5 && obj3 != 4 && obj3 != 5) {
            obj5 = 3;
            i2 = 2;
            if (obj3 != i2) {
                if (obj3 != obj5) {
                    obj5 = 0;
                    if (obj3 != 4) {
                        if (obj3 != 5) {
                            return obj5;
                        }
                        return h5.zza;
                    }
                    g5 obj3 = new g5(obj5);
                    return obj3;
                }
                obj3 = new h5();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return w8.n(h5.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzg.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int x() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long y(int i) {
        return this.zzg.e(i);
    }
}
