package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class f5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.f5, com.google.android.gms.internal.measurement.e5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.f5 zza;
    private com.google.android.gms.internal.measurement.b9 zze;
    private com.google.android.gms.internal.measurement.b9 zzf;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.n4> zzg;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.h5> zzh;
    static {
        f5 f5Var = new f5();
        f5.zza = f5Var;
        w8.o(f5.class, f5Var);
    }

    private f5() {
        super();
        this.zze = w8.t();
        this.zzf = w8.t();
        this.zzg = w8.k();
        this.zzh = w8.k();
    }

    public static com.google.android.gms.internal.measurement.e5 B() {
        return (e5)f5.zza.p();
    }

    static com.google.android.gms.internal.measurement.f5 C() {
        return f5.zza;
    }

    public static com.google.android.gms.internal.measurement.f5 D() {
        return f5.zza;
    }

    static void J(com.google.android.gms.internal.measurement.f5 f5, Iterable iterable2) {
        com.google.android.gms.internal.measurement.b9 zze;
        zze = f5.zze;
        if (!zze.zzc()) {
            f5.zze = w8.u(zze);
        }
        k7.h(iterable2, f5.zze);
    }

    static void K(com.google.android.gms.internal.measurement.f5 f5) {
        f5.zze = w8.t();
    }

    static void L(com.google.android.gms.internal.measurement.f5 f5, Iterable iterable2) {
        com.google.android.gms.internal.measurement.b9 zzf;
        zzf = f5.zzf;
        if (!zzf.zzc()) {
            f5.zzf = w8.u(zzf);
        }
        k7.h(iterable2, f5.zzf);
    }

    static void M(com.google.android.gms.internal.measurement.f5 f5) {
        f5.zzf = w8.t();
    }

    static void N(com.google.android.gms.internal.measurement.f5 f5, Iterable iterable2) {
        f5.R();
        k7.h(iterable2, f5.zzg);
    }

    static void O(com.google.android.gms.internal.measurement.f5 f5, int i2) {
        f5.R();
        f5.zzg.remove(i2);
    }

    static void P(com.google.android.gms.internal.measurement.f5 f5, Iterable iterable2) {
        f5.S();
        k7.h(iterable2, f5.zzh);
    }

    static void Q(com.google.android.gms.internal.measurement.f5 f5, int i2) {
        f5.S();
        f5.zzh.remove(i2);
    }

    private final void R() {
        com.google.android.gms.internal.measurement.c9 zzg;
        zzg = this.zzg;
        if (!zzg.zzc()) {
            this.zzg = w8.l(zzg);
        }
    }

    private final void S() {
        com.google.android.gms.internal.measurement.c9 zzh;
        zzh = this.zzh;
        if (!zzh.zzc()) {
            this.zzh = w8.l(zzh);
        }
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.n4 A(int i) {
        return (n4)this.zzg.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.h5 E(int i) {
        return (h5)this.zzh.get(i);
    }

    public final List<com.google.android.gms.internal.measurement.n4> F() {
        return this.zzg;
    }

    public final List<Long> G() {
        return this.zzf;
    }

    public final List<com.google.android.gms.internal.measurement.h5> H() {
        return this.zzh;
    }

    public final List<Long> I() {
        return this.zze;
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
                        return f5.zza;
                    }
                    e5 obj6 = new e5(obj7);
                    return obj6;
                }
                obj6 = new f5();
                return obj6;
            }
            obj6 = new Object[6];
            obj6[obj7] = "zzf";
            obj6[i4] = "zzg";
            obj6[i3] = n4.class;
            obj6[i2] = "zzh";
            obj6[obj8] = h5.class;
            return w8.n(f5.zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", obj6);
        }
        return Byte.valueOf(obj7);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzg.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int x() {
        return this.zzf.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int y() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int z() {
        return this.zze.size();
    }
}
