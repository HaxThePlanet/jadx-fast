package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
final class wa extends com.google.android.gms.internal.measurement.j {

    final com.google.android.gms.internal.measurement.xc c;
    wa(com.google.android.gms.internal.measurement.wb wb, String string2, com.google.android.gms.internal.measurement.xc xc3) {
        this.c = xc3;
        super("getValue");
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        com.google.android.gms.internal.measurement.q obj3;
        b6.h("getValue", 2, list2);
        obj3 = b5.b((q)list2.get(1));
        String obj4 = this.c.zza(b5.b((q)list2.get(0)).zzi());
        if (obj4 != null) {
            obj3 = new u(obj4);
        }
        return obj3;
    }
}
