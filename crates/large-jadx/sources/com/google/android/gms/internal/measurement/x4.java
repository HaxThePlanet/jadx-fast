package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class x4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.x4, com.google.android.gms.internal.measurement.w4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.x4 zza;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.z4> zze;
    static {
        x4 x4Var = new x4();
        x4.zza = x4Var;
        w8.o(x4.class, x4Var);
    }

    private x4() {
        super();
        this.zze = w8.k();
    }

    static void A(com.google.android.gms.internal.measurement.x4 x4, com.google.android.gms.internal.measurement.z4 z42) {
        com.google.android.gms.internal.measurement.c9 zze;
        z42.getClass();
        zze = x4.zze;
        if (!zze.zzc()) {
            x4.zze = w8.l(zze);
        }
        x4.zze.add(z42);
    }

    public static com.google.android.gms.internal.measurement.w4 w() {
        return (w4)x4.zza.p();
    }

    static com.google.android.gms.internal.measurement.x4 x() {
        return x4.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    protected final Object v(int i, Object object2, Object object3) {
        i--;
        int obj3 = 1;
        int obj4 = 2;
        obj4 = 0;
        if (obj2 != null && obj2 != obj4 && obj2 != 3 && obj2 != 4 && obj2 != 5) {
            obj4 = 2;
            if (obj2 != obj4) {
                if (obj2 != 3) {
                    obj4 = 0;
                    if (obj2 != 4) {
                        if (obj2 != 5) {
                            return obj4;
                        }
                        return x4.zza;
                    }
                    w4 obj2 = new w4(obj4);
                    return obj2;
                }
                obj2 = new x4();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = z4.class;
            return w8.n(x4.zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final com.google.android.gms.internal.measurement.z4 y(int i) {
        return (z4)this.zze.get(0);
    }

    public final List<com.google.android.gms.internal.measurement.z4> z() {
        return this.zze;
    }
}
