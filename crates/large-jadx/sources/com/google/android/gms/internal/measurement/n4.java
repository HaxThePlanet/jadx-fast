package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class n4 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.n4, com.google.android.gms.internal.measurement.m4> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.n4 zza;
    private int zze;
    private int zzf;
    private long zzg;
    static {
        n4 n4Var = new n4();
        n4.zza = n4Var;
        w8.o(n4.class, n4Var);
    }

    static void A(com.google.android.gms.internal.measurement.n4 n4, int i2) {
        n4.zze = zze |= 1;
        n4.zzf = i2;
    }

    static void B(com.google.android.gms.internal.measurement.n4 n4, long l2) {
        n4.zze = zze |= 2;
        n4.zzg = l2;
    }

    public static com.google.android.gms.internal.measurement.m4 y() {
        return (m4)n4.zza.p();
    }

    static com.google.android.gms.internal.measurement.n4 z() {
        return n4.zza;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean C() {
        if (zze &= 2 != 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean D() {
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
                        return n4.zza;
                    }
                    m4 obj3 = new m4(obj5);
                    return obj3;
                }
                obj3 = new n4();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = "zzg";
            return w8.n(n4.zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", obj3);
        }
        return Byte.valueOf(obj4);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final long x() {
        return this.zzg;
    }
}
