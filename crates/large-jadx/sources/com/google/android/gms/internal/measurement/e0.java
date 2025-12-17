package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
public final class e0 extends com.google.android.gms.internal.measurement.x {
    protected e0() {
        super();
        this.a.add(n0.zzb);
        this.a.add(n0.zzV);
        this.a.add(n0.zzY);
    }

    public final com.google.android.gms.internal.measurement.q a(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        com.google.android.gms.internal.measurement.n0 zza = n0.zza;
        int ordinal = b6.e(string).ordinal();
        final int i = 2;
        final int i2 = 0;
        final int i3 = 1;
        if (ordinal != i3 && ordinal != 47) {
            if (ordinal != 47) {
                if (ordinal != 50) {
                } else {
                    b6.h(n0.zzY.name(), i, list3);
                    com.google.android.gms.internal.measurement.q obj6 = b52.b((q)list3.get(i2));
                    if (obj6.d().booleanValue()) {
                        return obj6;
                    }
                    return b52.b((q)list3.get(i3));
                }
                super.b(string);
                throw 0;
            }
            b6.h(n0.zzV.name(), i3, list3);
            g obj7 = new g(Boolean.valueOf(obj6 ^= i3));
            return obj7;
        }
        b6.h(n0.zzb.name(), i, list3);
        obj6 = b52.b((q)list3.get(i2));
        if (!obj6.d().booleanValue()) {
            return obj6;
        }
        return b52.b((q)list3.get(i3));
    }
}
