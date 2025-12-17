package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class m5 extends com.google.android.gms.internal.measurement.w8<com.google.android.gms.internal.measurement.m5, com.google.android.gms.internal.measurement.l5> implements com.google.android.gms.internal.measurement.z9 {

    private static final com.google.android.gms.internal.measurement.m5 zza;
    private com.google.android.gms.internal.measurement.c9<com.google.android.gms.internal.measurement.o5> zze;
    static {
        m5 m5Var = new m5();
        m5.zza = m5Var;
        w8.o(m5.class, m5Var);
    }

    private m5() {
        super();
        this.zze = w8.k();
    }

    static com.google.android.gms.internal.measurement.m5 x() {
        return m5.zza;
    }

    public static com.google.android.gms.internal.measurement.m5 y() {
        return m5.zza;
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
                        return m5.zza;
                    }
                    l5 obj2 = new l5(obj4);
                    return obj2;
                }
                obj2 = new m5();
                return obj2;
            }
            obj2 = new Object[obj4];
            obj2[0] = "zze";
            obj2[obj3] = o5.class;
            return w8.n(m5.zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", obj2);
        }
        return Byte.valueOf(obj3);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final int w() {
        return this.zze.size();
    }

    public final List<com.google.android.gms.internal.measurement.o5> z() {
        return this.zze;
    }
}
